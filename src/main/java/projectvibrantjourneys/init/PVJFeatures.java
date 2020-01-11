package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
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
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.common.world.features.trees.PineTreeFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	
	public static Feature<SeaGrassConfig> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityConfig> bushFeature;
	public static Feature<SeaGrassConfig> waterCattailFeature;
	public static Feature<NoFeatureConfig> barkMushroomFeature;
	public static Feature<NoFeatureConfig> cobwebFeature;
	public static Feature<BlockStateFeatureConfig> fallenTreeFeature;
	public static Feature<TreeFeatureConfig> pineTree;
	
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = new OceanFloorSeashellsFeature(SeaGrassConfig::deserialize);
		bushFeature = new BushFeature(ProbabilityConfig::deserialize);
		waterCattailFeature = new WaterCattailFeature(SeaGrassConfig::deserialize);
		barkMushroomFeature = new BarkMushroomFeature(NoFeatureConfig::deserialize);
		cobwebFeature = new CobwebFeature(NoFeatureConfig::deserialize);
		fallenTreeFeature = new FallenTreeFeature(BlockStateFeatureConfig::func_227271_a_);
		pineTree = new PineTreeFeature(TreeFeatureConfig::func_227338_a_);
		
		registerFeature(oceanFloorSeashellsFeature, "ocean_floor_seashells_feature");
	}
	
	public static void registerFeature(Feature<?> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.FEATURES.register(feature);
	}
}
