package vibrantjourneys.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID, name="projectvibrantjourneys", type=Type.INSTANCE)
public class PVJConfig
{
	@Comment({
		"This is where you can enable/disable entire parts of the mod.",
	})
	@Config.LangKey("config.pvj.master")
	@Config.RequiresMcRestart
	public static MasterCategory master = new MasterCategory();
	
	@Comment({
		"Set global modifiers that affect entire parts of the mod.",
		"Everything is based around a value of 100",
		"e.g. setting twigs to 150 increases twigs spawn rate by 50%"
	})
	@Config.LangKey("config.pvj.global")
	@Config.RequiresMcRestart
	public static GlobalModifiersCategory global = new GlobalModifiersCategory();
	
	@Comment({
		"Set to 0 to disable from generation",
		"\"Sparse\" means biomes in which tree types rarely generate.",
		"e.g. birch trees rarely generate in forests and roofed forests.",
	})
	@Config.LangKey("config.pvj.worldgen")
	@Config.RequiresMcRestart
	public static WorldGenSubCategory worldgen = new WorldGenSubCategory();
	
	@Comment({
		"Set to 0 to disable from generation.",
		"Biome weight is how much chance a biome has to generate."
	})
	@Config.LangKey("config.pvj.biomes")
	@Config.RequiresMcRestart
	public static BiomesSubCategory biomes = new BiomesSubCategory();
	
	@Comment({
		"Spawn weight is how much often an entity spawns.",
		"Set to 0 to disable spawning."
	})
	@Config.LangKey("config.pvj.mobs")
	@Config.RequiresMcRestart
	public static EntitiesSubCategory entities = new EntitiesSubCategory();
	
	@Config.LangKey("config.pvj.misc")
	@Config.RequiresMcRestart
	public static MiscCategory misc = new MiscCategory();
	
	@Config.LangKey("config.pvj.integration")
	@Config.RequiresMcRestart
	public static IntegrationCategory integration = new IntegrationCategory();
	
	public static class MasterCategory
	{
		@Config.Name("Caves: Enable Caves")
		public boolean enableCaves = true;
		
		@Config.Name("Groundcover: Enable Groundcover")
		public boolean enableGroundcover = true;
		
		@Config.Name("Groundcover: Enable Twigs")
		public boolean enableTwigs = true;
		
		@Config.Name("Groundcover: Enable Rocks")
		public boolean enableRocks = true;
		
		@Config.Name("Groundcover: Enable Fallen Leaves")
		public boolean enableFallenLeaves = true;
		
		@Config.Name("Groundcover: Enable Bones")
		public boolean enableBones = true;
		
		@Config.Name("Groundcover: Enable Seashells")
		public boolean enableSeashells = true;
		
		@Config.Name("Groundcover: Enable Pinecones")
		public boolean enablePinecones = true;
		
		@Config.Name("Groundcover: Enable Flower Patch")
		public boolean enableFlowerPatches = true;
		
		@Config.Name("Environment: Enable Fallen Trees")
		public boolean enableFallenTrees = true;
		
		@Config.Name("Structures: Enable Structures")
		public boolean enableStructures = true;
		
		@Config.Name("Biomes: Enable Biomes")
		public boolean enableBiomes = true;
		
		@Config.Name("Plants: Enable Overworld Plants")
		public boolean enableOverworldPlants = true;
		
		@Config.Name("Plants: Enable Nether Plants")
		public boolean enableNetherPlants = true;
		
		@Config.Name("Plants: Enable End Plants")
		public boolean enableEndPlants = true;
		
		@Config.Name("Ore: Enable Aquamarine")
		public boolean enableAquamarine = true;
		
		@Config.Name("Mobs: Enable Passive Mobs")
		public boolean enablePassiveMobs = true;
		
		@Config.Name("Mobs: Enable Neutral Mobs")
		public boolean enableNeutralMobs = true;
		
