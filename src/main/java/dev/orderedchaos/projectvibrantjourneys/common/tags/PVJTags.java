package dev.orderedchaos.projectvibrantjourneys.common.tags;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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

  public static final TagKey<Block> GROWS_ON_HOLLOW_LOG = createBlockTag("grows_on_hollow_log");

  private static TagKey<Biome> createBiomeTag(final String location) {
    return TagKey.create(Registries.BIOME, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, location));
  }

  private static TagKey<Block> createBlockTag(final String location) {
    return BlockTags.create(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, location));
  }
}