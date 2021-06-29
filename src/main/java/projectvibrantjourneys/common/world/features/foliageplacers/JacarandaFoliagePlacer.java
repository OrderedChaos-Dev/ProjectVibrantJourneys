package projectvibrantjourneys.common.world.features.foliageplacers;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class JacarandaFoliagePlacer extends FoliagePlacer  {

	public static final Codec<JacarandaFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, JacarandaFoliagePlacer::new);
	});
	
	public JacarandaFoliagePlacer(FeatureSpread f1, FeatureSpread f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.JACARANDA_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(IWorldGenerationReader world, Random rand, BaseTreeFeatureConfig config, int p_230372_4_, Foliage foliage, int p_230372_6_, int p_230372_7_, Set<BlockPos> blocks, int p_230372_9_, MutableBoundingBox box) {
		BlockPos pos = foliage.foliagePos();
		
		for(int x = -2; x <= 2; x++) {
			for(int y = -1; y <= 2; y++) {
				for(int z = -2; z <= 2; z++) {
					BlockPos leafPos = pos.offset(x, y, z);
					if(world.isStateAtPosition(leafPos, (state) -> state.getMaterial().isReplaceable())) {
						if(Math.abs(x) == 2 || Math.abs(y) == 2 || Math.abs(z) == 2) {
							if(rand.nextInt(16) <= 5) {
								boolean shouldGenLeaves = false;
								for(Direction facing : Direction.values()) {
									if(world.isStateAtPosition(leafPos.offset(facing.getNormal()), (state) -> state.getMaterial() == Material.LEAVES)) {
										shouldGenLeaves = true;
										break;
									}
								}
								
								if(shouldGenLeaves) {
									if(Math.abs(x) == Math.abs(z)) {
										if(rand.nextInt(4) == 0)
											this.placeLeavesRow(world, rand, config, leafPos, 0, blocks, 0, foliage.doubleTrunk(), box);
									}
									else {
										this.placeLeavesRow(world, rand, config, leafPos, 0, blocks, 0, foliage.doubleTrunk(), box);
									}
								}
							}
						}
						else {
							this.placeLeavesRow(world, rand, config, leafPos, 0, blocks, 0, foliage.doubleTrunk(), box);
						}
						if(rand.nextInt(8) < 2) {
							BlockPos tempPos = leafPos.below();
							if(world.isStateAtPosition(tempPos, (state) -> state.getMaterial().isReplaceable())) {
								this.placeLeavesRow(world, rand, config, tempPos, 0, blocks, 0, foliage.doubleTrunk(), box);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public int foliageHeight(Random rand, int h, BaseTreeFeatureConfig config) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(Random rand, int x, int y, int z, int radius, boolean p_230373_6_) {
		return false;
	}

}
