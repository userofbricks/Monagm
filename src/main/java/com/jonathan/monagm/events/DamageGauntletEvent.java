package com.jonathan.monagm.events;

import java.util.Optional;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import com.jonathan.monagm.Monagm;
import com.jonathan.monagm.init.MonagmItems;
import com.jonathan.monagm.items.GauntletItem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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
	
	@SubscribeEvent
	public void DamageGauntletEvent(AttackEntityEvent event)
	{
		PlayerEntity player = event.getPlayer();
		LivingEntity playerEntityLiving = player instanceof LivingEntity ? (LivingEntity) player : null;
		Item[] gauntlets = new Item[] {MonagmItems.diamond_gauntlet, MonagmItems.gold_gauntlet, MonagmItems.iron_gauntlet, MonagmItems.leather_gauntlet};
		
		Optional<ImmutableTriple<String, Integer, ItemStack>> equipedOtionalTripple;
		
		for (int i = 0; i < 4; i++) {
			equipedOtionalTripple = CuriosAPI.getCurioEquipped(gauntlets[i], playerEntityLiving);
			equipedOtionalTripple.ifPresent((ImmutableTriple<String, Integer, ItemStack> equipedTripple) -> {
				ItemStack equiped = equipedTripple.getRight();
				String identifier = equipedTripple.getLeft();
				int index = equipedTripple.getMiddle();
				if (!player.isCreative() && equiped.getItem() instanceof GauntletItem) {
//					equiped.attemptDamageItem(1, player.getRNG(), player instanceof ServerPlayerEntity ? (ServerPlayerEntity)player : null);
					equipedTripple.getRight().damageItem(1, playerEntityLiving, damager -> CuriosAPI.onBrokenCurio(identifier, index, damager));
				}
			}
			);
		}
	}
}
