package com.projectvibrantjourneys.core.data;

import org.jetbrains.annotations.Nullable;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PVJItemTagsProvider extends ItemTagsProvider {

	public PVJItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, provider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		copy(BlockTags.LOGS, ItemTags.LOGS);
		copy(BlockTags.LOGS, ItemTags.OAK_LOGS);
		copy(BlockTags.LOGS, ItemTags.BIRCH_LOGS);
		copy(BlockTags.LOGS, ItemTags.SPRUCE_LOGS);
		copy(BlockTags.LOGS, ItemTags.JUNGLE_LOGS);
		copy(BlockTags.LOGS, ItemTags.ACACIA_LOGS);
		copy(BlockTags.LOGS, ItemTags.DARK_OAK_LOGS);
	}
}
