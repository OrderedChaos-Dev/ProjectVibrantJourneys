package com.projectvibrantjourneys.event;

import java.util.List;
import java.util.Set;

import com.projectvibrantjourneys.core.PVJConfig;
import com.projectvibrantjourneys.init.world.PVJBiomes;
import com.projectvibrantjourneys.init.world.placements.PVJPlacements;

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
					
					if(PVJConfig.CONFIG_DATA.enableFallenLeaves.get())
						vegetalFeatures.add(PVJPlacements.FALLEN_LEAVES.getHolder().get());
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
				
				if(PVJConfig.CONFIG_DATA.enableBarkMushrooms.get()) {
					vegetalFeatures.add(PVJPlacements.BARK_MUSHROOM.getHolder().get());
				}
				
				if(biomeTypes.contains(Type.BEACH)) {
					
					if(PVJConfig.CONFIG_DATA.enableSeaOats.get())
						vegetalFeatures.add(PVJPlacements.SEA_OATS.getHolder().get());
						
					if(PVJConfig.CONFIG_DATA.enableBeachGrass.get())
						vegetalFeatures.add(PVJPlacements.BEACH_GRASS.getHolder().get());
					
					if(PVJConfig.CONFIG_DATA.enablePalmTrees.get())
						vegetalFeatures.add(PVJPlacements.TREES_PALM.getHolder().get());
				}
				
				if(!hasAnyType(biomeTypes, Type.OCEAN, Type.BEACH) && (event.getCategory() != Biome.BiomeCategory.DESERT || biome == PVJBiomes.Keys.VERDANT_SANDS)) {
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
			}

			if(biome == Biomes.LUSH_CAVES) {
				vegetalFeatures.add(PVJPlacements.EXTRA_VEGETATION_LUSH_CAVES.getHolder().get());
			}
		}
		
		//ENTITY STUFF
		if(biomeTypes.contains(Type.OVERWORLD)) {
			if(event.getCategory() == Biome.BiomeCategory.JUNGLE && PVJConfig.CONFIG_DATA.enableJungleTropicalFish.get()) {
				mobSpawns.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 5, 5));
			}
		}

		
		//BIOMES
		if(biome == PVJBiomes.Keys.PINE_MEADOWS) {
			vegetalFeatures.add(PVJPlacements.PINE_MEADOWS_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.VERDANT_SANDS) {
//			vegetalFeatures.add(PVJPlacements.LUSH_CACTUS);
		} else if(biome == PVJBiomes.Keys.AUTUMNAL_CONIFEROUS_FOREST) {
			vegetalFeatures.add(PVJPlacements.AUTUMNAL_CONIFEROUS_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.BOREAL_FOREST || biome == PVJBiomes.Keys.SNOWY_BOREAL_FOREST) {
			vegetalFeatures.add(PVJPlacements.BOREAL_FOREST_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.DESERT_SHRUBLAND) {
			vegetalFeatures.add(PVJPlacements.DRY_GRASS.getHolder().get());
			vegetalFeatures.add(PVJPlacements.DESERT_SAGE.getHolder().get());
			vegetalFeatures.add(PVJPlacements.DESERT_AGAVE.getHolder().get());
			vegetalFeatures.add(PVJPlacements.DESERT_SHRUBLAND_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.OVERGROWN_SPIRES) {
			vegetalFeatures.add(PVJPlacements.OVERGROWN_SPIRES_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.PRAIRIE) {
			vegetalFeatures.add(PVJPlacements.PRAIRIE_TREES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.PRAIRIE_GRASS.getHolder().get());
		} else if(biome == PVJBiomes.Keys.BAOBAB_FIELDS) {
			vegetalFeatures.add(PVJPlacements.BAOBAB_FIELDS_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.REDWOODS || biome == PVJBiomes.Keys.SNOWY_REDWOODS) {
			vegetalFeatures.add(PVJPlacements.REDWOOD_FOREST_TREES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.CRYSTAL_LAKES) {
			vegetalFeatures.add(PVJPlacements.CRYSTAL_LAKES_TREES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.CRYSTAL_POOL.getHolder().get());
			vegetalFeatures.add(PVJPlacements.AMETHYST_CRYSTALS.getHolder().get());
		} else if(biome == PVJBiomes.Keys.BLOSSOMING_FIELDS) {
			vegetalFeatures.add(PVJPlacements.BLOSSOMING_FIELDS_TREES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.WHITE_SAKURA_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.PINK_SAKURA_FALLEN_LEAVES.getHolder().get());
		} else if(biome == PVJBiomes.Keys.ASPEN_GROVE) {
			vegetalFeatures.add(PVJPlacements.ASPEN_GROVE_TREES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.RED_MAPLE_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.ORANGE_MAPLE_FALLEN_LEAVES.getHolder().get());
			vegetalFeatures.add(PVJPlacements.PURPLE_MAPLE_FALLEN_LEAVES.getHolder().get());
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
