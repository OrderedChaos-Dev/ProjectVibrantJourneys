package vibrantjourneys;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ForgeHooks;
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
import vibrantjourneys.init.PVJEntities;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.init.PVJRegistryEventHandler;
import vibrantjourneys.init.PVJTileEntities;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.PVJOreDictionary;
import vibrantjourneys.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = "{@pvjVersion}", dependencies="after:*")
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
    	PVJBiomes.initBiomes();
    	PVJItems.initItems();
    	PVJBlocks.initBlocks();
    	PVJTileEntities.initTileEntities();
    	
    	// Items, blocks, entities, and item/block models are registered here
    	MinecraftForge.EVENT_BUS.register(new PVJRegistryEventHandler());
    	
    	MinecraftForge.EVENT_BUS.register(new PVJConfig.ConfigEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.registerTESRs();
    	
    	PVJOreDictionary.setValues();
    	BiomeReference.loadAllBiomeReferences();
    	PVJEntities.addSpawns();
    	PVJWorldGen.initWorldGen();
    	
		ProjectVibrantJourneys.proxy.registerBlockColors();
    	
		EntityRegistry.removeSpawn(EntitySquid.class, EnumCreatureType.WATER_CREATURE, BiomeReference.FRESHWATER_BIOMES.toArray(new Biome[0]));
		
		//removes wheat seed drop
		if(!PVJConfig.doGrassDropSeeds)
		{
			Field field;
			try
			{
				field = ForgeHooks.class.getDeclaredField("seedList");
				field.setAccessible(true);
				
				ArrayList<?> seeds = (ArrayList<?>) field.get(ForgeHooks.class);
				seeds.remove(0);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
    }
}
