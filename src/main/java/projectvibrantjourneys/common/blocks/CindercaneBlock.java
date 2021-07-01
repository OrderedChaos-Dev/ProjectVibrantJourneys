package projectvibrantjourneys.common.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class CindercaneBlock extends Block implements IPlantable {
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	public static final int MAX_HEIGHT = 7;

	public CindercaneBlock(AbstractBlock.Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		if (!state.canSurvive(world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		if (world.isEmptyBlock(pos.above())) {
			int i;
			for (i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
			}

			if (i < MAX_HEIGHT) {
				int j = state.getValue(AGE);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(pos.above(), this.defaultBlockState());
						world.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 4);
					} else {
						world.setBlock(pos, state.setValue(AGE, Integer.valueOf(j + 1)), 4);
					}
				}
			}
		}

	}

	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState state2, IWorld world, BlockPos pos, BlockPos pos2) {
		if (!state.canSurvive(world, pos)) {
			world.getBlockTicks().scheduleTick(pos, this, 1);
		}

		return super.updateShape(state, direction, state2, world, pos, pos2);
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState soil = world.getBlockState(pos.below());
		if (soil.canSustainPlant(world, pos.below(), Direction.UP, this))
			return true;
		BlockState blockstate = world.getBlockState(pos.below());
		if (blockstate.getBlock() == this) {
			return true;
		} else {
			if (blockstate.is(Blocks.NETHERRACK)) {
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
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> container) {
		container.add(AGE);
	}

	@Override
	public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.NETHER;
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		return defaultBlockState();
	}
}
