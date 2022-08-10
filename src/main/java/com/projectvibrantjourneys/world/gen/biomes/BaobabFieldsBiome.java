package com.projectvibrantjourneys.world.gen.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BaobabFieldsBiome {

	public static Biome baobabFields() {
		BiomeGenerationSettings.Builder biomeGenSettings = new BiomeGenerationSettings.Builder();
		BiomeUtils.globalOverworldGeneration(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaGrass(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaTrees(biomeGenSettings);
		BiomeDefaultFeatures.addWarmFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaExtraGrass(biomeGenSettings);

		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
		mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
				.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
		BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

		return BiomeUtils.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.SAVANNA, 1.2F, 0.0F, 4159204, 329011,
				0x8aab32, 0xa6c918, mobSpawnSettings, biomeGenSettings, null);
	}
}
