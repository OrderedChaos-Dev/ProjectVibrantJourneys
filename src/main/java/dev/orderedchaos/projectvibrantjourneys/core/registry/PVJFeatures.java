package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.*;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.MultipleVegetationPatchConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.stateproviders.DirectionalStateProvider;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJFeatures {

  public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ProjectVibrantJourneys.MOD_ID);

  public static final RegistryObject<Feature<RandomPatchConfiguration>> ROCKS = registerFeature("rocks", new RocksGroundcoverFeature(RandomPatchConfiguration.CODEC));
  public static final RegistryObject<Feature<NoneFeatureConfiguration>> BARK_MUSHROOM = registerFeature("bark_mushroom", new BarkMushroomFeature(NoneFeatureConfiguration.CODEC));
  public static final RegistryObject<Feature<SimpleBlockConfiguration>> SIMPLE_BLOCK_MATCH_WATER = registerFeature("simple_block_match_water", new SimpleBlockMatchWaterFeature(SimpleBlockConfiguration.CODEC));
  public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> NATURAL_COBWEB = registerFeature("natural_cobweb", new NaturalCobwebFeature(ProbabilityFeatureConfiguration.CODEC));
  public static final RegistryObject<Feature<FallenTreeConfiguration>> FALLEN_TREE = registerFeature("fallen_tree", new FallenTreeFeature(FallenTreeConfiguration.CODEC));
  public static final RegistryObject<Feature<MultipleVegetationPatchConfiguration>> POOL = registerFeature("pool", new MultipleWaterloggedVegetationPatchFeature(MultipleVegetationPatchConfiguration.CODEC));
  public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> LILYPAD = registerFeature("lily_pad", new ExtraLilyPadFeature(ProbabilityFeatureConfiguration.CODEC));
  public static final RegistryObject<Feature<NoneFeatureConfiguration>> ICICLE = registerFeature("icicle", new IcicleFeature(NoneFeatureConfiguration.CODEC));


  private static <FC extends FeatureConfiguration> RegistryObject<Feature<FC>> registerFeature(String name, Feature<FC> feature) {
    return FEATURES.register(name, () -> feature);
  }

  public static class StateProviders {

    public static final DeferredRegister<BlockStateProviderType<?>> TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, ProjectVibrantJourneys.MOD_ID);

    public static final RegistryObject<BlockStateProviderType<DirectionalStateProvider>> DIRECTIONAL_STATE_PROVIDER = TYPES.register("directional_state_provider", () -> new BlockStateProviderType<>(DirectionalStateProvider.CODEC));
  }
}