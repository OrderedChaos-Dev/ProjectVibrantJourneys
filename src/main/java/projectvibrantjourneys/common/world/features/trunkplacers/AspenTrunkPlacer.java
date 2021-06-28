package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
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

public class AspenTrunkPlacer extends AbstractTrunkPlacer {
	
	public static final Codec<AspenTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, AspenTrunkPlacer::new);
	});

	public AspenTrunkPlacer(int baseHeight, int heightA, int heightB) {
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
		
		BlockPos.Mutable blockpos = pos.mutable();
		
		int trunkHeight = 6 + rand.nextInt(2);

		for(int i = 0; i < height; i++) {
			placeLog(world, rand, blockpos.above(i), blocks, box, config);
			if(i >= trunkHeight) {
				list.add(new FoliagePlacer.Foliage(blockpos.above(i), 0, false));
				
				if(i % 2 == 0 && i < height - 2) {
					for(Direction dir : Direction.values()) {
						if(dir.getAxis().isHorizontal()) {
							int length = 1 + (height / i);
							BlockPos.Mutable branchPos = blockpos.above(i).mutable();
							for(int j = 0; j < length; j++) {
								if (TreeFeature.validTreePos(world, branchPos.offset(dir.getNormal()))) {
									branchPos = branchPos.offset(dir.getNormal()).mutable();
									setBlock(world, branchPos, Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, dir.getAxis()), box);
									blocks.add(branchPos.immutable());
								}
								list.add(new FoliagePlacer.Foliage(branchPos, 0, false));
							}
							list.add(new FoliagePlacer.Foliage(branchPos.offset(dir.getNormal()), 0, false));
						}
					}
				}
			}
			
		}
		
		list.add(new FoliagePlacer.Foliage(blockpos.above(height), 0, false));

		return list;
	}
}