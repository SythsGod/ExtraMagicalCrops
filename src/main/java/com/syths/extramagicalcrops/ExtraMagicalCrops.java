package com.syths.extramagicalcrops;

import javax.swing.JOptionPane;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.syths.extramagicalcrops.block.BlockCompressed;
import com.syths.extramagicalcrops.block.ModBlocks;
import com.syths.extramagicalcrops.crops.BlockCropMod;
import com.syths.extramagicalcrops.init.ModTabs;
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

@Mod(modid = ExtraMagicalCrops.MOD_ID, name = ExtraMagicalCrops.MOD_NAME, version = ExtraMagicalCrops.VERSION, dependencies = ExtraMagicalCrops.DEPENDENCIES)

public class ExtraMagicalCrops {
	// Let us all hate Teh_Colt <3
	public static final String MOD_ID = "extramagicalcrops";
	public static final String MOD_NAME = "Extra Magical Crops";
	public static final String VERSION = "0.0.1a";
	public static final String DEPENDENCIES = "required-after:ExtraUtilities;required-after:EnderIO;required-after:magicalcrops;";
	
	public static int secondSeedDropChance = 2;
	
	// Items and Blocks (Seperate Items)
	public static Item tabItem;
	public static Item dustBedrockium;
	public static Block compressedBedrockiumDustBlock;
	
	public static ItemSeed seedBedrockium;
	public static ItemSeed seedElectricalSteel;
	public static ItemSeed seedEnergeticAlloy;
	public static ItemSeed seedVibrantAlloy;
	public static ItemSeed seedRedstoneAlloy;
	public static ItemSeed seedConductiveIron;
	public static ItemSeed seedDarkSteel;
	public static ItemSeed seedSoularium;
	
	public static ItemEssence essenceBedrockium;
	public static ItemEssence essenceElectricalSteel;
	public static ItemEssence essenceEnergeticAlloy;
	public static ItemEssence essenceVibrantAlloy;
	public static ItemEssence essenceRedstoneAlloy;
	public static ItemEssence essenceConductiveIron;
	public static ItemEssence essencePulsatingIron;
	public static ItemEssence essenceDarkSteel;
	public static ItemEssence essenceSoularium;
	
	public static Block cropBedrockium;
	public static Block cropElectricalSteel;
	public static Block cropEnergeticAlloy;
	public static Block cropVibrantAlloy;
	public static Block cropRedstoneAlloy;
	public static Block cropConductiveIron;
	public static Block cropDarkSteel;
	public static Block cropSoularium;
	
	// public static String[] oreDict = new String[] { "bedrockiumIngot", "electricalSteelIngot";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModTabs.load();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		// Fetch needed items/blocks from other mods
		if(Loader.isModLoaded("ExtraUtilities") && Loader.isModLoaded("EnderIO")){
			ModItems.fetchItems();
			ModBlocks.fetchBlocks();
		}else{
			JOptionPane.showMessageDialog(null, "Mods weren't loaded.", "InforBox: debug", JOptionPane.INFORMATION_MESSAGE);			
		}
		
		// Single Items:
		dustBedrockium = new ItemDust("Bedrockium");
		if(dustBedrockium != null) RegistrationHelper.registerItem(dustBedrockium);
		compressedBedrockiumDustBlock = new BlockCompressed(Material.rock, "BedrockiumDust");
		if(compressedBedrockiumDustBlock != null) RegistrationHelper.registerBlock(compressedBedrockiumDustBlock);
		tabItem = new ItemTab();
		if(tabItem != null) RegistrationHelper.registerItem(tabItem);
		
		// Filling Seeds:
		seedBedrockium = new ItemSeed("Bedrockium", cropBedrockium);
		seedElectricalSteel = new ItemSeed("ElectricalSteel", cropElectricalSteel);
		seedEnergeticAlloy = new ItemSeed("EnergeticAlloy", cropEnergeticAlloy);
		seedVibrantAlloy = new ItemSeed("VibrantAlloy", cropVibrantAlloy);
		seedRedstoneAlloy = new ItemSeed("RedstoneAlloy", cropRedstoneAlloy);
		seedConductiveIron = new ItemSeed("ConductiveIron", cropConductiveIron);
		seedDarkSteel = new ItemSeed("DarkSteel", cropDarkSteel);
		seedSoularium = new ItemSeed("Soularium", cropSoularium);
		
