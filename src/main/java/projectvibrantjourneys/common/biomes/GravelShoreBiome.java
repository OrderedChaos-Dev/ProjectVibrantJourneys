package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class GravelShoreBiome {

	public static Biome makeGravelShoreBiome() {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();

		BiomeDefaultFeatures.commonSpawns(MobSpawnSettings);
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.GRAVEL_SHORE);
		biomeGenBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		biomeGenBuilder.addStructureStart(StructureFeatures.BURIED_TREASURE);
		biomeGenBuilder.addStructureStart(StructureFeatures.SHIPWRECH_BEACHED);

		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultLakes(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultGrass(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
				.biomeCategory(Biome.BiomeCategory.BEACH).depth(0.0F)
				.scale(0.025F).temperature(0.6F).downfall(0.4F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.6F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build()).generationSettings(biomeGenBuilder.build()).build();
	}
}
