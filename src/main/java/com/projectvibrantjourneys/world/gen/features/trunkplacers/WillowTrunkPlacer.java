package com.projectvibrantjourneys.world.gen.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.init.world.features.PVJTreePlacers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

/**
 * 
 * based off of acacia tree
 *
 */
public class WillowTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<WillowTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, WillowTrunkPlacer::new);
	});

	public WillowTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJTreePlacers.Trunk.WILLOW_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		if(config.forceDirt)
			setDirtAt(world, placer, rand, pos.below(), config);
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		int i = height - rand.nextInt(4) - 2;
		int j = 3 - rand.nextInt(3);
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
		int k = pos.getX();
		int l = pos.getZ();
		int i1 = 0;
		
		placeLog(world, placer, rand, blockpos$mutable.set(k + 1, pos.getY(), l), config);
		placeLog(world, placer, rand, blockpos$mutable.set(k - 1, pos.getY(), l), config);
		placeLog(world, placer, rand, blockpos$mutable.set(k, pos.getY(), l + 1), config);
		placeLog(world, placer, rand, blockpos$mutable.set(k, pos.getY(), l - 1), config);

		for (int j1 = 0; j1 < height; ++j1) {
			int k1 = pos.getY() + j1;
			if (j1 >= i && j > 0) {
				k += direction.getStepX();
				l += direction.getStepZ();
				--j;
			}

			if (placeLog(world, placer, rand, blockpos$mutable.set(k, k1, l), config)) {
				i1 = k1 + 1;
			}
		}

		list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(k, i1, l), 1, false));
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
					if (placeLog(world, placer, rand, blockpos$mutable.set(k, j2, l), config)) {
						i1 = j2 + 1;
					}
				}

				++i2;
			}

			if (i1 > 1) {
				list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(k, i1, l), 0, false));
			}
		}

		return list;
	}
}