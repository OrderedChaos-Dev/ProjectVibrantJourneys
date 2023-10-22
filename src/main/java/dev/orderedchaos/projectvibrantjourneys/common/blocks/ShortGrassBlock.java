package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShortGrassBlock extends BushBlock {

  protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
  public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 6);

  public ShortGrassBlock(BlockBehaviour.Properties props) {
    super(props);
    this.registerDefaultState(this.stateDefinition.any().setValue(MODEL, 0));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    int model = context.getLevel().getRandom().nextInt(7);
    return this.defaultBlockState().setValue(MODEL, model);
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(MODEL);
  }
}