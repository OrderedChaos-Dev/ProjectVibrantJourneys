package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;

public class OvergrownSpiresBiome {

	public static Biome makeShatteredJungleBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(SurfaceBuilders.SHATTERED_SAVANNA);
		
	      MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
	      BiomeDefaultFeatures.baseJungleSpawns(MobSpawnSettings);
		MobSpawnSettings
				.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2))
				.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3))
				.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 1, 2));
		MobSpawnSettings.setPlayerCanSpawn();

		biomeGenSettings.addStructureStart(StructureFeatures.JUNGLE_TEMPLE);
		biomeGenSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_JUNGLE);

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultLakes(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addWarmFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenSettings);
		BiomeDefaultFeatures.addJungleGrass(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenSettings);
		BiomeDefaultFeatures.addJungleExtraVegetation(biomeGenSettings);

		biomeGenSettings.addFeature(Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP);

		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).depth(0.3625F)
				.scale(1.225F).temperature(0.95F).downfall(0.9F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4445678).waterFogColor(270131)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build()).generationSettings(biomeGenSettings.build()).build();
	}

}
