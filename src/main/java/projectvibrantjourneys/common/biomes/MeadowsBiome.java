package projectvibrantjourneys.common.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class MeadowsBiome {

	public static Biome makeMeadowsBiome() {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.plainsSpawns(mobSpawnInfo);
		mobSpawnInfo.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
		mobSpawnInfo.setPlayerCanSpawn();

		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(PVJConfiguredSurfaceBuilders.MEADOWS);
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
		biomeGenBuilder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(0.04F)
				.scale(0.05F).temperature(0.65F).downfall(0.85F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(0x97ff6b)
						.foliageColorOverride(0x59d923)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.8F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenBuilder.build()).build();
	}
}
