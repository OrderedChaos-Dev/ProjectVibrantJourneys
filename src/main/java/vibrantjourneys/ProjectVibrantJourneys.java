package vibrantjourneys;

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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vibrantjourneys.crafting.PVJOreDictionary;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJEntities;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.init.PVJRecipes;
import vibrantjourneys.init.PVJRegistryEvents;
import vibrantjourneys.init.PVJTileEntities;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.GuiHandler;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.PVJEvents;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.PVJTerrainGenEvents;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = "{@pvjVersion}", dependencies="after:biomesoplenty")
public class ProjectVibrantJourneys
{   
    @Instance(Reference.MOD_ID)
    public static ProjectVibrantJourneys instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static ICommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//BoP support :)
    	if(Loader.isModLoaded("biomesoplenty"))
    	{
    		System.out.println("Project: Vibrant Journeys has detected that you also have Biomes O' Plenty installed!");
    		Reference.isBOPLoaded = true;
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
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	
    	PVJOreDictionary.setValues();
    	PVJRecipes.initRecipes();
    	
    	BiomeReference.loadAllBiomeReferences();
    	PVJWorldGen.initWorldGen();
    	
    	PVJEntities.addSpawns();
    	
    	if(PVJConfig.misc.restrictSquidsToOceans)
    		EntityRegistry.removeSpawn(EntitySquid.class, EnumCreatureType.WATER_CREATURE, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES));
    	
		ProjectVibrantJourneys.proxy.registerBlockColors();
		
		MinecraftForge.EVENT_BUS.register(new PVJEvents());
		MinecraftForge.TERRAIN_GEN_BUS.register(new PVJTerrainGenEvents());
    	
    }
}
