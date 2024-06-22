package dev.orderedchaos.projectvibrantjourneys.common.events;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class PVJCobwebEvents {

  // We need this because the SWORD_EFFICIENT block tag only sets the speed to 1.5
  @SubscribeEvent
  public static void harvestCobweb(PlayerEvent.BreakSpeed event) {
    if (event.getState().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
      Item item = event.getEntity().getMainHandItem().getItem();
      if (item instanceof SwordItem || item instanceof ShearsItem) {
        event.setNewSpeed(15.0F);
      }
    }
  }

  @SubscribeEvent
  public static void harvestCobweb(PlayerEvent.HarvestCheck event) {
    if (event.getTargetBlock().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
      Item item = event.getEntity().getMainHandItem().getItem();
      if (item instanceof SwordItem || item instanceof ShearsItem) {
        event.setCanHarvest(true);
      }
    }
  }

}
