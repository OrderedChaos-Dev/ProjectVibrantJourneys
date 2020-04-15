package projectvibrantjourneys.common.world;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.blockstateproviders.FloatingPlantBlockStateProvider;
import projectvibrantjourneys.common.world.blockstateproviders.RocksBlockStateProvider;
import projectvibrantjourneys.common.world.blockstateproviders.ShortGrassBlockStateProvider;
import projectvibrantjourneys.common.world.placers.GroundcoverPlacer;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.PVJBiomes;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJFeatures;

public class FeatureManager {
	
	public static final TreeFeatureConfig FIR_TREE = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.fir_log.getDefaultState()),
			new SimpleBlockStateProvider(PVJBlocks.fir_leaves.getDefaultState()),
			new SpruceFoliagePlacer(4, 2))).baseHeight(11).heightRandA(5).trunkHeight(4).trunkHeightRandom(2).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)PVJBlocks.fir_sapling).build();
	public static final TreeFeatureConfig PINE_TREE = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.pine_log.getDefaultState()),
			new SimpleBlockStateProvider(PVJBlocks.pine_leaves.getDefaultState()),
			new SpruceFoliagePlacer(1, 0))).baseHeight(6).heightRandA(3).trunkHeight(3).trunkHeightRandom(2).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)PVJBlocks.pine_sapling).build();
	public static final TreeFeatureConfig PALM_TREE = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.palm_log.getDefaultState()),
			new SimpleBlockStateProvider(PVJBlocks.palm_leaves.getDefaultState()),
			new SpruceFoliagePlacer(1, 0))).baseHeight(6).heightRandA(3).trunkHeight(3).trunkHeightRandom(2).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)PVJBlocks.palm_sapling).build();
	public static final TreeFeatureConfig WILLOW_TREE = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.willow_log.getDefaultState()),
			new SimpleBlockStateProvider(PVJBlocks.willow_leaves.getDefaultState()),
			new SpruceFoliagePlacer(1, 0))).baseHeight(6).heightRandA(3).trunkHeight(3).trunkHeightRandom(2).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)PVJBlocks.willow_sapling).build();
	public static final TreeFeatureConfig MANGROVE_TREE = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.mangrove_log.getDefaultState()),
			new SimpleBlockStateProvider(PVJBlocks.mangrove_leaves.getDefaultState()),
			new SpruceFoliagePlacer(1, 0))).baseHeight(6).heightRandA(3).trunkHeight(3).trunkHeightRandom(2).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)PVJBlocks.mangrove_sapling).build();
	
	public static final BigMushroomFeatureConfig glowcapFeatureConfig = new BigMushroomFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.glowcap_block.getDefaultState()), new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState()), 2);
	
	public static void init() {
		BlockClusterFeatureConfig oakTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.birch_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig firTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.fir_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig pineTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pine_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig palmTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.palm_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig willowTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.willow_twigs.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig mangroveTwigsCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.mangrove_twigs.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig oakFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig birchFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.birch_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig spruceFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.spruce_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig jungleFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.jungle_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig darkOakFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.dark_oak_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig acaciaFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.acacia_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig firFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.fir_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig pineFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.pine_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig palmFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.palm_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig willowFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.willow_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		BlockClusterFeatureConfig mangroveFallenLeavesCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.mangrove_fallen_leaves.getDefaultState()), new GroundcoverPlacer());
		
		BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(new RocksBlockStateProvider(), new GroundcoverPlacer());
		BlockClusterFeatureConfig netherrackRocksCluster = createNetherGroundcoverConfig(new SimpleBlockStateProvider(PVJBlocks.netherrack_rocks.getDefaultState()), new GroundcoverPlacer());
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
		BlockClusterFeatureConfig cattailCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.cattail.getDefaultState()), new DoublePlantBlockPlacer());
		BlockClusterFeatureConfig smallCactusCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.small_cactus.getDefaultState()), new SimpleBlockPlacer());
		BlockClusterFeatureConfig beachGrassCluster = makeFeatureConfig(new SimpleBlockStateProvider(PVJBlocks.beach_grass.getDefaultState()), new SimpleBlockPlacer());
		BlockClusterFeatureConfig frogbitCluster = (new BlockClusterFeatureConfig.Builder(new FloatingPlantBlockStateProvider(PVJBlocks.frogbit.getDefaultState()), new SimpleBlockPlacer())).tries(10).build();
		BlockClusterFeatureConfig duckweedCluster = (new BlockClusterFeatureConfig.Builder(new FloatingPlantBlockStateProvider(PVJBlocks.duckweed.getDefaultState()), new SimpleBlockPlacer())).tries(10).build();
		BlockClusterFeatureConfig glowcapCluster = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PVJBlocks.glowcap.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
		BlockClusterFeatureConfig shortGrassCluster = makeFeatureConfig(new ShortGrassBlockStateProvider(), new SimpleBlockPlacer());
		
		List<String> oakBiomes = PVJConfig.oakTreesBiomes.get();
		List<String> oakBiomesSparse = PVJConfig.oakTreesSparseBiomes.get();
		List<String> birchBiomes = PVJConfig.birchTreesBiomes.get();
		List<String> birchBiomesSparse = PVJConfig.birchTreesSparseBiomes.get();
		List<String> spruceBiomes = PVJConfig.spruceTreesBiomes.get();
		List<String> spruceBiomesSparse = PVJConfig.spruceTreesSparseBiomes.get();
		List<String> jungleBiomes = PVJConfig.jungleTreesBiomes.get();
		List<String> jungleBiomesSparse = PVJConfig.jungleTreesSparseBiomes.get();
		List<String> darkOakBiomes = PVJConfig.darkOakTreesBiomes.get();
		List<String> darkOakBiomesSparse = PVJConfig.darkOakTreesSparseBiomes.get();
		List<String> acaciaBiomes = PVJConfig.acaciaTreesBiomes.get();
		List<String> acaciaBiomesSparse = PVJConfig.acaciaTreesSparseBiomes.get();
		List<String> firBiomes = PVJConfig.firTreesBiomes.get();
		List<String> firBiomesSparse = PVJConfig.firTreesSparseBiomes.get();
		List<String> pineBiomes = PVJConfig.pineTreesBiomes.get();
		List<String> pineBiomesSparse = PVJConfig.pineTreesSparseBiomes.get();
		List<String> palmBiomes = PVJConfig.palmTreesBiomes.get();
		List<String> palmBiomesSparse = PVJConfig.palmTreesSparseBiomes.get();
		List<String> willowBiomes = PVJConfig.willowTreesBiomes.get();
		List<String> willowBiomesSparse = PVJConfig.willowTreesSparseBiomes.get();
		List<String> mangroveBiomes = PVJConfig.mangroveTreesBiomes.get();
		List<String> mangroveBiomesSparse = PVJConfig.mangroveTreesSparseBiomes.get();
		
		List<String> rocksBiomes = PVJConfig.rocksBiomes.get();
		List<String> netherrackRocksBiomes = PVJConfig.netherrackRocksBiomes.get();
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
		List<String> cobwebBiomes = PVJConfig.cobwebBiomes.get();
		List<String> seagrassBiomes = PVJConfig.seagrassBiomes.get();
		
		List<String> ironNuggetBiomes = PVJConfig.ironNuggetBiomes.get();
		List<String> goldNuggetBiomes = PVJConfig.goldNuggetBiomes.get();
		List<String> goldNuggetCommonBiomes = PVJConfig.goldNuggetCommonBiomes.get();
		List<String> flintBiomes = PVJConfig.flintBiomes.get();
		
		List<String> dungBiomes = PVJConfig.dungBiomes.get();
		
		List<String> seaOatsBiomes = PVJConfig.seaOatsBiomes.get();
		List<String> beachGrassBiomes = PVJConfig.beachGrassBiomes.get();
		List<String> cattailBiomes = PVJConfig.cattailBiomes.get();
		List<String> smallCactusBiomes = PVJConfig.smallCactusBiomes.get();
		List<String> barkMushroomBiomes = PVJConfig.barkMushroomBiomes.get();
		List<String> frogbitBiomes = PVJConfig.frogbitBiomes.get();
		List<String> duckweedBiomes = PVJConfig.duckweedBiomes.get();
		List<String> glowcapBiomes = PVJConfig.glowcapBiomes.get();
		List<String> shortGrassBiomes = PVJConfig.shortGrassBiomes.get();
		
		
		for(Biome biome : ForgeRegistries.BIOMES) {
			/*OAK TWIGS*/
			if(oakBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, oakTwigsCluster, oakFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.OAK_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 15);
			}
			if(oakBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, oakTwigsCluster, oakFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.OAK_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			/*BIRCH TWIGS*/
			if(birchBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, birchTwigsCluster, birchFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.BIRCH_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 15);
			}
			if(birchBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, birchTwigsCluster, birchFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.BIRCH_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			/*SPRUCE TWIGS*/
			if(spruceBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, spruceTwigsCluster, spruceFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.SPRUCE_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 15);
			}
			if(spruceBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, spruceTwigsCluster, spruceFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.SPRUCE_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			/*JUNGLE TWIGS*/
			if(jungleBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, jungleTwigsCluster, jungleFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.JUNGLE_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 15);
			}
				
			if(jungleBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, jungleTwigsCluster, jungleFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.JUNGLE_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			/*DARK OAK TWIGS*/
			if(darkOakBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, darkOakTwigsCluster, darkOakFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.DARK_OAK_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 15);
			}
				
			if(darkOakBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, darkOakTwigsCluster, darkOakFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.DARK_OAK_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			/*ACACIA TWIGS*/
			if(acaciaBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, acaciaTwigsCluster, acaciaFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, Blocks.ACACIA_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			if(acaciaBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, acaciaTwigsCluster, acaciaFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, Blocks.ACACIA_LOG.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
			
			/*FIR TWIGS*/
			if(firBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, firTwigsCluster, firFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, PVJBlocks.fir_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
				
			if(firBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, firTwigsCluster, firFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, PVJBlocks.fir_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 5);
			}
			
			/*PINE TWIGS*/
			if(pineBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, pineTwigsCluster, pineFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, PVJBlocks.pine_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 3);
			}
				
			if(pineBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, pineTwigsCluster, pineFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, PVJBlocks.pine_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 2);
			}
			
			/*PALM TWIGS*/
			if(palmBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, palmTwigsCluster, palmFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, PVJBlocks.palm_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 3);
			}
				
			if(palmBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, palmTwigsCluster, palmFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, PVJBlocks.palm_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 2);
			}
			
			/*WILLOW TWIGS*/
			if(willowBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, willowTwigsCluster, willowFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, PVJBlocks.willow_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 3);
			}
				
			if(willowBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, willowTwigsCluster, willowFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, PVJBlocks.willow_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 2);
			}
			
			/*MANGROVE TWIGS*/
			if(willowBiomes.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, mangroveTwigsCluster, mangroveFallenLeavesCluster, 3, false);
				addFallenTreeFeature(biome, PVJBlocks.mangrove_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 3);
			}
				
			if(mangroveBiomesSparse.contains(biome.getRegistryName().toString())) {
				addTwigsLeavesFeature(biome, mangroveTwigsCluster, mangroveFallenLeavesCluster, 1, false);
				addFallenTreeFeature(biome, PVJBlocks.mangrove_log.getDefaultState(), PVJFeatures.fallenTreeFeature, 2);
			}
				
			
			/*ROCKS*/
			if(rocksBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyFeature(biome, rocksCluster, 2, false);
			if(sandstoneBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyFeature(biome, sandstoneRocksCluster, 2, false);
			if(redSandstoneBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyFeature(biome, redSandstoneRocksCluster, 2, false);
			if(netherrackRocksBiomes.contains(biome.getRegistryName().toString()))
				addNetherFeature(biome, netherrackRocksCluster, 0.8F);
			if(iceChunksBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, iceChunks, 1, 0.2F, false);
			
			/*Bones*/
			if(bonesBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, bonesCluster, 1, 0.05F, false);
			if(bonesCommonBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, bonesCluster, 1, 0.2F, false);
			if(bonesNetherBiomes.contains(biome.getRegistryName().toString())) {
				addNetherFeature(biome, bonesNetherCluster, 0.4F);
				addNetherFeature(biome, charredBonesNetherCluster, 0.3F);
			}
			
			/*Pinecones | Seashells*/
			if(pineconesBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, pineconesCluster, 3, 0.5F, false);
			if(seashellsBiomes.contains(biome.getRegistryName().toString())) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						PVJFeatures.oceanFloorSeashellsFeature
							.withConfiguration(new SeaGrassConfig(5, 0.0D))
							.withPlacement(Placement.TOP_SOLID_HEIGHTMAP
									.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				addFrequencyChanceFeature(biome, seashellsCluster, 2, 0.3F, false);
			}
			
			/*Nuggets*/
			if(ironNuggetBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, ironNuggetCluster, 1, 0.1F, false);
			if(goldNuggetBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, goldNuggetCluster, 1, 0.05F, false);
			if(goldNuggetCommonBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, goldNuggetCluster, 2, 0.2F, false);
			if(flintBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, flintCluster, 1, 0.15F, false);
			
			if(dungBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, dungCluster, 2, 0.2F, false);
			
			if(seaOatsBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, seaOatsCluster, 3, 0.8F, false);
			if(beachGrassBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, beachGrassCluster, 3, 0.8F, false);
			if(cattailBiomes.contains(biome.getRegistryName().toString())) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						PVJFeatures.waterCattailFeature
							.withConfiguration(new SeaGrassConfig(8, 0.0D))
							.withPlacement(Placement.TOP_SOLID_HEIGHTMAP
									.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				addFrequencyFeature(biome, cattailCluster, 40, false);
			}
			if(smallCactusBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, smallCactusCluster, 2, 0.35F, false);
			if(glowcapBiomes.contains(biome.getRegistryName().toString()))
				addChanceFeature(biome, glowcapCluster, 2, false);
			if(shortGrassBiomes.contains(biome.getRegistryName().toString()))
				addFrequencyChanceFeature(biome, shortGrassCluster, 10, 0.8F, false);
			
			if(barkMushroomBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(Decoration.VEGETAL_DECORATION, PVJFeatures.barkMushroomFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(50))));
			if(frogbitBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(frogbitCluster).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
			if(duckweedBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(duckweedCluster).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
			
			if(lilypadBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
			if(cobwebBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(Decoration.VEGETAL_DECORATION, PVJFeatures.cobwebFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(5))));
			if(bushBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(Decoration.VEGETAL_DECORATION, PVJFeatures.bushFeature.withConfiguration(new ProbabilityConfig(0.9F)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(32))));
			if(seagrassBiomes.contains(biome.getRegistryName().toString())) {
			     biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(48, 0.4D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			}
			
			if(palmBiomes.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PVJFeatures.palmTree.withConfiguration(PALM_TREE).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.5F, 1))));
			if(palmBiomesSparse.contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PVJFeatures.palmTree.withConfiguration(PALM_TREE).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.4F, 1))));
			if(mangroveBiomes.contains(biome.getRegistryName().toString())) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PVJFeatures.mangroveTree.withConfiguration(MANGROVE_TREE).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.4F, 1))));
				biome.addFeature(Decoration.VEGETAL_DECORATION, PVJFeatures.mangroveRootFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(7))));
			}
			if(mangroveBiomesSparse.contains(biome.getRegistryName().toString())) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PVJFeatures.mangroveTree.withConfiguration(MANGROVE_TREE).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.2F, 1))));
				biome.addFeature(Decoration.VEGETAL_DECORATION, PVJFeatures.mangroveRootFeature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHT_64.configure(new FrequencyConfig(3))));
			}
		}
		
		PVJBiomes.boreal_forest.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(FeatureManager.FIR_TREE).func_227227_a_(0.8F)), PVJFeatures.pineTree.withConfiguration(FeatureManager.PINE_TREE))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
		PVJBiomes.snowy_boreal_forest.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(FeatureManager.FIR_TREE).func_227227_a_(0.7F)), PVJFeatures.pineTree.withConfiguration(FeatureManager.PINE_TREE))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
		PVJBiomes.willow_wetlands.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PVJFeatures.willowTree.withConfiguration(WILLOW_TREE).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
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
	
	private static void addTwigsLeavesFeature(Biome biome, BlockClusterFeatureConfig configTwigs, BlockClusterFeatureConfig configLeaves, int frequency, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		
		biome.addFeature(decoration,
				Feature.RANDOM_PATCH.withConfiguration(configTwigs)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(frequency))));
		
		biome.addFeature(decoration,
				Feature.RANDOM_PATCH.withConfiguration(configLeaves)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(frequency))));
	}
	
	private static void addFallenTreeFeature(Biome biome, BlockState log, Feature<BlockStateFeatureConfig> feature, int frequency) {
		biome.addFeature(Decoration.VEGETAL_DECORATION, feature.withConfiguration(new BlockStateFeatureConfig(log)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(frequency))));
	}
	
	private static void addFrequencyFeature(Biome biome, BlockClusterFeatureConfig config, int frequency, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		biome.addFeature(decoration,
				Feature.RANDOM_PATCH.withConfiguration(config)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(frequency))));
	}
	
	private static void addFrequencyChanceFeature(Biome biome, BlockClusterFeatureConfig config, int frequency, float chance, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		biome.addFeature(decoration,
				Feature.RANDOM_PATCH.withConfiguration(config)
				.withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE
						.configure(new HeightWithChanceConfig(frequency, chance))));
	}
	
	private static void addChanceFeature(Biome biome, BlockClusterFeatureConfig config, int chance, boolean underground) {
		GenerationStage.Decoration decoration = underground ? GenerationStage.Decoration.UNDERGROUND_DECORATION : GenerationStage.Decoration.VEGETAL_DECORATION;
		biome.addFeature(decoration,
				Feature.RANDOM_PATCH.withConfiguration(config)
				.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}
	
	private static void addNetherFeature(Biome biome, BlockClusterFeatureConfig configRocks, float chance) {
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(configRocks)
				.withPlacement(Placement.CHANCE_RANGE
						.configure(new ChanceRangeConfig(chance, 0, 0, 128))));
	}
}
