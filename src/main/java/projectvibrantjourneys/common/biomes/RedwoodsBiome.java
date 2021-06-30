package projectvibrantjourneys.common.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class RedwoodsBiome {

	public static Biome makeRedwoodsBiome(float depth, float scale, float temperature, float downfall, boolean isSnowy) {
		MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder();
		
		mobSpawnInfo.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 8, 4, 4));
		mobSpawnInfo.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
		mobSpawnInfo.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 8, 2, 4));
		mobSpawnInfo.setPlayerCanSpawn();
		DefaultBiomeFeatures.farmAnimals(mobSpawnInfo);
		DefaultBiomeFeatures.commonSpawns(mobSpawnInfo);

		float f = isSnowy ? -0.4F : temperature;
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.REDWOODS);
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_TAIGA);
		biomeGenBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		
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
		DefaultBiomeFeatures.addDefaultSprings(biomeGenBuilder);
		DefaultBiomeFeatures.addSparseBerryBushes(biomeGenBuilder);
		DefaultBiomeFeatures.addSurfaceFreezing(biomeGenBuilder);
		
		if(!isSnowy)
			DefaultBiomeFeatures.addPlainVegetation(biomeGenBuilder);

	      
		return (new Biome.Builder()).precipitation(isSnowy ? RainType.SNOW : RainType.RAIN)
				.biomeCategory(Biome.Category.TAIGA).depth(depth).scale(scale).temperature(f)
				.downfall(downfall)
				.specialEffects((new BiomeAmbience.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.grassColorOverride(0x379332).foliageColorOverride(0x379C32)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.25F))
						.ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
