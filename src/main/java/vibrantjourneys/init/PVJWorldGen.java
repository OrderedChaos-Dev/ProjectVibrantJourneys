package vibrantjourneys.init;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.integration.biomesoplenty.PVJWorldGenerationBOP;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.PVJDecorateEventHandler;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenCrackedSand;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundLitter;
import vibrantjourneys.worldgen.WorldGenLilypad;
import vibrantjourneys.worldgen.WorldGenMangroveRoot;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenSmallBush;
import vibrantjourneys.worldgen.WorldGenWildWheat;
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
		
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakDensity, BiomeReference.OAK_TREES.toArray(new Biome[0])));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleSparseDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_willow, PVJConfig.worldgen.fallenLeavesWillowDensity, BiomeReference.getValidBiomes(BiomeReference.WEEPING_WILLOW_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_mangrove, PVJConfig.worldgen.fallenLeavesMangroveDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MANGROVE_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_redwood, PVJConfig.worldgen.fallenLeavesRedwoodDensity, BiomeReference.getValidBiomes(BiomeReference.COAST_REDWOOD_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_palm, PVJConfig.worldgen.fallenLeavesPalmDensity, BiomeReference.getValidBiomes(BiomeReference.COCONUT_PALM_TREES)));
		registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
		
		registerWorldGen(new WorldGenLilypad(true, PVJConfig.worldgen.lilypadRiverDensity, true)); //for rivers
		registerWorldGen(new WorldGenLilypad(false, PVJConfig.worldgen.lilypadLakesDensity, false)); //for lakes
		
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
		registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, PVJConfig.worldgen.fallenTreeAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.willow_log, PVJBlocks.willow_leaves, PVJConfig.worldgen.fallenTreeWillowDensity, BiomeReference.getValidBiomes(BiomeReference.WEEPING_WILLOW_TREES)));
		registerWorldGen(new WorldGenFallenTree(PVJBlocks.redwood_log, PVJBlocks.redwood_leaves, PVJConfig.worldgen.fallenTreeRedwoodDensity, BiomeReference.getValidBiomes(BiomeReference.COAST_REDWOOD_TREES)));
		
		registerWorldGen(new WorldGenMangroveRoot(PVJConfig.worldgen.mangroveRootDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MANGROVE_TREES)));
		
		registerWorldGen(new WorldGenSmallBush(PVJConfig.worldgen.bushDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
	
		//surface
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 60, 200, PVJConfig.worldgen.stoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 60, 200, PVJConfig.worldgen.cobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mossy_cobblestone_rocks, 40, 200, PVJConfig.worldgen.mossyCobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MOSSY_COBBLESTONE_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 60, 200, PVJConfig.worldgen.andesiteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 60, 200, PVJConfig.worldgen.graniteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 60, 200, PVJConfig.worldgen.dioriteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.sandstone_rocks, 50, 100, PVJConfig.worldgen.sandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.SANDSTONE_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.red_sandstone_rocks, 55, 75, PVJConfig.worldgen.redSandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
		
		//underground
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.stone_rocks, 1, 60, PVJConfig.worldgen.stoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.cobblestone_rocks, 1, 60, PVJConfig.worldgen.cobblestoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.andesite_rocks, 1, 60, PVJConfig.worldgen.andesiteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.granite_rocks, 1, 60, PVJConfig.worldgen.graniteCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.diorite_rocks, 1, 60, PVJConfig.worldgen.dioriteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, PVJConfig.worldgen.oakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.oak_twigs, 60, 100, PVJConfig.worldgen.oakTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, PVJConfig.worldgen.birchTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.birch_twigs, 60, 100, PVJConfig.worldgen.birchTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 100, PVJConfig.worldgen.spruceTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.jungle_twigs, 60, 120, PVJConfig.worldgen.jungleTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.acacia_twigs, 60, 100, PVJConfig.worldgen.acaciaTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.dark_oak_twigs, 60, 100, PVJConfig.worldgen.darkOakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.willow_twigs, 60, 100, PVJConfig.worldgen.willowTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.WEEPING_WILLOW_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.mangrove_twigs, 60, 100, PVJConfig.worldgen.mangroveTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MANGROVE_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.palm_twigs, 60, 100, PVJConfig.worldgen.palmTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.COCONUT_PALM_TREES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.redwood_twigs, 60, 100, PVJConfig.worldgen.redwoodTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.COAST_REDWOOD_TREES)));
		
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDesertDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
		registerWorldGen(new WorldGenGroundLitter(PVJBlocks.bones, 1, 150, PVJConfig.worldgen.bonesNetherDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
		
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.crackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.red_cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.redCrackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
		
		registerWorldGen(new WorldGenWildWheat(PVJBlocks.wild_wheat, 60, 90, PVJConfig.worldgen.wildWheatDensity, PVJBiomes.prairie));
		
		if(Reference.isBOPLoaded)
		{
			PVJWorldGenerationBOP.initWorldGenBOP();
		}
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
