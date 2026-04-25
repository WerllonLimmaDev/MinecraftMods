package dev.werllon.shearupgraded.util;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public final class VeinMiningHelper {
    private VeinMiningHelper() {
    }

    public static Set<BlockPos> findConnectedBlocks(Level level, BlockPos origin, BlockState originState, int veinLimit) {
        Set<BlockPos> result = new LinkedHashSet<>();
        if (veinLimit <= 0 || !canVeinMine(originState)) {
            return result;
        }

        ArrayDeque<BlockPos> queue = new ArrayDeque<>();
        Set<BlockPos> visited = new HashSet<>();
        queue.add(origin);
        visited.add(origin);

        while (!queue.isEmpty() && result.size() < veinLimit) {
            BlockPos current = queue.poll();
            if (!current.equals(origin)) {
                result.add(current);
                if (result.size() >= veinLimit) {
                    break;
                }
            }

            for (BlockPos next : BlockPos.betweenClosed(current.offset(-1, -1, -1), current.offset(1, 1, 1))) {
                BlockPos candidate = next.immutable();
                if (candidate.equals(current) || !visited.add(candidate)) {
                    continue;
                }

                BlockState candidateState = level.getBlockState(candidate);
                if (isSameVein(originState, candidateState)) {
                    queue.add(candidate);
                }
            }
        }

        return result;
    }

    public static boolean isSameVein(BlockState originState, BlockState candidateState) {
        return originState.getBlock() == candidateState.getBlock() && canVeinMine(candidateState);
    }

    public static boolean canVeinMine(BlockState state) {
        return state.is(ModBlockTags.VEIN_MINEABLE_WITH_SHEARS);
    }
}
