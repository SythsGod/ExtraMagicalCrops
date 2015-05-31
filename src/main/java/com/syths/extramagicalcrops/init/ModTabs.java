package com.syths.extramagicalcrops.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.syths.extramagicalcrops.ExtraMagicalCrops;

public class ModTabs {
	
	public static CreativeTabs tabExtraMagicalCrops;
	
	public static void load(){
		tabExtraMagicalCrops = new CreativeTabs("tabExtraMagicalCrops"){
			@Override
			public Item getTabIconItem(){
				return ExtraMagicalCrops.tabItem;
			}
		};
	}
}
