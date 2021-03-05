package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.features.CobwebFeature;
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	
	public static Feature<NoFeatureConfig> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityConfig> bushFeature;
	public static Feature<NoFeatureConfig> waterCattailFeature;
	public static Feature<NoFeatureConfig> barkMushroomFeature;
	public static Feature<NoFeatureConfig> cobwebFeature;
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = new OceanFloorSeashellsFeature(NoFeatureConfig.field_236558_a_);
		bushFeature = new BushFeature(ProbabilityConfig.CODEC);
		waterCattailFeature = new WaterCattailFeature(NoFeatureConfig.field_236558_a_);
		barkMushroomFeature = new BarkMushroomFeature(NoFeatureConfig.field_236558_a_);
		cobwebFeature = new CobwebFeature(NoFeatureConfig.field_236558_a_);
		
		registerFeature(oceanFloorSeashellsFeature, "ocean_floor_seashells_feature");
		registerFeature(bushFeature, "bush_feature");
		registerFeature(waterCattailFeature, "water_cattail_feature");
		registerFeature(barkMushroomFeature, "bark_mushroom_feature");
		registerFeature(cobwebFeature, "cobweb_feature");
	}
	
	public static void registerFeature(Feature<?> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ForgeRegistries.FEATURES.register(feature);
	}
}
