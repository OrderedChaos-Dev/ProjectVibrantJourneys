package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class GravelShoreBiome {

	public static Biome makeGravelShoreBiome() {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();

		DefaultBiomeFeatures.commonSpawns(mobSpawnInfo);
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.GRAVEL_SHORE);
		biomeGenBuilder.addStructureStart(StructureFeatures.MINESHAFT);
		biomeGenBuilder.addStructureStart(StructureFeatures.BURIED_TREASURE);
		biomeGenBuilder.addStructureStart(StructureFeatures.SHIPWRECH_BEACHED);

		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultLakes(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultFlowers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultGrass(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
		return (new Biome.Builder()).precipitation(Biome.RainType.RAIN)
				.biomeCategory(Biome.Category.BEACH).depth(0.0F)
				.scale(0.025F).temperature(0.6F).downfall(0.4F)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011)
						.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.6F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenBuilder.build()).build();
	}
}
