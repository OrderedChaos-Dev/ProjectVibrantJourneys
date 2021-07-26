package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import projectvibrantjourneys.common.blocks.CattailBlock;
import projectvibrantjourneys.init.object.PVJBlocks;

public class WaterCattailFeature extends Feature<NoneFeatureConfiguration> {
	public WaterCattailFeature(Codec<NoneFeatureConfiguration> config) {
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		int i = 0;

		int k = rand.nextInt(8) - rand.nextInt(8);
		int l = rand.nextInt(8) - rand.nextInt(8);
		int i1 = world.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
		BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
		if (world.getBlockState(blockpos).getBlock() == Blocks.WATER && world.getBlockState(blockpos.above()).getBlock() == Blocks.AIR) {
			BlockState state = PVJBlocks.cattail.defaultBlockState();
			if (state.canSurvive(world, blockpos)) {
				((CattailBlock) state.getBlock()).placeInWater(world, blockpos, 2);
				i++;
			}
		}

		return i > 0;
	}
}