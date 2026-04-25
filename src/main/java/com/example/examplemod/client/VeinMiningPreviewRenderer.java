package com.example.examplemod.client;

import com.example.examplemod.item.BaseVeinShearsItem;
import com.example.examplemod.util.VeinMiningHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = "shearupgraded", value = Dist.CLIENT)
public class VeinMiningPreviewRenderer {

    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        if (player == null || minecraft.level == null) {
            return;
        }

        ItemStack heldItem = player.getMainHandItem();
        if (!(heldItem.getItem() instanceof BaseVeinShearsItem shearsItem)) {
            return;
        }

        if (!player.isShiftKeyDown()) {
            return;
        }

        HitResult hitResult = minecraft.hitResult;
        if (!(hitResult instanceof BlockHitResult blockHitResult)) {
            return;
        }

        BlockPos origin = blockHitResult.getBlockPos();
        BlockState originState = minecraft.level.getBlockState(origin);

        if (!VeinMiningHelper.canVeinMine(originState)) {
            return;
        }

        Set<BlockPos> targets = VeinMiningHelper.findConnectedBlocks(
                minecraft.level,
                origin,
                originState,
                shearsItem.getVeinLimit()
        );

        if (targets.isEmpty()) {
            return;
        }

        PoseStack poseStack = event.getPoseStack();
        var camera = event.getCamera();
        double camX = camera.getPosition().x;
        double camY = camera.getPosition().y;
        double camZ = camera.getPosition().z;

        poseStack.pushPose();
        poseStack.translate(-camX, -camY, -camZ);

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();

        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();

        for (BlockPos pos : targets) {
            LevelRenderer.renderLineBox(
                    poseStack,
                    bufferSource.getBuffer(RenderType.lines()),
                    pos.getX(),
                    pos.getY(),
                    pos.getZ(),
                    pos.getX() + 1,
                    pos.getY() + 1,
                    pos.getZ() + 1,
                    1.0F, 1.0F, 1.0F, 1.0F
            );
        }

        bufferSource.endBatch(RenderType.lines());

        RenderSystem.enableCull();
        RenderSystem.disableBlend();

        poseStack.popPose();
    }
}