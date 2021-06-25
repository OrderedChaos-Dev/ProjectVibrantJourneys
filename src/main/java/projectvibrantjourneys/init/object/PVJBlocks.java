package projectvibrantjourneys.init.object;

import java.util.ArrayList;
import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.common.blocks.BeachGrassBlock;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GlowcapBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.NaturalCobwebBlock;
import projectvibrantjourneys.common.blocks.NetherPlantBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.common.blocks.ShortGrassBlock;
import projectvibrantjourneys.common.blocks.trees.FirTree;
import projectvibrantjourneys.common.blocks.trees.PineTree;
import projectvibrantjourneys.common.blocks.trees.RedwoodTree;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.PVJItemGroup;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBlocks {
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	/* GROUNDCOVERS */
	public static Block twigs, fallen_leaves, rocks, mossy_rocks, sandstone_rocks, red_sandstone_rocks, ice_chunks, bones, charred_bones, pinecones, seashells;
	public static Block sea_oats;
	public static Block cattail;
	public static Block bark_mushroom;
	public static Block natural_cobweb;
	public static Block glowcap;
	public static Block crimson_nettle, warped_nettle;
	public static Block short_grass, beach_grass;
	
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

public static Block potted_fir_sapling, potted_pine_sapling, potted_redwood_sapling;
	
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
		
		sea_oats = registerBlock(new SeaOatsBlock(), "sea_oats");
		cattail = registerBlock(new CattailBlock(), "cattail");
		bark_mushroom = registerBlockWithFuel(new BarkMushroomBlock(), "bark_mushroom", 100);
		glowcap = registerBlock(new GlowcapBlock(), "glowcap");
		crimson_nettle = registerBlock(new NetherPlantBlock(MaterialColor.CRIMSON_NYLIUM), "crimson_nettle");
		warped_nettle = registerBlock(new NetherPlantBlock(MaterialColor.COLOR_CYAN), "warped_nettle");
		short_grass = registerBlock(new ShortGrassBlock(), "short_grass");
		beach_grass = registerBlock(new BeachGrassBlock(), "beach_grass");
		
		potted_glowcap = registerBlockWithoutItem(createFlowerPot(glowcap), "potted_glowcap");
		potted_crimson_nettle = registerBlockWithoutItem(createFlowerPot(crimson_nettle), "potted_crimson_nettle");
		potted_warped_nettle = registerBlockWithoutItem(createFlowerPot(warped_nettle), "potted_warped_nettle");
		
		natural_cobweb = registerBlockWithoutItem(new NaturalCobwebBlock(), "natural_cobweb");
		
		fir_sapling = registerBlockWithFuel(new SaplingBlock(new FirTree(), Properties.copy(Blocks.OAK_SAPLING)), "fir_sapling",
				100);
		fir_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_fir_log), "fir_log", 300);
		fir_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "fir_leaves");
		fir_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_fir_wood), "fir_wood", 300);
		fir_planks = registerBlockWithFuel(createPlanksBlock(), "fir_planks", 300);
		stripped_fir_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_fir_log", 300);
		stripped_fir_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_fir_wood", 300);
		fir_pressure_plate = registerBlockWithFuel(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				AbstractBlock.Properties.of(Material.WOOD, fir_planks.defaultMaterialColor()).noCollission()
						.strength(0.5F).sound(SoundType.WOOD)),
				"fir_pressure_plate", 300);
		fir_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "fir_trapdoor",
				300);
		fir_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "fir_button", 100);
		fir_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "fir_slab", 150);
		fir_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)),
				"fir_fence_gate", 300);
		fir_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "fir_fence", 300);
		fir_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "fir_door", 200);
		fir_stairs = registerBlockWithFuel(
				new StairsBlock(() -> fir_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)),
				"fir_stairs", 300);
		
		pine_sapling = registerBlockWithFuel(new SaplingBlock(new PineTree(), Properties.copy(Blocks.OAK_SAPLING)), "pine_sapling",
				100);
		pine_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_pine_log), "pine_log", 300);
		pine_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "pine_leaves");
		pine_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_pine_wood), "pine_wood", 300);
		pine_planks = registerBlockWithFuel(createPlanksBlock(), "pine_planks", 300);
		stripped_pine_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_pine_log", 300);
		stripped_pine_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_pine_wood", 300);
		pine_pressure_plate = registerBlockWithFuel(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				AbstractBlock.Properties.of(Material.WOOD, pine_planks.defaultMaterialColor()).noCollission()
						.strength(0.5F).sound(SoundType.WOOD)),
				"pine_pressure_plate", 300);
		pine_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "pine_trapdoor",
				300);
		pine_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "pine_button", 100);
		pine_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "pine_slab", 150);
		pine_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)),
				"pine_fence_gate", 300);
		pine_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "pine_fence", 300);
		pine_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "pine_door", 200);
		pine_stairs = registerBlockWithFuel(
				new StairsBlock(() -> pine_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)),
				"pine_stairs", 300);
		
		redwood_sapling = registerBlockWithFuel(new SaplingBlock(new RedwoodTree(), Properties.copy(Blocks.OAK_SAPLING)), "redwood_sapling",
				100);
		redwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.COLOR_BROWN, () -> stripped_redwood_log), "redwood_log", 300);
		redwood_leaves = registerBlock(new LeavesBlock(Properties.copy(Blocks.OAK_LEAVES)), "redwood_leaves");
		redwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN, () -> stripped_redwood_wood), "redwood_wood", 300);
		redwood_planks = registerBlockWithFuel(createPlanksBlock(), "redwood_planks", 300);
		stripped_redwood_log = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_redwood_log", 300);
		stripped_redwood_wood = registerBlockWithFuel(createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, null),
				"stripped_redwood_wood", 300);
		redwood_pressure_plate = registerBlockWithFuel(new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
				AbstractBlock.Properties.of(Material.WOOD, redwood_planks.defaultMaterialColor()).noCollission()
						.strength(0.5F).sound(SoundType.WOOD)),
				"redwood_pressure_plate", 300);
		redwood_trapdoor = registerBlockWithFuel(new TrapDoorBlock(Properties.copy(Blocks.OAK_TRAPDOOR)), "redwood_trapdoor",
				300);
		redwood_button = registerBlockWithFuel(new WoodButtonBlock(Properties.copy(Blocks.OAK_BUTTON)), "redwood_button", 100);
		redwood_slab = registerBlockWithFuel(new SlabBlock(Properties.copy(Blocks.OAK_SLAB)), "redwood_slab", 150);
		redwood_fence_gate = registerBlockWithFuel(new FenceGateBlock(Properties.copy(Blocks.SPRUCE_FENCE_GATE)),
				"redwood_fence_gate", 300);
		redwood_fence = registerBlockWithFuel(new FenceBlock(Properties.copy(Blocks.SPRUCE_FENCE)), "redwood_fence", 300);
		redwood_door = registerBlockWithFuel(new DoorBlock(Properties.copy(Blocks.SPRUCE_DOOR)), "redwood_door", 200);
		redwood_stairs = registerBlockWithFuel(
				new StairsBlock(() -> redwood_planks.defaultBlockState(), Properties.copy(Blocks.SPRUCE_STAIRS)),
				"redwood_stairs", 300);
		
		potted_fir_sapling =  registerBlockWithoutItem(createFlowerPot(fir_sapling), "potted_fir_sapling");
		potted_pine_sapling =  registerBlockWithoutItem(createFlowerPot(pine_sapling), "potted_pine_sapling");
		potted_redwood_sapling =  registerBlockWithoutItem(createFlowerPot(redwood_sapling), "potted_redwood_sapling");
		
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
		return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
				if(toolType == ToolType.AXE)
					return stripped.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
				return super.getToolModifiedState(state, world, pos, player, stack, toolType);
			}
		};
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
