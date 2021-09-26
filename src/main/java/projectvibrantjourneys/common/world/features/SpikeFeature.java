package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.Tags;

public class SpikeFeature extends Feature<BlockStateFeatureConfig> {
	   public SpikeFeature(Codec<BlockStateFeatureConfig> codec) {
	      super(codec);
	   }

	@Override
	public boolean place(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos,
			BlockStateFeatureConfig config) {
		while (world.isEmptyBlock(pos) && pos.getY() > 2) {
			pos = pos.below();
		}

		if (!world.getBlockState(pos).is(Blocks.GRASS_BLOCK) && !world.getBlockState(pos).is(Tags.Blocks.STONE)
				&& !world.getBlockState(pos).is(Tags.Blocks.DIRT)) {
			return false;
		} else {
			pos = pos.above(rand.nextInt(4));
			int i = rand.nextInt(4) + 7;
			int j = i / 4 + rand.nextInt(2);
			if (j > 1 && rand.nextInt(60) == 0) {
				pos = pos.above(10 + rand.nextInt(30));
			}

			for (int k = 0; k < i; ++k) {
				float f = (1.0F - (float) k / (float) i) * (float) j;
				int l = MathHelper.ceil(f);

				for (int i1 = -l; i1 <= l; ++i1) {
					float f1 = (float) MathHelper.abs(i1) - 0.25F;

					for (int j1 = -l; j1 <= l; ++j1) {
						float f2 = (float) MathHelper.abs(j1) - 0.25F;
						if ((i1 == 0 && j1 == 0 || !(f1 * f1 + f2 * f2 > f * f))
								&& (i1 != -l && i1 != l && j1 != -l && j1 != l || !(rand.nextFloat() > 0.75F))) {
							BlockState blockstate = world.getBlockState(pos.offset(i1, k, j1));
							Block block = blockstate.getBlock();
							if (blockstate.isAir(world, pos.offset(i1, k, j1)) || isDirt(block)) {
								this.setBlock(world, pos.offset(i1, k, j1), config.state);
							}

							if (k != 0 && l > 1) {
								blockstate = world.getBlockState(pos.offset(i1, -k, j1));
								block = blockstate.getBlock();
								if (blockstate.isAir(world, pos.offset(i1, -k, j1)) || isDirt(block)) {
									this.setBlock(world, pos.offset(i1, -k, j1), config.state);
								}
							}
						}
					}
				}
			}

			int k1 = j - 1;
			if (k1 < 0) {
				k1 = 0;
			} else if (k1 > 1) {
				k1 = 1;
			}

			for (int l1 = -k1; l1 <= k1; ++l1) {
				for (int i2 = -k1; i2 <= k1; ++i2) {
					BlockPos blockpos = pos.offset(l1, -1, i2);
					int j2 = 50;
					if (Math.abs(l1) == 1 && Math.abs(i2) == 1) {
						j2 = rand.nextInt(5);
					}

					while (blockpos.getY() > 50) {
						BlockState blockstate1 = world.getBlockState(blockpos);
						Block block1 = blockstate1.getBlock();
						if (!blockstate1.isAir(world, blockpos) && block1 != config.state.getBlock()) {
							break;
						}

						this.setBlock(world, blockpos, config.state);
						blockpos = blockpos.below();
						--j2;
						if (j2 <= 0) {
							blockpos = blockpos.below(rand.nextInt(5) + 1);
							j2 = rand.nextInt(5);
						}
					}
				}
			}

			return true;
		}
	}
}