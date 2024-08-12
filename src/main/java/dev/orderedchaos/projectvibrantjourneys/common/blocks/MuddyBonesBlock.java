package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;

public class MuddyBonesBlock extends MudBlock  {

  public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 2);
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

  public MuddyBonesBlock(Properties props) {
    super(props);
    this.registerDefaultState(this.stateDefinition.any().setValue(MODEL, 0).setValue(FACING, Direction.NORTH));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    int model = context.getLevel().getRandom().nextInt(3);
    Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(context.getLevel().getRandom());
    return this.defaultBlockState()
      .setValue(MODEL, model)
      .setValue(FACING, facing);
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(MODEL, FACING);
  }
}
