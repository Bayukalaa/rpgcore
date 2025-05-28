package dev.onlydarknesss.rpgcore.datagen;

import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.RPGCore;
import dev.onlydarknesss.rpgcore.items.customTags.CustomTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RPGCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(CustomTag.Blocks.MetalDetector)
                .add(ModBlocks.DEMONOID_ORE.get(), ModBlocks.DEEPSLATE_DEMONOID_ORE.get(), ModBlocks.ENDLESS_DEMONOID_ORE.get(), ModBlocks.HELL_DEMONOID_ORE.get()
                ).addTags(Tags.Blocks.ORES);


    }
}
