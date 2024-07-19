package dev.orderedchaos.projectvibrantjourneys.common.world.features.placementmodifiers;

import com.mojang.serialization.MapCodec;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.common.Tags;

/**
 * A placement filter that attempts to lower the amount of groundcover and other vegetation generated based on BiomeTags
 * e.g. plains type biomes tend to have less vegetation
 */
public class BiomeDensityPlacementFilter extends PlacementFilter {

  private static final BiomeDensityPlacementFilter INSTANCE = new BiomeDensityPlacementFilter();
  public static MapCodec<BiomeDensityPlacementFilter> CODEC = MapCodec.unit(() -> INSTANCE);

  @Override
  protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
    Holder<Biome> biome = context.getLevel().getBiome(pos);
    if (biome.is(Tags.Biomes.IS_PLAINS) || biome.is(BiomeTags.IS_SAVANNA) || biome.is(Biomes.MEADOW) || biome.is(Tags.Biomes.IS_SPARSE_VEGETATION)) {
      return random.nextBoolean();
    } else if (biome.is(Biomes.WINDSWEPT_HILLS) || biome.is(Biomes.WINDSWEPT_GRAVELLY_HILLS)) {
      return random.nextBoolean();
    }
    return true;
  }

  public static BiomeDensityPlacementFilter filter() {
    return INSTANCE;
  }

  @Override
  public PlacementModifierType<?> type() {
    return PVJPlacementModifiers.VEGETATION_DENSITY.get();
  }
}
