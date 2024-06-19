package dev.orderedchaos.projectvibrantjourneys.data.tags;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PVJBlockTagsProvider extends BlockTagsProvider {

  public PVJBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(output, lookupProvider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.tag(PVJTags.HOLLOW_LOGS).add(
      PVJBlocks.OAK_HOLLOW_LOG.get(),
      PVJBlocks.BIRCH_HOLLOW_LOG.get(),
      PVJBlocks.SPRUCE_HOLLOW_LOG.get(),
      PVJBlocks.JUNGLE_HOLLOW_LOG.get(),
      PVJBlocks.ACACIA_HOLLOW_LOG.get(),
      PVJBlocks.DARK_OAK_HOLLOW_LOG.get(),
      PVJBlocks.MANGROVE_HOLLOW_LOG.get(),
      PVJBlocks.CHERRY_HOLLOW_LOG.get()
    );
    this.tag(PVJTags.GROUNDCOVER).add(
      PVJBlocks.ROCKS.get(),
      PVJBlocks.MOSSY_ROCKS.get(),
      PVJBlocks.SANDSTONE_ROCKS.get(),
      PVJBlocks.RED_SANDSTONE_ROCKS.get(),
      PVJBlocks.TWIGS.get(),
      PVJBlocks.BONES.get(),
      PVJBlocks.CHARRED_BONES.get(),
      PVJBlocks.ICE_CHUNKS.get(),
      PVJBlocks.SEASHELLS.get(),
      PVJBlocks.PINECONES.get()
    );
    this.tag(PVJTags.FALLEN_LEAVES).add(
      PVJBlocks.FALLEN_LEAVES.get(),
      PVJBlocks.DEAD_FALLEN_LEAVES.get()
    );
    this.tag(PVJTags.GROWS_ON_HOLLOW_LOG).add(
      Blocks.SHORT_GRASS,
      Blocks.FERN,
      Blocks.TALL_GRASS,
      Blocks.LARGE_FERN,
      Blocks.PINK_PETALS,
      Blocks.BLUE_ORCHID,
      Blocks.PITCHER_CROP,
      Blocks.PITCHER_PLANT,
      Blocks.TORCHFLOWER,
      Blocks.MANGROVE_PROPAGULE,
      Blocks.DEAD_BUSH
    );
    this.tag(PVJTags.GROWS_ON_HOLLOW_LOG).add(
      PVJBlocks.CATTAIL.get(),
      PVJBlocks.REEDS.get(),
      PVJBlocks.SHORT_GRASS.get(),
      PVJBlocks.SANDY_SPROUTS.get(),
      PVJBlocks.BEACH_GRASS.get(),
      PVJBlocks.SEA_OATS.get(),
      PVJBlocks.PRICKLY_BUSH.get()
    );
    this.tag(BlockTags.LOGS).addTag(PVJTags.HOLLOW_LOGS);
    this.tag(BlockTags.LOGS_THAT_BURN).addTag(PVJTags.HOLLOW_LOGS);
    this.tag(BlockTags.FLOWER_POTS).add(
      PVJBlocks.POTTED_CINDERCANE.get(),
      PVJBlocks.POTTED_CRIMSON_NETTLE.get(),
      PVJBlocks.POTTED_WARPED_NETTLE.get(),
      PVJBlocks.POTTED_GLOWCAP.get(),
      PVJBlocks.POTTED_PRICKLY_BUSH.get(),
      PVJBlocks.POTTED_SMALL_CACTUS.get()
    );
    this.tag(BlockTags.MUSHROOM_GROW_BLOCK).addTag(PVJTags.HOLLOW_LOGS);
    this.tag(BlockTags.MINEABLE_WITH_AXE).addTag(PVJTags.HOLLOW_LOGS);
    this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(PVJBlocks.ICICLE.get());
    this.tag(BlockTags.SWORD_EFFICIENT)
      .addTag(PVJTags.FALLEN_LEAVES)
      .add(
        PVJBlocks.CATTAIL.get(),
        PVJBlocks.REEDS.get(),
        PVJBlocks.CINDERCANE.get(),
        PVJBlocks.GLOWCAP.get(),
        PVJBlocks.PRICKLY_BUSH.get(),
        PVJBlocks.BEACH_GRASS.get(),
        PVJBlocks.SEA_OATS.get(),
        PVJBlocks.SANDY_SPROUTS.get(),
        PVJBlocks.CRIMSON_NETTLE.get(),
        PVJBlocks.WARPED_NETTLE.get()
      );
    this.tag(BlockTags.REPLACEABLE_BY_TREES)
      .addTag(PVJTags.GROUNDCOVER)
      .addTag(PVJTags.FALLEN_LEAVES)
      .add(
        PVJBlocks.SHORT_GRASS.get(),
        PVJBlocks.SANDY_SPROUTS.get(),
        PVJBlocks.NATURAL_COBWEB.get(),
        PVJBlocks.BARK_MUSHROOM.get(),
        PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(),
        PVJBlocks.ORANGE_BARK_MUSHROOM.get()
    );
    this.tag(BlockTags.SNAPS_GOAT_HORN)
      .addTag(PVJTags.HOLLOW_LOGS);
    this.tag(BlockTags.REPLACEABLE).addTag(PVJTags.GROUNDCOVER);
  }
}
