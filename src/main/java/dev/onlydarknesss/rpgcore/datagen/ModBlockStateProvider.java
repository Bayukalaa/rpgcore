package dev.onlydarknesss.rpgcore.datagen;

import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.RPGCore;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
        public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper){
            super(output, RPGCore.MOD_ID, existingFileHelper);
        }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_DEMONOID_BLOCK);
        blockWithItem(ModBlocks.DEMONOID_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_DEMONOID_ORE);
        blockWithItem(ModBlocks.ENDLESS_DEMONOID_ORE);
        blockWithItem(ModBlocks.HELL_DEMONOID_ORE);

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
            simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
