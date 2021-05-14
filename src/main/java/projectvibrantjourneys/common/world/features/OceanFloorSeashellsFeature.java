package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.objectregistry.PVJBlocks;

public class OceanFloorSeashellsFeature extends Feature<NoFeatureConfig> {
   public OceanFloorSeashellsFeature(Codec<NoFeatureConfig> p_i231988_1_) {
      super(p_i231988_1_);
   }

   @Override
   public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      boolean flag = false;
      int i = rand.nextInt(8) - rand.nextInt(8);
      int j = rand.nextInt(8) - rand.nextInt(8);
      int k = reader.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
      BlockPos blockpos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
      if (reader.getBlockState(blockpos).is(Blocks.WATER)) {
         BlockState state = PVJBlocks.seashells.defaultBlockState();
         if (state.canSurvive(reader, blockpos) && rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
        	 reader.setBlock(blockpos, state.setValue(GroundcoverBlock.MODEL, rand.nextInt(5)).setValue(BlockStateProperties.WATERLOGGED, true), 2);

            flag = true;
         }
      }

      return flag;
   }
}
