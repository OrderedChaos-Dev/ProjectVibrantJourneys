package com.projectvibrantjourneys.world.gen.features.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;

public class PVJPineFoliagePlacer extends SpruceFoliagePlacer {

	public PVJPineFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeight) {
		super(radius, offset, trunkHeight);
	}
	
	@Override
	protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer,
			Random rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
			int p_161352_, int p_161353_, int p_161354_) {
		BlockPos blockpos = foliage.pos();
		int i = rand.nextInt(2);
		int j = 1;
		int k = 1;
		int m = 0;

		for (int l = p_161354_; l >= -p_161352_; --l) {
			if(m < 4)
				placeLeaves(world, rand, placer, config, blockpos, i, l, foliage.doubleTrunk());
			else
				placeLeavesWithChance(world, rand, placer, config, blockpos, i, l, foliage.doubleTrunk(), 0.8F);
			if (i >= j) {
				i = k;
				k = 2;
				j = Math.min(j + 1, p_161353_ + foliage.radiusOffset());
			} else {
				++i;
			}
			m++;
		}
	}
	
	protected void placeLeaves(LevelSimulatedReader world, Random rand, BiConsumer<BlockPos, BlockState> placer, TreeConfiguration config, BlockPos pos, int p_236753_5_, int p_236753_7_, boolean p_236753_8_) {
		int i = p_236753_8_ ? 1 : 0;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int j = -p_236753_5_; j <= p_236753_5_ + i; ++j) {
			for (int k = -p_236753_5_; k <= p_236753_5_ + i; ++k) {
				if (!this.shouldSkipLocationSigned(rand, j, p_236753_7_, k, p_236753_5_, p_236753_8_)) {
					blockpos$mutable.setWithOffset(pos, j, p_236753_7_, k);
					if (TreeFeature.validTreePos(world, blockpos$mutable) && rand.nextFloat() < 0.8F) {
						placer.accept(blockpos$mutable, config.foliageProvider.getState(rand, blockpos$mutable));
					}
				}
			}
		}
	}
	
	protected void placeLeavesWithChance(LevelSimulatedReader world, Random rand, BiConsumer<BlockPos, BlockState> placer, TreeConfiguration config, BlockPos pos, int p_236753_5_, int p_236753_7_, boolean p_236753_8_, float chance) {
		int i = p_236753_8_ ? 1 : 0;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int j = -p_236753_5_; j <= p_236753_5_ + i; ++j) {
			for (int k = -p_236753_5_; k <= p_236753_5_ + i; ++k) {
				if (!this.shouldSkipLocationSigned(rand, j, p_236753_7_, k, p_236753_5_, p_236753_8_)) {
					blockpos$mutable.setWithOffset(pos, j, p_236753_7_, k);
					if (TreeFeature.validTreePos(world, blockpos$mutable) && rand.nextFloat() < chance) {
						placer.accept(blockpos$mutable, config.foliageProvider.getState(rand, blockpos$mutable));
					}
				}
			}
		}
	}
}
