package com.syths.extramagicalcrops.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlocks {
	
	public static Block blockBedrockium;
	public static Block[] blocksEnderIO;
	
	public static void fetchBlocks(){
		blocksEnderIO = new Block[8];
		
		blockBedrockium = fetchBlock("ExtraUtilities", "block_bedrockium");
		for(int i = 0; i < 6; i++){
			blocksEnderIO[i] = fetchBlock("EnderIO", "blockIngotStorage", i);
		}
	}
	
	public static Block fetchBlock(String modId, String block){		
		return GameRegistry.findBlock(modId, block);
	}
	
	public static Block fetchBlock(String modId, String block, int dmg){
		ItemStack stack = GameRegistry.findItemStack(modId, block, 1);
		if(stack != null) stack.setItemDamage(dmg);
		return Block.getBlockFromItem(stack.getItem());
	}
}
