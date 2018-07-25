package vibrantjourneys.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockCrackedSand;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundLitter;
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.blocks.BlockPVJSapling;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IVariantHelper;
import vibrantjourneys.util.Reference;

public class PVJBlocks
{
	public static Block cobblestone_brick;
	
	//flattened for 1.13
	public static Block willow_planks;
	public static Block mangrove_planks;
	public static Block palm_planks;
	public static Block redwood_planks;
	
	//1.13: add bark
	public static Block willow_log;
	public static Block mangrove_log;
	public static Block palm_log;
	public static Block redwood_log;
	
	public static Block willow_leaves;
	public static Block mangrove_leaves;
	public static Block palm_leaves;
	public static Block redwood_leaves;
	
	//1.13: mangrove saplings can be waterlogged
	public static Block willow_sapling;
	public static Block mangrove_sapling;
	public static Block palm_sapling;
	public static Block redwood_sapling;
	
	public static Block coconut;
	
	public static Block fallenleaves_oak;
	public static Block fallenleaves_birch;
	public static Block fallenleaves_spruce;
	public static Block fallenleaves_jungle;
	public static Block fallenleaves_darkoak;
	public static Block fallenleaves_acacia;
	public static Block fallenleaves_willow;
	public static Block fallenleaves_mangrove;
	public static Block fallenleaves_palm;
	public static Block fallenleaves_redwood;
	public static Block fallenleaves_dead;
	
	public static Block stone_rocks;
	public static Block cobblestone_rocks;
	public static Block mossy_cobblestone_rocks;
	public static Block andesite_rocks;
	public static Block granite_rocks;
	public static Block diorite_rocks;
	public static Block sandstone_rocks;
	public static Block red_sandstone_rocks;
	
	public static Block oak_twigs;
	public static Block birch_twigs;
	public static Block spruce_twigs;
	public static Block jungle_twigs;
	public static Block acacia_twigs;
	public static Block dark_oak_twigs;
	public static Block willow_twigs;
	public static Block mangrove_twigs;
	public static Block palm_twigs;
	public static Block redwood_twigs;
	
	public static Block bones;
	
	public static Block cracked_sand;
	public static Block red_cracked_sand;
	
	public static void initBlocks()
	{
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick", false);
		
		willow_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.WILLOW), "planks_willow", false);
		mangrove_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.MANGROVE), "planks_mangrove", false);
		palm_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.PALM), "planks_palm", false);
		redwood_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.REDWOOD), "planks_redwood", false);
		
		willow_log = registerBlockWithProperties(new BlockPVJLog(EnumWoodType.WILLOW), "log_willow");
		mangrove_log = registerBlockWithProperties(new BlockPVJLog(EnumWoodType.MANGROVE), "log_mangrove");
		palm_log = registerBlockWithProperties(new BlockPVJLog(EnumWoodType.PALM), "log_palm");
		redwood_log = registerBlockWithProperties(new BlockPVJLog(EnumWoodType.REDWOOD), "log_redwood");
		
		willow_leaves = registerBlockWithProperties(new BlockPVJLeaves(EnumWoodType.WILLOW), "leaves_willow");
		mangrove_leaves = registerBlockWithProperties(new BlockPVJLeaves(EnumWoodType.MANGROVE), "leaves_mangrove");
		palm_leaves = registerBlockWithProperties(new BlockPVJLeaves(EnumWoodType.PALM), "leaves_palm");
		redwood_leaves = registerBlockWithProperties(new BlockPVJLeaves(EnumWoodType.REDWOOD), "leaves_redwood");
		
		willow_sapling = registerBlockWithProperties(new BlockPVJSapling(EnumWoodType.WILLOW), "sapling_willow");
		mangrove_sapling = registerBlockWithProperties(new BlockPVJSapling(EnumWoodType.MANGROVE), "sapling_mangrove");
		palm_sapling = registerBlockWithProperties(new BlockPVJSapling(EnumWoodType.PALM), "sapling_palm");
		redwood_sapling = registerBlockWithProperties(new BlockPVJSapling(EnumWoodType.REDWOOD), "sapling_redwood");
		
		coconut = registerBlock(new BlockCoconut(), "coconut", false);
		
		fallenleaves_oak = registerBlock(new BlockFallenLeaves(), "fallenleaves_oak", false);
		fallenleaves_birch = registerBlock(new BlockFallenLeaves(), "fallenleaves_birch", false);
		fallenleaves_spruce = registerBlock(new BlockFallenLeaves(), "fallenleaves_spruce", false);
		fallenleaves_jungle = registerBlock(new BlockFallenLeaves(), "fallenleaves_jungle", false);
		fallenleaves_darkoak = registerBlock(new BlockFallenLeaves(), "fallenleaves_darkoak", false);
		fallenleaves_acacia = registerBlock(new BlockFallenLeaves(), "fallenleaves_acacia", false);
		fallenleaves_willow = registerBlock(new BlockFallenLeaves(), "fallenleaves_willow", false);
		fallenleaves_mangrove = registerBlock(new BlockFallenLeaves(), "fallenleaves_mangrove", false);
		fallenleaves_palm = registerBlock(new BlockFallenLeaves(), "fallenleaves_palm", false);
		fallenleaves_redwood = registerBlock(new BlockFallenLeaves(), "fallenleaves_redwood", false);
		fallenleaves_dead = registerBlock(new BlockFallenLeaves(), "fallenleaves_dead", false);
		
		stone_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "stone_rocks");
		cobblestone_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "cobblestone_rocks");
		mossy_cobblestone_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "mossy_cobblestone_rocks");
		andesite_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "andesite_rocks");
		granite_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "granite_rocks");
		diorite_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "diorite_rocks");
		sandstone_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "sandstone_rocks");
		red_sandstone_rocks = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "red_sandstone_rocks");
		
		oak_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "oak_twigs");
		birch_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "birch_twigs");
		spruce_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "spruce_twigs");
		jungle_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "jungle_twigs");
		acacia_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "acacia_twigs");
		dark_oak_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "dark_oak_twigs");
		willow_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "willow_twigs");
		mangrove_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "mangrove_twigs");
		palm_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "palm_twigs");
		redwood_twigs = registerBlockWithProperties(new BlockGroundLitter(Material.PLANTS), "redwood_twigs");
		
		bones = registerBlockWithProperties(new BlockGroundLitter(Material.ROCK), "bones");
		
		cracked_sand = registerBlock(new BlockCrackedSand(), "cracked_sand", false);
		red_cracked_sand = registerBlock(new BlockCrackedSand(), "red_cracked_sand", false);		
	}
	
	private static Block registerBlock(Block block, String name, boolean hasVariants)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.BLOCKS.register(block);
		
		Item itemBlock = new ItemPVJBlock(block);
		itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.ITEMS.register(itemBlock);
		
		if(!hasVariants)
			ProjectVibrantJourneys.proxy.registerItemRenderer(Item.getItemFromBlock(block), name);
		
		return block;
	}
	
	private static Block registerBlockWithProperties(Block block, String name)
	{
		registerBlock(block, name, true);
		IVariantHelper PVJblock = (IVariantHelper)block;
		
		ImmutableList<IBlockState> variants = PVJblock.getVariants();
		
		for(IBlockState state : variants)
		{
			int meta = block.getMetaFromState(state);
			ModelResourceLocation resource = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name), "inventory");
			ProjectVibrantJourneys.proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
		}
		
		return block;
	}
}
