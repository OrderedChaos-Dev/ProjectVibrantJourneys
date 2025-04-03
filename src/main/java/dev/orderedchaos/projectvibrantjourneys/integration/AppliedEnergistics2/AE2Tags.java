package dev.orderedchaos.projectvibrantjourneys.integration.AppliedEnergistics2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Integration with Applied Energistics 2
 * https://github.com/AppliedEnergistics/Applied-Energistics-2
 * 
 */

public class AE2Tags {
  /* BLOCKS */

  /**
   * Growth accelerators from Applied Energistics 2 will trigger additional random ticks for blocks in that tag, regardless of what the
   * blocks are.
  */
  public static final TagKey<Block> GROWTH_ACCELERATABLE = createBlockTag("growth_acceleratable");

private static TagKey<Block> createBlockTag(final String location) {
    return BlockTags.create(ResourceLocation.fromNamespaceAndPath("ae2", location));
  }

}
