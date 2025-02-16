package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

public class HollowLogBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  public static final BooleanProperty MOSSY = BooleanProperty.create("mossy");
  protected static final VoxelShape BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
  protected static final VoxelShape TOP = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape LEFT_X = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape RIGHT_X = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
  protected static final VoxelShape LEFT_Z = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
  protected static final VoxelShape RIGHT_Z = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
  protected static final VoxelShape SHAPE_X = Shapes.or(BOTTOM, TOP, LEFT_X, RIGHT_X);
  protected static final VoxelShape SHAPE_Z = Shapes.or(BOTTOM, TOP, LEFT_Z, RIGHT_Z);
  protected static final VoxelShape SHAPE_Y = Shapes.or(LEFT_X, RIGHT_X, LEFT_Z, RIGHT_Z);

  public HollowLogBlock(BlockBehaviour.Properties props) {
    super(props);
    this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false).setValue(MOSSY, false));
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return switch (state.getValue(BlockStateProperties.AXIS)) {
      default -> SHAPE_X;
      case Z -> SHAPE_Z;
      case Y -> SHAPE_Y;
    };
  }

  @Override
  public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
    if (state.getValue(WATERLOGGED)) {
      level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
    }

    return state;
  }

  @Override
  public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, BlockState plantable) {
    if (state.getValue(AXIS) == Direction.Axis.Y && facing == Direction.UP) {
      return TriState.FALSE;
    }

    if (plantable.is(PVJTags.GROWS_ON_HOLLOW_LOG)) {
      return TriState.TRUE;
    }

    return super.canSustainPlant(state, world, pos, facing, plantable);
  }

  @Override
  public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
    if (state.getValue(AXIS) == Direction.Axis.Y) {
      return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    } else if (stack.is(Items.MOSS_CARPET) && player.mayBuild()) {
      if (!state.getValue(MOSSY)) {
        level.setBlock(pos, state.setValue(MOSSY, true), 2);
        if (!player.isCreative()) {
          stack.consumeAndReturn(1, player);
        }
        level.playSound(player, pos, SoundEvents.MOSS_CARPET_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        return ItemInteractionResult.SUCCESS;
      }
    } else if (state.getValue(MOSSY) && stack.is(PVJTags.HARVESTS_MOSSY_HOLLOW_LOGS)) {
      if (player instanceof ServerPlayer) {
        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, pos, stack);
      }
      stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
      level.setBlock(pos, state.setValue(MOSSY, false), 2);
      level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
      Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.MOSS_CARPET));
      return ItemInteractionResult.SUCCESS;
    }

    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(AXIS, WATERLOGGED, MOSSY);
  }

  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }
}
