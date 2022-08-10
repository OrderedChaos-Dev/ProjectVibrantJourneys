package com.projectvibrantjourneys.world.gen.features.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.projectvibrantjourneys.init.world.features.PVJTreePlacers;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class DesertJuniperFoliagePlacer extends FoliagePlacer  {

	public static final Codec<DesertJuniperFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, DesertJuniperFoliagePlacer::new);
	});
	
	public DesertJuniperFoliagePlacer(IntProvider f1, IntProvider f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJTreePlacers.Foliage.DESERT_JUNIPER_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer,
			Random rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
			int p_161352_, int p_161353_, int p_161354_) {
		BlockPos pos = foliage.pos();
		this.placeLeavesRow(world, placer, rand, config, pos, 1, 0, foliage.doubleTrunk());
		this.placeLeavesRow(world, placer, rand, config, pos.above(), 0, 0, foliage.doubleTrunk());
	}

	@Override
	public int foliageHeight(Random rand, int h, TreeConfiguration config) {
		return 1;
	}

	@Override
	protected boolean shouldSkipLocation(Random rand, int x, int y, int z, int radius, boolean p_230373_6_) {
		return rand.nextInt(4) == 0 && radius == 1;
	}

}
