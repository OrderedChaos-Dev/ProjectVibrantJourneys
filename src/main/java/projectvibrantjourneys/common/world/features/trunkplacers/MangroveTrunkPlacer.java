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
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class MangroveTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<MangroveTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, MangroveTrunkPlacer::new);
	});

	public MangroveTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.MANGROVE_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		int offY = 4 + rand.nextInt(3);
		BlockPos blockpos = pos.above(offY);
		for(int i = 0; i < height; i++) {
			placeLog(world, placer, rand, blockpos.above(i), config);
		}
		
		placeLog(world, placer, rand, blockpos.below(1).west(), config);
		placeLog(world, placer, rand, blockpos.below(1).east(), config);
		placeLog(world, placer, rand, blockpos.below(1).north(), config);
		placeLog(world, placer, rand, blockpos.below(1).south(), config);
		
		BlockPos temp = blockpos.below(2);
		int i = 0;
		while(world.isStateAtPosition(temp.west(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, placer, rand, temp.west(2).below(i), config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.east(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, placer, rand, temp.east(2).below(i), config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.south(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, placer, rand, temp.south(2).below(i), config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.north(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, placer, rand, temp.north(2).below(i), config);
			i++;
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(offY + height), 0, false));
	}
}