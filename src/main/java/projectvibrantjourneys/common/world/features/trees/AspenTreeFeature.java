package projectvibrantjourneys.common.world.features.trees;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class AspenTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public AspenTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean func_225557_a_(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = config.baseHeight + rand.nextInt(config.heightRandA);
		Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			this.func_227213_a_(world, rand, height, blockpos, 0, logs, box, config);
			
			int trunkHeight = config.trunkHeight + rand.nextInt(config.trunkHeightRandom);

			for(int i = trunkHeight; i < height - 2; i += 2) {
				for(Direction d : Direction.values()) {
					if(d.getAxis().isHorizontal()) {
						int length = 1 + (height / i);
						BlockPos branchPos = pos.up(i);
						for(int j = 1; j <= length; j++) {
							this.func_227217_a_(world, branchPos.offset(d, j), config.trunkProvider.getBlockState(rand, pos).with(LogBlock.AXIS, d.getAxis()), box);
							placeLeaves(world, rand, branchPos.offset(d, j), leaves, box, config);
						}
					}
				}
			}
			
			for(int i = trunkHeight; i <= height; i++)
				placeLeaves(world, rand, pos.up(i), leaves, box, config);
			
			return true;
		}
	}
	
	public void placeLeaves(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		for(int x = -1; x <= 1; x++)
			for(int y = -1; y <= 1; y++)
				for(int z = -1; z <= 1; z++)
					if(Math.abs(x) != Math.abs(z) || rand.nextBoolean())
						this.func_227219_b_(world, rand, pos.add(x, y, z), leaves, box, config);
	}
}
