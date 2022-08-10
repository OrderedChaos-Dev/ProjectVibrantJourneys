package com.projectvibrantjourneys.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GroundcoverBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 4);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	
	public GroundcoverBlock() {
		super(Block.Properties.of(Material.DIRT).strength(0.05F, 0.0F).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(MODEL, 0).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}
	
	public GroundcoverBlock(Material material, SoundType soundType) {
		super(Block.Properties.of(material).strength(0.1F, 0.0F).sound(soundType).noOcclusion());
		this.registerDefaultState(defaultBlockState().setValue(MODEL, 0).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		int model = context.getLevel().getRandom().nextInt(5);
		Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(context.getLevel().getRandom());
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState()
				.setValue(MODEL, model)
				.setValue(FACING, facing)
				.setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return state;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return Block.canSupportRigidBlock(world, pos.below());
	}
	
	@Override
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos)) {
			world.destroyBlock(pos, false);
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
		world.removeBlock(pos, true);
		if(!player.isCreative() && player.mayBuild()) {
			Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
		return InteractionResult.SUCCESS;
	}
	
	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XZ;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(MODEL, FACING, WATERLOGGED);
	}
}
