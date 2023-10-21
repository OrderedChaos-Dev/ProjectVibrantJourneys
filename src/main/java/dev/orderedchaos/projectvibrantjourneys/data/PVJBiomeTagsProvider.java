package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJTags;
import dev.orderedchaos.projectvibrantjourneys.util.PVJFeatureVars;
import dev.orderedchaos.projectvibrantjourneys.util.TreeFeatureUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class PVJBiomeTagsProvider extends BiomeTagsProvider {
    public PVJBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(packOutput, provider, ProjectVibrantJourneys.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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

    private void addTag(final TagKey<Biome> tagKey, final TreeFeatureUtils.ChanceBiomeEntry biomeEntry) {
        ResourceLocation location = new ResourceLocation(biomeEntry.biomeName().trim());

        if (location.getNamespace().equals("minecraft")) {
            Biome biome = ForgeRegistries.BIOMES.getValue(location);
            tag(tagKey).add(ResourceKey.create(Registries.BIOME, location));
        } else {
            tag(tagKey).addOptional(location);
        }
    }
}