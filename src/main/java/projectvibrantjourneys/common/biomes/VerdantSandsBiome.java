package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class VerdantSandsBiome {

	public static Biome makeVerdantSandsBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(PVJConfiguredSurfaceBuilders.VERDANT_SANDS);

		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.desertSpawns(mobSpawnInfo);

		mobSpawnInfo.setPlayerCanSpawn();

		DefaultBiomeFeatures.addDesertExtraDecoration(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenSettings);
		biomeGenSettings.addStructureStart(StructureFeatures.VILLAGE_DESERT);
		biomeGenSettings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		biomeGenSettings.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		biomeGenSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);

		DefaultBiomeFeatures.addFossilDecoration(biomeGenSettings);
		DefaultBiomeFeatures.addJungleEdgeTrees(biomeGenSettings);
		DefaultBiomeFeatures.addSavannaTrees(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenSettings);
		DefaultBiomeFeatures.addDesertLakes(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeGenSettings);
		DefaultBiomeFeatures.addWarmFlowers(biomeGenSettings);
		DefaultBiomeFeatures.addJungleGrass(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenSettings);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.DESERT).depth(0.125F)
				.scale(0.05F).temperature(1.5F).downfall(0.5F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenSettings.build()).build();
	}

}
