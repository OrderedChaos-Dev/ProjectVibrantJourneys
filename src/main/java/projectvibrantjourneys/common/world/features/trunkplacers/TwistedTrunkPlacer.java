package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.ArrayList;
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
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class TwistedTrunkPlacer extends AbstractTrunkPlacer {
	
	public static final Codec<TwistedTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, TwistedTrunkPlacer::new);
	});

	public TwistedTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.ASPEN_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		setDirtAt(world, pos.below());
		List<FoliagePlacer.Foliage> list = Lists.newArrayList();
		BlockPos blockpos = new BlockPos(pos);
		ArrayList<Direction> facings = new ArrayList<Direction>();
		int branchStart = 5 + rand.nextInt(4);
		for(int i = 0; i < height; i++) {
			placeLog(world, rand, blockpos, blocks, box, config);
			blockpos = blockpos.above();
			if(i > branchStart && i % 2 == 0) {
				list.add(new FoliagePlacer.Foliage(blockpos, 0, false));
				int branchCount = rand.nextInt(3) + 1;
				
				for(int b = 0; b < branchCount; b++) {
					int length = 2 + rand.nextInt(6);
					if(height >= 10) {
						length -= (int)(0.3 * height - 1);
					}
					Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
					while(facings.contains(dir)) {
						dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
					}
					facings.add(dir);
					
					BlockPos branchPos = new BlockPos(blockpos);
					for(int e = 1; e <= length; e++) {
						if(e > 1) {
							if(rand.nextBoolean())
								branchPos = branchPos.offset(dir.getNormal());
							if(rand.nextBoolean())
								branchPos = branchPos.above();
						}
						
						if(TreeFeature.validTreePos(world, branchPos)) {
							placeLog(world, rand, branchPos, blocks, box, config);
							list.add(new FoliagePlacer.Foliage(branchPos, 0, false));
							
							if(rand.nextInt(3) == 0) {
								Direction temp = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
								BlockPos tempPos = branchPos.offset(temp.getNormal());
								if(TreeFeature.validTreePos(world, tempPos)) {
									placeLog(world, rand, tempPos, blocks, box, config);
									list.add(new FoliagePlacer.Foliage(tempPos, 0, false));
								}
							}
						}
					}
					facings.clear();
				}
			}
		}

		return list;
	}
}