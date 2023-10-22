package dev.orderedchaos.projectvibrantjourneys.common.world;

import java.util.List;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum PortalType {
  //	NETHER_WASTES(Biomes.NETHER_WASTES, Blocks.NETHERRACK, List.of()),
  SOUL_SAND_VALLEY(Biomes.SOUL_SAND_VALLEY, Blocks.SOUL_SAND, List.of()),
  WARPED_FOREST(Biomes.WARPED_FOREST, Blocks.WARPED_NYLIUM, List.of(Blocks.WARPED_FUNGUS, Blocks.NETHER_SPROUTS, Blocks.WARPED_ROOTS)),
  CRIMSON_FOREST(Biomes.CRIMSON_FOREST, Blocks.CRIMSON_NYLIUM, List.of(Blocks.CRIMSON_FUNGUS, Blocks.CRIMSON_ROOTS)),
  BASALT_DELTAS(Biomes.BASALT_DELTAS, Blocks.BASALT, List.of());

  public final ResourceKey<Biome> biome;
  public final Block topSoil;
  public final List<Block> flora;

  PortalType(ResourceKey<Biome> biome, Block topSoil, List<Block> flora) {
    this.biome = biome;
    this.topSoil = topSoil;
    this.flora = flora;
  }

  public Block randomFlora(RandomSource random) {
    if (this.flora.isEmpty())
      return Blocks.AIR;

    return flora.get(random.nextInt(flora.size()));
  }

  public static PortalType getRandom(RandomSource random) {
    return PortalType.values()[random.nextInt(PortalType.values().length)];
  }

}