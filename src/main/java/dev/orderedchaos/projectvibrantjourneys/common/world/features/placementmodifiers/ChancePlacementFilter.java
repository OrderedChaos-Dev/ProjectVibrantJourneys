package dev.orderedchaos.projectvibrantjourneys.common.world.features.placementmodifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import dev.orderedchaos.projectvibrantjourneys.core.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class ChancePlacementFilter extends PlacementFilter {

  public static final MapCodec<ChancePlacementFilter> CODEC = PrimitiveCodec.STRING.fieldOf("weightConfigSpec").xmap(ChancePlacementFilter::new, filter -> filter.weightConfigSpec);

  private final String weightConfigSpec;

  private ChancePlacementFilter(String weightConfigSpec) {
    this.weightConfigSpec = weightConfigSpec;
  }

  public static ChancePlacementFilter of(String weightConfigSpec) {
    return new ChancePlacementFilter(weightConfigSpec);
  }

  @Override
  protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
    double value = PVJConfig.weightOptions.get(weightConfigSpec).get();
    return value >= 1.0D - random.nextDouble();
  }

  @Override
  public PlacementModifierType<?> type() {
    return PVJPlacementModifiers.CHANCE.get();
  }
}
