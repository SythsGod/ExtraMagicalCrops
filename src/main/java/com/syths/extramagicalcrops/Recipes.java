package com.syths.extramagicalcrops;

import com.syths.extramagicalcrops.block.ModBlocks;
import com.syths.extramagicalcrops.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {	
	public static void registerRecipes(){
		// GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedBedrockium, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockBedrockium, 'Y', ModItems.essenceExtreme, 'Z', Items.wheat_seeds);
		// GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.dustBedrockium, 1), "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceBedrockium);
		// GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.compressedBedrockiumDust, 1), "XXX", "XXX", "XXX", 'X', ExtraMagicalCrops.dustBedrockium);
		// GameRegistry.addSmelting(ExtraMagicalCrops.compressedBedrockiumDust, ModItems.itemBedrockiumIngot, 0.0F);
		
		for(int i = 0; i < ExtraMagicalCrops.returnItems.length; i++){ // Register all crafting recipes that are essence or seed related
			// Recipes for seeds
			GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.itemSeeds[i], 1), "XYX", "YZY", "XYX", 'X', ExtraMagicalCrops.seedCraftingItems[i], 'Y', ModItems.origEssences[ExtraMagicalCrops.itemEssences[i].getLevel() + 1], 'Z', Items.wheat_seeds);
			// Recipes for essences
			GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.returnItems[i], 1), "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.itemEssences[i]);
		}
		
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.itemSeeds[0], 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockBedrockium, 'Y', ModItems.origEssences[3], 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.itemSeeds[1], 1), "XYX", "YZY", "XYX", 'X', ModItems.ingotsEnderIO[0], 'Y', ModItems.origEssences[2], 'Z', Items.wheat_seeds);
		
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.compressedBedrockiumBlock, 1), "XXX", "XXX", "XXX", 'X', ExtraMagicalCrops.dustBedrockium);
		GameRegistry.addSmelting(ExtraMagicalCrops.compressedBedrockiumBlock, ModItems.ingotBedrockium, 0.0f);
	}
}