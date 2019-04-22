package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;
import vibrantjourneys.ProjectVibrantJourneys;
import vibrantjourneys.blocks.BlockCobblestoneBrickWall;
import vibrantjourneys.blocks.BlockCoconut;
import vibrantjourneys.blocks.BlockCrackedSand;
import vibrantjourneys.blocks.BlockFallenLeaves;
import vibrantjourneys.blocks.BlockGroundCover;
import vibrantjourneys.blocks.BlockGroundCover.GroundcoverType;
import vibrantjourneys.blocks.BlockMud;
import vibrantjourneys.blocks.BlockMysticalGrill;
import vibrantjourneys.blocks.BlockPVJCobweb;
import vibrantjourneys.blocks.BlockRockFormation;
import vibrantjourneys.blocks.BlockStoneBlock;
import vibrantjourneys.blocks.BlockWetAdobe;
import vibrantjourneys.blocks.plant.BlockBeachGrass;
import vibrantjourneys.blocks.plant.BlockBracketFungus;
import vibrantjourneys.blocks.plant.BlockCattail;
import vibrantjourneys.blocks.plant.BlockFloatingPlant;
import vibrantjourneys.blocks.plant.BlockFlouropore;
import vibrantjourneys.blocks.plant.BlockGlowcap;
import vibrantjourneys.blocks.plant.BlockNetherPlant;
import vibrantjourneys.blocks.plant.BlockPVJCactus;
import vibrantjourneys.blocks.plant.BlockPVJMushroom;
import vibrantjourneys.blocks.plant.BlockPVJPlant;
import vibrantjourneys.blocks.plant.BlockSeaOats;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.blocks.plant.BlockVoidGrass;
import vibrantjourneys.blocks.plant.BlockWeed;
import vibrantjourneys.blocks.plant.BlockWildCrop;
import vibrantjourneys.blocks.plant.BlockWitherweed;
import vibrantjourneys.blocks.wood.BlockBark;
import vibrantjourneys.blocks.wood.BlockPVJButton;
import vibrantjourneys.blocks.wood.BlockPVJDoor;
import vibrantjourneys.blocks.wood.BlockPVJDoubleSlab;
import vibrantjourneys.blocks.wood.BlockPVJFence;
import vibrantjourneys.blocks.wood.BlockPVJFenceGate;
import vibrantjourneys.blocks.wood.BlockPVJHalfSlab;
import vibrantjourneys.blocks.wood.BlockPVJLeaves;
import vibrantjourneys.blocks.wood.BlockPVJLog;
import vibrantjourneys.blocks.wood.BlockPVJPlanks;
import vibrantjourneys.blocks.wood.BlockPVJPressurePlate;
import vibrantjourneys.blocks.wood.BlockPVJSapling;
import vibrantjourneys.blocks.wood.BlockPVJStairs;
import vibrantjourneys.blocks.wood.BlockPVJTrapdoor;
import vibrantjourneys.integration.biomesoplenty.PVJBlocksBOP;
import vibrantjourneys.integration.traverse.PVJBlocksTraverse;
import vibrantjourneys.items.ItemBracketFungus;
import vibrantjourneys.items.ItemCoconut;
import vibrantjourneys.items.ItemFloatingPlant;
import vibrantjourneys.items.ItemPVJBlock;
import vibrantjourneys.items.ItemPVJSlab;
import vibrantjourneys.util.CreativeTabPVJ;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumStoneType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;

public class PVJBlocks
{
	public static final ArrayList<Block> BLOCKS = new ArrayList<Block>();
	public static final ArrayList<Block> LOGS = new ArrayList<Block>();
	public static final ArrayList<Block> LEAVES = new ArrayList<Block>();
	public static final ArrayList<Block> SAPLINGS = new ArrayList<Block>();
	public static final ArrayList<Block> PLANKS = new ArrayList<Block>();
	public static final ArrayList<Block> STAIRS = new ArrayList<Block>();
	public static final ArrayList<Block> SLABS = new ArrayList<Block>();
	public static final ArrayList<Block> FENCES = new ArrayList<Block>();
	public static final ArrayList<Block> FENCE_GATES = new ArrayList<Block>();
	public static final ArrayList<Block> DOORS = new ArrayList<Block>();
	public static final ArrayList<Block> TRAPDOORS = new ArrayList<Block>();
	public static final ArrayList<Block> BUTTONS = new ArrayList<Block>();
	public static final ArrayList<Block> PRESSURE_PLATES = new ArrayList<Block>();
	public static final ArrayList<Block> FALLEN_LEAVES = new ArrayList<Block>();
	public static final ArrayList<Block> TWIGS = new ArrayList<Block>();
	
