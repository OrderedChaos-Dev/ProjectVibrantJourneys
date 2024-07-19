package dev.orderedchaos.projectvibrantjourneys.data.tags;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJItems;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PVJItemTagsProvider extends ItemTagsProvider {

  public PVJItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
    super(pOutput, pLookupProvider, pBlockTags, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.copy(PVJTags.HOLLOW_LOGS, ItemTags.LOGS);
    this.copy(PVJTags.HOLLOW_LOGS, ItemTags.LOGS_THAT_BURN);
    this.tag(ItemTags.CREEPER_IGNITERS).add(PVJBlocks.CINDERCANE.asItem());
    this.tag(ItemTags.CAMEL_FOOD).add(PVJBlocks.SMALL_CACTUS.asItem());
    this.tag(Tags.Items.FOODS_SOUP).add(PVJItems.NETTLE_SOUP.get());
  }
}
