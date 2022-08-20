package com.projectvibrantjourneys.common;

import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class PVJCompostables {
	
	public static void init() {
		setCompostInfo(PVJBlocks.SHORT_GRASS.get(), 0.1F);
		setCompostInfo(PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PVJBlocks.DEAD_FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PVJBlocks.TWIGS.get(), 0.1F);
		setCompostInfo(PVJBlocks.PINECONES.get(), 0.1F);
		setCompostInfo(PVJBlocks.SEA_OATS.get(), 0.65F);
		setCompostInfo(PVJBlocks.CATTAIL.get(), 0.65F);
		setCompostInfo(PVJBlocks.BARK_MUSHROOM.get(), 0.4F);
		setCompostInfo(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), 0.4F);
		setCompostInfo(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), 0.4F);
		setCompostInfo(PVJBlocks.GLOWING_BLUE_FUNGUS.get(), 0.4F);
		setCompostInfo(PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
		setCompostInfo(PVJBlocks.GLOWCAP.get(), 0.65F);
		setCompostInfo(PVJBlocks.CRIMSON_NETTLE.get(), 0.65F);
		setCompostInfo(PVJBlocks.WARPED_NETTLE.get(), 0.65F);
		setCompostInfo(PVJBlocks.CINDERCANE.get(), 0.8F);
		setCompostInfo(PVJBlocks.BEACH_GRASS.get(), 0.25F);
		setCompostInfo(PVJBlocks.SMALL_CACTUS.get(), 0.25F);

	}

	public static void setCompostInfo(ItemLike item, float chance) {
		ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
	}
}
