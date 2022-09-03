package com.projectvibrantjourneys.core.registry.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.common.world.modifiers.PVJBiomeModifier;
import com.projectvibrantjourneys.common.world.modifiers.PVJSpawnModifier;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVJBiomeModifiers {
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ProjectVibrantJourneys.MOD_ID);
	
	public static final RegistryObject<Codec<PVJBiomeModifier>> BIOME_MODIFIER_SERIALIZER = BIOME_MODIFIER_SERIALIZERS.register("biome_modifier_serializer",
			() -> RecordCodecBuilder.create(builder -> builder.group(
								TagKey.codec(Registry.BIOME_REGISTRY).fieldOf("dimension").forGetter(PVJBiomeModifier::dimension),
								Biome.LIST_CODEC.listOf().fieldOf("biomes").forGetter(PVJBiomeModifier::biomes),
								Biome.LIST_CODEC.listOf().fieldOf("blacklist").forGetter(PVJBiomeModifier::blacklist),
								Decoration.CODEC.fieldOf("decoration").forGetter(PVJBiomeModifier::decoration),
								PlacedFeature.CODEC.fieldOf("feature").forGetter(PVJBiomeModifier::feature),
								PrimitiveCodec.STRING.fieldOf("configOption").forGetter(PVJBiomeModifier::configOption)
							).apply(builder, PVJBiomeModifier::new)));
	
	public static final RegistryObject<Codec<PVJSpawnModifier>> SPAWN_MODIFIER_SERIALIZER = BIOME_MODIFIER_SERIALIZERS.register("spawn_modifier_serializer",
			() -> RecordCodecBuilder.create(builder -> builder.group(
					TagKey.codec(Registry.BIOME_REGISTRY).fieldOf("dimension").forGetter(PVJSpawnModifier::dimension),
					Biome.LIST_CODEC.fieldOf("biomes").forGetter(PVJSpawnModifier::biomes),
					MobCategory.CODEC.fieldOf("category").forGetter(PVJSpawnModifier::category),
					SpawnerData.CODEC.fieldOf("data").forGetter(PVJSpawnModifier::data),
					PrimitiveCodec.STRING.fieldOf("configOption").forGetter(PVJSpawnModifier::configOption)
				).apply(builder, PVJSpawnModifier::new)));
	
	
}
