package dev.orderedchaos.projectvibrantjourneys.common.world.features.stateproviders;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class DirectionalStateProvider extends BlockStateProvider {
  public static final Codec<DirectionalStateProvider> CODEC = BlockState.CODEC.fieldOf("state").xmap(BlockBehaviour.BlockStateBase::getBlock, Block::defaultBlockState).xmap(DirectionalStateProvider::new, (p_68793_) -> {
    return p_68793_.block;
  }).codec();
  private final Block block;

  public DirectionalStateProvider(Block block) {
    this.block = block;
  }

  protected BlockStateProviderType<?> type() {
    return PVJFeatures.StateProviders.DIRECTIONAL_STATE_PROVIDER.get();
  }

  public BlockState getState(RandomSource random, BlockPos pos) {
    Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
    return this.block.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, dir);
  }
}