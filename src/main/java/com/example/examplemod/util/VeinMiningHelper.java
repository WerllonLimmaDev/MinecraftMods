package com.example.examplemod.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class VeinMiningHelper {

    public static Set<BlockPos> findConnectedBlocks(Level level, BlockPos origin, BlockState originState, int veinLimit) {
        Set<BlockPos> result = new LinkedHashSet<>();

        if (!canVeinMine(originState)) {
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

                if (candidate.equals(current)) continue;
                if (!visited.add(candidate)) continue;

                BlockState candidateState = level.getBlockState(candidate);
                if (!isSameVein(originState, candidateState)) continue;

                queue.add(candidate);
            }
        }

        return result;
    }

    public static boolean isSameVein(BlockState originState, BlockState candidateState) {
        return originState.getBlock() == candidateState.getBlock() && canVeinMine(candidateState);
    }

    public static boolean canVeinMine(BlockState state) {
        return state.is(BlockTags.LEAVES)
                || state.is(BlockTags.WOOL)
                || state.is(Blocks.COBWEB)
                || state.is(Blocks.VINE)
                || state.is(Blocks.GLOW_LICHEN)
                || state.is(Blocks.GRASS)
                || state.is(Blocks.TALL_GRASS)
                || state.is(Blocks.FERN)
                || state.is(Blocks.LARGE_FERN)
                || state.is(Blocks.DEAD_BUSH)
                || state.is(Blocks.HANGING_ROOTS)
                || state.is(Blocks.TRIPWIRE);
    }
}