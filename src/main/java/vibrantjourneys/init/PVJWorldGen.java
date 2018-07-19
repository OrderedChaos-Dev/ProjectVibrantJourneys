package vibrantjourneys.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.worldgen.PVJDecorateEventHandler;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundLitter;
import vibrantjourneys.worldgen.WorldGenLilypad;
import vibrantjourneys.worldgen.WorldGenMangroveRoot;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenSmallBush;
import vibrantjourneys.worldgen.WorldGenWillowTreeSwamp;

public class PVJWorldGen
{
	public static void initWorldGen()
	{
		MinecraftForge.TERRAIN_GEN_BUS.register(new PVJDecorateEventHandler());
		
		registerWorldGen(new WorldGenCobweb());
		
		registerWorldGen(new WorldGenPalmTreeBeach());
		registerWorldGen(new WorldGenWillowTreeSwamp());
		registerWorldGen(new WorldGenMangroveTreeSwamp());
		
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, 45, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, 10, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, 35, BiomeReference.BIRCH_TREE_BIOMES));
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
		registerWorldGen(new WorldGenLilypad(false, 150, false)); //for lakes
		
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, 25, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, 2, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, 20, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, 25, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, 10, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, 15, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.willow_log, PVJBlocks.willow_leaves, 30, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.redwood_log, PVJBlocks.redwood_leaves, 50, BiomeReference.REDWOOD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenMangroveRoot(2, BiomeReference.MANGROVE_TREE_BIOMES));
		
		registerWorldGen(new WorldGenSmallBush(3, BiomeReference.OAK_TREE_SPARSE_BIOMES));
	
		//surface
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 60, 100, 400, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 60, 100, 250, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mossy_cobblestone_rocks, 40, 100, 90, BiomeReference.MOSSY_COBBLESTONE_BOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 60, 100, 150, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 60, 100, 150, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 60, 100, 150, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.sandstone_rocks, 50, 100, 200, BiomeReference.SANDSTONE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.red_sandstone_rocks, 55, 75, 200, BiomeReference.DEAD_TREE_BIOMES));
		
		//underground
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 1, 60, 250, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 1, 60, 400, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 1, 60, 150, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 1, 60, 150, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 1, 60, 150, BiomeReference.ALL_BIOMES_ARRAY));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, 300, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, 50, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, 300, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, 50, BiomeReference.BIRCH_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 100, 300, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 150, 70, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.jungle_twigs, 60, 120, 700, BiomeReference.JUNGLE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.acacia_twigs, 60, 100, 50, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.dark_oak_twigs, 60, 100, 400, BiomeReference.DARK_OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.willow_twigs, 60, 100, 400, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mangrove_twigs, 60, 100, 100, BiomeReference.MANGROVE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.palm_twigs, 60, 100, 30, BiomeReference.PALM_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.redwood_twigs, 60, 100, 600, BiomeReference.REDWOOD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, 10, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, 90, BiomeDictionary.getBiomes(Type.SANDY).toArray(new Biome[0])));
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
