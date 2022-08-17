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
			builder.pop();
			
			builder.push("Entity Options");
			enableJungleTropicalFish = builder.comment("Enable spawning of tropical fish in jungles").define("enableJungleTropicalFish", true);
			builder.pop();
		}
	}
}
