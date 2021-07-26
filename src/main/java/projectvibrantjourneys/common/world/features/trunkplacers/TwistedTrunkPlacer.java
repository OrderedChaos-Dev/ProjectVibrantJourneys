package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class TwistedTrunkPlacer extends TrunkPlacer {
	
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
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer, Random rand, int height, BlockPos pos, TreeConfiguration config) {
		setDirtAt(world, placer, rand, pos.below(), config);
		List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		BlockPos blockpos = new BlockPos(pos);
		ArrayList<Direction> facings = new ArrayList<Direction>();
		int branchStart = 5 + rand.nextInt(4);
		for(int i = 0; i < height; i++) {
			placeLog(world, placer, rand, blockpos, config);
			blockpos = blockpos.above();
			if(i > branchStart && i % 2 == 0) {
				list.add(new FoliagePlacer.FoliageAttachment(blockpos, 0, false));
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
							placeLog(world, placer, rand, branchPos, config);
							list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0, false));
							
							if(rand.nextInt(3) == 0) {
								Direction temp = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
								BlockPos tempPos = branchPos.offset(temp.getNormal());
								if(TreeFeature.validTreePos(world, tempPos)) {
									placeLog(world, placer, rand, tempPos, config);
									list.add(new FoliagePlacer.FoliageAttachment(tempPos, 0, false));
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