package vibrantjourneys.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPVJPlant extends BlockBush
{
	public BlockPVJPlant()
	{
		super(Material.PLANTS);
		this.setHardness(0.0F);
		this.setSoundType(SoundType.PLANT);
	}
}
