package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PVJPotions {
  public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, ProjectVibrantJourneys.MOD_ID);

  public static DeferredHolder<Potion, Potion> GLOWING = POTIONS.register("glowing", () -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 3600)));
  public static DeferredHolder<Potion, Potion> LONG_GLOWING = POTIONS.register("long_glowing", () -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 9600)));

  public static DeferredHolder<Potion, Potion> SPORADIC_SILENCE = POTIONS.register("sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE, 4800)));
  public static DeferredHolder<Potion, Potion> LONG_SPORADIC_SILENCE = POTIONS.register("long_sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE, 12000)));
  public static DeferredHolder<Potion, Potion> STRONG_SPORADIC_SILENCE = POTIONS.register("strong_sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE, 4800, 1)));
}
