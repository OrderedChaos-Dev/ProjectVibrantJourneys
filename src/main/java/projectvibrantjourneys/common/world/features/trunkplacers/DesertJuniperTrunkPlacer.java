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
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class DesertJuniperTrunkPlacer extends AbstractTrunkPlacer {
	
	public static final Codec<DesertJuniperTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, DesertJuniperTrunkPlacer::new);
	});

	public DesertJuniperTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.JUNIPER_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		setDirtAt(world, pos.below());
		List<FoliagePlacer.Foliage> list = Lists.newArrayList();
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		
		BlockPos.Mutable blockpos = pos.mutable();

		for(int i = 0; i < height; i++) {
			placeLog(world, rand, blockpos, blocks, box, config);
			if(i > height / 2) {
				list.add(new FoliagePlacer.Foliage(blockpos.immutable(), 0, false));
			}
			
			if(rand.nextBoolean()) {
				blockpos = blockpos.setWithOffset(blockpos, direction);
				placeLog(world, rand, blockpos, blocks, box, config);
				if(i > height / 3) {
					list.add(new FoliagePlacer.Foliage(blockpos.immutable(), 0, false));
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