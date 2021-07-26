package projectvibrantjourneys.common.world.features.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class BaobabFoliagePlacer extends FoliagePlacer  {

	public static final Codec<BaobabFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, BaobabFoliagePlacer::new);
	});
	
	public BaobabFoliagePlacer(IntProvider f1, IntProvider f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.BAOBAB_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer,
			Random rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
			int p_161352_, int p_161353_, int p_161354_) {
		int radius = 3 + rand.nextInt(2);
		for(int i = 0; i <= 2; i++) {
			this.placeLeavesRow(world, placer, rand, config, foliage.pos(), radius + 1 - i, i, foliage.doubleTrunk());
		}
	}

	@Override
	public int foliageHeight(Random rand, int h, TreeConfiguration config) {
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
