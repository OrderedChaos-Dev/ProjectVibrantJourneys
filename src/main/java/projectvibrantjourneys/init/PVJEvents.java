package projectvibrantjourneys.init;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.object.PVJItems;

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
	
	@SubscribeEvent
	public void setupTrades(VillagerTradesEvent event) {
		if(event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add((entity, random) -> {
				return new MerchantOffer(new ItemStack(PVJItems.pearl, 1), new ItemStack(Items.EMERALD, 1), 10, 6, 2);
			});
		}
	}
}
