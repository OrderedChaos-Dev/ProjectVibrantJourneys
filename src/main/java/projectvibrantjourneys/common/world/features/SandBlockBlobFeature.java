package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.SandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class SandBlockBlobFeature extends Feature<BlockStateFeatureConfig> {
	
	   public SandBlockBlobFeature(Codec<BlockStateFeatureConfig> config) {
	      super(config);
	   }

	   public boolean place(ISeedReader world, ChunkGenerator chunk, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
	      while(true) {
	         label46: {
	            if (pos.getY() > 3) {
	               if (world.isEmptyBlock(pos.below())) {
	                  break label46;
	               }

	               Block block = world.getBlockState(pos.below()).getBlock();
	               if (!(block instanceof SandBlock)) {
	                  break label46;
	               }
	            }

	            if (pos.getY() <= 3) {
	               return false;
	            }

	            for(int l = 0; l < 4; ++l) {
	               int i = rand.nextInt(2);
	               int j = rand.nextInt(2);
	               int k = rand.nextInt(2);
	               float f = (float)(i + j + k) * 0.333F + 0.5F;

	               for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
	                  if (blockpos.distSqr(pos) <= (double)(f * f)) {
	                     world.setBlock(blockpos, config.state, 4);
	                  }
	               }

	               pos = pos.offset(-1 + rand.nextInt(2), -rand.nextInt(2), -1 + rand.nextInt(2));
	            }

	            return true;
	         }

	         pos = pos.below();
	      }
	   }
	}