package com.jonathan.monagm.events;

import java.util.Optional;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import com.jonathan.monagm.Monagm;
import com.jonathan.monagm.init.MonagmItems;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import top.theillusivec4.curios.api.CuriosAPI;

// failed atempt at damaging gaunlet items when player hits an entity

//@Mod.EventBusSubscriber(modid = Monagm.MODID, bus = Bus.FORGE)
public class DamageGauntletEvent 
{
	private static Item[] items = new Item[] {MonagmItems.diamond_gauntlet, MonagmItems.gold_gauntlet, MonagmItems.iron_gauntlet, MonagmItems.leather_gauntlet};
	
	@SubscribeEvent
	public void DamageGauntletEvent(AttackEntityEvent event)
	{
		PlayerEntity player = event.getPlayer();
		LivingEntity playerEntityLiving = player instanceof LivingEntity ? (LivingEntity) player : null;
		
		ItemStack stack = null;
		
		Optional<ImmutableTriple<String, Integer, ItemStack>> itemStackOptionalImmutableTriple = getItemStackOptionalImmutableTriple(playerEntityLiving);
		
		if (itemStackOptionalImmutableTriple != null) {
			stack = itemStackOptionalImmutableTriple.get().getRight();
			if (!player.isCreative()) {
				stack.attemptDamageItem(1, player.getRNG(), player instanceof ServerPlayerEntity ? (ServerPlayerEntity)player : null);
			}
		}
	}
	
	public Optional<ImmutableTriple<String, Integer, ItemStack>> getItemStackOptionalImmutableTriple(LivingEntity entity)
	{
		Optional<ImmutableTriple<String, Integer, ItemStack>> itemStackOptionalImmutableTriple = null;
		for (int i = 0; i < items.length; i++) {
			itemStackOptionalImmutableTriple = CuriosAPI.getCurioEquipped(items[i], entity);
			if (itemStackOptionalImmutableTriple != null) {
				return itemStackOptionalImmutableTriple;
			}
		}
		return itemStackOptionalImmutableTriple = CuriosAPI.getCurioEquipped(items[0], entity);
	}
}
