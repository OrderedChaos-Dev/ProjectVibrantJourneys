package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class BushFeature extends Feature<ProbabilityFeatureConfiguration> {
	
	public BushFeature(Codec<ProbabilityFeatureConfiguration> config) {
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		//check dirt/grass
		Block dirt = world.getBlockState(pos.below()).getBlock();
		if(dirt != Blocks.DIRT && dirt != Blocks.GRASS_BLOCK)
			return false;
		
		//check space
		for(Direction dir : Direction.Plane.HORIZONTAL) {
			BlockPos offsetPos = pos.offset(dir.getNormal());
			Block block = world.getBlockState(offsetPos).getBlock();
			if(block != Blocks.AIR && block != Blocks.TALL_GRASS) {
				return false;
			}
		}
		if (rand.nextFloat() < context.config().probability) {
			for(Direction dir : Direction.Plane.HORIZONTAL) {
				BlockPos offsetPos = pos.offset(dir.getNormal());
				if(world.getBlockState(offsetPos).getMaterial().isReplaceable());
					world.setBlock(offsetPos, Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
			}
			if(world.getBlockState(pos.above()).getMaterial().isReplaceable());
				world.setBlock(pos.above(), Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
			world.setBlock(pos, Blocks.OAK_LOG.defaultBlockState(), 2);
		}

		return true;
	}
}
