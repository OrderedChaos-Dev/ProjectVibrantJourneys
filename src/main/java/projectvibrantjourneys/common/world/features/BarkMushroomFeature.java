package projectvibrantjourneys.common.world.features;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.init.object.PVJBlocks;

public class BarkMushroomFeature extends Feature<NoneFeatureConfiguration> {
	public BarkMushroomFeature(Codec<NoneFeatureConfiguration> config) {
		super(config);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();
		BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());

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