package dev.orderedchaos.projectvibrantjourneys.common.world.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class MultipleVegetationPatchConfiguration implements FeatureConfiguration {

  public static final Codec<MultipleVegetationPatchConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
    return instance.group(TagKey.hashedCodec(Registries.BLOCK)
      .fieldOf("replaceable").forGetter((config) -> {
        return config.replaceable;
      }), BlockStateProvider.CODEC.fieldOf("ground_state").forGetter((config) -> {
      return config.groundState;
    }), Codec.floatRange(0.0F, 1.0F).fieldOf("placement_chance").forGetter((config) -> {
      return config.placementChance;
    }), PlacedFeature.CODEC.listOf().fieldOf("vegetation_feature").forGetter((config) -> {
      return config.vegetationFeature;
    }), CaveSurface.CODEC.fieldOf("surface").forGetter((config) -> {
      return config.surface;
    }), IntProvider.codec(1, 128).fieldOf("depth").forGetter((config) -> {
      return config.depth;
    }), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_bottom_block_chance").forGetter((config) -> {
      return config.extraBottomBlockChance;
    }), Codec.intRange(1, 256).fieldOf("vertical_range").forGetter((config) -> {
      return config.verticalRange;
    }), Codec.floatRange(0.0F, 1.0F).fieldOf("vegetation_chance").forGetter((config) -> {
      return config.vegetationChance;
    }), IntProvider.CODEC.fieldOf("xz_radius").forGetter((config) -> {
      return config.xzRadius;
    }), Codec.floatRange(0.0F, 1.0F).fieldOf("extra_edge_column_chance").forGetter((config) -> {
      return config.extraEdgeColumnChance;
    })).apply(instance, MultipleVegetationPatchConfiguration::new);
  });
  public final TagKey<Block> replaceable;
  public final BlockStateProvider groundState;
  public final float placementChance;
  public final List<Holder<PlacedFeature>> vegetationFeature;
  public final CaveSurface surface;
  public final IntProvider depth;
  public final float extraBottomBlockChance;
  public final int verticalRange;
  public final float vegetationChance;
  public final IntProvider xzRadius;
  public final float extraEdgeColumnChance;

  public MultipleVegetationPatchConfiguration(TagKey<Block> replace, BlockStateProvider provider, float placementChance, List<Holder<PlacedFeature>> feature, CaveSurface surface, IntProvider depth, float extraBottomChance, int verticalRange, float vegetationChance, IntProvider xzRadius, float extraEdgeColumnChance) {
    this.replaceable = replace;
    this.groundState = provider;
    this.placementChance = placementChance;
    this.vegetationFeature = feature;
    this.surface = surface;
    this.depth = depth;
    this.extraBottomBlockChance = extraBottomChance;
    this.verticalRange = verticalRange;
    this.vegetationChance = vegetationChance;
    this.xzRadius = xzRadius;
    this.extraEdgeColumnChance = extraEdgeColumnChance;
  }
}