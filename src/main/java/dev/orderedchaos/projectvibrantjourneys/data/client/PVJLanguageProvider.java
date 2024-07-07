package dev.orderedchaos.projectvibrantjourneys.data.client;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PVJLanguageProvider extends LanguageProvider  {

  public PVJLanguageProvider(PackOutput output) {
    super(output, ProjectVibrantJourneys.MOD_ID, "en_us");
  }

  @Override
  protected void addTranslations() {
    this.add("itemGroup.projectvibrantjourneys", "Project: Vibrant Journeys");

    this.add(PVJBlocks.TWIGS.get(), "Twigs");
    this.add(PVJBlocks.ROCKS.get(), "Rocks");
    this.add(PVJBlocks.MOSSY_ROCKS.get(), "Mossy Rocks");
    this.add(PVJBlocks.SANDSTONE_ROCKS.get(), "Sandstone Rocks");
    this.add(PVJBlocks.RED_SANDSTONE_ROCKS.get(), "Red Sandstone Rocks");
    this.add(PVJBlocks.BONES.get(), "Bones");
    this.add(PVJBlocks.CHARRED_BONES.get(), "Charred Bones");
    this.add(PVJBlocks.ICE_CHUNKS.get(), "Ice Chunks");
    this.add(PVJBlocks.SEASHELLS.get(), "Seashells");
    this.add(PVJBlocks.PINECONES.get(), "Pine cones");
    this.add(PVJBlocks.FALLEN_LEAVES.get(), "Fallen Leaves");
    this.add(PVJBlocks.DEAD_FALLEN_LEAVES.get(), "Dead Fallen Leaves");
    this.add(PVJBlocks.NATURAL_COBWEB.get(), "Cobweb");
    this.add(PVJBlocks.CATTAIL.get(), "Cattail");
    this.add(PVJBlocks.REEDS.get(), "Reeds");
    this.add(PVJBlocks.SEA_OATS.get(), "Sea Oats");
    this.add(PVJBlocks.SHORT_GRASS.get(), "Short Grass");
    this.add(PVJBlocks.BEACH_GRASS.get(), "Beach Grass");
    this.add(PVJBlocks.SMALL_CACTUS.get(), "Small Cactus");
    this.add(PVJBlocks.PRICKLY_BUSH.get(), "Prickly Bush");
    this.add(PVJBlocks.SANDY_SPROUTS.get(), "Sandy Sprouts");
    this.add(PVJBlocks.BARK_MUSHROOM.get(), "Bark Mushroom");
    this.add(PVJBlocks.ORANGE_BARK_MUSHROOM.get(), "Orange Bark Mushroom");
    this.add(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), "Light Brown Bark Mushroom");
    this.add(PVJBlocks.GLOWING_BLUE_FUNGUS.get(), "Glowing Blue Fungus");
    this.add(PVJBlocks.GLOWCAP.get(), "Glowcap");
    this.add(PVJBlocks.CRIMSON_NETTLE.get(), "Crimson Nettle");
    this.add(PVJBlocks.WARPED_NETTLE.get(), "Warped Nettle");
    this.add(PVJBlocks.CINDERCANE.get(), "Cindercane");
    this.add(PVJBlocks.ICICLE.get(), "Icicle");
    this.add(PVJBlocks.WATERGRASS.get(), "Watergrass");
    this.add(PVJBlocks.FERROUS_GRAVEL.get(), "Ferrous Gravel");
    this.add(PVJBlocks.GILDED_GRAVEL.get(), "Gilded Gravel");


    this.add(PVJBlocks.OAK_HOLLOW_LOG.get(), "Oak Hollow Log");
    this.add(PVJBlocks.BIRCH_HOLLOW_LOG.get(), "Birch Hollow Log");
    this.add(PVJBlocks.SPRUCE_HOLLOW_LOG.get(), "Spruce Hollow Log");
    this.add(PVJBlocks.JUNGLE_HOLLOW_LOG.get(), "Jungle Hollow Log");
    this.add(PVJBlocks.ACACIA_HOLLOW_LOG.get(), "Acacia Hollow Log");
    this.add(PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), "Dark Oak Hollow Log");
    this.add(PVJBlocks.CHERRY_HOLLOW_LOG.get(), "Cherry Hollow Log");
    this.add(PVJBlocks.MANGROVE_HOLLOW_LOG.get(), "Mangrove Hollow Log");

    this.add(PVJBlocks.POTTED_SMALL_CACTUS.get(), "Potted Small Cactus");
    this.add(PVJBlocks.POTTED_PRICKLY_BUSH.get(), "Potted Prickly Bush");
    this.add(PVJBlocks.POTTED_GLOWCAP.get(), "Potted Glowcap");
    this.add(PVJBlocks.POTTED_CRIMSON_NETTLE.get(), "Potted Crimson Nettle");
    this.add(PVJBlocks.POTTED_WARPED_NETTLE.get(), "Potted Warped Nettle");
    this.add(PVJBlocks.POTTED_CINDERCANE.get(), "Potted Cindercane");

    this.add("item.minecraft.potion.effect.glowing", "Potion of Glowing");
    this.add("item.minecraft.splash_potion.effect.glowing", "Splash Potion of Glowing");
    this.add("item.minecraft.lingering_potion.effect.glowing", "Lingering Potion of Glowing");
    this.add("item.minecraft.potion.effect.long_glowing", "Potion of Glowing");
    this.add("item.minecraft.splash_potion.effect.long_glowing", "Splash Potion of Glowing");
    this.add("item.minecraft.lingering_potion.effect.long_glowing", "Lingering Potion of Glowing");
  }
}
