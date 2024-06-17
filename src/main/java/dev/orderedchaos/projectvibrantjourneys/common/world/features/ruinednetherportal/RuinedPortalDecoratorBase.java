package dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportal;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuinedPortalDecoratorBase {

  private String name;

  public RuinedPortalDecoratorBase(String name) {
    this.name = name;
  }

  @Nullable
  public abstract BlockState getTopSoil(WorldGenLevel level, RandomSource random);

  @Nullable
  public abstract BlockState getFillerSoil(WorldGenLevel level, RandomSource random);

  public abstract void decorate(WorldGenLevel level, ChunkGenerator generator, RandomSource random, BlockPos groundPos);

  public static final List<RuinedPortalDecoratorBase> PORTAL_DECORATORS = new ArrayList<>();
  public static void registerPortalDecorators() {
    PORTAL_DECORATORS.add(new NetherWastesRuinedPortalDecorator());
    PORTAL_DECORATORS.add(new SoulSandValleyRuinedPortalDecorator());
    PORTAL_DECORATORS.add(new BasaltDeltasRuinedPortalDecorator());
    PORTAL_DECORATORS.add(new CrimsonForestRuinedPortalDecorator());
    PORTAL_DECORATORS.add(new WarpedForestRuinedPortalDecorator());
  }

  public static RuinedPortalDecoratorBase getRandomPortalDecorator(RandomSource random) {
    int luckyNumber = random.nextInt(PORTAL_DECORATORS.size());
    return PORTAL_DECORATORS.get(luckyNumber);
  }

  @Override
  public String toString() {
    return this.name;
  }
}
