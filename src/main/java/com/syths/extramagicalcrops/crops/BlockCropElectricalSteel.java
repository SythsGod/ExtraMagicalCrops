package com.syths.extramagicalcrops.crops;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.syths.extramagicalcrops.ExtraMagicalCrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCropElectricalSteel extends BlockCrop{
	
	@SideOnly(Side.CLIENT)
	private IIcon iconArray[];
	
	public BlockCropElectricalSteel(int par1){
		setBlockName("CropElectricalSteel");
	}
	
	public int getRenderType(){
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		if (meta < 7){
			if (meta == 6){
				meta = 5;
			}
			return this.iconArray[(meta >> 1)];
		}
		return this.iconArray[3];
	}
	
	protected Item getSeed(){
		return ExtraMagicalCrops.seedElectricalSteel;
	}
	
	protected Item getCrop(){
		return ExtraMagicalCrops.essenceElectricalSteel;
	}
	
	public int damageDropped(int i){
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconReg){
		this.iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; i++){
			System.out.println(i);
			this.iconArray[i] = iconReg.registerIcon("extramagicalcrops:mCropElectricalSteel_" + i);
		}
	}
}
