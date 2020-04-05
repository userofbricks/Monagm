package com.jonathan.monagm.events;

import com.jonathan.monagm.Monagm;
import com.jonathan.monagm.items.GauntletItem;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Monagm.MODID, bus = Bus.FORGE)
public class GauntletAnvilEnchanting
{
	@SubscribeEvent
	public void GauntletAnvilEnchanting(AnvilUpdateEvent event)
	{
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		ItemStack output = left;
		int knockback = 0;
		int punch = 0;
		
		if (left.getItem() instanceof GauntletItem && right.getItem() instanceof EnchantedBookItem)
		{
			if (EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, left) <= 0)
			{
				knockback = EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, right);
				output.addEnchantment(Enchantments.KNOCKBACK, knockback);
			}
			if (EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, left) <= 0)
			{
				punch = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, right);
				output.addEnchantment(Enchantments.PUNCH, punch);
			}
			if (EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, right) > 0 || EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, right) > 0)
			{
				event.setOutput(output);
			}
		}
	}
}
