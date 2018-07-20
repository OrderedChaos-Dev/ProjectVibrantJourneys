package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeColorHelper;
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
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.BiomeReference;
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
    	
    	MinecraftForge.EVENT_BUS.register(new PVJConfig.ConfigEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	PVJWorldGen.initWorldGen();

    	registerFallenLeavesColors(PVJBlocks.fallenleaves_oak, BlockPlanks.EnumType.OAK);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_birch, BlockPlanks.EnumType.BIRCH);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_spruce, BlockPlanks.EnumType.SPRUCE);
    	registerFallenLeavesColors(PVJBlocks.fallenleaves_jungle, BlockPlanks.EnumType.JUNGLE);
    	registerFallenLeavesColors2(PVJBlocks.fallenleaves_darkoak, BlockPlanks.EnumType.DARK_OAK);
    	registerFallenLeavesColors2(PVJBlocks.fallenleaves_acacia, BlockPlanks.EnumType.ACACIA);
    	
		EntityRegistry.removeSpawn(EntitySquid.class, EnumCreatureType.WATER_CREATURE, BiomeReference.FRESHWATER_BIOMES.toArray(new Biome[0]));
    }
    
    public void registerFallenLeavesColors(Block leafBlock, BlockPlanks.EnumType type)
    {
    	BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
    	IBlockState leafState = Blocks.LEAVES.getDefaultState();
    	
    	proxy.registerBlockColor((state, world, pos, tintindex) -> BiomeColorHelper.getFoliageColorAtPos(world, pos), leafBlock);
    	
    	proxy.registerItemColor((stack, tintindex) -> 
    		blockColors.colorMultiplier(leafState.withProperty(BlockOldLeaf.VARIANT, type), null, null, tintindex), 
    		Item.getItemFromBlock(leafBlock));
    }
    
    public void registerFallenLeavesColors2(Block leafBlock, BlockPlanks.EnumType type)
    {
    	BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
    	IBlockState leafState = Blocks.LEAVES2.getDefaultState();
    	
    	proxy.registerBlockColor((state, world, pos, tintindex) -> BiomeColorHelper.getFoliageColorAtPos(world, pos), leafBlock);
    	
    	proxy.registerItemColor((stack, tintindex) -> 
    		blockColors.colorMultiplier(leafState.withProperty(BlockNewLeaf.VARIANT, type), null, null, tintindex), 
    		Item.getItemFromBlock(leafBlock));
    }
}
