package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.common.blocks.BeachGrassBlock;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.common.blocks.CoconutBlock;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.FloatingPlantBlock;
import projectvibrantjourneys.common.blocks.GlowcapBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.PVJDoorBlock;
import projectvibrantjourneys.common.blocks.PVJPressurePlateBlock;
import projectvibrantjourneys.common.blocks.PVJSaplingBlock;
import projectvibrantjourneys.common.blocks.PVJTrapDoorBlock;
import projectvibrantjourneys.common.blocks.PVJWoodButtonBlock;
import projectvibrantjourneys.common.blocks.PossessedPumpkinBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.common.blocks.ShortGrassBlock;
import projectvibrantjourneys.common.blocks.SmallCactusBlock;
import projectvibrantjourneys.common.blocks.trees.FirTree;
import projectvibrantjourneys.common.blocks.trees.MangroveTree;
import projectvibrantjourneys.common.blocks.trees.PalmTree;
import projectvibrantjourneys.common.blocks.trees.PineTree;
import projectvibrantjourneys.common.blocks.trees.RedwoodTree;
import projectvibrantjourneys.common.blocks.trees.WillowTree;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder("projectvibrantjourneys")
public class PVJBlocks {

	/* GROUNDCOVERS */
	public static Block oak_twigs, birch_twigs, spruce_twigs, jungle_twigs, dark_oak_twigs, acacia_twigs,
						fir_twigs, pine_twigs, palm_twigs, willow_twigs, mangrove_twigs, redwood_twigs, cottonwood_twigs;
	public static Block  oak_fallen_leaves, birch_fallen_leaves, spruce_fallen_leaves, jungle_fallen_leaves, dark_oak_fallen_leaves, acacia_fallen_leaves,
						fir_fallen_leaves, pine_fallen_leaves, palm_fallen_leaves, willow_fallen_leaves, mangrove_fallen_leaves, redwood_fallen_leaves,
						cottonwood_fallen_leaves;
	public static Block rocks, mossy_rocks, andesite_rocks, granite_rocks, diorite_rocks, sandstone_rocks,
			red_sandstone_rocks, netherrack_rocks, ice_chunks;
	public static Block iron_nugget, gold_nugget, flint;
	public static Block bones, charred_bones;
	public static Block pinecones, seashells;
	public static Block dung;
	
	public static Block possessed_pumpkin;

	public static Block sea_oats;
	public static Block cattail;
	public static Block small_cactus;
	public static Block beach_grass;
	public static Block bark_mushroom;
	public static Block glowcap;
	public static Block short_grass;
	
	public static Block glowcap_block;

	public static Block fir_sapling, fir_log, fir_leaves, fir_planks, stripped_fir_log, fir_wood, stripped_fir_wood,
			fir_sign, fir_wall_sign, fir_pressure_plate, fir_trapdoor, fir_button, fir_slab, fir_fence_gate, fir_fence,
			fir_door, fir_stairs;
	public static Block pine_sapling, pine_log, pine_leaves, pine_planks, stripped_pine_log, pine_wood, stripped_pine_wood,
			pine_sign, pine_wall_sign, pine_pressure_plate, pine_trapdoor, pine_button, pine_slab, pine_fence_gate, pine_fence,
			pine_door, pine_stairs;
	public static Block palm_sapling, palm_log, palm_leaves, palm_planks, stripped_palm_log, palm_wood, stripped_palm_wood,
			palm_sign, palm_wall_sign, palm_pressure_plate, palm_trapdoor, palm_button, palm_slab, palm_fence_gate, palm_fence,
			palm_door, palm_stairs;
	public static Block willow_sapling, willow_log, willow_leaves, willow_planks, stripped_willow_log, willow_wood, stripped_willow_wood,
			willow_sign, willow_wall_sign, willow_pressure_plate, willow_trapdoor, willow_button, willow_slab, willow_fence_gate, willow_fence,
			willow_door, willow_stairs;
	public static Block mangrove_sapling, mangrove_log, mangrove_leaves, mangrove_planks, stripped_mangrove_log, mangrove_wood, stripped_mangrove_wood,
			mangrove_sign, mangrove_wall_sign, mangrove_pressure_plate, mangrove_trapdoor, mangrove_button, mangrove_slab, mangrove_fence_gate, mangrove_fence,
			mangrove_door, mangrove_stairs;
	public static Block redwood_sapling, redwood_log, redwood_leaves, redwood_planks, stripped_redwood_log, redwood_wood, stripped_redwood_wood,
			redwood_sign, redwood_wall_sign, redwood_pressure_plate, redwood_trapdoor, redwood_button, redwood_slab, redwood_fence_gate, redwood_fence,
			redwood_door, redwood_stairs;
	public static Block cottonwood_sapling, cottonwood_log, cottonwood_leaves, cottonwood_planks, stripped_cottonwood_log, cottonwood_wood, stripped_cottonwood_wood,
	cottonwood_sign, cottonwood_wall_sign, cottonwood_pressure_plate, cottonwood_trapdoor, cottonwood_button, cottonwood_slab, cottonwood_fence_gate, cottonwood_fence,
	cottonwood_door, cottonwood_stairs;
	
