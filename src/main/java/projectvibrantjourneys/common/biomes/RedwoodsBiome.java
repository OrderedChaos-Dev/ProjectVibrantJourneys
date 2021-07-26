package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class RedwoodsBiome {

	public static Biome makeRedwoodsBiome(float depth, float scale, float temperature, float downfall, boolean isSnowy) {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		
		MobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
		MobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
		MobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
		MobSpawnSettings.setPlayerCanSpawn();
		BiomeDefaultFeatures.farmAnimals(MobSpawnSettings);
		BiomeDefaultFeatures.commonSpawns(MobSpawnSettings);

		float f = isSnowy ? -0.4F : temperature;
		
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(PVJConfiguredSurfaceBuilders.REDWOODS);
		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
		biomeGenBuilder.addStructureStart(StructureFeatures.VILLAGE_TAIGA);
		biomeGenBuilder.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
		
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultLakes(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenBuilder);
		BiomeDefaultFeatures.addFerns(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenBuilder);
		BiomeDefaultFeatures.addGiantTaigaVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addSparseBerryBushes(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
		
		if(!isSnowy)
			BiomeDefaultFeatures.addPlainVegetation(biomeGenBuilder);

	      
		return (new Biome.BiomeBuilder()).precipitation(isSnowy ? Precipitation.SNOW : Precipitation.RAIN)
				.biomeCategory(Biome.BiomeCategory.TAIGA).depth(depth).scale(scale).temperature(f)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204)
						.waterFogColor(329011).fogColor(12638463)
						.grassColorOverride(0x379332).foliageColorOverride(0x379C32)
						.skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(0.25F))
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(MobSpawnSettings.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
