package dev.orderedchaos.projectvibrantjourneys.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ServerLevelAccessor;

public class LevelUtils {
  public static boolean isEmptyOrReplaceable(ServerLevelAccessor level, BlockPos pos) {
    return level.isEmptyBlock(pos) || level.getBlockState(pos).is(BlockTags.REPLACEABLE);
  }
}
