package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.common.tags.PVJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
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
    tag(BlockTags.CHERRY_LOGS).add(PVJBlocks.CHERRY_HOLLOW_LOG.get());
    tag(BlockTags.MANGROVE_LOGS).add(PVJBlocks.MANGROVE_HOLLOW_LOG.get());
    tag(BlockTags.LOGS).add(
      PVJBlocks.OAK_HOLLOW_LOG.get(),
      PVJBlocks.BIRCH_HOLLOW_LOG.get(),
      PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
      PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
      PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
      PVJBlocks.ACACIA_HOLLOW_LOG.get(),
      PVJBlocks.CHERRY_HOLLOW_LOG.get(),
      PVJBlocks.MANGROVE_HOLLOW_LOG.get()
    );
    tag(BlockTags.LOGS_THAT_BURN).add(
      PVJBlocks.OAK_HOLLOW_LOG.get(),
      PVJBlocks.BIRCH_HOLLOW_LOG.get(),
      PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
      PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
      PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
      PVJBlocks.ACACIA_HOLLOW_LOG.get(),
      PVJBlocks.CHERRY_HOLLOW_LOG.get(),
      PVJBlocks.MANGROVE_HOLLOW_LOG.get()
    );
    tag(BlockTags.MINEABLE_WITH_AXE).add(
      PVJBlocks.OAK_HOLLOW_LOG.get(),
      PVJBlocks.BIRCH_HOLLOW_LOG.get(),
      PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
      PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
      PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
      PVJBlocks.ACACIA_HOLLOW_LOG.get(),
      PVJBlocks.CHERRY_HOLLOW_LOG.get(),
      PVJBlocks.MANGROVE_HOLLOW_LOG.get()
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
      PVJBlocks.ACACIA_HOLLOW_LOG.get(),
      PVJBlocks.CHERRY_HOLLOW_LOG.get(),
      PVJBlocks.MANGROVE_HOLLOW_LOG.get()
    );

    tag(PVJTags.GROWS_ON_HOLLOW_LOG).add(
      Blocks.GRASS,
      Blocks.FERN,
      Blocks.TALL_GRASS,
      Blocks.LARGE_FERN,
      Blocks.PINK_PETALS,
      Blocks.BLUE_ORCHID,
      PVJBlocks.CATTAIL.get(),
      PVJBlocks.REEDS.get(),
      PVJBlocks.SHORT_GRASS.get(),
      PVJBlocks.SANDY_SPROUTS.get()
    );
  }

}
