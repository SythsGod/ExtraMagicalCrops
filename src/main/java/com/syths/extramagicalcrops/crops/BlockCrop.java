package com.syths.extramagicalcrops.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.syths.extramagicalcrops.ExtraMagicalCrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrop extends BlockBush implements IGrowable{
	
	@SideOnly(Side.CLIENT)
	public int blockType;
	public static IIcon iconArray[];
	
	public BlockCrop(){
		float f = 0.5F;
		setCreativeTab((CreativeTabs)null);
		setStepSound(soundTypeGrass);
		setTickRandomly(true);
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setHardness(0.0F);
		disableStats();
	}
	
	protected boolean canPlaceBlockOn(Block block){
		return block == Blocks.farmland;
	}
	
	@Override
	public void updateTick(World par1World, int x, int y, int z, Random rand){
		if(!par1World.isRemote && par1World.getBlockLightValue(x,  y + 1, z) >= 9 && par1World.getBlockMetadata(x, y, z) < 7){
			par1World.setBlockMetadataWithNotify(x, y, z, par1World.getBlockMetadata(x, y, z) + 1, 3);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){		
		if ((side < 0) || (meta > 7)){
			meta = 7;
		}
		
		return this.iconArray[meta];
	}
	
	public void dropBlockAsItemWithChance(World par1World, int x, int y, int z, int par5, float par6, int par7){
		super.dropBlockAsItemWithChance(par1World, x, y, z, par5, par6, par7);
		if (!par1World.isRemote){
			if ((par5 >= 7) && (par1World.rand.nextInt(10) == 0)){
				dropBlockAsItem(par1World, x, y, z, new ItemStack(ExtraMagicalCrops.itemSeeds[0], 1));
			}			
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int x, int y, int z){
		return getSeed();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconReg){		
		this.iconArray = new IIcon[8];
		for(int i = 0; i < this.iconArray.length; i++){
			this.iconArray[i] = iconReg.registerIcon(getTextureName() + "_stage_" + i);
		}
	}
	
	public int quantityDropped(Random p_149745_1_){
		return 1;
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random rand){
		int meta = par1World.getBlockMetadata(x, y, z);
		
		if(rand.nextInt(5) > 0) return;
		
		if(meta % 4 >= 3) par1World.spawnParticle("instantSpell", x + rand.nextFloat(), y + 0.6F,  z + rand.nextFloat(),  0.0D, 0.0D, 0.0D);
		else par1World.spawnParticle("enchantmentable", x + rand.nextFloat(), y + 0.9F, z + rand.nextFloat(), 0.0D, 0.0D, 0.0D);
	}
	
	protected Item getSeed(){
		return Items.wheat_seeds;
	}
	
	protected Item getCrop(){
		return Items.wheat;
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
		return p_149650_1_ == 7 ? getCrop() : getSeed();
	}
	
	public boolean breakBlock(){
		return true;
	}
	
	public boolean canBeHarvested(World par1World, Map<String, Boolean> harvesterSettings, int x, int y, int z){
		return (par1World.getBlockMetadata(x, y, z) - 3) % 4 == 0;
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune){
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
		if(metadata >= 7){
			if(world.rand.nextInt(7) <= metadata){
				for(int i = 0; i < 1 + fortune; i++){
					ret.add(new ItemStack(getSeed(), 1, 0));
				}
			}
		}			
		return ret;
	}
	
	public void preHarvest(World par1World, int x, int y, int z){
	}
	
	public void postHarvest(World par1World, int x, int y, int z){
	}

	@Override
	//canFertilize()
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
	}

	@Override
	// shouldFertilize()
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return false;
	}
	
	// fertilize()
	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {}
}

	
