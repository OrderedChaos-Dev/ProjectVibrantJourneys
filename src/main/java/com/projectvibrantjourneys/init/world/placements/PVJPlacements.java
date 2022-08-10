package com.projectvibrantjourneys.init.world.placements;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.world.features.PVJConfiguredFeatures;
import com.projectvibrantjourneys.init.world.features.PVJVegetationFeatures;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PVJPlacements {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ProjectVibrantJourneys.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> SEA_OATS = register("sea_oats", PVJConfiguredFeatures.SEA_OATS, onceEvery(5));
	public static final RegistryObject<PlacedFeature> CATTAILS = register("cattails", PVJConfiguredFeatures.CATTAILS, onceEvery(1));
	public static final RegistryObject<PlacedFeature> BEACH_GRASS = register("beach_grass", PVJConfiguredFeatures.BEACH_GRASS, onceEvery(5));
	public static final RegistryObject<PlacedFeature> BARK_MUSHROOM = register("bark_mushroom", PVJConfiguredFeatures.BARK_MUSHROOM, VegetationPlacements.worldSurfaceSquaredWithCount(30));
	public static final RegistryObject<PlacedFeature> SHORT_GRASS = register("short_grass", PVJConfiguredFeatures.SHORT_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> NATURAL_COBWEB = register("natural_cobweb", PVJConfiguredFeatures.NATURAL_COBWEB, VegetationPlacements.worldSurfaceSquaredWithCount(5));
	public static final RegistryObject<PlacedFeature> SMALL_CACTUS = register("small_cactus", PVJConfiguredFeatures.SMALL_CACTUS, RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> DESERT_SAGE = register("desert_sage", PVJConfiguredFeatures.DESERT_SAGE, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> DRY_GRASS = register("dry_grass", PVJConfiguredFeatures.DRY_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(10));
	public static final RegistryObject<PlacedFeature> PRAIRIE_GRASS = register("prairie_grass", PVJConfiguredFeatures.PRAIRIE_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(32));
	public static final RegistryObject<PlacedFeature> SPRUCE_BUSH = register("spruce_bush", PVJConfiguredFeatures.SPRUCE_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
	
	public static final RegistryObject<PlacedFeature> TWIGS = register("twigs", PVJConfiguredFeatures.TWIGS, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> FALLEN_LEAVES = register("fallen_leaves", PVJConfiguredFeatures.FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> WHITE_SAKURA_FALLEN_LEAVES = register("white_sakura_fallen_leaves", PVJConfiguredFeatures.WHITE_SAKURA_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> PINK_SAKURA_FALLEN_LEAVES = register("pink_sakura_fallen_leaves", PVJConfiguredFeatures.PINK_SAKURA_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> ASPEN_FALLEN_LEAVES = register("aspen_fallen_leaves", PVJConfiguredFeatures.ASPEN_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> RED_MAPLE_FALLEN_LEAVES = register("red_maple_fallen_leaves", PVJConfiguredFeatures.RED_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> ORANGE_MAPLE_FALLEN_LEAVES = register("orange_maple_fallen_leaves", PVJConfiguredFeatures.ORANGE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> PURPLE_MAPLE_FALLEN_LEAVES = register("purple_maple_fallen_leaves", PVJConfiguredFeatures.PURPLE_MAPLE_FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> PINECONES = register("pinecones", PVJConfiguredFeatures.PINECONES, VegetationPlacements.worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> SEASHELLS = register("seashells", PVJConfiguredFeatures.SEASHELLS, VegetationPlacements.worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> OCEAN_FLOOR_SEASHELLS = register("ocean_floor_seashells", PVJConfiguredFeatures.SEASHELLS, AquaticPlacements.seagrassPlacement(2));
	public static final RegistryObject<PlacedFeature> EXTRA_OCEAN_FLOOR_SEASHELLS = register("extra_ocean_floor_seashells", PVJConfiguredFeatures.SEASHELLS, AquaticPlacements.seagrassPlacement(4));
	public static final RegistryObject<PlacedFeature> ROCKS = register("rocks", PVJConfiguredFeatures.ROCKS, VegetationPlacements.worldSurfaceSquaredWithCount(2));
	public static final RegistryObject<PlacedFeature> ICE_CHUNKS = register("ice_chunks", PVJConfiguredFeatures.ICE_CHUNKS, VegetationPlacements.worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> BONES = register("bones", PVJConfiguredFeatures.BONES, VegetationPlacements.worldSurfaceSquaredWithCount(1));
	public static final RegistryObject<PlacedFeature> CHARRED_BONES = register("charred_bones", PVJConfiguredFeatures.CHARRED_BONES, RarityFilter.onAverageOnceEvery(5), CountOnEveryLayerPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	
	public static final RegistryObject<PlacedFeature> WARPED_NETTLE = register("warped_nettle", PVJConfiguredFeatures.WARPED_NETTLE, RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> CRIMSON_NETTLE = register("crimson_nettle", PVJConfiguredFeatures.CRIMSON_NETTLE, RarityFilter.onAverageOnceEvery(4), CountOnEveryLayerPlacement.of(2), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> GLOWCAP = register("glowcap", PVJConfiguredFeatures.GLOWCAP, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> CINDERCANE = register("cindercane", PVJConfiguredFeatures.CINDERCANE, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
	
	public static final RegistryObject<PlacedFeature> CRYSTAL_POOL = register("crystal_pool", PVJConfiguredFeatures.CRYSTAL_POOL, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> AMETHYST_CRYSTALS = register("amethyst_crystals", PVJConfiguredFeatures.AMETHYST_CRYSTALS, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	
	public static final RegistryObject<PlacedFeature> TREES_PALM = register("trees_palm", PVJVegetationFeatures.TREES_PALM, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> TREES_JUNIPER = register("trees_juniper", PVJVegetationFeatures.TREES_PALM, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.05F, 1)));
	public static final RegistryObject<PlacedFeature> EXTRA_VEGETATION_LUSH_CAVES = register("extra_vegetation_lush_caves", PVJVegetationFeatures.EXTRA_VEGETATION_LUSH_CAVES, CountPlacement.of(20), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final RegistryObject<PlacedFeature> PINE_MEADOWS_TREES = register("pine_meadows_trees", PVJVegetationFeatures.PINE_MEADOWS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 2)));
	public static final RegistryObject<PlacedFeature> AUTUMNAL_CONIFEROUS_TREES = register("autumnal_coniferous_trees", PVJVegetationFeatures.AUTUMNAL_CONIFEROUS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BOREAL_FOREST_TREES = register("boreal_forest_trees", PVJVegetationFeatures.BOREAL_FOREST_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> DESERT_SHRUBLAND_TREES = register("desert_shrubland_trees", PVJVegetationFeatures.DESERT_SHRUBLAND_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> OVERGROWN_SPIRES_TREES = register("overgrown_spires_trees", PVJVegetationFeatures.OVERGROWN_SPIRES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BAOBAB_FIELDS_TREES = register("baobab_field_trees", PVJVegetationFeatures.BAOBAB_FIELDs_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> PRAIRIE_TREES = register("prairie_trees", PVJVegetationFeatures.PRAIRIE_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> REDWOOD_FOREST_TREES = register("redwood_forest_trees", PVJVegetationFeatures.REDWOOD_FOREST_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> CRYSTAL_LAKES_TREES = register("crystal_lakes_trees", PVJVegetationFeatures.CRYSTAL_LAKES_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
	public static final RegistryObject<PlacedFeature> BLOSSOMING_FIELDS_TREES = register("blossoming_fields_trees", PVJVegetationFeatures.BLOSSOMING_FIELDS_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)));
	public static final RegistryObject<PlacedFeature> ASPEN_GROVE_TREES = register("aspen_grove_trees", PVJVegetationFeatures.ASPEN_GROVE_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2F, 1)));
//	public static final RegistryObject<PlacedFeature> LUSH_CACTUS = register("lush_cactus", VegetationFeatures.PATCH_CACTUS, PVJPlacements.onceEvery(2));
	public static final RegistryObject<PlacedFeature> DESERT_AGAVE = register("desert_agave", PVJVegetationFeatures.DESERT_AGAVE, PVJPlacements.onceEvery(16));
	
	public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
		return PLACED_FEATURES.register(name, () -> new PlacedFeature(feature.getHolder().orElseThrow(), modifiers));
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
