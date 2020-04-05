package com.jonathan.monagm.items;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public interface IGauntletMaterial 
{
	int getEnchantability();//
	
	int getDurability();//
	
	int getArmorAmount();//
	
	String getTextureName();//
	
	SoundEvent getSoundEvent();//
	
	Ingredient getRepairMaterial();//
	
	float getAttackDamage();//
}
