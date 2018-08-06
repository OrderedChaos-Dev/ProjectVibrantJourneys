package vibrantjourneys.init;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockCrackedSand;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundLitter;
import vibrantjourneys.blocks.BlockPVJButton;
import vibrantjourneys.blocks.BlockPVJDoubleSlab;
import vibrantjourneys.blocks.BlockPVJFence;
import vibrantjourneys.blocks.BlockPVJFenceGate;
import vibrantjourneys.blocks.BlockPVJHalfSlab;
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.blocks.BlockPVJPressurePlate;
import vibrantjourneys.blocks.BlockPVJSapling;
import vibrantjourneys.blocks.BlockPVJStairs;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.items.ItemPVJSlab;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.IPropertyHelper;
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
	
	//1.13: allow waterlogged
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
	
	//1.13: allow waterlogged
	public static Block bones;
	
	public static Block cracked_sand;
	public static Block red_cracked_sand;
	
	//1.13: allow waterlogged
	public static Block cobblestone_brick_stairs;
	public static Block willow_stairs;
	public static Block mangrove_stairs;
	public static Block palm_stairs;
	public static Block redwood_stairs;
	
	//1.13: allow waterlogged
	public static BlockPVJHalfSlab cobblestone_brick_half_slab;
	public static BlockPVJHalfSlab willow_half_slab;
	public static BlockPVJHalfSlab mangrove_half_slab;
	public static BlockPVJHalfSlab palm_half_slab;
	public static BlockPVJHalfSlab redwood_half_slab;
	
	//1.13: allow waterlogged
	public static BlockPVJDoubleSlab cobblestone_brick_double_slab;
	public static BlockPVJDoubleSlab willow_double_slab;
	public static BlockPVJDoubleSlab mangrove_double_slab;
	public static BlockPVJDoubleSlab palm_double_slab;
	public static BlockPVJDoubleSlab redwood_double_slab;
	
	//pressure plates, buttons, and trapdoors for all wood types for 1.13
	public static Block willow_pressure_plate;
	public static Block mangrove_pressure_plate;
	public static Block palm_pressure_plate;
	public static Block redwood_pressure_plate;
	
	public static Block willow_button;
	public static Block mangrove_button;
	public static Block palm_button;
	public static Block redwood_button;
	
	public static Block willow_fence;
	public static Block mangrove_fence;
	public static Block palm_fence;
	public static Block redwood_fence;
	
	public static Block willow_fence_gate;
	public static Block mangrove_fence_gate;
	public static Block palm_fence_gate;
	public static Block redwood_fence_gate;
	
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
		
		cobblestone_brick_stairs = registerBlockWithProperties(new BlockPVJStairs(cobblestone_brick.getDefaultState()), "cobblestone_brick_stairs");
		willow_stairs = registerBlockWithProperties(new BlockPVJStairs(willow_planks.getDefaultState()), "willow_stairs");
		mangrove_stairs = registerBlockWithProperties(new BlockPVJStairs(mangrove_planks.getDefaultState()), "mangrove_stairs");
		palm_stairs = registerBlockWithProperties(new BlockPVJStairs(palm_planks.getDefaultState()), "palm_stairs");
		redwood_stairs = registerBlockWithProperties(new BlockPVJStairs(redwood_planks.getDefaultState()), "redwood_stairs");
		
		cobblestone_brick_half_slab = new BlockPVJHalfSlab(cobblestone_brick.getDefaultState(), cobblestone_brick_half_slab);
		cobblestone_brick_double_slab = new BlockPVJDoubleSlab(cobblestone_brick.getDefaultState(), cobblestone_brick_half_slab);
		registerSlab(cobblestone_brick_half_slab, cobblestone_brick_double_slab, "cobblestone_brick_slab", "cobblestone_brick_double_slab");
		
		willow_half_slab = new BlockPVJHalfSlab(willow_planks.getDefaultState(), willow_half_slab);
		willow_double_slab = new BlockPVJDoubleSlab(willow_planks.getDefaultState(), willow_half_slab);
		registerSlab(willow_half_slab, willow_double_slab, "willow_slab", "willow_double_slab");
		
		mangrove_half_slab = new BlockPVJHalfSlab(mangrove_planks.getDefaultState(), mangrove_half_slab);
		mangrove_double_slab = new BlockPVJDoubleSlab(mangrove_planks.getDefaultState(), mangrove_half_slab);
		registerSlab(mangrove_half_slab, mangrove_double_slab, "mangrove_slab", "mangrove_double_slab");
		
		palm_half_slab = new BlockPVJHalfSlab(palm_planks.getDefaultState(), palm_half_slab);
		palm_double_slab = new BlockPVJDoubleSlab(palm_planks.getDefaultState(), palm_half_slab);
		registerSlab(palm_half_slab, palm_double_slab, "palm_slab", "palm_double_slab");
		
		redwood_half_slab = new BlockPVJHalfSlab(redwood_planks.getDefaultState(), redwood_half_slab);
		redwood_double_slab = new BlockPVJDoubleSlab(redwood_planks.getDefaultState(), redwood_half_slab);
		registerSlab(redwood_half_slab, redwood_double_slab, "redwood_slab", "redwood_double_slab");
		
		willow_pressure_plate = registerBlockWithProperties(new BlockPVJPressurePlate(), "willow_pressure_plate");
		mangrove_pressure_plate = registerBlockWithProperties(new BlockPVJPressurePlate(), "mangrove_pressure_plate");
		palm_pressure_plate = registerBlockWithProperties(new BlockPVJPressurePlate(), "palm_pressure_plate");
		redwood_pressure_plate = registerBlockWithProperties(new BlockPVJPressurePlate(), "redwood_pressure_plate");
		
		willow_button = registerBlockWithProperties(new BlockPVJButton(), "willow_button");
		mangrove_button = registerBlockWithProperties(new BlockPVJButton(), "mangrove_button");
		palm_button = registerBlockWithProperties(new BlockPVJButton(), "palm_button");
		redwood_button = registerBlockWithProperties(new BlockPVJButton(), "redwood_button");
		
		willow_fence = registerBlockWithProperties(new BlockPVJFence(EnumWoodType.WILLOW), "willow_fence");
		mangrove_fence = registerBlockWithProperties(new BlockPVJFence(EnumWoodType.MANGROVE), "mangrove_fence");
		palm_fence = registerBlockWithProperties(new BlockPVJFence(EnumWoodType.PALM), "palm_fence");
		redwood_fence = registerBlockWithProperties(new BlockPVJFence(EnumWoodType.REDWOOD), "redwood_fence");
		
		willow_fence_gate = registerBlockWithProperties(new BlockPVJFenceGate(EnumWoodType.WILLOW), "willow_fence_gate");
		mangrove_fence_gate = registerBlockWithProperties(new BlockPVJFenceGate(EnumWoodType.MANGROVE), "mangrove_fence_gate");
		palm_fence_gate = registerBlockWithProperties(new BlockPVJFenceGate(EnumWoodType.PALM), "palm_fence_gate");
		redwood_fence_gate = registerBlockWithProperties(new BlockPVJFenceGate(EnumWoodType.REDWOOD), "redwood_fence_gate");
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
	
	private static Block registerBlockWithItem(Block block, String name, ItemBlock itemblock)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.BLOCKS.register(block);
		
		itemblock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		ForgeRegistries.ITEMS.register(itemblock);
		
		ProjectVibrantJourneys.proxy.registerItemRenderer(Item.getItemFromBlock(block), name);
		return block;
	}
	
	private static Block registerBlockWithProperties(Block block, String name)
	{
		registerBlock(block, name, true);
		IPropertyHelper PVJblock = (IPropertyHelper)block;
		
		ImmutableList<IBlockState> variants = PVJblock.getProperties();
		
		for(IBlockState state : variants)
		{
			int meta = block.getMetaFromState(state);
			ModelResourceLocation resource = new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name), "inventory");
			ProjectVibrantJourneys.proxy.registerItemVariantRenderer(Item.getItemFromBlock(block), meta, resource);
		}
		
		return block;
	}
	
	private static void registerSlab(BlockPVJHalfSlab halfSlab, BlockPVJDoubleSlab doubleSlab, String name1, String name2)
	{
		ItemPVJSlab itemSlab = new ItemPVJSlab(halfSlab, halfSlab, doubleSlab);
		registerBlockWithItem(halfSlab, name1, itemSlab);
		
		doubleSlab.setRegistryName(new ResourceLocation(Reference.MOD_ID, name2));
		ForgeRegistries.BLOCKS.register(doubleSlab);
	}
}
