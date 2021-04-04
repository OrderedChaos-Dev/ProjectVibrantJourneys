package projectvibrantjourneys.common.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class OvergrownSpiresBiome {

	public static Biome makeShatteredJungleBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244186_r);
		
	      MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
	      DefaultBiomeFeatures.withSpawnsWithExtraChickens(mobSpawnInfo);
		mobSpawnInfo
				.withSpawner(EntityClassification.CREATURE,
						new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2))
				.withSpawner(EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 3))
				.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PANDA, 1, 1, 2));
		mobSpawnInfo.isValidSpawnBiomeForPlayer();

		biomeGenSettings.withStructure(StructureFeatures.JUNGLE_PYRAMID);
		biomeGenSettings.withStructure(StructureFeatures.RUINED_PORTAL_JUNGLE);

		DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeGenSettings);
		DefaultBiomeFeatures.withCavesAndCanyons(biomeGenSettings);
		DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenSettings);
		DefaultBiomeFeatures.withMonsterRoom(biomeGenSettings);
		DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGenSettings);
		DefaultBiomeFeatures.withOverworldOres(biomeGenSettings);
		DefaultBiomeFeatures.withWarmFlowers(biomeGenSettings);
		DefaultBiomeFeatures.withJungleGrass(biomeGenSettings);
		DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGenSettings);
		DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGenSettings);
		DefaultBiomeFeatures.withMelonPatchesAndVines(biomeGenSettings);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.JUNGLE).depth(0.3625F)
				.scale(1.225F).temperature(0.95F).downfall(0.9F)
				.setEffects((new BiomeAmbience.Builder()).setWaterColor(4445678).setWaterFogColor(270131)
						.setFogColor(12638463).withSkyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build())
				.withMobSpawnSettings(mobSpawnInfo.copy()).withGenerationSettings(biomeGenSettings.build()).build();
	}

}
