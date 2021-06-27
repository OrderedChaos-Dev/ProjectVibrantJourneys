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
import net.minecraft.world.gen.foliageplacer.FoliagePlacer.Foliage;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class BaobabTrunkPlacer extends AbstractTrunkPlacer {
	
	public static final Codec<BaobabTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, BaobabTrunkPlacer::new);
	});

	public BaobabTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.BAOBAB_TRUNK_PLACER;
	}

	@Override
	public List<Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		List<FoliagePlacer.Foliage> list = Lists.newArrayList();
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		for (int i = 0; i < height; ++i) {
			placeLog(world, rand, blockpos$mutable, blocks, box, config, pos, 0, i, 0);
			placeLog(world, rand, blockpos$mutable, blocks, box, config, pos, 1, i, 0);
			placeLog(world, rand, blockpos$mutable, blocks, box, config, pos, 1, i, 1);
			placeLog(world, rand, blockpos$mutable, blocks, box, config, pos, 0, i, 1);
		}
		
		BlockPos branchStart = pos.above(height - 2);
		genBranches(world, Direction.NORTH, Direction.WEST, rand, branchStart, blocks, box, config, list);
		genBranches(world, Direction.SOUTH, Direction.WEST, rand, branchStart.south(), blocks, box, config, list);
		genBranches(world, Direction.NORTH, Direction.EAST, rand, branchStart.east(), blocks, box, config, list);
		genBranches(world, Direction.SOUTH, Direction.EAST, rand, branchStart.south().east(), blocks, box, config, list);
		
		BlockPos innerLayerPos = pos.south(2).west();
		for (int x = 0; x < 4; x++) {
			for (int z = 0; z < 4; z++) {
				int h = 4 + rand.nextInt(3);
				BlockPos tempPos = innerLayerPos.north(x).east(z).above(h);
				for (int i = 0; i < 10; i++) {
					BlockPos p = tempPos.below(i);
					if (canPlaceRoot(world, p))
						placeLog(world, rand, p, blocks, box, config);
					else
						break;
				}
			}
		}
		
		placeRoot(world, rand, pos.west(2), blocks, box, config);
		placeRoot(world, rand, pos.west(2).south(), blocks, box, config);
		placeRoot(world, rand, pos.north(2), blocks, box, config);
		placeRoot(world, rand, pos.north(2).east(), blocks, box, config);
		placeRoot(world, rand, pos.east(3), blocks, box, config);
		placeRoot(world, rand, pos.east(3).south(), blocks, box, config);
		placeRoot(world, rand, pos.south(3), blocks, box, config);
		placeRoot(world, rand, pos.south(3).east(), blocks, box, config);
		
		
		return list;
	}
	
	private void placeLog(IWorldGenerationReader world, Random rand, BlockPos.Mutable pos, Set<BlockPos> blocks, MutableBoundingBox boundingBox, BaseTreeFeatureConfig config, BlockPos start, int offX, int offY, int offZ) {
		pos.setWithOffset(start, offX, offY, offZ);
		//place log
		placeLog(world, rand, pos, blocks, boundingBox, config);
	}

	public void genBranches(IWorldGenerationReader world, Direction d1, Direction d2, Random rand, BlockPos branchStart, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config, List<FoliagePlacer.Foliage> list) {
		BlockPos temp = branchStart;
		for(int length = 0; length <= 3 + rand.nextInt(4); length++) {
			temp = temp.offset(d1.getNormal());
			if(rand.nextBoolean()) {
				placeLog(world, rand, temp, blocks, box, config);
				temp = temp.offset(d2.getNormal());
			}
			
			if(rand.nextFloat() > 0.33)
				temp = temp.above();
			
			placeLog(world, rand, temp, blocks, box, config);
			if(rand.nextBoolean())
				placeLog(world, rand, temp.below(), blocks, box, config);
		}
		list.add(new FoliagePlacer.Foliage(temp, 0, true));
	}
	
	private void placeRoot(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int h = 2 + rand.nextInt(3);
		BlockPos tempPos = pos.above(h);
		for (int i = 0; i < 10; i++) {
			BlockPos p = tempPos.below(i);
			if (canPlaceRoot(world, p))
				placeLog(world, rand, p, logs, box, config);
			else
				break;
		}
	}
	
	private boolean canPlaceRoot(IWorldGenerationReader world, BlockPos pos) {
		return !world.isStateAtPosition(pos, (s) -> s.getMaterial().isSolid());
	}
}
