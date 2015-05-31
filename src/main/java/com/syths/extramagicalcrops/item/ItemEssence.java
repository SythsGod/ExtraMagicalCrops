package com.syths.extramagicalcrops.item;

import com.syths.extramagicalcrops.init.ModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEssence extends Item{
	
	public ItemEssence(String name){
		setMaxStackSize(64);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName("mEssence" + name);
		setTextureName("extramagicalcrops:mEssence" + name);
	}
}
