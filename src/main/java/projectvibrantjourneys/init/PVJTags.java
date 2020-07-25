package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PVJTags {

    // mod item tags

    // mod block tags
    public static Tag<Block> SEA_OATS_PLACEABLE = tagWithEntries("sea_oats_placeable", Collections.emptySet(), Arrays.asList(Tags.Blocks.DIRT, Tags.Blocks.SAND, BlockTags.SAND));
    public static Tag<Block> BEACH_GRASS_PLACEABLE = tagWithEntries("beach_grass_placeable", Collections.emptySet(), Arrays.asList(Tags.Blocks.DIRT, Tags.Blocks.SAND, BlockTags.SAND));
    public static Tag<Block> TROPICAL_SAPLING_PLANTABLE = tagWithEntries("tropical_sapling_plantable", Collections.emptySet(), Arrays.asList(Tags.Blocks.SAND, BlockTags.SAND));
    public static Tag<Block> JUNIPER_SAPLING_PLANTABLE = tagWithEntries("juniper_sapling_plantable", Arrays.asList(
            Blocks.TERRACOTTA,
            Blocks.BLACK_TERRACOTTA,
            Blocks.BLUE_TERRACOTTA,
            Blocks.BROWN_TERRACOTTA,
            Blocks.CYAN_TERRACOTTA,
            Blocks.GRAY_TERRACOTTA,
            Blocks.GREEN_TERRACOTTA,
            Blocks.LIGHT_BLUE_TERRACOTTA,
            Blocks.LIGHT_GRAY_TERRACOTTA,
            Blocks.LIME_TERRACOTTA,
            Blocks.MAGENTA_TERRACOTTA,
            Blocks.ORANGE_TERRACOTTA,
            Blocks.PINK_TERRACOTTA,
            Blocks.PURPLE_TERRACOTTA,
            Blocks.RED_TERRACOTTA,
            Blocks.WHITE_TERRACOTTA,
            Blocks.YELLOW_TERRACOTTA
    ), Collections.singleton(TROPICAL_SAPLING_PLANTABLE));
    public static Tag<Block> CATTAIL_GROWABLE = tagWithEntries("cattail_growable", Collections.singleton(Blocks.CLAY), Arrays.asList(
            Tags.Blocks.DIRT,
            Tags.Blocks.SAND,
            Tags.Blocks.GRAVEL,
            BlockTags.SAND
    ));

    public static <T> Tag<T> tagWithEntries(String id, Collection<T> entries, Collection<Tag<T>> tags) {
        Tag.Builder<T> builder = new Tag.Builder<>();
        entries.forEach(builder::add);
        tags.forEach(builder::add);
        return builder.build(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, id));
    }

}
