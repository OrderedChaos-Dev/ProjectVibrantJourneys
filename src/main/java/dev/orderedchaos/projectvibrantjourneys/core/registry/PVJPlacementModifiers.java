package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.placementmodifiers.BiomeDensityPlacementFilter;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.placementmodifiers.ChancePlacementFilter;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PVJPlacementModifiers {
  public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, ProjectVibrantJourneys.MOD_ID);

  public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<ChancePlacementFilter>> CHANCE = PLACEMENT_MODIFIERS.register("chance", () -> () -> ChancePlacementFilter.CODEC);
  public static final DeferredHolder<PlacementModifierType<?>, PlacementModifierType<BiomeDensityPlacementFilter>> VEGETATION_DENSITY = PLACEMENT_MODIFIERS.register("vegetation_density", () -> () -> BiomeDensityPlacementFilter.CODEC);
}
