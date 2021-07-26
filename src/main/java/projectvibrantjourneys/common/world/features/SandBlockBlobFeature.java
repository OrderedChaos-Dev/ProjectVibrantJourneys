package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class SandBlockBlobFeature extends Feature<BlockStateConfiguration> {

	public SandBlockBlobFeature(Codec<BlockStateConfiguration> config) {
		super(config);
	}

	@Override
	 public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		BlockPos pos = context.origin();
		WorldGenLevel world = context.level();
		Random rand = context.random();
		while (true) {
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

				for (int l = 0; l < 4; ++l) {
					int i = rand.nextInt(2);
					int j = rand.nextInt(2);
					int k = rand.nextInt(2);
					float f = (float) (i + j + k) * 0.333F + 0.5F;

					for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
						if (blockpos.distSqr(pos) <= (double) (f * f)) {
							world.setBlock(blockpos, context.config().state, 4);
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