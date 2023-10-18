package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class PVJItemTags extends ItemTagsProvider {

    public PVJItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockProvider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);
//        copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);
//        copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);
//        copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);
//        copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);
//        copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);
        copy(BlockTags.LOGS, ItemTags.LOGS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        tag(ItemTags.CREEPER_IGNITERS).add(PVJItems.CINDERCANE.get());
    }
}
