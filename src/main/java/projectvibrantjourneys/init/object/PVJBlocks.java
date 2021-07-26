package projectvibrantjourneys.init.object;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.common.blocks.BeachGrassBlock;
import projectvibrantjourneys.common.blocks.BerriedJuniperLeavesBlock;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.common.blocks.CindercaneBlock;
import projectvibrantjourneys.common.blocks.CoconutBlock;
import projectvibrantjourneys.common.blocks.DryGrassBlock;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GlowcapBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.JuniperSaplingBlock;
import projectvibrantjourneys.common.blocks.MangroveSaplingBlock;
import projectvibrantjourneys.common.blocks.NaturalCobwebBlock;
import projectvibrantjourneys.common.blocks.NetherPlantBlock;
import projectvibrantjourneys.common.blocks.PVJTallGrassBlock;
import projectvibrantjourneys.common.blocks.SandySaplingBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.common.blocks.ShortGrassBlock;
import projectvibrantjourneys.common.blocks.trees.AspenTree;
import projectvibrantjourneys.common.blocks.trees.BaobabTree;
import projectvibrantjourneys.common.blocks.trees.CottonwoodTree;
import projectvibrantjourneys.common.blocks.trees.FirTree;
import projectvibrantjourneys.common.blocks.trees.JoshuaTree;
import projectvibrantjourneys.common.blocks.trees.JuniperTree;
import projectvibrantjourneys.common.blocks.trees.MangroveTree;
import projectvibrantjourneys.common.blocks.trees.OrangeMapleTree;
import projectvibrantjourneys.common.blocks.trees.PalmTree;
import projectvibrantjourneys.common.blocks.trees.PineTree;
import projectvibrantjourneys.common.blocks.trees.PinkSakuraTree;
import projectvibrantjourneys.common.blocks.trees.PurpleMapleTree;
import projectvibrantjourneys.common.blocks.trees.RedMapleTree;
import projectvibrantjourneys.common.blocks.trees.RedwoodTree;
import projectvibrantjourneys.common.blocks.trees.TamarackTree;
import projectvibrantjourneys.common.blocks.trees.WhiteSakuraTree;
import projectvibrantjourneys.common.blocks.trees.WillowTree;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.PVJItemGroup;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBlocks {
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	/* GROUNDCOVERS */
	public static Block twigs, fallen_leaves, rocks, mossy_rocks, sandstone_rocks, red_sandstone_rocks, ice_chunks, bones, charred_bones, pinecones, seashells;
	public static Block aspen_fallen_leaves, red_maple_fallen_leaves, orange_maple_fallen_leaves, purple_maple_fallen_leaves, pink_sakura_fallen_leaves, white_sakura_fallen_leaves;
	
	public static Block sea_oats;
	public static Block cattail;
	public static Block bark_mushroom;
	public static Block natural_cobweb;
	public static Block glowcap;
	public static Block crimson_nettle, warped_nettle, cindercane;
	public static Block short_grass, beach_grass, prairie_grass, dry_grass;
	public static Block wildflowers, desert_sage, desert_agave, blooming_desert_agave;
	public static Block coconut;
	
	public static Block slime_geyser;
	
	public static Block fir_sapling, fir_log, fir_leaves, fir_planks, stripped_fir_log, fir_wood, stripped_fir_wood,
			fir_sign, fir_wall_sign, fir_pressure_plate, fir_trapdoor, fir_button, fir_slab, fir_fence_gate, fir_fence,
			fir_door, fir_stairs;

	public static Block pine_sapling, pine_log, pine_leaves, pine_planks, stripped_pine_log, pine_wood,
			stripped_pine_wood, pine_sign, pine_wall_sign, pine_pressure_plate, pine_trapdoor, pine_button, pine_slab,
			pine_fence_gate, pine_fence, pine_door, pine_stairs;

	public static Block redwood_sapling, redwood_log, redwood_leaves, redwood_planks, stripped_redwood_log,
			redwood_wood, stripped_redwood_wood, redwood_sign, redwood_wall_sign, redwood_pressure_plate,
			redwood_trapdoor, redwood_button, redwood_slab, redwood_fence_gate, redwood_fence, redwood_door,
			redwood_stairs;
	
	public static Block willow_sapling, willow_log, willow_leaves, willow_planks, stripped_willow_log, willow_wood,
			stripped_willow_wood, willow_sign, willow_wall_sign, willow_pressure_plate, willow_trapdoor, willow_button,
			willow_slab, willow_fence_gate, willow_fence, willow_door, willow_stairs;

	public static Block mangrove_sapling, mangrove_log, mangrove_leaves, mangrove_planks, stripped_mangrove_log,
			mangrove_wood, stripped_mangrove_wood, mangrove_sign, mangrove_wall_sign, mangrove_pressure_plate,
			mangrove_trapdoor, mangrove_button, mangrove_slab, mangrove_fence_gate, mangrove_fence, mangrove_door,
			mangrove_stairs;

	public static Block palm_sapling, palm_log, palm_leaves, palm_planks, stripped_palm_log, palm_wood,
			stripped_palm_wood, palm_sign, palm_wall_sign, palm_pressure_plate, palm_trapdoor, palm_button, palm_slab,
			palm_fence_gate, palm_fence, palm_door, palm_stairs;
	
	public static Block cottonwood_sapling, cottonwood_log, cottonwood_leaves, cottonwood_planks,
			stripped_cottonwood_log, cottonwood_wood, stripped_cottonwood_wood, cottonwood_sign, cottonwood_wall_sign,
			cottonwood_pressure_plate, cottonwood_trapdoor, cottonwood_button, cottonwood_slab, cottonwood_fence_gate,
			cottonwood_fence, cottonwood_door, cottonwood_stairs;
	
	public static Block aspen_sapling, aspen_log, aspen_leaves, aspen_planks, stripped_aspen_log, aspen_wood,
			stripped_aspen_wood, aspen_sign, aspen_wall_sign, aspen_pressure_plate, aspen_trapdoor, aspen_button,
			aspen_slab, aspen_fence_gate, aspen_fence, aspen_door, aspen_stairs;

	public static Block juniper_sapling, juniper_log, juniper_leaves, berried_juniper_leaves, juniper_planks, stripped_juniper_log,
			juniper_wood, stripped_juniper_wood, juniper_sign, juniper_wall_sign, juniper_pressure_plate,
			juniper_trapdoor, juniper_button, juniper_slab, juniper_fence_gate, juniper_fence, juniper_door,
			juniper_stairs;

	public static Block baobab_sapling, baobab_log, baobab_leaves, baobab_planks, stripped_baobab_log, baobab_wood,
			stripped_baobab_wood, baobab_sign, baobab_wall_sign, baobab_pressure_plate, baobab_trapdoor, baobab_button,
			baobab_slab, baobab_fence_gate, baobab_fence, baobab_door, baobab_stairs;
	
	public static Block red_maple_sapling, orange_maple_sapling, purple_maple_sapling, maple_log, red_maple_leaves, orange_maple_leaves, purple_maple_leaves,
			maple_planks, stripped_maple_log, maple_wood, stripped_maple_wood, maple_sign, maple_wall_sign,
			maple_pressure_plate, maple_trapdoor, maple_button, maple_slab, maple_fence_gate, maple_fence, maple_door,
			maple_stairs;
	
	public static Block pink_sakura_sapling, white_sakura_sapling, sakura_log, pink_sakura_leaves, white_sakura_leaves, sakura_planks, stripped_sakura_log,
			sakura_wood, stripped_sakura_wood, sakura_sign, sakura_wall_sign, sakura_pressure_plate,
			sakura_trapdoor, sakura_button, sakura_slab, sakura_fence_gate, sakura_fence, sakura_door,
			sakura_stairs;
	
	public static Block tamarack_sapling, tamarack_log, tamarack_leaves, tamarack_planks, stripped_tamarack_log, tamarack_wood,
			stripped_tamarack_wood, tamarack_sign, tamarack_wall_sign, tamarack_pressure_plate, tamarack_trapdoor, tamarack_button,
			tamarack_slab, tamarack_fence_gate, tamarack_fence, tamarack_door, tamarack_stairs;

	public static Block potted_fir_sapling, potted_pine_sapling, potted_redwood_sapling, potted_willow_sapling,
			potted_mangrove_sapling, potted_palm_sapling, potted_aspen_sapling, potted_juniper_sapling,
			potted_cottonwood_sapling, potted_baobab_sapling, potted_red_maple_sapling, potted_orange_maple_sapling,
			potted_purple_maple_sapling, potted_pink_sakura_sapling, potted_white_sakura_sapling, potted_tamarack_sapling,
			potted_joshua_sapling;
	
	public static Block joshua_sapling, joshua_log, joshua_leaves, joshua_planks,
			stripped_joshua_log, joshua_wood, stripped_joshua_wood, joshua_sign, joshua_wall_sign,
			joshua_pressure_plate, joshua_trapdoor, joshua_button, joshua_slab, joshua_fence_gate,
			joshua_fence, joshua_door, joshua_stairs;
	
	public static Block potted_glowcap, potted_crimson_nettle, potted_warped_nettle;

	@SubscribeEvent
	public static void initBlocks(RegistryEvent.Register<Block> event) {
		twigs = registerBlockWithFuel(new GroundcoverBlock(Material.DIRT), "twigs", 100);
		fallen_leaves = registerBlock(new FallenLeavesBlock(), "fallen_leaves");
		rocks = registerBlock(new GroundcoverBlock(Material.DIRT), "rocks");
		mossy_rocks = registerBlock(new GroundcoverBlock(Material.DIRT), "mossy_rocks");
		sandstone_rocks = registerBlock(new GroundcoverBlock(Material.DIRT), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new GroundcoverBlock(Material.DIRT), "red_sandstone_rocks");
		ice_chunks = registerBlock(new GroundcoverBlock(Material.DIRT, SoundType.GLASS), "ice_chunks");
		bones = registerBlock(new GroundcoverBlock(Material.DIRT), "bones");
		charred_bones = registerBlock(new GroundcoverBlock(Material.DIRT), "charred_bones");
		pinecones = registerBlockWithFuel(new GroundcoverBlock(Material.DIRT), "pinecones", 100);
		seashells = registerBlock(new GroundcoverBlock(Material.DIRT), "seashells");
		
		aspen_fallen_leaves = registerBlock(new FallenLeavesBlock(), "aspen_fallen_leaves");
		red_maple_fallen_leaves = registerBlock(new FallenLeavesBlock(), "red_maple_fallen_leaves");
		orange_maple_fallen_leaves = registerBlock(new FallenLeavesBlock(), "orange_maple_fallen_leaves");
		purple_maple_fallen_leaves = registerBlock(new FallenLeavesBlock(), "purple_maple_fallen_leaves");
		pink_sakura_fallen_leaves = registerBlock(new FallenLeavesBlock(), "pink_sakura_fallen_leaves");
		white_sakura_fallen_leaves = registerBlock(new FallenLeavesBlock(), "white_sakura_fallen_leaves");

		sea_oats = registerBlock(new SeaOatsBlock(), "sea_oats");
		cattail = registerBlock(new CattailBlock(), "cattail");
		bark_mushroom = registerBlockWithFuel(new BarkMushroomBlock(), "bark_mushroom", 100);
		glowcap = registerBlock(new GlowcapBlock(), "glowcap");
		crimson_nettle = registerBlock(new NetherPlantBlock(MaterialColor.CRIMSON_NYLIUM), "crimson_nettle");
		warped_nettle = registerBlock(new NetherPlantBlock(MaterialColor.COLOR_CYAN), "warped_nettle");
		cindercane = registerBlock(new CindercaneBlock(Properties.of(Material.PLANT, MaterialColor.NETHER).noCollission().randomTicks().instabreak().sound(SoundType.TWISTING_VINES)), "cindercane");
		desert_sage = registerBlock(new BeachGrassBlock(), "desert_sage");
		desert_agave = registerBlock(new BeachGrassBlock(), "desert_agave");
		blooming_desert_agave = registerBlock(new SeaOatsBlock(), "blooming_desert_agave");
		
		short_grass = registerBlock(new ShortGrassBlock(), "short_grass");
		beach_grass = registerBlock(new BeachGrassBlock(), "beach_grass");
		prairie_grass = registerBlock(new PVJTallGrassBlock(), "prairie_grass");
		dry_grass = registerBlock(new DryGrassBlock(), "dry_grass");
		
		potted_glowcap = registerBlockWithoutItem(createFlowerPot(glowcap), "potted_glowcap");
		potted_crimson_nettle = registerBlockWithoutItem(createFlowerPot(crimson_nettle), "potted_crimson_nettle");
		potted_warped_nettle = registerBlockWithoutItem(createFlowerPot(warped_nettle), "potted_warped_nettle");
		
		natural_cobweb = registerBlockWithoutItem(new NaturalCobwebBlock(), "natural_cobweb");
		coconut = registerBlock(new CoconutBlock(), "coconut");
		
		fir_sapling = registerBlockWithFuel(new SaplingBlock(new FirTree(), Properties.copy(Blocks.OAK_SAPLING)), "fir_sapling", 100);
		fir_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_fir_log), "fir_log", 300);
		fir_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "fir_leaves");
		fir_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_fir_wood), "fir_wood", 300);
		fir_planks = registerBlockWithFuel(createPlanksBlock(), "fir_planks", 300);
		stripped_fir_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_fir_log", 300);
		stripped_fir_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_fir_wood", 300);
		fir_pressure_plate = registerBlockWithFuel(createPressurePlate(fir_planks.defaultMaterialColor()), "fir_pressure_plate", 300);
		fir_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "fir_trapdoor", 300);
		fir_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "fir_button", 100);
		fir_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "fir_slab", 150);
		fir_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "fir_fence_gate", 300);
		fir_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "fir_fence", 300);
		fir_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "fir_door", 200);
		fir_stairs = registerBlockWithFuel(new StairBlock(() -> fir_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "fir_stairs", 300);
		
		pine_sapling = registerBlockWithFuel(new SaplingBlock(new PineTree(), Properties.copy(Blocks.OAK_SAPLING)), "pine_sapling", 100);
		pine_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_pine_log), "pine_log", 300);
		pine_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "pine_leaves");
		pine_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_pine_wood), "pine_wood", 300);
		pine_planks = registerBlockWithFuel(createPlanksBlock(), "pine_planks", 300);
		stripped_pine_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_pine_log", 300);
		stripped_pine_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_pine_wood", 300);
		pine_pressure_plate = registerBlockWithFuel(createPressurePlate(pine_planks.defaultMaterialColor()), "pine_pressure_plate", 300);
		pine_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "pine_trapdoor", 300);
		pine_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "pine_button", 100);
		pine_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "pine_slab", 150);
		pine_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "pine_fence_gate", 300);
		pine_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "pine_fence", 300);
		pine_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "pine_door", 200);
		pine_stairs = registerBlockWithFuel(new StairBlock(() -> pine_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "pine_stairs", 300);
		
		redwood_sapling = registerBlockWithFuel(new SaplingBlock(new RedwoodTree(), Properties.copy(Blocks.OAK_SAPLING)), "redwood_sapling", 100);
		redwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_redwood_log), "redwood_log", 300);
		redwood_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "redwood_leaves");
		redwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_redwood_wood), "redwood_wood", 300);
		redwood_planks = registerBlockWithFuel(createPlanksBlock(), "redwood_planks", 300);
		stripped_redwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_redwood_log", 300);
		stripped_redwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_redwood_wood", 300);
		redwood_pressure_plate = registerBlockWithFuel(createPressurePlate(redwood_planks.defaultMaterialColor()),"redwood_pressure_plate", 300);
		redwood_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "redwood_trapdoor", 300);
		redwood_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "redwood_button", 100);
		redwood_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "redwood_slab", 150);
		redwood_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "redwood_fence_gate", 300);
		redwood_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "redwood_fence", 300);
		redwood_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "redwood_door", 200);
		redwood_stairs = registerBlockWithFuel(new StairBlock(() -> redwood_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "redwood_stairs", 300);
		
		willow_sapling = registerBlockWithFuel(new SandySaplingBlock(new WillowTree(), Properties.copy(Blocks.OAK_SAPLING)), "willow_sapling", 100);
		willow_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_willow_log), "willow_log", 300);
		willow_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "willow_leaves");
		willow_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_willow_wood), "willow_wood", 300);
		willow_planks = registerBlockWithFuel(createPlanksBlock(), "willow_planks", 300);
		stripped_willow_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_willow_log", 300);
		stripped_willow_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_willow_wood", 300);
		willow_pressure_plate = registerBlockWithFuel(createPressurePlate(willow_planks.defaultMaterialColor()),"willow_pressure_plate", 300);
		willow_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "willow_trapdoor", 300);
		willow_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "willow_button", 100);
		willow_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "willow_slab", 150);
		willow_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "willow_fence_gate", 300);
		willow_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "willow_fence", 300);
		willow_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "willow_door", 200);
		willow_stairs = registerBlockWithFuel(new StairBlock(() -> willow_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "willow_stairs", 300);
		
		mangrove_sapling = registerBlockWithFuel(new MangroveSaplingBlock(new MangroveTree(), Properties.copy(Blocks.OAK_SAPLING)), "mangrove_sapling", 100);
		mangrove_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_mangrove_log), "mangrove_log", 300);
		mangrove_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "mangrove_leaves");
		mangrove_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_mangrove_wood), "mangrove_wood", 300);
		mangrove_planks = registerBlockWithFuel(createPlanksBlock(), "mangrove_planks", 300);
		stripped_mangrove_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_mangrove_log", 300);
		stripped_mangrove_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_mangrove_wood", 300);
		mangrove_pressure_plate = registerBlockWithFuel(createPressurePlate(mangrove_planks.defaultMaterialColor()),"mangrove_pressure_plate", 300);
		mangrove_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "mangrove_trapdoor", 300);
		mangrove_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "mangrove_button", 100);
		mangrove_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "mangrove_slab", 150);
		mangrove_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "mangrove_fence_gate", 300);
		mangrove_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "mangrove_fence", 300);
		mangrove_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "mangrove_door", 200);
		mangrove_stairs = registerBlockWithFuel(new StairBlock(() -> mangrove_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "mangrove_stairs", 300);
		
		palm_sapling = registerBlockWithFuel(new SandySaplingBlock(new PalmTree(), Properties.copy(Blocks.OAK_SAPLING)), "palm_sapling", 100);
		palm_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_palm_log), "palm_log", 300);
		palm_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "palm_leaves");
		palm_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_palm_wood), "palm_wood", 300);
		palm_planks = registerBlockWithFuel(createPlanksBlock(), "palm_planks", 300);
		stripped_palm_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_palm_log", 300);
		stripped_palm_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_palm_wood", 300);
		palm_pressure_plate = registerBlockWithFuel(createPressurePlate(palm_planks.defaultMaterialColor()),"palm_pressure_plate", 300);
		palm_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "palm_trapdoor", 300);
		palm_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "palm_button", 100);
		palm_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "palm_slab", 150);
		palm_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "palm_fence_gate", 300);
		palm_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "palm_fence", 300);
		palm_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "palm_door", 200);
		palm_stairs = registerBlockWithFuel(new StairBlock(() -> palm_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "palm_stairs", 300);
		
		cottonwood_sapling = registerBlockWithFuel(new SaplingBlock(new CottonwoodTree(), Properties.copy(Blocks.OAK_SAPLING)), "cottonwood_sapling", 100);
		cottonwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_cottonwood_log), "cottonwood_log", 300);
		cottonwood_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "cottonwood_leaves");
		cottonwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_cottonwood_wood), "cottonwood_wood", 300);
		cottonwood_planks = registerBlockWithFuel(createPlanksBlock(), "cottonwood_planks", 300);
		stripped_cottonwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_cottonwood_log", 300);
		stripped_cottonwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_cottonwood_wood", 300);
		cottonwood_pressure_plate = registerBlockWithFuel(createPressurePlate(cottonwood_planks.defaultMaterialColor()),"cottonwood_pressure_plate", 300);
		cottonwood_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "cottonwood_trapdoor", 300);
		cottonwood_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "cottonwood_button", 100);
		cottonwood_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "cottonwood_slab", 150);
		cottonwood_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "cottonwood_fence_gate", 300);
		cottonwood_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "cottonwood_fence", 300);
		cottonwood_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "cottonwood_door", 200);
		cottonwood_stairs = registerBlockWithFuel(new StairBlock(() -> cottonwood_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "cottonwood_stairs", 300);
		
		aspen_sapling = registerBlockWithFuel(new SaplingBlock(new AspenTree(), Properties.copy(Blocks.OAK_SAPLING)), "aspen_sapling", 100);
		aspen_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_aspen_log), "aspen_log", 300);
		aspen_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "aspen_leaves");
		aspen_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_aspen_wood), "aspen_wood", 300);
		aspen_planks = registerBlockWithFuel(createPlanksBlock(), "aspen_planks", 300);
		stripped_aspen_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_aspen_log", 300);
		stripped_aspen_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_aspen_wood", 300);
		aspen_pressure_plate = registerBlockWithFuel(createPressurePlate(aspen_planks.defaultMaterialColor()),"aspen_pressure_plate", 300);
		aspen_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "aspen_trapdoor", 300);
		aspen_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "aspen_button", 100);
		aspen_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "aspen_slab", 150);
		aspen_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "aspen_fence_gate", 300);
		aspen_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "aspen_fence", 300);
		aspen_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "aspen_door", 200);
		aspen_stairs = registerBlockWithFuel(new StairBlock(() -> aspen_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "aspen_stairs", 300);
		
		juniper_sapling = registerBlockWithFuel(new JuniperSaplingBlock(new JuniperTree(), Properties.copy(Blocks.OAK_SAPLING)), "juniper_sapling", 100);
		juniper_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_juniper_log), "juniper_log", 300);
		berried_juniper_leaves = registerBlock(new BerriedJuniperLeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "berried_juniper_leaves");
		juniper_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "juniper_leaves");
		juniper_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_juniper_wood), "juniper_wood", 300);
		juniper_planks = registerBlockWithFuel(createPlanksBlock(), "juniper_planks", 300);
		stripped_juniper_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_juniper_log", 300);
		stripped_juniper_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_juniper_wood", 300);
		juniper_pressure_plate = registerBlockWithFuel(createPressurePlate(juniper_planks.defaultMaterialColor()),"juniper_pressure_plate", 300);
		juniper_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "juniper_trapdoor", 300);
		juniper_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "juniper_button", 100);
		juniper_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "juniper_slab", 150);
		juniper_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "juniper_fence_gate", 300);
		juniper_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "juniper_fence", 300);
		juniper_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "juniper_door", 200);
		juniper_stairs = registerBlockWithFuel(new StairBlock(() -> juniper_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "juniper_stairs", 300);
		
		baobab_sapling = registerBlockWithFuel(new SaplingBlock(new BaobabTree(), Properties.copy(Blocks.OAK_SAPLING)), "baobab_sapling", 100);
		baobab_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_baobab_log), "baobab_log", 300);
		baobab_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "baobab_leaves");
		baobab_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_baobab_wood), "baobab_wood", 300);
		baobab_planks = registerBlockWithFuel(createPlanksBlock(), "baobab_planks", 300);
		stripped_baobab_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_baobab_log", 300);
		stripped_baobab_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_baobab_wood", 300);
		baobab_pressure_plate = registerBlockWithFuel(createPressurePlate(baobab_planks.defaultMaterialColor()),"baobab_pressure_plate", 300);
		baobab_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "baobab_trapdoor", 300);
		baobab_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "baobab_button", 100);
		baobab_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "baobab_slab", 150);
		baobab_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "baobab_fence_gate", 300);
		baobab_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "baobab_fence", 300);
		baobab_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "baobab_door", 200);
		baobab_stairs = registerBlockWithFuel(new StairBlock(() -> baobab_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "baobab_stairs", 300);
		
		red_maple_sapling = registerBlockWithFuel(new SaplingBlock(new RedMapleTree(), Properties.copy(Blocks.OAK_SAPLING)), "red_maple_sapling", 100);
		orange_maple_sapling = registerBlockWithFuel(new SaplingBlock(new OrangeMapleTree(), Properties.copy(Blocks.OAK_SAPLING)), "orange_maple_sapling", 100);
		purple_maple_sapling = registerBlockWithFuel(new SaplingBlock(new PurpleMapleTree(), Properties.copy(Blocks.OAK_SAPLING)), "purple_maple_sapling", 100);
		maple_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_maple_log), "maple_log", 300);
		red_maple_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_RED; } }, "red_maple_leaves");
		orange_maple_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_ORANGE; } }, "orange_maple_leaves");
		purple_maple_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)) { public MaterialColor defaultMaterialColor() { return MaterialColor.COLOR_PURPLE; } }, "purple_maple_leaves");
		maple_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_maple_wood), "maple_wood", 300);
		maple_planks = registerBlockWithFuel(createPlanksBlock(), "maple_planks", 300);
		stripped_maple_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_maple_log", 300);
		stripped_maple_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_maple_wood", 300);
		maple_pressure_plate = registerBlockWithFuel(createPressurePlate(maple_planks.defaultMaterialColor()),"maple_pressure_plate", 300);
		maple_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "maple_trapdoor", 300);
		maple_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "maple_button", 100);
		maple_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "maple_slab", 150);
		maple_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "maple_fence_gate", 300);
		maple_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "maple_fence", 300);
		maple_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "maple_door", 200);
		maple_stairs = registerBlockWithFuel(new StairBlock(() -> maple_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "maple_stairs", 300);
		
		pink_sakura_sapling = registerBlockWithFuel(new SaplingBlock(new PinkSakuraTree(), Properties.copy(Blocks.OAK_SAPLING)), "pink_sakura_sapling", 100);
		white_sakura_sapling = registerBlockWithFuel(new SaplingBlock(new WhiteSakuraTree(), Properties.copy(Blocks.OAK_SAPLING)), "white_sakura_sapling", 100);
		sakura_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, () -> stripped_sakura_log), "sakura_log", 300);
		pink_sakura_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "pink_sakura_leaves");
		white_sakura_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "white_sakura_leaves");
		sakura_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED, () -> stripped_sakura_wood), "sakura_wood", 300);
		sakura_planks = registerBlockWithFuel(createPlanksBlock(), "sakura_planks", 300);
		stripped_sakura_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null), "stripped_sakura_log", 300);
		stripped_sakura_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_RED, null), "stripped_sakura_wood", 300);
		sakura_pressure_plate = registerBlockWithFuel(createPressurePlate(sakura_planks.defaultMaterialColor()),"sakura_pressure_plate", 300);
		sakura_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "sakura_trapdoor", 300);
		sakura_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "sakura_button", 100);
		sakura_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "sakura_slab", 150);
		sakura_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "sakura_fence_gate", 300);
		sakura_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "sakura_fence", 300);
		sakura_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "sakura_door", 200);
		sakura_stairs = registerBlockWithFuel(new StairBlock(() -> sakura_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "sakura_stairs", 300);
		
		tamarack_sapling = registerBlockWithFuel(new SaplingBlock(new TamarackTree(), Properties.copy(Blocks.OAK_SAPLING)), "tamarack_sapling", 100);
		tamarack_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_tamarack_log), "tamarack_log", 300);
		tamarack_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "tamarack_leaves");
		tamarack_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_tamarack_wood), "tamarack_wood", 300);
		tamarack_planks = registerBlockWithFuel(createPlanksBlock(), "tamarack_planks", 300);
		stripped_tamarack_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_tamarack_log", 300);
		stripped_tamarack_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_tamarack_wood", 300);
		tamarack_pressure_plate = registerBlockWithFuel(createPressurePlate(tamarack_planks.defaultMaterialColor()),"tamarack_pressure_plate", 300);
		tamarack_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "tamarack_trapdoor", 300);
		tamarack_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "tamarack_button", 100);
		tamarack_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "tamarack_slab", 150);
		tamarack_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "tamarack_fence_gate", 300);
		tamarack_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "tamarack_fence", 300);
		tamarack_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "tamarack_door", 200);
		tamarack_stairs = registerBlockWithFuel(new StairBlock(() -> tamarack_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "tamarack_stairs", 300);
		
		joshua_sapling = registerBlockWithFuel(new SaplingBlock(new JoshuaTree(), Properties.copy(Blocks.OAK_SAPLING)), "joshua_sapling", 100);
		joshua_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_joshua_log), "joshua_log", 300);
		joshua_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "joshua_leaves");
		joshua_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_joshua_wood), "joshua_wood", 300);
		joshua_planks = registerBlockWithFuel(createPlanksBlock(), "joshua_planks", 300);
		stripped_joshua_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_joshua_log", 300);
		stripped_joshua_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null), "stripped_joshua_wood", 300);
		joshua_pressure_plate = registerBlockWithFuel(createPressurePlate(joshua_planks.defaultMaterialColor()),"joshua_pressure_plate", 300);
		joshua_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "joshua_trapdoor", 300);
		joshua_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "joshua_button", 100);
		joshua_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "joshua_slab", 150);
		joshua_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)), "joshua_fence_gate", 300);
		joshua_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "joshua_fence", 300);
		joshua_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "joshua_door", 200);
		joshua_stairs = registerBlockWithFuel(new StairBlock(() -> joshua_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)), "joshua_stairs", 300);
		
		potted_fir_sapling =  registerBlockWithoutItem(createFlowerPot(fir_sapling), "potted_fir_sapling");
		potted_pine_sapling =  registerBlockWithoutItem(createFlowerPot(pine_sapling), "potted_pine_sapling");
		potted_redwood_sapling =  registerBlockWithoutItem(createFlowerPot(redwood_sapling), "potted_redwood_sapling");
		potted_willow_sapling =  registerBlockWithoutItem(createFlowerPot(willow_sapling), "potted_willow_sapling");
		potted_mangrove_sapling =  registerBlockWithoutItem(createFlowerPot(mangrove_sapling), "potted_mangrove_sapling");
		potted_palm_sapling =  registerBlockWithoutItem(createFlowerPot(palm_sapling), "potted_palm_sapling");
		potted_aspen_sapling =  registerBlockWithoutItem(createFlowerPot(aspen_sapling), "potted_aspen_sapling");
		potted_juniper_sapling =  registerBlockWithoutItem(createFlowerPot(juniper_sapling), "potted_juniper_sapling");
		potted_cottonwood_sapling =  registerBlockWithoutItem(createFlowerPot(cottonwood_sapling), "potted_cottonwood_sapling");
		potted_baobab_sapling =  registerBlockWithoutItem(createFlowerPot(baobab_sapling), "potted_baobab_sapling");
		potted_red_maple_sapling =  registerBlockWithoutItem(createFlowerPot(red_maple_sapling), "potted_red_maple_sapling");
		potted_orange_maple_sapling =  registerBlockWithoutItem(createFlowerPot(orange_maple_sapling), "potted_orange_maple_sapling");
		potted_purple_maple_sapling =  registerBlockWithoutItem(createFlowerPot(purple_maple_sapling), "potted_purple_maple_sapling");
		potted_pink_sakura_sapling =  registerBlockWithoutItem(createFlowerPot(pink_sakura_sapling), "potted_pink_sakura_sapling");
		potted_white_sakura_sapling =  registerBlockWithoutItem(createFlowerPot(white_sakura_sapling), "potted_white_sakura_sapling");
		potted_tamarack_sapling =  registerBlockWithoutItem(createFlowerPot(tamarack_sapling), "potted_tamarack_sapling");
		potted_joshua_sapling =  registerBlockWithoutItem(createFlowerPot(joshua_sapling), "potted_joshua_sapling");
		
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	public static Block registerBlock(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		Item.Properties prop = new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP);
		BlockItem item = new BlockItem(block, prop);
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		BLOCKS.add(block);
		PVJItems.ITEMS.add(item);

		return block;
	}

	public static Block registerBlockWithoutItem(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		BLOCKS.add(block);

		return block;
	}

	// lol whatever
	public static Block registerBlockWithFuel(Block block, String name, int burnTime) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		Item.Properties prop = new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP);
		BlockItem item = new BlockItem(block, prop) {
			@Override
			public int getBurnTime(ItemStack stack) {
				return burnTime;
			}
		};
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		BLOCKS.add(block);
		PVJItems.ITEMS.add(item);

		return block;
	}
	
	public static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor, Supplier<Block> stripped) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolType toolType) {
				if(toolType == ToolType.AXE)
					return stripped.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
				return super.getToolModifiedState(state, world, pos, player, stack, toolType);
			}
		};
	}
	
	public static PressurePlateBlock createPressurePlate(MaterialColor color) {
		return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				BlockBehaviour.Properties.of(Material.WOOD, color).noCollission()
				.strength(0.5F).sound(SoundType.WOOD));
	}

	public static Block createPlanksBlock() {
		return new Block(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F)
				.sound(SoundType.WOOD));
	}
	
	public static Block createFlowerPot(Block plant) {
		Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, () -> plant, Properties.copy(Blocks.FLOWER_POT).lightLevel((state) -> plant == glowcap ? 12 : 0));
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getRegistryName(), () -> block);
		return block;
	}
}
