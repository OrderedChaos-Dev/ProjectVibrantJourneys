package dev.orderedchaos.projectvibrantjourneys.common.world.features.placementmodifiers;

import com.mojang.serialization.MapCodec;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPlacementModifiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

/**
 * Filter for nether features to prevent them spawning on bedrock
 */
public class NetherNoBedrockFilter extends PlacementFilter {

  private static final NetherNoBedrockFilter INSTANCE = new NetherNoBedrockFilter();
  public static final MapCodec<NetherNoBedrockFilter> CODEC = MapCodec.unit(() -> INSTANCE);

  @Override
  protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
    WorldGenLevel level = context.getLevel();
    return !level.getBlockState(pos).is(Blocks.BEDROCK);
  }

  public static NetherNoBedrockFilter noBedrockFilter() {
    return INSTANCE;
  }

  @Override
  public PlacementModifierType<?> type() {
    return PVJPlacementModifiers.NETHER_NO_BEDROCK.get();
  }
}
