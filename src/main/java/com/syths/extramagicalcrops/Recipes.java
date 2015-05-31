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
		// Seeds:
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedBedrockium, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockBedrockium, 'Y', ModItems.essenceExtreme, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedElectricalSteel, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockElectricalSteel, 'Y', ModItems.essenceRegular, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedEnergeticAlloy, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockEnergeticAlloy, 'Y', ModItems.essenceStrong, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedVibrantAlloy, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockVibrantAlloy, 'Y', ModItems.essenceExtreme, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedRedstoneAlloy, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockRedstoneAlloy, 'Y', ModItems.essenceRegular, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedConductiveIron, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockConductiveIron, 'Y', ModItems.essenceRegular, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedDarkSteel, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockDarkSteel, 'Y', ModItems.essenceExtreme, 'Z', Items.wheat_seeds);
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.seedSoularium, 1), "XYX", "YZY", "XYX", 'X', ModBlocks.blockSoularium, 'Y', ModItems.essenceStrong, 'Z', Items.wheat_seeds);
		
		// Essences to final item:
		GameRegistry.addRecipe(ModItems.ingotBedrockium, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceBedrockium);
		GameRegistry.addRecipe(ModItems.ingotElectricalSteel, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceElectricalSteel);
		GameRegistry.addRecipe(ModItems.ingotEnergeticAlloy, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceEnergeticAlloy);
		GameRegistry.addRecipe(ModItems.ingotVibrantAlloy, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceVibrantAlloy);
		GameRegistry.addRecipe(ModItems.ingotRedstoneAlloy, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceRedstoneAlloy);
		GameRegistry.addRecipe(ModItems.ingotConductiveIron, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceConductiveIron);
		GameRegistry.addRecipe(ModItems.ingotPulsatingIron, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essencePulsatingIron);
		GameRegistry.addRecipe(ModItems.ingotDarkSteel, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceDarkSteel);
		GameRegistry.addRecipe(ModItems.ingotSoularium, "XXX", "X X", "XXX", 'X', ExtraMagicalCrops.essenceSoularium);
		
		// Separate Items:
		GameRegistry.addRecipe(new ItemStack(ExtraMagicalCrops.compressedBedrockiumDustBlock, 1), "XXX", "XXX", "XXX", 'X', ExtraMagicalCrops.dustBedrockium);
		GameRegistry.addSmelting(ExtraMagicalCrops.compressedBedrockiumDustBlock, ModItems.ingotBedrockium, 0.0f);
	}
}