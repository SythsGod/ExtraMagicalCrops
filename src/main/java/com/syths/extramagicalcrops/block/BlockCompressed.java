package com.syths.extramagicalcrops.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.syths.extramagicalcrops.init.ModTabs;

public class BlockCompressed extends Block{
	
	public BlockCompressed(Material material, String name){
		super(material);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setHardness(0.5F);
		setStepSound(Block.soundTypeStone);
		setBlockName("compressed" + name);
		setBlockTextureName("extramagicalcrops:mCompressed" + name);
		setLightLevel(2.0F);
		setLightOpacity(5);
	}
}
