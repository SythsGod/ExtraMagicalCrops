package com.syths.extramagicalcrops.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlocks {
	
	public static Block blockBedrockium;
	public static Block blockElectricalSteel;
	public static Block blockEnergeticAlloy;
	public static Block blockVibrantAlloy;
	public static Block blockRedstoneAlloy;
	public static Block blockConductiveIron;
	public static Block blockPulsatingIron;
	public static Block blockDarkSteel;
	public static Block blockSoularium;
	
	public static void fetchBlocks(){		
		blockBedrockium = fetchBlock("ExtraUtilities", "block_bedrockium");
		blockElectricalSteel = fetchBlock("EnderIO", "blockIngotStorage", 0);
		blockEnergeticAlloy = fetchBlock("EnderIO", "blockIngotStorage", 1);
		blockVibrantAlloy = fetchBlock("EnderIO", "blockIngotStorage", 2);
		blockRedstoneAlloy = fetchBlock("EnderIO", "blockIngotStorage", 3);
		blockConductiveIron = fetchBlock("EnderIO", "blockIngotStorage", 4);
		blockPulsatingIron = fetchBlock("EnderIO", "blockIngotStorage", 5);
		blockDarkSteel = fetchBlock("EnderIO", "blockIngotStorage", 6);
		blockSoularium = fetchBlock("EnderIO", "blockIngotStorage", 7);
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
