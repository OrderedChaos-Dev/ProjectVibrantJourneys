package vibrantjourneys.integration.traverse;

import prospector.traverse.world.WorldGenConstants;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundCover;

public class PVJWorldGenTraverse
{
	public static void initWorldGenBOP()
	{
		if(PVJConfig.master.enableFallenTrees)
		{
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.integration.traverseworldgen.fallenTreeAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_BROWN_AUTUMN_TREES)));
			PVJWorldGen.registerWorldGen(new WorldGenFallenTree(WorldGenConstants.FIR_LOG, PVJConfig.integration.traverseworldgen.fallenTreeFirDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_FIR_TREES)));
		}
		if(PVJConfig.master.enableGroundcover)
		{
			if(PVJConfig.master.enableFallenLeaves)
			{
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(PVJBlocksTraverse.red_autumn_fallen_leaves, PVJConfig.integration.traverseworldgen.fallenLeavesRedAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_RED_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(PVJBlocksTraverse.brown_autumn_fallen_leaves, PVJConfig.integration.traverseworldgen.fallenLeavesBrownAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_BROWN_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(PVJBlocksTraverse.orange_autumn_fallen_leaves, PVJConfig.integration.traverseworldgen.fallenLeavesOrangeAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_ORANGE_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(PVJBlocksTraverse.yellow_autumn_fallen_leaves, PVJConfig.integration.traverseworldgen.fallenLeavesYellowAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_YELLOW_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenFallenLeaves(PVJBlocksTraverse.fir_fallen_leaves, PVJConfig.integration.traverseworldgen.fallenLeavesFirDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_FIR_TREES)));
			}
			if(PVJConfig.master.enableTwigs)
			{
				PVJWorldGen.registerWorldGen(new WorldGenGroundCover(PVJBlocksTraverse.red_autumn_twigs, 60, 150, PVJConfig.integration.traverseworldgen.twigsRedAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_RED_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenGroundCover(PVJBlocksTraverse.brown_autumn_twigs, 60, 150, PVJConfig.integration.traverseworldgen.twigsBrownAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_BROWN_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenGroundCover(PVJBlocksTraverse.orange_autumn_twigs, 60, 150, PVJConfig.integration.traverseworldgen.twigsOrangeAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_ORANGE_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenGroundCover(PVJBlocksTraverse.yellow_autumn_twigs, 60, 150, PVJConfig.integration.traverseworldgen.twigsYellowAutumnDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_YELLOW_AUTUMN_TREES)));
				PVJWorldGen.registerWorldGen(new WorldGenGroundCover(PVJBlocksTraverse.fir_twigs, 60, 150, PVJConfig.integration.traverseworldgen.twigsFirDensity, BiomeReference.getValidBiomes(BiomeReference.TRAVERSE_FIR_TREES)));
			}
		}
	}
}
