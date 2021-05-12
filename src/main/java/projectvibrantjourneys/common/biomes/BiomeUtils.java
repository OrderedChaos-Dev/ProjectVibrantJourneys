package projectvibrantjourneys.common.biomes;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;

public class BiomeUtils {

	public static int getSkyColorWithTemperatureModifier(float temperature) {
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}

	public static void withBasicFeatures(BiomeGenerationSettings.Builder builder) {
		DefaultBiomeFeatures.addDefaultCarvers(builder);
		DefaultBiomeFeatures.addDefaultSprings(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addDefaultMonsterRoom(builder);
		DefaultBiomeFeatures.addDefaultUndergroundVariety(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addSurfaceFreezing(builder);
		DefaultBiomeFeatures.addDefaultSoftDisks(builder);
	}

	public static void withBasicStructures(BiomeGenerationSettings.Builder builder) {
		DefaultBiomeFeatures.addDefaultOverworldLandStructures(builder);
	}

	public static void withBasicMobs(MobSpawnInfo.Builder builder) {
		DefaultBiomeFeatures.farmAnimals(builder);
		DefaultBiomeFeatures.commonSpawns(builder);
	}
}
