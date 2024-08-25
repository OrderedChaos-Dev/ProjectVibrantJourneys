package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class NetherPlantBlock extends BushBlock implements BonemealableBlock {

  @Override
  protected MapCodec<? extends BushBlock> codec() {
    return simpleCodec(NetherPlantBlock::new);
  }

  public NetherPlantBlock(BlockBehaviour.Properties props) {
    super(props);
  }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
    return state.is(BlockTags.NYLIUM) || state.is(Blocks.SOUL_SOIL) || super.mayPlaceOn(state, worldIn, pos);
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