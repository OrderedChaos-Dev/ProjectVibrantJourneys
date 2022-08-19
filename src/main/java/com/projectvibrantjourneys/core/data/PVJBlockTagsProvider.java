package com.projectvibrantjourneys.core.data;

import org.jetbrains.annotations.Nullable;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.core.registry.PVJBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class PVJBlockTagsProvider extends BlockTagsProvider {

	public PVJBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(BlockTags.LOGS).add(PVJBlocks.OAK_HOLLOW_LOG.get(), PVJBlocks.BIRCH_HOLLOW_LOG.get(), PVJBlocks.SPRUCE_HOLLOW_LOG.get(), PVJBlocks.JUNGLE_HOLLOW_LOG.get(), PVJBlocks.ACACIA_HOLLOW_LOG.get(), PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
		this.tag(BlockTags.LOGS_THAT_BURN).add(PVJBlocks.OAK_HOLLOW_LOG.get(), PVJBlocks.BIRCH_HOLLOW_LOG.get(), PVJBlocks.SPRUCE_HOLLOW_LOG.get(), PVJBlocks.JUNGLE_HOLLOW_LOG.get(), PVJBlocks.ACACIA_HOLLOW_LOG.get(), PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(PVJBlocks.OAK_HOLLOW_LOG.get(), PVJBlocks.BIRCH_HOLLOW_LOG.get(), PVJBlocks.SPRUCE_HOLLOW_LOG.get(), PVJBlocks.JUNGLE_HOLLOW_LOG.get(), PVJBlocks.ACACIA_HOLLOW_LOG.get(), PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
		this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(PVJBlocks.OAK_HOLLOW_LOG.get(), PVJBlocks.BIRCH_HOLLOW_LOG.get(), PVJBlocks.SPRUCE_HOLLOW_LOG.get(), PVJBlocks.JUNGLE_HOLLOW_LOG.get(), PVJBlocks.ACACIA_HOLLOW_LOG.get(), PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
		this.tag(BlockTags.OAK_LOGS).add(PVJBlocks.OAK_HOLLOW_LOG.get());
		this.tag(BlockTags.BIRCH_LOGS).add(PVJBlocks.BIRCH_HOLLOW_LOG.get());
		this.tag(BlockTags.SPRUCE_LOGS).add(PVJBlocks.SPRUCE_HOLLOW_LOG.get());
		this.tag(BlockTags.JUNGLE_LOGS).add(PVJBlocks.JUNGLE_HOLLOW_LOG.get());
		this.tag(BlockTags.ACACIA_LOGS).add(PVJBlocks.ACACIA_HOLLOW_LOG.get());
		this.tag(BlockTags.DARK_OAK_LOGS).add(PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
	}
}
