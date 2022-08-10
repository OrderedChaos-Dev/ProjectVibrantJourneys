package com.projectvibrantjourneys.world.gen.features;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.blocks.BarkMushroomBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class BarkSideFeature extends Feature<SimpleBlockConfiguration> {

	public BarkSideFeature(Codec<SimpleBlockConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());
		BlockState block = context.config().toPlace().getState(rand, blockpos);
		int count = 0;
		
		//must be a HorizontalDirectionalBlock
		//can't be bothered to write a feature configuration for it so putting a check here
		if(!(block.getBlock() instanceof HorizontalDirectionalBlock)) {
			return false;
		}

		for (int i = 64; i < pos.getY() + 50; i++) {
			blockpos.set(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (BarkMushroomBlock.canAttachTo(world, blockpos, Direction.DOWN)) {
				boolean flag = false;
				while(!flag) {
					Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
					if (world.isEmptyBlock(blockpos.offset(dir.getNormal())) && world.getBlockState(blockpos).isCollisionShapeFullBlock(world, pos))
						if(world.setBlock(blockpos.offset(dir.getNormal()), block.setValue(HorizontalDirectionalBlock.FACING, dir), 2)) {
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
