package dev.werllon.shearupgraded.util;

import dev.werllon.shearupgraded.ShearUpgradedMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> VEIN_MINEABLE_WITH_SHEARS =
            TagKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(ShearUpgradedMod.MOD_ID, "vein_mineable_with_shears")
            );

    private ModBlockTags() {
    }
}
