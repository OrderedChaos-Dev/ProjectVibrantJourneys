package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

/**
 * 
 * based off of acacia tree
 *
 */
public class WillowTrunkPlacer extends AbstractTrunkPlacer {
	
	public static final Codec<WillowTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, WillowTrunkPlacer::new);
	});

	public WillowTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return TrunkPlacerType.FORKING_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		setDirtAt(world, pos.below());
		List<FoliagePlacer.Foliage> list = Lists.newArrayList();
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		int i = height - rand.nextInt(4) - 2;
		int j = 3 - rand.nextInt(3);
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		int k = pos.getX();
		int l = pos.getZ();
		int i1 = 0;
		
		placeLog(world, rand, blockpos$mutable.set(k + 1, pos.getY(), l), blocks, box, config);
		placeLog(world, rand, blockpos$mutable.set(k - 1, pos.getY(), l), blocks, box, config);
		placeLog(world, rand, blockpos$mutable.set(k, pos.getY(), l + 1), blocks, box, config);
		placeLog(world, rand, blockpos$mutable.set(k, pos.getY(), l - 1), blocks, box, config);

		for (int j1 = 0; j1 < height; ++j1) {
			int k1 = pos.getY() + j1;
			if (j1 >= i && j > 0) {
				k += direction.getStepX();
				l += direction.getStepZ();
				--j;
			}

			if (placeLog(world, rand, blockpos$mutable.set(k, k1, l), blocks, box, config)) {
				i1 = k1 + 1;
			}
		}

		list.add(new FoliagePlacer.Foliage(new BlockPos(k, i1, l), 1, false));
		k = pos.getX();
		l = pos.getZ();
		Direction direction1 = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		if (direction1 != direction) {
			int k2 = i - rand.nextInt(2) - 1;
			int l1 = 1 + rand.nextInt(3);
			i1 = 0;

			for (int i2 = k2; i2 < height && l1 > 0; --l1) {
				if (i2 >= 1) {
					int j2 = pos.getY() + i2;
					k += direction1.getStepX();
					l += direction1.getStepZ();
					if (placeLog(world, rand, blockpos$mutable.set(k, j2, l), blocks, box, config)) {
						i1 = j2 + 1;
					}
				}

				++i2;
			}

			if (i1 > 1) {
				list.add(new FoliagePlacer.Foliage(new BlockPos(k, i1, l), 0, false));
			}
		}

		return list;
	}
}