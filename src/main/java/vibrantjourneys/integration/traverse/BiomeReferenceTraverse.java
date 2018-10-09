package vibrantjourneys.integration.traverse;

import prospector.traverse.world.TraverseWorld;
import vibrantjourneys.util.BiomeReference;

public class BiomeReferenceTraverse
{
	public static void loadTraverseBiomes()
	{
		BiomeReference.OAK_TREES.add(TraverseWorld.woodlandsBiome);
		BiomeReference.OAK_TREES.add(TraverseWorld.lushSwampBiome);
		BiomeReference.OAK_TREES.add(TraverseWorld.forestedHillsBiome);
		BiomeReference.OAK_TREES.add(TraverseWorld.lushHillsBiome);
		BiomeReference.OAK_TREES.add(TraverseWorld.thicketBiome);
		
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.aridHighlandBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.autumnalWoodsBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.autumnalWoodedHillsBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.badlandsBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.miniJungleBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.meadowBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.rockyPlainsBiome);
		BiomeReference.OAK_TREES_SPARSE.add(TraverseWorld.rockyPlateauBiome);
		
		BiomeReference.BIRCH_TREES.add(TraverseWorld.birchForestedHillsBiome);
		
		BiomeReference.BIRCH_TREES_SPARSE.add(TraverseWorld.forestedHillsBiome);

		BiomeReference.JUNGLE_TREES.add(TraverseWorld.miniJungleBiome);
		
		BiomeReference.ACACIA_TREES_SPARSE.add(TraverseWorld.aridHighlandBiome);
		
		BiomeReference.TRAVERSE_ORANGE_AUTUMN_TREES.add(TraverseWorld.autumnalWoodsBiome);
		BiomeReference.TRAVERSE_ORANGE_AUTUMN_TREES.add(TraverseWorld.autumnalWoodedHillsBiome);
		
		BiomeReference.TRAVERSE_YELLOW_AUTUMN_TREES.add(TraverseWorld.autumnalWoodsBiome);
		BiomeReference.TRAVERSE_YELLOW_AUTUMN_TREES.add(TraverseWorld.autumnalWoodedHillsBiome);
		
		BiomeReference.TRAVERSE_RED_AUTUMN_TREES.add(TraverseWorld.autumnalWoodsBiome);
		BiomeReference.TRAVERSE_RED_AUTUMN_TREES.add(TraverseWorld.autumnalWoodedHillsBiome);
		
		BiomeReference.TRAVERSE_BROWN_AUTUMN_TREES.add(TraverseWorld.autumnalWoodsBiome);
		BiomeReference.TRAVERSE_BROWN_AUTUMN_TREES.add(TraverseWorld.autumnalWoodedHillsBiome);
		
		BiomeReference.TRAVERSE_FIR_TREES.add(TraverseWorld.snowyConiferousForestBiome);
		BiomeReference.TRAVERSE_FIR_TREES.add(TraverseWorld.temperateRainforestBiome);
	}
}