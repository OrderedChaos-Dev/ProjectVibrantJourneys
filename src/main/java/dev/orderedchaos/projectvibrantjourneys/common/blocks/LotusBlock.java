package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LotusBlock extends WaterlilyBlock {

  protected static final VoxelShape AABB = Block.box(4.0, 1.0, 4.0, 12.0, 10, 12.0);

  public LotusBlock(Properties props) {
    super(props);
  }

  @Override
  public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
    return AABB;
  }

  @Override
  public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {}
}