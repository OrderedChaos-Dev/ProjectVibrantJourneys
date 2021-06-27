package projectvibrantjourneys.common.world.features.foliageplacers;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class DesertJuniperFoliagePlacer extends FoliagePlacer  {

	public static final Codec<DesertJuniperFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, DesertJuniperFoliagePlacer::new);
	});
	
	public DesertJuniperFoliagePlacer(FeatureSpread f1, FeatureSpread f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.JUNIPER_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(IWorldGenerationReader world, Random rand, BaseTreeFeatureConfig config, int p_230372_4_, Foliage foliage, int p_230372_6_, int p_230372_7_, Set<BlockPos> blocks, int p_230372_9_, MutableBoundingBox box) {
		BlockPos pos = foliage.foliagePos();
		this.placeLeavesRow(world, rand, config, pos, 1, blocks, 0, foliage.doubleTrunk(), box);
		this.placeLeavesRow(world, rand, config, pos.above(), 0, blocks, 0, foliage.doubleTrunk(), box);
	}

	@Override
	public int foliageHeight(Random rand, int h, BaseTreeFeatureConfig config) {
		return 1;
	}

	@Override
	protected boolean shouldSkipLocation(Random rand, int x, int y, int z, int radius, boolean p_230373_6_) {
		return rand.nextInt(4) == 0 && radius == 1;
	}

}
