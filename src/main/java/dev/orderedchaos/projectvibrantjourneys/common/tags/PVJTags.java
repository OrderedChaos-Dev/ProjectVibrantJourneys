package dev.orderedchaos.projectvibrantjourneys.common.tags;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.util.ModCompatUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class PVJTags {
  public static final TagKey<Biome> HAS_OAK_LOGS = createBiomeTag("has_logs/oak");
  public static final TagKey<Biome> HAS_BIRCH_LOGS = createBiomeTag("has_logs/birch");
  public static final TagKey<Biome> HAS_SPRUCE_LOGS = createBiomeTag("has_logs/spruce");
  public static final TagKey<Biome> HAS_JUNGLE_LOGS = createBiomeTag("has_logs/jungle");
  public static final TagKey<Biome> HAS_ACACIA_LOGS = createBiomeTag("has_logs/acacia");
  public static final TagKey<Biome> HAS_DARK_OAK_LOGS = createBiomeTag("has_logs/dark_oak");
  public static final TagKey<Biome> HAS_CHERRY_LOGS = createBiomeTag("has_logs/cherry");
  public static final TagKey<Biome> HAS_MANGROVE_LOGS = createBiomeTag("has_logs/mangrove");

  public static final TagKey<Block> GROUNDCOVER_CANNOT_GENERATE_ON = createBlockTag("groundcover_cannot_generate_on");
  public static final TagKey<Block> GROWS_ON_HOLLOW_LOG = createBlockTag("grows_on_hollow_log");

  /* ITEMS */
  public static final TagKey<Item> HARVESTS_MOSSY_HOLLOW_LOGS = createItemTag("harvests_mossy_hollow_logs");

  /* MOD COMPAT */
  public static final TagKey<Block> COMPOST_ACTIVATORS = createBlockTag(ModCompatUtils.ModIds.FARMERS_DELIGHT, "compost_activators");

  private static TagKey<Biome> createBiomeTag(final String location) {
    return TagKey.create(Registries.BIOME, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, location));
  }

  private static TagKey<Block> createBlockTag(final String location) {
    return BlockTags.create(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, location));
  }

  private static TagKey<Block> createBlockTag(final String namespace, final String location) {
    return BlockTags.create(new ResourceLocation(namespace, location));
  }

  private static TagKey<Item> createItemTag(final String location) {
    return ItemTags.create(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, location));
  }
}