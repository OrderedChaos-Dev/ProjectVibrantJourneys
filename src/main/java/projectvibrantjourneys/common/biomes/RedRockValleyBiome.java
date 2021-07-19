package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class RedRockValleyBiome {
	
	public static Biome makeRedRockValleyBiome() {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		
		DefaultBiomeFeatures.desertSpawns(mobSpawnInfo);
		mobSpawnInfo.setPlayerCanSpawn();
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.RED_ROCK_VALLEY);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addFossilDecoration(biomeGenBuilder);
		
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addExtraGold(biomeGenBuilder);
		DefaultBiomeFeatures.addBadlandGrass(biomeGenBuilder);
		DefaultBiomeFeatures.addJungleEdgeTrees(biomeGenBuilder);
		DefaultBiomeFeatures.addJungleGrass(biomeGenBuilder);
		DefaultBiomeFeatures.addBadlandExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
	      
		return (new Biome.Builder()).precipitation(RainType.RAIN)
				.biomeCategory(Biome.Category.DESERT)
				.depth(0.1F)
				.scale(0.1F)
				.temperature(1.7F)
				.downfall(0.55F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(1.9F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
