package dev.werllon.shearupgraded;

import com.mojang.logging.LogUtils;
import dev.werllon.shearupgraded.registry.ModItems;
import org.slf4j.Logger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.item.CreativeModeTabs;

@Mod(ShearUpgradedMod.MOD_ID)
public final class ShearUpgradedMod {
    public static final String MOD_ID = "shearupgraded";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ShearUpgradedMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModItems.register(modEventBus);
        modEventBus.addListener(this::addCreativeTabItems);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreativeTabItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != CreativeModeTabs.TOOLS_AND_UTILITIES) {
            return;
        }

        event.accept(ModItems.IRON_SHEARS);
        event.accept(ModItems.GOLDEN_SHEARS);
        event.accept(ModItems.EMERALD_SHEARS);
        event.accept(ModItems.DIAMOND_SHEARS);
        event.accept(ModItems.NETHERITE_SHEARS);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.debug("Server starting with Shear Upgraded loaded");
    }
}
