package dev.orderedchaos.projectvibrantjourneys.common.mixin;

import dev.orderedchaos.projectvibrantjourneys.core.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJPlacements;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(GrassBlock.class)
public class GrassBlockMixin {

  @Inject(method = "performBonemeal", at = @At(value = "TAIL"))
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, CallbackInfo info) {
    if (PVJConfig.shortGrassFromBoneMeal.get()) {
      BlockPos blockpos = pos.above();
      BlockState blockstate = PVJBlocks.SHORT_GRASS.get().defaultBlockState();
      Optional<Holder.Reference<PlacedFeature>> optional = level.registryAccess()
        .registryOrThrow(Registries.PLACED_FEATURE)
        .getHolder(PVJPlacements.SHORT_GRASS_BONEMEAL);

      label49:
      for (int i = 0; i < 64; i++) {
        BlockPos blockpos1 = blockpos;

        for (int j = 0; j < i / 16; j++) {
          blockpos1 = blockpos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
          if (!level.getBlockState(blockpos1.below()).is(Blocks.GRASS_BLOCK) || level.getBlockState(blockpos1).isCollisionShapeFullBlock(level, blockpos1)) {
            continue label49;
          }
        }

        BlockState blockstate1 = level.getBlockState(blockpos1);
        if (blockstate1.is(blockstate.getBlock()) && random.nextInt(10) == 0) {
          level.setBlock(blockpos1, Blocks.SHORT_GRASS.defaultBlockState(), 3);
        }

        if (blockstate1.isAir()) {
          BlockPos finalBlockpos = blockpos1;
          optional.ifPresent((holder) -> {
            holder.value().place(level, level.getChunkSource().getGenerator(), random, finalBlockpos);
          });
        }
      }
    }
  }
}
