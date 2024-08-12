package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import com.mojang.serialization.MapCodec;
import dev.orderedchaos.projectvibrantjourneys.core.PVJConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Bogged;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BoggedRemainsBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
  protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  public BoggedRemainsBlock(Properties pProperties) {
    super(pProperties);
    this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
  }

  @Override
  protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
    return simpleCodec(BoggedRemainsBlock::new);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
    return Block.canSupportRigidBlock(world, pos.below());
  }

  @Override
  public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
    if (state.getValue(WATERLOGGED)) {
      world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
    }
    return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : state;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING, WATERLOGGED);
  }

  @Override
  protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
    return SHAPE;
  }

  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext pContext) {
    FluidState ifluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
    return this.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, pContext.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
  }

  @Override
  public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
    pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
    pPlayer.causeFoodExhaustion(0.005F);
    boolean shouldDropResources = false;
    if (PVJConfig.allowBoggedFromBoggedRemains.get()) {
      if (!pLevel.isClientSide()) {
        RandomSource randomSource = pLevel.getRandom();
        if (1.0D - randomSource.nextDouble() <= PVJConfig.boggedChance.get()) {
          Bogged bogged = EntityType.BOGGED.create(pLevel);
          if (bogged != null) {
            bogged.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            bogged.moveTo((double)pPos.getX() + 0.5, (double)pPos.getY(), (double)pPos.getZ() + 0.5);
            pLevel.addFreshEntity(bogged);
            bogged.spawnAnim();
          }
        } else {
          shouldDropResources = true;
        }
      }
    } else {
      shouldDropResources = true;
    }

    if (shouldDropResources) {
      dropResources(pState, pLevel, pPos, pBlockEntity, pPlayer, pTool);
    }
  }
}
