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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
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
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.PVJOreDictionary;
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
    	
    	// Items, blocks, entities, and item/block models are registered here
    	MinecraftForge.EVENT_BUS.register(new PVJRegistryEventHandler());
    	
    	MinecraftForge.EVENT_BUS.register(new PVJConfig.ConfigEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	PVJWorldGen.initWorldGen();

    	registerFallenLeavesColors(PVJBlocks.fallenleaves_oak, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_birch, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH, Blocks.LEAVES, ColorizerFoliage.getFoliageColorBirch());
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_spruce, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE, Blocks.LEAVES, ColorizerFoliage.getFoliageColorPine());
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_jungle, BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE, Blocks.LEAVES, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_darkoak, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK, Blocks.LEAVES2, -1);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_acacia, BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA, Blocks.LEAVES2, -1);
    	
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
		
    	PVJOreDictionary.setValues();
    }
    
    public void registerFallenLeavesColors(Block leafBlock, PropertyEnum<EnumType> property, BlockPlanks.EnumType type, Block leaf, int color)
    {
    	BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
    	IBlockState leafState = leaf.getDefaultState();

    	//set color to -1 to use the biome foliage color
    	if(color == -1)
    		proxy.registerBlockColor((state, world, pos, tintindex) -> BiomeColorHelper.getFoliageColorAtPos(world, pos), leafBlock);
    	else
    		proxy.registerBlockColor((state, world, pos, tintindex) -> color, leafBlock);
    	
    	proxy.registerItemColor((stack, tintindex) -> 
    		blockColors.colorMultiplier(leafState.withProperty(property, type), null, null, tintindex), 
    		Item.getItemFromBlock(leafBlock));
    }
}
