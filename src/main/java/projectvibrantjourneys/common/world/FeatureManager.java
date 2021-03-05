package projectvibrantjourneys.common.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Features.Placements;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import projectvibrantjourneys.common.world.features.blockplacers.RocksBlockPlacer;
import projectvibrantjourneys.common.world.placers.GroundcoverPlacer;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJFeatures;

public class FeatureManager {
	public static BlockClusterFeatureConfig twigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.twigs.getDefaultState()), new GroundcoverPlacer(), 5);
	public static BlockClusterFeatureConfig fallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.fallen_leaves.getDefaultState()), new GroundcoverPlacer(), 5);
	public static BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.rocks.getDefaultState()), new RocksBlockPlacer(), 5);
	public static BlockClusterFeatureConfig iceChunksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.ice_chunks.getDefaultState()), new GroundcoverPlacer(), 5);
	public static BlockClusterFeatureConfig bonesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer(), 1);
	public static BlockClusterFeatureConfig charredBonesCluster = new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.charred_bones.getDefaultState()), new GroundcoverPlacer()).tries(64).func_227317_b_().build();
	public static BlockClusterFeatureConfig pineconesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pinecones.getDefaultState()), new GroundcoverPlacer(), 4);
	public static BlockClusterFeatureConfig seashellsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.seashells.getDefaultState()), new GroundcoverPlacer(), 5);
	public static BlockClusterFeatureConfig seaOatsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sea_oats.getDefaultState()), new DoublePlantBlockPlacer(), 15);
	public static BlockClusterFeatureConfig cattailCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.cattail.getDefaultState()), new DoublePlantBlockPlacer(), 15);
	
	public static ConfiguredFeature<?, ?> seaOatsFeature;
	public static ConfiguredFeature<?, ?> cattailFeature;
	public static ConfiguredFeature<?, ?> twigsFeature;
	public static ConfiguredFeature<?, ?> fallenLeavesFeature;
	public static ConfiguredFeature<?, ?> rocksFeature;
	public static ConfiguredFeature<?, ?> iceChunksFeature;
	public static ConfiguredFeature<?, ?> bonesFeature;
	public static ConfiguredFeature<?, ?> charredBonesFeature;
	public static ConfiguredFeature<?, ?> pineconesFeature;
	public static ConfiguredFeature<?, ?> seashellsFeature;
	public static ConfiguredFeature<?, ?> bushFeature;
	public static ConfiguredFeature<?, ?> barkMushroomFeature;
	public static ConfiguredFeature<?, ?> cobwebsFeature;
	public static ConfiguredFeature<?, ?> oceanSeashellsFeature;
	public static ConfiguredFeature<?, ?> waterCattailsFeature;
	
	public static void init() {
		seaOatsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "sea_oats",
				Feature.RANDOM_PATCH.withConfiguration(seaOatsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2));
		cattailFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "cattail",
				Feature.RANDOM_PATCH.withConfiguration(cattailCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(5).chance(2));
		waterCattailsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "water_cattail",
				PVJFeatures.waterCattailFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(30).chance(3));
		
		twigsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "twigs",
				Feature.RANDOM_PATCH.withConfiguration(twigsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		fallenLeavesFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "fallen_leaves",
				Feature.RANDOM_PATCH.withConfiguration(fallenLeavesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(4).chance(2));
		rocksFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "rocks",
				Feature.RANDOM_PATCH.withConfiguration(rocksCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		iceChunksFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ice_chunks",
				Feature.RANDOM_PATCH.withConfiguration(iceChunksCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2).chance(2));
		bonesFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "bones",
				Feature.RANDOM_PATCH.withConfiguration(bonesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(1).chance(2));
		charredBonesFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "charred_bones",
				Feature.RANDOM_PATCH.withConfiguration(charredBonesCluster).range(128).chance(2));
		pineconesFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "pinecones",
				Feature.RANDOM_PATCH.withConfiguration(pineconesCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(2).chance(2));
		seashellsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "seashells",
				Feature.RANDOM_PATCH.withConfiguration(seashellsCluster).withPlacement(Placements.PATCH_PLACEMENT).func_242731_b(3).chance(2));
		oceanSeashellsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ocean_seashells",
				PVJFeatures.oceanFloorSeashellsFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(10).chance(2));
		
		bushFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "bush",
				PVJFeatures.bushFeature.withConfiguration(new ProbabilityConfig(0.3F)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT));
		barkMushroomFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "bark_mushroom",
				PVJFeatures.barkMushroomFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(30));
		cobwebsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "cobwebs",
				PVJFeatures.cobwebFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).square().func_242731_b(30).chance(10));
		
	}
	
	private static BlockClusterFeatureConfig makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer, int tries) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.tries(tries)
				.build();
	}
}
