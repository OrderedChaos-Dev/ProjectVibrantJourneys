package projectvibrantjourneys.common.world.features.trees;

import java.util.Iterator;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class RedwoodTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public RedwoodTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = config.baseHeight + rand.nextInt(config.heightRandA);
		int j = config.trunkHeight >= 0 ? config.trunkHeight + rand.nextInt(config.trunkHeightRandom + 1): height - (config.foliageHeight + rand.nextInt(config.foliageHeightRandom + 1));
		int k = config.foliagePlacer.func_225573_a_(rand, j, height, config);
		Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			config.foliagePlacer.func_225571_a_(world, rand, config, height, j, k, blockpos, leaves);
			this.func_227213_a_(world, rand, height, blockpos, 0, logs, box, config);
			Iterator<Direction> it = Direction.Plane.HORIZONTAL.iterator();
			while(it.hasNext()) {
				placeRoot(world, rand, blockpos.offset(it.next()), logs, box, config);
			}
			return true;
		}
	}
	
	private boolean canPlaceRoot(IWorldGenerationReader world, BlockPos pos) {
		return !world.hasBlockState(pos, (s) -> s.isSolid());
	}
	
	private void placeRoot(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int h = 1 + rand.nextInt(3);
		BlockPos tempPos = pos.up(h);
		if (isAirOrLeaves(world, tempPos.up()) || isTallPlants(world, pos.up()) || isWater(world, tempPos.up())) {
			this.setBlockState(world, tempPos.up(), PVJBlocks.redwood_wood.getDefaultState(), box);
			logs.add(pos.toImmutable());
		}
		for (int i = 0; i < 10; i++) {
			BlockPos p = tempPos.down(i);
			if (canPlaceRoot(world, p))
				this.setLog(world, rand, p, logs, box, config);
			else
				break;
		}
	}
}
