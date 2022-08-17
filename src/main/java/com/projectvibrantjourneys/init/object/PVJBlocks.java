package com.projectvibrantjourneys.init.object;

import java.util.function.Supplier;

import com.projectvibrantjourneys.blocks.BarkMushroomBlock;
import com.projectvibrantjourneys.blocks.BeachGrassBlock;
import com.projectvibrantjourneys.blocks.CattailBlock;
import com.projectvibrantjourneys.blocks.CindercaneBlock;
import com.projectvibrantjourneys.blocks.FallenLeavesBlock;
import com.projectvibrantjourneys.blocks.GlowcapBlock;
import com.projectvibrantjourneys.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.blocks.NaturalCobwebBlock;
import com.projectvibrantjourneys.blocks.NetherPlantBlock;
import com.projectvibrantjourneys.blocks.SeaOatsBlock;
import com.projectvibrantjourneys.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.blocks.SmallCactusBlock;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.PVJCreativeModeTab;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectVibrantJourneys.MOD_ID);
	
	public static final Block[] TERRACOTTA_BLOCKS = {
			Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA,
			Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA,
			Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA,
			Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA,
			Blocks.BLACK_TERRACOTTA
	};
	
	public static final RegistryObject<Block> beach_grass = registerBlock("beach_grass", () -> new BeachGrassBlock());
	public static final RegistryObject<Block> sea_oats = registerBlock("sea_oats", () -> new SeaOatsBlock());
	public static final RegistryObject<Block> cattail = registerBlock("cattail", () -> new CattailBlock());
	public static final RegistryObject<Block> crimson_nettle = registerBlock("crimson_nettle", () -> new NetherPlantBlock(MaterialColor.CRIMSON_NYLIUM));
	public static final RegistryObject<Block> warped_nettle = registerBlock("warped_nettle", () -> new NetherPlantBlock(MaterialColor.WARPED_NYLIUM));
	public static final RegistryObject<Block> cindercane = registerBlockWithFuel("cindercane", 800, () -> new CindercaneBlock());
	public static final RegistryObject<Block> glowcap = registerBlock("glowcap", () -> new GlowcapBlock());
	public static final RegistryObject<Block> bark_mushroom = registerBlockWithFuel("bark_mushroom", 100, () -> new BarkMushroomBlock());
	public static final RegistryObject<Block> short_grass = registerBlock("short_grass", () -> new ShortGrassBlock());
	public static final RegistryObject<Block> natural_cobweb = registerBlockWithoutItem("natural_cobweb", () -> new NaturalCobwebBlock());
	public static final RegistryObject<Block> small_cactus = registerBlock("small_cactus", () -> new SmallCactusBlock());
	
	public static final RegistryObject<Block> twigs = registerBlockWithFuel("twigs", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> fallen_leaves = registerBlock("fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> rocks = registerBlock("rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> mossy_rocks = registerBlock("mossy_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> sandstone_rocks = registerBlock("sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> red_sandstone_rocks = registerBlock("red_sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> ice_chunks = registerBlock("ice_chunks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> bones = registerBlock("bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> charred_bones = registerBlock("charred_bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> pinecones = registerBlockWithFuel("pinecones", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> seashells = registerBlock("seashells", () -> new GroundcoverBlock());
	
	public static final RegistryObject<Block> potted_glowcap = registerBlockWithoutItem("potted_glowcap", () -> createFlowerPot(glowcap.get()));
	public static final RegistryObject<Block> potted_crimson_nettle = registerBlockWithoutItem("potted_crimson_nettle", () -> createFlowerPot(crimson_nettle.get()));
	public static final RegistryObject<Block> potted_warped_nettle = registerBlockWithoutItem("potted_warped_nettle", () -> createFlowerPot(warped_nettle.get()));
	public static final RegistryObject<Block> potted_cindercane = registerBlockWithoutItem("potted_cindercane", () -> createFlowerPot(cindercane.get()));
	public static final RegistryObject<Block> potted_small_cactus = registerBlockWithoutItem("potted_small_cactus", () -> createFlowerPot(small_cactus.get()));
	
	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
		RegistryObject<Block> temp = BLOCKS.register(name, block);
		
		PVJItems.ITEMS.register(name, () -> new ItemNameBlockItem(temp.get(), new Item.Properties().tab(PVJCreativeModeTab.INSTANCE)));
		return temp;
	}
	
	private static RegistryObject<Block> registerBlockWithoutItem(String name, Supplier<Block> block) {
		return BLOCKS.register(name, block);
	}
	
	private static RegistryObject<Block> registerBlockWithFuel(String name, int burnTime, Supplier<Block> block) {
		return registerBlock(name, block);
//		ResourceLocation res = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name);
//		
//		ItemNameBlockItem item = new ItemNameBlockItem(block.get(), new Item.Properties().tab(PVJCreativeModeTab.INSTANCE)) {
//			@Override
//			public int getBurnTime(ItemStack stack, RecipeType type) {
//				return burnTime;
//			}
//		};
//		
//		PVJItems.ITEMS.register(name, () -> item);
//		return BLOCKS.register(name, block);
	}
	
	public static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor, Supplier<Block> stripped) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
			return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolType) {
				if(toolType == ToolActions.AXE_STRIP && stripped != null)
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
		Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).lightLevel((state) -> plant == glowcap.get() ? 12 : 0));
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getRegistryName(), () -> block);
		return block;
	}
}
