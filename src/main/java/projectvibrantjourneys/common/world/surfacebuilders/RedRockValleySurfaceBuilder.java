package projectvibrantjourneys.common.world.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.BadlandsSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class RedRockValleySurfaceBuilder extends BadlandsSurfaceBuilder {
   private static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.defaultBlockState();
   private static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.defaultBlockState();
   private static final BlockState TERRACOTTA = Blocks.TERRACOTTA.defaultBlockState();

   public RedRockValleySurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec) {
      super(codec);
   }

   @Override
   public void apply(Random random, ChunkAccess chunk, Biome biome, int x, int z, int startNoise, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int bottom, long seed, SurfaceBuilderBaseConfiguration config) {
      double d0 = 0.0D;
      double d1 = Math.min(Math.abs(noise), this.pillarNoise.getValue((double)x * 0.25D, (double)z * 0.25D, false) * 15.0D);
      if (d1 > 0.0D) {
         double d2 = 0.001953125D;
         double d3 = Math.abs(this.pillarRoofNoise.getValue((double)x * 0.001953125D, (double)z * 0.001953125D, false));
         d0 = d1 * d1 * 2.5D;
         double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
         if (d0 > d4) {
            d0 = d4;
         }

         d0 = d0 + 64.0D;
      }

      int i1 = x & 15;
      int i = z & 15;
      BlockState blockstate3 = WHITE_TERRACOTTA;
      SurfaceBuilderConfiguration iSurfaceBuilderConfiguration = biome.getGenerationSettings().getSurfaceBuilderConfig();
      BlockState blockstate4 = iSurfaceBuilderConfiguration.getUnderMaterial();
      BlockState blockstate = iSurfaceBuilderConfiguration.getTopMaterial();
      BlockState blockstate1 = blockstate4;
      int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
      boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
      int k = -1;
      boolean flag1 = false;
      BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

      for(int l = Math.max(startNoise, (int)d0 + 1); l >= 0; --l) {
         blockpos$mutable.set(i1, l, i);
         if (chunk.getBlockState(blockpos$mutable).isAir() && l < (int)d0) {
            chunk.setBlockState(blockpos$mutable, defaultBlock, false);
         }

         BlockState blockstate2 = chunk.getBlockState(blockpos$mutable);
         if (blockstate2.isAir()) {
            k = -1;
         } else if (blockstate2.is(defaultBlock.getBlock())) {
            if (k == -1) {
               flag1 = false;
               if (j <= 0) {
                  blockstate3 = Blocks.AIR.defaultBlockState();
                  blockstate1 = defaultBlock;
               } else if (l >= seaLevel - 4 && l <= seaLevel + 1) {
                  blockstate3 = WHITE_TERRACOTTA;
                  blockstate1 = blockstate4;
               }

               if (l < seaLevel && (blockstate3 == null || blockstate3.isAir())) {
                  blockstate3 = defaultFluid;
               }

               k = j + Math.max(0, l - seaLevel);
               if (l >= seaLevel - 1) {
                  if (l <= seaLevel + 5 + j) {
                	  if(noise < 0.0D)
                		  chunk.setBlockState(blockpos$mutable, Blocks.GRASS_BLOCK.defaultBlockState(), false);
                	  else
                		  chunk.setBlockState(blockpos$mutable, blockstate, false);
                     flag1 = true;
                  } else {
                     BlockState blockstate5;
                     if (l >= 64 && l <= 127) {
                        if (flag) {
                           blockstate5 = TERRACOTTA;
                        } else {
                           blockstate5 = this.getBand(x, l, z);
                        }
                     } else {
                        blockstate5 = ORANGE_TERRACOTTA;
                     }

                     chunk.setBlockState(blockpos$mutable, blockstate5, false);
                  }
               } else {
                  chunk.setBlockState(blockpos$mutable, blockstate1, false);
                  Block block = blockstate1.getBlock();
                  if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
                     chunk.setBlockState(blockpos$mutable, ORANGE_TERRACOTTA, false);
                  }
               }
            } else if (k > 0) {
               --k;
               if (flag1) {
                  chunk.setBlockState(blockpos$mutable, ORANGE_TERRACOTTA, false);
               } else {
                  chunk.setBlockState(blockpos$mutable, this.getBand(x, l, z), false);
               }
            }
         }
      }

   }
}
