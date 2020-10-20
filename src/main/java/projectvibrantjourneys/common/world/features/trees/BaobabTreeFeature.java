package projectvibrantjourneys.common.world.features.trees;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.HugeTreesFeature;

public class BaobabTreeFeature extends HugeTreesFeature<HugeTreeFeatureConfig> {
	public BaobabTreeFeature(Function<Dynamic<?>, ? extends HugeTreeFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs,
			Set<BlockPos> leaves, MutableBoundingBox box, HugeTreeFeatureConfig config) {
		int height = this.func_227256_a_(rand, config);
		if (!this.hasRoom(world, pos, height, config)) {
			return false;
		} else {
			//place trunk
			this.func_227254_a_(world, rand, pos, height, logs, box, config);
			
			//place branches
			BlockPos branchStart = pos.up(height - 2);
			genBranches(world, Direction.NORTH, Direction.WEST, rand, branchStart, logs, leaves, box, config);
			genBranches(world, Direction.SOUTH, Direction.WEST, rand, branchStart.south(), logs, leaves, box, config);
			genBranches(world, Direction.NORTH, Direction.EAST, rand, branchStart.east(), logs, leaves, box, config);
			genBranches(world, Direction.SOUTH, Direction.EAST, rand, branchStart.south().east(), logs, leaves, box, config);
			
			//place "roots"
			BlockPos innerLayerPos = pos.south(2).west();
			for (int x = 0; x < 4; x++) {
				for (int z = 0; z < 4; z++) {
					int h = 4 + rand.nextInt(3);
					BlockPos tempPos = innerLayerPos.north(x).east(z).up(h);
					for (int i = 0; i < 10; i++) {
						BlockPos p = tempPos.down(i);
						if (canPlaceRoot(world, p))
							this.setLog(world, rand, p, logs, box, config);
						else
							break;
					}
				}
			}
			placeRoot(world, rand, pos.west(2), logs, box, config);
			placeRoot(world, rand, pos.west(2).south(), logs, box, config);
			placeRoot(world, rand, pos.north(2), logs, box, config);
			placeRoot(world, rand, pos.north(2).east(), logs, box, config);
			placeRoot(world, rand, pos.east(3), logs, box, config);
			placeRoot(world, rand, pos.east(3).south(), logs, box, config);
			placeRoot(world, rand, pos.south(3), logs, box, config);
			placeRoot(world, rand, pos.south(3).east(), logs, box, config);
			return true;
		}
	}

	private void genLeafCircle(IWorldGenerationReader world, Random rand, BlockPos pos, int radius, Set<BlockPos> leaves, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		for (int j = 0; j <= 2; ++j) {
			this.func_227255_a_(world, rand, pos.up(j), radius + 1 - j, leaves, box, config);
		}
	}

	private boolean canPlaceRoot(IWorldGenerationReader world, BlockPos pos) {
		return !world.hasBlockState(pos, (s) -> s.isSolid());
	}
	
	private void placeRoot(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int h = 2 + rand.nextInt(3);
		BlockPos tempPos = pos.up(h);
		for (int i = 0; i < 10; i++) {
			BlockPos p = tempPos.down(i);
			if (canPlaceRoot(world, p))
				this.setLog(world, rand, p, logs, box, config);
			else
				break;
		}
	}
	
	public void genBranches(IWorldGenerationReader world, Direction d1, Direction d2, Random rand, BlockPos branchStart, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, HugeTreeFeatureConfig config) {
		BlockPos temp = branchStart;
		for(int length = 0; length <= 3 + rand.nextInt(4); length++) {
			temp = temp.offset(d1);
			if(rand.nextBoolean()) {
				this.setLog(world, rand, temp, logs, box, config);
				temp = temp.offset(d2);
			}
			
			if(rand.nextFloat() > 0.33)
				temp = temp.up();
			
			this.setLog(world, rand, temp, logs, box, config);
			if(rand.nextBoolean())
				this.setLog(world, rand, temp.down(), logs, box, config);
		}
		this.genLeafCircle(world, rand, temp, 2 + rand.nextInt(4), leaves, box, config);
	}
	
	@Override
	protected void func_227254_a_(IWorldGenerationReader world, Random rand, BlockPos pos, int height, Set<BlockPos> logs, MutableBoundingBox box, HugeTreeFeatureConfig config) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for (int i = 0; i < height - 1; ++i) {
			blockpos$mutable.setPos(pos).move(0, i, 0);
			if (canBeReplacedByLogs(world, blockpos$mutable)) {
				this.setLog(world, rand, blockpos$mutable, logs, box, config);
			}
			blockpos$mutable.setPos(pos).move(1, i, 0);
			if (canBeReplacedByLogs(world, blockpos$mutable)) {
				this.setLog(world, rand, blockpos$mutable, logs, box, config);
			}

			blockpos$mutable.setPos(pos).move(1, i, 1);
			if (canBeReplacedByLogs(world, blockpos$mutable)) {
				this.setLog(world, rand, blockpos$mutable, logs, box, config);
			}

			blockpos$mutable.setPos(pos).move(0, i, 1);
			if (canBeReplacedByLogs(world, blockpos$mutable)) {
				this.setLog(world, rand, blockpos$mutable, logs, box, config);
			}
		}
	}
}