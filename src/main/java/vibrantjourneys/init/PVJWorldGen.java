package vibrantjourneys.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.PVJConfig;
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
		
		registerWorldGen(new WorldGenCobweb(PVJConfig.worldgen.cobwebDensity));
		
		registerWorldGen(new WorldGenPalmTreeBeach(PVJConfig.worldgen.palmDensity));
		registerWorldGen(new WorldGenWillowTreeSwamp(PVJConfig.worldgen.willowDensity));
		registerWorldGen(new WorldGenMangroveTreeSwamp(PVJConfig.worldgen.mangroveDensity));
		
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakDensity, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakSparseDensity, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchDensity, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchSparseDensity, BiomeReference.BIRCH_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceDensity, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceSparseDensity, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleDensity, BiomeReference.JUNGLE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakDensity, BiomeReference.DARK_OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_willow, PVJConfig.worldgen.fallenLeavesWillowDensity, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_mangrove, PVJConfig.worldgen.fallenLeavesMangroveDensity, BiomeReference.MANGROVE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_redwood, PVJConfig.worldgen.fallenLeavesRedwoodDensity, BiomeReference.REDWOOD_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_palm, PVJConfig.worldgen.fallenLeavesPalmDensity, BiomeReference.PALM_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.DEAD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenLilypad(true, PVJConfig.worldgen.lilypadRiverDensity, true)); //for rivers
		registerWorldGen(new WorldGenLilypad(false, PVJConfig.worldgen.lilypadLakesDensity, false)); //for lakes
		
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakDensity, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakSparseDensity, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchDensity, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchSparseDensity, BiomeReference.BIRCH_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceDensity, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceSparseDensity, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, PVJConfig.worldgen.fallenTreeAcaciaDensity, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.willow_log, PVJBlocks.willow_leaves, PVJConfig.worldgen.fallenTreeWillowDensity, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.redwood_log, PVJBlocks.redwood_leaves, PVJConfig.worldgen.fallenTreeRedwoodDensity, BiomeReference.REDWOOD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenMangroveRoot(PVJConfig.worldgen.mangroveRootDensity, BiomeReference.MANGROVE_TREE_BIOMES));
		
		registerWorldGen(new WorldGenSmallBush(PVJConfig.worldgen.bushDensity, BiomeReference.OAK_TREE_SPARSE_BIOMES));
	
		//surface
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 60, 100, PVJConfig.worldgen.stoneRocksDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 60, 100, PVJConfig.worldgen.cobblestoneRocksDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mossy_cobblestone_rocks, 40, 100, PVJConfig.worldgen.mossyCobblestoneRocksDensity, BiomeReference.MOSSY_COBBLESTONE_BOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 60, 100, PVJConfig.worldgen.andesiteRocksDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 60, 100, PVJConfig.worldgen.graniteRocksDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 60, 100, PVJConfig.worldgen.dioriteRocksDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.sandstone_rocks, 50, 100, PVJConfig.worldgen.sandstoneRocksDensity, BiomeReference.SANDSTONE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.red_sandstone_rocks, 55, 75, PVJConfig.worldgen.redSandstoneRocksDensity, BiomeReference.DEAD_TREE_BIOMES));
		
		//underground
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 1, 60, PVJConfig.worldgen.stoneRocksCaveDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 1, 60, PVJConfig.worldgen.cobblestoneRocksCaveDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 1, 60, PVJConfig.worldgen.andesiteRocksCaveDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 1, 60, PVJConfig.worldgen.graniteCaveDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 1, 60, PVJConfig.worldgen.dioriteRocksCaveDensity, BiomeReference.ALL_BIOMES_ARRAY));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, PVJConfig.worldgen.oakTwigsDensity, BiomeReference.OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, PVJConfig.worldgen.oakTwigsSparseDensity, BiomeReference.OAK_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, PVJConfig.worldgen.birchTwigsDensity, BiomeReference.BIRCH_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, PVJConfig.worldgen.birchTwigsSparseDensity, BiomeReference.BIRCH_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 100, PVJConfig.worldgen.spruceTwigsDensity, BiomeReference.SPRUCE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsSparseDensity, BiomeReference.SPRUCE_TREE_SPARSE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.jungle_twigs, 60, 120, PVJConfig.worldgen.jungleTwigsDensity, BiomeReference.JUNGLE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.acacia_twigs, 60, 100, PVJConfig.worldgen.acaciaTwigsDensity, BiomeReference.ACACIA_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.dark_oak_twigs, 60, 100, PVJConfig.worldgen.darkOakTwigsDensity, BiomeReference.DARK_OAK_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.willow_twigs, 60, 100, PVJConfig.worldgen.willowTwigsDensity, BiomeReference.WILLOW_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mangrove_twigs, 60, 100, PVJConfig.worldgen.mangroveTwigsDensity, BiomeReference.MANGROVE_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.palm_twigs, 60, 100, PVJConfig.worldgen.palmTwigsDensity, BiomeReference.PALM_TREE_BIOMES));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.redwood_twigs, 60, 100, PVJConfig.worldgen.redwoodTwigsDensity, BiomeReference.REDWOOD_TREE_BIOMES));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDensity, BiomeReference.ALL_BIOMES_ARRAY));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDesertDensity, BiomeDictionary.getBiomes(Type.SANDY).toArray(new Biome[0])));
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
