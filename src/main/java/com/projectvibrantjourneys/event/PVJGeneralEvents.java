package com.projectvibrantjourneys.event;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PVJGeneralEvents {

	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.BreakSpeed event) {
		if(event.getState().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
			Item item = event.getPlayer().getMainHandItem().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setNewSpeed(15.0F);
			}
		}
	}
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.HarvestCheck event) {
		if(event.getTargetBlock().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
			Item item = event.getPlayer().getMainHandItem().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setCanHarvest(true);
			}
		}
	}
	
}