	public static Block coconut;
	public static Block potted_fir_sapling, potted_pine_sapling, potted_palm_sapling, potted_willow_sapling, potted_mangrove_sapling,
						potted_redwood_sapling, potted_small_cactus, potted_glowcap;

	public static final Block frogbit = null;
	public static final Block duckweed = null;

	@SubscribeEvent
	public static void initBlocks(RegistryEvent.Register<Block> event) {
		oak_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "oak_twigs", 100);
		birch_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "birch_twigs", 100);
		spruce_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "spruce_twigs", 100);
		acacia_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "acacia_twigs", 100);
		dark_oak_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "dark_oak_twigs", 100);
		jungle_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "jungle_twigs", 100);
		fir_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "fir_twigs", 100);
		pine_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "pine_twigs", 100);
		palm_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "palm_twigs", 100);
		willow_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "willow_twigs", 100);
		mangrove_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "mangrove_twigs", 100);
		redwood_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "redwood_twigs", 100);
//		cottonwood_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "cottonwood_twigs", 100);
		
		oak_fallen_leaves = registerBlock(new FallenLeavesBlock(), "oak_fallen_leaves");
		birch_fallen_leaves = registerBlock(new FallenLeavesBlock(), "birch_fallen_leaves");
		spruce_fallen_leaves = registerBlock(new FallenLeavesBlock(), "spruce_fallen_leaves");
		jungle_fallen_leaves = registerBlock(new FallenLeavesBlock(), "jungle_fallen_leaves");
		dark_oak_fallen_leaves = registerBlock(new FallenLeavesBlock(), "dark_oak_fallen_leaves");
		acacia_fallen_leaves = registerBlock(new FallenLeavesBlock(), "acacia_fallen_leaves");
		fir_fallen_leaves = registerBlock(new FallenLeavesBlock(), "fir_fallen_leaves");
		pine_fallen_leaves = registerBlock(new FallenLeavesBlock(), "pine_fallen_leaves");
		palm_fallen_leaves = registerBlock(new FallenLeavesBlock(), "palm_fallen_leaves");
		willow_fallen_leaves = registerBlock(new FallenLeavesBlock(), "willow_fallen_leaves");
		mangrove_fallen_leaves = registerBlock(new FallenLeavesBlock(), "mangrove_fallen_leaves");
		redwood_fallen_leaves = registerBlock(new FallenLeavesBlock(), "redwood_fallen_leaves");
