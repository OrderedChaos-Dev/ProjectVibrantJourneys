package projectvibrantjourneys.init;

import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.init.objectregistry.PVJBlocks;

public class PVJEvents {
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.BreakSpeed event) {
		if(event.getState().getBlock() == PVJBlocks.natural_cobweb) {
			Item item = event.getPlayer().getMainHandItem().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setNewSpeed(15.0F);
			}
		}
	}
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.HarvestCheck event) {
		if(event.getTargetBlock().getBlock() == PVJBlocks.natural_cobweb) {
			Item item = event.getPlayer().getMainHandItem().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setCanHarvest(true);
			}
		}
	}
}