		@Config.Name("Mobs: Enable Aggressive Mobs")
		public boolean enableAggressiveMobs = true;
		
		@Config.Name("Building: Enable Mystical Grill")
		public boolean enableMysticalGrill = true;
		
		@Config.Name("Building: Enable Stone Blocks")
		public boolean enableStoneTypeBlocks = true;
		
		@Config.Name("Misc: Enable Puddles")
		public boolean enablePuddles = true;
		
		//@Config.Name("Ores: Enable Aquamarine")
		//public boolean enableAquamarine = true;
	}
	
	public static class GlobalModifiersCategory
	{
		@Config.Name("Groundcover Density")
		public int groundcoverDensity = 100;
		
		@Config.Name("Fallen Leaves Density")
		public int fallenLeavesDensity = 100;
		
		@Config.Name("Fallen Tree Density")
		public int fallenTreeDensity = 100;
		
		@Config.Name("Twigs Density")
		public int twigsDensity = 100;
		
		@Config.Name("Rocks Density")
		public int rocksDensity = 100;
		
		@Config.Name("Overworld Plants Density")
		public int overworldPlantsDensity = 100;
		
		@Config.Name("Nether Plants Density")
		public int netherPlantsDensity = 100;
		
		@Config.Name("End Plants Density")
		public int endPlantsDensity = 100;
		
		@Config.Name("Animals Density")
		public int animalsDensity = 100;
		
		@Config.Name("Mobs Density")
		public int mobsDensity = 100;
		
		@Config.Name("Stone Deposits Density")
		public int stoneDepositsDensity = 100;
		
	}
	
	public static class WorldGenSubCategory
	{
		public int cobwebDensity = 100;
		
		public int riverGrassDensity = 95;
		
		public int palmDensity = 5;
		public int willowDensity = 2;
		public int mangroveDensity = 5;
		public int redwoodDensity = 4;
		public int firDensity = 15;
		public int pineDensity = 15;
		public int aspenDensity = 20;
		public int redMapleDensity = 15;
		public int orangeMapleDensity = 15;
		public int baobabDensity = 2;
		public int cottonwoodDensity = 1;
		public int juniperDensity = 1;
		public int whiteCherryBlossomDensity = 5;
		public int pinkCherryBlossomDensity = 5;
		public int jacarandaDensity = 3;
		
		public int fallenLeavesOakDensity = 40;
		public int fallenLeavesOakSparseDensity = 8;
		public int fallenLeavesBirchDensity = 30;
		public int fallenLeavesBirchSparseDensity = 8;
		public int fallenLeavesSpruceDensity = 45;
		public int fallenLeavesSpruceSparseDensity = 8;
		public int fallenLeavesJungleDensity = 50;
		public int fallenLeavesJungleSparseDensity = 15;
		public int fallenLeavesAcaciaDensity = 7;
		public int fallenLeavesDarkOakDensity = 35;
		public int fallenLeavesDarkOakSparseDensity = 15;
		public int fallenLeavesWillowDensity = 35;
		public int fallenLeavesMangroveDensity = 7;
		public int fallenLeavesRedwoodDensity = 70;
		public int fallenLeavesPalmDensity = 7;
		public int fallenLeavesDeadDensity = 15;
		public int fallenLeavesFirDensity = 40;
		public int fallenLeavesPineDensity = 15;
		public int fallenLeavesAspenDensity = 30;
		public int fallenLeavesRedMapleDensity = 25;
		public int fallenLeavesOrangeMapleDensity = 25;
		public int fallenLeavesBaobabDensity = 3;
		public int fallenLeavesCottonwoodDensity = 1;
		public int fallenLeavesJuniperDensity = 1;
		public int fallenLeavesWhiteCherryBlossomDensity = 25;
		public int fallenLeavesPinkCherryBlossomDensity = 25;
		public int fallenLeavesJacarandaDensity = 7;
		
		public int lilypadRiverDensity = 20;
		public int lilypadLakesDensity = 150;
		
