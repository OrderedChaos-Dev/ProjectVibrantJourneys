package dev.orderedchaos.projectvibrantjourneys.data.datamaps;

import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class PVJDataMapsProvider extends DataMapProvider {

  public PVJDataMapsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(packOutput, lookupProvider);
  }

  @Override
  protected void gather() {
    Builder<Compostable, Item> compostables = builder(NeoForgeDataMaps.COMPOSTABLES);
    setCompostInfo(compostables, PVJBlocks.SHORT_GRASS.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.DEAD_FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.TWIGS.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.BIRCH_TWIGS.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.PINECONES.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.SEA_OATS.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.CATTAIL.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(compostables, PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(compostables, PVJBlocks.ORANGE_BARK_MUSHROOM.get(), 0.4F);
    setCompostInfo(compostables, PVJBlocks.GLOWING_BLUE_FUNGUS.get(), 0.4F);
    setCompostInfo(compostables, PVJBlocks.FALLEN_LEAVES.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.GLOWCAP.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.CRIMSON_NETTLE.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.WARPED_NETTLE.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.CINDERCANE.get(), 0.8F);
    setCompostInfo(compostables, PVJBlocks.BEACH_GRASS.get(), 0.25F);
    setCompostInfo(compostables, PVJBlocks.SMALL_CACTUS.get(), 0.25F);
    setCompostInfo(compostables, PVJBlocks.REEDS.get(), 0.65F);
    setCompostInfo(compostables, PVJBlocks.PRICKLY_BUSH.get(), 0.2F);
    setCompostInfo(compostables, PVJBlocks.SANDY_SPROUTS.get(), 0.15F);
    setCompostInfo(compostables, PVJBlocks.WATERGRASS.get(), 0.1F);
    setCompostInfo(compostables, PVJBlocks.GLOWCAP_BLOCK.get(), 0.85F);

    Builder<FurnaceFuel, Item> furnaceFuels = builder(NeoForgeDataMaps.FURNACE_FUELS);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.BARK_MUSHROOM.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.ORANGE_BARK_MUSHROOM.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.GLOWING_BLUE_FUNGUS.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.CINDERCANE.get(), 800);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.TWIGS.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.BIRCH_TWIGS.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.PINECONES.get(), 100);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.OAK_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.BIRCH_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.SPRUCE_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.JUNGLE_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.ACACIA_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.DARK_OAK_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.MANGROVE_HOLLOW_LOG.get(), 300);
    setFurnaceFuelInfo(furnaceFuels, PVJBlocks.CHERRY_HOLLOW_LOG.get(), 300);
  }

  private void setCompostInfo(Builder<Compostable, Item> builder, ItemLike item, float chance) {
    builder.add(item.asItem().builtInRegistryHolder(), new Compostable(chance), false);
  }

  private void setFurnaceFuelInfo(Builder<FurnaceFuel, Item> builder, ItemLike item, int burnTime) {
    builder.add(item.asItem().builtInRegistryHolder(), new FurnaceFuel(burnTime), false);
  }
}
