package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class CindercaneBlock extends Block implements IPlantable {
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	public static final int MAX_HEIGHT = 7;

	public CindercaneBlock(BlockBehaviour.Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
		if (!state.canSurvive(world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
		if (world.isEmptyBlock(pos.above())) {
			int i;
			for (i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
			}

			if (i < MAX_HEIGHT && rand.nextInt(4) == 0) {
				int j = state.getValue(AGE);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
					if (j == 15) {
						LevelUtils.setBlockAndUpdate(world, pos.above(), this.defaultBlockState());
						LevelUtils.setBlock(world, pos, state.setValue(AGE, Integer.valueOf(0)), 4);
					} else {
						LevelUtils.setBlock(world, pos, state.setValue(AGE, Integer.valueOf(j + 1)), 4);
					}
				}
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor world, BlockPos pos, BlockPos pos2) {
		if (!state.canSurvive(world, pos)) {
			world.scheduleTick(pos, this, 1);
		}

		return super.updateShape(state, direction, state2, world, pos, pos2);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState blockstate = world.getBlockState(pos.below());
		if (blockstate.getBlock() == this) {
			return true;
		} else {
			if (blockstate.is(Blocks.NETHERRACK) || blockstate.is(Blocks.CRIMSON_NYLIUM)
					|| blockstate.is(Blocks.WARPED_NYLIUM) || blockstate.is(Blocks.SOUL_SAND)
					|| blockstate.is(Blocks.SOUL_SOIL) || blockstate.is(Blocks.BASALT)
					|| blockstate.is(Blocks.BLACKSTONE)) {
				BlockPos blockpos = pos.below();

				for (Direction direction : Direction.Plane.HORIZONTAL) {
					BlockState blockstate1 = world.getBlockState(blockpos.relative(direction));
					FluidState fluidstate = world.getFluidState(blockpos.relative(direction));
					if (fluidstate.is(FluidTags.LAVA) || blockstate1.is(Blocks.MAGMA_BLOCK)) {
						return true;
					}
				}
			}

			return false;
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> container) {
		container.add(AGE);
	}

	@Override
	public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}

	@Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		return defaultBlockState();
	}
}
