package com.projectvibrantjourneys.world.gen.biomes;

import javax.annotation.Nullable;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BiomeUtils {
	
	public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
		BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
		BiomeDefaultFeatures.addDefaultSprings(builder);
		BiomeDefaultFeatures.addSurfaceFreezing(builder);
	}
	
	public static Biome biome(Biome.Precipitation precipation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder mobSpawnSettings, BiomeGenerationSettings.Builder biomeGenSettings, @Nullable Music music) {
		return (new Biome.BiomeBuilder()).precipitation(precipation).biomeCategory(category).temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor)
						.fogColor(12638463).skyColor(calculateSkyColor(temperature))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build())
				.mobSpawnSettings(mobSpawnSettings.build()).generationSettings(biomeGenSettings.build()).build();
	}
	
	public static Biome biome(Biome.Precipitation precipation, Biome.BiomeCategory category, float temperature, float downfall, int waterColor, int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder mobSpawnSettings, BiomeGenerationSettings.Builder biomeGenSettings, @Nullable Music music) {
		return (new Biome.BiomeBuilder()).precipitation(precipation).biomeCategory(category).temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor)
						.fogColor(12638463).skyColor(calculateSkyColor(temperature))
						.grassColorOverride(grassColor).foliageColorOverride(foliageColor)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build())
				.mobSpawnSettings(mobSpawnSettings.build()).generationSettings(biomeGenSettings.build()).build();
	}
	
	public static void addTaigaSpawns(MobSpawnSettings.Builder builder) {
		builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
	}
	
	protected static int calculateSkyColor(float f) {
		float $$1 = f / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}
}
