package projectvibrantjourneys.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import projectvibrantjourneys.client.block.BlockRendering;
import projectvibrantjourneys.init.PVJConfiguredFeatures;
import projectvibrantjourneys.init.PVJEvents;
import projectvibrantjourneys.init.PVJVanillaIntegration;
import projectvibrantjourneys.init.PVJWorldGen;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys {
	
	public static final String MOD_ID = "projectvibrantjourneys";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public ProjectVibrantJourneys() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PVJConfig.COMMON_CONFIG);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		
		PVJConfig.loadConfig(PVJConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("projectvibrantjourneys-common.toml"));
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PVJWorldGen::addBiomeFeatures);
		MinecraftForge.EVENT_BUS.register(new PVJEvents());
		PVJConfiguredFeatures.init();
		PVJVanillaIntegration.init();
	}
	
	private void clientSetup(FMLClientSetupEvent event) {
		BlockRendering.registerRenderers();
		BlockRendering.registerColors();
	}
	
	private void loadComplete(FMLLoadCompleteEvent event) {

	}
}
