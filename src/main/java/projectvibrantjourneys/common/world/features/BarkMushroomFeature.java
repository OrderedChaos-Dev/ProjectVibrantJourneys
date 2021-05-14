package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.init.object.PVJBlocks;

public class BarkMushroomFeature extends Feature<NoFeatureConfig> {
	public BarkMushroomFeature(Codec<NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(ISeedReader world, ChunkGenerator chunkGen, Random rand, BlockPos pos, NoFeatureConfig config) {
		BlockPos.Mutable blockpos = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());

		for (int i = 64; i < world.getHeight(); i++) {
			blockpos.set(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (BarkMushroomBlock.canAttachTo(world, blockpos, Direction.DOWN)) {
				boolean flag = false;
				while(!flag) {
					Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
					if (world.isEmptyBlock(blockpos.offset(dir.getNormal())) && world.getBlockState(blockpos).isCollisionShapeFullBlock(world, pos))
						world.setBlock(blockpos.offset(dir.getNormal()), PVJBlocks.bark_mushroom.defaultBlockState().setValue(BarkMushroomBlock.FACING, dir), 2);						
					
					if(rand.nextFloat() < 0.8F) {
						flag = true;
					}
				}
			}
		}

		return true;
	}
}