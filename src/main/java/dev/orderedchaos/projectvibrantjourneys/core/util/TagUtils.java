package dev.orderedchaos.projectvibrantjourneys.core.util;

import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.Arrays;
import java.util.List;

public class TagUtils {

  // TODO: access transformer to make provider.tag() public and rewrite this
//  public <T> TagsProvider.TagAppender<T> tagModObject(TagsProvider<T> provider, TagKey<T> tagKey, String modid, String name) {
//
//  }

  public static List<ResourceLocation> genLocationsFromModId(String modid, String... names) {
    return Arrays.stream(names).map((name) -> ResourceLocation.fromNamespaceAndPath(modid, name)).toList();
  }

  public static <T> void addOptionalFromList(TagsProvider.TagAppender<T> tagAppender, List<ResourceLocation> resources) {
    resources.forEach(tagAppender::addOptional);
  }

}
