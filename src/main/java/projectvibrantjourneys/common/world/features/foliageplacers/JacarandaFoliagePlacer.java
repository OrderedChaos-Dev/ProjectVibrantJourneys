package projectvibrantjourneys.common.world.features.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Material;
import projectvibrantjourneys.init.world.PVJBlockPlacers;

public class JacarandaFoliagePlacer extends FoliagePlacer  {

	public static final Codec<JacarandaFoliagePlacer> CODEC = RecordCodecBuilder.create((p) -> {
		return foliagePlacerParts(p).apply(p, JacarandaFoliagePlacer::new);
	});
	
	public JacarandaFoliagePlacer(IntProvider f1, IntProvider f2) {
		super(f1, f2);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return PVJBlockPlacers.JACARANDA_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> placer,
			Random rand, TreeConfiguration config, int p_161350_, FoliagePlacer.FoliageAttachment foliage,
			int p_161352_, int p_161353_, int p_161354_) {
		BlockPos pos = foliage.pos();
		
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
											this.placeLeavesRow(world, placer, rand, config, leafPos, 0, 0, foliage.doubleTrunk());
									}
									else {
										this.placeLeavesRow(world, placer, rand, config, leafPos, 0, 0, foliage.doubleTrunk());
									}
								}
							}
						}
						else {
							this.placeLeavesRow(world, placer, rand, config, leafPos, 0, 0, foliage.doubleTrunk());
						}
						if(rand.nextInt(8) < 2) {
							BlockPos tempPos = leafPos.below();
							if(world.isStateAtPosition(tempPos, (state) -> state.getMaterial().isReplaceable())) {
								this.placeLeavesRow(world, placer, rand, config, tempPos, 0, 0, foliage.doubleTrunk());
							}
						}
					}
				}
			}
		}
	}

	@Override
	public int foliageHeight(Random rand, int h, TreeConfiguration config) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(Random rand, int x, int y, int z, int radius, boolean p_230373_6_) {
		return false;
	}

}
