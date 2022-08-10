package com.projectvibrantjourneys.world.gen.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class PineMeadowsBiome {
	
	public static Biome pineMeadows() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
		
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);

		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
	    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
	    
		biomeGenSettings.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUNFLOWER);
		biomeGenSettings.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_PLAINS);
		BiomeDefaultFeatures.addJungleGrass(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
	    BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);

		
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.plainsSpawns(mobSpawnSettings);

	    return BiomeUtils.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.PLAINS, 0.7F, 0.8F, 4159204, 329011, 0x59cf70, 0x69cf59, mobSpawnSettings, biomeGenSettings, null);
	}
}
