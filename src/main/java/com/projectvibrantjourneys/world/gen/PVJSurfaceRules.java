package com.projectvibrantjourneys.world.gen;

import com.projectvibrantjourneys.init.world.PVJBiomes;
import com.projectvibrantjourneys.init.world.PVJBiomes.Keys;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class PVJSurfaceRules {
	
	private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
	private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
	private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
	private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
	private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
	private static final SurfaceRules.RuleSource DIORITE = makeStateRule(Blocks.DIORITE);
	private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
	private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
	private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
	
	private static final SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

	public static final SurfaceRules.RuleSource GRASS_DIRT_FLOOR = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	public static final SurfaceRules.RuleSource DESERT = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, SAND))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SANDSTONE));
	public static final SurfaceRules.RuleSource COARSE_DIRT_FLOOR = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, COARSE_DIRT))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	public static final SurfaceRules.RuleSource PODZOL_DIRT_FLOOR = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, PODZOL))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT));
	
	public static final SurfaceRules.RuleSource DESERT_BIOMES = SurfaceRules.ifTrue(SurfaceRules.isBiome(PVJBiomes.Keys.DESERT_SHRUBLAND), DESERT);
	
	public static final SurfaceRules.RuleSource VERDANT_SANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(PVJBiomes.Keys.VERDANT_SANDS),
																	SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.8D), DESERT),
																							SurfaceRules.ifTrue(surfaceNoiseAbove(0.2D), GRASS_DIRT_FLOOR),
																							SurfaceRules.ifTrue(surfaceNoiseAbove(-0.6D), DESERT), DESERT));
	
	public static final SurfaceRules.RuleSource PINE_MEADOWS = SurfaceRules.ifTrue(SurfaceRules.isBiome(PVJBiomes.Keys.PINE_MEADOWS),
																	SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), GRASS_DIRT_FLOOR),
																							SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -2.0D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.02D, 0.02D), DIORITE)), GRASS_DIRT_FLOOR));
	
	public static final SurfaceRules.RuleSource OVERGROWN_SPIRES = SurfaceRules.ifTrue(SurfaceRules.isBiome(PVJBiomes.Keys.OVERGROWN_SPIRES),
																	SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_DIRT_FLOOR));
	
	public static final SurfaceRules.RuleSource REDWOODS = SurfaceRules.ifTrue(SurfaceRules.isBiome(PVJBiomes.Keys.REDWOODS, PVJBiomes.Keys.SNOWY_REDWOODS),
																	SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT_FLOOR), SurfaceRules.ifTrue(surfaceNoiseAbove(1.25D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.90D), PODZOL_DIRT_FLOOR), GRASS_DIRT_FLOOR));
	
	
	public static final SurfaceRules.RuleSource PVJ_SURFACE_RULES = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(REDWOODS, OVERGROWN_SPIRES, VERDANT_SANDS, PINE_MEADOWS, DESERT_BIOMES, GRASS_DIRT_FLOOR));
	
	private static SurfaceRules.RuleSource makeStateRule(Block block) {
		return SurfaceRules.state(block.defaultBlockState());
	}

	private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
		return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
	}
}