package dev.onlydarknesss.rpgcore.Block;

import dev.onlydarknesss.rpgcore.RPGCore;
import dev.onlydarknesss.rpgcore.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RPGCore.MOD_ID);

    public static final RegistryObject<Block> DEMONOID_ORE = registerBlock("demonoid_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
            .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(2, 4)));

    public static final RegistryObject<Block> DEEPSLATE_DEMONOID_ORE = registerBlock("deepslate_demonoid_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
            .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(2, 4)));

    public static final RegistryObject<Block> ENDLESS_DEMONOID_ORE = registerBlock("endless_demonoid_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
            .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> HELL_DEMONOID_ORE = registerBlock("hell_demonoid_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)
            .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 4)));

    public static final RegistryObject<Block> RAW_DEMONOID_BLOCK = registerBlock("raw_demonoid_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
            .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(1, 1)));


    private static <T extends Block> void  registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
