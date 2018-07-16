package vibrantjourneys.init;

import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;

public class PVJWorldGen
{
	public static void initWorldGen()
	{
		registerWorldGen(new WorldGenPalmTreeBeach());
		registerWorldGen(new WorldGenCobweb());
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
