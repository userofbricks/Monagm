package com.jonathan.monagm;

import com.jonathan.monagm.init.MonagmItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MonagmItemGroup extends ItemGroup
{
	public MonagmItemGroup() 
	{
		super("monagm");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(MonagmItems.diamond_gauntlet);
	}
}
