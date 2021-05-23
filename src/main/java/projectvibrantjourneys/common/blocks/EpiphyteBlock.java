package projectvibrantjourneys.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class EpiphyteBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.FACING;
	
	public EpiphyteBlock(Block.Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		if (!player.abilities.mayBuild) {
			return ActionResultType.PASS;
		} else {
			if(!player.isCreative())
				Block.dropResources(state, world, pos);
			world.removeBlock(pos, false);
			return ActionResultType.SUCCESS;
		}
	}
	
	public static boolean canAttachTo(IBlockReader world, BlockPos pos, Direction direction) {
		BlockState blockstate = world.getBlockState(pos);
		return blockstate.getBlock().getTags().contains(ItemTags.LOGS.getName()) && world.getBlockState(pos).isCollisionShapeFullBlock(world, pos);
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		return canAttachTo(worldIn, pos.offset(direction.getOpposite().getNormal()), direction);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, currentPos)) {
			return Blocks.AIR.defaultBlockState();
		} else {
			return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
		}
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (!context.replacingClickedOnBlock()) {
			BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().offset(context.getClickedFace().getOpposite().getNormal()));
			if (blockstate.getBlock() == this && blockstate.getValue(FACING) == context.getClickedFace()) {
				return null;
			}
		}

		BlockState blockstate1 = this.defaultBlockState();
		IWorldReader iworldreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();

		for (Direction direction : context.getNearestLookingDirections()) {
			if (direction.getAxis().isHorizontal()) {
				blockstate1 = blockstate1.setValue(FACING, direction.getOpposite());
				if (blockstate1.canSurvive(iworldreader, blockpos)) {
					return blockstate1;
				}
			}
		}

		return null;
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
