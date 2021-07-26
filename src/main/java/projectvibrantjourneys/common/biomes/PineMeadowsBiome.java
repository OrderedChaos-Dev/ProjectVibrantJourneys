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
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class PineMeadowsBiome {

	public static Biome makePineMeadowsBiome() {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.plainsSpawns(MobSpawnSettings);
		MobSpawnSettings.setPlayerCanSpawn();

		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(PVJConfiguredSurfaceBuilders.PINE_MEADOWS);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_TAIGA)
				.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultLakes(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addTaigaGrass(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
		biomeGenBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		biomeGenBuilder.addFeature(Decoration.VEGETAL_DECORATION, Features.PATCH_SUNFLOWER);
		biomeGenBuilder.addFeature(Decoration.VEGETAL_DECORATION, Features.OAK_BEES_0002);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).depth(0.125F)
				.scale(0.05F).temperature(0.7F).downfall(0.8F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011)
						.grassColorOverride(0x59cf70)
						.foliageColorOverride(0x69cf59)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.8F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build()).generationSettings(biomeGenBuilder.build()).build();
	}
}//.grassColorOverride(0xa7cc5c)
