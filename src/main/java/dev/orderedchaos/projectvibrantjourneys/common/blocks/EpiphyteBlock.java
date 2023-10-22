package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

public class EpiphyteBlock extends HorizontalDirectionalBlock {
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

  public EpiphyteBlock(Block.Properties props) {
    super(props);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
    if (!player.getAbilities().mayBuild) {
      return InteractionResult.PASS;
    } else {
      if (!player.isCreative())
        Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
      world.removeBlock(pos, false);
      return InteractionResult.SUCCESS;
    }
  }

  public boolean canAttachTo(BlockGetter world, BlockPos pos, Direction direction) {
    BlockState blockstate = world.getBlockState(pos);
    return blockstate.is(BlockTags.LOGS) && Block.isFaceFull(world.getBlockState(pos).getCollisionShape(world, pos), direction);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
    Direction direction = state.getValue(FACING);
    return canAttachTo(worldIn, pos.offset(direction.getOpposite().getNormal()), direction);
  }

  @SuppressWarnings("deprecation")
  @Override
  public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
    if (facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, currentPos)) {
      return Blocks.AIR.defaultBlockState();
    } else {
      return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    if (!context.replacingClickedOnBlock()) {
      BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().offset(context.getClickedFace().getOpposite().getNormal()));
      if (blockstate.getBlock() == this && blockstate.getValue(FACING) == context.getClickedFace()) {
        return null;
      }
    }

    BlockState blockstate1 = this.defaultBlockState();
    LevelReader LevelReader = context.getLevel();
    BlockPos blockpos = context.getClickedPos();

    for (Direction direction : context.getNearestLookingDirections()) {
      if (direction.getAxis().isHorizontal()) {
        blockstate1 = blockstate1.setValue(FACING, direction.getOpposite());
        if (blockstate1.canSurvive(LevelReader, blockpos)) {
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
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }
}
