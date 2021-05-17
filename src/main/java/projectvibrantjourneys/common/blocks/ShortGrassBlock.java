package projectvibrantjourneys.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ShortGrassBlock extends BushBlock {

	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 6);
	
	public ShortGrassBlock() {
		super(Block.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS));
		this.registerDefaultState(this.defaultBlockState().setValue(MODEL, 0));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int model = context.getLevel().getRandom().nextInt(7);
		return this.defaultBlockState().setValue(MODEL, model);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XYZ;
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MODEL);
	}
}
