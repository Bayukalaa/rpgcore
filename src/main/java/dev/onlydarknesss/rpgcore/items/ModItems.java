package dev.onlydarknesss.rpgcore.items;

import dev.onlydarknesss.rpgcore.RPGCore;
import dev.onlydarknesss.rpgcore.items.custom.DetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RPGCore.MOD_ID);

    public static final RegistryObject<Item> Demonoid = ITEMS.register("demonoid", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> Raw_Demonoid = ITEMS.register("raw_demonoid", () ->
        new Item(new Item.Properties()));

    public static final RegistryObject<Item> DetectorItem = ITEMS.register("metals_detector", ()->
            new DetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
