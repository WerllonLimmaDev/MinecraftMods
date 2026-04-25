package dev.werllon.shearupgraded.util;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.IForgeShearable;

public final class EntityVeinMiningHelper {
    private static final double SEARCH_RADIUS = 12.0D;
    private static final double CHAIN_DISTANCE = 4.5D;

    private EntityVeinMiningHelper() {
    }

    @SuppressWarnings("deprecation")
    public static boolean canVeinMineEntity(LivingEntity entity, ItemStack stack) {
        if (!(entity instanceof IForgeShearable shearable)) {
            return false;
        }
        return entity.isAlive() && shearable.isShearable(stack, entity.level(), BlockPos.containing(entity.position()));
    }

    public static int shearConnectedEntities(
            ServerPlayer player,
            InteractionHand hand,
            ItemStack stack,
            LivingEntity origin,
            int veinLimit
    ) {
        if (veinLimit <= 0 || !canVeinMineEntity(origin, stack)) {
            return 0;
        }

        Level level = origin.level();
        List<LivingEntity> nearby = level.getEntitiesOfClass(
                        LivingEntity.class,
                        origin.getBoundingBox().inflate(SEARCH_RADIUS),
                        entity -> entity != null && isCompatibleTarget(origin, entity, stack)
                )
                .stream()
                .sorted(Comparator.comparingDouble(origin::distanceToSqr))
                .toList();

        ArrayDeque<LivingEntity> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(origin);
        visited.add(origin.getId());

        int shearedCount = 0;

        while (!queue.isEmpty() && shearedCount < veinLimit && !stack.isEmpty()) {
            LivingEntity current = queue.poll();
            if (!canVeinMineEntity(current, stack)) {
                continue;
            }

            shearEntity(player, hand, stack, current);
            shearedCount++;

            for (LivingEntity candidate : nearby) {
                if (!visited.add(candidate.getId())) {
                    continue;
                }
                if (current.distanceToSqr(candidate) <= CHAIN_DISTANCE * CHAIN_DISTANCE) {
                    queue.add(candidate);
                }
            }
        }

        return shearedCount;
    }

    private static boolean isCompatibleTarget(LivingEntity origin, LivingEntity candidate, ItemStack stack) {
        if (candidate == origin || origin.getType() != candidate.getType()) {
            return false;
        }
        if (!canVeinMineEntity(candidate, stack)) {
            return false;
        }

        if (origin instanceof Sheep originSheep && candidate instanceof Sheep candidateSheep) {
            return originSheep.getColor() == candidateSheep.getColor();
        }
        if (origin instanceof MushroomCow originCow && candidate instanceof MushroomCow candidateCow) {
            return originCow.getVariant() == candidateCow.getVariant();
        }

        return true;
    }

    @SuppressWarnings("deprecation")
    private static void shearEntity(ServerPlayer player, InteractionHand hand, ItemStack stack, LivingEntity entity) {
        if (!(entity instanceof IForgeShearable shearable)) {
            return;
        }

        BlockPos pos = BlockPos.containing(entity.position());
        int fortune = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(
                net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE,
                stack
        );

        List<ItemStack> drops = shearable.onSheared(player, stack, entity.level(), pos, fortune);
        drops.forEach(drop -> spawnShearedDrop(entity, drop));

        stack.hurtAndBreak(1, player, breaker -> breaker.broadcastBreakEvent(hand));
        if (stack.isEmpty()) {
            player.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        }
    }

    private static void spawnShearedDrop(LivingEntity entity, ItemStack drop) {
        ItemEntity itemEntity = entity.spawnAtLocation(drop, 1.0F);
        if (itemEntity == null) {
            return;
        }

        itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add(
                (entity.getRandom().nextFloat() - entity.getRandom().nextFloat()) * 0.1F,
                entity.getRandom().nextFloat() * 0.05F,
                (entity.getRandom().nextFloat() - entity.getRandom().nextFloat()) * 0.1F
        ));
    }
}
