package com.syths.extramagicalcrops.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockCrops extends ItemBlock{
	
	public IIcon missingTex;
	
	public ItemBlockCrops(Block block){
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta){
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack is){
		return super.getUnlocalizedName() + "." + is.getItemDamage();
	}
	
	/*public int getRenderType(){
		return 6;
	}
	
	public void registerIcons(IIconRegister iconReg){
		missingTex = iconReg.registerIcon("extramagicalcrops:textureMissing");
	}
	
	public IIcon getIcon(){
		return missingTex;
	}*/
}
