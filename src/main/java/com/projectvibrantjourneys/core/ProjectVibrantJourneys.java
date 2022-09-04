package com.projectvibrantjourneys.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projectvibrantjourneys.client.BlockRendering;
import com.projectvibrantjourneys.common.PVJCompostables;
import com.projectvibrantjourneys.core.config.ChanceTreeFeatureConfig;
import com.projectvibrantjourneys.core.config.PVJConfig;
import com.projectvibrantjourneys.core.registry.PVJBlocks;
import com.projectvibrantjourneys.core.registry.PVJItems;
import com.projectvibrantjourneys.core.registry.features.PVJConfiguredFeatures;
import com.projectvibrantjourneys.core.registry.features.PVJFeatures;
import com.projectvibrantjourneys.core.registry.features.PVJPlacements;
import com.projectvibrantjourneys.event.PVJGeneralEvents;
import com.projectvibrantjourneys.event.PVJWorldGenEvents;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ProjectVibrantJourneys.MOD_ID)
public class ProjectVibrantJourneys
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "projectvibrantjourneys";
    
    public ProjectVibrantJourneys() {                
		ChanceTreeFeatureConfig.init();
		
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
    	PVJBlocks.BLOCKS.register(bus);
        PVJItems.ITEMS.register(bus);
        PVJFeatures.FEATURES.register(bus);
        PVJFeatures.StateProviders.TYPES.register(bus);
        PVJConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
        PVJPlacements.PLACED_FEATURES.register(bus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PVJConfig.CONFIG);

        MinecraftForge.EVENT_BUS.register(new PVJWorldGenEvents());
        MinecraftForge.EVENT_BUS.register(new PVJGeneralEvents());
        MinecraftForge.EVENT_BUS.register(this);
        
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    	event.enqueueWork(() -> {
    		PVJCompostables.init();
    	});
    	
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
    	event.enqueueWork(() -> {
        	BlockRendering.registerRenderers();
    	});
    }
    

}