	public static final ArrayList<Block> STONES = new ArrayList<Block>();
	
	//1.13: add bark/ stripped bark
	//1.13: mangrove saplings can be waterlogged
	
	public static Block coconut;
	
	public static Block pvj_cobweb;
	
	public static Block fallenleaves_oak, fallenleaves_birch, fallenleaves_spruce, fallenleaves_jungle, fallenleaves_darkoak,
						fallenleaves_acacia, fallenleaves_dead;
	
	//1.13: allow waterlogged
	public static Block stone_rocks, cobblestone_rocks, mossy_cobblestone_rocks, andesite_rocks, granite_rocks, diorite_rocks, sandstone_rocks,
						red_sandstone_rocks;
	
	public static Block oak_twigs, birch_twigs, spruce_twigs, jungle_twigs, acacia_twigs, dark_oak_twigs;
	public static Block bones;
	public static Block seashells;
	public static Block pinecones;
	public static Block flower_patch;
	
	public static Block cracked_sand, red_cracked_sand;
	public static Block wet_adobe;
	public static Block mud;

	public static Block short_grass;
	public static Block wild_wheat, wild_potato, wild_carrot, wild_beetroot;
	public static Block frost_lotus;
	public static Block silverleaf;
	public static Block frogbit, duckweed;
	public static Block chickweed, clovers, crabgrass;
	public static Block small_cactus;
	public static Block bracket_fungus;
	public static Block flouropore;
	public static Block waxcap, orange_mushroom, deathcap;
	public static Block cattail;
	public static Block sundew;
	public static Block beach_grass;
	public static Block sea_oats;
	public static Block void_grass;
	
	public static Block bloodnettle;
	public static Block glowcap;
	public static Block witherweed;
	
	public static Block rock_formation, ice_formation;
	
	public static Block aquamarine_ore, aquamarine_block;
	
	public static Block mystical_grill;
	
	public static Block cobblestone_brick_wall;
	
	public static Block redwood_bark;
	
