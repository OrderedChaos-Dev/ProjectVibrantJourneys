package com.projectvibrantjourneys.world.gen.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.init.object.PVJBlocks;
import com.projectvibrantjourneys.init.world.features.PVJTreePlacers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class AspenTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<AspenTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, AspenTrunkPlacer::new);
	});

	public AspenTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJTreePlacers.Trunk.ASPEN_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		setDirtAt(world, placer, rand, pos.below(), config);
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		
		BlockPos.MutableBlockPos blockpos = pos.mutable();
		
		int trunkHeight = 6 + rand.nextInt(2);

		for(int i = 0; i < height; i++) {
			placeLog(world, placer, rand, blockpos.above(i), config);
			if(i >= trunkHeight) {
				list.add(new FoliagePlacer.FoliageAttachment(blockpos.above(i), 0, false));
				
				if(i % 2 == 0 && i < height - 2) {
					for(Direction dir : Direction.values()) {
						if(dir.getAxis().isHorizontal()) {
							int length = 1 + (height / i);
							BlockPos.MutableBlockPos branchPos = blockpos.above(i).mutable();
							for(int j = 0; j < length; j++) {
								if (TreeFeature.validTreePos(world, branchPos.offset(dir.getNormal()))) {
									branchPos = branchPos.offset(dir.getNormal()).mutable();
									placer.accept(branchPos, PVJBlocks.aspen_log.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, dir.getAxis()));
								}
								list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0, false));
							}
							list.add(new FoliagePlacer.FoliageAttachment(branchPos.offset(dir.getNormal()), 0, false));
						}
					}
				}
			}
			
		}
		
		list.add(new FoliagePlacer.FoliageAttachment(blockpos.above(height), 0, false));

		return list;
	}
}