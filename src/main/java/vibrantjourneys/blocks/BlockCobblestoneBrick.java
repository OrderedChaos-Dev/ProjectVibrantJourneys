package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockCobblestoneBrick extends Block
{
	public BlockCobblestoneBrick()
	{
		super(Material.ROCK, MapColor.GRAY);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}
}
