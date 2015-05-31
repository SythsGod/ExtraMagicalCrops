package com.syths.extramagicalcrops.item;

import com.syths.extramagicalcrops.init.ModTabs;

import net.minecraft.item.Item;

public class ItemDust extends Item{
	
	public ItemDust(String name){
		setMaxStackSize(64);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName("mDust" + name);
		setTextureName("extramagicalcrops:mDust" + name);
	}
}
