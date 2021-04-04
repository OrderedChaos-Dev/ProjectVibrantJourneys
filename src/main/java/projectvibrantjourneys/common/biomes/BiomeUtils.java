package projectvibrantjourneys.common.biomes;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class BiomeUtils {

	public static int getSkyColorWithTemperatureModifier(float temperature) {
		float lvt_1_1_ = temperature / 3.0F;
		lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
		return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}

	public static void withBasicFeatures(BiomeGenerationSettings.Builder builder) {
		DefaultBiomeFeatures.withCavesAndCanyons(builder);
		DefaultBiomeFeatures.withLavaAndWaterSprings(builder);
		DefaultBiomeFeatures.withNormalMushroomGeneration(builder);
		DefaultBiomeFeatures.withLavaAndWaterLakes(builder);
		DefaultBiomeFeatures.withMonsterRoom(builder);
		DefaultBiomeFeatures.withCommonOverworldBlocks(builder);
		DefaultBiomeFeatures.withOverworldOres(builder);
		DefaultBiomeFeatures.withClayDisks(builder);
		DefaultBiomeFeatures.withFrozenTopLayer(builder);
		DefaultBiomeFeatures.withDisks(builder);
	}

	public static void withBasicStructures(BiomeGenerationSettings.Builder builder) {
		builder.withStructure(StructureFeatures.MINESHAFT);
	}

	public static void withBasicMobs(MobSpawnInfo.Builder builder) {
		DefaultBiomeFeatures.withPassiveMobs(builder);
		DefaultBiomeFeatures.withBatsAndHostiles(builder);
	}
}
