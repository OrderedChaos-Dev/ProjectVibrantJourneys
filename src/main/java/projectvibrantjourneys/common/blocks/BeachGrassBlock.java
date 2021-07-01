package projectvibrantjourneys.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.PlantType;

public class BeachGrassBlock extends BushBlock {

	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public BeachGrassBlock() {
		super(Block.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS));
	}
	
//	@Override
//	public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
//		BlockState ground = world.getBlockState(pos.below());
//		return ground.getMaterial() == Material.SAND || ground.getMaterial() == Material.DIRT || ground.getBlock() instanceof GrassBlock;
//	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public AbstractBlock.OffsetType getOffsetType() {
		return AbstractBlock.OffsetType.XYZ;
	}
	
	@Override
	public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.DESERT;
	}
}
