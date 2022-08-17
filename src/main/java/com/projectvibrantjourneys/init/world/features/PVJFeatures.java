package com.projectvibrantjourneys.init.world.features;

import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.world.gen.features.BarkSideFeature;
import com.projectvibrantjourneys.world.gen.features.NaturalCobwebFeature;
import com.projectvibrantjourneys.world.gen.features.RocksGroundcoverFeature;
import com.projectvibrantjourneys.world.gen.features.SimpleBlockMatchWaterFeature;
import com.projectvibrantjourneys.world.gen.features.stateproviders.DirectionalStateProvider;

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
	public static final RegistryObject<Feature<SimpleBlockConfiguration>> BARK_MUSHROOM = registerFeature("bark_mushroom", new BarkSideFeature(SimpleBlockConfiguration.CODEC));
	public static final RegistryObject<Feature<SimpleBlockConfiguration>> SIMPLE_BLOCK_MATCH_WATER = registerFeature("simple_block_match_water", new SimpleBlockMatchWaterFeature(SimpleBlockConfiguration.CODEC));
	public static final RegistryObject<Feature<ProbabilityFeatureConfiguration>> NATURAL_COBWEB = registerFeature("natural_cobweb", new NaturalCobwebFeature(ProbabilityFeatureConfiguration.CODEC));

	private static<FC extends FeatureConfiguration> RegistryObject<Feature<FC>> registerFeature(String name, Feature<FC> feature) {
		return FEATURES.register(name, () -> feature);
	}
    
    public static class StateProviders {
    	
    	public static final DeferredRegister<BlockStateProviderType<?>> TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, ProjectVibrantJourneys.MOD_ID);
    	
    	public static final RegistryObject<BlockStateProviderType<DirectionalStateProvider>> DIRECTIONAL_STATE_PROVIDER = TYPES.register("directional_state_provider", () -> new BlockStateProviderType<>(DirectionalStateProvider.CODEC));
    }
}
