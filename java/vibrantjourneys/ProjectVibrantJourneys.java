package vibrantjourneys;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vibrantjourneys.init.ModBiomes;
import vibrantjourneys.init.ModBlocks;
import vibrantjourneys.init.ModEntities;
import vibrantjourneys.init.ModItems;
import vibrantjourneys.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class ProjectVibrantJourneys
{   
    @Instance(Reference.MOD_ID)
    public static ProjectVibrantJourneys instance;
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ModEntities.initEntities();
    	ModBiomes.initBiomes();
    	ModItems.initItems();
    	ModBlocks.initBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
