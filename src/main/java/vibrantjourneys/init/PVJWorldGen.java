package vibrantjourneys.init;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.worldgen.SwampEventHandler;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenWillowTreeSwamp;

public class PVJWorldGen
{
	public static void initWorldGen()
	{
		registerWorldGen(new WorldGenCobweb());
		registerWorldGen(new WorldGenPalmTreeBeach());
		registerWorldGen(new WorldGenWillowTreeSwamp());
		registerWorldGen(new WorldGenMangroveTreeSwamp());
		
		MinecraftForge.TERRAIN_GEN_BUS.register(new SwampEventHandler());
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		ProjectVibrantJourneys.proxy.registerWorldGenerator(worldgen);
	}
}
