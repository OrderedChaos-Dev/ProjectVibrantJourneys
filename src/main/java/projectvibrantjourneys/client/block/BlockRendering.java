package projectvibrantjourneys.client.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.init.object.PVJBlocks;

public class BlockRendering {
		@OnlyIn(Dist.CLIENT)
		public static void registerRenderers() {
			RenderType cutout = RenderType.cutout();
			RenderType cutout_mipped = RenderType.cutoutMipped();
		
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.twigs, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.rocks, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mossy_rocks, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sandstone_rocks, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_sandstone_rocks, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ice_chunks, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.bones, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.charred_bones, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pinecones, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.seashells, cutout);
			
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.bark_mushroom, cutout);
			
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.natural_cobweb, cutout);
	
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_maple_fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.orange_maple_fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.purple_maple_fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pink_sakura_fallen_leaves, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.white_sakura_fallen_leaves, cutout_mipped);
	
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sea_oats, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cattail, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.glowcap, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.crimson_nettle, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.warped_nettle, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cindercane, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.short_grass, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.beach_grass, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.prairie_grass, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.dry_grass, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.desert_sage, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.desert_agave, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.blooming_desert_agave, cutout);
			
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_glowcap, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_warped_nettle, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_crimson_nettle, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_fir_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_pine_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_redwood_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_willow_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_mangrove_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_palm_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_aspen_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_juniper_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_cottonwood_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_baobab_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_red_maple_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_orange_maple_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_purple_maple_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_pink_sakura_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_white_sakura_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_tamarack_sapling, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_joshua_sapling, cutout);
			
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.maple_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.maple_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sakura_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sakura_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_trapdoor, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_door, cutout);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_trapdoor, cutout);

			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_maple_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.orange_maple_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.purple_maple_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pink_sakura_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.white_sakura_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_sapling, cutout_mipped);
			ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_sapling, cutout_mipped);
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
					: FoliageColor.getDefaultColor(), block);
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
					: GrassColor.get(0.5D, 1.0D), block);
		}
}
