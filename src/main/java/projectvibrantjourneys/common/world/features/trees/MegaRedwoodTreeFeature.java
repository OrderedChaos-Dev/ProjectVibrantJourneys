package projectvibrantjourneys.common.world.features.trees;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.HugeTreesFeature;
import projectvibrantjourneys.init.PVJBlocks;

public class MegaRedwoodTreeFeature extends HugeTreesFeature<HugeTreeFeatureConfig> {
	public MegaRedwoodTreeFeature(Function<Dynamic<?>, ? extends HugeTreeFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs,
			Set<BlockPos> leaves, MutableBoundingBox box, HugeTreeFeatureConfig config) {
		int height = this.func_227256_a_(rand, config);
		if (!this.hasRoom(world, pos, height, config)) {
			return false;
		} else {
			boolean isSequoia = rand.nextBoolean();
			this.genCrown(world, rand, pos.getX(), pos.getZ(), pos.getY() + height, 0, leaves, box, config);
			if(!isSequoia) {
				this.genLeafCircle(world, rand, pos.up(height), 2, leaves, box, config);
				for (int j = pos.getY() + height - 2 - rand.nextInt(4); j > pos.getY() + height / 2; j -= 2 + rand.nextInt(4)) {
					float f = rand.nextFloat() * ((float) Math.PI * 2F);
					int k = pos.getX() + (int) (0.5F + MathHelper.cos(f) * 4.0F);
					int l = pos.getZ() + (int) (0.5F + MathHelper.sin(f) * 4.0F);

					for (int i1 = 0; i1 < 4; ++i1) {
						k = pos.getX() + (int) (1.5F + MathHelper.cos(f) * (float) i1);
						l = pos.getZ() + (int) (1.5F + MathHelper.sin(f) * (float) i1);
						BlockPos blockpos = new BlockPos(k, j - 3 + i1 / 2, l);
						this.setLog(world, rand, blockpos, logs, box, config);
					}

					int l1 = 1 + rand.nextInt(4);
					int i2 = j - 1;

					for (int j1 = j - l1; j1 <= i2; ++j1) {
						int k1 = Math.min(-((j1 - i2) - 3), 4);
						this.func_227257_b_(world, rand, new BlockPos(k, j1, l), k1, leaves, box, config);
					}
				}
			}

			this.func_227254_a_(world, rand, pos, height, logs, box, config);
			BlockPos innerLayerPos = pos.south(2).west();
			for (int x = 0; x < 4; x++) {
				for (int z = 0; z < 4; z++) {
					int h = 4 + rand.nextInt(3);
					BlockPos tempPos = innerLayerPos.north(x).east(z).up(h);
					if (isAirOrLeaves(world, tempPos.up()) || isTallPlants(world, pos.up()) || isWater(world, tempPos.up())) {
						this.setBlockState(world, tempPos.up(), PVJBlocks.redwood_wood.getDefaultState(), box);
						logs.add(pos.toImmutable());
					}
					for (int i = 0; i < 10; i++) {
						BlockPos p = tempPos.down(i);
						if (canPlaceRoot(world, p))
							this.setLog(world, rand, p, logs, box, config);
						else
							break;
					}
				}
			}
			placeRoot(world, rand, pos.west(2), logs, box, config);
			placeRoot(world, rand, pos.west(2).south(), logs, box, config);
			placeRoot(world, rand, pos.north(2), logs, box, config);
			placeRoot(world, rand, pos.north(2).east(), logs, box, config);
			placeRoot(world, rand, pos.east(3), logs, box, config);
			placeRoot(world, rand, pos.east(3).south(), logs, box, config);
			placeRoot(world, rand, pos.south(3), logs, box, config);
			placeRoot(world, rand, pos.south(3).east(), logs, box, config);
			return true;
		}
	}

	private void genLeafCircle(IWorldGenerationReader world, Random rand, BlockPos pos, int radius, Set<BlockPos> leaves, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int r = Math.min(radius, 3);
		for (int j = -2; j <= 0; ++j) {
			this.func_227255_a_(world, rand, pos.up(j), r + 1 - j, leaves, box, config);
		}
	}

	private void genCrown(IWorldGenerationReader world, Random rand, int posX, int posZ, int posY, int height,
			Set<BlockPos> leaves, MutableBoundingBox box, HugeTreeFeatureConfig config) {
		int i = rand.nextInt(5) + config.crownHeight;
		int j = 0;

		for (int k = posY - i; k <= posY; ++k) {
			int l = posY - k;
			int i1 = height + MathHelper.floor((float) l / (float) i * 3.5F);
			this.func_227255_a_(world, rand, new BlockPos(posX, k, posZ),
					i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0), leaves, box, config);
			j = i1;
		}
	}

	private boolean canPlaceRoot(IWorldGenerationReader world, BlockPos pos) {
		return !world.hasBlockState(pos, (s) -> s.isSolid());
	}
	
	private void placeRoot(IWorldGenerationReader world, Random rand, BlockPos pos, Set<BlockPos> logs, MutableBoundingBox box, BaseTreeFeatureConfig config) {
		int h = 2 + rand.nextInt(3);
		BlockPos tempPos = pos.up(h);
		if (isAirOrLeaves(world, tempPos.up()) || isTallPlants(world, pos.up()) || isWater(world, tempPos.up())) {
			this.setBlockState(world, tempPos.up(), PVJBlocks.redwood_wood.getDefaultState(), box);
			logs.add(pos.toImmutable());
		}
		for (int i = 0; i < 10; i++) {
			BlockPos p = tempPos.down(i);
			if (canPlaceRoot(world, p))
				this.setLog(world, rand, p, logs, box, config);
			else
				break;
		}
	}
}