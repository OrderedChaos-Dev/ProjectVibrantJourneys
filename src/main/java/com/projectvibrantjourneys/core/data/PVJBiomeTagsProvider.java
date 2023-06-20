package com.projectvibrantjourneys.core.data;

import com.projectvibrantjourneys.core.config.PVJTags;
import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class PVJBiomeTagsProvider extends BiomeTagsProvider {
    public PVJBiomeTagsProvider(DataGenerator generator, String modid, @Nullable ExistingFileHelper helper) {
        super(generator, modid, helper);
    }

    @Override
    protected void addTags() {
        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.OAK) {
            addTag(PVJTags.HAS_OAK_LOGS, biome);
        }

        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.BIRCH) {
            addTag(PVJTags.HAS_BIRCH_LOGS, biome);
        }

        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.SPRUCE) {
            addTag(PVJTags.HAS_SPRUCE_LOGS, biome);
        }

        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.JUNGLE) {
            addTag(PVJTags.HAS_JUNGLE_LOGS, biome);
        }

        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.ACACIA) {
            addTag(PVJTags.HAS_ACACIA_LOGS, biome);
        }

        for (TreeFeatureUtils.ChanceBiomeEntry biome : PVJFeatureVars.DARK_OAK) {
            addTag(PVJTags.HAS_DARK_OAK_LOGS, biome);
        }
    }

    private void addTag(final TagKey<Biome> tagKey, final TreeFeatureUtils.ChanceBiomeEntry biome) {
        ResourceLocation location = new ResourceLocation(biome.biomeName());

        if (location.getNamespace().equals("minecraft")) {
            tag(tagKey).add(ForgeRegistries.BIOMES.getValue(location));
        } else {
            tag(tagKey).addOptional(location);
        }
    }
}
