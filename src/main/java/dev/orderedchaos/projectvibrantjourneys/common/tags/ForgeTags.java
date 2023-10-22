package dev.orderedchaos.projectvibrantjourneys.common.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {

  public static final TagKey<Block> GRAVEL = createBlockTag("gravel");
  public static final TagKey<Block> SAND = createBlockTag("sand");

  public static final TagKey<Item> BONES = createItemTag("bones");
  public static final TagKey<Item> MUSHROOMS = createItemTag("mushrooms");
  public static final TagKey<Item> RODS = createItemTag("rods");
  public static final TagKey<Item> WOODEN_RODS = createItemTag("rods/wooden");

  private static TagKey<Block> createBlockTag(String location) {
    return BlockTags.create(new ResourceLocation("forge", location));
  }

  private static TagKey<Item> createItemTag(String location) {
    return ItemTags.create(new ResourceLocation("forge", location));
  }
}
