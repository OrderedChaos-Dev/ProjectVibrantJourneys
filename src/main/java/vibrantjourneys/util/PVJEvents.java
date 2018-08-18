package vibrantjourneys.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PVJEvents
{
	@SubscribeEvent
	public void onBreakGrass(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.getState().getBlock();
		if(!PVJConfig.doGrassDropSeeds)
		{
			if(block instanceof BlockTallGrass)
			{
				boolean flag = false;
				for(ItemStack item : event.getDrops())
				{
					if(item.getItem() == Items.WHEAT_SEEDS)
					{
						flag = true;
					}
				}
				if(flag)
				{
					event.getDrops().clear();
				}
			}
		}
	}
}
