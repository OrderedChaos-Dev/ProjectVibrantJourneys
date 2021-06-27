package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class MangroveTrunkPlacer extends AbstractTrunkPlacer {
	
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
	public List<FoliagePlacer.Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int offY = 3 + rand.nextInt(3);
		BlockPos blockpos = pos.above(offY);
		for(int i = 0; i < height; i++) {
			placeLog(world, rand, blockpos.above(i), blocks, box, config);
		}
		
		placeLog(world, rand, blockpos.below(1).west(), blocks, box, config);
		placeLog(world, rand, blockpos.below(1).east(), blocks, box, config);
		placeLog(world, rand, blockpos.below(1).north(), blocks, box, config);
		placeLog(world, rand, blockpos.below(1).south(), blocks, box, config);
		
		BlockPos temp = blockpos.below(2);
		int i = 0;
		while(world.isStateAtPosition(temp.west(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, rand, temp.west(2).below(i), blocks, box, config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.east(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, rand, temp.east(2).below(i), blocks, box, config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.south(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, rand, temp.south(2).below(i), blocks, box, config);
			i++;
		}
		i = 0;
		while(world.isStateAtPosition(temp.north(2).below(i), (state) -> state.getMaterial().isReplaceable())) {
			placeLog(world, rand, temp.north(2).below(i), blocks, box, config);
			i++;
		}

		return ImmutableList.of(new FoliagePlacer.Foliage(pos.above(offY + height), 0, false));
	}
}