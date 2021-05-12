package projectvibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.features.CobwebFeature;
import projectvibrantjourneys.common.world.features.FallenTreeFeature;
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	public static ArrayList<Feature<?>> FEATURES = new ArrayList<Feature<?>>();
	
	public static Feature<NoFeatureConfig> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityConfig> bushFeature;
	public static Feature<NoFeatureConfig> waterCattailFeature;
	public static Feature<NoFeatureConfig> barkMushroomFeature;
	public static Feature<ProbabilityConfig> cobwebFeature;
	public static Feature<NoFeatureConfig> fallenTreeFeature;
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = registerFeature(new OceanFloorSeashellsFeature(NoFeatureConfig.CODEC), "ocean_floor_seashells_feature");
		bushFeature = registerFeature(new BushFeature(ProbabilityConfig.CODEC), "bush_feature");
		waterCattailFeature = registerFeature(new WaterCattailFeature(NoFeatureConfig.CODEC), "water_cattail_feature");
		barkMushroomFeature = registerFeature(new BarkMushroomFeature(NoFeatureConfig.CODEC), "bark_mushroom_feature");
		cobwebFeature = registerFeature(new CobwebFeature(ProbabilityConfig.CODEC), "cobweb_feature");
		fallenTreeFeature = registerFeature(new FallenTreeFeature(NoFeatureConfig.CODEC), "fallen_tree_feature");
		
		event.getRegistry().registerAll(FEATURES.toArray(new Feature[0]));
	}
	
	public static <FC extends IFeatureConfig> Feature<FC> registerFeature(Feature<FC> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		FEATURES.add(feature);
		return feature;
	}
}
