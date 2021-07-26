package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class RedRockValleyBiome {
	
	public static Biome makeRedRockValleyBiome() {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		
		BiomeDefaultFeatures.desertSpawns(MobSpawnSettings);
		MobSpawnSettings.setPlayerCanSpawn();
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.RED_ROCK_VALLEY);
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addFossilDecoration(biomeGenBuilder);
		
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addExtraGold(biomeGenBuilder);
		BiomeDefaultFeatures.addBadlandGrass(biomeGenBuilder);
		BiomeDefaultFeatures.addJungleEdgeTrees(biomeGenBuilder);
		BiomeDefaultFeatures.addJungleGrass(biomeGenBuilder);
		BiomeDefaultFeatures.addBadlandExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
	      
		return (new Biome.BiomeBuilder()).precipitation(Precipitation.RAIN)
				.biomeCategory(Biome.BiomeCategory.DESERT)
				.depth(0.1F)
				.scale(0.1F)
				.temperature(1.7F)
				.downfall(0.55F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.grassColorOverride(0x8aab32)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(1.9F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
