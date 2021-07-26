package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.core.PVJConfig;
import projectvibrantjourneys.init.object.PVJBlocks;

public class OceanFloorSeashellsFeature extends Feature<NoneFeatureConfiguration> {
   public OceanFloorSeashellsFeature(Codec<NoneFeatureConfiguration> p_i231988_1_) {
      super(p_i231988_1_);
   }

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		boolean flag = false;
		int i = rand.nextInt(8) - rand.nextInt(8);
		int j = rand.nextInt(8) - rand.nextInt(8);
		int k = world.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + i, pos.getZ() + j);
		BlockPos blockpos = new BlockPos(pos.getX() + i, k, pos.getZ() + j);
		if (world.getBlockState(blockpos).is(Blocks.WATER)) {
			BlockState state = PVJBlocks.seashells.defaultBlockState();
			if (state.canSurvive(world, blockpos) && rand.nextInt(100) < PVJConfig.groundcoverChance.get()) {
				int model = rand.nextInt(5);
				Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
				world.setBlock(blockpos, state.setValue(GroundcoverBlock.MODEL, model)
						.setValue(GroundcoverBlock.FACING, facing).setValue(BlockStateProperties.WATERLOGGED, true), 2);

				flag = true;
			}
		}

		return flag;
	}
}
