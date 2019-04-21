package vibrantjourneys;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJCrafting;
import vibrantjourneys.init.PVJEntities;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.init.PVJRegistryEvents;
import vibrantjourneys.init.PVJTileEntities;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.PVJEvents;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.PVJTerrainGenEvents;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = "{@pvjVersion}", dependencies="after:biomesoplenty;after:traverse")
public class ProjectVibrantJourneys
{   
    @Instance(Reference.MOD_ID)
    public static ProjectVibrantJourneys instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static ICommonProxy proxy;

    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	logger = event.getModLog();
    	
    	//BoP support :)
    	if(Loader.isModLoaded("biomesoplenty"))
    	{
    		logger.info("Project: Vibrant Journeys detected that you also have Biomes O' Plenty installed! Enjoy your adventures!");
    		Reference.isBOPLoaded = true;
    	}
    	//Traverse support :)
    	if(Loader.isModLoaded("traverse"))
    	{
    		logger.info("Project: Vibrant Journeys detected that you also have Traverse installed! Safe travels!");
    		Reference.isTraverseLoaded = true;
    	}
    	//Serene Seasons support :)
    	if(Loader.isModLoaded("sereneseasons"))
    	{
    		logger.info("Project: Vibrant Journeys detected that you also have Serene Seasons installed! Good choice!");
    		Reference.isSereneSeasonsLoaded = true;
    	}
    	
    	PVJEntities.initEntities();
    	PVJBlocks.initBlocks();
    	PVJItems.initItems();
    	PVJBiomes.initBiomes();
    	PVJTileEntities.initTileEntities();
    	
    	// Items, blocks, entities, and item/block models are registered here
    	MinecraftForge.EVENT_BUS.register(new PVJRegistryEvents());
    	MinecraftForge.EVENT_BUS.register(new PVJConfig.ConfigEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.registerTESRs();
    	
    	PVJCrafting.initCrafting();
    	
    	BiomeReference.loadAllBiomeReferences();
    	PVJWorldGen.initWorldGen();
    	
    	PVJEntities.addSpawns();
    	
    	if(PVJConfig.misc.restrictSquidsToOceans)
    		EntityRegistry.removeSpawn(EntitySquid.class, EnumCreatureType.WATER_CREATURE, BiomeReference.getBiomes(BiomeReference.FRESHWATER_BIOMES));
    	
		ProjectVibrantJourneys.proxy.registerBlockColors();
		
		MinecraftForge.EVENT_BUS.register(new PVJEvents());
		MinecraftForge.TERRAIN_GEN_BUS.register(new PVJTerrainGenEvents());
    	
    }
}
