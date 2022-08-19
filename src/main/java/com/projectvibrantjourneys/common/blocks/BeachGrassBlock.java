package com.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class BeachGrassBlock extends BushBlock {
	
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public BeachGrassBlock() {
		super(Properties.of(Material.PLANT).color(MaterialColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS));
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XYZ;
	}
	
	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.DESERT;
	}
}
