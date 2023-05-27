package com.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.common.blocks.BarkMushroomBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BarkMushroomFeature extends Feature<NoneFeatureConfiguration> {

	public BarkMushroomFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		RandomSource rand = context.random();
		BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());
		BarkMushroomBlock block = BarkMushroomBlock.getRandom(rand);
		int count = 0;

		for (int i = 64; i < pos.getY() + 50; i++) {
			blockpos.set(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (block.canAttachTo(world, blockpos, Direction.DOWN)) {
				boolean flag = false;
				while(!flag) {
					Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
					if (world.isEmptyBlock(blockpos.offset(dir.getNormal())) && world.getBlockState(blockpos).isCollisionShapeFullBlock(world, pos))
						if(Utils.setBlock(world, blockpos.offset(dir.getNormal()), block.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, dir), 2)) {
							count++;
						}
					
					if(rand.nextFloat() < 0.8F) {
						flag = true;
					}
				}
			}
		}
		return count > 0;
	}

}
