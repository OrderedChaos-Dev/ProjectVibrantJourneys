package projectvibrantjourneys.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import projectvibrantjourneys.init.PVJTags;

import javax.annotation.Nullable;

public class CattailBlock extends DoublePlantBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CattailBlock() {
        super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0, 0)
                .sound(SoundType.PLANT));
        this.setDefaultState(
                this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER && state.get(WATERLOGGED)) {
            return false;
        }
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            BlockPos groundPos = pos.down();
            Block ground = world.getBlockState(groundPos).getBlock();

            if (world.getFluidState(pos).isTagged(FluidTags.WATER))
                return canGrow(ground);

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (world.getFluidState(groundPos.offset(direction)).isTagged(FluidTags.WATER)) {
                    return canGrow(ground);
                }
            }

            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos.down());
            if (state.getBlock() != this)
                return false;
            return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public boolean canGrow(Block ground) {
    	return ground.isIn(PVJTags.CATTAIL_GROWABLE);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos,
                                boolean isMoving) {
        if (!isValidPosition(state, world, pos)) {
            if (state.get(WATERLOGGED)) {
                world.setBlockState(pos, Blocks.WATER.getDefaultState());
            } else {
                world.destroyBlock(pos, false);
            }
        }
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            BlockState stateUpper = world.getBlockState(pos.up());
            if (stateUpper.getBlock() instanceof CattailBlock) {
                if (!isValidPosition(stateUpper, world, pos.up())) {
                    world.destroyBlock(pos.up(), false);
                }
            }
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
            if (blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
                if (blockstate.get(WATERLOGGED)) {
                    world.setBlockState(blockpos, Blocks.WATER.getDefaultState());
                } else {
                    world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
                }
            }

            world.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
            if (!world.isRemote && !player.isCreative()) {
                spawnDrops(state, world, pos, (TileEntity) null, player, player.getHeldItemMainhand());
                spawnDrops(blockstate, world, blockpos, (TileEntity) null, player, player.getHeldItemMainhand());
            }
        }
        world.playEvent(player, 2001, pos, Block.getStateId(state));
    }

    public void placeInWater(IWorld worldIn, BlockPos pos, int flags) {
        worldIn.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, true), flags);
        worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return false;
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world,
                                          BlockPos currentPos, BlockPos facingPos) {
        if (state.get(WATERLOGGED)) {
            world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());

        BlockState state = super.getStateForPlacement(context);
        if (state != null) {
            return state.with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        } else {
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED);
    }
}
