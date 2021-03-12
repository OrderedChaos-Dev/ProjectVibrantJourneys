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
import projectvibrantjourneys.init.PVJBlocks;

public class OceanFloorSeashellsFeature extends Feature<NoFeatureConfig> {
   public OceanFloorSeashellsFeature(Codec<NoFeatureConfig> p_i231988_1_) {
      super(p_i231988_1_);
   }

   public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      boolean flag = false;
      int i = rand.nextInt(8) - rand.nextInt(8);
      int j = rand.nextInt(8) - rand.nextInt(8);
      int k = reader.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
      BlockPos blockpos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
      if (reader.getBlockState(blockpos).isIn(Blocks.WATER)) {
         BlockState state = PVJBlocks.seashells.getDefaultState();
         if (state.isValidPosition(reader, blockpos) &&  rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
        	 reader.setBlockState(blockpos, state.with(GroundcoverBlock.MODEL, rand.nextInt(5)).with(BlockStateProperties.WATERLOGGED, true), 2);

            flag = true;
         }
      }

      return flag;
   }
}
