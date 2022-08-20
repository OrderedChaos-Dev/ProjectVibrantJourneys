package com.projectvibrantjourneys.event;

import java.util.List;
import java.util.Set;

import com.projectvibrantjourneys.core.config.PVJConfig;
import com.projectvibrantjourneys.core.config.WeightedTreeFeatureConfig;
import com.projectvibrantjourneys.core.registry.features.PVJPlacements;
import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class PVJWorldGenEvents {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void addBiomeFeatures(BiomeLoadingEvent event) {
		ResourceKey<Biome> biome = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		List<Holder<PlacedFeature>> vegetalFeatures = event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION);
		MobSpawnSettingsBuilder mobSpawns = event.getSpawns();
		
		if(event.getCategory() == Biome.BiomeCategory.NETHER) {
			
			if(PVJConfig.CONFIG_DATA.enableCharredBones.get())
				vegetalFeatures.add(PVJPlacements.CHARRED_BONES.getHolder().get());
			
			if(PVJConfig.CONFIG_DATA.enableGlowcap.get())
				vegetalFeatures.add(PVJPlacements.GLOWCAP.getHolder().get());
			
			if(PVJConfig.CONFIG_DATA.enableCindercane.get())
				vegetalFeatures.add(PVJPlacements.CINDERCANE.getHolder().get());
			
			if(biome == Biomes.WARPED_FOREST && PVJConfig.CONFIG_DATA.enableNetherNettles.get()) {
				vegetalFeatures.add(PVJPlacements.WARPED_NETTLE.getHolder().get());
			}
			
			if(biome == Biomes.CRIMSON_FOREST && PVJConfig.CONFIG_DATA.enableNetherNettles.get()) {
				vegetalFeatures.add(PVJPlacements.CRIMSON_NETTLE.getHolder().get());
			}
			
		} else if(biomeTypes.contains(Type.OVERWORLD)) {
			if(biome != Biomes.SNOWY_PLAINS && event.getCategory() != Biome.BiomeCategory.MUSHROOM) {
				if(hasAnyType(biomeTypes, Type.FOREST, Type.PLAINS)) {
					
					if(PVJConfig.CONFIG_DATA.enableTwigs.get())
						vegetalFeatures.add(PVJPlacements.TWIGS.getHolder().get());
					
					if(PVJConfig.CONFIG_DATA.enableFallenLeaves.get()) {
						vegetalFeatures.add(PVJPlacements.FALLEN_LEAVES.getHolder().get());
//						vegetalFeatures.add(PVJPlacements.DEAD_FALLEN_LEAVES.getHolder().get());
					}
				}
				if(hasAnyType(biomeTypes, Type.CONIFEROUS) && PVJConfig.CONFIG_DATA.enablePinecones.get()) {
					vegetalFeatures.add(PVJPlacements.PINECONES.getHolder().get());
				}
				if(hasAnyType(biomeTypes, Type.OCEAN, Type.BEACH) && PVJConfig.CONFIG_DATA.enableSeashells.get()) {
					vegetalFeatures.add(PVJPlacements.SEASHELLS.getHolder().get());
				}
				
				if(hasAnyType(biomeTypes, Type.OCEAN) && PVJConfig.CONFIG_DATA.enableSeashells.get()) {
					vegetalFeatures.add(PVJPlacements.OCEAN_FLOOR_SEASHELLS.getHolder().get());
				}
				
				if(biome == Biomes.WARM_OCEAN && PVJConfig.CONFIG_DATA.enableSeashells.get()) {
					vegetalFeatures.add(PVJPlacements.EXTRA_OCEAN_FLOOR_SEASHELLS.getHolder().get());
				}
				
				if(PVJConfig.CONFIG_DATA.enableRocks.get())
					vegetalFeatures.add(PVJPlacements.ROCKS.getHolder().get());
				
				if(PVJConfig.CONFIG_DATA.enableBones.get())
					vegetalFeatures.add(PVJPlacements.BONES.getHolder().get());
			
				if(hasAnyType(biomeTypes, Type.SNOWY) && PVJConfig.CONFIG_DATA.enableIceChunks.get()) {
					vegetalFeatures.add(PVJPlacements.ICE_CHUNKS.getHolder().get());
				}
				
				if(biome == Biomes.OLD_GROWTH_PINE_TAIGA || biome == Biomes.OLD_GROWTH_SPRUCE_TAIGA) {
					if(PVJConfig.CONFIG_DATA.enableFallenLeaves.get()) {
						vegetalFeatures.add(PVJPlacements.DENSE_DEAD_FALLEN_LEAVES.getHolder().get());
					}
					vegetalFeatures.add(PVJPlacements.MOSS_CARPET.getHolder().get());
				}
				
				if(PVJConfig.CONFIG_DATA.enableBarkMushrooms.get()) {
					vegetalFeatures.add(PVJPlacements.BARK_MUSHROOM.getHolder().get());
				}
				
				if(biomeTypes.contains(Type.BEACH)) {
					
					if(PVJConfig.CONFIG_DATA.enableSeaOats.get())
						vegetalFeatures.add(PVJPlacements.SEA_OATS.getHolder().get());
						
					if(PVJConfig.CONFIG_DATA.enableBeachGrass.get())
						vegetalFeatures.add(PVJPlacements.BEACH_GRASS.getHolder().get());
				}
				
				if(!hasAnyType(biomeTypes, Type.OCEAN, Type.BEACH) && (event.getCategory() != Biome.BiomeCategory.DESERT)) {
					if(PVJConfig.CONFIG_DATA.enableCattails.get())
						vegetalFeatures.add(PVJPlacements.CATTAILS.getHolder().get());
				}
				
				if(PVJConfig.CONFIG_DATA.enableShortGrass.get()) {
					vegetalFeatures.add(PVJPlacements.SHORT_GRASS.getHolder().get());
				}
				
				if(PVJConfig.CONFIG_DATA.enableNaturalCobwebs.get()) {
					vegetalFeatures.add(PVJPlacements.NATURAL_COBWEB.getHolder().get());
				}
				
				if(event.getCategory() == Biome.BiomeCategory.DESERT) {
					if(PVJConfig.CONFIG_DATA.enableSmallCacti.get())
						vegetalFeatures.add(PVJPlacements.SMALL_CACTUS.getHolder().get());
				}
				
				if(event.getCategory() != Biome.BiomeCategory.DESERT
						&& event.getCategory() != Biome.BiomeCategory.MESA
						&& event.getCategory() != Biome.BiomeCategory.RIVER
						&& event.getCategory() != Biome.BiomeCategory.OCEAN
						&& event.getCategory() != Biome.BiomeCategory.BEACH) {
					
					if(PVJConfig.CONFIG_DATA.enableExtraSeagrass.get())
						vegetalFeatures.add(AquaticPlacements.SEAGRASS_RIVER);
					
					if(PVJConfig.CONFIG_DATA.enableExtraLilypads.get())
						vegetalFeatures.add(VegetationPlacements.PATCH_WATERLILY);
				}
				
				if(event.getCategory() == Biome.BiomeCategory.RIVER) {
					if(PVJConfig.CONFIG_DATA.enableExtraRiverGrass.get())
						vegetalFeatures.add(VegetationPlacements.PATCH_GRASS_PLAIN);
				}
				
				if(TreeFeatureUtils.isIn(PVJFeatureVars.OAK, event.getName())) {
					vegetalFeatures.add(PVJPlacements.OAK_FALLEN_TREE.getHolder().get());
				}
				if(TreeFeatureUtils.isIn(PVJFeatureVars.BIRCH, event.getName())) {
					vegetalFeatures.add(PVJPlacements.BIRCH_FALLEN_TREE.getHolder().get());
				}
				if(TreeFeatureUtils.isIn(PVJFeatureVars.SPRUCE, event.getName())) {
					vegetalFeatures.add(PVJPlacements.SPRUCE_FALLEN_TREE.getHolder().get());
				}
				if(TreeFeatureUtils.isIn(PVJFeatureVars.JUNGLE, event.getName())) {
					vegetalFeatures.add(PVJPlacements.JUNGLE_FALLEN_TREE.getHolder().get());
				}
				if(TreeFeatureUtils.isIn(PVJFeatureVars.ACACIA, event.getName())) {
					vegetalFeatures.add(PVJPlacements.ACACIA_FALLEN_TREE.getHolder().get());
				}
				if(TreeFeatureUtils.isIn(PVJFeatureVars.DARK_OAK, event.getName())) {
					vegetalFeatures.add(PVJPlacements.DARK_OAK_FALLEN_TREE.getHolder().get());
				}
			}
		}
		
		//ENTITY STUFF
		if(biomeTypes.contains(Type.OVERWORLD)) {
			if(event.getCategory() == Biome.BiomeCategory.JUNGLE && PVJConfig.CONFIG_DATA.enableJungleTropicalFish.get()) {
				mobSpawns.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 5, 5));
			}
		}
	}
	
	private boolean hasAnyType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type... types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t))
				return true;
		}
		
		return false;
	}
}
