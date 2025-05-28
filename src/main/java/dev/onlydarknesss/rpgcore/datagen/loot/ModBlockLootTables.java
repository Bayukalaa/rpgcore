package dev.onlydarknesss.rpgcore.datagen.loot;

import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.DEMONOID_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEMONOID_ORE.get(), ModItems.Raw_Demonoid.get()));

        this.add(ModBlocks.ENDLESS_DEMONOID_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ENDLESS_DEMONOID_ORE.get(), ModItems.Raw_Demonoid.get()));

        this.add(ModBlocks.DEEPSLATE_DEMONOID_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_DEMONOID_ORE.get(), ModItems.Raw_Demonoid.get()));

        this.add(ModBlocks.HELL_DEMONOID_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.HELL_DEMONOID_ORE.get(), ModItems.Raw_Demonoid.get()));

        this.dropSelf(ModBlocks.RAW_DEMONOID_BLOCK.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block block, Item item){
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
