package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class PVJTags {
    public static TagKey<Biome> HAS_OAK_LOGS = createTag("has_logs/oak");
    public static TagKey<Biome> HAS_BIRCH_LOGS = createTag("has_logs/birch");
    public static TagKey<Biome> HAS_SPRUCE_LOGS = createTag("has_logs/spruce");
    public static TagKey<Biome> HAS_JUNGLE_LOGS = createTag("has_logs/jungle");
    public static TagKey<Biome> HAS_ACACIA_LOGS = createTag("has_logs/acacia");
    public static TagKey<Biome> HAS_DARK_OAK_LOGS = createTag("has_logs/dark_oak");

    private static TagKey<Biome> createTag(final String tagLocation) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, tagLocation));
    }
}