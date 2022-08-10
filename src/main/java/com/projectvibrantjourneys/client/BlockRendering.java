package com.projectvibrantjourneys.client;

import com.projectvibrantjourneys.init.object.PVJBlocks;

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
import net.minecraftforge.fml.common.Mod;

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
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_fallen_leaves.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_maple_fallen_leaves.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.orange_maple_fallen_leaves.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.purple_maple_fallen_leaves.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pink_sakura_fallen_leaves.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.white_sakura_fallen_leaves.get(), cutout_mipped);

		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sea_oats.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cattail.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.glowcap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.crimson_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.warped_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cindercane.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.short_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.beach_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.small_cactus.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.prairie_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.dry_grass.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.desert_sage.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.desert_agave.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.blooming_desert_agave.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_glowcap.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_warped_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_crimson_nettle.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_cindercane.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_small_cactus.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_fir_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_pine_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_redwood_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_willow_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_mangrove_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_palm_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_aspen_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_juniper_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_cottonwood_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_baobab_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_red_maple_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_orange_maple_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_purple_maple_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_pink_sakura_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_white_sakura_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_tamarack_sapling.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.potted_joshua_sapling.get(), cutout);
		
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.maple_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.maple_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sakura_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.sakura_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_trapdoor.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_door.get(), cutout);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_trapdoor.get(), cutout);

		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.fir_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pine_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.redwood_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.willow_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.mangrove_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.palm_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.aspen_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.juniper_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.baobab_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.cottonwood_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.red_maple_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.orange_maple_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.purple_maple_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.pink_sakura_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.white_sakura_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.tamarack_sapling.get(), cutout_mipped);
		ItemBlockRenderTypes.setRenderLayer(PVJBlocks.joshua_sapling.get(), cutout_mipped);
	}

	
}