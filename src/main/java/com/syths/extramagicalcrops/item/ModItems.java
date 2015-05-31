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
	public static ItemStack ingotBedrockium, essenceDust, essenceWeak, essenceRegular, essenceStrong, essenceExtreme;
	public static ItemStack[] origEssences;
	public static ItemStack[] ingotsEnderIO;
	
	public static void fetchItems(){
		origEssences = new ItemStack[4];
		ingotsEnderIO = new ItemStack[8];
		
		
		ingotBedrockium = fetchStack("ExtraUtilities", "bedrockiumIngot");
		
		// Get all needed "Ender IO" ingots
		for(int i = 0; i < 6; i++){
			ingotsEnderIO[i] = fetchStack("EnderIO", "itemAlloy", i);
		}
		
		// Get all the different magical crops essences
		for(int i = 0; i < 4; i++){
			origEssences[i] = fetchStack("magicalcrops", "magicalcrops_MagicEssence", i);
		}
		
		// magicalcrops_MagicEssence:4
		// magicalcrops_InfusionStone:4
		// EnderIO:itemAlloy
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
