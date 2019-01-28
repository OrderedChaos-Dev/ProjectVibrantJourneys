package vibrantjourneys.integration.biomesoplenty;

import net.minecraft.block.Block;
import vibrantjourneys.init.PVJCrafting;

public class BOPCrafting
{
	public static void initCrafting()
	{
		for(Block block : PVJBlocksBOP.TWIGS_BOP)
		{
			PVJCrafting.fuelHandler.addFuel(block, 100);
		}
		for(Block block : PVJBlocksBOP.FALLENLEAVES_BOP)
		{
			PVJCrafting.fuelHandler.addFuel(block, 100);
		}
	}
}
