package projectvibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GlowcapBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.NaturalCobwebBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder("projectvibrantjourneys")
public class PVJBlocks {

	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	/* GROUNDCOVERS */
	public static Block twigs, fallen_leaves, rocks, mossy_rocks, sandstone_rocks, red_sandstone_rocks, ice_chunks, bones, charred_bones, pinecones, seashells;
	public static Block sea_oats;
	public static Block cattail;
	public static Block bark_mushroom;
	public static Block natural_cobweb;
	public static Block glowcap;

	@SubscribeEvent
	public static void initBlocks(RegistryEvent.Register<Block> event) {
		twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD), "twigs", 100);
		fallen_leaves = registerBlock(new FallenLeavesBlock(), "fallen_leaves");
		rocks = registerBlock(new GroundcoverBlock(Material.CLAY), "rocks");
		mossy_rocks = registerBlock(new GroundcoverBlock(Material.CLAY), "mossy_rocks");
		sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY), "red_sandstone_rocks");
		ice_chunks = registerBlock(new GroundcoverBlock(Material.ICE, SoundType.GLASS), "ice_chunks");
		bones = registerBlock(new GroundcoverBlock(Material.CLAY), "bones");
		charred_bones = registerBlock(new GroundcoverBlock(Material.CLAY), "charred_bones");
		pinecones = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD), "pinecones", 100);
		seashells = registerBlock(new GroundcoverBlock(Material.CLAY), "seashells");
		
		sea_oats = registerBlock(new SeaOatsBlock(), "sea_oats");
		cattail = registerBlock(new CattailBlock(), "cattail");
		bark_mushroom = registerBlock(new BarkMushroomBlock(), "bark_mushroom");
		glowcap = registerBlock(new GlowcapBlock(), "glowcap");
		
		natural_cobweb = registerBlockWithoutItem(new NaturalCobwebBlock(), "natural_cobweb");
		
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	public static Block registerBlock(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));

		Item.Properties prop = new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP);
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

		Item.Properties prop = new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP);
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
}
