package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.common.tags.PVJTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HollowLogBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  public static final BooleanProperty MOSSY = BooleanProperty.create("mossy");
  protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
  protected static final VoxelShape TOP = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape LEFT_X = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape RIGHT_X = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
  protected static final VoxelShape LEFT_Z = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
  protected static final VoxelShape RIGHT_Z = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape SHAPE_X = Shapes.or(BOTTOM, TOP, LEFT_X, RIGHT_X);
  protected static final VoxelShape SHAPE_Z = Shapes.or(BOTTOM, TOP, LEFT_Z, RIGHT_Z);
  protected static final VoxelShape SHAPE_Y = Shapes.or(LEFT_X, RIGHT_X, LEFT_Z, RIGHT_Z);

  public HollowLogBlock(BlockBehaviour.Properties props) {
    super(props);
    this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false).setValue(MOSSY, false));
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return switch (state.getValue(BlockStateProperties.AXIS)) {
      default -> SHAPE_X;
      case Z -> SHAPE_Z;
      case Y -> SHAPE_Y;
    };
  }

  @Override
  public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
    if (state.getValue(WATERLOGGED)) {
      level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
    }

    return state;
  }

  @Override
  public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
    if (state.getValue(AXIS) == Direction.Axis.Y && facing == Direction.UP) {
      return false;
    }

    BlockState plant = plantable.getPlant(world, pos.relative(facing));
    if (plant.is(PVJTags.GROWS_ON_HOLLOW_LOG)) {
      return true;
    }

    return super.canSustainPlant(state, world, pos, facing, plantable);
  }

  @Override
  public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
    if (state.getValue(AXIS) == Direction.Axis.Y) {
      return InteractionResult.PASS;
    } else if (player.getItemInHand(hand).is(Items.MOSS_CARPET) && player.mayBuild()) {
      if (!state.getValue(MOSSY)) {
        level.setBlock(pos, state.setValue(MOSSY, true), 2);
        if (!player.isCreative()) {
          player.getItemInHand(hand).shrink(1);
        }
        return InteractionResult.SUCCESS;
      }
    }

    return InteractionResult.PASS;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(AXIS, WATERLOGGED, MOSSY);
  }

  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }
}
