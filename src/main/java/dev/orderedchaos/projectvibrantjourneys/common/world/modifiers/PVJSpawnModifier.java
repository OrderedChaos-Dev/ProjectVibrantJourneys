package dev.orderedchaos.projectvibrantjourneys.common.world.modifiers;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBiomeModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record PVJSpawnModifier(TagKey<Biome> dimension, HolderSet<Biome> biomes, MobCategory category, MobSpawnSettings.SpawnerData data, String configOption) implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(phase == Phase.ADD) {
            if(PVJConfig.configOptions.get(configOption).get()) {
                if(biome.is(dimension)) {
                    if(biomes.contains(biome)) {
                        builder.getMobSpawnSettings().addSpawn(category, data);
                    }
                }
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return PVJBiomeModifiers.SPAWN_MODIFIER_SERIALIZER.get();
    }


}