package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;
import vibrantjourneys.blocks.BlockChimney;
import vibrantjourneys.blocks.BlockChimneyTop;
import vibrantjourneys.blocks.BlockCobblestoneBrick;
import vibrantjourneys.blocks.BlockCobblestoneBrickWall;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockCrackedSand;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGlowcap;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.blocks.BlockMysticalGrill;
import vibrantjourneys.blocks.BlockNetherPlant;
import vibrantjourneys.blocks.BlockPVJButton;
import vibrantjourneys.blocks.BlockPVJDoor;
import vibrantjourneys.blocks.BlockPVJDoubleSlab;
import vibrantjourneys.blocks.BlockPVJFence;
import vibrantjourneys.blocks.BlockPVJFenceGate;
import vibrantjourneys.blocks.BlockPVJHalfSlab;
import vibrantjourneys.blocks.BlockPVJLeaves;
import vibrantjourneys.blocks.BlockPVJLog;
import vibrantjourneys.blocks.BlockPVJPlanks;
import vibrantjourneys.blocks.BlockPVJPlant;
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
	
	public static Block willow_planks;
	public static Block mangrove_planks;
	public static Block palm_planks;
	public static Block redwood_planks;
	public static Block fir_planks;
	public static Block pine_planks;
	public static Block aspen_planks;
	public static Block maple_planks;
	public static Block baobab_planks;
	
	//1.13: add bark/ stripped bark
	public static Block willow_log;
	public static Block mangrove_log;
	public static Block palm_log;
	public static Block redwood_log;
	public static Block fir_log;
	public static Block pine_log;
	public static Block aspen_log;
	public static Block maple_log;
	public static Block baobab_log;
	
	public static Block willow_leaves;
	public static Block mangrove_leaves;
	public static Block palm_leaves;
	public static Block redwood_leaves;
	public static Block fir_leaves;
	public static Block pine_leaves;
	public static Block aspen_leaves;
	public static Block red_maple_leaves;
	public static Block orange_maple_leaves;
	public static Block baobab_leaves;
	
	//1.13: mangrove saplings can be waterlogged
	public static Block willow_sapling;
	public static Block mangrove_sapling;
	public static Block palm_sapling;
	public static Block redwood_sapling;
	public static Block fir_sapling;
	public static Block pine_sapling;
	public static Block aspen_sapling;
	public static Block red_maple_sapling;
	public static Block orange_maple_sapling;
	public static Block baobab_sapling;
	
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
	public static Block fallenleaves_fir;
	public static Block fallenleaves_pine;
	public static Block fallenleaves_aspen;
	public static Block fallenleaves_red_maple;
	public static Block fallenleaves_orange_maple;
	public static Block fallenleaves_baobab;
	
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
	public static Block fir_twigs;
	public static Block pine_twigs;
	public static Block aspen_twigs;
	public static Block red_maple_twigs;
	public static Block orange_maple_twigs;
	public static Block baobab_twigs;
	
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
	public static Block fir_stairs;
	public static Block pine_stairs;
	public static Block aspen_stairs;
	public static Block maple_stairs;
	public static Block baobab_stairs;
	
	//1.13: allow waterlogged
	public static BlockPVJHalfSlab cobblestone_brick_half_slab;
	public static BlockPVJHalfSlab willow_half_slab;
	public static BlockPVJHalfSlab mangrove_half_slab;
	public static BlockPVJHalfSlab palm_half_slab;
	public static BlockPVJHalfSlab redwood_half_slab;
	public static BlockPVJHalfSlab fir_half_slab;
	public static BlockPVJHalfSlab pine_half_slab;
	public static BlockPVJHalfSlab aspen_half_slab;
	public static BlockPVJHalfSlab maple_half_slab;
	public static BlockPVJHalfSlab baobab_half_slab;
	
	public static BlockPVJDoubleSlab cobblestone_brick_double_slab;
	public static BlockPVJDoubleSlab willow_double_slab;
	public static BlockPVJDoubleSlab mangrove_double_slab;
	public static BlockPVJDoubleSlab palm_double_slab;
	public static BlockPVJDoubleSlab redwood_double_slab;
	public static BlockPVJDoubleSlab fir_double_slab;
	public static BlockPVJDoubleSlab pine_double_slab;
	public static BlockPVJDoubleSlab aspen_double_slab;
	public static BlockPVJDoubleSlab maple_double_slab;
	public static BlockPVJDoubleSlab baobab_double_slab;
	
	//pressure plates, buttons, and trapdoors for all wood types for 1.13
	public static Block willow_pressure_plate;
	public static Block mangrove_pressure_plate;
	public static Block palm_pressure_plate;
	public static Block redwood_pressure_plate;
	public static Block fir_pressure_plate;
	public static Block pine_pressure_plate;
	public static Block aspen_pressure_plate;
	public static Block maple_pressure_plate;
	public static Block baobab_pressure_plate;
	
	public static Block willow_button;
	public static Block mangrove_button;
	public static Block palm_button;
	public static Block redwood_button;
	public static Block fir_button;
	public static Block pine_button;
	public static Block aspen_button;
	public static Block maple_button;
	public static Block baobab_button;
	
	public static Block willow_fence;
	public static Block mangrove_fence;
	public static Block palm_fence;
	public static Block redwood_fence;
	public static Block fir_fence;
	public static Block pine_fence;
	public static Block aspen_fence;
	public static Block maple_fence;
	public static Block baobab_fence;
	
	public static Block willow_fence_gate;
	public static Block mangrove_fence_gate;
	public static Block palm_fence_gate;
	public static Block redwood_fence_gate;
	public static Block fir_fence_gate;
	public static Block pine_fence_gate;
	public static Block aspen_fence_gate;
	public static Block maple_fence_gate;
	public static Block baobab_fence_gate;
	
	public static Block willow_door;
	public static Block mangrove_door;
	public static Block palm_door;
	public static Block redwood_door;
	public static Block fir_door;
	public static Block pine_door;
	public static Block aspen_door;
	public static Block maple_door;
	public static Block baobab_door;
	
	public static Block willow_trapdoor;
	public static Block mangrove_trapdoor;
	public static Block palm_trapdoor;
	public static Block redwood_trapdoor;
	public static Block fir_trapdoor;
	public static Block pine_trapdoor;
	public static Block aspen_trapdoor;
	public static Block maple_trapdoor;
	public static Block baobab_trapdoor;
	
	public static Block wild_wheat;
	
	public static Block mystical_grill;
	
	public static Block cobblestone_chimney;
	public static Block stone_chimney;
	public static Block brick_chimney;
	public static Block stonebrick_chimney;
	public static Block cobblestone_brick_chimney;
	public static Block sandstone_chimney;
	public static Block netherbrick_chimney;
	
	public static Block cobblestone_chimney_top;
	public static Block stone_chimney_top;
	public static Block brick_chimney_top;
	public static Block stonebrick_chimney_top;
	public static Block cobblestone_brick_chimney_top;
	public static Block sandstone_chimney_top;
	public static Block netherbrick_chimney_top;
	
	public static Block cobblestone_brick_wall;
	
	//1.13: allow waterlogged
	public static Block seashells;
	public static Block pinecones;
	
	public static Block frost_lotus;
	public static Block silverleaf;
	
	public static Block bloodnettle;
	public static Block glowcap;
	
	public static void initBlocks()
	{
		cobblestone_brick = registerBlock(new BlockCobblestoneBrick(), "cobblestone_brick");
		
		willow_log = registerBlock(new BlockPVJLog(EnumWoodType.WILLOW), "log_willow");
		mangrove_log = registerBlock(new BlockPVJLog(EnumWoodType.MANGROVE), "log_mangrove");
		palm_log = registerBlock(new BlockPVJLog(EnumWoodType.PALM), "log_palm");
		redwood_log = registerBlock(new BlockPVJLog(EnumWoodType.REDWOOD), "log_redwood");
		fir_log = registerBlock(new BlockPVJLog(EnumWoodType.FIR), "log_fir");
		pine_log = registerBlock(new BlockPVJLog(EnumWoodType.PINE), "log_pine");
		aspen_log = registerBlock(new BlockPVJLog(EnumWoodType.ASPEN), "log_aspen");
		maple_log = registerBlock(new BlockPVJLog(EnumWoodType.RED_MAPLE), "log_maple");
		baobab_log = registerBlock(new BlockPVJLog(EnumWoodType.BAOBAB), "log_baobab");
		
		willow_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.WILLOW), "leaves_willow");
		mangrove_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.MANGROVE), "leaves_mangrove");
		palm_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.PALM), "leaves_palm");
		redwood_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.REDWOOD), "leaves_redwood");
		fir_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.FIR), "leaves_fir");
		pine_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.PINE), "leaves_pine");
		aspen_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.ASPEN), "leaves_aspen");
		red_maple_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.RED_MAPLE), "leaves_red_maple");
		orange_maple_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.ORANGE_MAPLE), "leaves_orange_maple");
		baobab_leaves = registerBlock(new BlockPVJLeaves(EnumWoodType.BAOBAB), "leaves_baobab");
		
		willow_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.WILLOW), "planks_willow");
		mangrove_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.MANGROVE), "planks_mangrove");
		palm_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.PALM), "planks_palm");
		redwood_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.REDWOOD), "planks_redwood");
		fir_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.FIR), "planks_fir");
		pine_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.PINE), "planks_pine");
		aspen_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.ASPEN), "planks_aspen");
		maple_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.RED_MAPLE), "planks_maple");
		baobab_planks = registerBlock(new BlockPVJPlanks(EnumWoodType.BAOBAB), "planks_baobab");

		willow_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.WILLOW), "sapling_willow");
		mangrove_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.MANGROVE), "sapling_mangrove");
		palm_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.PALM), "sapling_palm");
		redwood_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.REDWOOD), "sapling_redwood");
		fir_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.FIR), "sapling_fir");
		pine_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.PINE), "sapling_pine");
		aspen_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.ASPEN), "sapling_aspen");
		red_maple_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.RED_MAPLE), "sapling_red_maple");
		orange_maple_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.ORANGE_MAPLE), "sapling_orange_maple");
		baobab_sapling = registerBlock(new BlockPVJSapling(EnumWoodType.BAOBAB), "sapling_baobab");

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
		fallenleaves_fir = registerBlock(new BlockFallenLeaves(), "fallenleaves_fir");
		fallenleaves_pine = registerBlock(new BlockFallenLeaves(), "fallenleaves_pine");
		fallenleaves_aspen = registerBlock(new BlockFallenLeaves(), "fallenleaves_aspen");
		fallenleaves_red_maple = registerBlock(new BlockFallenLeaves(), "fallenleaves_red_maple");
		fallenleaves_orange_maple = registerBlock(new BlockFallenLeaves(), "fallenleaves_orange_maple");
		fallenleaves_baobab = registerBlock(new BlockFallenLeaves(), "fallenleaves_baobab");

		stone_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "stone_rocks");
		cobblestone_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "cobblestone_rocks");
		mossy_cobblestone_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "mossy_cobblestone_rocks");
		andesite_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "andesite_rocks");
		granite_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "granite_rocks");
		diorite_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "diorite_rocks");
		sandstone_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new BlockGroundCover(Material.ROCK), "red_sandstone_rocks");

		oak_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "oak_twigs");
		birch_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "birch_twigs");
		spruce_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "spruce_twigs");
		jungle_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "jungle_twigs");
		acacia_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "acacia_twigs");
		dark_oak_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "dark_oak_twigs");
		willow_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "willow_twigs");
		mangrove_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "mangrove_twigs");
		palm_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "palm_twigs");
		redwood_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "redwood_twigs");
		fir_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "fir_twigs");
		pine_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "pine_twigs");
		aspen_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "aspen_twigs");
		red_maple_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "red_maple_twigs");
		orange_maple_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "orange_maple_twigs");
		baobab_twigs = registerBlock(new BlockGroundCover(Material.PLANTS), "baobab_twigs");

		bones = registerBlock(new BlockGroundCover(Material.ROCK), "bones");
		seashells = registerBlock(new BlockGroundCover(Material.ROCK), "seashells");
		pinecones = registerBlock(new BlockGroundCover(Material.PLANTS), "pinecones");

		cracked_sand = registerBlock(new BlockCrackedSand(), "cracked_sand");
		red_cracked_sand = registerBlock(new BlockCrackedSand(), "red_cracked_sand");

		cobblestone_brick_stairs = registerBlock(new BlockPVJStairs(cobblestone_brick.getDefaultState()), "cobblestone_brick_stairs");
		willow_stairs = registerBlock(new BlockPVJStairs(willow_planks.getDefaultState()), "willow_stairs");
		mangrove_stairs = registerBlock(new BlockPVJStairs(mangrove_planks.getDefaultState()), "mangrove_stairs");
		palm_stairs = registerBlock(new BlockPVJStairs(palm_planks.getDefaultState()), "palm_stairs");
		redwood_stairs = registerBlock(new BlockPVJStairs(redwood_planks.getDefaultState()), "redwood_stairs");
		fir_stairs = registerBlock(new BlockPVJStairs(fir_planks.getDefaultState()), "fir_stairs");
		pine_stairs = registerBlock(new BlockPVJStairs(pine_planks.getDefaultState()), "pine_stairs");
		aspen_stairs = registerBlock(new BlockPVJStairs(aspen_planks.getDefaultState()), "aspen_stairs");
		maple_stairs = registerBlock(new BlockPVJStairs(maple_planks.getDefaultState()), "maple_stairs");
		baobab_stairs = registerBlock(new BlockPVJStairs(baobab_planks.getDefaultState()), "baobab_stairs");
		
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
		
		fir_half_slab = new BlockPVJHalfSlab(fir_planks.getDefaultState(), fir_half_slab);
		fir_double_slab = new BlockPVJDoubleSlab(fir_planks.getDefaultState(), fir_half_slab);
		registerSlab(fir_half_slab, fir_double_slab, "fir_slab", "fir_double_slab");
		
		pine_half_slab = new BlockPVJHalfSlab(pine_planks.getDefaultState(), pine_half_slab);
		pine_double_slab = new BlockPVJDoubleSlab(pine_planks.getDefaultState(), pine_half_slab);
		registerSlab(pine_half_slab, pine_double_slab, "pine_slab", "pine_double_slab");
		
		aspen_half_slab = new BlockPVJHalfSlab(aspen_planks.getDefaultState(), aspen_half_slab);
		aspen_double_slab = new BlockPVJDoubleSlab(aspen_planks.getDefaultState(), aspen_half_slab);
		registerSlab(aspen_half_slab, aspen_double_slab, "aspen_slab", "aspen_double_slab");
		
		maple_half_slab = new BlockPVJHalfSlab(maple_planks.getDefaultState(), maple_half_slab);
		maple_double_slab = new BlockPVJDoubleSlab(maple_planks.getDefaultState(), maple_half_slab);
		registerSlab(maple_half_slab, maple_double_slab, "maple_slab", "maple_double_slab");
		
		baobab_half_slab = new BlockPVJHalfSlab(baobab_planks.getDefaultState(), baobab_half_slab);
		baobab_double_slab = new BlockPVJDoubleSlab(baobab_planks.getDefaultState(), baobab_half_slab);
		registerSlab(baobab_half_slab, baobab_double_slab, "baobab_slab", "baobab_double_slab");
		
		willow_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "willow_pressure_plate");
		mangrove_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "mangrove_pressure_plate");
		palm_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "palm_pressure_plate");
		redwood_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "redwood_pressure_plate");
		fir_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "fir_pressure_plate");
		pine_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "pine_pressure_plate");
		aspen_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "aspen_pressure_plate");
		maple_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "maple_pressure_plate");
		baobab_pressure_plate = registerBlock(new BlockPVJPressurePlate(), "baobab_pressure_plate");
		
		willow_button = registerBlock(new BlockPVJButton(), "willow_button");
		mangrove_button = registerBlock(new BlockPVJButton(), "mangrove_button");
		palm_button = registerBlock(new BlockPVJButton(), "palm_button");
		redwood_button = registerBlock(new BlockPVJButton(), "redwood_button");
		fir_button = registerBlock(new BlockPVJButton(), "fir_button");
		pine_button = registerBlock(new BlockPVJButton(), "pine_button");
		aspen_button = registerBlock(new BlockPVJButton(), "aspen_button");
		maple_button = registerBlock(new BlockPVJButton(), "maple_button");
		baobab_button = registerBlock(new BlockPVJButton(), "baobab_button");
		
		willow_fence = registerBlock(new BlockPVJFence(EnumWoodType.WILLOW), "willow_fence");
		mangrove_fence = registerBlock(new BlockPVJFence(EnumWoodType.MANGROVE), "mangrove_fence");
		palm_fence = registerBlock(new BlockPVJFence(EnumWoodType.PALM), "palm_fence");
		redwood_fence = registerBlock(new BlockPVJFence(EnumWoodType.REDWOOD), "redwood_fence");
		fir_fence = registerBlock(new BlockPVJFence(EnumWoodType.FIR), "fir_fence");
		pine_fence = registerBlock(new BlockPVJFence(EnumWoodType.PINE), "pine_fence");
		aspen_fence = registerBlock(new BlockPVJFence(EnumWoodType.ASPEN), "aspen_fence");
		maple_fence = registerBlock(new BlockPVJFence(EnumWoodType.RED_MAPLE), "maple_fence");
		baobab_fence = registerBlock(new BlockPVJFence(EnumWoodType.BAOBAB), "baobab_fence");
		
		willow_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.WILLOW), "willow_fence_gate");
		mangrove_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.MANGROVE), "mangrove_fence_gate");
		palm_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.PALM), "palm_fence_gate");
		redwood_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.REDWOOD), "redwood_fence_gate");
		fir_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.FIR), "fir_fence_gate");
		pine_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.PINE), "pine_fence_gate");
		aspen_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.ASPEN), "aspen_fence_gate");
		maple_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.RED_MAPLE), "maple_fence_gate");
		baobab_fence_gate = registerBlock(new BlockPVJFenceGate(EnumWoodType.BAOBAB), "baobab_fence_gate");
		
		willow_door = registerDoor(new BlockPVJDoor(EnumWoodType.WILLOW), PVJItems.willow_door, "willow_door");
		mangrove_door = registerDoor(new BlockPVJDoor(EnumWoodType.MANGROVE), PVJItems.mangrove_door, "mangrove_door");
		palm_door = registerDoor(new BlockPVJDoor(EnumWoodType.PALM), PVJItems.palm_door, "palm_door");
		redwood_door = registerDoor(new BlockPVJDoor(EnumWoodType.REDWOOD), PVJItems.redwood_door, "redwood_door");
		fir_door = registerDoor(new BlockPVJDoor(EnumWoodType.FIR), PVJItems.fir_door, "fir_door");
		pine_door = registerDoor(new BlockPVJDoor(EnumWoodType.PINE), PVJItems.pine_door, "pine_door");
		aspen_door = registerDoor(new BlockPVJDoor(EnumWoodType.ASPEN), PVJItems.aspen_door, "aspen_door");
		maple_door = registerDoor(new BlockPVJDoor(EnumWoodType.RED_MAPLE), PVJItems.maple_door, "maple_door");
		baobab_door = registerDoor(new BlockPVJDoor(EnumWoodType.BAOBAB), PVJItems.baobab_door, "baobab_door");
		
		willow_trapdoor = registerBlock(new BlockPVJTrapdoor(), "willow_trapdoor");
		mangrove_trapdoor = registerBlock(new BlockPVJTrapdoor(), "mangrove_trapdoor");
		palm_trapdoor = registerBlock(new BlockPVJTrapdoor(), "palm_trapdoor");
		redwood_trapdoor = registerBlock(new BlockPVJTrapdoor(), "redwood_trapdoor");
		fir_trapdoor = registerBlock(new BlockPVJTrapdoor(), "fir_trapdoor");
		pine_trapdoor = registerBlock(new BlockPVJTrapdoor(), "pine_trapdoor");
		aspen_trapdoor = registerBlock(new BlockPVJTrapdoor(), "aspen_trapdoor");
		maple_trapdoor = registerBlock(new BlockPVJTrapdoor(), "maple_trapdoor");
		baobab_trapdoor = registerBlock(new BlockPVJTrapdoor(), "baobab_trapdoor");
		
		mystical_grill = registerBlock(new BlockMysticalGrill(), "mystical_grill");
		
		cobblestone_chimney = registerBlock(new BlockChimney(), "cobblestone_chimney");
		stone_chimney = registerBlock(new BlockChimney(), "stone_chimney");
		brick_chimney = registerBlock(new BlockChimney(), "brick_chimney");
		stonebrick_chimney = registerBlock(new BlockChimney(), "stonebrick_chimney");
		cobblestone_brick_chimney = registerBlock(new BlockChimney(), "cobblestone_brick_chimney");
		sandstone_chimney = registerBlock(new BlockChimney(), "sandstone_chimney");
		netherbrick_chimney = registerBlock(new BlockChimney(), "netherbrick_chimney");
		
		cobblestone_chimney_top = registerBlock(new BlockChimneyTop(), "cobblestone_chimney_top");
		stone_chimney_top = registerBlock(new BlockChimneyTop(), "stone_chimney_top");
		brick_chimney_top = registerBlock(new BlockChimneyTop(), "brick_chimney_top");
		stonebrick_chimney_top = registerBlock(new BlockChimneyTop(), "stonebrick_chimney_top");
		cobblestone_brick_chimney_top = registerBlock(new BlockChimneyTop(), "cobblestone_brick_chimney_top");
		sandstone_chimney_top = registerBlock(new BlockChimneyTop(), "sandstone_chimney_top");
		netherbrick_chimney_top = registerBlock(new BlockChimneyTop(), "netherbrick_chimney_top");
		
		cobblestone_brick_wall = registerBlock(new BlockCobblestoneBrickWall(), "cobblestone_brick_wall");
		
		wild_wheat = registerBlock(new BlockWildWheat(), "wild_wheat");
		frost_lotus = registerBlock(new BlockPVJPlant(), "frost_lotus");
		silverleaf = registerBlock(new BlockPVJPlant(), "silverleaf");
		
		bloodnettle = registerBlock(new BlockNetherPlant(), "bloodnettle");
		glowcap = registerBlock(new BlockGlowcap(), "glowcap");
		
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
