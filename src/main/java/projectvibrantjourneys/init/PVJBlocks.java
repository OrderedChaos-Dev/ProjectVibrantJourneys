package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.NaturalCobwebBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder("projectvibrantjourneys")
public class PVJBlocks {

	/* GROUNDCOVERS */
	public static Block twigs, fallen_leaves, rocks, mossy_rocks, sandstone_rocks, red_sandstone_rocks, ice_chunks, bones, charred_bones, pinecones, seashells;
	public static Block sea_oats;
	public static Block cattail;
	public static Block bark_mushroom;
	public static Block natural_cobweb;

	@SubscribeEvent
	public static void initBlocks(RegistryEvent.Register<Block> event) {
		twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "oak_twigs", 100);
		fallen_leaves = registerBlock(new FallenLeavesBlock(), "oak_fallen_leaves");
		rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "stone_rocks");
		mossy_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "mossy_rocks");
		sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "sandstone_rocks");
		red_sandstone_rocks = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.ROCKS), "red_sandstone_rocks");
		ice_chunks = registerBlock(new GroundcoverBlock(Material.ICE, GroundcoverBlock.Type.ROCKS, SoundType.GLASS), "ice_chunks");
		bones = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.BONES), "bones");
		charred_bones = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.BONES), "charred_bones");
		pinecones = registerBlock(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.PINECONES), "pinecones");
		seashells = registerBlock(new GroundcoverBlock(Material.CLAY, GroundcoverBlock.Type.SEASHELLS), "seashells");
		
		sea_oats = registerBlock(new SeaOatsBlock(), "sea_oats");
		cattail = registerBlock(new CattailBlock(), "cattail");
		bark_mushroom = registerBlock(new BarkMushroomBlock(), "bark_mushroom");
		
		natural_cobweb = registerBlockWithoutItem(new NaturalCobwebBlock(), "natural_cobweb");
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
	
		RenderTypeLookup.setRenderLayer(twigs, cutout);
		RenderTypeLookup.setRenderLayer(rocks, cutout);
		RenderTypeLookup.setRenderLayer(mossy_rocks, cutout);
		RenderTypeLookup.setRenderLayer(sandstone_rocks, cutout);
		RenderTypeLookup.setRenderLayer(red_sandstone_rocks, cutout);
		RenderTypeLookup.setRenderLayer(ice_chunks, cutout);
		RenderTypeLookup.setRenderLayer(bones, cutout);
		RenderTypeLookup.setRenderLayer(charred_bones, cutout);
		RenderTypeLookup.setRenderLayer(pinecones, cutout);
		RenderTypeLookup.setRenderLayer(seashells, cutout);
		
		RenderTypeLookup.setRenderLayer(bark_mushroom, cutout);
	
		
		RenderTypeLookup.setRenderLayer(natural_cobweb, cutout);

		RenderTypeLookup.setRenderLayer(fallen_leaves, cutout_mipped);

		RenderTypeLookup.setRenderLayer(sea_oats, cutout_mipped);
		RenderTypeLookup.setRenderLayer(cattail, cutout_mipped);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerColors() {
		BlockColors blockColors = Minecraft.getInstance().getBlockColors();
		ItemColors itemColors = Minecraft.getInstance().getItemColors();

		registerFoliageColorBlock(blockColors, twigs);
		registerFoliageColorBlock(blockColors, fallen_leaves);

		registerFoliageColorItem(itemColors, blockColors, fallen_leaves);
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
