package vibrantjourneys.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID, name="PVJ_Configuration", type=Type.INSTANCE)
public class PVJConfig
{
	@Comment({
		"All changes require a restart! Set to 0 to disable from generation",
		"\"Sparse\" means biomes in which tree types rarely generate.",
		"e.g. birch trees rarely generate in forests and roofed forests.",
	})
	public static WorldGenSubCategory worldgen = new WorldGenSubCategory();
	
	@Comment({
		"All changes require a restart! Set to 0 to disable from generation.",
		"Biome weight is how much chance a biome has to generate."
	})
	public static BiomesSubCategory biomes = new BiomesSubCategory();
	
	@Comment({
		"All changes require a restart! Spawn weight is how much often an entity spawns.",
		"Set to 0 to disable spawning."
	})
	public static EntitiesSubCategory entities = new EntitiesSubCategory();
	
	@Comment({
		"All changes require a restart! Spawn weight is how much often an entity spawns.",
		"Set to 0 to disable spawning."
	})
	public static BOPSubCategory bopworldgen = new BOPSubCategory();
	
	@Comment({
		"All changes require a restart! Set this to true to allow tall grass to",
		"drop wheat seeds."
	})
	public static boolean doGrassDropSeeds = false;
	
	public static class WorldGenSubCategory
	{
		public int cobwebDensity = 100;
		public int palmDensity = 5;
		public int willowDensity = 25;
		public int mangroveDensity = 5;
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
		public int fallenTreeRedwoodDensity = 50;
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
		public int bonesDensity = 5;
		public int bonesDesertDensity = 15;
		public int bonesNetherDensity = 15;
		public int crackedSandDensity = 75;
		public int redCrackedSandDensity = 75;
		public int wildWheatDensity = 20;
	}
	
	public static class BiomesSubCategory
	{
		public int prarieWeight = 10;
		public int redwoodsWeight = 10;
		public int willowSwampWeight = 6;
	}
	
	public static class EntitiesSubCategory
	{
		public int snailSpawnWeight = 50;
		public int flySpawnWeight = 30;
		public int fireflySpawnWeight = 350;
		
		public int ghostSpawnWeight = 75;
		public int shadeSpawnWeight = 85;
		public int icecubeSpawnWeight = 35;
		public int skeletalKnightWeight = 85;
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
