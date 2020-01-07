package projectvibrantjourneys.common.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.init.PVJBlocks;

public class BarkMushroomFeature extends Feature<NoFeatureConfig> {
	public BarkMushroomFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);

		for (int i = pos.getY(); i < world.getWorld().getDimension().getHeight(); i++) {
			blockpos.setPos(pos);
			blockpos.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
			blockpos.setY(i);
			if (BarkMushroomBlock.canAttachTo(world, blockpos, Direction.DOWN)) {
				boolean flag = false;
				while(!flag) {
					Direction dir = Direction.Plane.HORIZONTAL.random(rand);
					if (world.isAirBlock(blockpos.offset(dir)))
						world.setBlockState(blockpos.offset(dir), PVJBlocks.bark_mushroom.getDefaultState().with(BarkMushroomBlock.FACING, dir), 2);						
					
					if(rand.nextFloat() < 0.8F) {
						flag = true;
					}
				}
			}
		}

		return true;
	}
}