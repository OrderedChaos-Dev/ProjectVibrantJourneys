package dev.orderedchaos.projectvibrantjourneys.data.tags;

import dev.orderedchaos.projectvibrantjourneys.core.Constants;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.util.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class PVJBiomeTagsProvider extends BiomeTagsProvider  {

  public PVJBiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(pOutput, pProvider, ProjectVibrantJourneys.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    addTreeLogTypeTags(provider);
  }

  private void addTreeLogTypeTags(HolderLookup.Provider provider) {
    // doesn't include all biomes with these trees, only biomes where the "primary tree" is that tree
    // biomes can have multiple primary trees (eg forest has oak and birch, but savanna only has acacia)
    this.tag(PVJTags.HAS_OAK_LOGS).add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.SWAMP, Biomes.WINDSWEPT_FOREST, Biomes.DARK_FOREST, Biomes.MEADOW);
    this.tag(PVJTags.HAS_BIRCH_LOGS).add(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.MEADOW);
    this.tag(PVJTags.HAS_SPRUCE_LOGS).add(Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.GROVE, Biomes.WINDSWEPT_FOREST);
    this.tag(PVJTags.HAS_JUNGLE_LOGS).add(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE);
    this.tag(PVJTags.HAS_ACACIA_LOGS).add(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_SAVANNA);
    this.tag(PVJTags.HAS_DARK_OAK_LOGS).add(Biomes.DARK_FOREST);
    this.tag(PVJTags.HAS_MANGROVE_LOGS).add(Biomes.MANGROVE_SWAMP);
    this.tag(PVJTags.HAS_CHERRY_LOGS).add(Biomes.CHERRY_GROVE);

    // TODO: check these for cherry + mangrove
    // bop
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BOP,
        "mystic_grove",
        "lavender_forest",
        "bamboo_grove",
        "orchard",
        "wetland",
        "maple_woods",
        "snowy_maple_woods",
        "woodland",
        "lavender_field",
        "old_growth_dead_forest",
        "dead_forest",
        "prairie",
        "seasonal_forest",
        "fungal_jungle",
        "floodplain",
        "old_growth_woodland"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_BIRCH_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BOP,
        "boreal_forest",
        "seasonal_forest",
        "rainbow_hills"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_SPRUCE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BOP,
        "mediterranean_forest",
        "forested_field",
        "wetland",
        "jade_cliffs",
        "old_growth_dead_forest",
        "dead_forest"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_ACACIA_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BOP, "lush_desert"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_DARK_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BOP,
        "pumpkin_patch",
        "seasonal_forest"
      ));

    // byg
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG,
        "araucaria_savanna",
        "prairie",
        "white_mangrove_marshes",
        "autumnal_forest",
        "fragment_forest",
        "coconino_meadow",
        "orchard",
        "red_oak_forest",
        "baobab_savanna",
        "allium_fields",
        "temperate_rainforest"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_BIRCH_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG,
        "borealis_grove",
        "autumnal_forest",
        "howling_peaks",
        "temperate_grove"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_SPRUCE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG,
        "borealis_grove",
        "maple_taiga",
        "dacite_ridges",
        "canadian_shield",
        "frosted_taiga",
        "howling_peaks",
        "rose_fields",
        "autumnal_taiga",
        "weeping_witch_forest"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_JUNGLE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG,     "crag_gardens"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_ACACIA_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG, "araucaria_savanna", "baobab_savanna"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_DARK_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.BYG,     "temperate_rainforest"
      ));

    // terralith
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "shrublands",
        "snowy_shield",
        "rocky_jungle",
        "haze_mountain",
        "skylands_autumn",
        "shield",
        "temperate_highlands",
        "birch_taiga",
        "brushlands",
        "blooming_valley",
        "lush_valley",
        "snowy_maple_forest",
        "ice_marsh"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_BIRCH_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "orchid_swamp",
        "haze_mountain",
        "lavender_valley",
        "sakura_grove",
        "skylands_autumn",
        "skylands_spring",
        "lavender_forest",
        "shield",
        "temperate_highlands",
        "alpine_highlands",
        "birch_taiga",
        "yellowstone",
        "white_cliffs",
        "sakura_valley",
        "blooming_valley",
        "lush_valley"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_SPRUCE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "bryce_canyon",
        "rocky_shrublands",
        "moonlight_valley",
        "wintry_lowlands",
        "forested_highlands",
        "cold_shrublands",
        "siberian_taiga",
        "alpine_highlands",
        "skylands_winter",
        "shield",
        "alpine_grove",
        "wintry_forest",
        "moonlight_grove",
        "snowy_shield",
        "yellowstone",
        "highlands",
        "lush_valley"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_JUNGLE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "jungle_mountains",
        "desert_oasis",
        "skylands_summer",
        "red_oasis",
        "tropical_jungle",
        "rocky_jungle"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_ACACIA_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "arid_highlands",
        "moonlight_grove",
        "tropical_jungle",
        "hot_shrublands",
        "lavender_valley",
        "amethyst_rainforest",
        "skylands_summer",
        "moonlight_valley",
        "savanna_badlands",
        "lavender_forest",
        "amethyst_canyon"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_DARK_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.TERRALITH,
        "sakura_grove",
        "lavender_forest",
        "skylands_autumn",
        "mirage_isles",
        "forested_highlands",
        "lavender_valley",
        "skylands_spring",
        "snowy_maple_forest",
        "siberian_taiga",
        "skylands_winter",
        "sakura_valley"
      ));

    // pioneer
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "windswept_cliffs",
        "aspen_grove",
        "overgrown_spires",
        "verdant_sands",
        "flooded_forest",
        "pine_meadows"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_BIRCH_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "flooded_forest"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_SPRUCE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "autumnal_coniferous_forest",
        "pine_meadows"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_JUNGLE_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "overgrown_spires",
        "verdant_sands"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_ACACIA_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "verdant_sands",
        "baobab_fields"
      ));
    TagUtils.addOptionalFromList(this.tag(PVJTags.HAS_DARK_OAK_LOGS),
      TagUtils.genLocationsFromModId(Constants.ModIDs.PIONEER,
        "overgrown_spires"
      ));
  }
}
