package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class VerdantSandsBiome {

	public static Biome makeVerdantSandsBiome() {
		BiomeGenerationSettings.Builder biomeGenSettings = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(PVJConfiguredSurfaceBuilders.VERDANT_SANDS);

		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(MobSpawnSettings);
		BiomeDefaultFeatures.desertSpawns(MobSpawnSettings);

		MobSpawnSettings.setPlayerCanSpawn();

		BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenSettings);
		biomeGenSettings.addStructureStart(StructureFeatures.VILLAGE_DESERT);
		biomeGenSettings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		biomeGenSettings.addStructureStart(StructureFeatures.DESERT_PYRAMID);
		biomeGenSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);

		BiomeDefaultFeatures.addFossilDecoration(biomeGenSettings);
		BiomeDefaultFeatures.addJungleEdgeTrees(biomeGenSettings);
		BiomeDefaultFeatures.addSavannaTrees(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenSettings);
		BiomeDefaultFeatures.addDesertLakes(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenSettings);
		BiomeDefaultFeatures.addWarmFlowers(biomeGenSettings);
		BiomeDefaultFeatures.addJungleGrass(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenSettings);
		BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenSettings);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_RIVER);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP);
		biomeGenSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_WATERLILLY);

		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.DESERT).depth(0.125F)
				.scale(0.05F).temperature(1.5F).downfall(0.5F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.95F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build()).generationSettings(biomeGenSettings.build()).build();
	}

}
