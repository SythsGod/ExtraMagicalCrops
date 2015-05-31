package com.syths.extramagicalcrops;

import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.syths.extramagicalcrops.block.BlockCompressed;
import com.syths.extramagicalcrops.block.ModBlocks;
import com.syths.extramagicalcrops.crops.BlockCropMod;
import com.syths.extramagicalcrops.init.ModTabs;
// import com.syths.extramagicalcrops.item.ItemCollection;
import com.syths.extramagicalcrops.item.ItemDust;
import com.syths.extramagicalcrops.item.ItemEssence;
import com.syths.extramagicalcrops.item.ItemSeed;
import com.syths.extramagicalcrops.item.ItemTab;
import com.syths.extramagicalcrops.item.ModItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ExtraMagicalCrops.MOD_ID, name = ExtraMagicalCrops.MOD_NAME, version = ExtraMagicalCrops.VERSION, dependencies = ExtraMagicalCrops.DEPENDENCIES)

public class ExtraMagicalCrops {
	public static final String MOD_ID = "extramagicalcrops";
	public static final String MOD_NAME = "Extra Magical Crops";
	public static final String VERSION = "0.0.1a";
	public static final String DEPENDENCIES = "required-after:ExtraUtilities;required-after:EnderIO";
	
	public static int secondSeedDropChance = 2;
	
	// Items and Blocks
	public static Item tabItem, dustBedrockium; // Seperate Items
	public static Block compressedBedrockiumBlock;
	
	public static ItemSeed[] itemSeeds;
	public static ItemEssence[] itemEssences;
	
	public static Block[] crops; // Stores all crops
	
	public static String[] identifiers = new String[] { "Bedrockium" , "ElectricalSteel" , "EnergeticAlloy", "VibrantAlloy", "RedstoneAlloy", "ConductiveIron", "PulsatingIron", "DarkSteel", "Soularium" }; // Teh
	public static String[] itemNames = new String[] { "Bedrockium", "ElectricalSteel" , "EnergeticAlloy", "VibrantAlloy", "RedstoneAlloy", "ConductiveIron", "PulsatingIron", "DarkSteel", "Soularium" }; // Colt
	public static int[] levels = new int[] {3, 1, 2, 3, 1, 1, 1, 3, 2}; // Needed essence level
	public static Item[] returnItems;
	public static ItemStack[] seedCraftingItems;
	// public static String[] oreDict = new String[] { "bedrockiumIngot", "electricalSteelIngot";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModTabs.load();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	itemSeeds = new ItemSeed[identifiers.length];
	itemEssences = new ItemEssence[identifiers.length];
	crops = new Block[identifiers.length];
	
	// Create Seeds
	for(int i = 0; i <= identifiers.length - 1; i++){
		itemSeeds[i] = new ItemSeed(identifiers[i], "seed", i);
		if(itemSeeds[i] != null) RegisterBot.registerItem(itemSeeds[i]);
	}
	
	// Create Essences
	for(int i = 0; i <= identifiers.length - 1; i++){
		itemEssences[i] = new ItemEssence(identifiers[i], levels[i]);
		if(itemEssences != null) RegisterBot.registerItem(itemEssences[i]);
	}
	
	// Register Crops (blocks)
	for(int i = 0; i <= identifiers.length - 1; i++){		
		crops[i] = new BlockCropMod(identifiers[i], itemSeeds[i], itemEssences[i]);
		if(crops[i] != null) RegisterBot.registerBlock(crops[i]);
	}
	
	dustBedrockium = new ItemDust("Bedrockium");
	GameRegistry.registerItem(dustBedrockium, "dustBedrockium");
	compressedBedrockiumBlock = new BlockCompressed(Material.rock, "BedrockiumDust");
	GameRegistry.registerBlock(compressedBedrockiumBlock, "mCompressedBedrockiumDust");
	
	tabItem = new ItemTab();
	GameRegistry.registerItem(tabItem, "tabItem");;
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		if(Loader.isModLoaded("ExtraUtilities")){
			ModItems.fetchItems();
			ModBlocks.fetchBlocks();
			
			returnItems = new Item[] { dustBedrockium, ModItems.ingotsEnderIO[0].getItem(), ModItems.ingotsEnderIO[1].getItem(), ModItems.ingotsEnderIO[2].getItem(), ModItems.ingotsEnderIO[3].getItem(), ModItems.ingotsEnderIO[4].getItem(), ModItems.ingotsEnderIO[5].getItem() };
			seedCraftingItems = new ItemStack[] { new ItemStack(ModBlocks.blockBedrockium, 1), new ItemStack(ModBlocks.blocksEnderIO[0]), new ItemStack(ModBlocks.blocksEnderIO[1]), new ItemStack(ModBlocks.blocksEnderIO[2]), new ItemStack(ModBlocks.blocksEnderIO[3]), new ItemStack(ModBlocks.blocksEnderIO[4]), new ItemStack(ModBlocks.blocksEnderIO[5]) };
			
			Recipes.registerRecipes();
		}
	}
}
