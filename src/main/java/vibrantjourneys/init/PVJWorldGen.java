package vibrantjourneys.init;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.integration.biomesoplenty.PVJWorldGenBOP;
import vibrantjourneys.integration.traverse.PVJWorldGenTraverse;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumStoneType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.WorldGenAbandonedFarm;
import vibrantjourneys.worldgen.WorldGenBeachGrass;
import vibrantjourneys.worldgen.WorldGenBoulder;
import vibrantjourneys.worldgen.WorldGenBracketFungus;
import vibrantjourneys.worldgen.WorldGenCattail;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenCrackedSand;
import vibrantjourneys.worldgen.WorldGenDesertCaves;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenFloaters;
import vibrantjourneys.worldgen.WorldGenFlouropore;
import vibrantjourneys.worldgen.WorldGenFlowerPatch;
import vibrantjourneys.worldgen.WorldGenFrozenCaves;
import vibrantjourneys.worldgen.WorldGenGroundCover;
import vibrantjourneys.worldgen.WorldGenJuniperTreeMesa;
import vibrantjourneys.worldgen.WorldGenMangroveRoot;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenMud;
import vibrantjourneys.worldgen.WorldGenOvergrownCaves;
import vibrantjourneys.worldgen.WorldGenPVJPlant;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenPillowBasalt;
import vibrantjourneys.worldgen.WorldGenRiverGrass;
import vibrantjourneys.worldgen.WorldGenRocks;
import vibrantjourneys.worldgen.WorldGenRuins;
import vibrantjourneys.worldgen.WorldGenSeaOats;
import vibrantjourneys.worldgen.WorldGenShortGrass;
import vibrantjourneys.worldgen.WorldGenSmallBush;
import vibrantjourneys.worldgen.WorldGenStalactite;
import vibrantjourneys.worldgen.WorldGenStalagmite;
import vibrantjourneys.worldgen.WorldGenTerracottaCaves;

