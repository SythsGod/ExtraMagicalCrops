package com.syths.extramagicalcrops.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
	public static Block blockBedrockium;
	
	public static void fetchBlocks(){
		blockBedrockium = fetchBlock("ExtraUtilities", "block_bedrockium");
	}
	
	public static Block fetchBlock(String modId, String block){		
		return GameRegistry.findBlock(modId, block);
	}
}
