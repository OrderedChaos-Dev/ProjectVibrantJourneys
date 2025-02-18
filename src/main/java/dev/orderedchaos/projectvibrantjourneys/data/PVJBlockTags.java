package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.common.tags.PVJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class PVJBlockTags extends BlockTagsProvider {

  public PVJBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.addModTags(provider);
    this.addModCompatTags(provider);
  }

  private void addModTags(HolderLookup.Provider provider) {
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

    tag(PVJTags.GROUNDCOVER_CANNOT_GENERATE_ON).add(
      Blocks.DEEPSLATE,
      Blocks.SCULK,
      Blocks.STONE_BRICKS,
      Blocks.MOSSY_STONE_BRICKS,
      Blocks.CRACKED_STONE_BRICKS,
      Blocks.MAGMA_BLOCK,
      Blocks.SPAWNER,
      Blocks.FARMLAND,
      Blocks.DIRT_PATH,
      Blocks.MYCELIUM,
      Blocks.AMETHYST_BLOCK,
      Blocks.DEEPSLATE_BRICKS,
      Blocks.DEEPSLATE_TILES,
      Blocks.CRACKED_DEEPSLATE_TILES,
      Blocks.CRACKED_DEEPSLATE_BRICKS,
      Blocks.CHISELED_DEEPSLATE,
      Blocks.POLISHED_DEEPSLATE,
      Blocks.COBBLED_DEEPSLATE,
      Blocks.REINFORCED_DEEPSLATE,
      Blocks.NOTE_BLOCK,
      Blocks.COPPER_BLOCK,
      Blocks.CUT_COPPER,
      Blocks.EXPOSED_COPPER,
      Blocks.EXPOSED_CUT_COPPER,
      Blocks.OXIDIZED_COPPER,
      Blocks.OXIDIZED_CUT_COPPER,
      Blocks.WEATHERED_COPPER,
      Blocks.WEATHERED_CUT_COPPER,
      Blocks.WAXED_COPPER_BLOCK,
      Blocks.WAXED_CUT_COPPER,
      Blocks.WAXED_EXPOSED_COPPER,
      Blocks.WAXED_EXPOSED_CUT_COPPER,
      Blocks.WAXED_OXIDIZED_COPPER,
      Blocks.WAXED_OXIDIZED_CUT_COPPER,
      Blocks.WAXED_WEATHERED_COPPER,
      Blocks.WAXED_WEATHERED_CUT_COPPER,
      Blocks.HAY_BLOCK,
      Blocks.BARREL,
      Blocks.BEEHIVE,
      Blocks.BEE_NEST,
      Blocks.CRAFTING_TABLE,
      Blocks.FURNACE,
      Blocks.BLAST_FURNACE,
      Blocks.SMOKER,
      Blocks.CARTOGRAPHY_TABLE,
      Blocks.FLETCHING_TABLE,
      Blocks.TNT,
      Blocks.SMITHING_TABLE,
      Blocks.LOOM,
      Blocks.DECORATED_POT
    ).addTags(
      BlockTags.WOOL,
      BlockTags.PLANKS,
      BlockTags.LEAVES,
      BlockTags.TERRACOTTA,
      BlockTags.SNOW,
      BlockTags.ICE,
      Tags.Blocks.ORES,
      Tags.Blocks.STORAGE_BLOCKS,
      BlockTags.FENCES,
      BlockTags.FENCE_GATES,
      BlockTags.STAIRS,
      BlockTags.STAIRS
    );
  }

  private void addModCompatTags(HolderLookup.Provider provider) {
    tag(PVJTags.COMPOST_ACTIVATORS)
      .add(PVJBlocks.GLOWCAP.get());
  }
}
