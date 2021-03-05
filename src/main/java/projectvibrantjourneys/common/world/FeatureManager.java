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
import net.minecraft.world.gen.placement.Placement;
import projectvibrantjourneys.common.world.placers.GroundcoverPlacer;
import projectvibrantjourneys.init.PVJBlocks;

public class FeatureManager {
	public static BlockClusterFeatureConfig oakTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.twigs.getDefaultState()), new GroundcoverPlacer());
	
	public static  BlockClusterFeatureConfig oakFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.fallen_leaves.getDefaultState()), new GroundcoverPlacer());
	
//	BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(new RocksBlockStateProvider(), new GroundcoverPlacer());
//	BlockClusterFeatureConfig netherrackRocksCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.netherrack_rocks.getDefaultState()), new GroundcoverPlacer());
	public static  BlockClusterFeatureConfig sandstoneRocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
	public static  BlockClusterFeatureConfig redSandstoneRocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.red_sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
	public static  BlockClusterFeatureConfig iceChunks = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.ice_chunks.getDefaultState()), new GroundcoverPlacer());
	
	public static  BlockClusterFeatureConfig bonesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
	public static  BlockClusterFeatureConfig bonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
	public static  BlockClusterFeatureConfig charredBonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.charred_bones.getDefaultState()), new GroundcoverPlacer());
	
	public static BlockClusterFeatureConfig pineconesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pinecones.getDefaultState()), new GroundcoverPlacer());
	public static BlockClusterFeatureConfig seashellsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.seashells.getDefaultState()), new GroundcoverPlacer());
	
	public static BlockClusterFeatureConfig seaOatsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sea_oats.getDefaultState()), new DoublePlantBlockPlacer());
	public static BlockClusterFeatureConfig cattailCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.cattail.getDefaultState()), new DoublePlantBlockPlacer());
	
	public static ConfiguredFeature<?, ?> seaOatsFeature;
	
	public static void init() {
		seaOatsFeature = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "sea_oats", Feature.RANDOM_PATCH.withConfiguration(seaOatsCluster).withPlacement(Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placements.PATCH_PLACEMENT.chance(100)));
	}
	
	private static BlockClusterFeatureConfig makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.tries(4)
				.build();
	}
	
	private static BlockClusterFeatureConfig createNetherGroundcoverConfig(BlockStateProvider provider, BlockPlacer placer) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.tries(64)
				.func_227317_b_()
				.build();
	}
}
