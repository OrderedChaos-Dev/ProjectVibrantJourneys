package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class RedwoodTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<RedwoodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
		return trunkPlacerParts(instance).apply(instance, RedwoodTrunkPlacer::new);
	});

	public RedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.REDWOOD_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		BlockPos blockpos = pos.below();
		//place dirt
		setDirtAt(world, placer, rand, blockpos, config);
		setDirtAt(world, placer, rand, blockpos.east(), config);
		setDirtAt(world, placer, rand, blockpos.south(), config);
		setDirtAt(world, placer, rand, blockpos.north(), config);
		
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int i = 0; i < height; ++i) {
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 0, i, 0);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 1, i, 0);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 1, i, 1);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 0, i, 1);
		}
		
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, -1, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, -1, 1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 0, 2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 1, 2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 2, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 2, 1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 0, -1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 5, 8, 1, -1);
		
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, -1, 2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, -1, -1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 2, 2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 2, -1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, -2, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, -2, 1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 3, 1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 3, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 0, -2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 1, -2);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 0, 3);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 5, 1, 3);

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, true));
	}

	private static void placeLog(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos start, int offX, int offY, int offZ) {
		pos.setWithOffset(start, offX, offY, offZ);
		//place log
		placer.accept(pos, config.trunkProvider.getState(rand, pos));
	}
	
	public static void placeBase(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos start, int heightMin, int heightMax, int offX, int offZ) {
		int height = rand.nextInt(heightMax - heightMin) + heightMin;
		int offY = 1;
		while(offY > -4 && world.isStateAtPosition(pos.setWithOffset(start, offX, offY, offZ), (state) -> state.getMaterial().isReplaceable())) {
			offY--;
		}
		
		for(int i = offY; i < height; i++) {
			BlockPos.MutableBlockPos temp = pos.setWithOffset(start, offX, i, offZ);
			
			if(i < height - 1)
				placer.accept(temp, config.trunkProvider.getState(rand, temp));
			else
				placer.accept(temp, PVJBlocks.redwood_wood.defaultBlockState());
		}
	}
}
