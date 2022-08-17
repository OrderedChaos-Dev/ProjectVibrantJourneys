package com.projectvibrantjourneys.init.object;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class PVJVanilla {
	
	public static void init() {
		setCompostInfo(PVJBlocks.short_grass.get(), 0.1F);
		setCompostInfo(PVJBlocks.fallen_leaves.get(), 0.1F);
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

	}

	public static void setCompostInfo(ItemLike item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
