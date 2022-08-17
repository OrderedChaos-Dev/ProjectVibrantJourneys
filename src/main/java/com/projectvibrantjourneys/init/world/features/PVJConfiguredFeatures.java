package com.projectvibrantjourneys.init.world.features;

import java.util.List;
import java.util.function.Supplier;

import com.projectvibrantjourneys.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.object.PVJBlocks;
import com.projectvibrantjourneys.world.gen.features.stateproviders.DirectionalStateProvider;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PVJConfiguredFeatures {
	
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ProjectVibrantJourneys.MOD_ID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> BEACH_GRASS = register("beach_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.beach_grass.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEA_OATS = register("sea_oats", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.sea_oats.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CATTAILS = register("cattails", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(128, 7, 2, PVJBlocks.cattail.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BARK_MUSHROOM = register("bark_mushroom", () -> new ConfiguredFeature<>(PVJFeatures.BARK_MUSHROOM.get(), new SimpleBlockConfiguration(BlockStateProvider.simple(PVJBlocks.bark_mushroom.get()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> NATURAL_COBWEB = register("natural_cobweb", () -> new ConfiguredFeature<>(PVJFeatures.NATURAL_COBWEB.get(), new ProbabilityFeatureConfiguration(0.1F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SHORT_GRASS = register("short_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PVJBlocks.short_grass.get()), ShortGrassBlock.MODEL, UniformInt.of(0, 6))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_CACTUS = register("small_cactus", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(8, 7, 3, PVJBlocks.small_cactus.get().defaultBlockState())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TWIGS = register("twigs", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.twigs.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FALLEN_LEAVES = register("fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINECONES = register("pinecones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.pinecones.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEASHELLS = register("seashells", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.seashells.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ROCKS = register("rocks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(4, 7, 3, PlacementUtils.filtered(PVJFeatures.ROCKS.get(), NoneFeatureConfiguration.INSTANCE,
																			BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
																					BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICE_CHUNKS = register("ice_chunks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.ice_chunks.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BONES = register("bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(1, 7, 3, PVJBlocks.bones.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_BONES = register("charred_bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(50, 7, 3, PVJBlocks.charred_bones.get())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> WARPED_NETTLE = register("warped_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.warped_nettle.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRIMSON_NETTLE = register("crimson_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.crimson_nettle.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CINDERCANE = register("cindercane", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, columnPlantWithFluid(256, 7, 3, PVJBlocks.cindercane.get(), Fluids.LAVA, Fluids.FLOWING_LAVA)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWCAP = register("glowcap", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.glowcap.get().defaultBlockState())));

	public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<?, ?>> register(String name, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
		return CONFIGURED_FEATURES.register(name, configuredFeature);
	}
	
	private static RandomPatchConfiguration createRandomPatchFeature(int tries, int xzSpread, int ySpread, BlockState block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
				new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration createGroundcoverPatchFeature(int tries, int xzSpread, int ySpread, Block block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
		      new SimpleBlockConfiguration(new RandomizedIntStateProvider(new DirectionalStateProvider(block), GroundcoverBlock.MODEL, UniformInt.of(0, 4))),
		    		  BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration simpleRandomPatch(BlockState blockstate) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(blockstate)));
	}
	
	public static RandomPatchConfiguration simpleRandomPatch(BlockStateProvider provider) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider));
	}
	
	private static RandomPatchConfiguration columnPlantWithFluid(int tries, int xzspread, int yspread, Block block, Fluid fluid1, Fluid fluid2) {
		return new RandomPatchConfiguration(tries, xzspread, yspread, PlacementUtils.filtered(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 4), BlockStateProvider.simple(block)),
		    		  BlockPredicate.allOf(BlockPredicate.matchesBlock(Blocks.AIR, BlockPos.ZERO),
		    				  BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO),
		    				  BlockPredicate.anyOf(BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    						  new BlockPos(1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    								  new BlockPos(-1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    										  new BlockPos(0, -1, 1)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2), new BlockPos(0, -1, -1))))));
	}

}
