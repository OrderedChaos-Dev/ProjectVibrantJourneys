package com.projectvibrantjourneys.init;

import com.projectvibrantjourneys.init.object.PVJBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class PVJCreativeModeTab extends CreativeModeTab {
	
	public static final PVJCreativeModeTab INSTANCE = new PVJCreativeModeTab();

	public PVJCreativeModeTab() {
		super("projectvibrantjourneys");
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(PVJBlocks.twigs.get().asItem());
	}

}
