package vibrantjourneys.blocks;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.IPVJBlock;

public class BlockCobblestoneBrick extends Block implements IPVJBlock
{
	public BlockCobblestoneBrick()
	{
		super(Material.ROCK, MapColor.GRAY);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
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
		return "";
	}
}
