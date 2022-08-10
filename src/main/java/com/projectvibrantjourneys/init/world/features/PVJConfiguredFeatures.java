package com.projectvibrantjourneys.init.world.features;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

import com.projectvibrantjourneys.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.blocks.ShortGrassBlock;
import com.projectvibrantjourneys.core.ProjectVibrantJourneys;
import com.projectvibrantjourneys.init.object.PVJBlocks;
import com.projectvibrantjourneys.world.gen.features.foliageplacers.AspenFoliagePlacer;
import com.projectvibrantjourneys.world.gen.features.foliageplacers.BaobabFoliagePlacer;
import com.projectvibrantjourneys.world.gen.features.foliageplacers.DesertJuniperFoliagePlacer;
import com.projectvibrantjourneys.world.gen.features.foliageplacers.PVJPineFoliagePlacer;
import com.projectvibrantjourneys.world.gen.features.foliageplacers.PalmFoliagePlacer;
import com.projectvibrantjourneys.world.gen.features.stateproviders.DirectionalStateProvider;
import com.projectvibrantjourneys.world.gen.features.treedecorators.CoconutDecorator;
import com.projectvibrantjourneys.world.gen.features.treedecorators.JuniperBerriesDecorator;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.AspenTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.BaobabTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.DesertJuniperTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.MangroveTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.PalmTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.RedwoodTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.SmallRedwoodTrunkPlacer;
import com.projectvibrantjourneys.world.gen.features.trunkplacers.WillowTrunkPlacer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PVJConfiguredFeatures {
	
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ProjectVibrantJourneys.MOD_ID);
	
	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
	private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

	public static final RegistryObject<ConfiguredFeature<?, ?>> BEACH_GRASS = register("beach_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.beach_grass.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEA_OATS = register("sea_oats", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.sea_oats.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CATTAILS = register("cattails", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(128, 7, 2, PVJBlocks.cattail.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BARK_MUSHROOM = register("bark_mushroom", () -> new ConfiguredFeature<>(PVJFeatures.BARK_MUSHROOM.get(), new SimpleBlockConfiguration(BlockStateProvider.simple(PVJBlocks.bark_mushroom.get()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> NATURAL_COBWEB = register("natural_cobweb", () -> new ConfiguredFeature<>(PVJFeatures.NATURAL_COBWEB.get(), new ProbabilityFeatureConfiguration(0.1F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SHORT_GRASS = register("short_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PVJBlocks.short_grass.get()), ShortGrassBlock.MODEL, UniformInt.of(0, 6))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_CACTUS = register("small_cactus", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(8, 7, 3, PVJBlocks.small_cactus.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DESERT_SAGE = register("desert_sage", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(2, 7, 2, PVJBlocks.desert_sage.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> DRY_GRASS = register("dry_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new RandomizedIntStateProvider(BlockStateProvider.simple(PVJBlocks.dry_grass.get()), ShortGrassBlock.MODEL, UniformInt.of(0, 1))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PRAIRIE_GRASS = register("prairie_grass", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(64, 7, 3, PVJBlocks.prairie_grass.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SPRUCE_BUSH = register("spruce_bush", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(1, 0, 0), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), Blocks.SPRUCE_LOG, Blocks.OAK_LEAVES, new TwoLayersFeatureSize(0, 0, 0))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TWIGS = register("twigs", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.twigs.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FALLEN_LEAVES = register("fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_FALLEN_LEAVES = register("white_sakura_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.white_sakura_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_FALLEN_LEAVES = register("pink_sakura_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.pink_sakura_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_FALLEN_LEAVES = register("aspen_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.aspen_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE_FALLEN_LEAVES = register("red_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.red_maple_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE_FALLEN_LEAVES = register("orange_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.orange_maple_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_MAPLE_FALLEN_LEAVES = register("purple_maple_fallen_leaves", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeature(4, 7, 3, PVJBlocks.purple_maple_fallen_leaves.get().defaultBlockState())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINECONES = register("pinecones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.pinecones.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SEASHELLS = register("seashells", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.seashells.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ROCKS = register("rocks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(4, 7, 3, PlacementUtils.filtered(PVJFeatures.ROCKS.get(), NoneFeatureConfiguration.INSTANCE,
																			BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
																					BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ICE_CHUNKS = register("ice_chunks", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(4, 7, 3, PVJBlocks.ice_chunks.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BONES = register("bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(1, 7, 3, PVJBlocks.bones.get())));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_BONES = register("charred_bones", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, createGroundcoverPatchFeature(50, 7, 3, PVJBlocks.charred_bones.get())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> AMETHYST_CRYSTALS = register("amethyst_crystals", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.LARGE_AMETHYST_BUD.defaultBlockState(), 2).add(Blocks.AMETHYST_CLUSTER.defaultBlockState(), 1)))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> WARPED_NETTLE = register("warped_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.warped_nettle.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRIMSON_NETTLE = register("crimson_nettle", () -> new ConfiguredFeature<>(Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(BlockStateProvider.simple(PVJBlocks.crimson_nettle.get()), 8, 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> CINDERCANE = register("cindercane", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, columnPlantWithFluid(256, 7, 3, PVJBlocks.cindercane.get(), Fluids.LAVA, Fluids.FLOWING_LAVA)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWCAP = register("glowcap", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, simpleRandomPatch(PVJBlocks.glowcap.get().defaultBlockState())));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> PALM_TREE = register("palm_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new PalmTrunkPlacer(7, 2, 2), new PalmFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.palm_log.get(), PVJBlocks.palm_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new CoconutDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BIG_REDWOOD_TREE = register("big_redwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new RedwoodTrunkPlacer(31, 23, 17), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(17, 24)), PVJBlocks.redwood_log.get(), PVJBlocks.redwood_leaves.get(), new TwoLayersFeatureSize(1, 1, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE = register("small_redwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.redwood_log.get(), PVJBlocks.redwood_leaves.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_0002 = register("small_redwood_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.redwood_log.get(), PVJBlocks.redwood_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_REDWOOD_TREE_BEES_005 = register("small_redwood_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new SmallRedwoodTrunkPlacer(7, 5, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.redwood_log.get(), PVJBlocks.redwood_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FIR_TREE = register("fir_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 4, 6), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PVJBlocks.fir_log.get(), PVJBlocks.fir_leaves.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINE_TREE = register("pine_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(9, 2, 2), new PVJPineFoliagePlacer(UniformInt.of(3, 3), UniformInt.of(1, 1), UniformInt.of(2, 3)), PVJBlocks.pine_log.get(), PVJBlocks.pine_leaves.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WILLOW_TREE = register("willow_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new WillowTrunkPlacer(6, 3, 3), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.willow_log.get(), PVJBlocks.willow_leaves.get(), new TwoLayersFeatureSize(1, 0, 1), List.of(new LeaveVineDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> MANGROVE_TREE = register("mangrove_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new MangroveTrunkPlacer(4, 2, 2), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.mangrove_log.get(), PVJBlocks.mangrove_leaves.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> BAOBAB_TREE = register("baobab_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new BaobabTrunkPlacer(20, 5, 2), new BaobabFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.baobab_log.get(), PVJBlocks.baobab_leaves.get(), new TwoLayersFeatureSize(1, 1, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> JUNIPER_TREE = register("juniper_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new DesertJuniperTrunkPlacer(7, 2, 1), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.juniper_log.get(), PVJBlocks.juniper_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(new JuniperBerriesDecorator()))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> COTTONWOOD_TREE = register("cottonwood_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.cottonwood_log.get(), PVJBlocks.cottonwood_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> COTTONWOOD_TREE_BEES_005 = register("cottonwood_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(15, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.cottonwood_log.get(), PVJBlocks.cottonwood_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE = register("pink_sakura_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.pink_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE = register("white_sakura_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.white_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE_BEES_0002 = register("pink_sakura_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.pink_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE_BEES_0002 = register("white_sakura_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.white_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE_BEES_005 = register("pink_sakura_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.pink_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE_BEES_005 = register("white_sakura_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(10, 4, 3), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4), PVJBlocks.sakura_log.get(), PVJBlocks.white_sakura_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE = register("aspen_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.aspen_log.get(), PVJBlocks.aspen_leaves.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_0002 = register("aspen_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.aspen_log.get(), PVJBlocks.aspen_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ASPEN_TREE_BEES_005 = register("aspen_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new AspenTrunkPlacer(11, 5, 2), new AspenFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.aspen_log.get(), PVJBlocks.aspen_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE_TREE = register("red_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.maple_log.get(), PVJBlocks.red_maple_leaves.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = register("orange_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.maple_log.get(), PVJBlocks.orange_maple_leaves.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_MAPLE_TREE = register("purple_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(4, 2, 0), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), PVJBlocks.maple_log.get(), PVJBlocks.purple_maple_leaves.get(), new TwoLayersFeatureSize(1, 0, 1))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_RED_MAPLE_TREE = register("fancy_red_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PVJBlocks.maple_log.get(), PVJBlocks.red_maple_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_ORANGE_MAPLE_TREE = register("fancy_orange_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PVJBlocks.maple_log.get(), PVJBlocks.orange_maple_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_PURPLE_MAPLE_TREE = register("fancy_purple_maple_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(3, 11, 0), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), PVJBlocks.maple_log.get(), PVJBlocks.purple_maple_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE = register("tamarack_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PVJBlocks.tamarack_log.get(), PVJBlocks.tamarack_leaves.get(), new TwoLayersFeatureSize(2, 0, 2))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_0002 = register("tamarack_tree_bees_0002", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PVJBlocks.tamarack_log.get(), PVJBlocks.tamarack_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_0002))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> TAMARACK_TREE_BEES_005 = register("tamarack_tree_bees_005", () -> new ConfiguredFeature<>(Feature.TREE, tree(new StraightTrunkPlacer(15, 3, 4), new SpruceFoliagePlacer(UniformInt.of(2, 4), UniformInt.of(1, 1), UniformInt.of(2, 4)), PVJBlocks.tamarack_log.get(), PVJBlocks.tamarack_leaves.get(), new TwoLayersFeatureSize(2, 0, 2), List.of(BEEHIVE_005))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> JOSHUA_TREE = register("joshua_tree", () -> new ConfiguredFeature<>(Feature.TREE, tree(new FancyTrunkPlacer(8, 8, 0), new DesertJuniperFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), PVJBlocks.joshua_log.get(), PVJBlocks.joshua_leaves.get(), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL_POOL = register("crystal_pool", () -> new ConfiguredFeature<>(Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(
					BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.STONE), PlacementUtils.inlinePlaced(CaveFeatures.GLOW_LICHEN), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F)));
	
	public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<?, ?>> register(String name, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
		return CONFIGURED_FEATURES.register(name, configuredFeature);
	}
	
	private static RandomPatchConfiguration createRandomPatchFeature(int tries, int xzSpread, int ySpread, BlockState block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
				new SimpleBlockConfiguration(BlockStateProvider.simple(block)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))),
								BlockPredicate.not(BlockPredicate.matchesFluid(Fluids.WATER, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration createGroundcoverPatchFeature(int tries, int xzSpread, int ySpread, Block block) {
		return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.filtered(PVJFeatures.SIMPLE_BLOCK_MATCH_WATER.get(),
		      new SimpleBlockConfiguration(new RandomizedIntStateProvider(new DirectionalStateProvider(block), GroundcoverBlock.MODEL, UniformInt.of(0, 4))),
		    		  BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.ICE, new BlockPos(0, -1, 0))),
								BlockPredicate.not(BlockPredicate.matchesBlock(Blocks.SNOW, new BlockPos(0, 0, 0))))));
	}
	
	private static RandomPatchConfiguration simpleRandomPatch(BlockState blockstate) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(blockstate)));
	}
	
	public static RandomPatchConfiguration simpleRandomPatch(BlockStateProvider provider) {
		return FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider));
	}
	
	private static RandomPatchConfiguration columnPlantWithFluid(int tries, int xzspread, int yspread, Block block, Fluid fluid1, Fluid fluid2) {
		return new RandomPatchConfiguration(tries, xzspread, yspread, PlacementUtils.filtered(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 4), BlockStateProvider.simple(block)),
		    		  BlockPredicate.allOf(BlockPredicate.matchesBlock(Blocks.AIR, BlockPos.ZERO),
		    				  BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO),
		    				  BlockPredicate.anyOf(BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    						  new BlockPos(1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    								  new BlockPos(-1, -1, 0)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2),
		    										  new BlockPos(0, -1, 1)), BlockPredicate.matchesFluids(List.of(fluid1, fluid2), new BlockPos(0, -1, -1))))));
	}
	
	private static TreeConfiguration tree(TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer, Block log, Block leaves, FeatureSize featureSize, List<TreeDecorator> decorators) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), trunkPlacer,
																						BlockStateProvider.simple(leaves),
																						foliagePlacer, featureSize).ignoreVines().decorators(decorators).build();
	}
	
	private static TreeConfiguration tree(TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer, Block log, Block leaves, FeatureSize featureSize) {
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), trunkPlacer,
																						BlockStateProvider.simple(leaves),
																						foliagePlacer, featureSize).ignoreVines().build();
	}
	

}
