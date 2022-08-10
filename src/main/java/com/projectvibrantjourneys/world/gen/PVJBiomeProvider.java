package com.projectvibrantjourneys.world.gen;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;
import com.projectvibrantjourneys.core.PVJConfig;
import com.projectvibrantjourneys.init.world.PVJBiomes.Keys;
import com.projectvibrantjourneys.world.gen.biomes.PVJOverworldBiomeBuilder;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.SurfaceRuleManager.RuleCategory;

public class PVJBiomeProvider extends Region {

//	public static final PVJOverworldBiomeBuilder builder = new PVJOverworldBiomeBuilder();
	public static final ArrayList<ResourceKey<Biome>> DISABLED_BIOMES = new ArrayList<ResourceKey<Biome>>();
	
	public PVJBiomeProvider(ResourceLocation name, int overworldWeight) {
		super(name, RegionType.OVERWORLD, overworldWeight);
		if(!PVJConfig.CONFIG_DATA.enableOvergrownSpires.get())
			DISABLED_BIOMES.add(Keys.OVERGROWN_SPIRES);
		if(!PVJConfig.CONFIG_DATA.enableVerdantSands.get())
			DISABLED_BIOMES.add(Keys.VERDANT_SANDS);
		if(!PVJConfig.CONFIG_DATA.enablePineMeadows.get())
			DISABLED_BIOMES.add(Keys.PINE_MEADOWS);
		if(!PVJConfig.CONFIG_DATA.enableAutumnalConiferousForest.get())
			DISABLED_BIOMES.add(Keys.AUTUMNAL_CONIFEROUS_FOREST);
		if(!PVJConfig.CONFIG_DATA.enableBorealForest.get())
			DISABLED_BIOMES.add(Keys.BOREAL_FOREST);
		if(!PVJConfig.CONFIG_DATA.enableSnowyBorealForest.get())
			DISABLED_BIOMES.add(Keys.SNOWY_BOREAL_FOREST);
		if(!PVJConfig.CONFIG_DATA.enableDesertShrubland.get())
			DISABLED_BIOMES.add(Keys.DESERT_SHRUBLAND);
		if(!PVJConfig.CONFIG_DATA.enablePrairie.get())
			DISABLED_BIOMES.add(Keys.PRAIRIE);
		if(!PVJConfig.CONFIG_DATA.enableRedwoods.get())
			DISABLED_BIOMES.add(Keys.REDWOODS);
		if(!PVJConfig.CONFIG_DATA.enableSnowyRedwoods.get())
			DISABLED_BIOMES.add(Keys.SNOWY_REDWOODS);
		if(!PVJConfig.CONFIG_DATA.enableBaobabFields.get())
			DISABLED_BIOMES.add(Keys.BAOBAB_FIELDS);
		if(!PVJConfig.CONFIG_DATA.enableCrystalLakes.get())
			DISABLED_BIOMES.add(Keys.CRYSTAL_LAKES);
		if(!PVJConfig.CONFIG_DATA.enableBlossomingFields.get())
			DISABLED_BIOMES.add(Keys.BLOSSOMING_FIELDS);
		if(!PVJConfig.CONFIG_DATA.enableAspenGrove.get())
			DISABLED_BIOMES.add(Keys.ASPEN_GROVE);
		
		SurfaceRuleManager.addSurfaceRules(RuleCategory.OVERWORLD, "projectvibrantjourneys", PVJSurfaceRules.PVJ_SURFACE_RULES);
	}

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
    	//just experimenting
    	
//    	this.addBiomeSimilar(mapper, Biomes.DESERT, PVJBiomes.Keys.VERDANT_SANDS);
//    	this.addBiomeSimilar(mapper, Biomes.PLAINS, PVJBiomes.Keys.PINE_MEADOWS);
//    	this.addBiomeSimilar(mapper, Biomes.TAIGA, PVJBiomes.Keys.AUTUMNAL_CONIFEROUS_FOREST);
//    	this.addBiomeSimilar(mapper, Biomes.TAIGA, PVJBiomes.Keys.BOREAL_FOREST);
//    	this.addBiomeSimilar(mapper, Biomes.SNOWY_TAIGA, PVJBiomes.Keys.SNOWY_BOREAL_FOREST);
//    	this.addBiomeSimilar(mapper, Biomes.DESERT, PVJBiomes.Keys.DESERT_SHRUBLAND);
//    	this.addBiomeSimilar(mapper, Biomes.SAVANNA, PVJBiomes.Keys.DESERT_SHRUBLAND);
//    	this.addBiomeSimilar(mapper, Biomes.JUNGLE, PVJBiomes.Keys.OVERGROWN_SPIRES);
//    	this.addBiomeSimilar(mapper, Biomes.PLAINS, PVJBiomes.Keys.PRAIRIE);
//    	
    	PVJOverworldBiomeBuilder.biomes1.addBiomes((pair) -> {
    		ParameterPoint parameter = pair.getFirst();
    		ResourceKey<Biome> biome = pair.getSecond();
    		
    		if(biome != null) {
    			if(!DISABLED_BIOMES.contains(biome))
    				mapper.accept(new Pair<>(parameter, biome));
    		}
    	});
    	
//    	PVJOverworldBiomeBuilder.biomes2.addBiomes((pair) -> {
//    		ParameterPoint parameter = pair.getFirst();
//    		ResourceKey<Biome> biome = pair.getSecond();
//    		
//    		if(biome != null) {
//    			if(!DISABLED_BIOMES.contains(biome))
//    				mapper.accept(new Pair<>(ParameterUtils.convertParameterPoint(parameter, this.getUniquenessParameter()), biome));
//    		}
//    	});
    	
//    	List<TBClimate.ParameterPoint> verdantSandsPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.HOT)
//    			.humidity(Humidity.ARID, Humidity.DRY)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_5)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.VALLEY)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> desertShrublandPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.HOT)
//    			.humidity(Humidity.ARID, Humidity.DRY)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_3)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> pineMeadowsPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.NEUTRAL, Temperature.COOL)
//    			.humidity(Humidity.NEUTRAL)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_3)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> borealForestPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.COOL)
//    			.humidity(Humidity.NEUTRAL)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_6)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> autumnalConiferousForestPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.COOL)
//    			.humidity(Humidity.NEUTRAL, Humidity.HUMID)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_6)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> snowyBorealForestPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.ICY)
//    			.humidity(Humidity.NEUTRAL)
//    			.continentalness(Parameter.point(1.5F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_6)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> overgrownSpiresPoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.HOT)
//    			.humidity(Humidity.HUMID, Humidity.WET)
//    			.continentalness(Parameter.point(2.0F))
//    			.erosion(Erosion.EROSION_1, Erosion.EROSION_6)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	List<TBClimate.ParameterPoint> prairiePoints = new ParameterPointListBuilder()
//    			.temperature(Temperature.NEUTRAL)
//    			.humidity(Humidity.NEUTRAL, Humidity.DRY)
//    			.continentalness(Parameter.point(1.3F))
//    			.erosion(Erosion.EROSION_3, Erosion.EROSION_3)
//    			.depth(Depth.SURFACE)
//    			.weirdness(Weirdness.FULL_RANGE)
//    			.uniqueness(this.getUniquenessParameter())
//    			.build();
//    	
//    	
//    	verdantSandsPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.VERDANT_SANDS));
//    	desertShrublandPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.DESERT_SHRUBLAND));
//    	pineMeadowsPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.PINE_MEADOWS));
//    	borealForestPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.BOREAL_FOREST));
//    	autumnalConiferousForestPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.AUTUMNAL_CONIFEROUS_FOREST));
//    	snowyBorealForestPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.SNOWY_BOREAL_FOREST));
//    	overgrownSpiresPoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.OVERGROWN_SPIRES));
//    	prairiePoints.forEach(point -> this.addBiome(mapper, point, PVJBiomes.Keys.PRAIRIE));
    }
    
//    @Override
//    public void addNetherBiomes(Registry<Biome> registry, Consumer<Pair<TBClimate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//    	
//    }
}
