package com.jonathan.monagm.init;

import java.util.ArrayList;
import java.util.List;

import com.jonathan.monagm.Monagm;
import com.jonathan.monagm.enchantments.KnockbackResistanceEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Monagm.MODID)
public class MonagmEnchantments 
{
	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

	public static final Enchantment KNOCKBACK_RESISTANCE = new KnockbackResistanceEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlotType.CHEST);
}
