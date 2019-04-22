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
		public int cobwebDensity = 30;
		
		public int riverGrassDensity = 70;
		
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
		
		public int fallenLeavesOakDensity = 50;
		public int fallenLeavesOakSparseDensity = 10;
		public int fallenLeavesBirchDensity = 35;
		public int fallenLeavesBirchSparseDensity = 10;
		public int fallenLeavesSpruceDensity = 60;
		public int fallenLeavesSpruceSparseDensity = 10;
		public int fallenLeavesJungleDensity = 60;
		public int fallenLeavesJungleSparseDensity = 20;
		public int fallenLeavesAcaciaDensity = 7;
		public int fallenLeavesDarkOakDensity = 50;
		public int fallenLeavesDarkOakSparseDensity = 15;
		public int fallenLeavesWillowDensity = 40;
		public int fallenLeavesMangroveDensity = 10;
		public int fallenLeavesRedwoodDensity = 90;
		public int fallenLeavesPalmDensity = 10;
		public int fallenLeavesDeadDensity = 15;
		public int fallenLeavesFirDensity = 60;
		public int fallenLeavesPineDensity = 25;
		public int fallenLeavesAspenDensity = 40;
		public int fallenLeavesRedMapleDensity = 30;
		public int fallenLeavesOrangeMapleDensity = 30;
		public int fallenLeavesBaobabDensity = 2;
		public int fallenLeavesCottonwoodDensity = 1;
		public int fallenLeavesJuniperDensity = 1;
		public int fallenLeavesWhiteCherryBlossomDensity = 30;
		public int fallenLeavesPinkCherryBlossomDensity = 30;
		public int fallenLeavesJacarandaDensity = 10;
		
		public int lilypadRiverDensity = 20;
		public int lilypadLakesDensity = 150;
		
		public int fallenTreeOakDensity = 50;
		public int fallenTreeOakSparseDensity = 5;
		public int fallenTreeBirchDensity = 50;
		public int fallenTreeBirchSparseDensity = 15;
		public int fallenTreeSpruceDensity = 50;
		public int fallenTreeSpruceSparseDensity = 20;
		public int fallenTreeJungleDensity = 20;
		public int fallenTreeAcaciaDensity = 5;
		public int fallenTreeWillowDensity = 50;
		public int fallenTreeMangroveDensity = 30;
		public int fallenTreePalmDensity = 20;
		public int fallenTreeRedwoodDensity = 80;
		public int fallenTreeFirDensity = 50;
		public int fallenTreePineDensity = 40;
		public int fallenTreeAspenDensity = 40;
		public int fallenTreeMapleDensity = 30;
		public int fallenTreeBaobabDensity = 1;
		public int fallenTreeCottonwoodDensity = 20;
		public int fallenTreeJuniperDensity = 1;
		public int fallenTreeCherryBlossomDensity = 30;
		public int fallenTreeJacarandaDensity = 20;
		
		public int mangroveRootDensity = 2;
		
		public int bushDensity = 3;
		
		public int stoneRocksDensity = 180;
		public int cobblestoneRocksDensity = 130;
		public int mossyCobblestoneRocksDensity = 40;
		public int andesiteRocksDensity = 60;
		public int graniteRocksDensity = 60;
		public int dioriteRocksDensity = 60;
		public int sandstoneRocksDensity = 70;
		public int redSandstoneRocksDensity = 70;
		
		public int stoneRocksCaveDensity = 150;
		public int cobblestoneRocksCaveDensity = 100;
		public int andesiteRocksCaveDensity = 60;
		public int graniteCaveDensity = 60;
		public int dioriteRocksCaveDensity = 60;
		
		public int oakTwigsDensity = 200;
		public int oakTwigsSparseDensity = 35;
		public int birchTwigsDensity = 200;
		public int birchTwigsSparseDensity = 35;
		public int spruceTwigsDensity = 170;
		public int spruceTwigsSparseDensity = 40;
		public int jungleTwigsDensity = 450;
		public int acaciaTwigsDensity = 25;
		public int darkOakTwigsDensity = 250;
		public int willowTwigsDensity = 250;
		public int mangroveTwigsDensity = 50;
		public int palmTwigsDensity = 15;
		public int redwoodTwigsDensity = 370;
		public int firTwigsDensity = 350;
		public int pineTwigsDensity = 50;
		public int aspenTwigsDensity = 160;
		public int redMapleTwigsDensity = 160;
		public int orangeMapleTwigsDensity = 160;
		public int baobabTwigsDensity = 4;
		public int cottonwoodTwigsDensity = 2;
		public int juniperTwigsDensity = 1;
		public int whiteCherryBlossomTwigsDensity = 40;
		public int pinkCherryBlossomTwigsDensity = 40;
		public int jacarandaTwigsDensity = 30;
		
		public int bonesDensity = 2;
		public int bonesDesertDensity = 10;
		public int bonesNetherDensity = 15;
		
		public int crackedSandDensity = 75;
		public int redCrackedSandDensity = 75;
		
		public int seashellsDensity = 70;
		public int pineconesDensity = 70;
		public int flowerPatchDensity = 2;
		
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
		public int bracketFungusDensity = 1000;
		public int beachGrassDensity = 5;
		public int seaOatsDensity = 5;
		public int flouroporeDensity = 200;
		public int bloodnettleDensity = 1;
		public int witherweedDensity = 1;
		public int glowcapDensity = 2;
		public int shortGrassDensity = 10;
		public int waxcapDensity = 1;
		public int deathcapDensity = 1;
		public int orangeMushroomDensity = 1;
		public int smallCactusDensity = 1;
		public int cattailDensity = 150;
		public int voidGrassDensity = 1;
		
		public int stalactiteDensity = 450;
		public int stalagmiteDensity = 450;
		public int icicleDensity = 450;
		
		public int boulderDensity = 5;
		
		public boolean modifyDungeons = true;
		public boolean enableFrozenCaves = true;
		public boolean enableSandstoneCaves = true;
		public boolean enableTerracottaCaves = true;
		public boolean enableOvergrownCaves = true;
		
		public int basaltDensity = 20;
		public int pillowBasaltDensity = 1;
		public int marbleDensity = 15;
		public int limestoneDensity = 20;
		public int siltstoneDensity = 20;
		public int gneissDensity = 20;
		
		public int mudDensity = 45;
		
		public boolean decreasePlainsPonds = true;
		public boolean decreaseDesertLakes = true;
		public boolean allowBeachVillages = true;
		
		public int abandonedFarmWeight = 5;
		public int ruinsWeight = 5;
		
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
		public int fireflySpawnWeight = 150;
		public int spiderSpawnWeight = 5;
		public int starfishWeight = 10;
		public int starfishBeachWeight = 25;
		public int clamWeight = 5;
		public int duckWeight = 7;
		
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
		
		@Config.Comment("For weaklings")
		public boolean replaceGoonSounds = false;
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
		public int fallenTreeEucalyptusDensity = 10;
		public int fallenTreeJacarandaDensity = 15;
		public int fallenTreeRedwoodDensity = 20;
		public int fallenTreeSacredOakDensity = 15;
		public int fallenTreeMahoganyDensity = 20;
		public int fallenTreePineDensity = 15;
		public int fallenTreeWillowDensity = 15;
		public int fallenTreeHellbarkDensity = 2;
		public int fallenTreeFirDensity = 25;
		public int fallenTreeUmbranDensity = 25;
		public int fallenTreeMagicDensity = 25;
		public int fallenTreePalmDensity = 15;
		public int fallenTreeMangroveDensity = 15;
		public int fallenTreeCherryDensity = 20;
		public int fallenTreeMapleDensity = 20;
		public int fallenTreeAutumnDensity = 20;
		public int fallenTreeDeadDensity = 10;
		
		public int fallenLeavesEbonyDensity = 25;
		public int fallenLeavesEucalyptusDensity = 50;
		public int fallenLeavesJacarandaDensity = 60;
		public int fallenLeavesRedwoodDensity = 70;
		public int fallenLeavesSacredOakDensity = 50;
		public int fallenLeavesBambooDensity = 700;
		public int fallenLeavesMahoganyDensity = 50;
		public int fallenLeavesPineDensity = 50;
		public int fallenLeavesWillowDensity = 70;
		public int fallenLeavesHellbarkDensity = 40;
		public int fallenLeavesFirDensity = 70;
		public int fallenLeavesUmbranDensity = 40;
		public int fallenLeavesFloweringOakDensity = 60;
		public int fallenLeavesYellowAutumnDensity = 70;
		public int fallenLeavesOrangeAutumnDensity = 70;
		public int fallenLeavesMagicDensity = 65;
		public int fallenLeavesPalmDensity = 35;
		public int fallenLeavesMangroveDensity = 60;
		public int fallenLeavesWhiteCherryDensity = 60;
		public int fallenLeavesPinkCherryDensity = 60;
		public int fallenLeavesMapleDensity = 65;
		
		public int twigsEbonyDensity = 50;
		public int twigsEucalyptusDensity = 120;
		public int twigsJacarandaDensity = 120;
		public int twigsRedwoodDensity = 350;
		public int twigsSacredOakDensity = 150;
		public int twigsMahoganyDensity = 150;
		public int twigsPineDensity = 70;
		public int twigsWillowDensity = 150;
		public int twigsHellbarkDensity = 40;
		public int twigsFirDensity = 160;
		public int twigsUmbranDensity = 160;
		public int twigsMagicDensity = 70;
		public int twigsPalmDensity = 70;
		public int twigsMangroveDensity = 120;
		public int twigsCherryDensity = 160;
		public int twigsAutumnDensity = 160;
		public int twigsMapleDensity = 160;
	}
	
	public static class TraverseSubCategory
	{
		public int fallenTreeAutumnDensity = 5;
		public int fallenTreeFirDensity = 15;
		
		public int fallenLeavesRedAutumnDensity = 15;
		public int fallenLeavesBrownAutumnDensity = 15;
		public int fallenLeavesYellowAutumnDensity = 15;
		public int fallenLeavesOrangeAutumnDensity = 15;
		public int fallenLeavesFirDensity = 30;
		
		public int twigsRedAutumnDensity = 50;
		public int twigsBrownAutumnDensity = 50;
		public int twigsYellowAutumnDensity = 50;
		public int twigsOrangeAutumnDensity = 50;
		public int twigsFirDensity = 170;
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
