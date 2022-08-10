package com.projectvibrantjourneys.world.gen.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
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

public class PalmTrunkPlacer extends TrunkPlacer {
	public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, PalmTrunkPlacer::new);
	});

	public PalmTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJTreePlacers.Trunk.PALM_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		BlockPos.MutableBlockPos blockposmutable = pos.mutable();
		
		for(int i = 0; i < height; i++) {
			if(rand.nextFloat() < 0.35F) {
				x += dir.getStepX();
				z += dir.getStepZ();
			}
			placeLog(world, placer, rand, blockposmutable.set(x, y + i, z), config);
		}
		
		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(blockposmutable, 0, false));
	}
}