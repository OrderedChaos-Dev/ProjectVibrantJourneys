package projectvibrantjourneys.common.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class OvergrownSpiresBiome {

	public static Biome makeShatteredJungleBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(ConfiguredSurfaceBuilders.SHATTERED_SAVANNA);
		
	      MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
	      DefaultBiomeFeatures.baseJungleSpawns(mobSpawnInfo);
		mobSpawnInfo
				.addSpawn(EntityClassification.CREATURE,
						new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2))
				.addSpawn(EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 3))
				.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PANDA, 1, 1, 2));
		mobSpawnInfo.setPlayerCanSpawn();

		biomeGenSettings.addStructureStart(StructureFeatures.JUNGLE_TEMPLE);
		biomeGenSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_JUNGLE);

		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultLakes(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultOres(biomeGenSettings);
		DefaultBiomeFeatures.addWarmFlowers(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenSettings);
		DefaultBiomeFeatures.addJungleGrass(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenSettings);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenSettings);
		DefaultBiomeFeatures.addJungleExtraVegetation(biomeGenSettings);

		biomeGenSettings.addFeature(Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP);

		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.JUNGLE).depth(0.3625F)
				.scale(1.225F).temperature(0.95F).downfall(0.9F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4445678).waterFogColor(270131)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenSettings.build()).build();
	}

}
