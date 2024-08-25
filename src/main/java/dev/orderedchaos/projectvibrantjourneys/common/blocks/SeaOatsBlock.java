package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class SeaOatsBlock extends DoublePlantBlock implements BonemealableBlock {

  public SeaOatsBlock(BlockBehaviour.Properties props) {
    super(props);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      BlockState ground = world.getBlockState(pos.below());

      if (!ground.isFaceSturdy(world, pos.below(), Direction.UP))
        return false;
      return ground.is(BlockTags.SAND) || ground.is(BlockTags.DIRT);
    } else {
      BlockState blockstate = world.getBlockState(pos.below());
      if (state.getBlock() != this)
        return false;
      return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
    }
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
    return true;
  }

  @Override
  public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
    return true;
  }

  @Override
  public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
    popResource(pLevel, pPos, new ItemStack(this));
  }
}