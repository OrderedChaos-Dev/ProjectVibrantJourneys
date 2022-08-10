package com.projectvibrantjourneys.world.gen.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DesertShrublandBiome {

	public static Biome desertShrubland() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
		
	    BiomeDefaultFeatures.addFossilDecoration(biomeGenSettings);
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);

		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
	    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenSettings);
	    
	    BiomeDefaultFeatures.addDesertVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenSettings);

		
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.desertSpawns(mobSpawnSettings);

	    return BiomeUtils.biome(Biome.Precipitation.NONE, Biome.BiomeCategory.DESERT, 2.0F, 0F, 4159204, 329011, mobSpawnSettings, biomeGenSettings, null);
	}
	
}
