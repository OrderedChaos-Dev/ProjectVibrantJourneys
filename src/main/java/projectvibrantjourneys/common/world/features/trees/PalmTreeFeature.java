package projectvibrantjourneys.common.world.features.trees;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class PalmTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public PalmTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> function) {
		super(function);
	}

	@Override
	protected boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = 5 + rand.nextInt(3) + rand.nextInt(4);
		
		Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			this.func_227213_a_(world, rand, height, pos, 0, logs, box, config);
			
			return true;
		}
	}

	//this is a dumpster fire and I will fix it later
	@Override
	protected void func_227213_a_(IWorldGenerationReader world, Random rand, int a, BlockPos pos, int c, Set<BlockPos> logs, MutableBoundingBox box, TreeFeatureConfig config) {
		Direction dir = Direction.Plane.HORIZONTAL.random(rand);
		BlockPos logPos = pos;
		this.setLog(world, rand, logPos, logs, box, config);
		for (int i = 0; i < a - c; ++i) {
			logPos = logPos.up();
			if (rand.nextBoolean()) {
				logPos = logPos.offset(dir);
				if (rand.nextInt(3) > 0) {
					this.setLog(world, rand, logPos.down(), logs, box, config);
				}
			}
			this.setLog(world, rand, logPos, logs, box, config);
		}
		
		BlockState leaf = config.leavesProvider.getBlockState(rand, logPos);
		world.setBlockState(logPos.up(), leaf, 2);
		
		for (int xOffset = -2; xOffset <= 2; xOffset++) {
			for (int zOffset = -2; zOffset <= 2; zOffset++) {
				BlockPos leafpos = new BlockPos(logPos.getX() + xOffset, logPos.getY() + 1, logPos.getZ() + zOffset);
				if (!leafpos.equals(logPos)) {
					if (Math.abs(xOffset) == 2 || Math.abs(zOffset) == 2) {
						if (rand.nextInt(3) == 0 && (Math.abs(xOffset) != Math.abs(zOffset))) {
							world.setBlockState(leafpos, leaf, 2);
							if (rand.nextInt(7) == 0) {
								if(!world.hasBlockState(leafpos.down(), (state) -> (state.getBlock() instanceof LogBlock))) {
									world.setBlockState(leafpos.down(), PVJBlocks.coconut.getDefaultState(), 2);
								}
							}
						}
					} else {
						world.setBlockState(leafpos, leaf, 2);
						if (rand.nextInt(7) == 0) {
							if(!world.hasBlockState(leafpos.down(), (state) -> (state.getBlock() instanceof LogBlock))) {
								world.setBlockState(leafpos.down(), PVJBlocks.coconut.getDefaultState(), 2);
							}
						}

					}
				}
			}
         }
         
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).west(2 + i);

			world.setBlockState(leafpos, leaf, 2);
			world.setBlockState(leafpos.down(), leaf, 2);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).east(2 + i);
			world.setBlockState(leafpos, leaf, 2);
			world.setBlockState(leafpos.down(), leaf, 2);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).north(2 + i);
			world.setBlockState(leafpos, leaf, 2);
			world.setBlockState(leafpos.down(), leaf, 2);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).south(2 + i);
			world.setBlockState(leafpos, leaf, 2);
			world.setBlockState(leafpos.down(), leaf, 2);
		}
	}
}
