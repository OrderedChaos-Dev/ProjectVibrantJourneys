package com.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HollowLogBlock extends RotatedPillarBlock {
	
	protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	protected static final VoxelShape TOP = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape LEFT_X = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape RIGHT_X =  Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	protected static final VoxelShape LEFT_Z = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
	protected static final VoxelShape RIGHT_Z = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SHAPE_X = Shapes.or(BOTTOM, TOP, LEFT_X, RIGHT_X);
	protected static final VoxelShape SHAPE_Z = Shapes.or(BOTTOM, TOP, LEFT_Z, RIGHT_Z);
	protected static final VoxelShape SHAPE_Y = Shapes.or(LEFT_X, RIGHT_X, LEFT_Z, RIGHT_Z);
	
	public HollowLogBlock(BlockBehaviour.Properties props) {
		super(props);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		switch(state.getValue(BlockStateProperties.AXIS)) {
			case X:
			default:
				return SHAPE_X;
			case Z:
				return SHAPE_Z;
			case Y:
				return SHAPE_Y;
		}
	}
}
