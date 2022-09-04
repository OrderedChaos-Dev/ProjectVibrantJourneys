package com.projectvibrantjourneys.event;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.projectvibrantjourneys.core.config.PVJConfig;
import com.projectvibrantjourneys.core.registry.features.PVJPlacements;
import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
public class PVJWorldGenEvents {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void addBiomeFeatures(BiomeLoadingEvent event) {
		ResourceKey<Biome> biome = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		
		Optional<Holder<Biome>> holder = ForgeRegistries.BIOMES.getHolder(biome);

		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<Holder<PlacedFeature>> vegetalFeatures = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
		MobSpawnSettingsBuilder mobSpawns = event.getSpawns();
		
		
		//WORLD GENERATION
		if(event.getCategory() == Biome.BiomeCategory.NETHER) {

			addFeature(vegetalFeatures, PVJPlacements.CHARRED_BONES, PVJConfig.CONFIG_DATA.enableCharredBones, true);
			addFeature(vegetalFeatures, PVJPlacements.GLOWCAP, PVJConfig.CONFIG_DATA.enableGlowcap, true);
			addFeature(vegetalFeatures, PVJPlacements.CINDERCANE, PVJConfig.CONFIG_DATA.enableCindercane, true);
			addFeature(vegetalFeatures, PVJPlacements.WARPED_NETTLE, PVJConfig.CONFIG_DATA.enableNetherNettles, biome == Biomes.WARPED_FOREST);
			addFeature(vegetalFeatures, PVJPlacements.CRIMSON_NETTLE, PVJConfig.CONFIG_DATA.enableNetherNettles, biome == Biomes.CRIMSON_FOREST);
		} else if(overworld(biomeTypes, holder) && !biome.getRegistryName().toString().equals("biomesoplenty:origin_valley")) {
			
			//disable worldgen in snowy plains because it looks ugly
			if(biome != Biomes.SNOWY_PLAINS && event.getCategory() != Biome.BiomeCategory.MUSHROOM) {
				addFeature(vegetalFeatures, PVJPlacements.TWIGS, PVJConfig.CONFIG_DATA.enableTwigs, forestOrPlains(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.FALLEN_LEAVES, PVJConfig.CONFIG_DATA.enableFallenLeaves, forestOrPlains(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.PINECONES, PVJConfig.CONFIG_DATA.enablePinecones, coniferous(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.SEASHELLS, PVJConfig.CONFIG_DATA.enableSeashells, oceanOrBeach(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.OCEAN_FLOOR_SEASHELLS, PVJConfig.CONFIG_DATA.enableSeashells, oceanOrBeach(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.EXTRA_OCEAN_FLOOR_SEASHELLS, PVJConfig.CONFIG_DATA.enableSeashells, oceanOrBeach(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.ROCKS, PVJConfig.CONFIG_DATA.enableRocks, true);
				addFeature(vegetalFeatures, PVJPlacements.BONES, PVJConfig.CONFIG_DATA.enableBones, true);
				addFeature(vegetalFeatures, PVJPlacements.ICE_CHUNKS, PVJConfig.CONFIG_DATA.enableIceChunks, snowy(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.BADLANDS_DEAD_FALLEN_LEAVES, PVJConfig.CONFIG_DATA.enableFallenLeaves, biome == Biomes.WOODED_BADLANDS);
				addFeature(vegetalFeatures, PVJPlacements.DENSE_DEAD_FALLEN_LEAVES, PVJConfig.CONFIG_DATA.enableFallenLeaves, biome == Biomes.OLD_GROWTH_PINE_TAIGA || biome == Biomes.OLD_GROWTH_SPRUCE_TAIGA);
				addFeature(vegetalFeatures, PVJPlacements.MOSS_CARPET, PVJConfig.CONFIG_DATA.enableMossCarpets, biome == Biomes.OLD_GROWTH_PINE_TAIGA || biome == Biomes.OLD_GROWTH_SPRUCE_TAIGA);
				addFeature(vegetalFeatures, PVJPlacements.BARK_MUSHROOM, PVJConfig.CONFIG_DATA.enableBarkMushrooms, true);
				addFeature(vegetalFeatures, PVJPlacements.SEA_OATS, PVJConfig.CONFIG_DATA.enableSeaOats, beach(biomeTypes, holder) && !veryCold(biome));
				addFeature(vegetalFeatures, PVJPlacements.BEACH_GRASS, PVJConfig.CONFIG_DATA.enableBeachGrass, beach(biomeTypes, holder));
				addFeature(vegetalFeatures, PVJPlacements.CATTAILS, PVJConfig.CONFIG_DATA.enableCattails, !oceanOrBeach(biomeTypes, holder) && !veryCold(biome) && event.getCategory() != Biome.BiomeCategory.MESA);
				addFeature(vegetalFeatures, PVJPlacements.SHORT_GRASS, PVJConfig.CONFIG_DATA.enableShortGrass, true);
				addFeature(vegetalFeatures, PVJPlacements.NATURAL_COBWEB, PVJConfig.CONFIG_DATA.enableNaturalCobwebs, true);
				addFeature(vegetalFeatures, PVJPlacements.SMALL_CACTUS, PVJConfig.CONFIG_DATA.enableSmallCacti, event.getCategory() == Biome.BiomeCategory.DESERT);
				addFeature(vegetalFeatures, PVJPlacements.EXTRA_SEAGRASS, PVJConfig.CONFIG_DATA.enableExtraSeagrass, inlandNotDesert(event.getCategory()));
				addFeature(vegetalFeatures, PVJPlacements.EXTRA_LILYPADS, PVJConfig.CONFIG_DATA.enableExtraLilypads, inlandNotDesert(event.getCategory()) && !veryCold(biome));
				addFeature(vegetalFeatures, PVJPlacements.EXTRA_GRASS, PVJConfig.CONFIG_DATA.enableExtraRiverGrass, event.getCategory() == Biome.BiomeCategory.RIVER);
				addFeature(vegetalFeatures, PVJPlacements.TIDE_POOL, PVJConfig.CONFIG_DATA.enableTidePools, biome == Biomes.STONY_SHORE);
				addFeature(vegetalFeatures, PVJPlacements.PRICKLY_BUSH, PVJConfig.CONFIG_DATA.enablePricklyBush, biome == Biomes.WOODED_BADLANDS);
				addFeature(vegetalFeatures, PVJPlacements.REEDS, PVJConfig.CONFIG_DATA.enableReeds, event.getCategory() == Biome.BiomeCategory.PLAINS || event.getCategory() == Biome.BiomeCategory.SAVANNA);
				
				addFeature(vegetalFeatures, PVJPlacements.OAK_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.OAK, event.getName()));
				addFeature(vegetalFeatures, PVJPlacements.BIRCH_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.BIRCH, event.getName()));
				addFeature(vegetalFeatures, PVJPlacements.SPRUCE_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.SPRUCE, event.getName()));
				addFeature(vegetalFeatures, PVJPlacements.JUNGLE_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.JUNGLE, event.getName()));
				addFeature(vegetalFeatures, PVJPlacements.ACACIA_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.ACACIA, event.getName()));
				addFeature(vegetalFeatures, PVJPlacements.DARK_OAK_FALLEN_TREE, PVJConfig.CONFIG_DATA.enableFallenTrees, TreeFeatureUtils.isIn(PVJFeatureVars.DARK_OAK, event.getName()));
			}
		}
		
		//ENTITY STUFF
		if(biomeTypes.contains(Type.OVERWORLD) || hasAnyTag(holder, Tags.Biomes.IS_OVERWORLD)) {
			addSpawn(mobSpawns, MobCategory.WATER_AMBIENT, EntityType.TROPICAL_FISH, 25, 5, 5, PVJConfig.CONFIG_DATA.enableJungleTropicalFish, event.getCategory() == Biome.BiomeCategory.JUNGLE);
			addSpawn(mobSpawns, MobCategory.WATER_AMBIENT, EntityType.COD, 25, 1, 4, PVJConfig.CONFIG_DATA.enableTidePools, biome == Biomes.STONY_SHORE);
		}
	}
	
	private boolean hasAnyType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type... types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t))
				return true;
		}
		return false;
	}
	
	@SafeVarargs
	private boolean hasAnyTag(Optional<Holder<Biome>> biome, TagKey<Biome>... tags) {
//		for(TagKey<Biome> tag : tags) {
//			return biome.is(tag);
//		}
		return false;
	}
	
	private void addFeature(List<Holder<PlacedFeature>> decorations, Holder<PlacedFeature> placedFeature, ForgeConfigSpec.BooleanValue configValue, boolean conditions) {
		if(configValue.get() && conditions)
			decorations.add(placedFeature);
	}
	
	private void addFeature(List<Holder<PlacedFeature>> decorations, RegistryObject<PlacedFeature> placedFeature, ForgeConfigSpec.BooleanValue configValue, boolean conditions) {
		addFeature(decorations, placedFeature.getHolder().get(), configValue, conditions);
	}
	
	private void addSpawn(MobSpawnSettingsBuilder spawns, MobCategory category, EntityType<?> entityType, int weight, int minCount, int maxCount, ForgeConfigSpec.BooleanValue configValue, boolean conditions) {
		if(configValue.get() && conditions)
			spawns.addSpawn(category, new MobSpawnSettings.SpawnerData(entityType, weight, minCount, maxCount));
	}
	
	private boolean forestOrPlains(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>>holder) {
		return hasAnyType(biomeTypes, Type.FOREST, Type.PLAINS) || hasAnyTag(holder, Tags.Biomes.IS_PLAINS, BiomeTags.IS_FOREST);
	}
	
	private boolean oceanOrBeach(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>> holder) {
		return (hasAnyType(biomeTypes, Type.OCEAN, Type.BEACH) || hasAnyTag(holder, Tags.Biomes.IS_BEACH, BiomeTags.IS_BEACH, BiomeTags.IS_OCEAN));
	}
	
	private boolean beach(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>> holder) {
		return (hasAnyType(biomeTypes, Type.BEACH) || hasAnyTag(holder, Tags.Biomes.IS_BEACH, BiomeTags.IS_BEACH));
	}
	
	private boolean coniferous(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>> holder) {
		return hasAnyType(biomeTypes, Type.CONIFEROUS) || hasAnyTag(holder, Tags.Biomes.IS_CONIFEROUS);
	}
	
	private boolean snowy(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>> holder) {
		return hasAnyType(biomeTypes, Type.SNOWY) || hasAnyTag(holder, Tags.Biomes.IS_SNOWY);
	}
	
	
	//basically snowy biomes except snowy taiga
	private boolean veryCold(ResourceKey<Biome> biome) {
		return biome == Biomes.FROZEN_RIVER || biome == Biomes.SNOWY_PLAINS || biome == Biomes.SNOWY_BEACH || biome == Biomes.SNOWY_SLOPES
				|| biome == Biomes.ICE_SPIKES || biome == Biomes.FROZEN_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN;
	}
	
	private boolean inlandNotDesert(BiomeCategory category) {
		return category != Biome.BiomeCategory.DESERT && category != Biome.BiomeCategory.MESA && category != Biome.BiomeCategory.RIVER && category != Biome.BiomeCategory.OCEAN && category != Biome.BiomeCategory.BEACH;
	}
	
	private boolean overworld(Set<BiomeDictionary.Type> biomeTypes, Optional<Holder<Biome>> holder) {
		return biomeTypes.contains(Type.OVERWORLD) || hasAnyTag(holder, Tags.Biomes.IS_OVERWORLD);
	}
}
