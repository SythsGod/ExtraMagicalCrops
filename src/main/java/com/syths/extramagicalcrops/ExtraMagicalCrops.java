package com.syths.extramagicalcrops;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.syths.extramagicalcrops.block.BlockCompressed;
import com.syths.extramagicalcrops.block.ModBlocks;
import com.syths.extramagicalcrops.crops.BlockCropBedrockium;
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
	
	public static String[] identifiers = new String[] { "Bedrockium"}; // Teh
	public static String[] itemNames = new String[] {"Bedrockium"}; // Colt
	// public static String[] oreDict = new String[] { "bedrockiumIngot", "electricalSteelIngot";
	
	public static Block[] crops; // Crops & Blocks
	public static Item[] items; // Items
	
	public static ItemSeed[] itemSeeds;
	public static ItemEssence[] itemEssences;
	
	public static Item tabItem, dustBedrockium, essenceElectricalSteel, seedElectricalSteel;
	public static Block compressedBedrockiumBlock;
	
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
		itemSeeds[i] = new ItemSeed(identifiers[i], "seed");
		if(itemSeeds[i] != null) RegisterBot.registerItem(itemSeeds[i]);
	}
	
	// Create Essences
	for(int i = 0; i <= identifiers.length - 1; i++){
		itemEssences[i] = new ItemEssence(identifiers[i]);
		if(itemEssences != null) RegisterBot.registerItem(itemEssences[i]);
	}
	
	// Register Blocks
	for(int i = 0; i <= identifiers.length - 1; i++){
		crops[i] = new BlockCropMod(identifiers[i], itemSeeds[i], itemEssences[i]);
		if(crops[i] != null) RegisterBot.registerBlock(crops[i]);
	}	
	
	/*CropBedrockium = new BlockCropBedrockium(0);
	RegisterBot.registerBlock(CropBedrockium);
	
	crops[0] = new BlockCropBedrockium(0);
	
	// Register Items
	// ToDo -=- Put in a separate file or use a helper
	essenceBedrockium = new ItemEssence("Bedrockium");
	essenceElectricalSteel = new ItemEssence("Electrical_Steel");
	seedBedrockium = new ItemSeed("Bedrockium", "seed");
	seedElectricalSteel = new ItemSeed("Electrical_Steel", "seed");
	dustBedrockium = new ItemDust("Bedrockium");
	compressedBedrockiumDust = new BlockCompressed(Material.plants, "BedrockiumDust");
	GameRegistry.registerItem(essenceBedrockium, "essenceBedrockium");
	GameRegistry.registerItem(seedBedrockium, "seedBedrockium");
	GameRegistry.registerItem(dustBedrockium, "dustBedrockium");
	GameRegistry.registerItem(essenceElectricalSteel, "essenceElectricalSteel");
	GameRegistry.registerItem(seedElectricalSteel, "seedElectricalSteel");
	GameRegistry.registerBlock(compressedBedrockiumDust, "compressedBedrockiumDust");*/
	
	tabItem = new ItemTab();
	GameRegistry.registerItem(tabItem, "tabItem");;
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		if(Loader.isModLoaded("ExtraUtilities")){
			ModItems.fetchItems();
			ModBlocks.fetchBlocks();
			// Recipes.registerRecipes();
		}else{
			// Do something about this being empty  ?! !IMPORTANT
		}
	}
}