		public int fallenTreeOakDensity = 20;
		public int fallenTreeOakSparseDensity = 2;
		public int fallenTreeBirchDensity = 17;
		public int fallenTreeBirchSparseDensity = 2;
		public int fallenTreeSpruceDensity = 20;
		public int fallenTreeSpruceSparseDensity = 10;
		public int fallenTreeJungleDensity = 5;
		public int fallenTreeAcaciaDensity = 15;
		public int fallenTreeWillowDensity = 25;
		public int fallenTreeMangroveDensity = 5;
		public int fallenTreePalmDensity = 5;
		public int fallenTreeRedwoodDensity = 45;
		public int fallenTreeFirDensity = 20;
		public int fallenTreePineDensity = 10;
		public int fallenTreeAspenDensity = 25;
		public int fallenTreeMapleDensity = 10;
		public int fallenTreeBaobabDensity = 3;
		public int fallenTreeCottonwoodDensity = 2;
		public int fallenTreeJuniperDensity = 1;
		public int fallenTreeCherryBlossomDensity = 10;
		public int fallenTreeJacarandaDensity = 3;
		
		public int mangroveRootDensity = 2;
		
		public int bushDensity = 3;
		public int bushDensityCanyon = 1;
		
		public int stoneRocksDensity = 300;
		public int cobblestoneRocksDensity = 200;
		public int mossyCobblestoneRocksDensity = 50;
		public int andesiteRocksDensity = 100;
		public int graniteRocksDensity = 100;
		public int dioriteRocksDensity = 100;
		public int sandstoneRocksDensity = 120;
		public int redSandstoneRocksDensity = 120;
		
		public int stoneRocksCaveDensity = 200;
		public int cobblestoneRocksCaveDensity = 150;
		public int andesiteRocksCaveDensity = 100;
		public int graniteCaveDensity = 100;
		public int dioriteRocksCaveDensity = 100;
		
		public int oakTwigsDensity = 230;
		public int oakTwigsSparseDensity = 40;
		public int birchTwigsDensity = 230;
		public int birchTwigsSparseDensity = 40;
		public int spruceTwigsDensity = 200;
		public int spruceTwigsSparseDensity = 50;
		public int jungleTwigsDensity = 500;
		public int acaciaTwigsDensity = 30;
		public int darkOakTwigsDensity = 300;
		public int willowTwigsDensity = 300;
		public int mangroveTwigsDensity = 60;
		public int palmTwigsDensity = 20;
		public int redwoodTwigsDensity = 430;
		public int firTwigsDensity = 400;
		public int pineTwigsDensity = 70;
		public int aspenTwigsDensity = 200;
		public int redMapleTwigsDensity = 200;
		public int orangeMapleTwigsDensity = 200;
		public int baobabTwigsDensity = 10;
		public int cottonwoodTwigsDensity = 5;
		public int juniperTwigsDensity = 4;
		public int whiteCherryBlossomTwigsDensity = 70;
		public int pinkCherryBlossomTwigsDensity = 70;
		public int jacarandaTwigsDensity = 60;
		
		public int bonesDensity = 4;
		public int bonesDesertDensity = 13;
		public int bonesNetherDensity = 25;
		
		public int crackedSandDensity = 75;
		public int redCrackedSandDensity = 75;
		
		public int seashellsDensity = 90;
		public int pineconesDensity = 90;
		public int flowerPatchDensity = 5;
		
		public int wildWheatDensity = 1;
		public int wildPotatoDensity = 1;
		public int wildCarrotDensity = 1;
		public int wildBeetrootDensity = 1;
		public int frostLotusDensity = 4;
		public int sundewDensity = 5;
		public int silverleafDensity = 2;
		public int chickweedDensity = 5;
		public int cloversDensity = 5;
		public int crabgrassDensity = 5;
		public int bracketFungusDensity = 2000;
		public int beachGrassDensity = 30;
		public int seaOatsDensity = 20;
		public int flouroporeDensity = 200;
		public int bloodnettleDensity = 1;
		public int witherweedDensity = 1;
		public int glowcapDensity = 2;
		public int shortGrassDensity = 6;
		public int waxcapDensity = 1;
		public int deathcapDensity = 1;
		public int orangeMushroomDensity = 1;
		public int smallCactusDensity = 1;
		public int cattailDensity = 1000;
		public int voidGrassDensity = 1;
		
