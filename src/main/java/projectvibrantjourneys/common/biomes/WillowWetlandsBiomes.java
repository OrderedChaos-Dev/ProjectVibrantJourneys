package projectvibrantjourneys.common.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class WillowWetlandsBiomes extends Biome {
   public WillowWetlandsBiomes() {
      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.SWAMP).depth(-0.2F).scale(0.1F).temperature(0.8F).downfall(0.9F).waterColor(6388580).waterFogColor(2302743).parent((String)null));
      this.func_226711_a_(Feature.SWAMP_HUT.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
      this.func_226711_a_(Feature.MINESHAFT.func_225566_b_(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
      DefaultBiomeFeatures.addCarvers(this);
      DefaultBiomeFeatures.addStructures(this);
      DefaultBiomeFeatures.addLakes(this);
      DefaultBiomeFeatures.addMonsterRooms(this);
      DefaultBiomeFeatures.addStoneVariants(this);
      DefaultBiomeFeatures.addOres(this);
      DefaultBiomeFeatures.addSwampClayDisks(this);
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227247_y_.func_225566_b_(DefaultBiomeFeatures.field_226830_y_).func_227228_a_(Placement.COUNT_HEIGHTMAP_32.func_227446_a_(new FrequencyConfig(1))));
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226826_u_).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(5))));
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226715_C_).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(1))));
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226720_H_).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(4))));
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226722_J_).func_227228_a_(Placement.COUNT_CHANCE_HEIGHTMAP.func_227446_a_(new HeightWithChanceConfig(8, 0.25F))));
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(DefaultBiomeFeatures.field_226721_I_).func_227228_a_(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.func_227446_a_(new HeightWithChanceConfig(8, 0.125F))));
      DefaultBiomeFeatures.addMushrooms(this);
      DefaultBiomeFeatures.func_222329_ae(this);
      DefaultBiomeFeatures.addSprings(this);
      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.func_225566_b_(new SeaGrassConfig(64, 0.6D)).func_227228_a_(Placement.TOP_SOLID_HEIGHTMAP.func_227446_a_(IPlacementConfig.NO_PLACEMENT_CONFIG)));
      DefaultBiomeFeatures.addFossils(this);
      DefaultBiomeFeatures.addFreezeTopLayer(this);
      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 1, 1, 1));
   }

   @OnlyIn(Dist.CLIENT)
   public int func_225528_a_(double x, double z) {
	   double d0 = INFO_NOISE.func_215464_a(x * 0.0225D, z * 0.0225D, false);
       return d0 < -0.1D ? 0x5B9F27 : 0x70D325;
   }

   @OnlyIn(Dist.CLIENT)
   public int func_225527_a_() {
      return 0x70D325;
   }
}