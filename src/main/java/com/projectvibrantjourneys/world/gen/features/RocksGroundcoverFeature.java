package com.projectvibrantjourneys.world.gen.features;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.init.object.PVJBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

public class RocksGroundcoverFeature extends Feature<NoneFeatureConfiguration> {
	
	public RocksGroundcoverFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		Random random = context.random();
		BlockPos pos = context.origin();
		WorldGenLevel level = context.level();
		Block ground = level.getBlockState(pos.below()).getBlock();
		BlockState state = PVJBlocks.rocks.get().defaultBlockState();
		if(ground == Blocks.RED_SAND || ground == Blocks.RED_SANDSTONE) {
			state = PVJBlocks.red_sandstone_rocks.get().defaultBlockState();
		} else if(ground == Blocks.SAND || ground == Blocks.SANDSTONE) {
			state = PVJBlocks.sandstone_rocks.get().defaultBlockState();
		} else if(random.nextFloat() < 0.2F) {
			state = PVJBlocks.mossy_rocks.get().defaultBlockState();
		}
		
		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
		int model = random.nextInt(5);
		
		if (state.canSurvive(level, pos)) {
			if(level.isFluidAtPosition(pos, (fluidstate) -> fluidstate.getType() == Fluids.WATER)) {
				level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, true).setValue(GroundcoverBlock.FACING, dir).setValue(GroundcoverBlock.MODEL, model), 2);
			} else {
				level.setBlock(pos, state.setValue(GroundcoverBlock.FACING, dir).setValue(GroundcoverBlock.MODEL, model), 2);
			}
			return true;
		}
		
		return false;
	}
}