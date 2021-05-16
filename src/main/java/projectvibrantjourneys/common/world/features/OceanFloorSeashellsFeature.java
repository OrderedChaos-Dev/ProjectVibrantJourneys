package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.object.PVJBlocks;

public class OceanFloorSeashellsFeature extends Feature<NoFeatureConfig> {
   public OceanFloorSeashellsFeature(Codec<NoFeatureConfig> p_i231988_1_) {
      super(p_i231988_1_);
   }

   @Override
   public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
      boolean flag = false;
      int i = rand.nextInt(8) - rand.nextInt(8);
      int j = rand.nextInt(8) - rand.nextInt(8);
      int k = world.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
      BlockPos blockpos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
      if (world.getBlockState(blockpos).is(Blocks.WATER)) {
         BlockState state = PVJBlocks.seashells.defaultBlockState();
         if (state.canSurvive(world, blockpos) && rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
				int model = rand.nextInt(5);
				Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
				world.setBlock(blockpos, state
											.setValue(GroundcoverBlock.MODEL, model)
											.setValue(GroundcoverBlock.FACING, facing)
											.setValue(BlockStateProperties.WATERLOGGED, true), 2);

            flag = true;
         }
      }

      return flag;
   }
}
