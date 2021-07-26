package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import projectvibrantjourneys.init.object.PVJBlocks;

public class CobwebFeature extends Feature<ProbabilityFeatureConfiguration> {
	public CobwebFeature(Codec<ProbabilityFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());

		for (int i = 64; i < world.getHeight(); i++) {
			blockpos.set(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (world.getBlockState(blockpos).getBlock() instanceof LeavesBlock) {
				if(world.isEmptyBlock(blockpos.below())) {
					if(rand.nextFloat() < context.config().probability) {
						world.setBlock(blockpos.below(), PVJBlocks.natural_cobweb.defaultBlockState(), 2);
						break;
					}
				}
			}
		}
		return true;
	}
}