package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.util.IPropertyHelper;

public class BlockPVJFenceGate extends BlockFenceGate implements IPropertyHelper
{
	public BlockPVJFenceGate()
	{
		/*
		 * BlockFenceGate uses BlockPlanks.EnumType for map color, I use OAK for the sake of invoking its constructor
		 * see getMapColor() method below
		 */
		super(BlockPlanks.EnumType.OAK);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.WOOD;
    }
	
	@Override
	public ImmutableList<IBlockState> getProperties()
	{
		return this.blockState.getValidStates();
	}
}
