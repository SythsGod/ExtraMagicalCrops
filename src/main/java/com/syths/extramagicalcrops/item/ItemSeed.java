package com.syths.extramagicalcrops.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.syths.extramagicalcrops.ExtraMagicalCrops;
import com.syths.extramagicalcrops.init.ModTabs;

public class ItemSeed extends Item{
	
	String itemType;
	
	public ItemSeed(String name, String type){
		itemType = type;
		setMaxStackSize(64);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName("mSeed" + name);
		setTextureName("extramagicalcrops:mSeed" + name);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1Stack, EntityPlayer par2Player, World par3World, int x, int y, int z,
			int par7Side, float par8HitX, float par9HitY, float par10HitZ){
		
		if(par7Side != 1 || par3World.getBlock(x, y, z) == Blocks.air || par3World.getBlock(x, y, z) == null || par3World.getBlock(x, y, z) != Blocks.farmland || !par3World.isAirBlock(x,  y + 1, z)) return false;
		else if(itemType == "seed"){
			if(par3World.isRemote){
				par3World.playSound(x, y + 1, z, Block.soundTypeGrass.getBreakSound(), 1, 0.75F, true);
				return true;
			}
			
			int meta = par1Stack.getItemDamage();
			par3World.setBlock(x, y + 1, z, ExtraMagicalCrops.crops[(meta - (meta % 4)) / 4], (meta % 4), 3);
			par1Stack.stackSize--;
			return true;
		}
		return false;
	}
}
