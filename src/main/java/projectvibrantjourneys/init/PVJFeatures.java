package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.features.CobwebFeature;
import projectvibrantjourneys.common.world.features.FallenTreeFeature;
import projectvibrantjourneys.common.world.features.MangroveRootsFeature;
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.common.world.features.trees.AspenTreeFeature;
import projectvibrantjourneys.common.world.features.trees.BaobabTreeFeature;
import projectvibrantjourneys.common.world.features.trees.CottonwoodTreeFeature;
import projectvibrantjourneys.common.world.features.trees.JuniperTreeFeature;
import projectvibrantjourneys.common.world.features.trees.MangroveTreeFeature;
import projectvibrantjourneys.common.world.features.trees.MegaRedwoodTreeFeature;
import projectvibrantjourneys.common.world.features.trees.PalmTreeFeature;
import projectvibrantjourneys.common.world.features.trees.PineTreeFeature;
import projectvibrantjourneys.common.world.features.trees.RedwoodTreeFeature;
import projectvibrantjourneys.common.world.features.trees.WillowTreeFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	
	public static Feature<SeaGrassConfig> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityConfig> bushFeature;
	public static Feature<SeaGrassConfig> waterCattailFeature;
	public static Feature<NoFeatureConfig> barkMushroomFeature;
	public static Feature<NoFeatureConfig> cobwebFeature;
	public static Feature<BlockStateFeatureConfig> fallenTreeFeature;
	public static Feature<BlockClusterFeatureConfig> randomPatchNoFlatFeature;
	public static Feature<TreeFeatureConfig> pineTree;
	public static Feature<TreeFeatureConfig> palmTree;
	public static Feature<TreeFeatureConfig> willowTree;
	public static Feature<TreeFeatureConfig> mangroveTree;
	public static Feature<TreeFeatureConfig> redwoodTree;
	public static Feature<TreeFeatureConfig> aspenTree;
	public static Feature<HugeTreeFeatureConfig> megaRedwoodTree;
	public static Feature<HugeTreeFeatureConfig> baobabTree;
	public static Feature<TreeFeatureConfig> cottonwoodTree;
	public static Feature<TreeFeatureConfig> juniperTree;
	public static Feature<NoFeatureConfig> mangroveRootFeature;
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = new OceanFloorSeashellsFeature(SeaGrassConfig::deserialize);
		bushFeature = new BushFeature(ProbabilityConfig::deserialize);
		waterCattailFeature = new WaterCattailFeature(SeaGrassConfig::deserialize);
		barkMushroomFeature = new BarkMushroomFeature(NoFeatureConfig::deserialize);
		cobwebFeature = new CobwebFeature(NoFeatureConfig::deserialize);
		fallenTreeFeature = new FallenTreeFeature(BlockStateFeatureConfig::deserialize);
		pineTree = new PineTreeFeature(TreeFeatureConfig::deserializeFoliage);
		palmTree = new PalmTreeFeature(TreeFeatureConfig::deserializeFoliage);
		willowTree = new WillowTreeFeature(TreeFeatureConfig::deserializeFoliage);
		mangroveTree = new MangroveTreeFeature(TreeFeatureConfig::deserializeFoliage);
		redwoodTree = new RedwoodTreeFeature(TreeFeatureConfig::deserializeFoliage);
		aspenTree = new AspenTreeFeature(TreeFeatureConfig::deserializeFoliage);
		megaRedwoodTree = new MegaRedwoodTreeFeature(HugeTreeFeatureConfig::func_227277_a_);
		baobabTree = new BaobabTreeFeature(HugeTreeFeatureConfig::func_227277_a_);
		cottonwoodTree = new CottonwoodTreeFeature(TreeFeatureConfig::deserializeFoliage);
		juniperTree = new JuniperTreeFeature(TreeFeatureConfig::deserializeFoliage);
		mangroveRootFeature = new MangroveRootsFeature(NoFeatureConfig::deserialize);
		
		registerFeature(oceanFloorSeashellsFeature, "ocean_floor_seashells_feature");
		registerFeature(bushFeature, "bush_feature");
		registerFeature(waterCattailFeature, "water_cattail_feature");
		registerFeature(barkMushroomFeature, "bark_mushroom_feature");
		registerFeature(cobwebFeature, "cobweb_feature");
		registerFeature(fallenTreeFeature, "fallen_tree_feature");
		registerFeature(pineTree, "pine_tree");
		registerFeature(palmTree, "palm_tree");
		registerFeature(willowTree, "willow_tree");
		registerFeature(mangroveTree, "mangrove_tree");
		registerFeature(redwoodTree, "redwood_tree");
		registerFeature(aspenTree, "aspen_tree");
		registerFeature(megaRedwoodTree, "mega_redwood_tree");
		registerFeature(baobabTree, "baobab_tree");
		registerFeature(cottonwoodTree, "cottonwood_tree");
		registerFeature(juniperTree, "juniper_tree");
		registerFeature(mangroveRootFeature, "mangrove_root_feature");
	}
	
	public static void registerFeature(Feature<?> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.FEATURES.register(feature);
	}
}
