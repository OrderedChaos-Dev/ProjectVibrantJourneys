package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.blockstateproviders.RocksBlockStateProvider;
import projectvibrantjourneys.common.world.placers.GroundcoverPlacer;
import projectvibrantjourneys.core.PVJConfig;

public class PVJFeatures {
	
	public static void init() {
		BlockClusterFeatureConfig oakTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.birch_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaTwigsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_twigs.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig oakFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.birch_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaFallenLeavesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig rocksCluster = createGroundcoverConfig(new RocksBlockStateProvider(), new GroundcoverPlacer());
		BlockClusterFeatureConfig sandstoneRocksCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig redSandstoneRocksCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.red_sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig iceChunks = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.ice_chunks.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig bonesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig bonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig charredBonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.charred_bones.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig pineconesCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.pinecones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig seashellsCluster = createGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.seashells.getDefaultState()), new GroundcoverPlacer());
		
		List<String> oakBiomes = PVJConfig.oakTwigsBiomes.get();
		List<String> oakBiomesSparse = PVJConfig.oakTwigsSparseBiomes.get();
		List<String> birchBiomes = PVJConfig.birchTwigsBiomes.get();
		List<String> birchBiomesSparse = PVJConfig.birchTwigsSparseBiomes.get();
		List<String> spruceBiomes = PVJConfig.spruceTwigsBiomes.get();
		List<String> spruceBiomesSparse = PVJConfig.spruceTwigsSparseBiomes.get();
		List<String> jungleBiomes = PVJConfig.jungleTwigsBiomes.get();
		List<String> jungleBiomesSparse = PVJConfig.jungleTwigsSparseBiomes.get();
		List<String> darkOakBiomes = PVJConfig.darkOakTwigsBiomes.get();
		List<String> darkOakBiomesSparse = PVJConfig.darkOakTwigsSparseBiomes.get();
		List<String> acaciaBiomes = PVJConfig.acaciaTwigsBiomes.get();
		List<String> acaciaBiomesSparse = PVJConfig.acaciaTwigsSparseBiomes.get();
		
		List<String> rocksBiomes = PVJConfig.rocksBiomes.get();
		List<String> sandstoneBiomes = PVJConfig.sandstoneBiomes.get();
		List<String> redSandstoneBiomes = PVJConfig.redSandstoneBiomes.get();
		List<String> iceChunksBiomes = PVJConfig.iceChunksBiomes.get();
		
		List<String> bonesBiomes = PVJConfig.bonesBiomes.get();
		List<String> bonesCommonBiomes = PVJConfig.bonesCommonBiomes.get();
		List<String> bonesNetherBiomes = PVJConfig.bonesNetherBiomes.get();
		
		List<String> pineconesBiomes = PVJConfig.pineconesBiomes.get();
		List<String> seashellsBiomes = PVJConfig.seashellsBiomes.get();
		
		for(Biome biome : ForgeRegistries.BIOMES) {
			/*OAK TWIGS*/
			if(oakBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, oakTwigsCluster, oakFallenLeavesCluster, 3, false);
			if(oakBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, oakTwigsCluster, oakFallenLeavesCluster, 1, false);
			/*BIRCH TWIGS*/
			if(birchBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, birchTwigsCluster, birchFallenLeavesCluster, 3, false);
			if(birchBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, birchTwigsCluster, birchFallenLeavesCluster, 1, false);
			/*SPRUCE TWIGS*/
			if(spruceBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, spruceTwigsCluster, spruceFallenLeavesCluster, 3, false);
			if(spruceBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, spruceTwigsCluster, spruceFallenLeavesCluster, 1, false);
			/*JUNGLE TWIGS*/
			if(jungleBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, jungleTwigsCluster, jungleFallenLeavesCluster, 3, false);
			if(jungleBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, jungleTwigsCluster, jungleFallenLeavesCluster, 1, false);
			/*DARK OAK TWIGS*/
			if(darkOakBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, darkOakTwigsCluster, darkOakFallenLeavesCluster, 3, false);
			if(darkOakBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, darkOakTwigsCluster, darkOakFallenLeavesCluster, 1, false);
			/*ACACIA TWIGS*/
			if(acaciaBiomes.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, acaciaTwigsCluster, acaciaFallenLeavesCluster, 3, false);
			if(acaciaBiomesSparse.contains(biome.getRegistryName().toString()))
				addTwigsLeavesFeature(biome, acaciaTwigsCluster, acaciaFallenLeavesCluster, 1, false);
			
			/*ROCKS*/
			if(rocksBiomes.contains(biome.getRegistryName().toString()))
				addRocksFeature(biome, rocksCluster, 2, false);
			if(sandstoneBiomes.contains(biome.getRegistryName().toString()))
				addRocksFeature(biome, sandstoneRocksCluster, 2, false);
			if(redSandstoneBiomes.contains(biome.getRegistryName().toString()))
				addRocksFeature(biome, redSandstoneRocksCluster, 2, false);
			if(iceChunksBiomes.contains(biome.getRegistryName().toString()))
				addGroundcoverChanceFeature(biome, iceChunks, 1, 0.2F, false);
			
			/*Bones*/
			if(bonesBiomes.contains(biome.getRegistryName().toString()))
				addGroundcoverChanceFeature(biome, bonesCluster, 1, 0.05F, false);
			if(bonesCommonBiomes.contains(biome.getRegistryName().toString()))
				addGroundcoverChanceFeature(biome, bonesCluster, 1, 0.2F, false);
			if(bonesNetherBiomes.contains(biome.getRegistryName().toString())) {
				addNetherFeature(biome, bonesNetherCluster, 0.4F);
				addNetherFeature(biome, charredBonesNetherCluster, 0.3F);
			}
			
			/*Pinecones | Seashells*/
			if(pineconesBiomes.contains(biome.getRegistryName().toString()))
				addGroundcoverChanceFeature(biome, pineconesCluster, 3, 0.5F, false);
			if(seashellsBiomes.contains(biome.getRegistryName().toString()))
				addGroundcoverChanceFeature(biome, seashellsCluster, 2, 0.3F, false);
		}
	}
	
	private static BlockClusterFeatureConfig createGroundcoverConfig(BlockStateProvider provider, BlockPlacer placer) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.func_227315_a_(4)
				.func_227322_d_();
	}
	
	private static BlockClusterFeatureConfig createNetherGroundcoverConfig(BlockStateProvider provider, BlockPlacer placer) {
		return new BlockClusterFeatureConfig
				.Builder(provider, placer)
				.func_227315_a_(64)
				.func_227317_b_()
				.func_227322_d_();
	}
	
	private static void addTwigsLeavesFeature(Biome biome, BlockClusterFeatureConfig configTwigs, BlockClusterFeatureConfig configLeaves, int frequency, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		
		biome.addFeature(decoration,
				Feature.field_227248_z_.func_225566_b_(configTwigs)
				.func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE
						.func_227446_a_(new FrequencyConfig(frequency))));
		
		biome.addFeature(decoration,
				Feature.field_227248_z_.func_225566_b_(configLeaves)
				.func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE
						.func_227446_a_(new FrequencyConfig(frequency))));
	}
	
	private static void addRocksFeature(Biome biome, BlockClusterFeatureConfig configRocks, int frequency, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		biome.addFeature(decoration,
				Feature.field_227248_z_.func_225566_b_(configRocks)
				.func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE
						.func_227446_a_(new FrequencyConfig(frequency))));
	}
	
	private static void addGroundcoverChanceFeature(Biome biome, BlockClusterFeatureConfig configRocks, int frequency, float chance, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		biome.addFeature(decoration,
				Feature.field_227248_z_.func_225566_b_(configRocks)
				.func_227228_a_(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE
						.func_227446_a_(new HeightWithChanceConfig(frequency, chance))));
	}
	
	private static void addNetherFeature(Biome biome, BlockClusterFeatureConfig configRocks, float chance) {
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.field_227248_z_.func_225566_b_(configRocks)
				.func_227228_a_(Placement.CHANCE_RANGE
						.func_227446_a_(new ChanceRangeConfig(chance, 0, 0, 128))));
	}
}
