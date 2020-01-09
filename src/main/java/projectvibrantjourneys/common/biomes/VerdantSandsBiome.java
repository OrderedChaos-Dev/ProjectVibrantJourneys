package projectvibrantjourneys.common.biomes;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import projectvibrantjourneys.init.PVJBiomes;

public final class VerdantSandsBiome extends Biome {
	public VerdantSandsBiome() {
		super((new Biome.Builder()).surfaceBuilder(PVJBiomes.verdant_sands_surface_builder, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG)
				.precipitation(Biome.RainType.RAIN).category(Biome.Category.DESERT).depth(0.125F).scale(0.05F)
				.temperature(1.5F).downfall(0.5F).waterColor(4159204).waterFogColor(329011).parent((String) null));
		this.func_226711_a_(Feature.VILLAGE.func_225566_b_(new VillageConfig("village/desert/town_centers", 6)));
		this.func_226711_a_(Feature.PILLAGER_OUTPOST.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
		this.func_226711_a_(Feature.DESERT_PYRAMID.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
		this.func_226711_a_(
				Feature.MINESHAFT.func_225566_b_(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.func_226711_a_(Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addDesertLakes(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.func_222299_R(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.func_222290_D(this);
		DefaultBiomeFeatures.func_222348_W(this);
		DefaultBiomeFeatures.addSavannaTrees(this);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR
				.func_225566_b_(new MultipleRandomFeatureConfig(ImmutableList.of(
						Feature.FANCY_TREE.func_225566_b_(DefaultBiomeFeatures.field_226817_l_).func_227227_a_(0.3F),
						Feature.FANCY_TREE.func_225566_b_(DefaultBiomeFeatures.field_226815_j_).func_227227_a_(0.6F),
						Feature.JUNGLE_GROUND_BUSH.func_225566_b_(DefaultBiomeFeatures.field_226821_p_)
								.func_227227_a_(0.7F),
						Feature.NORMAL_TREE.func_225566_b_(DefaultBiomeFeatures.field_226792_b_).func_227227_a_(0.6F)),
						Feature.NORMAL_TREE.func_225566_b_(DefaultBiomeFeatures.field_226739_a_)))
				.func_227228_a_(
						Placement.COUNT_EXTRA_HEIGHTMAP.func_227446_a_(new AtSurfaceWithExtraConfig(5, 0.2F, 1))));
		DefaultBiomeFeatures.addDeadBushes(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addDesertFeatures(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	}
}