package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class BlossomingFieldsBiome {

	public static Biome makeBlossomingFieldsBiome() {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.plainsSpawns(mobSpawnInfo);
		mobSpawnInfo.setPlayerCanSpawn();

		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_PLAINS)
				.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);

		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultLakes(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenBuilder);
		biomeGenBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION_COMMON);
		biomeGenBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST);
		DefaultBiomeFeatures.addPlainGrass(biomeGenBuilder);
		biomeGenBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.01F)
				.scale(0.01F).temperature(0.5F).downfall(0.55F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(0xaeed5c)
						.foliageColorOverride(0xaeed5c)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.8F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenBuilder.build()).build();
	}
}
