package vibrantjourneys.init;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.integration.biomesoplenty.PVJWorldGenerationBOP;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.WorldGenBracketFungus;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenCrackedSand;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenGroundCover;
import vibrantjourneys.worldgen.WorldGenFloaters;
import vibrantjourneys.worldgen.WorldGenMangroveRoot;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenPVJPlant;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenRiverGrass;
import vibrantjourneys.worldgen.WorldGenShortGrass;
import vibrantjourneys.worldgen.WorldGenSmallBush;

public class PVJWorldGen
{
	public static void initWorldGen()
	{	
		registerWorldGen(new WorldGenCobweb(PVJConfig.worldgen.cobwebDensity));
		
		registerWorldGen(new WorldGenPalmTreeBeach(PVJConfig.worldgen.palmDensity));
		registerWorldGen(new WorldGenMangroveTreeSwamp(PVJConfig.worldgen.mangroveDensity));
		
		if(PVJConfig.master.enableFallenTrees)
		{
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, PVJConfig.worldgen.fallenTreeAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.willow_log, PVJConfig.worldgen.fallenTreeWillowDensity, BiomeReference.getValidBiomes(BiomeReference.WILLOW_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.redwood_log, PVJConfig.worldgen.fallenTreeRedwoodDensity, BiomeReference.getValidBiomes(BiomeReference.REDWOOD_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.fir_log, PVJConfig.worldgen.fallenTreeFirDensity, BiomeReference.getValidBiomes(BiomeReference.FIR_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.pine_log, PVJConfig.worldgen.fallenTreePineDensity, BiomeReference.getValidBiomes(BiomeReference.PINE_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.aspen_log, PVJConfig.worldgen.fallenTreeAspenDensity, BiomeReference.getValidBiomes(BiomeReference.ASPEN_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.maple_log, PVJConfig.worldgen.fallenTreeMapleDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MAPLE_TREES)));
			registerWorldGen(new WorldGenFallenTree(PVJBlocks.baobab_log, PVJConfig.worldgen.fallenTreeBaobabDensity, BiomeReference.getValidBiomes(BiomeReference.BAOBAB_TREES)));
		}
		
		registerWorldGen(new WorldGenMangroveRoot(PVJConfig.worldgen.mangroveRootDensity, BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES)));
		
		registerWorldGen(new WorldGenSmallBush(PVJConfig.worldgen.bushDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
		
		if(PVJConfig.master.enableGroundcover)
		{
			if(PVJConfig.master.enableFallenLeaves)
			{
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
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_willow, PVJConfig.worldgen.fallenLeavesWillowDensity, BiomeReference.getValidBiomes(BiomeReference.WILLOW_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_mangrove, PVJConfig.worldgen.fallenLeavesMangroveDensity, BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_redwood, PVJConfig.worldgen.fallenLeavesRedwoodDensity, BiomeReference.getValidBiomes(BiomeReference.REDWOOD_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_palm, PVJConfig.worldgen.fallenLeavesPalmDensity, BiomeReference.getValidBiomes(BiomeReference.PALM_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_fir, PVJConfig.worldgen.fallenLeavesFirDensity, BiomeReference.getValidBiomes(BiomeReference.FIR_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_pine, PVJConfig.worldgen.fallenLeavesPineDensity, BiomeReference.getValidBiomes(BiomeReference.PINE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_aspen, PVJConfig.worldgen.fallenLeavesAspenDensity, BiomeReference.getValidBiomes(BiomeReference.ASPEN_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_red_maple, PVJConfig.worldgen.fallenLeavesRedMapleDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MAPLE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_orange_maple, PVJConfig.worldgen.fallenLeavesOrangeMapleDensity, BiomeReference.getValidBiomes(BiomeReference.ORANGE_MAPLE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_baobab, PVJConfig.worldgen.fallenLeavesBaobabDensity, BiomeReference.getValidBiomes(BiomeReference.BAOBAB_TREES)));
			}
			if(PVJConfig.master.enableRocks)
			{
				//surface
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 60, 200, PVJConfig.worldgen.stoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 60, 200, PVJConfig.worldgen.cobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.mossy_cobblestone_rocks, 40, 200, PVJConfig.worldgen.mossyCobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MOSSY_COBBLESTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 60, 200, PVJConfig.worldgen.andesiteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 60, 200, PVJConfig.worldgen.graniteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 60, 200, PVJConfig.worldgen.dioriteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.sandstone_rocks, 50, 100, PVJConfig.worldgen.sandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.SANDSTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.red_sandstone_rocks, 55, 75, PVJConfig.worldgen.redSandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
				
				//underground
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 1, 60, PVJConfig.worldgen.stoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 1, 60, PVJConfig.worldgen.cobblestoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 1, 60, PVJConfig.worldgen.andesiteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 1, 60, PVJConfig.worldgen.graniteCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 1, 60, PVJConfig.worldgen.dioriteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			}

			if(PVJConfig.master.enableTwigs)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.jungle_twigs, 60, 150, PVJConfig.worldgen.jungleTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.acacia_twigs, 60, 150, PVJConfig.worldgen.acaciaTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.dark_oak_twigs, 60, 150, PVJConfig.worldgen.darkOakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.willow_twigs, 60, 150, PVJConfig.worldgen.willowTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.WILLOW_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.mangrove_twigs, 60, 150, PVJConfig.worldgen.mangroveTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.palm_twigs, 60, 150, PVJConfig.worldgen.palmTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.PALM_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.fir_twigs, 60, 150, PVJConfig.worldgen.firTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.FIR_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.pine_twigs, 60, 150, PVJConfig.worldgen.pineTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.PINE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.aspen_twigs, 60, 150, PVJConfig.worldgen.aspenTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.ASPEN_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.red_maple_twigs, 60, 150, PVJConfig.worldgen.redMapleTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.RED_MAPLE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.orange_maple_twigs, 60, 150, PVJConfig.worldgen.orangeMapleTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.ORANGE_MAPLE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.baobab_twigs, 60, 100, PVJConfig.worldgen.baobabTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.BAOBAB_TREES)));
			}
			if(PVJConfig.master.enableBones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDesertDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 150, PVJConfig.worldgen.bonesNetherDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
			}
			if(PVJConfig.master.enableSeashells)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.seashells, 60, 80, PVJConfig.worldgen.seashellsDensity, BiomeReference.getValidBiomes(BiomeReference.BEACH_BIOMES)));
			}
			if(PVJConfig.master.enablePinecones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.pinecones, 60, 80, PVJConfig.worldgen.pineconesDensity, BiomeDictionary.getBiomes(Type.CONIFEROUS).toArray(new Biome[0])));
			}
		}

		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_wheat, 60, 90, PVJConfig.worldgen.wildWheatDensity, PVJBiomes.prairie));
		
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.crackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.red_cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.redCrackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
		
		registerWorldGen(new WorldGenShortGrass(PVJBlocks.short_grass, PVJConfig.worldgen.shortGrassDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		
		if(PVJConfig.master.enableOverworldPlants)
		{
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.frost_lotus, 60, 255, PVJConfig.worldgen.frostLotusDensity, BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.silverleaf, 60, 255, PVJConfig.worldgen.silverleafDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.chickweed, 60, 255, PVJConfig.worldgen.chickweedDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));	
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.clovers, 60, 255, PVJConfig.worldgen.cloversDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.crabgrass, 60, 255, PVJConfig.worldgen.crabgrassDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenFloaters(true, PVJConfig.worldgen.lilypadRiverDensity, true)); //for rivers
			registerWorldGen(new WorldGenFloaters(false, PVJConfig.worldgen.lilypadLakesDensity, false)); //for lakes
			registerWorldGen(new WorldGenBracketFungus(PVJConfig.worldgen.bracketFungusDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenRiverGrass(PVJConfig.worldgen.riverGrassDensity));
		}

		if(PVJConfig.master.enableNetherPlants)
		{
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.bloodnettle, 0, 255, PVJConfig.worldgen.bloodnettleDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.glowcap, 0, 255, PVJConfig.worldgen.glowcapDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
		}
		
		if(Reference.isBOPLoaded)
		{
			PVJWorldGenerationBOP.initWorldGenBOP();
		}
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		GameRegistry.registerWorldGenerator(worldgen, 0);
	}
}
