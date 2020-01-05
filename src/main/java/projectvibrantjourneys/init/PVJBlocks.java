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
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJBlocks {
	
	/* GROUNDCOVERS */
	public static Block oak_twigs, birch_twigs, spruce_twigs, jungle_twigs, dark_oak_twigs, acacia_twigs;
	public static Block oak_fallen_leaves,  birch_fallen_leaves,  spruce_fallen_leaves,  jungle_fallen_leaves,  dark_oak_fallen_leaves,  acacia_fallen_leaves;
	public static Block rocks, mossy_rocks, andesite_rocks, granite_rocks, diorite_rocks, sandstone_rocks, red_sandstone_rocks, netherrack_rocks, ice_chunks;
	public static Block iron_nugget, gold_nugget, flint;
	public static Block bones, charred_bones;
	public static Block pinecones, seashells;
	public static Block dung;
	
	@SubscribeEvent
	public static void initBlocks(RegistryEvent.Register<Block> event) {
		oak_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "oak_twigs", 100);
		birch_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "birch_twigs", 100);
		spruce_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "spruce_twigs", 100);
		acacia_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "acacia_twigs", 100);
		dark_oak_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "dark_oak_twigs", 100);
		jungle_twigs = registerBlockWithFuel(new GroundcoverBlock(Material.WOOD, GroundcoverBlock.Type.TWIGS), "jungle_twigs", 100);
		
		oak_fallen_leaves = registerBlock(new FallenLeavesBlock(), "oak_fallen_leaves");
		birch_fallen_leaves = registerBlock(new FallenLeavesBlock(), "birch_fallen_leaves");
		spruce_fallen_leaves = registerBlock(new FallenLeavesBlock(), "spruce_fallen_leaves");
		jungle_fallen_leaves = registerBlock(new FallenLeavesBlock(), "jungle_fallen_leaves");
		dark_oak_fallen_leaves = registerBlock(new FallenLeavesBlock(), "dark_oak_fallen_leaves");
		acacia_fallen_leaves = registerBlock(new FallenLeavesBlock(), "acacia_fallen_leaves");
		
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
		
		if(FMLEnvironment.dist == Dist.CLIENT) {
			registerRenderers();
		}
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
	
	//lol whatever
	public static Block registerBlockWithFuel(Block block, String name, int burnTime) {
		block.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		
		Item.Properties prop = new Item.Properties().group(PVJItemGroup.PVJ_ITEMGROUP);
		BlockItem item = new BlockItem(block, prop) {
			@Override
			public int getBurnTime(ItemStack stack)
		    {
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
		RenderTypeLookup.setRenderLayer(oak_twigs, RenderType.func_228643_e_()); //"cutout"
		RenderTypeLookup.setRenderLayer(birch_twigs, RenderType.func_228643_e_());
		RenderTypeLookup.setRenderLayer(spruce_twigs, RenderType.func_228643_e_());
		RenderTypeLookup.setRenderLayer(acacia_twigs, RenderType.func_228643_e_());
		RenderTypeLookup.setRenderLayer(dark_oak_twigs, RenderType.func_228643_e_());
		RenderTypeLookup.setRenderLayer(jungle_twigs, RenderType.func_228643_e_());
		
		RenderTypeLookup.setRenderLayer(oak_fallen_leaves, RenderType.func_228641_d_()); // "cutout mipped"
		RenderTypeLookup.setRenderLayer(birch_fallen_leaves, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(spruce_fallen_leaves, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(acacia_fallen_leaves, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(dark_oak_fallen_leaves, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(jungle_fallen_leaves, RenderType.func_228641_d_());
		
		RenderTypeLookup.setRenderLayer(iron_nugget, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(gold_nugget, RenderType.func_228641_d_());
		RenderTypeLookup.setRenderLayer(flint, RenderType.func_228641_d_());
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
		
		registerFoliageColorItem(itemColors, blockColors, oak_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, birch_fallen_leaves, FoliageColors.getBirch());
		registerFoliageColorItem(itemColors, blockColors, spruce_fallen_leaves, FoliageColors.getSpruce());
		registerFoliageColorItem(itemColors, blockColors, jungle_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, dark_oak_fallen_leaves);
		registerFoliageColorItem(itemColors, blockColors, acacia_fallen_leaves);
	}
	
	private static void registerFoliageColorBlock(BlockColors bc, Block block) {
		bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
				? BiomeColors.func_228361_b_(world, pos) : FoliageColors.getDefault(), block);
	}
	
	private static void registerFoliageColorBlock(BlockColors bc, Block block, int color) {
		bc.register((state, world, pos, tintIndex) -> color, block);
	}
	
	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block) {
		ic.register((itemstack, tintIndex) -> {
			BlockState state = Blocks.OAK_LEAVES.getDefaultState();
			int color = bc.func_228054_a_(state, null, null, tintIndex); //get color
			return color;
		}, block);
	}
	
	private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block, int color) {
		ic.register((itemstack, tintIndex) -> color, block);
	}
}
