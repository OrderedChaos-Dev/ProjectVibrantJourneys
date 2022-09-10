package com.projectvibrantjourneys.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.projectvibrantjourneys.common.world.modifiers.PVJBiomeModifier;
import com.projectvibrantjourneys.common.world.modifiers.PVJSpawnModifier;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.util.PVJFeatureVars;
import com.projectvibrantjourneys.util.TreeFeatureUtils.ChanceBiomeEntry;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;

@SuppressWarnings("unchecked")
public class PVJBiomeModifierDataGen {
	
	private static final TagKey<Biome> OVERWORLD = BiomeTags.IS_OVERWORLD;
	private static final TagKey<Biome> NETHER = BiomeTags.IS_NETHER;
	private static final TagKey<Biome> END = BiomeTags.IS_END;

	public static Map<ResourceLocation, BiomeModifier> createFeatureGenMap(RegistryOps<JsonElement> registryOps) {
		Map<ResourceLocation, BiomeModifier> map = new HashMap<>();
		addFeature(map, "twigs", new Builder(registryOps, "twigs", "enableTwigs").tag(overworld()).blacklist(desert(), oceanOrBeach(), mushroom()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
		addFeature(map, "fallen_leaves", new Builder(registryOps, "fallen_leaves", "enableFallenLeaves").tag(overworld()).blacklist(desert(), oceanOrBeach(), mushroom()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
		addFeature(map, "dead_fallen_leaves", new Builder(registryOps, "dead_fallen_leaves", "enableFallenLeaves").extraBiomes(Biomes.WOODED_BADLANDS));
		addFeature(map, "dense_dead_fallen_leaves", new Builder(registryOps, "dense_dead_fallen_leaves", "enableFallenLeaves").extraBiomes(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA));
		addFeature(map, "pinecones", new Builder(registryOps, "pinecones", "enablePinecones").tag(coniferous()));
		addFeature(map, "seashells", new Builder(registryOps, "seashells", "enableSeashells").tag(oceanOrBeach()));
		addFeature(map, "ocean_floor_seashells", new Builder(registryOps, "ocean_floor_seashells", "enableSeashells").tag(oceanOrBeach()));
		addFeature(map, "rocks", new Builder(registryOps, "rocks", "enableRocks").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
		addFeature(map, "bones", new Builder(registryOps, "bones", "enableBones").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
		addFeature(map, "cave_rocks", new Builder(registryOps, "cave_rocks", "enableRocks").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
		addFeature(map, "cave_bones", new Builder(registryOps, "cave_bones", "enableBones").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
		addFeature(map, "ice_chunks", new Builder(registryOps, "ice_chunks", "enableIceChunks").tag(snowy()).extraBlacklist(Biomes.SNOWY_BEACH));
		addFeature(map, "moss_carpet", new Builder(registryOps, "moss_carpet", "enableMossCarpets").extraBiomes(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA));
		addFeature(map, "bark_mushroom", new Builder(registryOps, "bark_mushroom", "enableBarkMushrooms").tag(overworld()));
		addFeature(map, "sea_oats", new Builder(registryOps, "sea_oats", "enableSeaOats").tag(beach()).extraBlacklist(veryCold()));
		addFeature(map, "beach_grass", new Builder(registryOps, "beach_grass", "enableBeachGrass").tag(beach()).extraBlacklist(veryCold()));
		addFeature(map, "cattails", new Builder(registryOps, "cattails", "enableCattails").tag(overworld()).blacklist(oceanOrBeach(), badlands()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
		addFeature(map, "short_grass", new Builder(registryOps, "short_grass", "enableShortGrass").tag(overworld()).blacklist(mushroom()).extraBlacklist(Biomes.SNOWY_PLAINS));
		addFeature(map, "natural_cobweb", new Builder(registryOps, "natural_cobweb", "enableNaturalCobwebs").tag(overworld()).blacklist(mushroom()).extraBlacklist(Biomes.SNOWY_PLAINS));
		addFeature(map, "small_cactus", new Builder(registryOps, "small_cactus", "enableSmallCacti").tag(desert()));
		addFeature(map, "extra_seagrass", new Builder(registryOps, "extra_seagrass", "enableExtraSeagrass").tag(overworld()).blacklist(oceanOrBeach(), desert()).extraBlacklist(Biomes.STONY_SHORE));
		addFeature(map, "extra_lilypads", new Builder(registryOps, "extra_lilypads", "enableExtraLilypads").tag(overworld()).blacklist(oceanOrBeach(), desert()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
		addFeature(map, "extra_grass", new Builder(registryOps, "extra_grass", "enableExtraSeagrass").tag(river()));
		addFeature(map, "tide_pool", new Builder(registryOps, "tide_pool", "enableTidePools").extraBiomes(Biomes.STONY_SHORE));
		addFeature(map, "cave_roots", new Builder(registryOps, "cave_roots", "enableCaveRoots").tag(overworld()));
		addFeature(map, "reeds", new Builder(registryOps, "reeds", "enableReeds").tag(plainsType()).extraBlacklist(Biomes.SNOWY_PLAINS));
		addFeature(map, "prickly_bush", new Builder(registryOps, "prickly_bush", "enablePricklyBush").extraBiomes(Biomes.WOODED_BADLANDS));
		addFeature(map, "icicle", new Builder(registryOps, "icicle", "enableIcicles").tag(snowy()));
		
		addFeature(map, "oak_fallen_tree", new Builder(registryOps, "oak_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.OAK)));
		addFeature(map, "birch_fallen_tree", new Builder(registryOps, "birch_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.BIRCH)));
		addFeature(map, "spruce_fallen_tree", new Builder(registryOps, "spruce_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.SPRUCE)));
		addFeature(map, "jungle_fallen_tree", new Builder(registryOps, "jungle_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.JUNGLE)));
		addFeature(map, "acacia_fallen_tree", new Builder(registryOps, "acacia_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.ACACIA)));
		addFeature(map, "dark_oak_fallen_tree", new Builder(registryOps, "dark_oak_fallen_tree", "enableFallenTrees").extraBiomes(getBiomes(registryOps, PVJFeatureVars.DARK_OAK)));
		
		addFeature(map, "charred_bones", new Builder(registryOps, "charred_bones", "enableCharredBones").dimension(NETHER).tag(List.of(NETHER)));
		addFeature(map, "glowcap", new Builder(registryOps, "glowcap", "enableGlowcap").dimension(NETHER).tag(List.of(NETHER)));
		addFeature(map, "cindercane", new Builder(registryOps, "cindercane", "enableCindercane").dimension(NETHER).tag(List.of(NETHER)));
		addFeature(map, "warped_nettle", new Builder(registryOps, "warped_nettle", "enableNetherNettles").dimension(NETHER).extraBiomes(Biomes.WARPED_FOREST));
		addFeature(map, "crimson_nettle", new Builder(registryOps, "crimson_nettle", "enableNetherNettles").dimension(NETHER).extraBiomes(Biomes.CRIMSON_FOREST));

		addSpawn(map, "tropical_fish_in_jungles", getAllBiomes(registryOps, BiomeTags.IS_JUNGLE), OVERWORLD, MobCategory.WATER_AMBIENT, new SpawnerData(EntityType.TROPICAL_FISH, 25, 5, 5));
		return map;
	}
	
	private static void addFeature(Map<ResourceLocation, BiomeModifier> map, String placedFeatureName, Builder builder) {
		BiomeModifier modifier = builder.build();
		ResourceLocation location = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, placedFeatureName);
		map.put(location, modifier);
	}
	
	private static void addSpawn(Map<ResourceLocation, BiomeModifier> map, String spawnName, HolderSet<Biome> biomes, TagKey<Biome> dimension, MobCategory category, SpawnerData data) {
		BiomeModifier modifier = new PVJSpawnModifier(dimension, biomes, category, data, "enableJungleTropicalFish");
		map.put(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, spawnName), modifier);
	}
	
	private static HolderSet<Biome> getAllBiomes(RegistryOps<JsonElement> registryOps, TagKey<Biome> tag) {
		return new HolderSet.Named<>(registryOps.registry(Registry.BIOME_REGISTRY).get(), tag);
	}
	
	private static List<TagKey<Biome>> forestOrPlains() {
		return List.of(Tags.Biomes.IS_PLAINS, BiomeTags.IS_FOREST);
	}
	
	private static List<TagKey<Biome>> plainsType() {
		return List.of(Tags.Biomes.IS_PLAINS, BiomeTags.IS_SAVANNA);
	}
	
	private static List<TagKey<Biome>> oceanOrBeach() {
		return List.of(BiomeTags.IS_BEACH, BiomeTags.IS_OCEAN);
	}
	
	private static List<TagKey<Biome>> badlands() {
		return List.of(BiomeTags.IS_BADLANDS);
	}

	private static List<TagKey<Biome>> beach() {
		return List.of(BiomeTags.IS_BEACH);
	}
	
	private static List<TagKey<Biome>> river() {
		return List.of(BiomeTags.IS_RIVER);
	}
	
	private static List<TagKey<Biome>> coniferous() {
		return List.of(Tags.Biomes.IS_CONIFEROUS);
	}
	
	private static List<TagKey<Biome>> snowy() {
		return List.of(Tags.Biomes.IS_SNOWY);
	}
	
	private static List<TagKey<Biome>> mushroom() {
		return List.of(Tags.Biomes.IS_MUSHROOM);
	}

	private static List<ResourceKey<Biome>> veryCold() {
		return List.of(Biomes.FROZEN_RIVER, Biomes.SNOWY_PLAINS,
						Biomes.SNOWY_BEACH,
						Biomes.SNOWY_SLOPES,
						Biomes.ICE_SPIKES,
						Biomes.FROZEN_OCEAN,
						Biomes.DEEP_FROZEN_OCEAN,
						Biomes.JAGGED_PEAKS);
	}
	
	private static List<TagKey<Biome>> desert() {
		/* rip BiomeCategory, going to take a risk and hope modded biomes with desert pyramids are also actually deserts */
		return List.of(BiomeTags.HAS_DESERT_PYRAMID, BiomeTags.IS_BADLANDS);
	}
	
	private static List<TagKey<Biome>> overworld() {
		return List.of(BiomeTags.IS_OVERWORLD);
	}
	
	private static List<TagKey<Biome>> nether() {
		return List.of(BiomeTags.IS_NETHER);
	}
	
	private static Holder<Biome> getBiome(RegistryOps<JsonElement> registryOps, ResourceKey<Biome> biomeKey) {
		return registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biomeKey).get();
	}

	private static List<Holder<Biome>> getBiomes(RegistryOps<JsonElement> registryOps, Set<ChanceBiomeEntry> entries) {
		List<Holder<Biome>> list = new ArrayList<>();
		List<String> biomes = entries.stream().map(entry -> entry.biomeName()).toList();
		registryOps.registry(Registry.BIOME_REGISTRY).get().registryKeySet().forEach((key) -> {
			if(biomes.contains(key.location().toString())) {
				list.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(key).get());
			}
		});
		
		return list;
	}

	private static class Builder {
		
		private String placedFeatureName;
		private TagKey<Biome> dimension = OVERWORLD;
		private List<TagKey<Biome>> biomeTags = new ArrayList<>();
		private List<TagKey<Biome>> blacklistTags = new ArrayList<>();;
		private List<Holder<Biome>> extraBiomes = new ArrayList<>();;
		private List<Holder<Biome>> extraBlacklist = new ArrayList<>();;
		private RegistryOps<JsonElement> registryOps;
		private Decoration decoration = Decoration.VEGETAL_DECORATION;
		private String configOption;
		
		public Builder(RegistryOps<JsonElement> registryOps, String placedFeatureName, String configOption) {
			this.registryOps = registryOps;
			this.placedFeatureName = placedFeatureName;
			this.configOption = configOption;
		}
		
		public Builder dimension(TagKey<Biome> tag) {
			this.dimension = tag;
			return this;
		}
		
		public Builder tag(List<TagKey<Biome>> tags) {
			this.biomeTags.addAll(combine(tags));
			return this;
		}
		
		public Builder blacklist(List<TagKey<Biome>>... tags) {
			this.blacklistTags.addAll(combine(tags));
			return this;
		}
		
		public Builder extraBiomes(List<Holder<Biome>>... biomes) {
			this.extraBiomes.addAll(combine(biomes));
			return this;
		}
		
		public Builder extraBiomes(ResourceKey<Biome>... biomes) {
			for(ResourceKey<Biome> biome : biomes) {
				this.extraBiomes.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biome).get());
			}
			return this;
		}
		
		public Builder extraBlacklist(List<Holder<Biome>>... biomes) {
			this.extraBlacklist.addAll(combine(biomes));
			return this;
		}
		
		public Builder extraBlacklist(ResourceKey<Biome>... biomes) {
			for(ResourceKey<Biome> biome : biomes) {
				this.extraBlacklist.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biome).get());
			}
			return this;
		}
		
		public Builder extraBlacklist(List<ResourceKey<Biome>> biomes) {
			for(ResourceKey<Biome> biome : biomes) {
				this.extraBlacklist.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biome).get());
			}
			return this;
		}
		
		public Builder decoration(Decoration decoration) {
			this.decoration = decoration;
			return this;
		}
		
		@SafeVarargs
		public final <T> List<T> combine(List<T>... lists) {
			List<T> list = new ArrayList<>();
			for(List<T> i : lists)
				for(T tag : i)
					list.add(tag);
			
			return list;
		}
		
		public PVJBiomeModifier build() {
			List<HolderSet<Biome>> biomesSet = new ArrayList<>(this.biomeTags.stream().map(tag -> getAllBiomes(registryOps, tag)).toList());
			List<HolderSet<Biome>> blacklistSet = new ArrayList<>(this.blacklistTags.stream().map(tag -> getAllBiomes(registryOps, tag)).toList());
			biomesSet.add(HolderSet.direct(this.extraBiomes));
			blacklistSet.add(HolderSet.direct(this.extraBlacklist));
			ResourceLocation location = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, placedFeatureName);
			Holder<PlacedFeature> placedFeature = registryOps.registry(Registry.PLACED_FEATURE_REGISTRY).get().getHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, location));
			return new PVJBiomeModifier(dimension, biomesSet, blacklistSet, decoration, placedFeature, configOption);
		}
	}
}
