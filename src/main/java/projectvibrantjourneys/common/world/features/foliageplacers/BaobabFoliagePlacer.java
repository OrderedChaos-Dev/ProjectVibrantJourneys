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

public class BaobabFoliagePlacer extends FoliagePlacer  {

	public static final Codec<BaobabFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, BaobabFoliagePlacer::new);
	});
	
	public BaobabFoliagePlacer(FeatureSpread f1, FeatureSpread f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.BAOBAB_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(IWorldGenerationReader world, Random rand, BaseTreeFeatureConfig config, int p_230372_4_, Foliage foliage, int p_230372_6_, int p_230372_7_, Set<BlockPos> blocks, int p_230372_9_, MutableBoundingBox box) {
		int radius = 1 + rand.nextInt(4);
		for(int i = 0; i <= 2; i++) {
			this.placeLeavesRow(world, rand, config, foliage.foliagePos(), radius + 1 - i, blocks, i, foliage.doubleTrunk(), box);
		}
	}

	@Override
	public int foliageHeight(Random rand, int h, BaseTreeFeatureConfig config) {
		return 3;
	}

	@Override
	protected boolean shouldSkipLocation(Random rand, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
		if (p_230373_3_ == 0) {
			return (p_230373_2_ > 1 || p_230373_4_ > 1) && p_230373_2_ != 0 && p_230373_4_ != 0;
		} else {
			return p_230373_2_ == p_230373_5_ && p_230373_4_ == p_230373_5_ && p_230373_5_ > 0;
		}
	}

}
