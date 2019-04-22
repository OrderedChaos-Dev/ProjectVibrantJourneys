package vibrantjourneys.integration.sereneseasons;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sereneseasons.api.season.ISeasonState;
import sereneseasons.api.season.SeasonHelper;
import sereneseasons.season.SeasonASMHelper;

public class PVJSereneSeasons
{
	public static ISeasonState getSeasonState(World world)
	{
		ISeasonState state = SeasonHelper.getSeasonState(world);
		return state;
	}
	
	public static boolean canSnowHere(World world, BlockPos pos)
	{
		//hmm
		//return WorldHooks.canSnowAtInSeason(world, pos, false, getSeasonState(world));
		
		return SeasonASMHelper.canSnowAtInSeason(world, pos, false, getSeasonState(world));
	}
}
