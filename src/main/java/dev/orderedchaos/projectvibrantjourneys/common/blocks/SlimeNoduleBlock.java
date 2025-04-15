package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SlimeNoduleBlock extends EpiphyteBlock {

  protected static final VoxelShape EAST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
  protected static final VoxelShape WEST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
  protected static final VoxelShape NORTH = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);


  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

  public SlimeNoduleBlock(Properties props) {
    super(props);
  }

  @Override
  public boolean canAttachTo(BlockGetter world, BlockPos pos, Direction direction) {
    return Block.isFaceFull(world.getBlockState(pos).getCollisionShape(world, pos), direction);
  }

  @Override
  public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
    return InteractionResult.FAIL;
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
    return switch (state.getValue(FACING)) {
      case NORTH -> NORTH;
      case SOUTH -> SOUTH;
      case WEST -> WEST;
      default -> EAST;
    };
  }
}