	public static void initBlocks()
	{
		short_grass = registerBlock(new BlockShortGrass(), "short_grass");
		frost_lotus = registerBlock(new BlockPVJPlant(), "frost_lotus");
		silverleaf = registerBlock(new BlockPVJPlant(), "silverleaf");
		chickweed = registerBlock(new BlockWeed(), "chickweed");
		clovers = registerBlock(new BlockWeed(), "clovers");
		crabgrass = registerBlock(new BlockWeed(), "crabgrass");
		bracket_fungus = new BlockBracketFungus();
		registerBlockWithItem(bracket_fungus, "bracket_fungus", new ItemBracketFungus(bracket_fungus, false));
		flouropore = new BlockFlouropore();
		registerBlockWithItem(flouropore, "flouropore", new ItemBracketFungus(flouropore, true));
		frogbit = new BlockFloatingPlant();
		registerBlockWithItem(frogbit, "frogbit", new ItemFloatingPlant(frogbit));
		duckweed = new BlockFloatingPlant();
		registerBlockWithItem(duckweed, "duckweed", new ItemFloatingPlant(duckweed));
		waxcap = registerBlock(new BlockPVJMushroom(), "waxcap");
		orange_mushroom = registerBlock(new BlockPVJMushroom(), "orange_mushroom");
		deathcap = registerBlock(new BlockPVJMushroom(), "deathcap");
		cattail = registerBlock(new BlockCattail(), "cattail");
		beach_grass = registerBlock(new BlockBeachGrass(), "beach_grass");
		sea_oats = registerBlock(new BlockSeaOats(), "sea_oats");
		sundew = registerBlock(new BlockPVJPlant(), "sundew");
		small_cactus = registerBlock(new BlockPVJCactus(), "small_cactus");
		void_grass = registerBlock(new BlockVoidGrass(), "void_grass");
		
		wild_wheat = registerBlock(new BlockWildCrop(Items.WHEAT), "wild_wheat");
		wild_potato = registerBlock(new BlockWildCrop(Items.POTATO), "wild_potato");
		wild_carrot = registerBlock(new BlockWildCrop(Items.CARROT), "wild_carrot");
		wild_beetroot = registerBlock(new BlockWildCrop(Items.BEETROOT), "wild_beetroot");

		bloodnettle = registerBlock(new BlockNetherPlant(), "bloodnettle");
		glowcap = registerBlock(new BlockGlowcap(), "glowcap");
		witherweed = registerBlock(new BlockWitherweed(), "witherweed");
		
		//separate loops to keep the creative inventory neat
		for(EnumWoodType woodType : EnumWoodType.values())
			LOGS.add(registerBlock(new BlockPVJLog(), "log_" + woodType.getName()));
		
		for(EnumLeafType leafType : EnumLeafType.values())
			LEAVES.add(registerBlock(new BlockPVJLeaves(leafType), "leaves_" + leafType.getName()));
		
		for(EnumLeafType leafType : EnumLeafType.values())
			SAPLINGS.add(registerBlock(new BlockPVJSapling(leafType), "sapling_" + leafType.getName()));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			PLANKS.add(registerBlock(new BlockPVJPlanks(), "planks_" + woodType.getName()));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			STAIRS.add(registerBlock(new BlockPVJStairs(PLANKS.get(woodType.getID()).getDefaultState()), woodType.getName() + "_stairs"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
		{
			BlockPVJHalfSlab slab1 = new BlockPVJHalfSlab(PLANKS.get(woodType.getID()).getDefaultState());
			BlockPVJDoubleSlab slab2 = new BlockPVJDoubleSlab(PLANKS.get(woodType.getID()).getDefaultState(), slab1);
			
			registerSlab(slab1, slab2, woodType.getName()+ "_slab", woodType.getName() + "_double_slab");
			
			SLABS.add(slab1);
		}

		for(EnumWoodType woodType : EnumWoodType.values())
			FENCES.add(registerBlock(new BlockPVJFence(), woodType.getName() + "_fence"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			FENCE_GATES.add(registerBlock(new BlockPVJFenceGate(), woodType.getName() + "_fence_gate"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			DOORS.add(registerDoor(new BlockPVJDoor(), woodType.getName() + "_door"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			TRAPDOORS.add(registerBlock(new BlockPVJTrapdoor(), woodType.getName() + "_trapdoor"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			BUTTONS.add(registerBlock(new BlockPVJButton(), woodType.getName() + "_button"));
		
		for(EnumWoodType woodType : EnumWoodType.values())
			PRESSURE_PLATES.add(registerBlock(new BlockPVJPressurePlate(), woodType.getName() + "_pressure_plate"));
		
		redwood_bark = registerBlock(new BlockBark(LOGS.get(EnumWoodType.REDWOOD.getID())), "redwood_bark");

		fallenleaves_oak = registerBlock(new BlockFallenLeaves(), "fallenleaves_oak");
		fallenleaves_birch = registerBlock(new BlockFallenLeaves(), "fallenleaves_birch");
		fallenleaves_spruce = registerBlock(new BlockFallenLeaves(), "fallenleaves_spruce");
		fallenleaves_jungle = registerBlock(new BlockFallenLeaves(), "fallenleaves_jungle");
		fallenleaves_darkoak = registerBlock(new BlockFallenLeaves(), "fallenleaves_darkoak");
		fallenleaves_acacia = registerBlock(new BlockFallenLeaves(), "fallenleaves_acacia");
		fallenleaves_dead = registerBlock(new BlockFallenLeaves(), "fallenleaves_dead");
		
		for(EnumLeafType leafType : EnumLeafType.values())
			FALLEN_LEAVES.add(registerBlock(new BlockFallenLeaves(), "fallenleaves_" + leafType.getName()));	
		
		oak_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "oak_twigs");
		birch_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "birch_twigs");
		spruce_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "spruce_twigs");
		jungle_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "jungle_twigs");
		acacia_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "acacia_twigs");
		dark_oak_twigs = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), "dark_oak_twigs");
		
		for(EnumLeafType leafType : EnumLeafType.values())
			TWIGS.add(registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.TWIGS), leafType.getName() + "_twigs"));

		coconut = new BlockCoconut();
		registerBlockWithItem(coconut, "coconut", new ItemCoconut(coconut));

		stone_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "stone_rocks");
		cobblestone_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "cobblestone_rocks");
		mossy_cobblestone_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "mossy_cobblestone_rocks");
		andesite_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "andesite_rocks");
		granite_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "granite_rocks");
		diorite_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "diorite_rocks");
		sandstone_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.ROCKS), "red_sandstone_rocks");

		bones = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.BONES), "bones");
		seashells = registerBlock(new BlockGroundCover(Material.ROCK, GroundcoverType.SEASHELLS), "seashells");
		pinecones = registerBlock(new BlockGroundCover(Material.PLANTS, GroundcoverType.PINECONES), "pinecones");
		flower_patch = registerBlock(new BlockGroundCover(Material.VINE, GroundcoverType.FLOWER_PATCH), "flower_patch");

		cracked_sand = registerBlock(new BlockCrackedSand(), "cracked_sand");
		red_cracked_sand = registerBlock(new BlockCrackedSand(), "red_cracked_sand");
		
		mud = registerBlock(new BlockMud(), "mud");
		
		if(PVJConfig.master.enableStoneTypeBlocks)
		{
			wet_adobe = registerBlock(new BlockWetAdobe(), "wet_adobe");
			
			for(EnumStoneType stone : EnumStoneType.values())
				STONES.add(registerBlock(new BlockStoneBlock(stone.getHardness(), stone.getResistance(), stone.getMapColor()), stone.getName()));
			
			for(EnumStoneType stone : EnumStoneType.values())
				STAIRS.add(registerBlock(new BlockPVJStairs(STONES.get(stone.getID()).getDefaultState()), stone.getName() + "_stairs"));

			for(EnumStoneType stone : EnumStoneType.values())
			{
				BlockPVJHalfSlab slab1 = new BlockPVJHalfSlab(STONES.get(stone.getID()).getDefaultState());
				BlockPVJDoubleSlab slab2 = new BlockPVJDoubleSlab(STONES.get(stone.getID()).getDefaultState(), slab1);
				
				registerSlab(slab1, slab2, stone.getName()+ "_slab", stone.getName() + "_double_slab");
				
				SLABS.add(slab1);
			}
			
			cobblestone_brick_wall = registerBlock(new BlockCobblestoneBrickWall(), "cobblestone_brick_wall");
		}
		else
			ProjectVibrantJourneys.logger.info("Stone blocks disabled, skipping");
		
		/*if(PVJConfig.master.enableAquamarine)
		{
			aquamarine_ore = registerBlock(new BlockPVJOre(3.0F, 5.0F, PVJItems.aquamarine), "aquamarine_ore");
			aquamarine_block = registerBlock(new BlockStoneBlock(3.0F, 7.0F, MapColor.LIGHT_BLUE), "aquamarine_block");
		}*/
		
		if(PVJConfig.master.enableMysticalGrill)
		{
			mystical_grill = registerBlock(new BlockMysticalGrill(), "mystical_grill");
		}
		else
			ProjectVibrantJourneys.logger.info("Mystical grill disabled, skipping");
		
		rock_formation = registerBlock(new BlockRockFormation(), "rock_formation");
		ice_formation = registerBlock(new BlockRockFormation(), "ice_formation");
		
		pvj_cobweb = registerBlock(new BlockPVJCobweb(), "pvj_cobweb");
		
		if(Reference.isBOPLoaded)
			PVJBlocksBOP.initBOPBlocks();
		
		if(Reference.isTraverseLoaded)
			PVJBlocksTraverse.initTraverseBlocks();
	}
	
	public static Block registerBlock(Block block, String name)
	{
		block.setTranslationKey(name);
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
		block.setTranslationKey(name);
		block.setCreativeTab(CreativeTabPVJ.instance);
		
		block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		BLOCKS.add(block);
		
		itemblock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		PVJItems.ITEMS.add(itemblock);
		
		return block;
	}
	
	//Doors must be registered alongside its item 
	public static Block registerDoor(BlockPVJDoor door, String name)
	{
		door = (BlockPVJDoor) registerBlock(door, name);
		door.setCreativeTab(null);
		
		Item item = PVJItems.registerItem(new ItemDoor(door), name + "_item");
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
