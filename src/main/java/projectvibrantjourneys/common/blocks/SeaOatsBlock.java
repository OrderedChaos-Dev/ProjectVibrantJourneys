package projectvibrantjourneys.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class SeaOatsBlock extends DoublePlantBlock {

	public SeaOatsBlock() {
		super(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0, 0).sound(SoundType.PLANT));
		
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		if (state.get(HALF) != DoubleBlockHalf.UPPER) {
			Block ground = world.getBlockState(pos.down()).getBlock();
			return (ground == Blocks.DIRT || ground == Blocks.GRASS_BLOCK || ground == Blocks.SAND);
		} else {
			BlockState blockstate = world.getBlockState(pos.down());
			if (state.getBlock() != this)
				return false;
			return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
		}
	}
	
	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		return false;
	}
}
