package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import com.mojang.serialization.MapCodec;
import dev.orderedchaos.projectvibrantjourneys.common.blocks.properties.BeachedKelpShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BeachedKelpBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
  public static final EnumProperty<BeachedKelpShape> KELP_SHAPE = EnumProperty.create("shape", BeachedKelpShape.class);

  protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.0D, 15.0D);

  public BeachedKelpBlock(BlockBehaviour.Properties props) {
    super(props);
    this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(KELP_SHAPE, BeachedKelpShape.TOP));
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
    return Block.canSupportRigidBlock(world, pos.below());
  }

  @Override
  public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
    if (state.getValue(WATERLOGGED)) {
      world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
    }
    return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : state;
  }

  @Override
  public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
    return pState.getFluidState().isEmpty();
  }

  @Override
  public boolean isPathfindable(BlockState pState, BlockGetter level, BlockPos pos, PathComputationType pPathComputationType) {
    return pPathComputationType == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(pState, level, pos, pPathComputationType);
  }

  @Override
  public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return Shapes.empty();
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  @SuppressWarnings("deprecation")
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(KELP_SHAPE, FACING, WATERLOGGED);
  }
}