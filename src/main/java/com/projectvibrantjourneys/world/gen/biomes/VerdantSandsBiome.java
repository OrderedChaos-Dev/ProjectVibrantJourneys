package com.projectvibrantjourneys.world.gen.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VerdantSandsBiome {

	public static Biome verdantSands() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder());
		
	    BiomeDefaultFeatures.addFossilDecoration(biomeGenSettings);
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);

		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
	    BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenSettings);
	    
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
		BiomeDefaultFeatures.addSparseJungleTrees(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaTrees(biomeGenSettings);
		BiomeDefaultFeatures.addWarmFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addJungleGrass(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
	    BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenSettings);

		BiomeDefaultFeatures.addDefaultSeagrass(biomeGenSettings);

		
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		BiomeDefaultFeatures.desertSpawns(mobSpawnSettings);
		mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));

	    return BiomeUtils.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.DESERT, 1.5F, 0.5F, 4159204, 329011, mobSpawnSettings, biomeGenSettings, null);
	}
}
