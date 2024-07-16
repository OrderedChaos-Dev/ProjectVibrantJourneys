package dev.orderedchaos.projectvibrantjourneys.common.events;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJMobEffects;
import net.minecraft.tags.GameEventTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.VanillaGameEvent;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class PVJGameEventEvents {

  @SubscribeEvent
  public static void checkVibrationEvent(VanillaGameEvent event) {
    if (event.getVanillaEvent().is(GameEventTags.VIBRATIONS)) {
      if (event.getCause() instanceof LivingEntity entity) {
        MobEffectInstance mobEffectInstance = entity.getEffect(PVJMobEffects.SPORADIC_SILENCE);
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