public class PVJWorldGen
{	
	public static int[] dimensionBlacklist;
	public static void initWorldGen()
	{	
		dimensionBlacklist = getDimensionBlacklist();
		registerWorldGen(new WorldGenCobweb(PVJConfig.worldgen.cobwebDensity));
		
		registerWorldGen(new WorldGenPalmTreeBeach(PVJConfig.worldgen.palmDensity));
		registerWorldGen(new WorldGenMangroveTreeSwamp(PVJConfig.worldgen.mangroveDensity));
		registerWorldGen(new WorldGenJuniperTreeMesa(PVJConfig.worldgen.juniperDensity));
		
		registerWorldGen(new WorldGenBoulder(PVJConfig.worldgen.boulderDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
		
		if(PVJConfig.master.enableCaves)
		{
			registerWorldGen(new WorldGenStalagmite(PVJBlocks.rock_formation, 0, 70, PVJConfig.worldgen.stalagmiteDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenStalactite(PVJBlocks.rock_formation, 0, 70, PVJConfig.worldgen.stalactiteDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenStalactite(PVJBlocks.ice_formation, 0, 70, PVJConfig.worldgen.icicleDensity, BiomeReference.getBiomes(BiomeReference.SNOWY_BIOMES)));
			
			
			if(PVJConfig.worldgen.enableOvergrownCaves)
				registerWorldGen(new WorldGenOvergrownCaves(BiomeReference.getBiomes(BiomeReference.MANGROVE_TREES)));
			
			if(PVJConfig.worldgen.enableFrozenCaves)
				registerWorldGen(new WorldGenFrozenCaves(BiomeReference.getBiomes(BiomeReference.SNOWY_BIOMES)));
			
			if(PVJConfig.worldgen.enableSandstoneCaves)
				registerWorldGen(new WorldGenDesertCaves(BiomeReference.getBiomes(BiomeReference.DESERT_BIOMES)));
			
			if(PVJConfig.worldgen.enableTerracottaCaves)
				registerWorldGen(new WorldGenTerracottaCaves(BiomeReference.getBiomes(BiomeReference.MESA_BIOMES)));
		}
		else
			ProjectVibrantJourneys.logger.info("Cave stuff disabled");
		
		if(PVJConfig.master.enableStoneTypeBlocks)
		{
			registerWorldGen(new WorldGenPillowBasalt(PVJConfig.worldgen.pillowBasaltDensity));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.BASALT.getID()), 14, 65, PVJConfig.worldgen.basaltDensity, BiomeDictionary.getBiomes(Type.OCEAN).toArray(new Biome[0])));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.LIMESTONE.getID()), 14, 70, PVJConfig.worldgen.limestoneDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.MARBLE.getID()), 9, 70, PVJConfig.worldgen.marbleDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.SILTSTONE.getID()), 15, 65, PVJConfig.worldgen.siltstoneDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));
			//registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.GNEISS.getID()), 9, 70, PVJConfig.worldgen.gneissDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
		}
		
		registerWorldGen(new WorldGenMud(PVJConfig.worldgen.mudDensity, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[0])));
		
		if(PVJConfig.master.enableFallenTrees)
		{
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakSparseDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchSparseDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceSparseDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, PVJConfig.worldgen.fallenTreeAcaciaDensity, BiomeReference.getBiomes(BiomeReference.ACACIA_TREES)));
			
			for(EnumWoodType woodType : EnumWoodType.values())
			{
				if(woodType.getFallenTreeDensity() != -1)
				{
					if(woodType.getTreeDensity() > 0)
						registerWorldGen(new WorldGenFallenTree(PVJBlocks.LOGS.get(woodType.getID()), woodType.getFallenTreeDensity(), woodType.getTreeBiomes()));
				}
			}
		}
		else
			ProjectVibrantJourneys.logger.info("Fallen trees disabled");
		
		registerWorldGen(new WorldGenMangroveRoot(PVJConfig.worldgen.mangroveRootDensity, BiomeReference.getBiomes(BiomeReference.MANGROVE_TREES)));
		
		registerWorldGen(new WorldGenSmallBush(PVJConfig.worldgen.bushDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES_SPARSE)));
		
		if(PVJConfig.master.enableGroundcover)
		{
			if(PVJConfig.master.enableFallenLeaves)
			{
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakDensity, BiomeReference.OAK_TREES.toArray(new Biome[0])));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakSparseDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchSparseDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceSparseDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleDensity, BiomeReference.getBiomes(BiomeReference.JUNGLE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleSparseDensity, BiomeReference.getBiomes(BiomeReference.JUNGLE_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakDensity, BiomeReference.getBiomes(BiomeReference.DARKOAK_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakSparseDensity, BiomeReference.getBiomes(BiomeReference.DARKOAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getBiomes(BiomeReference.ACACIA_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getBiomes(BiomeReference.ACACIA_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getBiomes(BiomeReference.MESA_BIOMES)));
				
				for(EnumLeafType leafType : EnumLeafType.values())
				{
					if(leafType.getFallenLeavesDensity() != -1)
						if(leafType.getWoodType().getTreeDensity() > 0)
							registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.FALLEN_LEAVES.get(leafType.getID()), leafType.getFallenLeavesDensity(), leafType.getTreeBiomes()));
				}
			}
			else
				ProjectVibrantJourneys.logger.info("Fallen leaves disabled");
			if(PVJConfig.master.enableRocks)
			{
				//surface
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 60, 200, PVJConfig.worldgen.stoneRocksDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 60, 200, PVJConfig.worldgen.cobblestoneRocksDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.mossy_cobblestone_rocks, 40, 200, PVJConfig.worldgen.mossyCobblestoneRocksDensity, BiomeReference.getBiomes(BiomeReference.MOSSY_COBBLESTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 60, 200, PVJConfig.worldgen.andesiteRocksDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 60, 200, PVJConfig.worldgen.graniteRocksDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 60, 200, PVJConfig.worldgen.dioriteRocksDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.sandstone_rocks, 50, 100, PVJConfig.worldgen.sandstoneRocksDensity, BiomeReference.getBiomes(BiomeReference.SANDSTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.red_sandstone_rocks, 55, 75, PVJConfig.worldgen.redSandstoneRocksDensity, BiomeReference.getBiomes(BiomeReference.MESA_BIOMES)));
				
				//underground
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 1, 60, PVJConfig.worldgen.stoneRocksCaveDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 1, 60, PVJConfig.worldgen.cobblestoneRocksCaveDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 1, 60, PVJConfig.worldgen.andesiteRocksCaveDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 1, 60, PVJConfig.worldgen.graniteCaveDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 1, 60, PVJConfig.worldgen.dioriteRocksCaveDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			}
			else
				ProjectVibrantJourneys.logger.info("Rocks disabled");

			if(PVJConfig.master.enableTwigs)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsSparseDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsSparseDensity, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsSparseDensity, BiomeReference.getBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.jungle_twigs, 60, 150, PVJConfig.worldgen.jungleTwigsDensity, BiomeReference.getBiomes(BiomeReference.JUNGLE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.acacia_twigs, 60, 150, PVJConfig.worldgen.acaciaTwigsDensity, BiomeReference.getBiomes(BiomeReference.ACACIA_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.dark_oak_twigs, 60, 150, PVJConfig.worldgen.darkOakTwigsDensity, BiomeReference.getBiomes(BiomeReference.DARKOAK_TREES)));
				for(EnumLeafType leafType : EnumLeafType.values())
				{
					if(leafType.getTwigsDensity() != -1)
						if(leafType.getWoodType().getTreeDensity() > 0)
							registerWorldGen(new WorldGenGroundCover(PVJBlocks.TWIGS.get(leafType.getID()), 60, 150, leafType.getTwigsDensity(), leafType.getTreeBiomes()));
				}
			}
			else
				ProjectVibrantJourneys.logger.info("Twigs disabled");
			if(PVJConfig.master.enableBones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDesertDensity, BiomeReference.getBiomes(BiomeReference.DESERT_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 150, PVJConfig.worldgen.bonesNetherDensity, BiomeReference.getBiomes(BiomeReference.NETHER_BIOMES)));
			}
			else
				ProjectVibrantJourneys.logger.info("Bones disabled");
			if(PVJConfig.master.enableSeashells)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.seashells, 60, 80, PVJConfig.worldgen.seashellsDensity, BiomeReference.getBiomes(BiomeReference.BEACH_BIOMES)));
			}
			else
				ProjectVibrantJourneys.logger.info("Seashells disabled :(");
			if(PVJConfig.master.enablePinecones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.pinecones, 60, 80, PVJConfig.worldgen.pineconesDensity, BiomeDictionary.getBiomes(Type.CONIFEROUS).toArray(new Biome[0])));
			}
			else
				ProjectVibrantJourneys.logger.info("Pinecones took a long time to model...and you disabled them!");
			if(PVJConfig.master.enableFlowerPatches)
			{
				registerWorldGen(new WorldGenFlowerPatch(PVJConfig.worldgen.flowerPatchDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			}
			else
				ProjectVibrantJourneys.logger.info("Flower patches disabled");
		}
		else
			ProjectVibrantJourneys.logger.info("Groundcover disabled. You're a boring person!");

		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_wheat, PVJConfig.worldgen.wildWheatDensity, PVJBiomes.prairie));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_potato, PVJConfig.worldgen.wildPotatoDensity, Biomes.PLAINS));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_carrot, PVJConfig.worldgen.wildCarrotDensity, BiomeDictionary.getBiomes(Type.COLD).toArray(new Biome[0])));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_beetroot, PVJConfig.worldgen.wildBeetrootDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES)));
		
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.crackedSandDensity, BiomeReference.getBiomes(BiomeReference.DESERT_BIOMES)));
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.red_cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.redCrackedSandDensity, BiomeReference.getBiomes(BiomeReference.MESA_BIOMES)));
		
		if(PVJConfig.master.enableOverworldPlants)
		{
			registerWorldGen(new WorldGenShortGrass(PVJBlocks.short_grass, PVJConfig.worldgen.shortGrassDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.frost_lotus, PVJConfig.worldgen.frostLotusDensity, BiomeReference.getBiomes(BiomeReference.SNOWY_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.sundew, PVJConfig.worldgen.sundewDensity, BiomeDictionary.getBiomes(Type.SWAMP).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.silverleaf, PVJConfig.worldgen.silverleafDensity, BiomeReference.getBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.chickweed, PVJConfig.worldgen.chickweedDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));	
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.clovers, PVJConfig.worldgen.cloversDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.crabgrass, PVJConfig.worldgen.crabgrassDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.waxcap, PVJConfig.worldgen.waxcapDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.orange_mushroom, PVJConfig.worldgen.orangeMushroomDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.deathcap, PVJConfig.worldgen.deathcapDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.small_cactus, PVJConfig.worldgen.smallCactusDensity, BiomeReference.getBiomes(BiomeReference.DESERT_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.small_cactus, PVJConfig.worldgen.smallCactusDensity, BiomeReference.getBiomes(BiomeReference.MESA_BIOMES)));
			registerWorldGen(new WorldGenBeachGrass(PVJConfig.worldgen.beachGrassDensity, BiomeReference.getBiomes(BiomeReference.BEACH_BIOMES)));
			registerWorldGen(new WorldGenSeaOats(PVJConfig.worldgen.seaOatsDensity, BiomeReference.getBiomes(BiomeReference.BEACH_BIOMES)));
			registerWorldGen(new WorldGenFloaters(true, PVJConfig.worldgen.lilypadRiverDensity, true)); //for rivers
			registerWorldGen(new WorldGenFloaters(false, PVJConfig.worldgen.lilypadLakesDensity, false)); //for lakes
			registerWorldGen(new WorldGenBracketFungus(PVJConfig.worldgen.bracketFungusDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenFlouropore(PVJConfig.worldgen.flouroporeDensity, BiomeReference.getBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenRiverGrass(PVJConfig.worldgen.riverGrassDensity));
			registerWorldGen(new WorldGenCattail(PVJConfig.worldgen.cattailDensity, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES)));
		}
		else
			ProjectVibrantJourneys.logger.info("Overworld plants disabled");

		if(PVJConfig.master.enableNetherPlants)
		{
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.bloodnettle, PVJConfig.worldgen.bloodnettleDensity, WorldGenPVJPlant.NETHER, BiomeReference.getBiomes(BiomeReference.NETHER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.glowcap, PVJConfig.worldgen.glowcapDensity, WorldGenPVJPlant.NETHER, BiomeReference.getBiomes(BiomeReference.NETHER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.witherweed, PVJConfig.worldgen.witherweedDensity, WorldGenPVJPlant.NETHER, BiomeReference.getBiomes(BiomeReference.NETHER_BIOMES)));
		}
		else
			ProjectVibrantJourneys.logger.info("Nether plants disabled");
		
		if(PVJConfig.master.enableEndPlants)
		{
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.void_grass, PVJConfig.worldgen.voidGrassDensity, WorldGenPVJPlant.END, BiomeReference.getBiomes(BiomeReference.END_BIOMES)));
		}
		else
			ProjectVibrantJourneys.logger.info("End plants disabled");
		
		if(PVJConfig.master.enableStructures)
		{
			registerWorldGen(new WorldGenAbandonedFarm(PVJConfig.worldgen.abandonedFarmWeight, BiomeDictionary.getBiomes(Type.PLAINS).toArray(new Biome[0])));
			registerWorldGen(new WorldGenRuins(PVJConfig.worldgen.ruinsWeight, BiomeReference.getBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenRuins(PVJConfig.worldgen.ruinsWeight, BiomeReference.getBiomes(BiomeReference.BIRCH_TREES)));
		}
		else
			ProjectVibrantJourneys.logger.info("Structures disabled");
		
		if(Reference.isBOPLoaded)
			PVJWorldGenBOP.initWorldGenBOP();
		
		if(Reference.isTraverseLoaded)
			PVJWorldGenTraverse.initWorldGenBOP();
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		GameRegistry.registerWorldGenerator(worldgen, 0);
	}
	
	public static int[] getDimensionBlacklist()
	{
		if(!PVJConfig.worldgen.dimensionBlacklist.equals(""))
		{
			String[] temp = PVJConfig.worldgen.dimensionBlacklist.split(",");
			int[] ids = new int[temp.length];
			for(int i = 0; i < temp.length; i++)
			{
				String s = temp[i];
				try
				{
					int id = Integer.parseInt(s);
					ids[i] = id;
				}
				catch(NumberFormatException e)
				{
					ProjectVibrantJourneys.logger.error("Invalid id format in the dimension blacklist: " + s);
					ids[i] = 921; //just a random number to prevent crashes. i hope no one uses this id
				}
			}
			
			return ids;
		}
		
		return new int[0];
	}
}
