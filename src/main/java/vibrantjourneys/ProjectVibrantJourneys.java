package vibrantjourneys;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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
import vibrantjourneys.integration.biomesoplenty.PVJRenderingHandlerBOP;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;
import vibrantjourneys.tileentities.renderer.TileEntityMysticalGrillRenderer;
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