		// Registering Seeds:
		if(seedBedrockium != null) RegistrationHelper.registerItem(seedBedrockium);
		if(seedElectricalSteel != null) RegistrationHelper.registerItem(seedElectricalSteel);
		if(seedEnergeticAlloy != null) RegistrationHelper.registerItem(seedEnergeticAlloy);
		if(seedVibrantAlloy != null) RegistrationHelper.registerItem(seedVibrantAlloy);
		if(seedRedstoneAlloy != null) RegistrationHelper.registerItem(seedRedstoneAlloy);
		if(seedConductiveIron != null) RegistrationHelper.registerItem(seedConductiveIron);
		if(seedDarkSteel != null) RegistrationHelper.registerItem(seedDarkSteel);
		if(seedSoularium != null) RegistrationHelper.registerItem(seedSoularium);
		
		// Filling Essences:
		essenceBedrockium = new ItemEssence("Bedrockium");
		essenceElectricalSteel = new ItemEssence("ElectricalSteel");
		essenceEnergeticAlloy = new ItemEssence("EnergeticAlloy");
		essenceVibrantAlloy = new ItemEssence("VibrantAlloy");
		essenceRedstoneAlloy = new ItemEssence("RedstoneAlloy");
		essenceConductiveIron = new ItemEssence("ConductiveIron");
		essencePulsatingIron = new ItemEssence("PulsatingIron");
		essenceDarkSteel = new ItemEssence("DarkSteel");
		essenceSoularium = new ItemEssence("Soularium");
		
		// Registering Essences:
		if(essenceBedrockium != null) RegistrationHelper.registerItem(essenceBedrockium);
		if(essenceElectricalSteel != null) RegistrationHelper.registerItem(essenceElectricalSteel);
		if(essenceEnergeticAlloy != null) RegistrationHelper.registerItem(essenceEnergeticAlloy);
		if(essenceVibrantAlloy != null) RegistrationHelper.registerItem(essenceVibrantAlloy);
		if(essenceRedstoneAlloy != null) RegistrationHelper.registerItem(essenceRedstoneAlloy);
		if(essenceConductiveIron != null) RegistrationHelper.registerItem(essenceConductiveIron);
		if(essenceDarkSteel != null) RegistrationHelper.registerItem(essenceDarkSteel);
		if(essenceSoularium != null) RegistrationHelper.registerItem(essenceSoularium);
		
		// Filling Crops:
		cropBedrockium = new BlockCropMod("Bedrockium", seedBedrockium, essenceBedrockium);
		cropElectricalSteel = new BlockCropMod("ElectricalSteel", seedElectricalSteel, essenceElectricalSteel);
		cropEnergeticAlloy = new BlockCropMod("EnergeticAlloy", seedEnergeticAlloy, essenceEnergeticAlloy);
		cropVibrantAlloy = new BlockCropMod("VibrantAlloy", seedVibrantAlloy, essenceVibrantAlloy);
		cropRedstoneAlloy = new BlockCropMod("RedstoneAlloy", seedRedstoneAlloy, essenceRedstoneAlloy);
		cropConductiveIron = new BlockCropMod("ConductiveIron", seedConductiveIron, essenceConductiveIron);
		cropDarkSteel = new BlockCropMod("DarkSteel", seedDarkSteel, essenceDarkSteel);
		cropSoularium = new BlockCropMod("Soularium", seedSoularium, essenceSoularium);
		
		// Registering Crops:
		if(cropBedrockium != null) RegistrationHelper.registerBlock(cropBedrockium);
		if(cropElectricalSteel != null) RegistrationHelper.registerBlock(cropElectricalSteel);
		if(cropEnergeticAlloy != null) RegistrationHelper.registerBlock(cropEnergeticAlloy);
		if(cropVibrantAlloy != null) RegistrationHelper.registerBlock(cropVibrantAlloy);
		if(cropRedstoneAlloy != null) RegistrationHelper.registerBlock(cropRedstoneAlloy);
		if(cropConductiveIron != null) RegistrationHelper.registerBlock(cropConductiveIron);
		if(cropDarkSteel != null) RegistrationHelper.registerBlock(cropDarkSteel);
		if(cropSoularium != null) RegistrationHelper.registerBlock(cropSoularium);
		
		Recipes.registerRecipes();
	}	
}
