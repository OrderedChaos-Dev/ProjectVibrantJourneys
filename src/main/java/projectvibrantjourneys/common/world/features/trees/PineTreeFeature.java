package projectvibrantjourneys.common.world.features.trees;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class PineTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {
	public PineTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> p_i225820_1_) {
		super(p_i225820_1_);
	}
	/*
	 * honestly, I really don't know what these do because there are no 1.15 mappings yet
	 * so I just guess
	 */

	@Override
	public boolean func_225557_a_(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox boundingBox,
			TreeFeatureConfig config) {
		int i = config.field_227371_p_ + rand.nextInt(config.field_227328_b_ + 1) + rand.nextInt(config.field_227329_c_ + 1);
		int j = config.field_227330_d_ >= 0 ? config.field_227330_d_ + rand.nextInt(config.field_227331_f_ + 1)
				: i - (config.field_227334_i_ + rand.nextInt(config.field_227335_j_ + 1));
		int k = config.field_227327_a_.func_225573_a_(rand, j, i, config);
		Optional<BlockPos> optional = this.func_227212_a_(world, i, j, k, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			config.field_227327_a_.func_225571_a_(world, rand, config, i, j, k, blockpos, leaves);
			this.func_227213_a_(world, rand, i, blockpos, config.field_227332_g_ + rand.nextInt(config.field_227333_h_ + 1), logs, boundingBox, config);
			return true;
		}
	}

	@Override
	protected void func_227213_a_(IWorldGenerationReader world, Random rand, int p_227213_3_, BlockPos pos, int p_227213_5_, Set<BlockPos> logs, MutableBoundingBox p_227213_7_, TreeFeatureConfig config) {
		for (int i = 0; i < p_227213_3_ - p_227213_5_; ++i) {
			this.func_227216_a_(world, rand, pos.up(i), logs, p_227213_7_, config);
			if (i > 3) {
				Direction dir = Direction.Plane.HORIZONTAL.random(rand);
				setBranch(world, rand, pos.up(i), dir, logs);
			}
		}
	}
	
	private void setBranch(IWorldGenerationReader world, Random rand, BlockPos pos, Direction dir, Set<BlockPos> logs) {
		pos = pos.offset(dir);
		BlockState log = PVJBlocks.pine_log.getDefaultState().with(LogBlock.AXIS, dir.getAxis());
		BlockState leaves = PVJBlocks.pine_leaves.getDefaultState().with(LeavesBlock.DISTANCE, 1);
		
		world.setBlockState(pos, log, 19);
		for(Direction offset : Direction.values()) {
			if(offset != dir.getOpposite()) {
				world.setBlockState(pos.offset(offset), leaves, 19);
			}
		}
	}
}