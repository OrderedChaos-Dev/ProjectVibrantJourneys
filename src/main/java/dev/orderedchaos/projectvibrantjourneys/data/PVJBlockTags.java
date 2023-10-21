package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PVJBlockTags extends BlockTagsProvider {

    public PVJBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.OAK_LOGS).add(PVJBlocks.OAK_HOLLOW_LOG.get());
        tag(BlockTags.BIRCH_LOGS).add(PVJBlocks.BIRCH_HOLLOW_LOG.get());
        tag(BlockTags.SPRUCE_LOGS).add(PVJBlocks.SPRUCE_HOLLOW_LOG.get());
        tag(BlockTags.JUNGLE_LOGS).add(PVJBlocks.JUNGLE_HOLLOW_LOG.get());
        tag(BlockTags.DARK_OAK_LOGS).add(PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
        tag(BlockTags.ACACIA_LOGS).add(PVJBlocks.ACACIA_HOLLOW_LOG.get());
        tag(BlockTags.LOGS).add(
                PVJBlocks.OAK_HOLLOW_LOG.get(),
                PVJBlocks.BIRCH_HOLLOW_LOG.get(),
                PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
                PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
                PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
                PVJBlocks.ACACIA_HOLLOW_LOG.get()
        );
        tag(BlockTags.LOGS_THAT_BURN).add(
                PVJBlocks.OAK_HOLLOW_LOG.get(),
                PVJBlocks.BIRCH_HOLLOW_LOG.get(),
                PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
                PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
                PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
                PVJBlocks.ACACIA_HOLLOW_LOG.get()
        );
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                PVJBlocks.OAK_HOLLOW_LOG.get(),
                PVJBlocks.BIRCH_HOLLOW_LOG.get(),
                PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
                PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
                PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
                PVJBlocks.ACACIA_HOLLOW_LOG.get()
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                PVJBlocks.ICICLE.get()
        );
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(
                PVJBlocks.OAK_HOLLOW_LOG.get(),
                PVJBlocks.BIRCH_HOLLOW_LOG.get(),
                PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
                PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
                PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
                PVJBlocks.ACACIA_HOLLOW_LOG.get()
        );
    }

}
