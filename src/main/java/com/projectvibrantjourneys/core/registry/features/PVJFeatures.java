package com.projectvibrantjourneys.core.registry.features;

import com.projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import com.projectvibrantjourneys.common.world.features.FallenTreeFeature;
import com.projectvibrantjourneys.common.world.features.NaturalCobwebFeature;
import com.projectvibrantjourneys.common.world.features.RocksGroundcoverFeature;
import com.projectvibrantjourneys.common.world.features.SimpleBlockMatchWaterFeature;
import com.projectvibrantjourneys.common.world.features.configs.FallenTreeConfiguration;
import com.projectvibrantjourneys.common.world.features.stateproviders.DirectionalStateProvider;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ProjectVibrantJourneys.MOD_ID);
	
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> ROCKS = registerFeature("rocks", new RocksGroundcoverFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> BARK_MUSHROOM = registerFeature("bark_mushroom", new BarkMushroomFeature(NoneFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<SimpleBlockConfiguration>> SIMPLE_BLOCK_MATCH_WATER = registerFeature("simple_block_match_water", new SimpleBlockMatchWaterFeature(SimpleBlockConfiguration.CODEC));
	public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> NATURAL_COBWEB = registerFeature("natural_cobweb", new NaturalCobwebFeature(ProbabilityFeatureConfiguration.CODEC));
	public static final RegistryObject<Feature<FallenTreeConfiguration>> FALLEN_TREE = registerFeature("fallen_tree", new FallenTreeFeature(FallenTreeConfiguration.CODEC));

	private static<FC extends FeatureConfiguration> RegistryObject<Feature<FC>> registerFeature(String name, Feature<FC> feature) {
		return FEATURES.register(name, () -> feature);
	}
    
    public static class StateProviders {
    	
    	public static final DeferredRegister<BlockStateProviderType<?>> TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, ProjectVibrantJourneys.MOD_ID);
    	
    	public static final RegistryObject<BlockStateProviderType<DirectionalStateProvider>> DIRECTIONAL_STATE_PROVIDER = TYPES.register("directional_state_provider", () -> new BlockStateProviderType<>(DirectionalStateProvider.CODEC));
    }
}
