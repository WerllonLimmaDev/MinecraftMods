package dev.werllon.shearupgraded.item;

import dev.werllon.shearupgraded.util.VeinMiningHelper;
import java.util.List;
import java.util.Set;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BaseVeinShearsItem extends ShearsItem {
    private static final String VEIN_MINING_TAG = "shearupgraded_vein_mining";

    private final int veinLimit;

    public BaseVeinShearsItem(int durability, int veinLimit) {
        super(new Item.Properties().durability(durability));
        this.veinLimit = veinLimit;
    }

    public int getVeinLimit() {
        return veinLimit;
    }

    protected boolean isVeinMiningActive(Player player) {
        return player.isShiftKeyDown();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.shearupgraded.vein_mining_range", veinLimit)
                .withStyle(ChatFormatting.AQUA));

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.shearupgraded.vein_mining_activation")
                    .withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("tooltip.shearupgraded.hold_shift")
                    .withStyle(ChatFormatting.DARK_GRAY));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean result = super.mineBlock(stack, level, state, pos, entity);

        if (level.isClientSide || !(entity instanceof ServerPlayer player)) {
            return result;
        }
        if (!isVeinMiningActive(player)) {
            return result;
        }
        if (stack.getOrCreateTag().getBoolean(VEIN_MINING_TAG) || !VeinMiningHelper.canVeinMine(state)) {
            return result;
        }

        Set<BlockPos> targets = VeinMiningHelper.findConnectedBlocks(level, pos, state, Math.max(veinLimit - 1, 0));
        stack.getOrCreateTag().putBoolean(VEIN_MINING_TAG, true);
        try {
            for (BlockPos target : targets) {
                player.gameMode.destroyBlock(target);
            }
        } finally {
            stack.getOrCreateTag().remove(VEIN_MINING_TAG);
        }

        return result;
    }
}
