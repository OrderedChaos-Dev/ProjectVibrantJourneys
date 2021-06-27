package projectvibrantjourneys.common.world.features.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableList;
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

public class PalmTrunkPlacer extends AbstractTrunkPlacer {
	public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create((x) -> {
		return trunkPlacerParts(x).apply(x, PalmTrunkPlacer::new);
	});

	public PalmTrunkPlacer(int baseHeight, int heightA, int heightB) {
		super(baseHeight, heightA, heightB);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return PVJBlockPlacers.PALM_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.Foliage> placeTrunk(IWorldGenerationReader world, Random rand, int height, BlockPos pos, Set<BlockPos> blocks, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		BlockPos.Mutable temp = pos.mutable();
		
		for(int i = 0; i < height; i++) {
			if(rand.nextFloat() < 0.35F) {
				x += dir.getStepX();
				z += dir.getStepZ();
			}
			placeLog(world, rand, temp.set(x, y + i, z), blocks, box, config);
		}
		
		return ImmutableList.of(new FoliagePlacer.Foliage(temp, 0, false));
	}
}
