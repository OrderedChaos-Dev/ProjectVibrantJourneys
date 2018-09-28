package vibrantjourneys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockStoneBlock extends Block
{
	public BlockStoneBlock(float hardness, float resistance, MapColor mapColor)
	{
		super(Material.ROCK, mapColor);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(SoundType.STONE);
	}
}
