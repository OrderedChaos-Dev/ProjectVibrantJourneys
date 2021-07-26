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

public class SmallRedwoodTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<SmallRedwoodTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
		return trunkPlacerParts(instance).apply(instance, SmallRedwoodTrunkPlacer::new);
	});

	public SmallRedwoodTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
		super(baseHeight, heightRandA, heightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.SMALL_REDWOOD_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		setDirtAt(world, placer, rand, pos.below(), config);

		for (int i = 0; i < height; ++i) {
			placeLog(world, placer, rand, pos.above(i), config);
		}
		
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 4, 0, 1);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 4, 1, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 4, -1, 0);
		placeBase(world, placer, rand, blockpos$mutable, config, pos, 1, 4, 0, -1);

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));
	}
	
	public static void placeBase(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos start, int heightMin, int heightMax, int offX, int offZ) {
		int height = rand.nextInt(heightMax - heightMin) + heightMin;
		int offY = 1;
		while(offY > -3 && world.isStateAtPosition(pos.setWithOffset(start, offX, offY, offZ), (state) -> state.getMaterial().isReplaceable())) {
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
