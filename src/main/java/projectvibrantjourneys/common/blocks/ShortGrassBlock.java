package projectvibrantjourneys.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ShortGrassBlock extends BushBlock implements IGrowable{
	
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 6);
	
	public ShortGrassBlock() {
		super(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0, 0).sound(SoundType.PLANT));
		this.setDefaultState(getDefaultState().with(MODEL, 0));
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if(!world.isRemote) {
			int model = world.getRandom().nextInt(7);
			world.setBlockState(pos, this.getDefaultState().with(MODEL, model));
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int model = context.getWorld().getRandom().nextInt(7);
		return this.getDefaultState().with(MODEL, model);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
		DoublePlantBlock doubleplantblock = (DoublePlantBlock) Blocks.TALL_GRASS;
		if (doubleplantblock.getDefaultState().isValidPosition(world, pos)
				&& world.isAirBlock(pos.up())) {
			doubleplantblock.placeAt(world, pos, 2);
		}

	}
	
	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MODEL);
	}
}
