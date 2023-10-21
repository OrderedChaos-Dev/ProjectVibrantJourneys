package dev.orderedchaos.projectvibrantjourneys.common.world.modifiers;

import com.mojang.serialization.Codec;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBiomeModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

import java.util.List;

public record PVJBiomeModifier(TagKey<Biome> dimension, List<HolderSet<Biome>> biomes, List<HolderSet<Biome>> blacklist, GenerationStep.Decoration decoration, Holder<PlacedFeature> feature, String configOption) implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(PVJConfig.configOptions.get(configOption).get()) {
            if(phase == Phase.ADD) {
                if(biome.is(dimension)) {
                    boolean flag = false;
                    for(HolderSet<Biome> set : biomes) {
                        if(set.contains(biome)) {
                            flag = true;
                            break;
                        }
                    }

                    if(flag) {
                        for(HolderSet<Biome> set : blacklist) {
                            if(set.contains(biome)) {
                                return;
                            }
                        }

                        builder.getGenerationSettings().addFeature(decoration, feature);
                    }
                }
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return PVJBiomeModifiers.BIOME_MODIFIER_SERIALIZER.get();
    }


}