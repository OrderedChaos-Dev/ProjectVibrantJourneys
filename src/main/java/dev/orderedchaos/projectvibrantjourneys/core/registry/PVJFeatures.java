package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.*;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.MultipleVegetationPatchConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.stateproviders.DirectionalStateProvider;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PVJFeatures {

  public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, ProjectVibrantJourneys.MOD_ID);

  public static final DeferredHolder<Feature<?>, Feature<RandomPatchConfiguration>> ROCKS = registerFeature("rocks", new RocksGroundcoverFeature(RandomPatchConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> BARK_MUSHROOM = registerFeature("bark_mushroom", new BarkMushroomFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GLOWING_BLUE_FUNGUS = registerFeature("glowing_blue_fungus", new GlowingBlueFungusFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<SimpleBlockConfiguration>> SIMPLE_BLOCK_MATCH_WATER = registerFeature("simple_block_match_water", new SimpleBlockMatchWaterFeature(SimpleBlockConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<ProbabilityFeatureConfiguration>> NATURAL_COBWEB = registerFeature("natural_cobweb", new NaturalCobwebFeature(ProbabilityFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<FallenTreeConfiguration>> FALLEN_TREE = registerFeature("fallen_tree", new FallenTreeFeature(FallenTreeConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<MultipleVegetationPatchConfiguration>> POOL = registerFeature("pool", new MultipleWaterloggedVegetationPatchFeature(MultipleVegetationPatchConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<ProbabilityFeatureConfiguration>> LILYPAD = registerFeature("lily_pad", new ExtraLilyPadFeature(ProbabilityFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> ICICLE = registerFeature("icicle", new IcicleFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GRAVEL_PIT = registerFeature("gravel_pit", new GravelPitFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> GOLD_PIT = registerFeature("gold_pit", new GoldPitFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<BlockStateConfiguration>> BEACHED_KELP = registerFeature("beached_kelp", new BeachedKelpFeature(BlockStateConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MUDDY_BONES = registerFeature("muddy_bones", new MuddyBonesFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> LOTUS_POND = registerFeature("lotus_pond", new LotusPondFeature(NoneFeatureConfiguration.CODEC));
  public static final DeferredHolder<Feature<?>, Feature<ProbabilityFeatureConfiguration>> FLOATING_PINK_LOTUS = registerFeature("floating_pink_lotus", new FloatingPinkLotusFeature(ProbabilityFeatureConfiguration.CODEC));

  private static <FC extends FeatureConfiguration> DeferredHolder<Feature<?>, Feature<FC>> registerFeature(String name, Feature<FC> feature) {
    return FEATURES.register(name, () -> feature);
  }

  public static class StateProviders {

    public static final DeferredRegister<BlockStateProviderType<?>> TYPES = DeferredRegister.create(BuiltInRegistries.BLOCKSTATE_PROVIDER_TYPE, ProjectVibrantJourneys.MOD_ID);

    public static final DeferredHolder<BlockStateProviderType<?>, BlockStateProviderType<DirectionalStateProvider>> DIRECTIONAL_STATE_PROVIDER = TYPES.register("directional_state_provider", () -> new BlockStateProviderType<>(DirectionalStateProvider.CODEC));
  }
}