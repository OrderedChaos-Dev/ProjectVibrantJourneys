package projectvibrantjourneys.common.world.features.trees;

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
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import projectvibrantjourneys.init.PVJBlocks;

public class JuniperTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

	public JuniperTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, TreeFeatureConfig config) {
		int height = config.baseHeight + rand.nextInt(config.heightRandA);
		Optional<BlockPos> optional = this.func_227212_a_(world, height, 3, 3, pos, config);
		if (!optional.isPresent()) {
			return false;
		} else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(world, blockpos.down(), blockpos);
			
			BlockPos placement = blockpos;
			Direction direction = Direction.Plane.HORIZONTAL.random(rand);
			
			for(int i = 0; i < height; i++) {
				this.setLog(world, rand, placement, logs, box, config);
				
				if(i > height / 2) {
					for(Direction d : Direction.values()) {
						if(rand.nextFloat() <= 0.15)
							this.placeBerries(world, placement.offset(d), leaves, box);
						else
							this.setLeaf(world, rand, placement.offset(d), leaves, box, config);
					}
				}
				
				if(rand.nextBoolean()) {
					placement = placement.offset(direction);
					this.setLog(world, rand, placement, logs, box, config);
					if(i > height / 3) {
						for (Direction d : Direction.values()) {
							this.setLeaf(world, rand, placement.offset(d), leaves, box, config);
						}
					}
				}
				
				if(rand.nextBoolean()) {
					direction = Direction.Plane.HORIZONTAL.random(rand);
				}
				
				placement = placement.up();
			}
			
			return true;
		}
	}
	
	private boolean placeBerries(IWorldGenerationReader world, BlockPos pos, Set<BlockPos> leaves, MutableBoundingBox box) {
		if (!isAirOrLeaves(world, pos) && !isTallPlants(world, pos) && !isWater(world, pos)) {
			return false;
		} else {
			this.setBlockState(world, pos, PVJBlocks.berried_juniper_leaves.getDefaultState(), box);
			leaves.add(pos.toImmutable());
			return true;
		}
	}
}
