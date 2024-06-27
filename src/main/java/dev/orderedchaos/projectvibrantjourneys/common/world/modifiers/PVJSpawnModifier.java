package dev.orderedchaos.projectvibrantjourneys.common.world.modifiers;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import dev.orderedchaos.projectvibrantjourneys.core.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBiomeModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

import java.util.Optional;

public record PVJSpawnModifier(TagKey<Biome> dimension, HolderSet<Biome> biomes, MobCategory category,
                               MobSpawnSettings.SpawnerData data, String configOption) implements BiomeModifier {

  @Override
  public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    if (phase == Phase.ADD) {
      Pair<ModConfigSpec.BooleanValue, Optional<ModConfigSpec.DoubleValue>> configValuePair = PVJConfig.configOptions.get(configOption);
      if (configValuePair.getFirst().get()) {
        if (biome.is(dimension)) {
          if (biomes.contains(biome)) {
            builder.getMobSpawnSettings().addSpawn(category, data);
          }
        }
      }
    }
  }

  @Override
  public MapCodec<? extends BiomeModifier> codec() {
    return PVJBiomeModifiers.SPAWN_MODIFIER_SERIALIZER.get();
  }

}