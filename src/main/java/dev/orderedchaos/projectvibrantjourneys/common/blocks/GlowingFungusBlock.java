package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

public class GlowingFungusBlock extends EpiphyteBlock {
  protected static final VoxelShape EAST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
  protected static final VoxelShape WEST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
  protected static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

  public GlowingFungusBlock(BlockBehaviour.Properties props) {
    super(props);
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return switch ((Direction) state.getValue(FACING)) {
      case NORTH -> NORTH;
      case SOUTH -> SOUTH;
      case WEST -> WEST;
      default -> EAST;
    };
  }

  @Override
  public boolean canAttachTo(BlockGetter world, BlockPos pos, Direction direction) {
    BlockState blockstate = world.getBlockState(pos);
    return (blockstate.is(BlockTags.STONE_ORE_REPLACEABLES) || blockstate.is(Tags.Blocks.STONE)) && Block.isFaceFull(world.getBlockState(pos).getCollisionShape(world, pos), direction);
  }
}