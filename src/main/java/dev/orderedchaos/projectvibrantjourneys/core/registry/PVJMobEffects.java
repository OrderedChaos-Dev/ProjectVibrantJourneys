package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PVJMobEffects {

  public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, ProjectVibrantJourneys.MOD_ID);

  public static final RegistryObject<MobEffect> SPORADIC_SILENCE = register("sporadic_silence", () -> new BaseMobEffect(MobEffectCategory.BENEFICIAL, 0x052a32));

  private static RegistryObject<MobEffect> register(String name, Supplier<MobEffect> supplier) {
    return MOB_EFFECTS.register(name, supplier);
  }

  private static class BaseMobEffect extends MobEffect {
    protected BaseMobEffect(MobEffectCategory pCategory, int pColor) {
      super(pCategory, pColor);
    }
  }
}