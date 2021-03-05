package projectvibrantjourneys.core;

import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.FeatureManager;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJEvents;
import projectvibrantjourneys.init.PVJVanillaIntegration;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys {
	
	public static final String MOD_ID = "projectvibrantjourneys";
	public static final Logger LOGGER = LogManager.getLogManager().getLogger(MOD_ID);
	
	public ProjectVibrantJourneys() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PVJConfig.COMMON_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PVJConfig.CLIENT_CONFIG);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		
		PVJConfig.loadConfig(PVJConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("projectvibrantjourneys-common.toml"));
		PVJConfig.loadConfig(PVJConfig.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("projectvibrantjourneys-client.toml"));
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::onBiomeLoad);
		MinecraftForge.EVENT_BUS.register(new PVJEvents());
		FeatureManager.init();
	}
	
	private void clientSetup(FMLClientSetupEvent event) {
		PVJBlocks.registerRenderers();
		PVJBlocks.registerColors();
	}
	
	private void loadComplete(FMLLoadCompleteEvent event) {
		FeatureManager.init();
		PVJVanillaIntegration.init();
	}
	
	private void onBiomeLoad(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, event.getName());
		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		
		if(event.getCategory() == Biome.Category.NETHER) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> FeatureManager.charredBonesFeature);
		} else if(event.getCategory() != Biome.Category.THEEND) {
			
			//plants
			if(event.getCategory() == Biome.Category.BEACH || event.getCategory() == Biome.Category.OCEAN)
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.seaOatsFeature);
			if(!hasType(biomeTypes, Type.OCEAN, Type.BEACH)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.cattailFeature);
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.waterCattailsFeature);
			}
			//groundcover

			if(hasType(biomeTypes, Type.FOREST, Type.PLAINS)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.twigsFeature);
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.fallenLeavesFeature);
			}
			if(hasType(biomeTypes, Type.SNOWY)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.iceChunksFeature);
			}
			if(hasType(biomeTypes, Type.CONIFEROUS)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.pineconesFeature);
			}
			if(hasType(biomeTypes, Type.OCEAN, Type.BEACH)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.seashellsFeature);
			}
			event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.rocksFeature);
			event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.bonesFeature);
			
			if(hasType(biomeTypes, Type.PLAINS)) {
				event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.bushFeature);
			}
			event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.barkMushroomFeature);
			event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.cobwebsFeature);
		}
	}
	
	private boolean hasType(Set<BiomeDictionary.Type> list, BiomeDictionary.Type...types) {
		for(BiomeDictionary.Type t : types) {
			if(list.contains(t)) return true;
		}
		return false;
	}
}
