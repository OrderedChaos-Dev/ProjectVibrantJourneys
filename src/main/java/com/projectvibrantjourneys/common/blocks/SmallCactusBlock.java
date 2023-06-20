package com.projectvibrantjourneys.common.blocks;

import com.projectvibrantjourneys.common.world.features.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class SmallCactusBlock extends BushBlock implements BonemealableBlock {
	
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public SmallCactusBlock() {
		super(Properties.of(Material.PLANT).color(MaterialColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS).offsetType(OffsetType.XZ));
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.DESERT;
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClientSide) {
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockState blockstate = level.getBlockState(pos.relative(direction));
			Material material = blockstate.getMaterial();
			if (material.isSolid() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		Utils.setBlock(level, pos, Blocks.CACTUS.defaultBlockState(), 2);
	}
}
