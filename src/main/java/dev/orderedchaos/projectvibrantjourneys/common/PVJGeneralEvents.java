package dev.orderedchaos.projectvibrantjourneys.common;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJMobEffects;
import net.minecraft.tags.GameEventTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PVJGeneralEvents {

  // We need this because the SWORD_EFFICIENT block tag only sets the speed to 1.5
  @SubscribeEvent
  public void harvestCobweb(PlayerEvent.BreakSpeed event) {
    if (event.getState().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
      Item item = event.getEntity().getMainHandItem().getItem();
      if (item instanceof SwordItem || item instanceof ShearsItem) {
        event.setNewSpeed(15.0F);
      }
    }
  }

  @SubscribeEvent
  public void harvestCobweb(PlayerEvent.HarvestCheck event) {
    if (event.getTargetBlock().getBlock() == PVJBlocks.NATURAL_COBWEB.get()) {
      Item item = event.getEntity().getMainHandItem().getItem();
      if (item instanceof SwordItem || item instanceof ShearsItem) {
        event.setCanHarvest(true);
      }
    }
  }


  @SubscribeEvent
  public void checkVibrationEvent(VanillaGameEvent event) {
    if (event.getVanillaEvent().is(GameEventTags.VIBRATIONS)) {
      if (event.getCause() instanceof LivingEntity entity) {
        MobEffectInstance mobEffectInstance = entity.getEffect(PVJMobEffects.SPORADIC_SILENCE.get());
        if (mobEffectInstance != null) {
          RandomSource random = event.getLevel().getRandom();
          float threshold = ((mobEffectInstance.getAmplifier() + 1) * 0.25F) + ((mobEffectInstance.getAmplifier() + 1) * 0.05F * random.nextFloat());
          if (random.nextFloat() < threshold) {
            event.setCanceled(true);
          }
        }
      }
    }
  }
}
