package vibrantjourneys.init;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.worldgen.PVJDecorateEventHandler;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenLilypad;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenWillowTreeSwamp;

public class PVJWorldGen
{
	public static void initWorldGen()
	{
		registerWorldGen(new WorldGenCobweb());
		
		registerWorldGen(new WorldGenPalmTreeBeach());
		registerWorldGen(new WorldGenWillowTreeSwamp());
		registerWorldGen(new WorldGenMangroveTreeSwamp());
		
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, 50, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, 10, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, 50, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, 10, BiomeReference.BIRCH_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, 50, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, 10, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, 60, BiomeReference.JUNGLE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, 50, BiomeReference.DARK_OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, 10, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_willow, 40, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_mangrove, 10, BiomeReference.MANGROVE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_redwood, 70, BiomeReference.REDWOOD_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_palm, 15, BiomeReference.PALM_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, 20, BiomeReference.DEAD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenLilypad(true, 20, true)); //for rivers
		registerWorldGen(new WorldGenLilypad(false, 100, false)); //for lakes
		
		MinecraftForge.TERRAIN_GEN_BUS.register(new PVJDecorateEventHandler());
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
