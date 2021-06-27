package projectvibrantjourneys.common.world.features.foliageplacers;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class PalmFoliagePlacer extends FoliagePlacer {
	
	public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, PalmFoliagePlacer::new);
	});

	public PalmFoliagePlacer(FeatureSpread p_i242003_1_, FeatureSpread p_i242003_2_) {
		super(p_i242003_1_, p_i242003_2_);
	}
	
	@Override
	protected void createFoliage(IWorldGenerationReader world, Random rand, BaseTreeFeatureConfig config, int p_230372_4_, FoliagePlacer.Foliage foliage, int p_230372_6_, int p_230372_7_, Set<BlockPos> blocks, int p_230372_9_, MutableBoundingBox box) {
		boolean flag = foliage.doubleTrunk();
		BlockPos logPos = foliage.foliagePos();
		BlockState leaf = config.leavesProvider.getState(rand, logPos);
				
		
		for (int xOffset = -2; xOffset <= 2; xOffset++) {
			for (int zOffset = -2; zOffset <= 2; zOffset++) {
				BlockPos leafpos = new BlockPos(logPos.getX() + xOffset, logPos.getY() + 1, logPos.getZ() + zOffset);
				if (!leafpos.equals(logPos)) {
					if (Math.abs(xOffset) == 2 || Math.abs(zOffset) == 2) {
						if (rand.nextInt(3) == 0 && (Math.abs(xOffset) != Math.abs(zOffset))) {
							world.setBlock(leafpos, leaf, 19);
							blocks.add(leafpos.immutable());
							if (rand.nextInt(7) == 0) {
								if(world.isStateAtPosition(leafpos.below(), (state) -> state.getMaterial().isReplaceable())) {
//									world.setBlockState(leafpos.below(), PVJBlocks.coconut.getDefaultState(), 19);
								}
							}
						}
					} else {
						world.setBlock(leafpos, leaf, 19);
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

			world.setBlock(leafpos, leaf, 19);
			world.setBlock(leafpos.below(), leaf, 19);
			blocks.add(leafpos.immutable());
			blocks.add(leafpos.below().immutable());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).east(2 + i);
			world.setBlock(leafpos, leaf, 19);
			world.setBlock(leafpos.below(), leaf, 19);
			blocks.add(leafpos.immutable());
			blocks.add(leafpos.below().immutable());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).north(2 + i);
			world.setBlock(leafpos, leaf, 19);
			world.setBlock(leafpos.below(), leaf, 19);
			blocks.add(leafpos.immutable());
			blocks.add(leafpos.below().immutable());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			BlockPos leafpos = new BlockPos(logPos.getX(), logPos.getY() + 1 - i, logPos.getZ()).south(2 + i);
			world.setBlock(leafpos, leaf, 19);
			world.setBlock(leafpos.below(), leaf, 19);
			blocks.add(leafpos.immutable());
			blocks.add(leafpos.below().immutable());
		}
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.PALM_FOLIAGE_PLACER;
	}

	@Override
	public int foliageHeight(Random p_230374_1_, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
		return 3;
	}

	@Override
	protected boolean shouldSkipLocation(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
		return false;
	}
}
