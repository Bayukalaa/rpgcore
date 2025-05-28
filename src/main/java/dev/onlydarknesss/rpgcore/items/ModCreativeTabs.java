package dev.onlydarknesss.rpgcore.items;

import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.RPGCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPGCore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RPGCoreItems = CREATIVE_MODE_TAB.register("rpgcore_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Demonoid.get()))
                    .title(Component.translatable("creativetab.rpgcore.rpgcore_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Demonoid.get());
                        output.accept(ModItems.Raw_Demonoid.get());


                        output.accept(ModBlocks.DEMONOID_ORE.get());
                        output.accept(ModBlocks.RAW_DEMONOID_BLOCK.get());
                        output.accept(ModBlocks.DEEPSLATE_DEMONOID_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
