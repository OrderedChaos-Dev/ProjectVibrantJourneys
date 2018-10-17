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
		
		@Config.Name("Structures: Enable Fallen Trees")
		public boolean enableFallenTrees = true;
		
		@Config.Name("Biomes: Enable Biomes")
		public boolean enableBiomes = true;
		
		@Config.Name("Plants: Enable Overworld Plants")
		public boolean enableOverworldPlants = true;
		
		@Config.Name("Plants: Enable Nether Plants")
		public boolean enableNetherPlants = true;
		
		@Config.Name("Mobs: Enable Passive Mobs")
		public boolean enablePassiveMobs = true;
		
		@Config.Name("Mobs: Enable Neutral Mobs")
		public boolean enableNeutralMobs = true;
		
		@Config.Name("Mobs: Enable Aggressive Mobs")
		public boolean enableAggressiveMobs = true;
		
		@Config.Name("Building: Enable Mystical Grill")
		public boolean enableMysticalGrill = true;
		
		@Config.Name("Building: Enable Chimneys")
		public boolean enableChimneys = true;
		
		@Config.Name("Building: Enable Lighting Blocks")
		public boolean enableLighting = true;
		
		@Config.Name("Building: Enable Stone Blocks")
		public boolean enableStoneTypeBlocks = true;
		
		//@Config.Name("Ores: Enable Aquamarine")
		//public boolean enableAquamarine = true;
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
		public int baobabDensity = 4;
		public int cottonwoodDensity = 3;
		
		public int fallenLeavesOakDensity = 45;
		public int fallenLeavesOakSparseDensity = 10;
		public int fallenLeavesBirchDensity = 35;
		public int fallenLeavesBirchSparseDensity = 10;
		public int fallenLeavesSpruceDensity = 50;
		public int fallenLeavesSpruceSparseDensity = 10;
		public int fallenLeavesJungleDensity = 60;
		public int fallenLeavesJungleSparseDensity = 20;
		public int fallenLeavesAcaciaDensity = 10;
		public int fallenLeavesDarkOakDensity = 50;
		public int fallenLeavesDarkOakSparseDensity = 20;
		public int fallenLeavesWillowDensity = 40;
		public int fallenLeavesMangroveDensity = 10;
		public int fallenLeavesRedwoodDensity = 70;
		public int fallenLeavesPalmDensity = 15;
		public int fallenLeavesDeadDensity = 20;
		public int fallenLeavesFirDensity = 40;
		public int fallenLeavesPineDensity = 20;
		public int fallenLeavesAspenDensity = 40;
		public int fallenLeavesRedMapleDensity = 30;
		public int fallenLeavesOrangeMapleDensity = 30;
		public int fallenLeavesBaobabDensity = 5;
		public int fallenLeavesCottonwoodDensity = 2;
		public int fallenLeavesCrystalbarkDensity = 20;
		public int fallenLeavesBlueArcwoodDensity = 35;
		public int fallenLeavesPurpleArcwoodDensity = 35;
		
		public int lilypadRiverDensity = 20;
		public int lilypadLakesDensity = 150;
		
		public int fallenTreeOakDensity = 25;
		public int fallenTreeOakSparseDensity = 2;
		public int fallenTreeBirchDensity = 20;
		public int fallenTreeBirchSparseDensity = 2;
		public int fallenTreeSpruceDensity = 25;
		public int fallenTreeSpruceSparseDensity = 10;
		public int fallenTreeAcaciaDensity = 15;
		public int fallenTreeWillowDensity = 30;
		public int fallenTreeMangroveDensity = 5;
		public int fallenTreePalmDensity = 5;
		public int fallenTreeRedwoodDensity = 50;
		public int fallenTreeFirDensity = 25;
		public int fallenTreePineDensity = 10;
		public int fallenTreeAspenDensity = 25;
		public int fallenTreeMapleDensity = 10;
		public int fallenTreeBaobabDensity = 3;
		public int fallenTreeCottonwoodDensity = 1;
		public int fallenTreeCrystalbarkDensity = 15;
		public int fallenTreeArcwoodDensity = 15;
		
		public int mangroveRootDensity = 2;
		
		public int bushDensity = 3;
		
		public int stoneRocksDensity = 400;
		public int cobblestoneRocksDensity = 250;
		public int mossyCobblestoneRocksDensity = 90;
		public int andesiteRocksDensity = 150;
		public int graniteRocksDensity = 150;
		public int dioriteRocksDensity = 150;
		public int sandstoneRocksDensity = 200;
		public int redSandstoneRocksDensity = 200;
		
		public int stoneRocksCaveDensity = 400;
		public int cobblestoneRocksCaveDensity = 250;
		public int andesiteRocksCaveDensity = 150;
		public int graniteCaveDensity = 150;
		public int dioriteRocksCaveDensity = 150;
		
		public int oakTwigsDensity = 300;
		public int oakTwigsSparseDensity = 50;
		public int birchTwigsDensity = 300;
		public int birchTwigsSparseDensity = 50;
		public int spruceTwigsDensity = 300;
		public int spruceTwigsSparseDensity = 70;
		public int jungleTwigsDensity = 700;
		public int acaciaTwigsDensity = 50;
		public int darkOakTwigsDensity = 400;
		public int willowTwigsDensity = 400;
		public int mangroveTwigsDensity = 100;
		public int palmTwigsDensity = 30;
		public int redwoodTwigsDensity = 600;
		public int firTwigsDensity = 500;
		public int pineTwigsDensity = 100;
		public int aspenTwigsDensity = 300;
		public int redMapleTwigsDensity = 300;
		public int orangeMapleTwigsDensity = 300;
		public int baobabTwigsDensity = 20;
		public int cottonwoodTwigsDensity = 10;
		public int crystalbarkTwigsDensity = 20;
		public int blueArcwoodTwigsDensity = 30;
		public int purpleArcwoodTwigsDensity = 30;
		
		public int bonesDensity = 5;
		public int bonesDesertDensity = 15;
		public int bonesNetherDensity = 30;
		
		public int crackedSandDensity = 75;
		public int redCrackedSandDensity = 75;
		
		public int seashellsDensity = 120;
		
		public int pineconesDensity = 150;
		
		public int wildWheatDensity = 20;
		public int wildPotatoDensity = 2;
		public int wildCarrotDensity = 2;
		public int wildBeetrootDensity = 2;
		public int frostLotusDensity = 15;
		public int silverleafDensity = 30;
		public int chickweedDensity = 350;
		public int cloversDensity = 400;
		public int crabgrassDensity = 250;
		public int bracketFungusDensity = 2000;
		public int bloodnettleDensity = 10;
		public int glowcapDensity = 25;
		public int shortGrassDensity = 5;
		public int waxcapDensity = 3;
		public int deathcapDensity = 2;
		public int orangeMushroomDensity = 4;
		public int smallCactusDensity = 7;
		public int cattailDensity = 1000;
		
		public int stalactiteDensity = 450;
		public int stalagmiteDensity = 450;
		public int icicleDensity = 450;
		
		public boolean modifyDungeons = true;
		public boolean enableFrozenCaves = true;
		public boolean enableSandstoneCaves = true;
		public boolean enableOvergrownCaves = true;
		
		public int basaltDensity = 20;
		public int pillowBasaltDensity = 3;
		public int marbleDensity = 15;
		public int limestoneDensity = 20;
		public int siltstoneDensity = 20;
	}
	
	public static class BiomesSubCategory
	{
		public int prairieWeight = 7;
		public int redwoodsWeight = 10;
		public int redwoodPeaksWeight = 9;
		public int willowSwampWeight = 6;
		public int borealForestWeight = 10;
		public int snowyBorealForestWeight = 10;
		public int aspenGroveWeight = 9;
		public int mudlandsWeight = 8;
		public int baobabFieldsWeight = 6;
		public int paleForestWeight = 7;
		public int overgrownSpiresWeight = 8;
	}
	
	public static class EntitiesSubCategory
	{
		public int snailSpawnWeight = 40;
		public int flySpawnWeight = 95;
		public int flySwampSpawnWeight = 160;
		public int fireflySpawnWeight = 350;
		public int spiderSpawnWeight = 35;
		
		public int grizzlyBearSpawnWeight = 5;
		
		public int ghostSpawnWeight = 65;
		
		public int shadeSpawnWeight = 55;
		public int icecubeSpawnWeight = 35;
		public int skeletalKnightWeight = 45;
		public int goonSpawnWeight = 20;
	}
	
	public static class MiscCategory
	{
		public boolean doGrassDropSeeds = false;
		
		public boolean restrictSquidsToOceans = true;
		
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
