package projectvibrantjourneys.common.world.features.blockplacers;

import java.util.Random;
import java.util.Set;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;

public class PVJPineFoliagePlacer extends SpruceFoliagePlacer {

	public PVJPineFoliagePlacer(FeatureSpread radius, FeatureSpread offset, FeatureSpread trunkHeight) {
		super(radius, offset, trunkHeight);
	}
	
	@Override
	protected void createFoliage(IWorldGenerationReader world, Random rand,
			BaseTreeFeatureConfig config, int p_230372_4_, FoliagePlacer.Foliage foliage, int p_230372_6_,
			int p_230372_7_, Set<BlockPos> blocks, int p_230372_9_, MutableBoundingBox box) {
		BlockPos blockpos = foliage.foliagePos();
		int i = rand.nextInt(2);
		int j = 1;
		int k = 1;
		int m = 0;

		for (int l = p_230372_9_; l >= -p_230372_6_; --l) {
			if(m < 4)
				placeLeaves(world, rand, config, blockpos, i, blocks, l, foliage.doubleTrunk(), box);
			else
				placeLeavesWithChance(world, rand, config, blockpos, i, blocks, l, foliage.doubleTrunk(), box, 0.8F);
			if (i >= j) {
				i = k;
				k = 2;
				j = Math.min(j + 1, p_230372_7_ + foliage.radiusOffset());
			} else {
				++i;
			}
			m++;
		}
	}
	
	protected void placeLeaves(IWorldGenerationReader world, Random rand,BaseTreeFeatureConfig config, BlockPos pos, int p_236753_5_, Set<BlockPos> blocks,int p_236753_7_, boolean p_236753_8_, MutableBoundingBox box) {
		int i = p_236753_8_ ? 1 : 0;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int j = -p_236753_5_; j <= p_236753_5_ + i; ++j) {
			for (int k = -p_236753_5_; k <= p_236753_5_ + i; ++k) {
				if (!this.shouldSkipLocationSigned(rand, j, p_236753_7_, k, p_236753_5_, p_236753_8_)) {
					blockpos$mutable.setWithOffset(pos, j, p_236753_7_, k);
					if (TreeFeature.validTreePos(world, blockpos$mutable) && rand.nextFloat() < 0.8F) {
						world.setBlock(blockpos$mutable, config.leavesProvider.getState(rand, blockpos$mutable), 19);
						box.expand(new MutableBoundingBox(blockpos$mutable, blockpos$mutable));
						blocks.add(blockpos$mutable.immutable());
					}
				}
			}
		}
	}
	
	protected void placeLeavesWithChance(IWorldGenerationReader world, Random rand,BaseTreeFeatureConfig config, BlockPos pos, int p_236753_5_, Set<BlockPos> blocks,int p_236753_7_, boolean p_236753_8_, MutableBoundingBox box, float chance) {
		int i = p_236753_8_ ? 1 : 0;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int j = -p_236753_5_; j <= p_236753_5_ + i; ++j) {
			for (int k = -p_236753_5_; k <= p_236753_5_ + i; ++k) {
				if (!this.shouldSkipLocationSigned(rand, j, p_236753_7_, k, p_236753_5_, p_236753_8_)) {
					blockpos$mutable.setWithOffset(pos, j, p_236753_7_, k);
					if (TreeFeature.validTreePos(world, blockpos$mutable) && rand.nextFloat() < chance) {
						world.setBlock(blockpos$mutable, config.leavesProvider.getState(rand, blockpos$mutable), 19);
						box.expand(new MutableBoundingBox(blockpos$mutable, blockpos$mutable));
						blocks.add(blockpos$mutable.immutable());
					}
				}
			}
		}
	}
}
