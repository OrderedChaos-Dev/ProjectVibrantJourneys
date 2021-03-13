package projectvibrantjourneys.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

import org.codehaus.plexus.util.ExceptionUtils;

import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJWorldGen {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addBiomeFeatures(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<Supplier<ConfiguredFeature<?, ?>>> vegetalFeatures = event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
		
		if(event.getCategory() == Biome.Category.NETHER) {
			if(PVJConfig.charredBones.get())
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> PVJConfiguredFeatures.charred_bones);
			if(PVJConfig.glowcap.get())
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> PVJConfiguredFeatures.glowcap);
			
			if(PVJConfig.netherNettles.get()) {
				if(biome == Biomes.CRIMSON_FOREST)
					event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> PVJConfiguredFeatures.crimson_nettle);
				if(biome == Biomes.WARPED_FOREST)
					event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> PVJConfiguredFeatures.warped_nettle);
			}

		} else if(event.getCategory() != Biome.Category.THEEND) {
			//plants
			if(event.getCategory() == Biome.Category.BEACH || event.getCategory() == Biome.Category.OCEAN && !hasType(biomeTypes, Type.SNOWY) && PVJConfig.seaOats.get())
				vegetalFeatures.add(() -> PVJConfiguredFeatures.sea_oats);
			if(!hasType(biomeTypes, Type.OCEAN, Type.BEACH) && event.getCategory() != Biome.Category.DESERT && PVJConfig.cattails.get()) {
				vegetalFeatures.add(() -> PVJConfiguredFeatures.cattails);
				vegetalFeatures.add(() -> PVJConfiguredFeatures.water_cattails);
			}
			
			//groundcover
			if(hasType(biomeTypes, Type.FOREST, Type.PLAINS)) {
				if(PVJConfig.twigs.get())
					vegetalFeatures.add(() -> PVJConfiguredFeatures.twigs);
				
				if(PVJConfig.fallenLeaves.get())
					vegetalFeatures.add(() -> PVJConfiguredFeatures.fallen_leaves);
			}
			if(hasType(biomeTypes, Type.SNOWY) && PVJConfig.iceChunks.get()) {
				vegetalFeatures.add(() -> PVJConfiguredFeatures.ice_chunks);
			}
			if(hasType(biomeTypes, Type.CONIFEROUS) && PVJConfig.pinecones.get()) {
				vegetalFeatures.add(() -> PVJConfiguredFeatures.pinecones);
			}
			if(hasType(biomeTypes, Type.OCEAN, Type.BEACH) && PVJConfig.seashells.get()) {
				vegetalFeatures.add(() -> PVJConfiguredFeatures.seashells);
				vegetalFeatures.add(() -> PVJConfiguredFeatures.ocean_seashells);
			}
			
			if(PVJConfig.rocks.get())
				vegetalFeatures.add(() -> PVJConfiguredFeatures.rocks);
			
			if(PVJConfig.bones.get())
				vegetalFeatures.add(() -> PVJConfiguredFeatures.bones);
			
			if(hasType(biomeTypes, Type.PLAINS) && PVJConfig.bushes.get()) {
				vegetalFeatures.add(() -> PVJConfiguredFeatures.bushes);
			}
			
			if(PVJConfig.barkMushrooms.get())
				vegetalFeatures.add(() -> PVJConfiguredFeatures.bark_mushrooms);
			
			if(PVJConfig.cobwebs.get())
				vegetalFeatures.add(() -> PVJConfiguredFeatures.cobwebs);
			
			//other
			if(event.getCategory() != Biome.Category.DESERT
					&& event.getCategory() != Biome.Category.MESA
					&& event.getCategory() != Biome.Category.RIVER
					&& event.getCategory() != Biome.Category.OCEAN
					&& PVJConfig.moreSeagrass.get()) {
				vegetalFeatures.add(() -> Features.SEAGRASS_RIVER);
			}
			
			if(event.getCategory() == Biome.Category.RIVER && PVJConfig.moreGrassInRivers.get()) {
				vegetalFeatures.add(() -> Features.PATCH_GRASS_PLAIN);
			}
			if((event.getCategory() == Biome.Category.JUNGLE || hasType(biomeTypes, Type.JUNGLE)) && PVJConfig.jungleTropicalFish.get()) {
				event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 20, 1, 8));
			}
		}
	}
	
	/*
	 * EventPriority is low to ensure that feature lists of modded biomes are complete
	 */
	@SubscribeEvent(priority = EventPriority.LOW)
	public static void addFallenTreeFeatures(BiomeLoadingEvent event) {
		if(!PVJConfig.fallenTrees.get())
			return;
		
		//just gonna wrap this in a try catch to really make sure things don't go fubar
		try {
//			ProjectVibrantJourneys.LOGGER.debug(event.getName().toString());
			List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
			RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, event.getName());
			Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
			List<Pair<ConfiguredFeature<?, ?>, Float>> trees = new ArrayList<Pair<ConfiguredFeature<?, ?>, Float>>();
			List<Block> logs = new ArrayList<Block>();
			for(Supplier<ConfiguredFeature<?, ?>> cf : features)
				getFeatureNames(cf.get(), trees);
			
			Random rand = new Random();
			
			for(Pair<ConfiguredFeature<?, ?>, Float> pair : trees) {
				if(pair.getFirst().getConfig() instanceof BaseTreeFeatureConfig) {
					try {
						Block block = ((BaseTreeFeatureConfig)pair.getFirst().getConfig()).trunkProvider.getBlockState(rand, null).getBlock();
//						ProjectVibrantJourneys.LOGGER.debug("----> " + block.getRegistryName());
						if(!logs.contains(block)) {							
							features.add(() -> {
								float chance = pair.getSecond() > 0 ? pair.getSecond() / 2.0F : 0.05F;
								if(event.getCategory() == Category.PLAINS || hasType(biomeTypes, Type.PLAINS, Type.SAVANNA, Type.MESA, Type.WASTELAND, Type.DRY))
									chance =  chance / 2.0F;
								return PVJConfiguredFeatures.getOrCreateFallenTreeFeature(block).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, chance, 1)));
							});
						}
						logs.add(block);
					} catch(Exception e) {}
				}
			}
		} catch(Exception e) {
			ProjectVibrantJourneys.LOGGER.debug("Caught error when trying to add fallen trees:" + ExceptionUtils.getStackTrace(e));
			
		}
	
	}
	
	//used to help find tree features hidden in decorated configured features
	//most biomes group their trees in random selectors, these features are added to a list
	public static String getFeatureNames(ConfiguredFeature<?, ?> cf, List<Pair<ConfiguredFeature<?, ?>, Float>> list) {
		if(Feature.RANDOM_SELECTOR.getRegistryName().equals(cf.getFeature().getRegistryName())) {
			((MultipleRandomFeatureConfig)cf.getConfig()).features.forEach((s) -> list.add(createPair(s.feature.get(), s.chance)));
		} else if(cf.getConfig() instanceof DecoratedFeatureConfig) {
			ConfiguredFeature<?, ?> feature = ((DecoratedFeatureConfig)cf.getConfig()).feature.get();
			
			if(feature.getConfig() instanceof BaseTreeFeatureConfig) {
				list.add(createPair(feature, 0.0F));
			} else
				return getFeatureNames(feature, list);
		}
		return cf.getFeature().getRegistryName().toString();
	}
	
	public static Pair<ConfiguredFeature<?, ?>, Float> createPair(ConfiguredFeature<?, ?> c, float f) {
		return new Pair<ConfiguredFeature<?, ?>, Float>(c, f);
	}
	
	
	private static boolean hasType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type...types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t)) return true;
		}
		return false;
	}
}
