package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.PVJConfiguredSurfaceBuilders;

public class VerdantSandsBiome {

	public static Biome makeVerdantSandsBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.withSurfaceBuilder(PVJConfiguredSurfaceBuilders.VERDANT_SANDS);

		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.withDesertMobs(mobSpawnInfo);

		mobSpawnInfo.isValidSpawnBiomeForPlayer();

		DefaultBiomeFeatures.withDesertWells(biomeGenSettings);
		DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeGenSettings);
		biomeGenSettings.withStructure(StructureFeatures.VILLAGE_DESERT);
		biomeGenSettings.withStructure(StructureFeatures.PILLAGER_OUTPOST);
		biomeGenSettings.withStructure(StructureFeatures.DESERT_PYRAMID);
		biomeGenSettings.withStructure(StructureFeatures.RUINED_PORTAL_DESERT);

		DefaultBiomeFeatures.withFossils(biomeGenSettings);
		DefaultBiomeFeatures.withJungleEdgeTrees(biomeGenSettings);
		DefaultBiomeFeatures.withSavannaTrees(biomeGenSettings);
		DefaultBiomeFeatures.withCavesAndCanyons(biomeGenSettings);
		DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenSettings);
		DefaultBiomeFeatures.withMonsterRoom(biomeGenSettings);
		DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGenSettings);
		DefaultBiomeFeatures.withOverworldOres(biomeGenSettings);
		DefaultBiomeFeatures.withWarmFlowers(biomeGenSettings);
		DefaultBiomeFeatures.withJungleGrass(biomeGenSettings);
		DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGenSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGenSettings);
		DefaultBiomeFeatures.withNormalMushroomGeneration(biomeGenSettings);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.DESERT).depth(0.125F)
				.scale(0.05F).temperature(1.5F).downfall(0.5F)
				.setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011)
						.setFogColor(12638463).withSkyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
				.withMobSpawnSettings(mobSpawnInfo.copy()).withGenerationSettings(biomeGenSettings.build()).build();
	}

}
