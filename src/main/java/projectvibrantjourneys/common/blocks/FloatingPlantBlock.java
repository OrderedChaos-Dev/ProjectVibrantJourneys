package projectvibrantjourneys.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

public class FloatingPlantBlock extends LilyPadBlock {
	private static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);
	
	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 3);
	
	public FloatingPlantBlock() {
		super(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0, 0).sound(SoundType.PLANT).notSolid().doesNotBlockMovement());
	}
	
	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.Water;
    }
	
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MODEL);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int model = context.getWorld().getRandom().nextInt(5);
		return this.getDefaultState().with(MODEL, model);
	}
}
