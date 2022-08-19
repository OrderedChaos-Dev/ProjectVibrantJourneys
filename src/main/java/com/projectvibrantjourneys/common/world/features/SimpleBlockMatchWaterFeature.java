package com.projectvibrantjourneys.common.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.material.Fluids;

public class SimpleBlockMatchWaterFeature extends Feature<SimpleBlockConfiguration> {
	
	public SimpleBlockMatchWaterFeature(Codec<SimpleBlockConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		SimpleBlockConfiguration config = context.config();
		WorldGenLevel level = context.level();
		BlockPos pos = context.origin();
		BlockState state = config.toPlace().getState(context.random(), pos);
		if (state.canSurvive(level, pos)) {
			if (state.getBlock() instanceof DoublePlantBlock) {
				if (!level.isEmptyBlock(pos.above())) {
					return false;
				}

				DoublePlantBlock.placeAt(level, state, pos, 2);
			} else {
				if(state.getBlock() instanceof SimpleWaterloggedBlock) {
					if(level.isFluidAtPosition(pos, (fluidstate) -> fluidstate.getType() == Fluids.WATER)) {
						level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, true), 2);
					} else {
						level.setBlock(pos, state, 2);
					}
				} else {
					level.setBlock(pos, state, 2);
				}
			}

			return true;
		} else {
			return false;
		}
	}
	}