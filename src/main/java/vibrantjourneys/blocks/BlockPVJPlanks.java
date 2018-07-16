package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPVJBlock;

public class BlockPVJPlanks extends Block implements IPVJBlock
{
	private EnumWoodType woodType;
	
	public BlockPVJPlanks(EnumWoodType woodType)
	{
		super(Material.WOOD);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
		this.woodType = woodType;
	}
	@Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return woodType.getMapColor();
    }
	
	@Override
	public Class<? extends ItemBlock> getItem()
	{
		return ItemPVJBlock.class;
	}

	@Override
	public ImmutableList<IBlockState> getVariants()
	{
		return this.blockState.getValidStates();
	}
	
	@Override
	public String getStateName(IBlockState state)
	{
		return woodType.getName();
	}
}
