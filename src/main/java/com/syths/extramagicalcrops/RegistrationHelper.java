package com.syths.extramagicalcrops;

import com.syths.extramagicalcrops.item.ItemEssence;
import com.syths.extramagicalcrops.item.ItemSeed;
import com.syths.extramagicalcrops.item.ItemTab;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RegistrationHelper {
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, "extramagicalcrops_" + block.getUnlocalizedName());
	}
	
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, "extramagicalcrops_" + item.getUnlocalizedName());
	}
}

