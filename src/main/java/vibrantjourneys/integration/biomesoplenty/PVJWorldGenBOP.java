package vibrantjourneys.integration.biomesoplenty;

import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundCover;

public class PVJWorldGenBOP
{
	public static void initWorldGenBOP()
	{
		if(PVJConfig.master.enableFallenTrees)
		{
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.FIR_LOG, PVJConfig.integration.bopworldgen.fallenTreeFirDensity, BiomeReference.getBiomes(BiomeReference.BOP_FIR_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.JACARANDA_LOG, PVJConfig.integration.bopworldgen.fallenTreeJacarandaDensity, BiomeReference.getBiomes(BiomeReference.BOP_JACARANDA_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.WILLOW_LOG, PVJConfig.integration.bopworldgen.fallenTreeWillowDensity, BiomeReference.getBiomes(BiomeReference.BOP_WILLOW_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.PINE_LOG, PVJConfig.integration.bopworldgen.fallenTreePineDensity, BiomeReference.getBiomes(BiomeReference.BOP_PINE_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.CHERRY_LOG, PVJConfig.integration.bopworldgen.fallenTreeCherryDensity, BiomeReference.getBiomes(BiomeReference.BOP_PINK_CHERRY_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.DEAD_LOG, PVJConfig.integration.bopworldgen.fallenTreeDeadDensity, BiomeReference.getBiomes(BiomeReference.BOP_DEAD_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.EBONY_LOG, PVJConfig.integration.bopworldgen.fallenTreeEbonyDensity, BiomeReference.getBiomes(BiomeReference.BOP_EBONY_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.EUCALYPTUS_LOG, PVJConfig.integration.bopworldgen.fallenTreeEucalyptusDensity, BiomeReference.getBiomes(BiomeReference.BOP_EUCALYPTUS_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.MAHOGONY_LOG, PVJConfig.integration.bopworldgen.fallenTreeMahoganyDensity, BiomeReference.getBiomes(BiomeReference.BOP_MAHOGANY_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.MAGIC_LOG, PVJConfig.integration.bopworldgen.fallenTreeMagicDensity, BiomeReference.getBiomes(BiomeReference.BOP_MAGIC_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.PALM_LOG, PVJConfig.integration.bopworldgen.fallenTreePalmDensity, BiomeReference.getBiomes(BiomeReference.BOP_PALM_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.MANGROVE_LOG, PVJConfig.integration.bopworldgen.fallenTreeMangroveDensity, BiomeReference.getBiomes(BiomeReference.BOP_MANGROVE_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.REDWOOD_LOG, PVJConfig.integration.bopworldgen.fallenTreeRedwoodDensity, BiomeReference.getBiomes(BiomeReference.BOP_REDWOOD_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.SACRED_OAK_LOG, PVJConfig.integration.bopworldgen.fallenTreeSacredOakDensity, BiomeReference.getBiomes(BiomeReference.BOP_SACRED_OAK_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReferenceBOP.UMBRAN_LOG, PVJConfig.integration.bopworldgen.fallenTreeUmbranDensity, BiomeReference.getBiomes(BiomeReference.BOP_UMBRAN_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReference.OAK_LOG, PVJConfig.integration.bopworldgen.fallenTreeMapleDensity, BiomeReference.getBiomes(BiomeReference.BOP_MAPLE_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(
					BiomeReference.OAK_LOG, PVJConfig.integration.bopworldgen.fallenTreeAutumnDensity, BiomeReference.getBiomes(BiomeReference.BOP_YELLOW_AUTUMN_TREES)));
		}

		if(PVJConfig.master.enableGroundcover)
		{
			if(PVJConfig.master.enableFallenLeaves)
			{
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(
						PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getBiomes(BiomeReference.BOP_DEAD_TREES)));
				
				for(BOPBlockInfo info : PVJBlocksBOP.BLOCK_INFO_FALLENLEAVES)
				{
					PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(info.getBlock(), info.getWorldGenDensity(), info.getBiomes()));
				}
			}
			if(PVJConfig.master.enableTwigs)
			{
				for(BOPBlockInfo info : PVJBlocksBOP.BLOCK_INFO_TWIGS)
				{
					PVJWorldGen.registerWorldGen(new WorldGenGroundCover(info.getBlock(), 60, 150, info.getWorldGenDensity(), info.getBiomes()));
				}
			}
		}
	}
	
	public static int getDensityFallenLeaves(String name)
	{
		switch(name)
		{
			case "bamboo":
				return PVJConfig.integration.bopworldgen.fallenLeavesBambooDensity;
			case "magic":
				return PVJConfig.integration.bopworldgen.fallenLeavesMagicDensity;
			case "yellow_autumn":
				return PVJConfig.integration.bopworldgen.fallenLeavesYellowAutumnDensity;
			case "orange_autumn":
				return PVJConfig.integration.bopworldgen.fallenLeavesOrangeAutumnDensity;
			case "umbran":
				return PVJConfig.integration.bopworldgen.fallenLeavesUmbranDensity;
			case "fir":
				return PVJConfig.integration.bopworldgen.fallenLeavesFirDensity;
			case "pink_cherry":
				return PVJConfig.integration.bopworldgen.fallenLeavesPinkCherryDensity;
			case "white_cherry":
				return PVJConfig.integration.bopworldgen.fallenLeavesWhiteCherryDensity;
			case "maple":
				return PVJConfig.integration.bopworldgen.fallenLeavesMapleDensity;
			case "hellbark":
				return PVJConfig.integration.bopworldgen.fallenLeavesHellbarkDensity;
			case "flowering":
				return PVJConfig.integration.bopworldgen.fallenLeavesFloweringOakDensity;
			case "jacaranda":
				return PVJConfig.integration.bopworldgen.fallenLeavesJacarandaDensity;
			case "sacred_oak":
				return PVJConfig.integration.bopworldgen.fallenLeavesSacredOakDensity;
			case "mangrove":
				return PVJConfig.integration.bopworldgen.fallenLeavesMangroveDensity;
			case "palm":
				return PVJConfig.integration.bopworldgen.fallenLeavesPalmDensity;
			case "redwood":
				return PVJConfig.integration.bopworldgen.fallenLeavesRedwoodDensity;
			case "willow":
				return PVJConfig.integration.bopworldgen.fallenLeavesWillowDensity;
			case "pine":
				return PVJConfig.integration.bopworldgen.fallenLeavesPineDensity;
			case "mahogany":
				return PVJConfig.integration.bopworldgen.fallenLeavesMahoganyDensity;
			case "ebony":
				return PVJConfig.integration.bopworldgen.fallenLeavesEbonyDensity;
			case "eucalyptus":
				return PVJConfig.integration.bopworldgen.fallenLeavesEucalyptusDensity;
			default:
				return 0;
		}
	}
	
	public static int getDensityTwigs(String name)
	{
		switch(name)
		{
			case "magic":
				return PVJConfig.integration.bopworldgen.twigsMagicDensity;
			case "yellow_autumn":
				return PVJConfig.integration.bopworldgen.twigsAutumnDensity;
			case "orange_autumn":
				return PVJConfig.integration.bopworldgen.twigsAutumnDensity;
			case "umbran":
				return PVJConfig.integration.bopworldgen.twigsUmbranDensity;
			case "fir":
				return PVJConfig.integration.bopworldgen.twigsFirDensity;
			case "pink_cherry":
				return PVJConfig.integration.bopworldgen.twigsCherryDensity;
			case "white_cherry":
				return PVJConfig.integration.bopworldgen.twigsCherryDensity;
			case "maple":
				return PVJConfig.integration.bopworldgen.twigsMapleDensity;
			case "hellbark":
				return PVJConfig.integration.bopworldgen.twigsHellbarkDensity;
			case "jacaranda":
				return PVJConfig.integration.bopworldgen.twigsJacarandaDensity;
			case "sacred_oak":
				return PVJConfig.integration.bopworldgen.twigsSacredOakDensity;
			case "mangrove":
				return PVJConfig.integration.bopworldgen.twigsMangroveDensity;
			case "palm":
				return PVJConfig.integration.bopworldgen.twigsPalmDensity;
			case "redwood":
				return PVJConfig.integration.bopworldgen.twigsRedwoodDensity;
			case "willow":
				return PVJConfig.integration.bopworldgen.twigsWillowDensity;
			case "pine":
				return PVJConfig.integration.bopworldgen.twigsPineDensity;
			case "mahogany":
				return PVJConfig.integration.bopworldgen.twigsMahoganyDensity;
			case "ebony":
				return PVJConfig.integration.bopworldgen.twigsEbonyDensity;
			case "eucalyptus":
				return PVJConfig.integration.bopworldgen.twigsEucalyptusDensity;
			default:
				return 0;
		}
	}
}