		public int stalactiteDensity = 450;
		public int stalagmiteDensity = 450;
		public int icicleDensity = 450;
		
		public int boulderDensity = 40;
		
		public boolean modifyDungeons = true;
		public boolean enableFrozenCaves = true;
		public boolean enableSandstoneCaves = true;
		public boolean enableTerracottaCaves = true;
		public boolean enableOvergrownCaves = true;
		
		public int basaltDensity = 20;
		public int pillowBasaltDensity = 3;
		public int marbleDensity = 15;
		public int limestoneDensity = 20;
		public int siltstoneDensity = 20;
		public int gneissDensity = 20;
		
		public int mudDensity = 45;
		
		public boolean decreasePlainsPonds = true;
		public boolean decreaseDesertLakes = true;
		public boolean allowBeachVillages = true;
		
		public int abandonedFarmWeight = 15;
		public int ruinsWeight = 15;
		
		@Config.Comment({
			"Use dimension ids, separate by commas. Do not use spaces"
		})
		public String dimensionBlacklist = "";
		
		public boolean enableBaobabFields = false;
	}
	
	public static class BiomesSubCategory
	{
		public int prairieWeight = 6;
		public int redwoodsWeight = 8;
		public int redwoodPeaksWeight = 8;
		public int willowSwampWeight = 6;
		public int borealForestWeight = 8;
		public int snowyBorealForestWeight = 8;
		public int aspenGroveWeight = 7;
		public int overgrownSpiresWeight = 5;
		public int blossomingfields = 5;
		public int baobabFieldsWeight = 5;
	}
	
	public static class EntitiesSubCategory
	{
		public int snailSpawnWeight = 8;
		public int flySpawnWeight = 10;
		public int flySwampSpawnWeight = 20;
		public int fireflySpawnWeight = 100;
		public int spiderSpawnWeight = 5;
		public int starfishWeight = 10;
		public int starfishBeachWeight = 25;
		public int clamWeight = 5;
		public int duckWeight = 10;
		
		public int grizzlyBearSpawnWeight = 5;
		public int coyoteSpawnWeight = 2;
		
		public int ghostSpawnWeight = 65;
		public int watcherSpawnWeight = 5;
		
		public int shadeSpawnWeight = 55;
		public int shadeRoofedForestSpawnWeight = 100;
		public int bansheeSpawnWeight = 55;
		public int icecubeSpawnWeight = 35;
		public int skeletalKnightWeight = 45;
		public int goonSpawnWeight = 20;
		
		public boolean firefliesSpawnInSnowBiomes = false;
		public boolean junglesSpawnCaveSpiders = true;
		public boolean squidsDropFood = true;
	}
	
	public static class MiscCategory
	{
		public boolean doGrassDropSeeds = false;
		
		public boolean restrictSquidsToOceans = true;
		
		@Comment({
			"If true, you can shift right click on groundcover to drop their item"
		})
		public boolean shiftRightClickGroundCover = true;
		
		@Comment({
			"This is measured in ticks. 20 ticks = 1 second",
			"6000 ticks = 5 minutes"
		})
		public int mysticalGrillCookTime = 6000;
	}
	
	public static class IntegrationCategory
	{
		@Config.Name("Biomes O' Plenty")
		public BOPSubCategory bopworldgen = new BOPSubCategory();
		
		@Config.Name("Traverse")
		public TraverseSubCategory traverseworldgen = new TraverseSubCategory();
	}
	
