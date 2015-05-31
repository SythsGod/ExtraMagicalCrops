package com.syths.extramagicalcrops.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.syths.extramagicalcrops.ExtraMagicalCrops;
import com.syths.extramagicalcrops.init.ModTabs;

public class ItemCollection extends Item {
	
	String itemType;
	public IIcon[] exclusiveTextures = new IIcon[0];
	
	public ItemCollection(String type){
		super();
		itemType = type;
		setHasSubtypes(true);
		setCreativeTab(ModTabs.tabExtraMagicalCrops);
		setUnlocalizedName(itemType);
		if (type == "misc") exclusiveTextures = new IIcon[0];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack is){
		return getUnlocalizedName() + "." + is.getItemDamage();
	}
	
	/*@Override
	public boolean onItemUse(ItemStack par1Stack, EntityPlayer par2Player, World par3World, int x, int y, int z,
			int par7Side, float par8HitX, float par9HitY, float par10HitZ){
		
		if(par7Side != 1 || par3World.getBlock(x, y, z) == Blocks.air || par3World.getBlock(x, y, z) == null || par3World.getBlock(x, y, z) != Blocks.farmland || !par3World.isAirBlock(x,  y + 1, z)) return false;
		else if(itemType == "seed"){
			if(par3World.isRemote){
				par3World.playSound(x, y + 1, z, Block.soundTypeGrass.getBreakSound(), 1, 0.75F, true);
				return true;
			}
			
			int meta = par1Stack.getItemDamage();
			par3World.setBlock(x, y + 1, z, ExtraMagicalCrops.CropBedrockium  ExtraMagicalCrops.crops[(meta - (meta % 4)) / 4] , (meta % 4), 3);
			par1Stack.stackSize--;
			return true;
		}
		return false;
	}*/
	
	@Override
	public void registerIcons(IIconRegister iconReg){
		if(itemType.equals("seed") || itemType.equals("essence"))
			for (int i = 0; i < exclusiveTextures.length; i++)
				exclusiveTextures[i] = iconReg.registerIcon("extramagicalcrops:" + itemType + ExtraMagicalCrops.identifiers[i]);
		else
			exclusiveTextures[0] = iconReg.registerIcon("extramagicalcrops:essencePulsating");
	}
	
	@Override
	public IIcon getIconFromDamage(int damage){
		return damage < exclusiveTextures.length ? exclusiveTextures[damage] : exclusiveTextures[0];
	}
	
	//@Override
	public void getSubItems(Block block, CreativeTabs tab, List list){
		
		if(itemType.equals("seed") || itemType.equals("essence"))
			for(int i = 0; i < exclusiveTextures.length; i++)
				list.add(new ItemStack(block, 1, i));
		else list.add(new ItemStack(block, 1, 0));
	}
	
//	@Override
//	public int getSeedId(){
//		return ExtraMagicalCrops.itemSeeds.itemID;
//	}
	
//	@Override
//    public int getPlantedBlockId(World world, int x, int y, int z, ItemStack stack)
//    {
//        int meta = stack.getItemDamage();
//        return ExtraMagicalCrops.crops[(meta - (meta % 4)) / 4].blockID;
//    }
	
	//@Override
	public int getPlantedBlockMetaData(World par1World, int x, int y, int z, ItemStack par5Stack){
		return(par5Stack.getItemDamage() % 4 * 4);
	}
	
	//@Override
	public boolean canBePlantedHere(World par1World, int x, int y, int z, ItemStack par5Stack){
		return par1World.getBlock(x,  y - 1, z) == Blocks.farmland || par1World.getBlock(x, y - 1, z) == Blocks.dirt;
	}
	
	//@Override
	public void prePlant(World par1World, int x, int y, int z, ItemStack par5Stack){
		if(par1World.getBlock(x, y - 1, z) == Blocks.dirt)
			par1World.setBlock(x, y - 1, z, Blocks.farmland);
	}
	
	//@Override
	public void postPlant(World par1World, int x, int y, int z, ItemStack par5Stack){
	}
}