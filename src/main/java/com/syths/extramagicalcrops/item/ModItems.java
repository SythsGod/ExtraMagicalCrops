package com.syths.extramagicalcrops.item;

import java.util.ArrayList;
import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
	public static ItemStack ingotBedrockium;
	public static ItemStack essenceDust;
	public static ItemStack essenceWeak;
	public static ItemStack essenceRegular;
	public static ItemStack essenceStrong;
	public static ItemStack essenceExtreme;
	public static ItemStack ingotElectricalSteel;
	public static ItemStack ingotEnergeticAlloy;
	public static ItemStack ingotVibrantAlloy;
	public static ItemStack ingotRedstoneAlloy;
	public static ItemStack ingotConductiveIron;
	public static ItemStack ingotPulsatingIron;
	public static ItemStack ingotDarkSteel;
	public static ItemStack ingotSoularium;
	
	public static void fetchItems(){		
		ingotBedrockium = fetchStack("ExtraUtilities", "bedrockiumIngot");		
		essenceDust = fetchStack("magicalcrops", "magicalcrops_MagicEssence", 0);
		essenceWeak = fetchStack("magicalcrops", "magicalcrops_MagicEssence", 1);
		essenceRegular = fetchStack("magicalcrops", "magicalcrops_MagicEssence", 2);
		essenceStrong = fetchStack("magicalcrops", "magicalcrops_MagicEssence", 3);
		essenceExtreme = fetchStack("magicalcrops", "magicalcrops_MagicEssence", 4);
		ingotElectricalSteel = fetchStack("EnderIO", "blockStorageIngot", 0);
		ingotEnergeticAlloy = fetchStack("EnderIO", "blockStorageIngot", 1);
		ingotVibrantAlloy = fetchStack("EnderIO", "blockStorageIngot", 2);
		ingotRedstoneAlloy = fetchStack("EnderIO", "blockStorageIngot", 3);
		ingotConductiveIron = fetchStack("EnderIO", "blockStorageIngot", 4);
		ingotPulsatingIron = fetchStack("EnderIO", "blockStorageIngot", 5);
		ingotDarkSteel = fetchStack("EnderIO", "blockStorageIngot", 6);
		ingotSoularium = fetchStack("EnderIO", " blockStorageIngot", 7);
	}
	
	public static ItemStack fetchStack(String modId, String item){
		return GameRegistry.findItemStack(modId, item, 1); // Will return in the form of an ItemStack var
	}
	
	public static ItemStack fetchStack(String modId, String name, int damage){
		ItemStack stack = GameRegistry.findItemStack(modId, name, 1);
		if(stack != null) stack.setItemDamage(damage);
		return stack;
	}
	
	public static ItemStack fetchOreDict(String dict){
		ArrayList<ItemStack> stacks = OreDictionary.getOres(dict);
		if (stacks.size() > 1){
			return stacks.get(0);
		}
		
		return null;
	}
	
	public static ItemStack pullStack(String className, String field){
		try{
			Class c = Class.forName(className);
			Object f = c.getField(field).get(null);
			
			if(f instanceof ItemStack)
				return (ItemStack) f;
			if(f instanceof Item)
				return new ItemStack(((Item)f), 1, 0);
			return null;
		}
		catch (Exception ex){
			return null;
		}
	}
}
