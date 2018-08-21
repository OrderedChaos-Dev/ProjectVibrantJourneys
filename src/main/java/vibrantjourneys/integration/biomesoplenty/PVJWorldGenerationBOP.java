package vibrantjourneys.integration.biomesoplenty;

import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundCover;

public class PVJWorldGenerationBOP
{
	public static void initWorldGenBOP()
	{
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.FIR_LOG, PVJConfig.bopworldgen.fallenTreeFirDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_FIR_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.JACARANDA_LOG, PVJConfig.bopworldgen.fallenTreeJacarandaDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_JACARANDA_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.WILLOW_LOG, PVJConfig.bopworldgen.fallenTreeWillowDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_WILLOW_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.PINE_LOG, PVJConfig.bopworldgen.fallenTreePineDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_PINE_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.CHERRY_LOG, PVJConfig.bopworldgen.fallenTreeCherryDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_PINK_CHERRY_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.DEAD_LOG, PVJConfig.bopworldgen.fallenTreeDeadDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_DEAD_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.EBONY_LOG, PVJConfig.bopworldgen.fallenTreeEbonyDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_EBONY_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.EUCALYPTUS_LOG, PVJConfig.bopworldgen.fallenTreeEucalyptusDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_EUCALYPTUS_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.MAHOGONY_LOG, PVJConfig.bopworldgen.fallenTreeMahoganyDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_MAHOGANY_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.MAGIC_LOG, PVJConfig.bopworldgen.fallenTreeMagicDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_MAGIC_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.PALM_LOG, PVJConfig.bopworldgen.fallenTreePalmDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_PALM_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.MANGROVE_LOG, PVJConfig.bopworldgen.fallenTreeMangroveDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_MANGROVE_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.REDWOOD_LOG, PVJConfig.bopworldgen.fallenTreeRedwoodDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_REDWOOD_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.SACRED_OAK_LOG, PVJConfig.bopworldgen.fallenTreeSacredOakDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_SACRED_OAK_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReferenceBOP.UMBRAN_LOG, PVJConfig.bopworldgen.fallenTreeUmbranDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_UMBRAN_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReference.OAK_LOG, PVJConfig.bopworldgen.fallenTreeMapleDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_MAPLE_TREES)));
		PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
				BiomeReference.OAK_LOG, PVJConfig.bopworldgen.fallenTreeAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_YELLOW_AUTUMN_TREES)));
		
		PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(
				PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getValidBiomes(BiomeReference.BOP_DEAD_TREES)));
		
		for(BOPBlockInfo info : PVJBlocksBOP.BLOCK_INFO_FALLENLEAVES)
		{
			PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(info.getBlock(), info.getWorldGenDensity(), info.getBiomes()));
		}
		
		for(BOPBlockInfo info : PVJBlocksBOP.BLOCK_INFO_TWIGS)
		{
			PVJWorldGen.registerWorldGen(new WorldGenGroundCover(info.getBlock(), 60, 150, info.getWorldGenDensity(), info.getBiomes()));
		}
	}
	
	public static int getDensityFallenLeaves(String name)
	{
		switch(name)
		{
			case "bamboo":
				return PVJConfig.bopworldgen.fallenLeavesBambooDensity;
			case "magic":
				return PVJConfig.bopworldgen.fallenLeavesMagicDensity;
			case "yellow_autumn":
				return PVJConfig.bopworldgen.fallenLeavesYellowAutumnDensity;
			case "orange_autumn":
				return PVJConfig.bopworldgen.fallenLeavesOrangeAutumnDensity;
			case "umbran":
				return PVJConfig.bopworldgen.fallenLeavesUmbranDensity;
			case "fir":
				return PVJConfig.bopworldgen.fallenLeavesFirDensity;
			case "pink_cherry":
				return PVJConfig.bopworldgen.fallenLeavesPinkCherryDensity;
			case "white_cherry":
				return PVJConfig.bopworldgen.fallenLeavesWhiteCherryDensity;
			case "maple":
				return PVJConfig.bopworldgen.fallenLeavesMapleDensity;
			case "hellbark":
				return PVJConfig.bopworldgen.fallenLeavesHellbarkDensity;
			case "flowering":
				return PVJConfig.bopworldgen.fallenLeavesFloweringOakDensity;
			case "jacaranda":
				return PVJConfig.bopworldgen.fallenLeavesJacarandaDensity;
			case "sacred_oak":
				return PVJConfig.bopworldgen.fallenLeavesSacredOakDensity;
			case "mangrove":
				return PVJConfig.bopworldgen.fallenLeavesMangroveDensity;
			case "palm":
				return PVJConfig.bopworldgen.fallenLeavesPalmDensity;
			case "redwood":
				return PVJConfig.bopworldgen.fallenLeavesRedwoodDensity;
			case "willow":
				return PVJConfig.bopworldgen.fallenLeavesWillowDensity;
			case "pine":
				return PVJConfig.bopworldgen.fallenLeavesPineDensity;
			case "mahogany":
				return PVJConfig.bopworldgen.fallenLeavesMahoganyDensity;
			case "ebony":
				return PVJConfig.bopworldgen.fallenLeavesEbonyDensity;
			case "eucalyptus":
				return PVJConfig.bopworldgen.fallenLeavesEucalyptusDensity;
			default:
				return 0;
		}
	}
	
	public static int getDensityTwigs(String name)
	{
		switch(name)
		{
			case "magic":
				return PVJConfig.bopworldgen.twigsMagicDensity;
			case "yellow_autumn":
				return PVJConfig.bopworldgen.twigsAutumnDensity;
			case "orange_autumn":
				return PVJConfig.bopworldgen.twigsAutumnDensity;
			case "umbran":
				return PVJConfig.bopworldgen.twigsUmbranDensity;
			case "fir":
				return PVJConfig.bopworldgen.twigsFirDensity;
			case "pink_cherry":
				return PVJConfig.bopworldgen.twigsCherryDensity;
			case "white_cherry":
				return PVJConfig.bopworldgen.twigsCherryDensity;
			case "maple":
				return PVJConfig.bopworldgen.twigsMapleDensity;
			case "hellbark":
				return PVJConfig.bopworldgen.twigsHellbarkDensity;
			case "jacaranda":
				return PVJConfig.bopworldgen.twigsJacarandaDensity;
			case "sacred_oak":
				return PVJConfig.bopworldgen.twigsSacredOakDensity;
			case "mangrove":
				return PVJConfig.bopworldgen.twigsMangroveDensity;
			case "palm":
				return PVJConfig.bopworldgen.twigsPalmDensity;
			case "redwood":
				return PVJConfig.bopworldgen.twigsRedwoodDensity;
			case "willow":
				return PVJConfig.bopworldgen.twigsWillowDensity;
			case "pine":
				return PVJConfig.bopworldgen.twigsPineDensity;
			case "mahogany":
				return PVJConfig.bopworldgen.twigsMahoganyDensity;
			case "ebony":
				return PVJConfig.bopworldgen.twigsEbonyDensity;
			case "eucalyptus":
				return PVJConfig.bopworldgen.twigsEucalyptusDensity;
			default:
				return 0;
		}
	}
}
