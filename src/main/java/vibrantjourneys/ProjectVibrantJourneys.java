package vibrantjourneys;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJEntities;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class ProjectVibrantJourneys
{   
    @Instance(Reference.MOD_ID)
    public static ProjectVibrantJourneys instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static ICommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	PVJEntities.initEntities();
    	PVJBiomes.initBiomes();
    	PVJItems.initItems();
    	PVJBlocks.initBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	PVJWorldGen.initWorldGen();
    }
}
