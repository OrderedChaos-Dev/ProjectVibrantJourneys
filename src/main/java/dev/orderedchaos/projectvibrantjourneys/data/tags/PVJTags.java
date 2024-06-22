package dev.orderedchaos.projectvibrantjourneys.data.tags;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class PVJTags {

  /* BIOMES */
  public static final TagKey<Biome> HAS_OAK_LOGS = createBiomeTag("has_logs/oak");
  public static final TagKey<Biome> HAS_BIRCH_LOGS = createBiomeTag("has_logs/birch");
  public static final TagKey<Biome> HAS_SPRUCE_LOGS = createBiomeTag("has_logs/spruce");
  public static final TagKey<Biome> HAS_JUNGLE_LOGS = createBiomeTag("has_logs/jungle");
  public static final TagKey<Biome> HAS_ACACIA_LOGS = createBiomeTag("has_logs/acacia");
  public static final TagKey<Biome> HAS_DARK_OAK_LOGS = createBiomeTag("has_logs/dark_oak");
  public static final TagKey<Biome> HAS_CHERRY_LOGS = createBiomeTag("has_logs/cherry");
  public static final TagKey<Biome> HAS_MANGROVE_LOGS = createBiomeTag("has_logs/mangrove");

  /* BLOCKS */
  public static final TagKey<Block> GROWS_ON_HOLLOW_LOG = createBlockTag("grows_on_hollow_log");
  public static final TagKey<Block> HOLLOW_LOGS = createBlockTag("hollow_logs");
  public static final TagKey<Block> FALLEN_LEAVES = createBlockTag("fallen_leaves");
  public static final TagKey<Block> GROUNDCOVER = createBlockTag("groundcover");
  public static final TagKey<Block> GROUNDCOVER_CANNOT_GENERATE_ON = createBlockTag("groundcover_cannot_generate_on");
  public static final TagKey<Block> CINDERCANE_GROWS_ON = createBlockTag("cindercane_grows_on");

  private static TagKey<Biome> createBiomeTag(final String location) {
    return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, location));
  }

  private static TagKey<Block> createBlockTag(final String location) {
    return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, location));
  }
}