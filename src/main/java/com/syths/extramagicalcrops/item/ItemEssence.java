package com.syths.extramagicalcrops.item;

import com.syths.extramagicalcrops.init.ModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEssence extends Item{
	
	int level;
	
	public ItemEssence(String name, int level){
		this.level = level;
		setMaxStackSize(64);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName("mEssence" + name);
		setTextureName("extramagicalcrops:mEssence" + name);
	}
	
	public int getLevel(){
		return level;
	}
}
