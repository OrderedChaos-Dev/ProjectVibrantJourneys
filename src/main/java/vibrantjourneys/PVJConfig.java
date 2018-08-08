package vibrantjourneys;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vibrantjourneys.util.Reference;

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
		public int fallenLeavesAcaciaDensity = 10;
		public int fallenLeavesDarkOakDensity = 50;
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
