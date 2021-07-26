package projectvibrantjourneys.init.world;

import java.util.ArrayList;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.features.CliffRockFeature;
import projectvibrantjourneys.common.world.features.CobwebFeature;
import projectvibrantjourneys.common.world.features.FallenTreeFeature;
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.SandBlockBlobFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	public static final ArrayList<Feature<?>> FEATURES = new ArrayList<Feature<?>>();
	
	public static Feature<NoneFeatureConfiguration> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityFeatureConfiguration> bushFeature;
	public static Feature<NoneFeatureConfiguration> waterCattailFeature;
	public static Feature<NoneFeatureConfiguration> barkMushroomFeature;
	public static Feature<ProbabilityFeatureConfiguration> cobwebFeature;
	public static Feature<NoneFeatureConfiguration> fallenTreeFeature;
	public static Feature<BlockStateConfiguration> sandRock;
	public static Feature<ProbabilityFeatureConfiguration> cliffRock;
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = registerFeature(new OceanFloorSeashellsFeature(NoneFeatureConfiguration.CODEC), "ocean_floor_seashells_feature");
		bushFeature = registerFeature(new BushFeature(ProbabilityFeatureConfiguration.CODEC), "bush_feature");
		waterCattailFeature = registerFeature(new WaterCattailFeature(NoneFeatureConfiguration.CODEC), "water_cattail_feature");
		barkMushroomFeature = registerFeature(new BarkMushroomFeature(NoneFeatureConfiguration.CODEC), "bark_mushroom_feature");
		cobwebFeature = registerFeature(new CobwebFeature(ProbabilityFeatureConfiguration.CODEC), "cobweb_feature");
		fallenTreeFeature = registerFeature(new FallenTreeFeature(NoneFeatureConfiguration.CODEC), "fallen_tree_feature");
		sandRock = registerFeature(new SandBlockBlobFeature(BlockStateConfiguration.CODEC), "sand_rock");
		cliffRock = registerFeature(new CliffRockFeature(ProbabilityFeatureConfiguration.CODEC), "cliff_rock");
		
		FEATURES.forEach((feature) -> event.getRegistry().register(feature));
	}
	
	public static <FC extends FeatureConfiguration> Feature<FC> registerFeature(Feature<FC> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		FEATURES.add(feature);
		return feature;
	}
}
