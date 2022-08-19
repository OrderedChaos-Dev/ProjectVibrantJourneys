package com.projectvibrantjourneys.core.registry;

import java.util.function.Supplier;

import com.projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import com.projectvibrantjourneys.common.blocks.BeachGrassBlock;
import com.projectvibrantjourneys.common.blocks.CattailBlock;
import com.projectvibrantjourneys.common.blocks.CindercaneBlock;
import com.projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import com.projectvibrantjourneys.common.blocks.GlowcapBlock;
import com.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.common.blocks.HollowLogBlock;
import com.projectvibrantjourneys.common.blocks.NaturalCobwebBlock;
import com.projectvibrantjourneys.common.blocks.NetherPlantBlock;
import com.projectvibrantjourneys.common.blocks.SeaOatsBlock;
import com.projectvibrantjourneys.common.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.common.blocks.SmallCactusBlock;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
	
	public static final RegistryObject<Block> BEACH_GRASS = registerBlock("beach_grass", () -> new BeachGrassBlock());
	public static final RegistryObject<Block> SEA_OATS = registerBlock("sea_oats", () -> new SeaOatsBlock());
	public static final RegistryObject<Block> CATTAIL = registerBlock("cattail", () -> new CattailBlock());
	public static final RegistryObject<Block> CRIMSON_NETTLE = registerBlock("crimson_nettle", () -> new NetherPlantBlock(MaterialColor.CRIMSON_NYLIUM));
	public static final RegistryObject<Block> WARPED_NETTLE = registerBlock("warped_nettle", () -> new NetherPlantBlock(MaterialColor.WARPED_NYLIUM));
	public static final RegistryObject<Block> CINDERCANE = registerBlockWithFuel("cindercane", 800, () -> new CindercaneBlock());
	public static final RegistryObject<Block> GLOWCAP = registerBlock("glowcap", () -> new GlowcapBlock());
	public static final RegistryObject<Block> BARK_MUSHROOM = registerBlockWithFuel("bark_mushroom", 100, () -> new BarkMushroomBlock());
	public static final RegistryObject<Block> SHORT_GRASS = registerBlock("short_grass", () -> new ShortGrassBlock());
	public static final RegistryObject<Block> NATURAL_COBWEB = registerBlockWithoutItem("natural_cobweb", () -> new NaturalCobwebBlock());
	public static final RegistryObject<Block> SMALL_CACTUS = registerBlock("small_cactus", () -> new SmallCactusBlock());
	
	public static final RegistryObject<Block> TWIGS = registerBlockWithFuel("twigs", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> FALLEN_LEAVES = registerBlock("fallen_leaves", () -> new FallenLeavesBlock());
	public static final RegistryObject<Block> ROCKS = registerBlock("rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> MOSSY_ROCKS = registerBlock("mossy_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> SANDSTONE_ROCKS = registerBlock("sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> RED_SANDSTONE_ROCKS = registerBlock("red_sandstone_rocks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> ICE_CHUNKS = registerBlock("ice_chunks", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> BONES = registerBlock("bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> CHARRED_BONES = registerBlock("charred_bones", () -> new GroundcoverBlock());
	public static final RegistryObject<Block> PINECONES = registerBlockWithFuel("pinecones", 100, () -> new GroundcoverBlock());
	public static final RegistryObject<Block> SEASHELLS = registerBlock("seashells", () -> new GroundcoverBlock());
	
	public static final RegistryObject<Block> OAK_HOLLOW_LOG = registerBlock("oak_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> BIRCH_HOLLOW_LOG = registerBlock("birch_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));
	public static final RegistryObject<Block> SPRUCE_HOLLOW_LOG = registerBlock("spruce_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
	public static final RegistryObject<Block> JUNGLE_HOLLOW_LOG = registerBlock("jungle_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
	public static final RegistryObject<Block> ACACIA_HOLLOW_LOG = registerBlock("acacia_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG)));
	public static final RegistryObject<Block> DARK_OAK_HOLLOW_LOG = registerBlock("dark_oak_hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> POTTED_GLOWCAP = registerBlockWithoutItem("potted_glowcap", () -> createFlowerPot(GLOWCAP.get()));
	public static final RegistryObject<Block> POTTED_CRIMSON_NETTLE = registerBlockWithoutItem("potted_crimson_nettle", () -> createFlowerPot(CRIMSON_NETTLE.get()));
	public static final RegistryObject<Block> POTTED_WARPED_NETTLE = registerBlockWithoutItem("potted_warped_nettle", () -> createFlowerPot(WARPED_NETTLE.get()));
	public static final RegistryObject<Block> POTTED_CINDERCANE = registerBlockWithoutItem("potted_cindercane", () -> createFlowerPot(CINDERCANE.get()));
	public static final RegistryObject<Block> POTTED_SMALL_CACTUS = registerBlockWithoutItem("potted_small_cactus", () -> createFlowerPot(SMALL_CACTUS.get()));
	
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
	
	public static Block createFlowerPot(Block plant) {
		Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).lightLevel((state) -> plant == GLOWCAP.get() ? 12 : 0));
		((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(plant.getRegistryName(), () -> block);
		return block;
	}
}
