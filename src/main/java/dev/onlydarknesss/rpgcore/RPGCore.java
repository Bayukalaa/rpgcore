package dev.onlydarknesss.rpgcore;

import com.mojang.logging.LogUtils;
import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.items.ModCreativeTabs;
import dev.onlydarknesss.rpgcore.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RPGCore.MOD_ID)
public class RPGCore
{
    public static final String MOD_ID = "rpgcore";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RPGCore(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
       // modEventBus.addListener(this::addCreative);

        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event)
//    {
//        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(ModItems.Demonoid);
//            event.accept(ModItems.Raw_Demonoid);
//        }
//
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
//            event.accept(ModBlocks.DEMONOID_ORE);
//            event.accept(ModBlocks.RAW_DEMONOID_BLOCK);
//        }
//    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
