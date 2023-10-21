package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BarkMushroomBlock extends EpiphyteBlock {
	protected static final VoxelShape EAST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape WEST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

	public BarkMushroomBlock(Block.Properties props) {
		super(props);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			case NORTH -> NORTH;
			case SOUTH -> SOUTH;
			case WEST -> WEST;
			default -> EAST;
		};
	}

	public static BarkMushroomBlock getRandom(RandomSource rand) {
		float f = rand.nextFloat();
		if(f > 0.66F)
			return (BarkMushroomBlock) PVJBlocks.BARK_MUSHROOM.get();
		else if(f > 0.33F)
			return (BarkMushroomBlock) PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get();

		return (BarkMushroomBlock) PVJBlocks.ORANGE_BARK_MUSHROOM.get();
	}
}