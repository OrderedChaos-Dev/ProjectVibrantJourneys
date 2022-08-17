package com.projectvibrantjourneys.init.world.placements;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.world.features.PVJConfiguredFeatures;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
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
	
	public static final RegistryObject<PlacedFeature> TWIGS = register("twigs", PVJConfiguredFeatures.TWIGS, VegetationPlacements.worldSurfaceSquaredWithCount(3));
	public static final RegistryObject<PlacedFeature> FALLEN_LEAVES = register("fallen_leaves", PVJConfiguredFeatures.FALLEN_LEAVES, VegetationPlacements.worldSurfaceSquaredWithCount(3));
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
