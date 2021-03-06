package projectvibrantjourneys.init;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.FeatureManager;
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
				event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> FeatureManager.charredBonesFeature);
		} else if(event.getCategory() != Biome.Category.THEEND) {
			//plants
			if(event.getCategory() == Biome.Category.BEACH || event.getCategory() == Biome.Category.OCEAN && PVJConfig.seaOats.get())
				vegetalFeatures.add(() -> FeatureManager.seaOatsFeature);
			if(!hasType(biomeTypes, Type.OCEAN, Type.BEACH) && event.getCategory() != Biome.Category.DESERT && PVJConfig.cattails.get()) {
				vegetalFeatures.add(() -> FeatureManager.cattailFeature);
				vegetalFeatures.add(() -> FeatureManager.waterCattailsFeature);
			}
			
			//groundcover
			if(hasType(biomeTypes, Type.FOREST, Type.PLAINS)) {
				if(PVJConfig.twigs.get())
					vegetalFeatures.add(() -> FeatureManager.twigsFeature);
				
				if(PVJConfig.fallenLeaves.get())
					vegetalFeatures.add(() -> FeatureManager.fallenLeavesFeature);
			}
			if(hasType(biomeTypes, Type.SNOWY) && PVJConfig.iceChunks.get()) {
				vegetalFeatures.add(() -> FeatureManager.iceChunksFeature);
			}
			if(hasType(biomeTypes, Type.CONIFEROUS) && PVJConfig.pinecones.get()) {
				vegetalFeatures.add(() -> FeatureManager.pineconesFeature);
			}
			if(hasType(biomeTypes, Type.OCEAN, Type.BEACH) && PVJConfig.seashells.get()) {
				vegetalFeatures.add(() -> FeatureManager.seashellsFeature);
				vegetalFeatures.add(() -> FeatureManager.oceanSeashellsFeature);
			}
			
			if(PVJConfig.rocks.get())
				vegetalFeatures.add(() -> FeatureManager.rocksFeature);
			
			if(PVJConfig.bones.get())
				vegetalFeatures.add(() -> FeatureManager.bonesFeature);
			
			if(hasType(biomeTypes, Type.PLAINS) && PVJConfig.bushes.get()) {
				vegetalFeatures.add(() -> FeatureManager.bushFeature);
			}
			
			if(PVJConfig.barkMushrooms.get())
				vegetalFeatures.add(() -> FeatureManager.barkMushroomFeature);
			
			if(PVJConfig.cobwebs.get())
				vegetalFeatures.add(() -> FeatureManager.cobwebsFeature);
			
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
	
	private static boolean hasType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type...types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t)) return true;
		}
		return false;
	}
}
