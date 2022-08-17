package com.projectvibrantjourneys.client;

import com.projectvibrantjourneys.init.object.PVJBlocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockRendering {
	
	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderType cutout = RenderType.cutout();
		RenderType cutout_mipped = RenderType.cutoutMipped();
	
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.twigs.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.rocks.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mossy_rocks.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sandstone_rocks.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_sandstone_rocks.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ice_chunks.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.bones.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.charred_bones.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pinecones.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.seashells.get(), cutout);
	
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.bark_mushroom.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.natural_cobweb.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fallen_leaves.get(), cutout_mipped);

		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sea_oats.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cattail.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.glowcap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.crimson_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.warped_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cindercane.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.short_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.beach_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.small_cactus.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_glowcap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_warped_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_crimson_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_cindercane.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_small_cactus.get(), cutout);
	}

	
}