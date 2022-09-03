package com.projectvibrantjourneys.core.registry.world;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.worldSurfaceSquaredWithCount;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;;

public class PVJPlacements {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ProjectVibrantJourneys.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> MOSS_CARPET = register("moss_carpet", PVJConfiguredFeatures.MOSS_CARPETS, worldSurfaceSquaredWithCount(3));
	
	/* OVERWORLD PLANTS */
	public static final RegistryObject<PlacedFeature> SEA_OATS = register("sea_oats", PVJConfiguredFeatures.SEA_OATS, onceEvery(5));
	public static final RegistryObject<PlacedFeature> CATTAILS = register("cattails", PVJConfiguredFeatures.CATTAILS, onceEvery(1));
	public static final RegistryObject<PlacedFeature> BEACH_GRASS = register("beach_grass", PVJConfiguredFeatures.BEACH_GRASS, onceEvery(5));
	public static final RegistryObject<PlacedFeature> BARK_MUSHROOM = register("bark_mushroom", PVJConfiguredFeatures.BARK_MUSHROOM, worldSurfaceSquaredWithCount(30));
	public static final RegistryObject<PlacedFeature> SHORT_GRASS = register("short_grass", PVJConfiguredFeatures.SHORT_GRASS, worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> SMALL_CACTUS = register("small_cactus", PVJConfiguredFeatures.SMALL_CACTUS, RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	
	/* GROUNDCOVER */
	public static final RegistryObject<PlacedFeature> TWIGS = register("twigs", PVJConfiguredFeatures.TWIGS, worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> FALLEN_LEAVES = register("fallen_leaves", PVJConfiguredFeatures.FALLEN_LEAVES, worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> DEAD_FALLEN_LEAVES = register("dead_fallen_leaves", PVJConfiguredFeatures.DEAD_FALLEN_LEAVES, worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> DENSE_DEAD_FALLEN_LEAVES = register("dense_dead_fallen_leaves", PVJConfiguredFeatures.DEAD_FALLEN_LEAVES, worldSurfaceSquaredWithCount(6));
	public static final RegistryObject<PlacedFeature> PINECONES = register("pinecones", PVJConfiguredFeatures.PINECONES, worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> SEASHELLS = register("seashells", PVJConfiguredFeatures.SEASHELLS, worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> OCEAN_FLOOR_SEASHELLS = register("ocean_floor_seashells", PVJConfiguredFeatures.SEASHELLS, AquaticPlacements.seagrassPlacement(2));
	public static final RegistryObject<PlacedFeature> EXTRA_OCEAN_FLOOR_SEASHELLS = register("extra_ocean_floor_seashells", PVJConfiguredFeatures.SEASHELLS, AquaticPlacements.seagrassPlacement(4));
	public static final RegistryObject<PlacedFeature> ROCKS = register("rocks", PVJConfiguredFeatures.ROCKS, worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> ICE_CHUNKS = register("ice_chunks", PVJConfiguredFeatures.ICE_CHUNKS, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> BONES = register("bones", PVJConfiguredFeatures.BONES, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> CHARRED_BONES = register("charred_bones", PVJConfiguredFeatures.CHARRED_BONES, RarityFilter.onAverageOnceEvery(5), CountOnEveryLayerPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	
	/* NETHER PLANTS */
	public static final RegistryObject<PlacedFeature> WARPED_NETTLE = register("warped_nettle", PVJConfiguredFeatures.WARPED_NETTLE, RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> CRIMSON_NETTLE = register("crimson_nettle", PVJConfiguredFeatures.CRIMSON_NETTLE, RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> GLOWCAP = register("glowcap", PVJConfiguredFeatures.GLOWCAP, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> CINDERCANE = register("cindercane", PVJConfiguredFeatures.CINDERCANE, InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	
	/* FALLEN TREES */
	public static final RegistryObject<PlacedFeature> OAK_FALLEN_TREE = register("oak_fallen_tree", PVJConfiguredFeatures.OAK_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> BIRCH_FALLEN_TREE = register("birch_fallen_tree", PVJConfiguredFeatures.BIRCH_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> SPRUCE_FALLEN_TREE = register("spruce_fallen_tree", PVJConfiguredFeatures.SPRUCE_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> JUNGLE_FALLEN_TREE = register("jungle_fallen_tree", PVJConfiguredFeatures.JUNGLE_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> ACACIA_FALLEN_TREE = register("acacia_fallen_tree", PVJConfiguredFeatures.ACACIA_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> DARK_OAK_FALLEN_TREE = register("dark_oak_fallen_tree", PVJConfiguredFeatures.DARK_OAK_FALLEN_TREE, worldSurfaceSquaredWithCount(1));
	
	/* EXTRAS */
	public static final RegistryObject<PlacedFeature> NATURAL_COBWEB = register("natural_cobweb", PVJConfiguredFeatures.NATURAL_COBWEB, worldSurfaceSquaredWithCount(5));
//	public static final RegistryObject<PlacedFeature> EXTRA_SEAGRASS = register("extra_seagrass", AquaticFeatures.SEAGRASS_SLIGHTLY_LESS_SHORT, AquaticPlacements.seagrassPlacement(48));
//	public static final RegistryObject<PlacedFeature> EXTRA_LILYPADS = register("extra_lilypads", VegetationFeatures.PATCH_WATERLILY, worldSurfaceSquaredWithCount(4));
//	public static final RegistryObject<PlacedFeature> EXTRA_GRASS = register("extra_grass", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
	public static final RegistryObject<PlacedFeature> EXTRA_SEAGRASS = copy("extra_seagrass", AquaticPlacements.SEAGRASS_RIVER);
	public static final RegistryObject<PlacedFeature> EXTRA_LILYPADS = register("extra_lilypads", PVJConfiguredFeatures.LILYPADS, worldSurfaceSquaredWithCount(4));
	public static final RegistryObject<PlacedFeature> EXTRA_GRASS = copy("extra_grass", VegetationPlacements.PATCH_GRASS_PLAIN);
	public static final RegistryObject<PlacedFeature> TIDE_POOL = register("tide_pool", PVJConfiguredFeatures.TIDE_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	
	private static RegistryObject<PlacedFeature> copy(String name, Holder<PlacedFeature> placedFeature) {
		return register(name, placedFeature.value().feature(), placedFeature.value().placement());
	}
	
	private static <T extends FeatureConfiguration> RegistryObject<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return PLACED_FEATURES.register(name, () -> new PlacedFeature(Holder.hackyErase(feature), modifiers));
	}
	
	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return PLACED_FEATURES.register(name, () -> new PlacedFeature(Holder.hackyErase(feature.getHolder().orElseThrow()), modifiers));
	}

	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
		return register(name, feature, List.of(modifiers));
	}
	
	public static List<PlacementModifier> onceEvery(int distance) {
		Builder<PlacementModifier> builder = ImmutableList.builder();
		builder.add(RarityFilter.onAverageOnceEvery(distance));

		builder.add(InSquarePlacement.spread());
		builder.add(PlacementUtils.HEIGHTMAP);
		builder.add(BiomeFilter.biome());
		return builder.build();
	}
	
	public static void init() {};
}
