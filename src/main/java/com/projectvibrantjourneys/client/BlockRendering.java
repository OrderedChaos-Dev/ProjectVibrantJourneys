package com.projectvibrantjourneys.client;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockRendering {
	
	@OnlyIn(Dist.CLIENT)
	public static void registerRenderers() {
		RenderType cutout = RenderType.cutout();
		RenderType cutout_mipped = RenderType.cutoutMipped();
		RenderType translucent = RenderType.translucent();
	
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.TWIGS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ROCKS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.MOSSY_ROCKS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.SANDSTONE_ROCKS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.RED_SANDSTONE_ROCKS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ICE_CHUNKS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.BONES.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.CHARRED_BONES.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.PINECONES.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.SEASHELLS.get(), cutout);
	
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.BARK_MUSHROOM.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.GLOWING_BLUE_FUNGUS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.NATURAL_COBWEB.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.DEAD_FALLEN_LEAVES.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.SEA_OATS.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.CATTAIL.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.GLOWCAP.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.CRIMSON_NETTLE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.WARPED_NETTLE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.CINDERCANE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.SHORT_GRASS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.BEACH_GRASS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.SMALL_CACTUS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.PRICKLY_BUSH.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.REEDS.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.ICICLE.get(), translucent);
		
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_GLOWCAP.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_WARPED_NETTLE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_CRIMSON_NETTLE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_CINDERCANE.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_SMALL_CACTUS.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.POTTED_PRICKLY_BUSH.get(), cutout);
	}

	
}