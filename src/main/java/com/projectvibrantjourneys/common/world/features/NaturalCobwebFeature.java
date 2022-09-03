package com.projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

public class NaturalCobwebFeature extends Feature<ProbabilityFeatureConfiguration> {
	public NaturalCobwebFeature(Codec<ProbabilityFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		RandomSource rand = context.random();
		BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());

		for (int i = 64; i < pos.getY() + 50; i++) {
			blockpos.set(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (world.getBlockState(blockpos).getBlock() instanceof LeavesBlock) {
				if(world.isEmptyBlock(blockpos.below())) {
					if(rand.nextFloat() < context.config().probability) {
						world.setBlock(blockpos.below(), PVJBlocks.NATURAL_COBWEB.get().defaultBlockState(), 2);
						break;
					}
				}
			}
		}
		return true;
	}
}