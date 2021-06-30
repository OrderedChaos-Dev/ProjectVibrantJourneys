package projectvibrantjourneys.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class BorealPlateauBiome {

	public static Biome makeBorealPlateauBiome() {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		DefaultBiomeFeatures.farmAnimals(mobSpawnInfo);
		DefaultBiomeFeatures.commonSpawns(mobSpawnInfo);
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(ConfiguredSurfaceBuilders.STONE);

		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		
		DefaultBiomeFeatures.addDefaultCarvers(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultLakes(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		DefaultBiomeFeatures.addMossyStoneBlock(biomeGenBuilder);
		DefaultBiomeFeatures.addFerns(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSoftDisks(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultFlowers(biomeGenBuilder);
		DefaultBiomeFeatures.addGiantTaigaVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultMushrooms(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		DefaultBiomeFeatures.addSparseBerryBushes(biomeGenBuilder);
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
		
		return (new Biome.Builder())
				.precipitation(Biome.RainType.SNOW)
				.biomeCategory(Biome.Category.TAIGA)
				.depth(2.5F)
				.scale(0.1F)
				.temperature(-0.4F)
				.downfall(0.45F)
				.specialEffects((new BiomeAmbience.Builder())
						.waterColor(4020182)
						.waterFogColor(329011)
						.fogColor(12638463)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(2.0F))
						.foliageColorOverride(0x00994d)
						.grassColorOverride(0x00994d)
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
						.build())
				.mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
