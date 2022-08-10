package com.projectvibrantjourneys.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class PVJConfig {
	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final Data CONFIG_DATA = new Data(BUILDER);
	public static final ForgeConfigSpec CONFIG = BUILDER.build();
	
	public static class Data {
		
		public ForgeConfigSpec.BooleanValue enableRocks;
		public ForgeConfigSpec.BooleanValue enableTwigs;
		public ForgeConfigSpec.BooleanValue enableFallenLeaves;
		public ForgeConfigSpec.BooleanValue enableBones;
		public ForgeConfigSpec.BooleanValue enableCharredBones;
		public ForgeConfigSpec.BooleanValue enableIceChunks;
		public ForgeConfigSpec.BooleanValue enablePinecones;
		public ForgeConfigSpec.BooleanValue enableSeashells;
		
		public ForgeConfigSpec.BooleanValue enableSeaOats;
		public ForgeConfigSpec.BooleanValue enableCattails;
		public ForgeConfigSpec.BooleanValue enableBeachGrass;
		public ForgeConfigSpec.BooleanValue enableBarkMushrooms;
		public ForgeConfigSpec.BooleanValue enableGlowcap;
		public ForgeConfigSpec.BooleanValue enableCindercane;
		public ForgeConfigSpec.BooleanValue enableNetherNettles;
		public ForgeConfigSpec.BooleanValue enableShortGrass;
		public ForgeConfigSpec.BooleanValue enableNaturalCobwebs;
		public ForgeConfigSpec.BooleanValue enableSmallCacti;
		
		public ForgeConfigSpec.BooleanValue enableExtraLilypads;
		public ForgeConfigSpec.BooleanValue enableExtraSeagrass;
		public ForgeConfigSpec.BooleanValue enableExtraRiverGrass;
		
		public ForgeConfigSpec.BooleanValue enablePalmTrees;
		
		public ForgeConfigSpec.ConfigValue<Boolean> enableOvergrownSpires;
		public ForgeConfigSpec.ConfigValue<Boolean> enableVerdantSands;
		public ForgeConfigSpec.ConfigValue<Boolean> enableBorealForest;
		public ForgeConfigSpec.ConfigValue<Boolean> enableSnowyBorealForest;
		public ForgeConfigSpec.ConfigValue<Boolean> enablePineMeadows;
		public ForgeConfigSpec.ConfigValue<Boolean> enablePrairie;
		public ForgeConfigSpec.ConfigValue<Boolean> enableAutumnalConiferousForest;
		public ForgeConfigSpec.ConfigValue<Boolean> enableDesertShrubland;
		public ForgeConfigSpec.ConfigValue<Boolean> enableRedwoods;
		public ForgeConfigSpec.ConfigValue<Boolean> enableSnowyRedwoods;
		public ForgeConfigSpec.ConfigValue<Boolean> enableBaobabFields;
		public ForgeConfigSpec.ConfigValue<Boolean> enableCrystalLakes;
		public ForgeConfigSpec.ConfigValue<Boolean> enableBlossomingFields;
		public ForgeConfigSpec.ConfigValue<Boolean> enableAspenGrove;
		
		public ForgeConfigSpec.ConfigValue<Boolean> alpine_heights;
		public ForgeConfigSpec.ConfigValue<Boolean> boreal_plateau;
		public ForgeConfigSpec.ConfigValue<Boolean> willow_wetlands;
		public ForgeConfigSpec.ConfigValue<Boolean> mangrove_marsh;

		public ForgeConfigSpec.ConfigValue<Boolean> crimson_thicket;

		public ForgeConfigSpec.ConfigValue<Boolean> red_rock_valley;

		public ForgeConfigSpec.ConfigValue<Boolean> windswept_cliffs;
		
		public ForgeConfigSpec.BooleanValue enableJungleTropicalFish;
		
		public Data(ForgeConfigSpec.Builder builder) {
			builder.push("World Generation");
			enableRocks = builder.comment("Enable generation of rocks").define("enableRocks", true);
			enableTwigs = builder.comment("Enable generation of twigs").define("enableTwigs", true);
			enableFallenLeaves = builder.comment("Enable generation of fallen leaves").define("enableFallenLeaves", true);
			enableBones = builder.comment("Enable generation of bones").define("enableBones", true);
			enableCharredBones = builder.comment("Enable generation of charred bones").define("enableCharredBones", true);
			enableIceChunks = builder.comment("Enable generation of ice chunks").define("enableIceChunks", true);
			enablePinecones = builder.comment("Enable generation of pinecones").define("enablePinecones", true);
			enableSeashells = builder.comment("Enable generation of seashells").define("enableSeashells", true);
			
			enableSeaOats = builder.comment("Enable generation of sea oats").define("enableSeaOats", true);
			enableCattails = builder.comment("Enable generation of cattails").define("enableCattails", true);
			enableBeachGrass = builder.comment("Enable generation of beach grass").define("enableBeachGrass", true);
			enableBarkMushrooms = builder.comment("Enable generation of bark mushrooms").define("enableBarkMushrooms", true);
			enableGlowcap = builder.comment("Enable generation of glowcap").define("enableGlowcap", true);
			enableCindercane = builder.comment("Enable generation of cindercane").define("enableCindercane", true);
			enableNetherNettles = builder.comment("Enable generation of nether nettles").define("enableNetherNettles", true);
			enableShortGrass = builder.comment("Enable generation of short grass").define("enableShortGrass", true);
			enableNaturalCobwebs = builder.comment("Enable generation of natural cobwebs").define("enableNaturalCobwebs", true);
			enableSmallCacti = builder.comment("Enable generation of small cacti").define("enableSmallCacti", true);
			
			enableExtraLilypads = builder.comment("Enable generation of extra lilypads in lakes").define("enableExtraLilypads", true);
			enableExtraSeagrass = builder.comment("Enable generation of extra seagrass in lakes").define("enableExtraSeagrass", true);
			enableExtraRiverGrass = builder.comment("Enable generation of extra grass in rivers").define("enableExtraRiverGrass", true);
			
			enablePalmTrees = builder.comment("Enable Palm Trees on beaches").define("enablePalmTrees", true);
			builder.pop();
			builder.push("Biome Options");
			enableOvergrownSpires = builder.comment("Enable Overgrown Spires biome").define("enableOvergrownSpires", true);
			enableVerdantSands = builder.comment("Enable Verdant Sands biome").define("enableVerdantSands", true);
			enableBorealForest = builder.comment("Enable Boreal Forest biome").define("enableBorealForest", true);
			enableSnowyBorealForest = builder.comment("Enable Snowy Boreal Forest biome").define("enableSnowyBorealForest", true);
			enablePineMeadows = builder.comment("Enable Pine Meadows biome").define("enablePineMeadows", true);
			enablePrairie = builder.comment("Enable Prairie biome").define("enablePrairie", true);
			enableAutumnalConiferousForest = builder.comment("Enable Autumnal Coniferous Forest biome").define("enableAutumnalConiferousForest", true);
			enableDesertShrubland = builder.comment("Enable Desert Shrubland biome").define("enableDesertShrubland", true);
			enableRedwoods = builder.comment("Enable Redwoods biome").define("enableRedwoods", true);
			enableSnowyRedwoods = builder.comment("Enable Snowy Redwoods biome").define("enableSnowyRedwoods", true);
			enableBaobabFields = builder.comment("Enable Baobab Fields biome").define("enableBaobabFields", true);
			enableCrystalLakes = builder.comment("Enable Crystal Lakes biome").define("enableCrystalLakes", true);
			enableBlossomingFields = builder.comment("Enable Blossoming Fields biome").define("enableBlossomingFields", true);
			enableAspenGrove = builder.comment("Enable Aspen Grove biome").define("enableAspenGrove", true);
			builder.pop();
			
			builder.push("Entity Options");
			enableJungleTropicalFish = builder.comment("Enable spawning of tropical fish in jungles").define("enableJungleTropicalFish", true);
			builder.pop();
		}
	}
}
