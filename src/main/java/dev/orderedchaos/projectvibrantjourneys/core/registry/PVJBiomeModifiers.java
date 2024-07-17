package dev.orderedchaos.projectvibrantjourneys.core.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.orderedchaos.projectvibrantjourneys.common.world.modifiers.PVJBiomeModifier;
import dev.orderedchaos.projectvibrantjourneys.common.world.modifiers.PVJBiomeModifier.Builder.Dimension;
import dev.orderedchaos.projectvibrantjourneys.common.world.modifiers.PVJSpawnModifier;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import dev.orderedchaos.projectvibrantjourneys.data.tags.PVJTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class PVJBiomeModifiers {
  public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ProjectVibrantJourneys.MOD_ID);

  public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<PVJBiomeModifier>> BIOME_MODIFIER_SERIALIZER = BIOME_MODIFIER_SERIALIZERS.register("biome_modifier",
    () -> RecordCodecBuilder.mapCodec(builder -> builder.group(
      TagKey.codec(Registries.BIOME).fieldOf("dimension").forGetter(PVJBiomeModifier::dimension),
      Biome.LIST_CODEC.listOf().fieldOf("biomes").forGetter(PVJBiomeModifier::biomes),
      Biome.LIST_CODEC.listOf().fieldOf("blacklist").forGetter(PVJBiomeModifier::blacklist),
      GenerationStep.Decoration.CODEC.fieldOf("decoration").forGetter(PVJBiomeModifier::decoration),
      PlacedFeature.CODEC.fieldOf("feature").forGetter(PVJBiomeModifier::feature),
      Codec.STRING.fieldOf("configOption").forGetter(PVJBiomeModifier::configOption)
    ).apply(builder, PVJBiomeModifier::new)));

  public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<PVJSpawnModifier>> SPAWN_MODIFIER_SERIALIZER = BIOME_MODIFIER_SERIALIZERS.register("spawn_modifier",
    () -> RecordCodecBuilder.mapCodec(builder -> builder.group(
      TagKey.codec(Registries.BIOME).fieldOf("dimension").forGetter(PVJSpawnModifier::dimension),
      Biome.LIST_CODEC.fieldOf("biomes").forGetter(PVJSpawnModifier::biomes),
      MobCategory.CODEC.fieldOf("category").forGetter(PVJSpawnModifier::category),
      MobSpawnSettings.SpawnerData.CODEC.fieldOf("data").forGetter(PVJSpawnModifier::data),
      PrimitiveCodec.STRING.fieldOf("configOption").forGetter(PVJSpawnModifier::configOption)
    ).apply(builder, PVJSpawnModifier::new)));

  public static void bootstrap(BootstrapContext<BiomeModifier> context) {
    bootstrapBiomeModifiers(context);
    bootstrapSpawnModifiers(context);
  }

  public static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> context) {
    addBiomeModifier(context, PVJPlacements.TWIGS, new PVJBiomeModifier.Builder(context, "enableTwigs").tag(overworld()).blacklist(desert(), oceanOrBeach(), mushroom()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.BIRCH_TWIGS, new PVJBiomeModifier.Builder(context, "enableTwigs").tag(List.of(PVJTags.HAS_BIRCH_LOGS)));
    addBiomeModifier(context, PVJPlacements.FALLEN_LEAVES, new PVJBiomeModifier.Builder(context, "enableFallenLeaves").tag(overworld()).blacklist(desert(), oceanOrBeach(), mushroom()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.DEAD_FALLEN_LEAVES, new PVJBiomeModifier.Builder(context, "enableFallenLeaves").extraBiomes(Biomes.WOODED_BADLANDS));
    addBiomeModifier(context, PVJPlacements.DENSE_DEAD_FALLEN_LEAVES, new PVJBiomeModifier.Builder(context, "enableFallenLeaves").extraBiomes(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA));
    addBiomeModifier(context, PVJPlacements.PINECONES, new PVJBiomeModifier.Builder(context, "enablePinecones").tag(coniferous()));
    addBiomeModifier(context, PVJPlacements.SEASHELLS, new PVJBiomeModifier.Builder(context, "enableSeashells").tag(oceanOrBeach()));
    addBiomeModifier(context, PVJPlacements.OCEAN_FLOOR_SEASHELLS, new PVJBiomeModifier.Builder(context, "enableSeashells").tag(oceanOrBeach()));
    addBiomeModifier(context, PVJPlacements.ROCKS, new PVJBiomeModifier.Builder(context, "enableRocks").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.BONES, new PVJBiomeModifier.Builder(context, "enableBones").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.CAVE_ROCKS, new PVJBiomeModifier.Builder(context, "enableRocks").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.CAVE_BONES, new PVJBiomeModifier.Builder(context, "enableBones").tag(overworld()).blacklist(mushroom()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.ICE_CHUNKS, new PVJBiomeModifier.Builder(context, "enableIceChunks").tag(snowy()).extraBlacklist(Biomes.SNOWY_BEACH));
    addBiomeModifier(context, PVJPlacements.MOSS_CARPET, new PVJBiomeModifier.Builder(context, "enableMossCarpets").extraBiomes(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA));
    addBiomeModifier(context, PVJPlacements.BARK_MUSHROOM, new PVJBiomeModifier.Builder(context, "enableBarkMushrooms").tag(overworld()));
    addBiomeModifier(context, PVJPlacements.SEA_OATS, new PVJBiomeModifier.Builder(context, "enableSeaOats").tag(beach()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.BEACH_GRASS, new PVJBiomeModifier.Builder(context, "enableBeachGrass").tag(beach()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.CATTAILS, new PVJBiomeModifier.Builder(context, "enableCattails").tag(overworld()).blacklist(oceanOrBeach(), badlands()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.SHORT_GRASS, new PVJBiomeModifier.Builder(context, "enableShortGrass").tag(overworld()).blacklist(mushroom()).extraBlacklist(Biomes.SNOWY_PLAINS));
    addBiomeModifier(context, PVJPlacements.NATURAL_COBWEB, new PVJBiomeModifier.Builder(context, "enableNaturalCobwebs").tag(overworld()).blacklist(mushroom()).extraBlacklist(Biomes.SNOWY_PLAINS));
    addBiomeModifier(context, PVJPlacements.SMALL_CACTUS, new PVJBiomeModifier.Builder(context, "enableSmallCacti").tag(desert()));
    addBiomeModifier(context, PVJPlacements.EXTRA_SEAGRASS, new PVJBiomeModifier.Builder(context, "enableExtraSeagrass").tag(overworld()).blacklist(oceanOrBeach(), desert()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.EXTRA_LILYPADS, new PVJBiomeModifier.Builder(context, "enableExtraLilypads").tag(overworld()).blacklist(oceanOrBeach(), desert()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.EXTRA_GRASS, new PVJBiomeModifier.Builder(context, "enableExtraRiverGrass").tag(river()));
    addBiomeModifier(context, PVJPlacements.TIDE_POOL, new PVJBiomeModifier.Builder(context, "enableTidePools").extraBiomes(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.CAVE_ROOTS, new PVJBiomeModifier.Builder(context, "enableCaveRoots").tag(overworld()));
    addBiomeModifier(context, PVJPlacements.REEDS, new PVJBiomeModifier.Builder(context, "enableReeds").tag(plainsType()).extraBlacklist(Biomes.SNOWY_PLAINS));
    addBiomeModifier(context, PVJPlacements.PRICKLY_BUSH, new PVJBiomeModifier.Builder(context, "enablePricklyBush").extraBiomes(Biomes.WOODED_BADLANDS));
    addBiomeModifier(context, PVJPlacements.ICICLE, new PVJBiomeModifier.Builder(context, "enableIcicles").tag(snowy()));
    addBiomeModifier(context, PVJPlacements.SANDY_SPROUTS, new PVJBiomeModifier.Builder(context, "enableSandySprouts").tag(beach()).extraBlacklist(veryCold()));
    addBiomeModifier(context, PVJPlacements.WATERGRASS, new PVJBiomeModifier.Builder(context, "enableWatergrass").tag(overworld()).blacklist(oceanOrBeach(), badlands()).extraBlacklist(veryCold()).extraBlacklist(Biomes.STONY_SHORE));
    addBiomeModifier(context, PVJPlacements.GRAVEL_PIT, new PVJBiomeModifier.Builder(context, "enableGravelPits").decoration(GenerationStep.Decoration.LAKES).extraBiomes(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST));
    addBiomeModifier(context, PVJPlacements.GOLD_PIT, new PVJBiomeModifier.Builder(context, "enableGoldPits").decoration(GenerationStep.Decoration.LAKES).tag(List.of(BiomeTags.IS_BADLANDS)));
    addBiomeModifier(context, PVJPlacements.BEACHED_KELP, new PVJBiomeModifier.Builder(context, "enableBeachedKelp").extraBiomes(Biomes.BEACH));
    addBiomeModifier(context, PVJPlacements.DRIED_BEACHED_KELP, new PVJBiomeModifier.Builder(context, "enableDriedBeachedKelp").extraBiomes(Biomes.BEACH));
    addBiomeModifier(context, PVJPlacements.GLOWING_BLUE_FUNGUS, new PVJBiomeModifier.Builder(context, "enableGlowingBlueFungus").extraBiomes(Biomes.DEEP_DARK));
    addBiomeModifier(context, PVJPlacements.CHERRY_GROVE_BAMBOO, new PVJBiomeModifier.Builder(context, "enableCherryGroveBamboo").extraBiomes(Biomes.CHERRY_GROVE));
    addBiomeModifier(context, PVJPlacements.MUDDY_BONES, new PVJBiomeModifier.Builder(context, "enableMuddyBones").extraBiomes(Biomes.MANGROVE_SWAMP));

    addBiomeModifier(context, PVJPlacements.OAK_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_OAK_LOGS)));
    addBiomeModifier(context, PVJPlacements.BIRCH_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_BIRCH_LOGS)));
    addBiomeModifier(context, PVJPlacements.SPRUCE_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_SPRUCE_LOGS)));
    addBiomeModifier(context, PVJPlacements.JUNGLE_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_JUNGLE_LOGS)));
    addBiomeModifier(context, PVJPlacements.ACACIA_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_ACACIA_LOGS)));
    addBiomeModifier(context, PVJPlacements.DARK_OAK_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_DARK_OAK_LOGS)));
    addBiomeModifier(context, PVJPlacements.CHERRY_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_CHERRY_LOGS)));
    addBiomeModifier(context, PVJPlacements.MANGROVE_FALLEN_TREE, new PVJBiomeModifier.Builder(context, "enableFallenTrees").tag(List.of(PVJTags.HAS_MANGROVE_LOGS)));

    addBiomeModifier(context, PVJPlacements.CHARRED_BONES, new PVJBiomeModifier.Builder(context, "enableCharredBones").dimension(Dimension.NETHER).tag(List.of(BiomeTags.IS_NETHER)));
    addBiomeModifier(context, PVJPlacements.GLOWCAP, new PVJBiomeModifier.Builder(context, "enableGlowcap").dimension(Dimension.NETHER).tag(List.of(BiomeTags.IS_NETHER)));
    addBiomeModifier(context, PVJPlacements.CINDERCANE, new PVJBiomeModifier.Builder(context, "enableCindercane").dimension(Dimension.NETHER).tag(List.of(BiomeTags.IS_NETHER)));
    addBiomeModifier(context, PVJPlacements.WARPED_NETTLE, new PVJBiomeModifier.Builder(context, "enableNetherNettles").dimension(Dimension.NETHER).extraBiomes(Biomes.WARPED_FOREST));
    addBiomeModifier(context, PVJPlacements.CRIMSON_NETTLE, new PVJBiomeModifier.Builder(context, "enableNetherNettles").dimension(Dimension.NETHER).extraBiomes(Biomes.CRIMSON_FOREST));
  }

  public static void bootstrapSpawnModifiers(BootstrapContext<BiomeModifier> context) {
    addSpawnModifier(context, "tropical_fish_in_jungles", BiomeTags.IS_OVERWORLD, BiomeTags.IS_JUNGLE, MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 5, 5), "enableJungleTropicalFish");
  }

  private static void addBiomeModifier(BootstrapContext<BiomeModifier> context, ResourceKey<PlacedFeature> placedFeatureKey, PVJBiomeModifier.Builder builder) {
    BiomeModifier modifier = builder.placedFeature(placedFeatureKey).build();
    ResourceKey<BiomeModifier> key = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, placedFeatureKey.location());
    context.register(key, modifier);
  }

  private static void addSpawnModifier(
    BootstrapContext<BiomeModifier> context,
    String spawnName,
    TagKey<Biome> dimension,
    TagKey<Biome> biomes,
    MobCategory mobCategory,
    MobSpawnSettings.SpawnerData spawnerData,
    String configOption
  ) {
    HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
    ResourceKey<BiomeModifier> key = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ProjectVibrantJourneys.MOD_ID, spawnName));
    BiomeModifier modifier = new PVJSpawnModifier(dimension, biomeGetter.getOrThrow(biomes), mobCategory, spawnerData, configOption);
    context.register(key, modifier);
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
    return List.of(Tags.Biomes.IS_CONIFEROUS_TREE);
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
    return List.of(BiomeTags.HAS_DESERT_PYRAMID, BiomeTags.IS_BADLANDS, BiomeTags.HAS_VILLAGE_DESERT);
  }

  private static List<TagKey<Biome>> overworld() {
    return List.of(BiomeTags.IS_OVERWORLD);
  }

  private static List<TagKey<Biome>> nether() {
    return List.of(BiomeTags.IS_NETHER);
  }
}