//		cottonwood_fallen_leaves = registerBlock(new FallenLeavesBlock(), "cottonwood_fallen_leaves");
		
		rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "stone_rocks");
		mossy_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "mossy_rocks");
		andesite_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "andesite_rocks");
		granite_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "granite_rocks");
		diorite_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "diorite_rocks");
		sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "red_sandstone_rocks");
		netherrack_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "netherrack_rocks");
		ice_chunks = registerBlock(new GroundcoverBlock(Material.ICE, GroundcoverBlock.Type.ROCKS, SoundType.GLASS), "ice_chunks");
		
		iron_nugget = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.IRON_NUGGET), "iron_nugget");
		gold_nugget = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.GOLD_NUGGET), "gold_nugget");
		flint = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.FLINT), "flint");
		
		bones = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.BONES), "bones");
		charred_bones = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.BONES), "charred_bones");
		
		pinecones = registerBlock(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.PINECONES), "pinecones");
		seashells = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.SEASHELLS), "seashells");
		
		dung = registerBlock(new GroundcoverBlock(Material.EARTH, GroundcoverBlock.Type.DUNG), "dung");
		
		sea_oats = registerBlock(new SeaOatsBlock(), "sea_oats");
		cattail = registerBlock(new CattailBlock(), "cattail");
		small_cactus = registerBlock(new SmallCactusBlock(), "small_cactus");
		beach_grass = registerBlock(new BeachGrassBlock(), "beach_grass");
		bark_mushroom = registerBlock(new BarkMushroomBlock(), "bark_mushroom");
		registerBlockWithoutItem(new FloatingPlantBlock(), "frogbit");
		registerBlockWithoutItem(new FloatingPlantBlock(), "duckweed");
		glowcap = registerBlock(new GlowcapBlock(), "glowcap");
		short_grass  = registerBlock(new ShortGrassBlock(), "short_grass");
		
		possessed_pumpkin = registerBlock(new PossessedPumpkinBlock(), "possessed_pumpkin");
		
		glowcap_block = registerBlock(new HugeMushroomBlock(Block.Properties.create(Material.WOOD, MaterialColor.YELLOW).hardnessAndResistance(0.2F).lightValue(12).sound(SoundType.WOOD)), "glowcap_block");
		
		potted_fir_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> fir_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_fir_sapling");
		potted_pine_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> pine_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_pine_sapling");
		potted_palm_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> palm_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_palm_sapling");
		potted_willow_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> willow_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_willow_sapling");
		potted_mangrove_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> mangrove_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_mangrove_sapling");
		potted_redwood_sapling = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> redwood_sapling, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_redwood_sapling");
		potted_glowcap = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> glowcap, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).lightValue(10).notSolid()), "potted_glowcap");
		potted_small_cactus = registerBlockWithoutItem(new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> small_cactus, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()), "potted_small_cactus");
		
		fir_log = registerBlock(new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "fir_log");
		fir_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "fir_leaves");
		fir_sapling = registerBlock(new PVJSaplingBlock(new FirTree()), "fir_sapling");
		fir_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "fir_planks");
		stripped_fir_log = registerBlock(new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_fir_log");
		fir_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "fir_wood");
		stripped_fir_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_fir_wood");
		fir_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "fir_pressure_plate");
		fir_stairs = registerBlockWithFuel(new StairsBlock(() -> fir_planks.getDefaultState(), Block.Properties.from(fir_planks)), "fir_stairs", 300);
		fir_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "fir_trapdoor");
		fir_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "fir_button");
		fir_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "fir_slab");
		fir_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "fir_fence_gate");
		fir_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "fir_fence");
		fir_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "fir_door");
		
