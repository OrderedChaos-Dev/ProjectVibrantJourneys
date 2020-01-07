package projectvibrantjourneys.common.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class CobwebFeature extends Feature<NoFeatureConfig> {
	public CobwebFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);

		for (int i = pos.getY(); i < world.getWorld().getDimension().getHeight(); i++) {
			blockpos.setPos(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (world.getBlockState(blockpos).getBlock() instanceof LeavesBlock) {
				if(world.isAirBlock(blockpos.down())) {
					if(rand.nextBoolean()) {
						world.setBlockState(blockpos.down(), Blocks.COBWEB.getDefaultState(), 2);
						break;
					}
				}
			}
		}

		return true;
	}
}