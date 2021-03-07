package projectvibrantjourneys.client.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.PVJBlocks;

public class BlockRendering {
		@OnlyIn(Dist.CLIENT)
		public static void registerRenderers() {
			RenderType cutout = RenderType.getCutout();
			RenderType cutout_mipped = RenderType.getCutoutMipped();
		
			RenderTypeLookup.setRenderLayer(PVJBlocks.twigs, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.rocks, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.mossy_rocks, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.sandstone_rocks, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.red_sandstone_rocks, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.ice_chunks, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.bones, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.charred_bones, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pinecones, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.seashells, cutout);
			
			RenderTypeLookup.setRenderLayer(PVJBlocks.bark_mushroom, cutout);
			
			RenderTypeLookup.setRenderLayer(PVJBlocks.natural_cobweb, cutout);
	
			RenderTypeLookup.setRenderLayer(PVJBlocks.fallen_leaves, cutout_mipped);
	
			RenderTypeLookup.setRenderLayer(PVJBlocks.sea_oats, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cattail, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.glowcap, cutout);
		}
	
		@OnlyIn(Dist.CLIENT)
		public static void registerColors() {
			BlockColors blockColors = Minecraft.getInstance().getBlockColors();
			ItemColors itemColors = Minecraft.getInstance().getItemColors();
	
			registerFoliageColorBlock(blockColors, PVJBlocks.twigs);
			registerFoliageColorBlock(blockColors, PVJBlocks.fallen_leaves);
	
			registerFoliageColorItem(itemColors, blockColors, PVJBlocks.fallen_leaves);
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
