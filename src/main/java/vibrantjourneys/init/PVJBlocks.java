package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;
import vibrantjourneys.blocks.BlockChimney;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockCrackedSand;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundLitter;
import vibrantjourneys.blocks.BlockMysticalGrill;
import vibrantjourneys.blocks.BlockPVJButton;
import vibrantjourneys.blocks.BlockPVJDoor;
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
import vibrantjourneys.blocks.BlockPVJTrapdoor;
import vibrantjourneys.blocks.BlockWildWheat;
import vibrantjourneys.integration.biomesoplenty.PVJBlocksBOP;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.items.ItemPVJSlab;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.Reference;

public class PVJBlocks
{
	public static final ArrayList<Block> BLOCKS = new ArrayList<Block>();
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
	
	//trapdoor, boat
	public static Block willow_door;
	public static Block mangrove_door;
	public static Block palm_door;
	public static Block redwood_door;
	
	public static Block willow_trapdoor;
	public static Block mangrove_trapdoor;
	public static Block palm_trapdoor;
	public static Block redwood_trapdoor;
	
	public static Block wild_wheat;
	
	public static Block cobblestone_chimney;
	public static Block stone_chimney;
	public static Block brick_chimney;
	public static Block stonebrick_chimney;
	public static Block cobblestone_brick_chimney;
	public static Block sandstone_chimney;
	public static Block netherbrick_chimney;
	
	public static Block mystical_grill;
	
