package dev.onlydarknesss.rpgcore.items.customTags;

import dev.onlydarknesss.rpgcore.RPGCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CustomTag {
    public static class Blocks {
        public static final TagKey<Block> MetalDetector = tag("metal_detector_valueables");
        public static final TagKey<Block> NEEDS_DEMONOID_TOOL = tag("needs_demonoid_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RPGCore.MOD_ID, name));
        }
    }

    public static class Items{
        private static TagKey<Item> tag(String n){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RPGCore.MOD_ID, n));
        }
    }
}
