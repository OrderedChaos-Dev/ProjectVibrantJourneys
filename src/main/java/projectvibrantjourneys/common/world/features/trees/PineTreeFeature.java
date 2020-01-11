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
	public boolean func_225557_a_(IWorldGenerationReader p_225557_1_, Random p_225557_2_, BlockPos p_225557_3_,
			Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox p_225557_6_,
			TreeFeatureConfig p_225557_7_) {
		int i = p_225557_7_.field_227371_p_ + p_225557_2_.nextInt(p_225557_7_.field_227328_b_ + 1)
				+ p_225557_2_.nextInt(p_225557_7_.field_227329_c_ + 1);
		int j = p_225557_7_.field_227330_d_ >= 0
				? p_225557_7_.field_227330_d_ + p_225557_2_.nextInt(p_225557_7_.field_227331_f_ + 1)
				: i - (p_225557_7_.field_227334_i_ + p_225557_2_.nextInt(p_225557_7_.field_227335_j_ + 1));
		int k = p_225557_7_.field_227327_a_.func_225573_a_(p_225557_2_, j, i, p_225557_7_);
		Optional<BlockPos> optional = this.func_227212_a_(p_225557_1_, i, j, k, p_225557_3_, p_225557_7_);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(p_225557_1_, blockpos.down(), blockpos);
			p_225557_7_.field_227327_a_.func_225571_a_(p_225557_1_, p_225557_2_, p_225557_7_, i, j, k, blockpos,
					p_225557_5_);
			this.func_227213_a_(p_225557_1_, p_225557_2_, i, blockpos,
					p_225557_7_.field_227332_g_ + p_225557_2_.nextInt(p_225557_7_.field_227333_h_ + 1), p_225557_4_,
					p_225557_6_, p_225557_7_);
			return true;
		}
	}

	@Override
	protected void func_227213_a_(IWorldGenerationReader world, Random rand, int p_227213_3_, BlockPos pos, int p_227213_5_, Set<BlockPos> logs, MutableBoundingBox p_227213_7_, TreeFeatureConfig p_227213_8_) {
		for (int i = 0; i < p_227213_3_ - p_227213_5_; ++i) {
			this.func_227216_a_(world, rand, pos.up(i), logs, p_227213_7_, p_227213_8_);
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