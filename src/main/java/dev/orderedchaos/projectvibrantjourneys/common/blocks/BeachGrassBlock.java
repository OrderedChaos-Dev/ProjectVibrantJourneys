package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

public class BeachGrassBlock extends BushBlock {

  @Override
  protected MapCodec<? extends BushBlock> codec() {
    return simpleCodec(BeachGrassBlock::new);
  }

  protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

  public BeachGrassBlock(Block.Properties props) {
    super(props);
  }

  @Override
  public VoxelShape getShape(BlockState blockstate, BlockGetter world, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
    BlockState ground = pLevel.getBlockState(pPos.below());
    TriState soilDecision = ground.canSustainPlant(pLevel, pPos.below(), Direction.UP, pState);
    if (!soilDecision.isDefault())
      return soilDecision.isTrue();
    return ground.is(BlockTags.SAND);
  }
}
