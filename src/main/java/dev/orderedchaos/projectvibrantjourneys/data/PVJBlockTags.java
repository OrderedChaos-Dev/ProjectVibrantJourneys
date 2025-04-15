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
    tag(BlockTags.MINEABLE_WITH_SHOVEL).add(PVJBlocks.FERROUS_GRAVEL.get(), PVJBlocks.GILDED_GRAVEL.get(), PVJBlocks.GILDED_RED_SAND.get(), PVJBlocks.MUDDY_BONES.get());
    tag(Tags.Blocks.GRAVEL).add(PVJBlocks.FERROUS_GRAVEL.get(), PVJBlocks.GILDED_GRAVEL.get());
    tag(BlockTags.SAND).add(PVJBlocks.GILDED_RED_SAND.get());
    tag(Tags.Blocks.SAND).add(PVJBlocks.GILDED_RED_SAND.get());
    tag(Tags.Blocks.SAND_RED).add(PVJBlocks.GILDED_RED_SAND.get());
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
    tag(BlockTags.SWORD_EFFICIENT)
      .add(
        PVJBlocks.FALLEN_LEAVES.get(),
        PVJBlocks.DEAD_FALLEN_LEAVES.get(),
        PVJBlocks.CATTAIL.get(),
        PVJBlocks.REEDS.get(),
        PVJBlocks.CINDERCANE.get(),
        PVJBlocks.GLOWCAP.get(),
        PVJBlocks.PRICKLY_BUSH.get(),
        PVJBlocks.BEACH_GRASS.get(),
        PVJBlocks.SEA_OATS.get(),
        PVJBlocks.SANDY_SPROUTS.get(),
        PVJBlocks.CRIMSON_NETTLE.get(),
        PVJBlocks.WARPED_NETTLE.get(),
        PVJBlocks.WATERGRASS.get(),
        PVJBlocks.YELLOW_WILDFLOWERS.get(),
        PVJBlocks.ORANGE_WILDFLOWERS.get(),
        PVJBlocks.BLUE_WILDFLOWERS.get(),
        PVJBlocks.PURPLE_WILDFLOWERS.get(),
        PVJBlocks.WHITE_WILDFLOWERS.get(),
        PVJBlocks.MIXED_WILDFLOWERS.get()
      );

    tag(PVJTags.GROWS_ON_HOLLOW_LOG).add(
      Blocks.GRASS,
      Blocks.FERN,
      Blocks.TALL_GRASS,
      Blocks.LARGE_FERN,
      Blocks.PINK_PETALS,
      Blocks.BLUE_ORCHID,
      Blocks.PITCHER_CROP,
      Blocks.PITCHER_PLANT,
      Blocks.TORCHFLOWER,
      Blocks.MANGROVE_PROPAGULE,
      Blocks.DEAD_BUSH,
      PVJBlocks.CATTAIL.get(),
      PVJBlocks.REEDS.get(),
      PVJBlocks.SHORT_GRASS.get(),
      PVJBlocks.SANDY_SPROUTS.get(),
      PVJBlocks.BEACH_GRASS.get(),
      PVJBlocks.SEA_OATS.get(),
      PVJBlocks.PRICKLY_BUSH.get(),
      PVJBlocks.WATERGRASS.get(),
      PVJBlocks.YELLOW_WILDFLOWERS.get(),
      PVJBlocks.ORANGE_WILDFLOWERS.get(),
      PVJBlocks.BLUE_WILDFLOWERS.get(),
      PVJBlocks.PURPLE_WILDFLOWERS.get(),
      PVJBlocks.WHITE_WILDFLOWERS.get(),
      PVJBlocks.MIXED_WILDFLOWERS.get()
    );
    tag(BlockTags.REPLACEABLE_BY_TREES)
      .add(
        PVJBlocks.TWIGS.get(),
        PVJBlocks.ROCKS.get(),
        PVJBlocks.SEASHELLS.get(),
        PVJBlocks.PINECONES.get(),
        PVJBlocks.RED_SANDSTONE_ROCKS.get(),
        PVJBlocks.SANDSTONE_ROCKS.get(),
        PVJBlocks.MOSSY_ROCKS.get(),
        PVJBlocks.ICE_CHUNKS.get(),
        PVJBlocks.BONES.get(),
        PVJBlocks.CHARRED_BONES.get(),
        PVJBlocks.FALLEN_LEAVES.get(),
        PVJBlocks.DEAD_FALLEN_LEAVES.get(),
        PVJBlocks.SHORT_GRASS.get(),
        PVJBlocks.SANDY_SPROUTS.get(),
        PVJBlocks.NATURAL_COBWEB.get(),
        PVJBlocks.BARK_MUSHROOM.get(),
        PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(),
        PVJBlocks.ORANGE_BARK_MUSHROOM.get(),
        PVJBlocks.WATERGRASS.get(),
        PVJBlocks.YELLOW_WILDFLOWERS.get(),
        PVJBlocks.ORANGE_WILDFLOWERS.get(),
        PVJBlocks.BLUE_WILDFLOWERS.get(),
        PVJBlocks.PURPLE_WILDFLOWERS.get(),
        PVJBlocks.WHITE_WILDFLOWERS.get(),
        PVJBlocks.MIXED_WILDFLOWERS.get()
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
