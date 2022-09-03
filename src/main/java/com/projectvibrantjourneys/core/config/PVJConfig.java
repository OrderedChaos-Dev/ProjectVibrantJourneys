package com.projectvibrantjourneys.core.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class PVJConfig {
	
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final Data CONFIG_DATA = new Data(BUILDER);
	public static final ForgeConfigSpec CONFIG = BUILDER.build();
	
	public static class Data {
		
		public HashMap<String, ForgeConfigSpec.BooleanValue> configOptions = new HashMap<>();
		
		public ForgeConfigSpec.BooleanValue enableRocks;
		public ForgeConfigSpec.BooleanValue enableTwigs;
		public ForgeConfigSpec.BooleanValue enableFallenLeaves;
		public ForgeConfigSpec.BooleanValue enableBones;
		public ForgeConfigSpec.BooleanValue enableCharredBones;
		public ForgeConfigSpec.BooleanValue enableIceChunks;
		public ForgeConfigSpec.BooleanValue enablePinecones;
		public ForgeConfigSpec.BooleanValue enableSeashells;
		
		public ForgeConfigSpec.BooleanValue enableFallenTrees;
		
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
		public ForgeConfigSpec.BooleanValue enableMossCarpets;
		public ForgeConfigSpec.BooleanValue enableTidePools;
		
		public ForgeConfigSpec.BooleanValue enableJungleTropicalFish;
		
		public Data(ForgeConfigSpec.Builder builder) {
			builder.push("World Generation");
			config("enableRocks", enableRocks, builder.comment("Enable generation of rocks").define("enableRocks", true));
			config("enableTwigs", enableTwigs, builder.comment("Enable generation of twigs").define("enableTwigs", true));
			config("enableFallenLeaves", enableFallenLeaves, builder.comment("Enable generation of fallen leaves").define("enableFallenLeaves", true));
			config("enableBones", enableBones, builder.comment("Enable generation of bones").define("enableBones", true));
			config("enableCharredBones", enableCharredBones, builder.comment("Enable generation of charred bones").define("enableCharredBones", true));
			config("enableIceChunks", enableIceChunks, builder.comment("Enable generation of ice chunks").define("enableIceChunks", true));
			config("enablePinecones", enablePinecones, builder.comment("Enable generation of pinecones").define("enablePinecones", true));
			config("enableSeashells", enableSeashells, builder.comment("Enable generation of seashells").define("enableSeashells", true));
			
			config("enableFallenTrees", enableFallenTrees, builder.comment("Enable generation of fallen trees").define("enableFallenTrees", true));
			
			config("enableSeaOats", enableSeaOats, builder.comment("Enable generation of sea oats").define("enableSeaOats", true));
			config("enableCattails", enableCattails, builder.comment("Enable generation of cattails").define("enableCattails", true));
			config("enableBeachGrass", enableBeachGrass, builder.comment("Enable generation of beach grass").define("enableBeachGrass", true));
			config("enableBarkMushrooms", enableBarkMushrooms, builder.comment("Enable generation of bark mushrooms").define("enableBarkMushrooms", true));
			config("enableGlowcap", enableGlowcap, builder.comment("Enable generation of glowcap").define("enableGlowcap", true));
			config("enableCindercane", enableCindercane, builder.comment("Enable generation of cindercane").define("enableCindercane", true));
			config("enableNetherNettles", enableNetherNettles, builder.comment("Enable generation of nether nettles").define("enableNetherNettles", true));
			config("enableShortGrass", enableShortGrass, builder.comment("Enable generation of short grass").define("enableShortGrass", true));
			config("enableNaturalCobwebs", enableNaturalCobwebs, builder.comment("Enable generation of natural cobwebs").define("enableNaturalCobwebs", true));
			config("enableSmallCacti", enableSmallCacti, builder.comment("Enable generation of small cacti").define("enableSmallCacti", true));
			
			config("enableExtraLilypads", enableExtraLilypads, builder.comment("Enable generation of extra lilypads in lakes").define("enableExtraLilypads", true));
			config("enableExtraSeagrass", enableExtraSeagrass, builder.comment("Enable generation of extra seagrass in lakes").define("enableExtraSeagrass", true));
			config("enableExtraRiverGrass", enableExtraRiverGrass, builder.comment("Enable generation of extra grass in rivers").define("enableExtraRiverGrass", true));
			config("enableMossCarpets", enableMossCarpets, builder.comment("Enable moss carpets in old growth taiga biomes").define("enableMossCarpets", true));
			config("enableTidePools", enableTidePools, builder.comment("Enable of tide pools in stony shores").define("enableTidePools", true));
			builder.pop();
			
			builder.push("Entity Options");
			config("enableJungleTropicalFish", enableJungleTropicalFish, builder.comment("Enable spawning of tropical fish in jungles").define("enableJungleTropicalFish", true));
			builder.pop();

		}
		
		private void config(String name, ForgeConfigSpec.BooleanValue spec, BooleanValue value) {
			spec = value;
			configOptions.put(name, spec);
		}
	}
}
