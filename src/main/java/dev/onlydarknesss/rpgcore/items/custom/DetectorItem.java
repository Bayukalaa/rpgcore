package dev.onlydarknesss.rpgcore.items.custom;

import dev.onlydarknesss.rpgcore.Block.ModBlocks;
import dev.onlydarknesss.rpgcore.items.customTags.CustomTag;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DetectorItem extends Item {
    public DetectorItem(Properties p){
        super(p);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()){
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean fBlock = false;

            for (int i = 0; i <= posClicked.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(posClicked.below(i));
                if(isValueableBlock(state)){
                    outputCordinates(posClicked.below(i), player, state.getBlock());
                    fBlock = true;
                    break;
                }
            }

            if (!fBlock){
                player.sendSystemMessage(Component.literal("Block not found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void outputCordinates(BlockPos bellow, Player p, Block block){
        p.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " + "( " + bellow.getX() + ", " + bellow.getY() + ", " + bellow.getZ() + " )"));
    }


    private boolean isValueableBlock(BlockState state){
        return state.is(CustomTag.Blocks.MetalDetector);
    }
}
