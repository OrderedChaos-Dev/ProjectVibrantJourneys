package com.projectvibrantjourneys.core.registry.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.common.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.common.world.features.configs.FallenTreeConfiguration;
import com.projectvibrantjourneys.common.world.features.stateproviders.DirectionalStateProvider;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.core.registry.PVJBlocks;
import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils.WeightedBiomeEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

	public static final RegistryObject<ConfiguredFeature<?, ?>> MOSS_CARPETS = register("moss_carpet", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, mossCarpetConfig(10, 7, 2, Blocks.MOSS_CARPET)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> BEACH_GRASS = register("beach_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.BEACH_GRASS.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEA_OATS = register("sea_oats", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.SEA_OATS.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CATTAILS = register("cattails", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, cattailConfig(128, 7, 2, PVJBlocks.CATTAIL.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BARK_MUSHROOM = register("bark_mushroom", () -> new ConfiguredFeature<>(PVJFeatures.BARK_MUSHROOM.get(), NoneFeatureConfiguration.INSTANCE));
	public static final RegistryObject<ConfiguredFeature<?, ?>> NATURAL_COBWEB = register("natural_cobweb", () -> new ConfiguredFeature<>(PVJFeatures.NATURAL_COBWEB.get(), new ProbabilityFeatureConfiguration(0.1F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SHORT_GRASS = register("short_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PVJBlocks.SHORT_GRASS.get()), ShortGrassBlock.MODEL, UniformInt.of(0, 6))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_CACTUS = register("small_cactus", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, randomPatchConfig(8, 7, 3, PVJBlocks.SMALL_CACTUS.get().defaultBlockState())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TWIGS = register("twigs", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.TWIGS.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FALLEN_LEAVES = register("fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, randomPatchConfig(4, 7, 3, PVJBlocks.FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DEAD_FALLEN_LEAVES = register("dead_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, randomPatchConfig(3, 7, 3, PVJBlocks.DEAD_FALLEN_LEAVES.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINECONES = register("pinecones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.PINECONES.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEASHELLS = register("seashells", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.SEASHELLS.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ROCKS = register("rocks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(4, 7, 3, PlacementUtils.filtered(PVJFeatures.ROCKS.get(), NoneFeatureConfiguration.INSTANCE,
																			BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
																					BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICE_CHUNKS = register("ice_chunks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(4, 7, 3, PVJBlocks.ICE_CHUNKS.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BONES = register("bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(1, 7, 3, PVJBlocks.BONES.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_BONES = register("charred_bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, groundcoverConfig(50, 7, 3, PVJBlocks.CHARRED_BONES.get())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> WARPED_NETTLE = register("warped_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.WARPED_NETTLE.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRIMSON_NETTLE = register("crimson_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.CRIMSON_NETTLE.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CINDERCANE = register("cindercane", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, columnPlantWithFluid(256, 7, 3, PVJBlocks.CINDERCANE.get(), Fluids.LAVA, Fluids.FLOWING_LAVA)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWCAP = register("glowcap", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.GLOWCAP.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_FALLEN_TREE = register("oak_fallen_tree", () -> fallenTree(PVJBlocks.OAK_HOLLOW_LOG.get(), Blocks.OAK_LOG, PVJFeatureVars.OAK));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_FALLEN_TREE = register("birch_fallen_tree", () -> fallenTree(PVJBlocks.BIRCH_HOLLOW_LOG.get(), Blocks.BIRCH_LOG, PVJFeatureVars.BIRCH));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SPRUCE_FALLEN_TREE = register("spruce_fallen_tree", () -> fallenTree(PVJBlocks.SPRUCE_HOLLOW_LOG.get(), Blocks.SPRUCE_LOG, PVJFeatureVars.SPRUCE));
	public static final RegistryObject<ConfiguredFeature<?, ?>> JUNGLE_FALLEN_TREE = register("jungle_fallen_tree", () -> fallenTree(PVJBlocks.JUNGLE_HOLLOW_LOG.get(), Blocks.JUNGLE_LOG, PVJFeatureVars.JUNGLE));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ACACIA_FALLEN_TREE = register("acacia_fallen_tree", () -> fallenTree(PVJBlocks.ACACIA_HOLLOW_LOG.get(), Blocks.ACACIA_LOG, PVJFeatureVars.ACACIA));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DARK_OAK_FALLEN_TREE = register("dark_oak_fallen_tree", () -> fallenTree(PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), Blocks.DARK_OAK_LOG, PVJFeatureVars.DARK_OAK));
	
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<?, ?>> register(String name, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
		return CONFIGURED_FEATURES.register(name, configuredFeature);
	}
	
	private static RandomPatchConfiguration randomPatchConfig(int tries, int xzSpread, int ySpread, BlockState block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
				new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.LAVA, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration cattailConfig(int tries, int xzSpread, int ySpread, BlockState block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
				new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.LAVA, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration groundcoverConfig(int tries, int xzSpread, int ySpread, Block block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
		      new SimpleBlockConfiguration(new RandomizedIntStateProvider(new DirectionalStateProvider(block), GroundcoverBlock.MODEL, UniformInt.of(0, 4))),
		    		  BlockPredicate.allOf(BlockPredicate.replaceable(), 
		    				  BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
		    				  BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.LAVA, new BlockPos(0, 0, 0))),
		    				  BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))),
							  BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration mossCarpetConfig(int tries, int xzSpread, int ySpread, Block block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
		      new SimpleBlockConfiguration(BlockStateProvider.simple(block)),
		    		  BlockPredicate.allOf(BlockPredicate.replaceable(), 
		    				  BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
		    				  BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, -1, 0))),
		    				  BlockPredicate.not(BlockPredicate.replaceable(new BlockPos(0, -1, 0))),
		    				  BlockPredicate.hasSturdyFace(new BlockPos(0, -1, 0), Direction.UP),
		    				  BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.LAVA, new BlockPos(0, 0, 0))),
		    				  BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))),
							  BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))));
	}
	
	private static ConfiguredFeature<?, ?> fallenTree(Block hollowLog, Block baseLog, Set<WeightedBiomeEntry> data) {
		return new ConfiguredFeature<>(PVJFeatures.FALLEN_TREE.get(), new FallenTreeConfiguration(hollowLog.defaultBlockState(), baseLog.defaultBlockState(), new ArrayList<>(data)));
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