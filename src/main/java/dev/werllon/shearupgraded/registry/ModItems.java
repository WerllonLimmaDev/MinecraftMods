package dev.werllon.shearupgraded.registry;

import dev.werllon.shearupgraded.ShearUpgradedMod;
import dev.werllon.shearupgraded.item.DiamondShearsItem;
import dev.werllon.shearupgraded.item.EmeraldShearsItem;
import dev.werllon.shearupgraded.item.GoldenShearsItem;
import dev.werllon.shearupgraded.item.IronShearsItem;
import dev.werllon.shearupgraded.item.NetheriteShearsItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ShearUpgradedMod.MOD_ID);

    public static final RegistryObject<Item> IRON_SHEARS = ITEMS.register("iron_shears", IronShearsItem::new);
    public static final RegistryObject<Item> GOLDEN_SHEARS = ITEMS.register("golden_shears", GoldenShearsItem::new);
    public static final RegistryObject<Item> EMERALD_SHEARS = ITEMS.register("emerald_shears", EmeraldShearsItem::new);
    public static final RegistryObject<Item> DIAMOND_SHEARS = ITEMS.register("diamond_shears", DiamondShearsItem::new);
    public static final RegistryObject<Item> NETHERITE_SHEARS = ITEMS.register("netherite_shears", NetheriteShearsItem::new);

    private ModItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
