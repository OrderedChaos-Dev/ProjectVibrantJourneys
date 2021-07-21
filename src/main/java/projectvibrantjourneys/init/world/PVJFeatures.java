package projectvibrantjourneys.init.world;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.common.world.features.BarkMushroomFeature;
import projectvibrantjourneys.common.world.features.BushFeature;
import projectvibrantjourneys.common.world.features.CliffRockFeature;
import projectvibrantjourneys.common.world.features.CobwebFeature;
import projectvibrantjourneys.common.world.features.FallenTreeFeature;
import projectvibrantjourneys.common.world.features.JuniperTreeFeature;
import projectvibrantjourneys.common.world.features.OceanFloorSeashellsFeature;
import projectvibrantjourneys.common.world.features.SandBlockBlobFeature;
import projectvibrantjourneys.common.world.features.SandTreeFeature;
import projectvibrantjourneys.common.world.features.SnowMountainTreeFeature;
import projectvibrantjourneys.common.world.features.WaterCattailFeature;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJFeatures {
	public static final ArrayList<Feature<?>> FEATURES = new ArrayList<Feature<?>>();
	
	public static Feature<NoFeatureConfig> oceanFloorSeashellsFeature;
	public static Feature<ProbabilityConfig> bushFeature;
	public static Feature<NoFeatureConfig> waterCattailFeature;
	public static Feature<NoFeatureConfig> barkMushroomFeature;
	public static Feature<ProbabilityConfig> cobwebFeature;
	public static Feature<NoFeatureConfig> fallenTreeFeature;
	public static Feature<BaseTreeFeatureConfig> snowTree;
	public static Feature<BaseTreeFeatureConfig> sandTree;
	public static Feature<BaseTreeFeatureConfig> juniperTree;
	public static Feature<BlockStateFeatureConfig> sandRock;
	public static Feature<ProbabilityConfig> cliffRock;
	
	@SubscribeEvent
	public static void initFeatures(RegistryEvent.Register<Feature<?>> event) {
		oceanFloorSeashellsFeature = registerFeature(new OceanFloorSeashellsFeature(NoFeatureConfig.CODEC), "ocean_floor_seashells_feature");
		bushFeature = registerFeature(new BushFeature(ProbabilityConfig.CODEC), "bush_feature");
		waterCattailFeature = registerFeature(new WaterCattailFeature(NoFeatureConfig.CODEC), "water_cattail_feature");
		barkMushroomFeature = registerFeature(new BarkMushroomFeature(NoFeatureConfig.CODEC), "bark_mushroom_feature");
		cobwebFeature = registerFeature(new CobwebFeature(ProbabilityConfig.CODEC), "cobweb_feature");
		fallenTreeFeature = registerFeature(new FallenTreeFeature(NoFeatureConfig.CODEC), "fallen_tree_feature");
		snowTree = registerFeature(new SnowMountainTreeFeature(BaseTreeFeatureConfig.CODEC), "snow_tree");
		sandTree = registerFeature(new SandTreeFeature(BaseTreeFeatureConfig.CODEC), "sand_tree");
		juniperTree = registerFeature(new JuniperTreeFeature(BaseTreeFeatureConfig.CODEC), "juniper_tree");
		sandRock = registerFeature(new SandBlockBlobFeature(BlockStateFeatureConfig.CODEC), "sand_rock");
		cliffRock = registerFeature(new CliffRockFeature(ProbabilityConfig.CODEC), "cliff_rock");
		
		FEATURES.forEach((feature) -> event.getRegistry().register(feature));
	}
	
	public static <FC extends IFeatureConfig> Feature<FC> registerFeature(Feature<FC> feature, String name) {
		feature.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		FEATURES.add(feature);
		return feature;
	}
}
