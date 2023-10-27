package dev.orderedchaos.projectvibrantjourneys.core.registry;

import com.google.common.collect.ImmutableList;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;

public class PVJPlacements {
  public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, ProjectVibrantJourneys.MOD_ID);

  public static final ResourceKey<PlacedFeature> MOSS_CARPET = createKey("moss_carpet");

  /* OVERWORLD PLANTS */
  public static final ResourceKey<PlacedFeature> SEA_OATS = createKey("sea_oats");
  public static final ResourceKey<PlacedFeature> CATTAILS = createKey("cattails");
  public static final ResourceKey<PlacedFeature> BEACH_GRASS = createKey("beach_grass");
  public static final ResourceKey<PlacedFeature> BARK_MUSHROOM = createKey("bark_mushroom");
  public static final ResourceKey<PlacedFeature> SHORT_GRASS = createKey("short_grass");
  public static final ResourceKey<PlacedFeature> SMALL_CACTUS = createKey("small_cactus");
  public static final ResourceKey<PlacedFeature> ICICLE = createKey("icicle");
  public static final ResourceKey<PlacedFeature> CAVE_ROOTS = createKey("cave_roots");
  public static final ResourceKey<PlacedFeature> REEDS = createKey("reeds");
  public static final ResourceKey<PlacedFeature> PRICKLY_BUSH = createKey("prickly_bush");
  public static final ResourceKey<PlacedFeature> SANDY_SPROUTS = createKey("sandy_sprouts");

  /* GROUNDCOVER */
  public static final ResourceKey<PlacedFeature> TWIGS = createKey("twigs");
  public static final ResourceKey<PlacedFeature> FALLEN_LEAVES = createKey("fallen_leaves");
  public static final ResourceKey<PlacedFeature> DEAD_FALLEN_LEAVES = createKey("dead_fallen_leaves");
  public static final ResourceKey<PlacedFeature> DENSE_DEAD_FALLEN_LEAVES = createKey("dense_dead_fallen_leaves");
  public static final ResourceKey<PlacedFeature> PINECONES = createKey("pinecones");
  public static final ResourceKey<PlacedFeature> SEASHELLS = createKey("seashells");
  public static final ResourceKey<PlacedFeature> OCEAN_FLOOR_SEASHELLS = createKey("ocean_floor_seashells");
  public static final ResourceKey<PlacedFeature> EXTRA_OCEAN_FLOOR_SEASHELLS = createKey("extra_ocean_floor_seashells");
  public static final ResourceKey<PlacedFeature> ROCKS = createKey("rocks");
  public static final ResourceKey<PlacedFeature> ICE_CHUNKS = createKey("ice_chunks");
  public static final ResourceKey<PlacedFeature> BONES = createKey("bones");
  public static final ResourceKey<PlacedFeature> CHARRED_BONES = createKey("charred_bones");
  public static final ResourceKey<PlacedFeature> CAVE_BONES = createKey("cave_bones");
  public static final ResourceKey<PlacedFeature> CAVE_ROCKS = createKey("cave_rocks");

  /* NETHER PLANTS */
  public static final ResourceKey<PlacedFeature> WARPED_NETTLE = createKey("warped_nettle");
  public static final ResourceKey<PlacedFeature> CRIMSON_NETTLE = createKey("crimson_nettle");
  public static final ResourceKey<PlacedFeature> GLOWCAP = createKey("glowcap");
  public static final ResourceKey<PlacedFeature> CINDERCANE = createKey("cindercane");

  /* FALLEN TREES */
  public static final ResourceKey<PlacedFeature> OAK_FALLEN_TREE = createKey("oak_fallen_tree");
  public static final ResourceKey<PlacedFeature> BIRCH_FALLEN_TREE = createKey("birch_fallen_tree");
  public static final ResourceKey<PlacedFeature> SPRUCE_FALLEN_TREE = createKey("spruce_fallen_tree");
  public static final ResourceKey<PlacedFeature> JUNGLE_FALLEN_TREE = createKey("jungle_fallen_tree");
  public static final ResourceKey<PlacedFeature> ACACIA_FALLEN_TREE = createKey("acacia_fallen_tree");
  public static final ResourceKey<PlacedFeature> DARK_OAK_FALLEN_TREE = createKey("dark_oak_fallen_tree");
  public static final ResourceKey<PlacedFeature> CHERRY_FALLEN_TREE = createKey("cherry_fallen_tree");
  public static final ResourceKey<PlacedFeature> MANGROVE_FALLEN_TREE = createKey("mangrove_fallen_tree");

  /* EXTRAS */
  public static final ResourceKey<PlacedFeature> NATURAL_COBWEB = createKey("natural_cobweb");
  public static final ResourceKey<PlacedFeature> EXTRA_SEAGRASS = createKey("extra_seagrass");
  public static final ResourceKey<PlacedFeature> EXTRA_LILYPADS = createKey("extra_lilypads");
  public static final ResourceKey<PlacedFeature> EXTRA_GRASS = createKey("extra_grass");
  public static final ResourceKey<PlacedFeature> TIDE_POOL = createKey("tide_pool");

  public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
    register(context, MOSS_CARPET, holderGetter.getOrThrow(PVJConfiguredFeatures.MOSS_CARPETS), worldSurfaceSquaredWithCount(3));
    register(context, SEA_OATS, holderGetter.getOrThrow(PVJConfiguredFeatures.SEA_OATS), onceEvery(5));
    register(context, CATTAILS, holderGetter.getOrThrow(PVJConfiguredFeatures.CATTAILS), onceEvery(1));
    register(context, BEACH_GRASS, holderGetter.getOrThrow(PVJConfiguredFeatures.BEACH_GRASS), onceEvery(5));
    register(context, BARK_MUSHROOM, holderGetter.getOrThrow(PVJConfiguredFeatures.BARK_MUSHROOM), worldSurfaceSquaredWithCount(30));
    register(context, SHORT_GRASS, holderGetter.getOrThrow(PVJConfiguredFeatures.SHORT_GRASS), worldSurfaceSquaredWithCount(3));
    register(context, SMALL_CACTUS, holderGetter.getOrThrow(PVJConfiguredFeatures.SMALL_CACTUS), RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    register(context, ICICLE, holderGetter.getOrThrow(PVJConfiguredFeatures.ICICLE), CountPlacement.of(150), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
    register(context, CAVE_ROOTS, holderGetter.getOrThrow(PVJConfiguredFeatures.CAVE_ROOTS), CountPlacement.of(188), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
    register(context, REEDS, holderGetter.getOrThrow(PVJConfiguredFeatures.REEDS), onceEvery(1));
    register(context, PRICKLY_BUSH, holderGetter.getOrThrow(PVJConfiguredFeatures.PRICKLY_BUSH), onceEvery(2));
    register(context, TWIGS, holderGetter.getOrThrow(PVJConfiguredFeatures.TWIGS), worldSurfaceSquaredWithCount(3));
    register(context, FALLEN_LEAVES, holderGetter.getOrThrow(PVJConfiguredFeatures.FALLEN_LEAVES), worldSurfaceSquaredWithCount(3));
    register(context, DEAD_FALLEN_LEAVES, holderGetter.getOrThrow(PVJConfiguredFeatures.DEAD_FALLEN_LEAVES), worldSurfaceSquaredWithCount(3));
    register(context, DENSE_DEAD_FALLEN_LEAVES, holderGetter.getOrThrow(PVJConfiguredFeatures.DEAD_FALLEN_LEAVES), worldSurfaceSquaredWithCount(6));
    register(context, PINECONES, holderGetter.getOrThrow(PVJConfiguredFeatures.PINECONES), worldSurfaceSquaredWithCount(2));
    register(context, SEASHELLS, holderGetter.getOrThrow(PVJConfiguredFeatures.SEASHELLS), worldSurfaceSquaredWithCount(2));
    register(context, OCEAN_FLOOR_SEASHELLS, holderGetter.getOrThrow(PVJConfiguredFeatures.SEASHELLS), seagrassPlacement(2));
    register(context, EXTRA_OCEAN_FLOOR_SEASHELLS, holderGetter.getOrThrow(PVJConfiguredFeatures.SEASHELLS), seagrassPlacement(4));
    register(context, ROCKS, holderGetter.getOrThrow(PVJConfiguredFeatures.ROCKS), worldSurfaceSquaredWithCount(2));
    register(context, ICE_CHUNKS, holderGetter.getOrThrow(PVJConfiguredFeatures.ICE_CHUNKS), worldSurfaceSquaredWithCount(1));
    register(context, BONES, holderGetter.getOrThrow(PVJConfiguredFeatures.BONES), worldSurfaceSquaredWithCount(1));
    register(context, CHARRED_BONES, holderGetter.getOrThrow(PVJConfiguredFeatures.CHARRED_BONES), RarityFilter.onAverageOnceEvery(5), CountOnEveryLayerPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    register(context, CAVE_BONES, holderGetter.getOrThrow(PVJConfiguredFeatures.BONES), CountPlacement.of(100), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(4), VerticalAnchor.absolute(60)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    register(context, CAVE_ROCKS, holderGetter.getOrThrow(PVJConfiguredFeatures.ROCKS), CountPlacement.of(250), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(4), VerticalAnchor.absolute(60)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    register(context, WARPED_NETTLE, holderGetter.getOrThrow(PVJConfiguredFeatures.WARPED_NETTLE), RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
    register(context, CRIMSON_NETTLE, holderGetter.getOrThrow(PVJConfiguredFeatures.CRIMSON_NETTLE), RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
    register(context, GLOWCAP, holderGetter.getOrThrow(PVJConfiguredFeatures.GLOWCAP), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    register(context, CINDERCANE, holderGetter.getOrThrow(PVJConfiguredFeatures.CINDERCANE), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    register(context, OAK_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.OAK_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, BIRCH_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.BIRCH_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, SPRUCE_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.SPRUCE_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, JUNGLE_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.JUNGLE_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, ACACIA_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.ACACIA_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, DARK_OAK_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.DARK_OAK_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, CHERRY_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.CHERRY_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, MANGROVE_FALLEN_TREE, holderGetter.getOrThrow(PVJConfiguredFeatures.MANGROVE_FALLEN_TREE), worldSurfaceSquaredWithCount(1));
    register(context, NATURAL_COBWEB, holderGetter.getOrThrow(PVJConfiguredFeatures.NATURAL_COBWEB), worldSurfaceSquaredWithCount(5));
    register(context, EXTRA_SEAGRASS, holderGetter.getOrThrow(AquaticFeatures.SEAGRASS_SLIGHTLY_LESS_SHORT), seagrassPlacement(48));
    register(context, EXTRA_LILYPADS, holderGetter.getOrThrow(PVJConfiguredFeatures.LILYPADS), worldSurfaceSquaredWithCount(4));
    register(context, EXTRA_GRASS, holderGetter.getOrThrow(VegetationFeatures.PATCH_GRASS), NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    register(context, TIDE_POOL, holderGetter.getOrThrow(PVJConfiguredFeatures.TIDE_POOL), CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
    register(context, SANDY_SPROUTS, holderGetter.getOrThrow(PVJConfiguredFeatures.SANDY_SPROUTS), onceEvery(5));
  }

  private static ResourceKey<PlacedFeature> createKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
  }

  public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
    context.register(key, new PlacedFeature(feature, modifiers));
  }

  public static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
    context.register(key, new PlacedFeature(feature, List.of(modifiers)));
  }

  public static List<PlacementModifier> onceEvery(int distance) {
    ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
    builder.add(RarityFilter.onAverageOnceEvery(distance));

    builder.add(InSquarePlacement.spread());
    builder.add(PlacementUtils.HEIGHTMAP);
    builder.add(BiomeFilter.biome());
    return builder.build();
  }

  private static List<PlacementModifier> seagrassPlacement(int count) {
    return List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, CountPlacement.of(count), BiomeFilter.biome());
  }

  public static void init() {
  }

  ;
}