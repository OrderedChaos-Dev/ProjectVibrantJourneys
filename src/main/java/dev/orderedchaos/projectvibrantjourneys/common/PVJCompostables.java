package dev.orderedchaos.projectvibrantjourneys.common;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class PVJCompostables {

  public static void init() {
    setCompostInfo(PVJBlocks.SHORT_GRASS.get(), 0.1F);
    setCompostInfo(PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(PVJBlocks.DEAD_FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(PVJBlocks.TWIGS.get(), 0.1F);
    setCompostInfo(PVJBlocks.PINECONES.get(), 0.1F);
    setCompostInfo(PVJBlocks.SEA_OATS.get(), 0.65F);
    setCompostInfo(PVJBlocks.CATTAIL.get(), 0.65F);
    setCompostInfo(PVJBlocks.BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(PVJBlocks.GLOWING_BLUE_FUNGUS.get(), 0.4F);
    setCompostInfo(PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(PVJBlocks.GLOWCAP.get(), 0.65F);
    setCompostInfo(PVJBlocks.CRIMSON_NETTLE.get(), 0.65F);
    setCompostInfo(PVJBlocks.WARPED_NETTLE.get(), 0.65F);
    setCompostInfo(PVJBlocks.CINDERCANE.get(), 0.8F);
    setCompostInfo(PVJBlocks.BEACH_GRASS.get(), 0.25F);
    setCompostInfo(PVJBlocks.SMALL_CACTUS.get(), 0.25F);
    setCompostInfo(PVJBlocks.REEDS.get(), 0.65F);
    setCompostInfo(PVJBlocks.PRICKLY_BUSH.get(), 0.2F);
    setCompostInfo(PVJBlocks.SANDY_SPROUTS.get(), 0.15F);
    setCompostInfo(PVJBlocks.WATERGRASS.get(), 0.1F);
    setCompostInfo(PVJBlocks.PINK_LOTUS.get(), 0.5F);
    setCompostInfo(PVJBlocks.PINK_VINES.get(), 0.2F);
    setCompostInfo(PVJBlocks.YELLOW_WILDFLOWERS.get(), 0.25F);
    setCompostInfo(PVJBlocks.ORANGE_WILDFLOWERS.get(), 0.25F);
    setCompostInfo(PVJBlocks.BLUE_WILDFLOWERS.get(), 0.25F);
    setCompostInfo(PVJBlocks.PURPLE_WILDFLOWERS.get(), 0.25F);
    setCompostInfo(PVJBlocks.WHITE_WILDFLOWERS.get(), 0.25F);
    setCompostInfo(PVJBlocks.MIXED_WILDFLOWERS.get(), 0.25F);
  }

  public static void setCompostInfo(ItemLike item, float chance) {
    ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
  }
}