//		fir_sign = registerBlockWithoutItem(new StandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.field_227038_a_), "fir_sign");
//		fir_wall_sign = registerBlockWithoutItem(new WallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.field_227038_a_), "fir_wall_sign");
		
		pine_log = registerBlock(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "pine_log");
		pine_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "pine_leaves");
		pine_sapling = registerBlock(new PVJSaplingBlock(new PineTree()), "pine_sapling");
		pine_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "pine_planks");
		stripped_pine_log = registerBlock(new LogBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_pine_log");
		pine_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "pine_wood");
		stripped_pine_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_pine_wood");
		pine_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "pine_pressure_plate");
		pine_stairs = registerBlockWithFuel(new StairsBlock(() -> pine_planks.getDefaultState(), Block.Properties.from(pine_planks)), "pine_stairs", 300);
		pine_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "pine_trapdoor");
		pine_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "pine_button");
		pine_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "pine_slab");
		pine_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "pine_fence_gate");
		pine_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "pine_fence");
		pine_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "pine_door");

		palm_log = registerBlock(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "palm_log");
		palm_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "palm_leaves");
		palm_sapling = registerBlock(new PVJSaplingBlock(new PalmTree()), "palm_sapling");
		palm_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "palm_planks");
		stripped_palm_log = registerBlock(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_palm_log");
		palm_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "palm_wood");
		stripped_palm_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_palm_wood");
		palm_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "palm_pressure_plate");
		palm_stairs = registerBlockWithFuel(new StairsBlock(() -> palm_planks.getDefaultState(), Block.Properties.from(palm_planks)), "palm_stairs", 300);
		palm_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "palm_trapdoor");
		palm_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "palm_button");
		palm_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "palm_slab");
		palm_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "palm_fence_gate");
		palm_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "palm_fence");
		palm_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "palm_door");
		coconut = registerBlock(new CoconutBlock(), "coconut"); 	
		
		willow_log = registerBlock(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "willow_log");
		willow_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "willow_leaves");
		willow_sapling = registerBlock(new PVJSaplingBlock(new WillowTree()), "willow_sapling");
		willow_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "willow_planks");
		stripped_willow_log = registerBlock(new LogBlock(MaterialColor.GRAY, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_willow_log");
		willow_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "willow_wood");
		stripped_willow_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_willow_wood");
		willow_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "willow_pressure_plate");
		willow_stairs = registerBlockWithFuel(new StairsBlock(() -> willow_planks.getDefaultState(), Block.Properties.from(willow_planks)), "willow_stairs", 300);
		willow_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "willow_trapdoor");
		willow_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "willow_button");
		willow_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "willow_slab");
		willow_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "willow_fence_gate");
		willow_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "willow_fence");
		willow_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "willow_door");
		
		mangrove_log = registerBlock(new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "mangrove_log");
		mangrove_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "mangrove_leaves");
		mangrove_sapling = registerBlock(new PVJSaplingBlock(new MangroveTree()), "mangrove_sapling");
		mangrove_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "mangrove_planks");
		stripped_mangrove_log = registerBlock(new LogBlock(MaterialColor.GRAY, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_mangrove_log");
		mangrove_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "mangrove_wood");
		stripped_mangrove_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_mangrove_wood");
		mangrove_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.GRAY).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "mangrove_pressure_plate");
		mangrove_stairs = registerBlockWithFuel(new StairsBlock(() -> mangrove_planks.getDefaultState(), Block.Properties.from(mangrove_planks)), "mangrove_stairs", 300);
		mangrove_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "mangrove_trapdoor");
		mangrove_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "mangrove_button");
		mangrove_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "mangrove_slab");
		mangrove_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "mangrove_fence_gate");
		mangrove_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "mangrove_fence");
		mangrove_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "mangrove_door");
		
		redwood_log = registerBlock(new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "redwood_log");
		redwood_leaves = registerBlock(new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), "redwood_leaves");
		redwood_sapling = registerBlock(new PVJSaplingBlock(new RedwoodTree()), "redwood_sapling");
		redwood_planks = registerBlock(new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "redwood_planks");
		stripped_redwood_log = registerBlock(new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_redwood_log");
		redwood_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "redwood_wood");
		stripped_redwood_wood = registerBlock(new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), "stripped_redwood_wood");
		redwood_pressure_plate = registerBlock(new PVJPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "redwood_pressure_plate");
		redwood_stairs = registerBlockWithFuel(new StairsBlock(() -> redwood_planks.getDefaultState(), Block.Properties.from(redwood_planks)), "redwood_stairs", 300);
		redwood_trapdoor = registerBlock(new PVJTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "redwood_trapdoor");
		redwood_button = registerBlock(new PVJWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), "redwood_button");
		redwood_slab = registerBlock(new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "redwood_slab");
		redwood_fence_gate = registerBlock(new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "redwood_fence_gate");
		redwood_fence = registerBlock(new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), "redwood_fence");
		redwood_door = registerBlockWithoutItem(new PVJDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), "redwood_door");
	}

	public static Block registerBlock(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		Item.Properties prop = new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP);
		BlockItem item = new BlockItem(block, prop);
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(item);

		return block;
	}

	public static Block registerBlockWithoutItem(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.BLOCKS.register(block);

		return block;
	}

	// lol whatever
	public static Block registerBlockWithFuel(Block block, String name, int burnTime) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		Item.Properties prop = new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP);
		BlockItem item = new BlockItem(block, prop) {
			@Override
			public int getBurnTime(ItemStack stack) {
				return burnTime;
			}
		};
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(item);

		return block;
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderType cutout = RenderType.getCutout();
		RenderType cutout_mipped = RenderType.getCutoutMipped();
		
		RenderTypeLookup.setRenderLayer(oak_twigs, cutout);
		RenderTypeLookup.setRenderLayer(birch_twigs, cutout);
		RenderTypeLookup.setRenderLayer(spruce_twigs, cutout);
		RenderTypeLookup.setRenderLayer(acacia_twigs, cutout);
		RenderTypeLookup.setRenderLayer(dark_oak_twigs, cutout);
		RenderTypeLookup.setRenderLayer(jungle_twigs, cutout);
		RenderTypeLookup.setRenderLayer(fir_twigs, cutout);
		RenderTypeLookup.setRenderLayer(pine_twigs, cutout);
		RenderTypeLookup.setRenderLayer(palm_twigs, cutout);
		RenderTypeLookup.setRenderLayer(willow_twigs, cutout);
		RenderTypeLookup.setRenderLayer(mangrove_twigs, cutout);
		RenderTypeLookup.setRenderLayer(redwood_twigs, cutout);
		RenderTypeLookup.setRenderLayer(rocks, cutout);
		RenderTypeLookup.setRenderLayer(mossy_rocks, cutout);
		RenderTypeLookup.setRenderLayer(andesite_rocks, cutout);
		RenderTypeLookup.setRenderLayer(diorite_rocks, cutout);
		RenderTypeLookup.setRenderLayer(granite_rocks, cutout);
		RenderTypeLookup.setRenderLayer(sandstone_rocks, cutout);
		RenderTypeLookup.setRenderLayer(red_sandstone_rocks, cutout);
		RenderTypeLookup.setRenderLayer(netherrack_rocks, cutout);
		RenderTypeLookup.setRenderLayer(ice_chunks, cutout);
		RenderTypeLookup.setRenderLayer(bones, cutout);
		RenderTypeLookup.setRenderLayer(charred_bones, cutout);
		RenderTypeLookup.setRenderLayer(pinecones, cutout);
		RenderTypeLookup.setRenderLayer(seashells, cutout);
		RenderTypeLookup.setRenderLayer(dung, cutout);
		RenderTypeLookup.setRenderLayer(bark_mushroom, cutout);
		RenderTypeLookup.setRenderLayer(frogbit, cutout);
		RenderTypeLookup.setRenderLayer(duckweed, cutout);
		RenderTypeLookup.setRenderLayer(fir_door, cutout);
		RenderTypeLookup.setRenderLayer(fir_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(pine_door, cutout);
		RenderTypeLookup.setRenderLayer(pine_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(palm_door, cutout);
		RenderTypeLookup.setRenderLayer(palm_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(willow_door, cutout);
		RenderTypeLookup.setRenderLayer(willow_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(mangrove_door, cutout);
		RenderTypeLookup.setRenderLayer(mangrove_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(redwood_door, cutout);
		RenderTypeLookup.setRenderLayer(redwood_trapdoor, cutout);
		RenderTypeLookup.setRenderLayer(potted_fir_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_pine_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_palm_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_willow_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_mangrove_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_redwood_sapling, cutout);
		RenderTypeLookup.setRenderLayer(potted_glowcap, cutout);
		RenderTypeLookup.setRenderLayer(potted_small_cactus, cutout);

		RenderTypeLookup.setRenderLayer(oak_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(birch_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(spruce_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(acacia_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(dark_oak_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(jungle_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(fir_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(pine_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(palm_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(willow_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(mangrove_fallen_leaves, cutout_mipped);
		RenderTypeLookup.setRenderLayer(redwood_fallen_leaves, cutout_mipped);

		RenderTypeLookup.setRenderLayer(sea_oats, cutout_mipped);
		RenderTypeLookup.setRenderLayer(cattail, cutout_mipped);
		RenderTypeLookup.setRenderLayer(small_cactus, cutout_mipped);
		RenderTypeLookup.setRenderLayer(beach_grass, cutout_mipped);
		RenderTypeLookup.setRenderLayer(glowcap, cutout_mipped);
		RenderTypeLookup.setRenderLayer(short_grass, cutout_mipped);

		RenderTypeLookup.setRenderLayer(fir_sapling, cutout_mipped);
		RenderTypeLookup.setRenderLayer(pine_sapling, cutout_mipped);
		RenderTypeLookup.setRenderLayer(palm_sapling, cutout_mipped);
		RenderTypeLookup.setRenderLayer(willow_sapling, cutout_mipped);
		RenderTypeLookup.setRenderLayer(mangrove_sapling, cutout_mipped);
		RenderTypeLookup.setRenderLayer(redwood_sapling, cutout_mipped);

		RenderTypeLookup.setRenderLayer(iron_nugget, cutout_mipped);
		RenderTypeLookup.setRenderLayer(gold_nugget, cutout_mipped);
		RenderTypeLookup.setRenderLayer(flint, cutout_mipped);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerColors() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		registerFoliageColorBlock(blockColors, oak_twigs);
		registerFoliageColorBlock(blockColors, birch_twigs, FoliageColors.getBirch());
		registerFoliageColorBlock(blockColors, spruce_twigs, FoliageColors.getSpruce());
		registerFoliageColorBlock(blockColors, jungle_twigs);
		registerFoliageColorBlock(blockColors, dark_oak_twigs);
		registerFoliageColorBlock(blockColors, acacia_twigs);
		registerFoliageColorBlock(blockColors, oak_fallen_leaves);
		registerFoliageColorBlock(blockColors, birch_fallen_leaves, FoliageColors.getBirch());
		registerFoliageColorBlock(blockColors, spruce_fallen_leaves, FoliageColors.getSpruce());
		registerFoliageColorBlock(blockColors, jungle_fallen_leaves);
		registerFoliageColorBlock(blockColors, dark_oak_fallen_leaves);
		registerFoliageColorBlock(blockColors, acacia_fallen_leaves);
		registerGrassColorBlock(blockColors, short_grass);

		registerFoliageColorItem(itemColors, blockColors, oak_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, birch_fallen_leaves, FoliageColors.getBirch());
		registerFoliageColorItem(itemColors, blockColors, spruce_fallen_leaves, FoliageColors.getSpruce());
		registerFoliageColorItem(itemColors, blockColors, jungle_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, dark_oak_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, acacia_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, short_grass);
	}

	private static void registerFoliageColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getFoliageColor(world, pos)
				: FoliageColors.getDefault(), block);
	}

	private static void registerFoliageColorBlock(BlockColors bc, Block block, int color) {
		bc.register((state, world, pos, tintIndex) -> color, block);
	}

	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block) {
		ic.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.getDefaultState();
			int color = bc.getColor(state, null, null, tintIndex); // get color
			return color;
		}, block);
	}

	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block, int color) {
		ic.register((itemstack, tintIndex) -> color, block);
	}

	private static void registerGrassColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.getGrassColor(world, pos)
				: GrassColors.get(0.5D, 1.0D), block);
	}
}
