package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraftforge.common.PlantType;

public class SandySproutsBlock extends PinkPetalsBlock {

  public SandySproutsBlock(Block.Properties props) {
    super(props);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  public PlantType getPlantType(BlockGetter world, BlockPos pos) {
    return PlantType.DESERT;
  }
}