	public static class BOPSubCategory
	{
		public int fallenTreeEbonyDensity = 5;
		public int fallenTreeEucalyptusDensity = 15;
		public int fallenTreeJacarandaDensity = 20;
		public int fallenTreeRedwoodDensity = 35;
		public int fallenTreeSacredOakDensity = 25;
		public int fallenTreeMahoganyDensity = 30;
		public int fallenTreePineDensity = 30;
		public int fallenTreeWillowDensity = 25;
		public int fallenTreeHellbarkDensity = 5;
		public int fallenTreeFirDensity = 35;
		public int fallenTreeUmbranDensity = 35;
		public int fallenTreeMagicDensity = 35;
		public int fallenTreePalmDensity = 25;
		public int fallenTreeMangroveDensity = 25;
		public int fallenTreeCherryDensity = 35;
		public int fallenTreeMapleDensity = 35;
		public int fallenTreeAutumnDensity = 35;
		public int fallenTreeDeadDensity = 20;
		
		public int fallenLeavesEbonyDensity = 45;
		public int fallenLeavesEucalyptusDensity = 60;
		public int fallenLeavesJacarandaDensity = 85;
		public int fallenLeavesRedwoodDensity = 95;
		public int fallenLeavesSacredOakDensity = 60;
		public int fallenLeavesBambooDensity = 100;
		public int fallenLeavesMahoganyDensity = 60;
		public int fallenLeavesPineDensity = 60;
		public int fallenLeavesWillowDensity = 90;
		public int fallenLeavesHellbarkDensity = 50;
		public int fallenLeavesFirDensity = 95;
		public int fallenLeavesUmbranDensity = 55;
		public int fallenLeavesFloweringOakDensity = 85;
		public int fallenLeavesYellowAutumnDensity = 80;
		public int fallenLeavesOrangeAutumnDensity = 80;
		public int fallenLeavesMagicDensity = 75;
		public int fallenLeavesPalmDensity = 45;
		public int fallenLeavesMangroveDensity = 75;
		public int fallenLeavesWhiteCherryDensity = 75;
		public int fallenLeavesPinkCherryDensity = 75;
		public int fallenLeavesMapleDensity = 80;
		
		public int twigsEbonyDensity = 70;
		public int twigsEucalyptusDensity = 150;
		public int twigsJacarandaDensity = 150;
		public int twigsRedwoodDensity = 400;
		public int twigsSacredOakDensity = 200;
		public int twigsMahoganyDensity = 200;
		public int twigsPineDensity = 100;
		public int twigsWillowDensity = 200;
		public int twigsHellbarkDensity = 50;
		public int twigsFirDensity = 200;
		public int twigsUmbranDensity = 200;
		public int twigsMagicDensity = 100;
		public int twigsPalmDensity = 100;
		public int twigsMangroveDensity = 150;
		public int twigsCherryDensity = 200;
		public int twigsAutumnDensity = 200;
		public int twigsMapleDensity = 200;
	}
	
	public static class TraverseSubCategory
	{
		public int fallenTreeAutumnDensity = 5;
		public int fallenTreeFirDensity = 20;
		
		public int fallenLeavesRedAutumnDensity = 15;
		public int fallenLeavesBrownAutumnDensity = 15;
		public int fallenLeavesYellowAutumnDensity = 15;
		public int fallenLeavesOrangeAutumnDensity = 15;
		public int fallenLeavesFirDensity = 30;
		
		public int twigsRedAutumnDensity = 60;
		public int twigsBrownAutumnDensity = 60;
		public int twigsYellowAutumnDensity = 60;
		public int twigsOrangeAutumnDensity = 60;
		public int twigsFirDensity = 200;
	}
	
	@Mod.EventBusSubscriber
	public static class ConfigEventHandler
	{
		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
		{
			if(event.getModID().equals(Reference.MOD_ID))
			{
				ConfigManager.sync(Reference.MOD_ID, Type.INSTANCE);
			}
		}
	}
}
