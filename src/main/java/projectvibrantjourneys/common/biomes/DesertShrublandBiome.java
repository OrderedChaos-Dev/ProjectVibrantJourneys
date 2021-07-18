package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class DesertShrublandBiome {
	
	public static Biome makeDesertShrublandBiome(float height) {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		
		DefaultBiomeFeatures.desertSpawns(mobSpawnInfo);
		mobSpawnInfo.setPlayerCanSpawn();
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.DESERT);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_DESERT);
		biomeGenBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		biomeGenBuilder.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);
		DefaultBiomeFeatures.addFossilDecoration(biomeGenBuilder);
		
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addDesertVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDesertExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDesertExtraDecoration(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
	      
		return (new Biome.Builder()).precipitation(RainType.NONE)
				.biomeCategory(Biome.Category.DESERT)
				.depth(height)
				.scale(0.01F)
				.temperature(1.9F)
				.downfall(0F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(1.9F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
