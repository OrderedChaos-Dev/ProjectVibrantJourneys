package com.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Material;

public class SeaOatsBlock extends DoublePlantBlock {

	public SeaOatsBlock() {
		super(Block.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS));
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			BlockState ground = world.getBlockState(pos.below());
			return ground.getMaterial() == Material.SAND || ground.getMaterial() == Material.DIRT || ground.getBlock() instanceof GrassBlock;
		} else {
			BlockState blockstate = world.getBlockState(pos.below());
			if (state.getBlock() != this)
				return false;
			return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
		}
	}
	
	@Override
	public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
		return false;
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XYZ;
	}
}