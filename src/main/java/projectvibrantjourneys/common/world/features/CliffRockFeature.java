package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class CliffRockFeature extends Feature<ProbabilityFeatureConfiguration> {
	
	private Block[] bottom = {Blocks.STONE, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.ANDESITE};
	private Block[] top = {Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL, Blocks.ANDESITE_WALL};
	
	public CliffRockFeature(Codec<ProbabilityFeatureConfiguration> config) {
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		if (rand.nextFloat() < context.config().probability) {
			if(world.getBlockState(pos).getMaterial().isReplaceable() && world.getBlockState(pos.above()).getMaterial().isReplaceable()) {
				world.setBlock(pos, bottom[rand.nextInt(bottom.length)].defaultBlockState(), 2);
				world.setBlock(pos.above(), top[rand.nextInt(top.length)].defaultBlockState(), 2);
				if(rand.nextBoolean() && world.getBlockState(pos.above(2)).getMaterial().isReplaceable()) {
					world.setBlock(pos.above(2), top[rand.nextInt(top.length)].defaultBlockState(), 2);
				}
				return true;
			}
		}
		
		return false;
	}
}
