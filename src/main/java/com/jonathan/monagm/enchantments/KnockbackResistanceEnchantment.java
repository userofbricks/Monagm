package com.jonathan.monagm.enchantments;

import com.jonathan.monagm.init.MonagmEnchantments;
import com.jonathan.monagm.items.GauntletItem;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class KnockbackResistanceEnchantment extends Enchantment
{

	public KnockbackResistanceEnchantment(Rarity rarityIn, EquipmentSlotType... slots)
	{
		super(rarityIn, EnchantmentType.WEARABLE, slots);
		this.setRegistryName("knockback_resistance");
		
		MonagmEnchantments.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel)
	{
		return 1 + 10 * (enchantmentLevel - 1);
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel)
	{
		return this.getMinEnchantability(enchantmentLevel) + 50;
	}
	
	@Override
	public int getMaxLevel()
	{
		return 5;
	}
	
	@Override
	public boolean canApply(ItemStack stack)
	{
		return stack.getItem() instanceof GauntletItem;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) 
	{
		if(ench == Enchantments.KNOCKBACK)
		{
			return false;
		}
		return true;
	}
}
