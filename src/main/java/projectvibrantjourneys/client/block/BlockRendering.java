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
import projectvibrantjourneys.init.object.PVJBlocks;

public class BlockRendering {
		@OnlyIn(Dist.CLIENT)
		public static void registerRenderers() {
			RenderType cutout = RenderType.cutout();
			RenderType cutout_mipped = RenderType.cutoutMipped();
		
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
			RenderTypeLookup.setRenderLayer(PVJBlocks.aspen_fallen_leaves, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.red_maple_fallen_leaves, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.orange_maple_fallen_leaves, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.purple_maple_fallen_leaves, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pink_sakura_fallen_leaves, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.white_sakura_fallen_leaves, cutout_mipped);
	
			RenderTypeLookup.setRenderLayer(PVJBlocks.sea_oats, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cattail, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.glowcap, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.crimson_nettle, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.warped_nettle, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cindercane, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.short_grass, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.beach_grass, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.prairie_grass, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.dry_grass, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.desert_sage, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.desert_agave, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.blooming_desert_agave, cutout);
			
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_glowcap, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_warped_nettle, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_crimson_nettle, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_fir_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_pine_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_redwood_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_willow_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_mangrove_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_palm_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_aspen_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_juniper_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_cottonwood_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_baobab_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_red_maple_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_orange_maple_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_purple_maple_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_pink_sakura_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_white_sakura_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_tamarack_sapling, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.potted_joshua_sapling, cutout);
			
			RenderTypeLookup.setRenderLayer(PVJBlocks.fir_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.fir_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pine_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pine_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.redwood_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.redwood_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.willow_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.willow_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.mangrove_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.mangrove_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.palm_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.palm_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.aspen_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.aspen_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.juniper_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.juniper_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cottonwood_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cottonwood_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.baobab_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.baobab_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.maple_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.maple_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.sakura_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.sakura_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.tamarack_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.tamarack_trapdoor, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.joshua_door, cutout);
			RenderTypeLookup.setRenderLayer(PVJBlocks.joshua_trapdoor, cutout);

			RenderTypeLookup.setRenderLayer(PVJBlocks.fir_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pine_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.redwood_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.willow_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.mangrove_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.palm_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.aspen_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.juniper_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.baobab_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.cottonwood_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.red_maple_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.orange_maple_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.purple_maple_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.pink_sakura_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.white_sakura_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.tamarack_sapling, cutout_mipped);
			RenderTypeLookup.setRenderLayer(PVJBlocks.joshua_sapling, cutout_mipped);
		}
	
		@OnlyIn(Dist.CLIENT)
		public static void registerColors() {
			BlockColors blockColors = Minecraft.getInstance().getBlockColors();
			ItemColors itemColors = Minecraft.getInstance().getItemColors();
	
			registerFoliageColorBlock(blockColors, PVJBlocks.twigs);
			registerFoliageColorBlock(blockColors, PVJBlocks.fallen_leaves);
//			registerGrassColorBlock(blockColors, PVJBlocks.cattail);
			registerGrassColorBlock(blockColors, PVJBlocks.short_grass);
			
			registerFoliageColorItem(itemColors, blockColors, PVJBlocks.fallen_leaves);
			registerFoliageColorItem(itemColors, blockColors, PVJBlocks.short_grass);
			
			registerWaterColorBlock(blockColors, PVJBlocks.potted_mangrove_sapling);
		}
	
		private static void registerFoliageColorBlock(BlockColors bc, Block block) {
			bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
					? BiomeColors.getAverageFoliageColor(world, pos)
					: FoliageColors.getDefaultColor(), block);
		}
		
		private static void registerWaterColorBlock(BlockColors bc, Block block) {
			bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
					? BiomeColors.getAverageWaterColor(world, pos)
					: -1, block);
		}
	
		private static void registerFoliageColorBlock(BlockColors bc, Block block, int color) {
			bc.register((state, world, pos, tintIndex) -> color, block);
		}
	
		private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block) {
			ic.register((itemstack, tintIndex) -> {
				BlockState state = Blocks.OAK_LEAVES.defaultBlockState();
				int color = bc.getColor(state, null, null, tintIndex); // get color
				return color;
			}, block);
		}
	
		private static void registerFoliageColorItem(ItemColors ic, BlockColors bc, Block block, int color) {
			ic.register((itemstack, tintIndex) -> color, block);
		}
	
		private static void registerGrassColorBlock(BlockColors bc, Block block) {
			bc.register((state, world, pos, tintIndex) -> (world != null && pos != null)
					? BiomeColors.getAverageGrassColor(world, pos)
					: GrassColors.get(0.5D, 1.0D), block);
		}
}
