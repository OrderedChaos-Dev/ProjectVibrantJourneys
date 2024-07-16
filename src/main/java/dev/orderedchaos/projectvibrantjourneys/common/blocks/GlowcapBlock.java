package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.TriState;

public class GlowcapBlock extends MushroomBlock {

  public GlowcapBlock(BlockBehaviour.Properties props) {
    super(PVJConfiguredFeatures.HUGE_GLOWCAP, props);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
    BlockPos blockpos = pos.below();
    BlockState blockstate = worldIn.getBlockState(blockpos);
    if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
      return true;
    } else {
      TriState soilDecision = blockstate.canSustainPlant(worldIn, blockpos, Direction.UP, state);
      return soilDecision.isDefault() ? this.mayPlaceOn(blockstate, worldIn, blockpos) : soilDecision.isTrue();
    }
  }
}