package com.syths.extramagicalcrops.item;

import net.minecraft.item.Item;

import com.syths.extramagicalcrops.init.ModTabs;

public class ItemUltimateEssence extends Item{
	public ItemUltimateEssence(String name){
		setMaxStackSize(64);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName("essence" + name);
		setTextureName("extramagicalcrops:mEssence" + name);
	}
}
