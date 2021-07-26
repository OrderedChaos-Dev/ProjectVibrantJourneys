package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class DesertShrublandBiome {
	
	public static Biome makeDesertShrublandBiome(float height) {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		
		BiomeDefaultFeatures.desertSpawns(MobSpawnSettings);
		MobSpawnSettings.setPlayerCanSpawn();
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.DESERT);
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_DESERT);
		biomeGenBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		biomeGenBuilder.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);
		BiomeDefaultFeatures.addFossilDecoration(biomeGenBuilder);
		
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addDesertVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
	      
		return (new Biome.BiomeBuilder()).precipitation(Precipitation.NONE)
				.biomeCategory(Biome.BiomeCategory.DESERT)
				.depth(height)
				.scale(0.01F)
				.temperature(1.9F)
				.downfall(0F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(1.9F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