	public static void initBlocks()
	{
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick");
		
		willow_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.WILLOW), "planks_willow");
		mangrove_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.MANGROVE), "planks_mangrove");
		palm_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.PALM), "planks_palm");
		redwood_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.REDWOOD), "planks_redwood");
		
		willow_log = registerBlock(new BlockPVJLog(EnumWoodType.WILLOW), "log_willow");
		mangrove_log = registerBlock(new BlockPVJLog(EnumWoodType.MANGROVE), "log_mangrove");
		palm_log = registerBlock(new BlockPVJLog(EnumWoodType.PALM), "log_palm");
		redwood_log = registerBlock(new BlockPVJLog(EnumWoodType.REDWOOD), "log_redwood");
		
		willow_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.WILLOW), "leaves_willow");
		mangrove_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.MANGROVE), "leaves_mangrove");
		palm_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.PALM), "leaves_palm");
		redwood_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.REDWOOD), "leaves_redwood");

		willow_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.WILLOW), "sapling_willow");
		mangrove_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.MANGROVE), "sapling_mangrove");
		palm_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.PALM), "sapling_palm");
		redwood_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.REDWOOD), "sapling_redwood");

		coconut = registerBlock(new BlockCoconut(), "coconut");

		fallenleaves_oak = registerBlock(new BlockFallenLeaves(), "fallenleaves_oak");
		fallenleaves_birch = registerBlock(new BlockFallenLeaves(), "fallenleaves_birch");
		fallenleaves_spruce = registerBlock(new BlockFallenLeaves(), "fallenleaves_spruce");
		fallenleaves_jungle = registerBlock(new BlockFallenLeaves(), "fallenleaves_jungle");
		fallenleaves_darkoak = registerBlock(new BlockFallenLeaves(), "fallenleaves_darkoak");
		fallenleaves_acacia = registerBlock(new BlockFallenLeaves(), "fallenleaves_acacia");
		fallenleaves_willow = registerBlock(new BlockFallenLeaves(), "fallenleaves_willow");
		fallenleaves_mangrove = registerBlock(new BlockFallenLeaves(), "fallenleaves_mangrove");
		fallenleaves_palm = registerBlock(new BlockFallenLeaves(), "fallenleaves_palm");
		fallenleaves_redwood = registerBlock(new BlockFallenLeaves(), "fallenleaves_redwood");
		fallenleaves_dead = registerBlock(new BlockFallenLeaves(), "fallenleaves_dead");

		stone_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "stone_rocks");
		cobblestone_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "cobblestone_rocks");
		mossy_cobblestone_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "mossy_cobblestone_rocks");
		andesite_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "andesite_rocks");
		granite_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "granite_rocks");
		diorite_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "diorite_rocks");
		sandstone_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new BlockGroundLitter(Material.ROCK), "red_sandstone_rocks");

		oak_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "oak_twigs");
		birch_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "birch_twigs");
		spruce_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "spruce_twigs");
		jungle_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "jungle_twigs");
		acacia_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "acacia_twigs");
		dark_oak_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "dark_oak_twigs");
		willow_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "willow_twigs");
		mangrove_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "mangrove_twigs");
		palm_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "palm_twigs");
		redwood_twigs = registerBlock(new BlockGroundLitter(Material.PLANTS), "redwood_twigs");

		bones = registerBlock(new BlockGroundLitter(Material.ROCK), "bones");

		cracked_sand = registerBlock(new BlockCrackedSand(), "cracked_sand");
		red_cracked_sand = registerBlock(new BlockCrackedSand(), "red_cracked_sand");

		cobblestone_brick_stairs = registerBlock(new BlockPVJStairs(cobblestone_brick.getDefaultState()), "cobblestone_brick_stairs");
		willow_stairs = registerBlock(new BlockPVJStairs(willow_planks.getDefaultState()), "willow_stairs");
		mangrove_stairs = registerBlock(new BlockPVJStairs(mangrove_planks.getDefaultState()), "mangrove_stairs");
		palm_stairs = registerBlock(new BlockPVJStairs(palm_planks.getDefaultState()), "palm_stairs");
		redwood_stairs = registerBlock(new BlockPVJStairs(redwood_planks.getDefaultState()), "redwood_stairs");
		
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
		
		willow_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "willow_pressure_plate");
		mangrove_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "mangrove_pressure_plate");
		palm_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "palm_pressure_plate");
		redwood_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "redwood_pressure_plate");
		
		willow_button = registerBlock(new BlockPVJButton(), "willow_button");
		mangrove_button = registerBlock(new BlockPVJButton(), "mangrove_button");
		palm_button = registerBlock(new BlockPVJButton(), "palm_button");
		redwood_button = registerBlock(new BlockPVJButton(), "redwood_button");
		
		willow_fence = registerBlock(new BlockPVJFence(EnumWoodType.WILLOW), "willow_fence");
		mangrove_fence = registerBlock(new BlockPVJFence(EnumWoodType.MANGROVE), "mangrove_fence");
		palm_fence = registerBlock(new BlockPVJFence(EnumWoodType.PALM), "palm_fence");
		redwood_fence = registerBlock(new BlockPVJFence(EnumWoodType.REDWOOD), "redwood_fence");
		
		willow_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.WILLOW), "willow_fence_gate");
		mangrove_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.MANGROVE), "mangrove_fence_gate");
		palm_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.PALM), "palm_fence_gate");
		redwood_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.REDWOOD), "redwood_fence_gate");
		
		willow_door = registerDoor(new BlockPVJDoor(EnumWoodType.WILLOW), PVJItems.willow_door, "willow_door");
		mangrove_door = registerDoor(new BlockPVJDoor(EnumWoodType.MANGROVE), PVJItems.mangrove_door, "mangrove_door");
		palm_door = registerDoor(new BlockPVJDoor(EnumWoodType.PALM), PVJItems.palm_door, "palm_door");
		redwood_door = registerDoor(new BlockPVJDoor(EnumWoodType.REDWOOD), PVJItems.redwood_door, "redwood_door");
		
		willow_trapdoor = registerBlock(new BlockPVJTrapdoor(), "willow_trapdoor");
		mangrove_trapdoor = registerBlock(new BlockPVJTrapdoor(), "mangrove_trapdoor");
		palm_trapdoor = registerBlock(new BlockPVJTrapdoor(), "palm_trapdoor");
		redwood_trapdoor = registerBlock(new BlockPVJTrapdoor(), "redwood_trapdoor");
		
		wild_wheat = registerBlock(new BlockWildWheat(), "wild_wheat");
		
		cobblestone_chimney = registerBlock(new BlockChimney(), "cobblestone_chimney");
		
		mystical_grill = registerBlock(new BlockMysticalGrill(), "mystical_grill");
		
		if(Reference.isBOPLoaded)
			PVJBlocksBOP.initBOPBlocks();
	}
	
	public static Block registerBlock(Block block, String name)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		
		Item itemBlock = new ItemPVJBlock(block);
		itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));

		BLOCKS.add(block);
		PVJItems.ITEMS.add(itemBlock);
		
		return block;
	}
	
	public static Block registerBlockWithItem(Block block, String name, ItemBlock itemblock)
	{
		block.setUnlocalizedName(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		BLOCKS.add(block);
		
		itemblock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		PVJItems.ITEMS.add(itemblock);
		
		return block;
	}
	
	//Doors must be registered alongside its item 
	public static Block registerDoor(BlockPVJDoor door, Item item, String name)
	{
		door = (BlockPVJDoor) registerBlock(door, name);
		door.setCreativeTab(null);
		
		item = PVJItems.registerItem(new ItemDoor(door), name + "_item");
		door.setDoorItem(item);
		
		return door;
	}
	
	public static void registerSlab(BlockPVJHalfSlab halfSlab, BlockPVJDoubleSlab doubleSlab, String name1, String name2)
	{
		ItemPVJSlab itemSlab = new ItemPVJSlab(halfSlab, halfSlab, doubleSlab);
		registerBlockWithItem(halfSlab, name1, itemSlab);
		
		doubleSlab.setRegistryName(new ResourceLocation(Reference.MOD_ID, name2));
		BLOCKS.add(doubleSlab);
	}
}
