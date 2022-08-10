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

public class BaobabTrunkPlacer extends TrunkPlacer {
	
	public static final Codec<BaobabTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, BaobabTrunkPlacer::new);
	});

	public BaobabTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJTreePlacers.Trunk.BAOBAB_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
		
		BlockPos blockpos = pos.below();
		setDirtAt(world, placer, rand, blockpos, config);
		setDirtAt(world, placer, rand, blockpos.east(), config);
		setDirtAt(world, placer, rand, blockpos.south(), config);
		setDirtAt(world, placer, rand, blockpos.north(), config);
		
		for (int i = 0; i < height; ++i) {
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 0, i, 0);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 1, i, 0);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 1, i, 1);
			placeLog(world, placer, rand, blockpos$mutable, config, pos, 0, i, 1);
		}
		
		BlockPos branchStart = pos.above(height - 2);
		genBranches(world, placer, Direction.NORTH, Direction.WEST, rand, branchStart, config, list);
		genBranches(world, placer, Direction.SOUTH, Direction.WEST, rand, branchStart.south(), config, list);
		genBranches(world, placer, Direction.NORTH, Direction.EAST, rand, branchStart.east(), config, list);
		genBranches(world, placer, Direction.SOUTH, Direction.EAST, rand, branchStart.south().east(), config, list);
		
		BlockPos innerLayerPos = pos.south(2).west();
		for (int x = 0; x < 4; x++) {
			for (int z = 0; z < 4; z++) {
				int h = 4 + rand.nextInt(3);
				BlockPos tempPos = innerLayerPos.north(x).east(z).above(h);
				for (int i = 0; i < 10; i++) {
					BlockPos p = tempPos.below(i);
					if (canPlaceRoot(world, p))
						placeLog(world, placer, rand, p, config);
					else
						break;
				}
			}
		}
		
		placeRoot(world, placer, rand, pos.west(2), config);
		placeRoot(world, placer, rand, pos.west(2).south(), config);
		placeRoot(world, placer, rand, pos.north(2), config);
		placeRoot(world, placer, rand, pos.north(2).east(), config);
		placeRoot(world, placer, rand, pos.east(3), config);
		placeRoot(world, placer, rand, pos.east(3).south(), config);
		placeRoot(world, placer, rand, pos.south(3), config);
		placeRoot(world, placer, rand, pos.south(3).east(), config);
		
		
		return list;
	}
	
	private void placeLog(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos start, int offX, int offY, int offZ) {
		pos.setWithOffset(start, offX, offY, offZ);
		//place log
		placeLog(world, placer, rand, pos, config);
	}

	public void genBranches(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Direction d1, Direction d2, Random rand, BlockPos branchStart, TreeConfiguration config, List<FoliagePlacer.FoliageAttachment> list) {
		BlockPos temp = branchStart;
		for(int length = 0; length <= 3 + rand.nextInt(4); length++) {
			temp = temp.offset(d1.getNormal());
			if(rand.nextBoolean()) {
				placeLog(world, placer, rand, temp, config);
				temp = temp.offset(d2.getNormal());
			}
			
			if(rand.nextFloat() > 0.33)
				temp = temp.above();
			
			placeLog(world, placer, rand, temp, config);
			if(rand.nextBoolean())
				placeLog(world, placer, rand, temp.below(), config);
		}
		temp = temp.above();
		placeLog(world, placer, rand, temp.west(), config);
		placeLog(world, placer, rand, temp.east(), config);
		placeLog(world, placer, rand, temp.north(), config);
		placeLog(world, placer, rand, temp.south(), config);
		temp = temp.above();
		placeLog(world, placer, rand, temp.west(2), config);
		placeLog(world, placer, rand, temp.east(2), config);
		placeLog(world, placer, rand, temp.north(2), config);
		placeLog(world, placer, rand, temp.south(2), config);
		list.add(new FoliagePlacer.FoliageAttachment(temp, 0, true));
	}
	
	private void placeRoot(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, BlockPos pos,TreeConfiguration config) {
		int h = 2 + rand.nextInt(3);
		BlockPos tempPos = pos.above(h);
		for (int i = 0; i < 10; i++) {
			BlockPos p = tempPos.below(i);
			if (canPlaceRoot(world, p))
				placeLog(world, placer, rand, p, config);
			else
				break;
		}
	}
	
	private boolean canPlaceRoot(LevelSimulatedReader world, BlockPos pos) {
		return !world.isStateAtPosition(pos, (s) -> s.getMaterial().isSolid());
	}
}
