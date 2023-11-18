package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.ShortGrassBlock;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.FallenTreeConfiguration.FallenTreeVegetation;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations.MultipleVegetationPatchConfiguration;
import dev.orderedchaos.projectvibrantjourneys.common.world.features.stateproviders.DirectionalStateProvider;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;
import java.util.Optional;

public class PVJConfiguredFeatures {
  public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, ProjectVibrantJourneys.MOD_ID);

  public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS_CARPETS = createKey("moss_carpet");
  public static final ResourceKey<ConfiguredFeature<?, ?>> LILYPADS = createKey("lilypads");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_ROOTS = createKey("cave_roots");

  public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_GRASS = createKey("beach_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_OATS = createKey("sea_oats");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CATTAILS = createKey("cattails");
  public static final ResourceKey<ConfiguredFeature<?, ?>> BARK_MUSHROOM = createKey("bark_mushroom");
  public static final ResourceKey<ConfiguredFeature<?, ?>> NATURAL_COBWEB = createKey("natural_cobweb");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_GRASS = createKey("short_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_CACTUS = createKey("small_cactus");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE = createKey("icicle");
  public static final ResourceKey<ConfiguredFeature<?, ?>> REEDS = createKey("reeds");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PRICKLY_BUSH = createKey("prickly_bush");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SANDY_SPROUTS = createKey("sandy_sprouts");

  public static final ResourceKey<ConfiguredFeature<?, ?>> TWIGS = createKey("twigs");
  public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_LEAVES = createKey("fallen_leaves");
  public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_FALLEN_LEAVES = createKey("dead_fallen_leaves");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PINECONES = createKey("pinecones");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SEASHELLS = createKey("seashells");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKS = createKey("rocks");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ICE_CHUNKS = createKey("ice_chunks");
  public static final ResourceKey<ConfiguredFeature<?, ?>> BONES = createKey("bones");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CHARRED_BONES = createKey("charred_bones");

  public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_NETTLE = createKey("warped_nettle");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_NETTLE = createKey("crimson_nettle");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CINDERCANE = createKey("cindercane");
  public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWCAP = createKey("glowcap");

  public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_FALLEN_TREE = createKey("oak_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_FALLEN_TREE = createKey("birch_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_FALLEN_TREE = createKey("spruce_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_FALLEN_TREE = createKey("jungle_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA_FALLEN_TREE = createKey("acacia_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_OAK_FALLEN_TREE = createKey("dark_oak_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_FALLEN_TREE = createKey("cherry_fallen_tree");
  public static final ResourceKey<ConfiguredFeature<?, ?>> MANGROVE_FALLEN_TREE = createKey("mangrove_fallen_tree");

  public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_PICKLE = createKey("sea_pickle");
  public static final ResourceKey<ConfiguredFeature<?, ?>> TIDE_POOL = createKey("tide_pool");

  public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

    final RandomizedIntStateProvider SHORT_GRASS_STATE_PROVIDER = new RandomizedIntStateProvider(
      BlockStateProvider.simple(PVJBlocks.SHORT_GRASS.get()),
      ShortGrassBlock.MODEL,
      UniformInt.of(0, 6)
    );
    final RandomizedIntStateProvider PINECONES_STATE_PROVIDER = new RandomizedIntStateProvider(
      BlockStateProvider.simple(PVJBlocks.SHORT_GRASS.get()),
      GroundcoverBlock.MODEL,
      UniformInt.of(0, 4)
    );
    final RandomizedIntStateProvider PINK_PETALS_STATE_PROVIDER = new RandomizedIntStateProvider(
      BlockStateProvider.simple(Blocks.PINK_PETALS),
      PinkPetalsBlock.AMOUNT,
      UniformInt.of(PinkPetalsBlock.MIN_FLOWERS, PinkPetalsBlock.MAX_FLOWERS)
    );
    final List<FallenTreeVegetation> BASIC_FALLEN_TREE_VEGETATION = List.of(
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.GRASS), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.RED_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.MOSS_CARPET), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(PVJBlocks.FALLEN_LEAVES.get()), Optional.of("enableFallenLeaves")),
      new FallenTreeVegetation(SHORT_GRASS_STATE_PROVIDER, Optional.of("enableShortGrass"))
    );
    final List<FallenTreeVegetation> SPRUCE_FALLEN_TREE_VEGETATION = List.of(
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.GRASS), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.FERN), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.RED_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.MOSS_CARPET), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(PVJBlocks.FALLEN_LEAVES.get()), Optional.of("enableFallenLeaves")),
      new FallenTreeVegetation(PINECONES_STATE_PROVIDER, Optional.of("enablePinecones")),
      new FallenTreeVegetation(SHORT_GRASS_STATE_PROVIDER, Optional.of("enableShortGrass"))
    );
    final List<FallenTreeVegetation> ACACIA_FALLEN_TREE_VEGETATION = List.of(
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.GRASS), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.RED_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(PVJBlocks.FALLEN_LEAVES.get()), Optional.of("enableFallenLeaves")),
      new FallenTreeVegetation(SHORT_GRASS_STATE_PROVIDER, Optional.of("enableShortGrass"))
    );
    final List<FallenTreeVegetation> DARK_OAK_FALLEN_TREE_VEGETATION = List.of(
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.GRASS), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.FERN), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.RED_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.MOSS_CARPET), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(PVJBlocks.FALLEN_LEAVES.get()), Optional.of("enableFallenLeaves")),
      new FallenTreeVegetation(SHORT_GRASS_STATE_PROVIDER, Optional.of("enableShortGrass"))
    );
    final List<FallenTreeVegetation> CHERRY_FALLEN_TREE_VEGETATION = List.of(
      new FallenTreeVegetation(BlockStateProvider.simple(Blocks.GRASS), Optional.empty()),
      new FallenTreeVegetation(BlockStateProvider.simple(PVJBlocks.FALLEN_LEAVES.get()), Optional.of("enableFallenLeaves")),
      new FallenTreeVegetation(PINK_PETALS_STATE_PROVIDER, Optional.empty()),
      new FallenTreeVegetation(SHORT_GRASS_STATE_PROVIDER, Optional.of("enableShortGrass"))
    );

    HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
    register(context, MOSS_CARPETS, Feature.RANDOM_PATCH, mossCarpetConfig(10, 7, 2, Blocks.MOSS_CARPET));
    register(context, LILYPADS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(24, 7, 3, PlacementUtils.onlyWhenEmpty(PVJFeatures.LILYPAD.get(), new ProbabilityFeatureConfiguration(0.75F))));
    register(context, CAVE_ROOTS, Feature.RANDOM_PATCH, new RandomPatchConfiguration(2, 2, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.HANGING_ROOTS)), BlockPredicate.matchesTag(new BlockPos(0, -1, 0), BlockTags.DIRT))));

    register(context, BEACH_GRASS, Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.BEACH_GRASS.get().defaultBlockState()));
    register(context, SEA_OATS, Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.SEA_OATS.get().defaultBlockState()));
    register(context, CATTAILS, Feature.RANDOM_PATCH, cattailConfig(128, 7, 2, PVJBlocks.CATTAIL.get().defaultBlockState()));
    register(context, BARK_MUSHROOM, PVJFeatures.BARK_MUSHROOM.get(), NoneFeatureConfiguration.INSTANCE);
    register(context, NATURAL_COBWEB, PVJFeatures.NATURAL_COBWEB.get(), new ProbabilityFeatureConfiguration(0.1F));
    register(context, SHORT_GRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PVJBlocks.SHORT_GRASS.get()), ShortGrassBlock.MODEL, UniformInt.of(0, 6)))));
    register(context, SMALL_CACTUS, Feature.RANDOM_PATCH, randomPatchConfig(8, 7, 3, PVJBlocks.SMALL_CACTUS.get().defaultBlockState()));
    register(context, ICICLE, PVJFeatures.ICICLE.get(), NoneFeatureConfiguration.INSTANCE);
    register(context, REEDS, Feature.RANDOM_PATCH, cattailConfig(250, 12, 2, PVJBlocks.REEDS.get().defaultBlockState()));
    register(context, PRICKLY_BUSH, Feature.RANDOM_PATCH, randomPatchConfig(10, 7, 3, PVJBlocks.PRICKLY_BUSH.get().defaultBlockState()));
    register(context, SANDY_SPROUTS, Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.SANDY_SPROUTS.get().defaultBlockState()));

    register(context, TWIGS, Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.TWIGS.get()));
    register(context, FALLEN_LEAVES, Feature.RANDOM_PATCH, randomPatchConfig(4, 7, 3, PVJBlocks.FALLEN_LEAVES.get().defaultBlockState()));
    register(context, DEAD_FALLEN_LEAVES, Feature.RANDOM_PATCH, randomPatchConfig(3, 7, 3, PVJBlocks.DEAD_FALLEN_LEAVES.get().defaultBlockState()));
    register(context, PINECONES, Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.PINECONES.get()));
    register(context, SEASHELLS, Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.SEASHELLS.get()));
    register(context, ROCKS, PVJFeatures.ROCKS.get(), groundcoverConfig(4, 7, 3, PVJBlocks.ROCKS.get()));
    register(context, ICE_CHUNKS, Feature.RANDOM_PATCH, iceChunksConfig(4, 7, 3, PVJBlocks.ICE_CHUNKS.get()));
    register(context, BONES, Feature.RANDOM_PATCH, groundcoverConfig(1, 7, 3, PVJBlocks.BONES.get()));
    register(context, CHARRED_BONES, Feature.RANDOM_PATCH, groundcoverConfig(50, 7, 3, PVJBlocks.CHARRED_BONES.get()));

    register(context, WARPED_NETTLE, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.WARPED_NETTLE.get()), 8, 4));
    register(context, CRIMSON_NETTLE, Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.CRIMSON_NETTLE.get()), 8, 4));
    register(context, CINDERCANE, Feature.RANDOM_PATCH, columnPlantWithFluid(256, 7, 3, PVJBlocks.CINDERCANE.get(), Fluids.LAVA, Fluids.FLOWING_LAVA));
    register(context, GLOWCAP, Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.GLOWCAP.get().defaultBlockState()));

    register(context, OAK_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.OAK_HOLLOW_LOG.get(), Blocks.OAK_LOG, BASIC_FALLEN_TREE_VEGETATION, true));
    register(context, BIRCH_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.BIRCH_HOLLOW_LOG.get(), Blocks.BIRCH_LOG, BASIC_FALLEN_TREE_VEGETATION, true));
    register(context, SPRUCE_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.SPRUCE_HOLLOW_LOG.get(), Blocks.SPRUCE_LOG, SPRUCE_FALLEN_TREE_VEGETATION, true));
    register(context, JUNGLE_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.JUNGLE_HOLLOW_LOG.get(), Blocks.JUNGLE_LOG, BASIC_FALLEN_TREE_VEGETATION, true));
    register(context, ACACIA_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.ACACIA_HOLLOW_LOG.get(), Blocks.ACACIA_LOG, ACACIA_FALLEN_TREE_VEGETATION, false));
    register(context, DARK_OAK_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), Blocks.DARK_OAK_LOG, DARK_OAK_FALLEN_TREE_VEGETATION, true));
    register(context, CHERRY_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.CHERRY_HOLLOW_LOG.get(), Blocks.CHERRY_LOG, CHERRY_FALLEN_TREE_VEGETATION, false));
    register(context, MANGROVE_FALLEN_TREE, PVJFeatures.FALLEN_TREE.get(), fallenTreeConfig(PVJBlocks.MANGROVE_HOLLOW_LOG.get(), Blocks.MANGROVE_LOG, BASIC_FALLEN_TREE_VEGETATION, true));

    register(context, SEA_PICKLE, Feature.SEA_PICKLE, new CountConfiguration(1));
    register(context, TIDE_POOL, PVJFeatures.POOL.get(), new MultipleVegetationPatchConfiguration(
      BlockTags.LUSH_GROUND_REPLACEABLE,
      BlockStateProvider.simple(Blocks.STONE),
      0.15F,
      List.of(PlacementUtils.inlinePlaced(
          holderGetter.getOrThrow(SEA_PICKLE)),
        PlacementUtils.inlinePlaced(holderGetter.getOrThrow(AquaticFeatures.SEAGRASS_TALL)),
        PlacementUtils.inlinePlaced(holderGetter.getOrThrow(AquaticFeatures.KELP)),
        PlacementUtils.inlinePlaced(holderGetter.getOrThrow(AquaticFeatures.KELP))),
      CaveSurface.FLOOR,
      ConstantInt.of(3),
      1F,
      5,
      0.3F,
      UniformInt.of(2, 3), 0.7F));

  }

  private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
    return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
  }

  private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
    context.register(key, new ConfiguredFeature<>(feature, config));
  }

  private static RandomPatchConfiguration randomPatchConfig(int tries, int xzSpread, int ySpread, BlockState block) {
    return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
      PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
      new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(
        BlockPredicate.replaceable(),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SNOW)),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SNOW, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.LAVA, Blocks.WATER)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.LAVA, Fluids.WATER))
      )
    ));
  }

  private static RandomPatchConfiguration cattailConfig(int tries, int xzSpread, int ySpread, BlockState block) {
    return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
      PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
      new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(
        BlockPredicate.replaceable(),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SNOW)),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SNOW, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.LAVA)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.LAVA))
      )
    ));
  }

  private static RandomPatchConfiguration groundcoverConfig(int tries, int xzSpread, int ySpread, Block block) {
    return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
      PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
      new SimpleBlockConfiguration(new RandomizedIntStateProvider(new DirectionalStateProvider(block), GroundcoverBlock.MODEL, UniformInt.of(0, 4))),
      BlockPredicate.allOf(
        BlockPredicate.replaceable(),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SNOW, Blocks.AMETHYST_BLOCK)),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SNOW, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.LAVA)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.LAVA))
      )
    ));
  }

  private static RandomPatchConfiguration iceChunksConfig(int tries, int xzSpread, int ySpread, Block block) {
    return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
      PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
      new SimpleBlockConfiguration(new RandomizedIntStateProvider(new DirectionalStateProvider(block), GroundcoverBlock.MODEL, UniformInt.of(0, 4))),
      BlockPredicate.allOf(
        BlockPredicate.replaceable(),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW)),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SNOW, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.LAVA)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.LAVA))
      )
    ));
  }

  private static RandomPatchConfiguration mossCarpetConfig(int tries, int xzSpread, int ySpread, Block block) {
    return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(
      PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
      new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
      BlockPredicate.allOf(
        BlockPredicate.replaceable(),
        BlockPredicate.not(BlockPredicate.replaceable(Direction.DOWN.getNormal())),
        BlockPredicate.hasSturdyFace(Direction.DOWN.getNormal(), Direction.UP),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.SNOW, Blocks.WATER)),
        BlockPredicate.not(BlockPredicate.matchesBlocks(Blocks.SNOW, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.LAVA)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Direction.DOWN.getNormal(), Fluids.WATER)),
        BlockPredicate.not(BlockPredicate.matchesFluids(Fluids.LAVA))
      )
    ));
  }

  private static FallenTreeConfiguration fallenTreeConfig(Block hollowLog, Block baseLog, List<FallenTreeVegetation> vegetationProviders, boolean canBeMossy) {
    return new FallenTreeConfiguration(hollowLog.defaultBlockState(), baseLog.defaultBlockState(), vegetationProviders, canBeMossy);
  }

  private static RandomPatchConfiguration simpleRandomPatch(BlockState blockstate) {
    return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(blockstate)));
  }

  public static RandomPatchConfiguration simpleRandomPatch(BlockStateProvider provider) {
    return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider));
  }

  private static RandomPatchConfiguration columnPlantWithFluid(int tries, int xzspread, int yspread, Block block, Fluid... fluids) {
    return new RandomPatchConfiguration(tries, xzspread, yspread, PlacementUtils.filtered(
      Feature.BLOCK_COLUMN,
      BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 4), BlockStateProvider.simple(block)),
      BlockPredicate.allOf(
        BlockPredicate.matchesBlocks(BlockPos.ZERO, Blocks.AIR),
        BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO),
        BlockPredicate.anyOf(
          BlockPredicate.matchesFluids(new BlockPos(1, -1, 0), List.of(fluids)),
          BlockPredicate.matchesFluids(new BlockPos(1, -1, 0), List.of(fluids)),
          BlockPredicate.matchesFluids(new BlockPos(-1, -1, 0), List.of(fluids)),
          BlockPredicate.matchesFluids(new BlockPos(0, -1, 1), List.of(fluids)),
          BlockPredicate.matchesFluids(new BlockPos(0, -1, -1), List.of(fluids))
        )
      )
    ));
  }

}