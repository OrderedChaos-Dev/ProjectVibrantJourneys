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

public class DesertJuniperTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<DesertJuniperTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, DesertJuniperTrunkPlacer::new);
	});

	public DesertJuniperTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJTreePlacers.Trunk.DESERT_JUNIPER_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		if(config.forceDirt)
			setDirtAt(world, placer, rand, pos.below(), config);
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		
		BlockPos.MutableBlockPos blockpos = pos.mutable();

		for(int i = 0; i < height; i++) {
			placeLog(world, placer, rand, blockpos, config);
			if(i > height / 2) {
				list.add(new FoliagePlacer.FoliageAttachment(blockpos.immutable(), 0, false));
			}
			
			if(rand.nextBoolean()) {
				blockpos = blockpos.setWithOffset(blockpos, direction);
				placeLog(world, placer, rand, blockpos, config);
				if(i > height / 3) {
					list.add(new FoliagePlacer.FoliageAttachment(blockpos.immutable(), 0, false));
				}
			}

			if(rand.nextBoolean()) {
				direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
			}
			
			blockpos = blockpos.move(Direction.UP);
		}

		return list;
	}
}