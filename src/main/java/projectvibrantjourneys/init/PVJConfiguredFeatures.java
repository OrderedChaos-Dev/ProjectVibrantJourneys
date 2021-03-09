package projectvibrantjourneys.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Features.Placements;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import projectvibrantjourneys.common.world.features.blockplacers.GroundcoverPlacer;
import projectvibrantjourneys.common.world.features.blockplacers.RocksBlockPlacer;

public class PVJConfiguredFeatures {
	public static final GroundcoverPlacer GROUNDCOVER_PLACER = new GroundcoverPlacer();
	public static BlockClusterFeatureConfig twigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.twigs.getDefaultState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig fallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.fallen_leaves.getDefaultState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.rocks.getDefaultState()), new RocksBlockPlacer(), 5);
	public static BlockClusterFeatureConfig iceChunksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.ice_chunks.getDefaultState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig bonesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), GROUNDCOVER_PLACER, 1);
	public static BlockClusterFeatureConfig charredBonesCluster = new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.charred_bones.getDefaultState()), new GroundcoverPlacer()).tries(64).func_227317_b_().build();
	public static BlockClusterFeatureConfig pineconesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pinecones.getDefaultState()), GROUNDCOVER_PLACER, 4);
	public static BlockClusterFeatureConfig seashellsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.seashells.getDefaultState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig seaOatsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sea_oats.getDefaultState()), DoublePlantBlockPlacer.PLACER, 15);
	public static BlockClusterFeatureConfig cattailCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.cattail.getDefaultState()), DoublePlantBlockPlacer.PLACER, 15);
	public static BlockClusterFeatureConfig glowcapCluster = new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.glowcap.getDefaultState()), SimpleBlockPlacer.PLACER).tries(64).func_227317_b_().build();
	
	public static ConfiguredFeature<?, ?> sea_oats;
	public static ConfiguredFeature<?, ?> cattails;
	public static ConfiguredFeature<?, ?> water_cattails;
	public static ConfiguredFeature<?, ?> twigs;
	public static ConfiguredFeature<?, ?> fallen_leaves;
	public static ConfiguredFeature<?, ?> rocks;
	public static ConfiguredFeature<?, ?> ice_chunks;
	public static ConfiguredFeature<?, ?> bones;
	public static ConfiguredFeature<?, ?> charred_bones;
	public static ConfiguredFeature<?, ?> pinecones;
	public static ConfiguredFeature<?, ?> seashells;
	public static ConfiguredFeature<?, ?> ocean_seashells;
	public static ConfiguredFeature<?, ?> bushes;
	public static ConfiguredFeature<?, ?> bark_mushrooms;
	public static ConfiguredFeature<?, ?> cobwebs;
	public static ConfiguredFeature<?, ?> glowcap;
	
	public static final List<ConfiguredFeature<?, ?>> FALLEN_TREES = new ArrayList<ConfiguredFeature<?, ?>>();
	
	public static void init() {
		sea_oats = register("sea_oats",
				Feature.RANDOM_PATCH.withConfiguration(seaOatsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2));
		cattails = register("cattail",
				Feature.RANDOM_PATCH.withConfiguration(cattailCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(5).chance(2));
		water_cattails = register("water_cattail",
				PVJFeatures.waterCattailFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(30).chance(3));
		
		twigs = register("twigs",
				Feature.RANDOM_PATCH.withConfiguration(twigsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		fallen_leaves = register("fallen_leaves",
				Feature.RANDOM_PATCH.withConfiguration(fallenLeavesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(4).chance(2));
		rocks = register("rocks",
				Feature.RANDOM_PATCH.withConfiguration(rocksCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		ice_chunks = register("ice_chunks",
				Feature.RANDOM_PATCH.withConfiguration(iceChunksCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2).chance(2));
		bones = register("bones",
				Feature.RANDOM_PATCH.withConfiguration(bonesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(1).chance(2));
		charred_bones = register("charred_bones",
				Feature.RANDOM_PATCH.withConfiguration(charredBonesCluster).range(128).chance(2));
		pinecones = register("pinecones",
				Feature.RANDOM_PATCH.withConfiguration(pineconesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2).chance(2));
		seashells = register("seashells",
				Feature.RANDOM_PATCH.withConfiguration(seashellsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		ocean_seashells = register("ocean_seashells",
				PVJFeatures.oceanFloorSeashellsFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(10).chance(2));
		
		bushes = register("bush",
				PVJFeatures.bushFeature.withConfiguration(new ProbabilityConfig(0.3F)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));
		bark_mushrooms = register("bark_mushroom",
				PVJFeatures.barkMushroomFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(30));
		cobwebs = register("cobwebs",
				PVJFeatures.cobwebFeature.withConfiguration(new ProbabilityConfig(0.2F)).square().func_242731_b(30).chance(25));
		glowcap = register("glowcap",
				Feature.RANDOM_PATCH.withConfiguration(glowcapCluster).range(128).chance(2));
	}
	
	private static BlockClusterFeatureConfig makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer, int tries) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.tries(tries)
				.build();
	}
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
	}
	
	public static ConfiguredFeature<?, ?> getOrCreateFallenTreeFeature(Block log) {
		try {
			for(ConfiguredFeature<?, ?> cf : FALLEN_TREES) {
				if(((BlockStateFeatureConfig)((DecoratedFeatureConfig)cf.getConfig()).feature.get().getConfig()).state.getBlock() == log) {
					return cf;
				}
			}
		} catch(Exception e) {
			return getOrCreateFallenTreeFeature(Blocks.OAK_LOG); //defaults to oak if anything goes wrong
		}
		
		ConfiguredFeature<?, ?> fallenTree = register(log.getRegistryName().getPath() + "_fallen_tree",
				PVJFeatures.fallenTreeFeature.withConfiguration(new BlockStateFeatureConfig(log.getDefaultState())).withPlacement(Placements.KELP_PLACEMENT));
		FALLEN_TREES.add(fallenTree);
		return fallenTree;
	}
}
