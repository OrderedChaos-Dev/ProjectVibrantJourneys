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
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class OvergrownSpiresBiome extends Biome {
	public OvergrownSpiresBiome() {
		super((new Biome.Builder())
				.surfaceBuilder(SurfaceBuilder.SHATTERED_SAVANNA, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.precipitation(Biome.RainType.RAIN)
				.category(Biome.Category.JUNGLE)
				.depth(0.3625F)
				.scale(1.225F)
				.temperature(0.95F)
				.downfall(0.9F)
				.waterColor(4445678)
				.waterFogColor(270131)
				.parent((String) null));
		this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.addStructure(Feature.JUNGLE_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addBamboo(this);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR
				.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
						Feature.DARK_OAK_TREE.withConfiguration(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG).withChance(0.2F),
						Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.6F),
						Feature.JUNGLE_GROUND_BUSH.withConfiguration(DefaultBiomeFeatures.JUNGLE_GROUND_BUSH_CONFIG).withChance(0.7F),
						Feature.MEGA_JUNGLE_TREE.withConfiguration(DefaultBiomeFeatures.MEGA_JUNGLE_TREE_CONFIG).withChance(0.2F),
						Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG).withChance(0.6F)),
						Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
				.withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.2F, 1))));
		DefaultBiomeFeatures.addOakAndJungleTrees(this);
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.addMushrooms(this);
		DefaultBiomeFeatures.addReedsAndPumpkins(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addJunglePlants(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 40, 1, 2));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.OCELOT, 2, 1, 3));
	}
}