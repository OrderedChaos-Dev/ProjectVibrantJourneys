package projectvibrantjourneys.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import projectvibrantjourneys.init.PVJBiomes;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJEntities;
import projectvibrantjourneys.init.PVJEvents;
import projectvibrantjourneys.init.PVJFeatures;
import projectvibrantjourneys.init.PVJVanillaIntegration;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys {
	
	public static final String MOD_ID = "projectvibrantjourneys";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public ProjectVibrantJourneys() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PVJConfig.COMMON_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PVJConfig.CLIENT_CONFIG);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		
		PVJConfig.loadConfig(PVJConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("projectvibrantjourneys-common.toml"));
		PVJConfig.loadConfig(PVJConfig.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("projectvibrantjourneys-client.toml"));
		
		PVJEntities.preInitEntityTypes();
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {
		PVJBiomes.initBiomeTypes();
		MinecraftForge.EVENT_BUS.register(new PVJEvents());
	}
	
	private void clientSetup(FMLClientSetupEvent event) {
		//BiFunction<Minecraft, Screen, Screen> config_gui = (minecraft, screen) -> { return new ConfigScreen();};
		//ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> config_gui);
		PVJEntities.registerEntityRenderers();
		PVJBlocks.registerRenderers();
	}
	
	private void loadComplete(FMLLoadCompleteEvent event) {
		PVJBlocks.registerColors();
		PVJFeatures.init();
		PVJVanillaIntegration.init();
		PVJEntities.addSpawns();
	}
}
