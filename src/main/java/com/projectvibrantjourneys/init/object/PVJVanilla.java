package com.projectvibrantjourneys.init.object;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class PVJVanilla {
	
	public static void init() {
		setCompostInfo(PVJBlocks.short_grass.get(), 0.1F);
		setCompostInfo(PVJBlocks.fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.aspen_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.orange_maple_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.red_maple_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.purple_maple_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.pink_sakura_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.white_sakura_fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.twigs.get(), 0.1F);
		setCompostInfo(PVJBlocks.pinecones.get(), 0.1F);
		setCompostInfo(PVJBlocks.sea_oats.get(), 0.65F);
		setCompostInfo(PVJBlocks.cattail.get(), 0.65F);
		setCompostInfo(PVJBlocks.bark_mushroom.get(), 0.4F);
		setCompostInfo(PVJBlocks.fallen_leaves.get(), 0.1F);
		setCompostInfo(PVJBlocks.glowcap.get(), 0.65F);
		setCompostInfo(PVJBlocks.crimson_nettle.get(), 0.65F);
		setCompostInfo(PVJBlocks.warped_nettle.get(), 0.65F);
		setCompostInfo(PVJBlocks.cindercane.get(), 0.8F);
		setCompostInfo(PVJBlocks.beach_grass.get(), 0.25F);
		setCompostInfo(PVJBlocks.small_cactus.get(), 0.25F);
		setCompostInfo(PVJBlocks.desert_agave.get(), 0.25F);
		setCompostInfo(PVJBlocks.desert_sage.get(), 0.25F);
		setCompostInfo(PVJBlocks.blooming_desert_agave.get(), 0.25F);
		setCompostInfo(PVJBlocks.dry_grass.get(), 0.1F);
		setCompostInfo(PVJBlocks.prairie_grass.get(), 0.1F);
		
		setCompostInfo(PVJBlocks.aspen_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.baobab_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.cottonwood_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.fir_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.joshua_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.juniper_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.mangrove_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.palm_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.pine_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.pink_sakura_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.red_maple_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.redwood_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.tamarack_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.white_sakura_sapling.get(), 0.3F);
		setCompostInfo(PVJBlocks.willow_sapling.get(), 0.3F);
		
		setCompostInfo(PVJBlocks.aspen_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.baobab_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.cottonwood_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.fir_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.joshua_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.juniper_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.berried_juniper_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.mangrove_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.orange_maple_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.palm_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.pine_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.pink_sakura_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.red_maple_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.redwood_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.tamarack_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.white_sakura_leaves.get(), 0.3F);
		setCompostInfo(PVJBlocks.willow_leaves.get(), 0.3F);
		
		setCompostInfo(PVJBlocks.coconut.get(), 0.8F);
		setCompostInfo(PVJItems.CRACKED_COCONUT.get(), 0.4F);
	}

	public static void setCompostInfo(ItemLike item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
