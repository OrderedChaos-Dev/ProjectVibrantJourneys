package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.blockstateproviders.RocksBlockStateProvider;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.placers.GroundcoverPlacer;
import projectvibrantjourneys.core.PVJConfig;

public class PVJFeatures {
	
	public static void init() {
		BlockClusterFeatureConfig oakTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.birch_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_twigs.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig oakFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.birch_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(new RocksBlockStateProvider(), new GroundcoverPlacer());
		BlockClusterFeatureConfig sandstoneRocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig redSandstoneRocksCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.red_sandstone_rocks.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig iceChunks = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.ice_chunks.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig bonesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig bonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.bones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig charredBonesNetherCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.charred_bones.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig pineconesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pinecones.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig seashellsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.seashells.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig ironNuggetCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.iron_nugget.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig goldNuggetCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.gold_nugget.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig flintCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.flint.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig dungCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.dung.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig seaOatsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.sea_oats.getDefaultState()), new DoublePlantBlockPlacer());
		
		Feature<ProbabilityConfig> bushFeature = new BushFeature(ProbabilityConfig::deserialize);
		
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
		
		List<String> bushBiomes = PVJConfig.bushBiomes.get();
		List<String> lilypadBiomes = PVJConfig.lilypadBiomes.get();
		
		List<String> ironNuggetBiomes = PVJConfig.ironNuggetBiomes.get();
		List<String> goldNuggetBiomes = PVJConfig.goldNuggetBiomes.get();
		List<String> goldNuggetCommonBiomes = PVJConfig.goldNuggetCommonBiomes.get();
		List<String> flintBiomes = PVJConfig.flintBiomes.get();
		
		List<String> dungBiomes = PVJConfig.dungBiomes.get();
		
		List<String> seaOatsBiomes = PVJConfig.seaOatsBiomes.get();
		
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
				addChanceFeature(biome, iceChunks, 1, 0.2F, false);
			
			/*Bones*/
			if(bonesBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, bonesCluster, 1, 0.05F, false);
			if(bonesCommonBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, bonesCluster, 1, 0.2F, false);
			if(bonesNetherBiomes.contains(biome.getRegistryName().toString())) {
				addNetherFeature(biome, bonesNetherCluster, 0.4F);
				addNetherFeature(biome, charredBonesNetherCluster, 0.3F);
			}
			
			/*Pinecones | Seashells*/
			if(pineconesBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, pineconesCluster, 3, 0.5F, false);
			if(seashellsBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, seashellsCluster, 2, 0.3F, false);
			
			/*Nuggets*/
			if(ironNuggetBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, ironNuggetCluster, 1, 0.1F, false);
			if(goldNuggetBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, goldNuggetCluster, 1, 0.05F, false);
			if(goldNuggetCommonBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, goldNuggetCluster, 2, 0.2F, false);
			if(flintBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, flintCluster, 1, 0.15F, false);
			
			if(dungBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, dungCluster, 2, 0.2F, false);
			
			if(seaOatsBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, seaOatsCluster, 3, 0.8F, false);
			
			if(bushBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(Decoration.VEGETAL_DECORATION, bushFeature.func_225566_b_(new ProbabilityConfig(0.9F)).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(32))));
			
			if(lilypadBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226720_H_).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(4))));
		}
	}
	
	private static BlockClusterFeatureConfig makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer) {
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
	
	private static void addChanceFeature(Biome biome, BlockClusterFeatureConfig configRocks, int frequency, float chance, boolean underground) {
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
