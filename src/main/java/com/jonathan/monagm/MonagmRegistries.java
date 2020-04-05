package com.jonathan.monagm;

import org.apache.logging.log4j.Logger;

import com.jonathan.monagm.init.GauntletMaterials;
import com.jonathan.monagm.init.MonagmEnchantments;
import com.jonathan.monagm.init.MonagmItems;
import com.jonathan.monagm.items.GauntletItem;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class MonagmRegistries 
{
	public static final ItemGroup MONAGM = Monagm.MONAGM;
	public static final Logger LOGGER = Monagm.LOGGER;
	public static final String MODID = Monagm.MODID;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
//			MonagmItems.tutorial_gauntlet = new GauntletItem(GauntletMaterials.tutorial, new Item.Properties().group(MONAGM)).setRegistryName(location("tutorial_gauntlet")),
			MonagmItems.diamond_gauntlet = 	new GauntletItem(GauntletMaterials.diamond, new Item.Properties().group(MONAGM)).setRegistryName(location("diamond_gauntlet")),
			MonagmItems.gold_gauntlet = 	new GauntletItem(GauntletMaterials.gold, 	new Item.Properties().group(MONAGM)).setRegistryName(location("gold_gauntlet")),
			MonagmItems.iron_gauntlet = 	new GauntletItem(GauntletMaterials.iron, 	new Item.Properties().group(MONAGM)).setRegistryName(location("iron_gauntlet")),
			MonagmItems.leather_gauntlet = 	new GauntletItem(GauntletMaterials.leather, new Item.Properties().group(MONAGM)).setRegistryName(location("leather_gauntlet"))
		);
		
		LOGGER.info("Items registered.");
	}
	
	@SubscribeEvent
	public static void registerEnchant(RegistryEvent.Register<Enchantment> event)
	{
		event.getRegistry().registerAll(MonagmEnchantments.ENCHANTMENTS.toArray(new Enchantment[0]));
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MODID, name);
	}
}
