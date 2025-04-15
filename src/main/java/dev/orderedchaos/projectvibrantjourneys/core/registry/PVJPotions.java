package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJPotions {
  public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ProjectVibrantJourneys.MOD_ID);

  public static RegistryObject<Potion> GLOWING = POTIONS.register("glowing", () -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 3600)));
  public static RegistryObject<Potion> LONG_GLOWING = POTIONS.register("long_glowing", () -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 9600)));

  public static RegistryObject<Potion> SPORADIC_SILENCE = POTIONS.register("sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE.get(), 4800)));
  public static RegistryObject<Potion> LONG_SPORADIC_SILENCE = POTIONS.register("long_sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE.get(), 12000)));
  public static RegistryObject<Potion> STRONG_SPORADIC_SILENCE = POTIONS.register("strong_sporadic_silence", () -> new Potion(new MobEffectInstance(PVJMobEffects.SPORADIC_SILENCE.get(), 4800, 1)));
}
