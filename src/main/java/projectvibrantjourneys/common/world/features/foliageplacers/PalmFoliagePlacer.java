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

public class PalmFoliagePlacer extends FoliagePlacer {
	
	public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, PalmFoliagePlacer::new);
	});

	public PalmFoliagePlacer(IntProvider p_i242003_1_, IntProvider p_i242003_2_) {
		super(p_i242003_1_, p_i242003_2_);
	}
	
	@Override
	protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer,
			Random rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
			int p_161352_, int p_161353_, int p_161354_) {
		boolean flag = foliage.doubleTrunk();
		BlockPos logPos = foliage.pos();
		BlockState leaf = config.foliageProvider.getState(rand, logPos);
				
		
		for (int xOffset = -2; xOffset <= 2; xOffset++) {
			for (int zOffset = -2; zOffset <= 2; zOffset++) {
				BlockPos leafpos = new BlockPos(logPos.getX() + xOffset, logPos.getY() + 1, logPos.getZ() + zOffset);
				if (!leafpos.equals(logPos)) {
					if (Math.abs(xOffset) == 2 || Math.abs(zOffset) == 2) {
						if (rand.nextInt(3) == 0 && (Math.abs(xOffset) != Math.abs(zOffset))) {
							placer.accept(leafpos, leaf);
							if (rand.nextInt(7) == 0) {
								if(world.isStateAtPosition(leafpos.below(), (state) -> state.getMaterial().isReplaceable())) {
//									world.setBlockState(leafpos.below(), PVJBlocks.coconut.getDefaultState(), 19);
								}
							}
						}
					} else {
						placer.accept(leafpos, leaf);
						if (rand.nextInt(7) == 0) {
							if(world.isStateAtPosition(leafpos.below(), (state) -> state.getMaterial().isReplaceable())) {
//								world.setBlockState(leafpos.below(), PVJBlocks.coconut.getDefaultState(), 19);
							}
						}

					}
				}
			}
         }
         
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).west(2 + i);
			placer.accept(leafpos, leaf);
			placer.accept(leafpos.below(), leaf);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).east(2 + i);
			placer.accept(leafpos, leaf);
			placer.accept(leafpos.below(), leaf);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).north(2 + i);
			placer.accept(leafpos, leaf);
			placer.accept(leafpos.below(), leaf);
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).south(2 + i);
			placer.accept(leafpos, leaf);
			placer.accept(leafpos.below(), leaf);
		}
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.PALM_FOLIAGE_PLACER;
	}

	@Override
	public int foliageHeight(Random p_230374_1_, int p_230374_2_, TreeConfiguration config) {
		return 3;
	}

	@Override
	protected boolean shouldSkipLocation(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
		return false;
	}
}
