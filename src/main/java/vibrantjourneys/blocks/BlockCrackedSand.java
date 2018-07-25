package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCrackedSand extends Block
{
	public BlockCrackedSand()
	{
		super(Material.ROCK);
		this.setHardness(0.85F);
		this.setSoundType(SoundType.STONE);
	}
}
