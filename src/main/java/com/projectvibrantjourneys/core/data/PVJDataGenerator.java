package com.projectvibrantjourneys.core.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PVJDataGenerator {

	@SubscribeEvent
    public static void data(GatherDataEvent event) {
    	DataGenerator gen = event.getGenerator();
    	ExistingFileHelper helper = event.getExistingFileHelper();
    	
    	if(event.includeServer()) {
    		PVJBlockTagsProvider blockTags = new PVJBlockTagsProvider(gen, helper);
    		gen.addProvider(blockTags);
    		gen.addProvider(new PVJItemTagsProvider(gen, blockTags, helper));
    		gen.addProvider(new PVJRecipesProvider(gen));
    	}
    	
    	if(event.includeClient()) {
    		
    	}
    }
}
