package com.projectvibrantjourneys.common.world.features;

import java.sql.Types;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.common.world.features.configs.MultipleVegetationPatchConfiguration;
import com.projectvibrantjourneys.core.config.PVJConfig;
import com.projectvibrantjourneys.core.registry.world.PVJConfiguredFeatures;
import com.projectvibrantjourneys.core.registry.world.PVJPlacements;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;

public class MultipleWaterloggedVegetationPatchFeature extends Feature<MultipleVegetationPatchConfiguration> {
	
	public MultipleWaterloggedVegetationPatchFeature(Codec<MultipleVegetationPatchConfiguration> codec) {
		super(codec);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<MultipleVegetationPatchConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		MultipleVegetationPatchConfiguration config = context.config();
		RandomSource random = context.random();
		
		if(random.nextFloat() > config.placementChance)
			return false;
		
		BlockPos blockpos = context.origin();
		Predicate<BlockState> predicate = (p_204782_) -> {
			return p_204782_.is(config.replaceable);
		};
		int i = config.xzRadius.sample(random) + 1;
		int j = config.xzRadius.sample(random) + 1;
		Set<BlockPos> set = this.placeGroundPatch(worldgenlevel, config, random, blockpos, predicate, i, j);
		this.distributeVegetation(context, worldgenlevel, config, random, set, i, j);
		
		return !set.isEmpty();
	}

	protected Set<BlockPos> placeGroundPatch(WorldGenLevel level, MultipleVegetationPatchConfiguration config, RandomSource rand, BlockPos pos, Predicate<BlockState> replace, int x, int z) {
		Set<BlockPos> set = createGround(level, config, rand, pos, replace, x, z);
		Set<BlockPos> set1 = new HashSet<>();
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (BlockPos blockpos : set) {
			if (!isExposed(level, set, blockpos, blockpos$mutableblockpos)) {
				set1.add(blockpos);
			}
		}

		for (BlockPos blockpos1 : set1) {
			level.setBlock(blockpos1, Blocks.WATER.defaultBlockState(), 2);
		}

		return set1;
	}

	private static boolean isExposed(WorldGenLevel level, Set<BlockPos> set, BlockPos pos, BlockPos.MutableBlockPos posMutable) {
		return isExposedDirection(level, pos, posMutable, Direction.NORTH)
				|| isExposedDirection(level, pos, posMutable, Direction.EAST)
				|| isExposedDirection(level, pos, posMutable, Direction.SOUTH)
				|| isExposedDirection(level, pos, posMutable, Direction.WEST)
				|| isExposedDirection(level, pos, posMutable, Direction.DOWN);
	}

	private static boolean isExposedDirection(WorldGenLevel level, BlockPos pos, BlockPos.MutableBlockPos posMutable, Direction dir) {
		posMutable.setWithOffset(pos, dir);
		return !level.getBlockState(posMutable).isFaceSturdy(level, posMutable, dir.getOpposite());
	}

	protected Set<BlockPos> createGround(WorldGenLevel level, MultipleVegetationPatchConfiguration config, RandomSource rand, BlockPos pos, Predicate<BlockState> predicate, int x, int z) {
		Set<BlockPos> set = new HashSet<>();

		carve(set, level, config, rand, pos, predicate, x, z, true);
		carve(set, level, config, rand, pos.below(), predicate, x - 1, z - 1, false);
		
		return set;
	}
	
	private void carve(Set<BlockPos> set, WorldGenLevel level, MultipleVegetationPatchConfiguration config, RandomSource rand, BlockPos pos, Predicate<BlockState> predicate, int x, int z, boolean surface) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
		BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos$mutableblockpos.mutable();
		Direction direction = config.surface.getDirection();
		Direction direction1 = direction.getOpposite();
		
		for(int i = -x; i <= x; ++i) {
			boolean flag = i == -x || i == x;

			for(int j = -z; j <= z; ++j) {
				boolean flag1 = j == -z || j == z;
				boolean flag2 = flag || flag1;
				boolean flag3 = flag && flag1;
				boolean flag4 = flag2 && !flag3;
				if (!flag3 && (!flag4 || config.extraEdgeColumnChance != 0.0F && !(rand.nextFloat() > config.extraEdgeColumnChance))) {
					blockpos$mutableblockpos.setWithOffset(pos, i, 0, j);

					for(int k = 0; (surface ? level.isStateAtPosition(blockpos$mutableblockpos, BlockBehaviour.BlockStateBase::isAir) : true) && k < config.verticalRange; ++k) {
						blockpos$mutableblockpos.move(direction);
					}

					for(int i1 = 0; level.isStateAtPosition(blockpos$mutableblockpos, (p_204784_) -> {
						return !p_204784_.isAir();
					}) && i1 < config.verticalRange; ++i1) {
						blockpos$mutableblockpos.move(direction1);
					}

					blockpos$mutableblockpos1.setWithOffset(blockpos$mutableblockpos, config.surface.getDirection());
					BlockState blockstate = level.getBlockState(blockpos$mutableblockpos1);
					if (blockstate.isFaceSturdy(level, blockpos$mutableblockpos1, config.surface.getDirection().getOpposite())) {
						int l = config.depth.sample(rand) + (config.extraBottomBlockChance > 0.0F && rand.nextFloat() < config.extraBottomBlockChance ? 1 : 0);
						BlockPos blockpos = blockpos$mutableblockpos1.immutable();
						boolean flag5 = this.placeGround(level, config, predicate, rand, blockpos$mutableblockpos1, l);
						if (flag5) {
							set.add(blockpos);
						}
					}
				}
			}
		}
	}

	//TODO: move hardcoded vegetation to config for flexibility (may re-use this feature for other things who knows)
	protected void distributeVegetation(FeaturePlaceContext<MultipleVegetationPatchConfiguration> context, WorldGenLevel level, MultipleVegetationPatchConfiguration config, RandomSource rand, Set<BlockPos> set, int p_160619_, int p_160620_) {
		for(BlockPos blockpos : set) {
			if (config.vegetationChance > 0.0F && rand.nextFloat() < config.vegetationChance) {
				this.placeVegetation(level, config, context.chunkGenerator(), rand, blockpos);
				
				if(rand.nextInt(20) == 0) {
					for(int i = 0; i < 32; ++i) {
						BlockPos pos = blockpos;
						BlockState blockstate = Blocks.SEAGRASS.defaultBlockState();

						for(int j = 0; j < i / 16; ++j) {
							pos = pos.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
							if (level.getBlockState(pos.below()).isCollisionShapeFullBlock(level, pos.below())) {
								if (blockstate.canSurvive(level, pos)) {
									BlockState blockstate1 = level.getBlockState(pos);
									if (blockstate1.is(Blocks.WATER) && level.getFluidState(pos).getAmount() == 8) {
										level.setBlock(pos, blockstate, 3);
									} else if (blockstate1.is(Blocks.KELP) && rand.nextBoolean()) {
									      int l = Math.min(blockstate1.getValue(GrowingPlantHeadBlock.AGE) + 1, 25);
									      if(level.getBlockState(pos.above()).getFluidState().getType() == Fluids.WATER) {
									    	  level.setBlock(pos, blockstate1.setValue(GrowingPlantHeadBlock.AGE, Integer.valueOf(l)), 3);
									      }
									} else if (blockstate1.is(Blocks.SEAGRASS) && rand.nextInt(3) == 0) {
									      if(level.getBlockState(pos.above()).getFluidState().getType() == Fluids.WATER) {
									    	  level.setBlock(pos, Blocks.TALL_SEAGRASS.defaultBlockState(), 3);
									      }
									}
								}
							}
						}
					}
				}
				
				
				
			} else {
				if(level.getFluidState(blockpos).getType() == Fluids.WATER && level.getBlockState(blockpos).getBlock() == Blocks.WATER && rand.nextFloat() < 0.25F) {
					tryPlaceCoral(level, blockpos, rand);
				}
			}
		}
	}
	
	private void tryPlaceCoral(WorldGenLevel level, BlockPos pos, RandomSource rand) {

		if(level.getBlockState(pos.below()).isCollisionShapeFullBlock(level, pos.below())) {
			if(rand.nextBoolean()) {
				Registry.BLOCK.getTag(BlockTags.CORALS).flatMap((blocks) -> {
					return blocks.getRandomElement(rand);
				}).map(Holder::value).ifPresent((p_204720_) -> {
					level.setBlock(pos, p_204720_.defaultBlockState(), 2);
				});
			}
		} else {
			for(Direction direction : Direction.Plane.HORIZONTAL) {
				if(rand.nextBoolean()) {
					if(level.getBlockState(pos.relative(direction)).isCollisionShapeFullBlock(level, pos.relative(direction))) {
		                  Registry.BLOCK.getTag(BlockTags.WALL_CORALS).flatMap((blocks) -> {
		                      return blocks.getRandomElement(rand);
		                   }).map(Holder::value).ifPresent((block) -> {
		                      BlockState blockstate1 = block.defaultBlockState();
		                      if (blockstate1.hasProperty(BaseCoralWallFanBlock.FACING)) {
		                         blockstate1 = blockstate1.setValue(BaseCoralWallFanBlock.FACING, direction.getOpposite());
		                      }

		                      level.setBlock(pos, blockstate1, 2);
		                   });
					}
				}
			}
		}
	}

	protected boolean placeVegetation(WorldGenLevel level, MultipleVegetationPatchConfiguration config, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos) {
		boolean flag = false;
		
		for(Holder<PlacedFeature> feature : config.vegetationFeature) {
			if(feature.value().place(level, chunkGenerator, rand, pos.below().relative(config.surface.getDirection().getOpposite()))) {
				BlockState blockstate = level.getBlockState(pos);
				if (blockstate.hasProperty(BlockStateProperties.WATERLOGGED) && !blockstate.getValue(BlockStateProperties.WATERLOGGED)) {
					level.setBlock(pos, blockstate.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 2);
				}
				flag = true;
			}
		}
		
		return flag;
	}

	protected boolean placeGround(WorldGenLevel level, MultipleVegetationPatchConfiguration config, Predicate<BlockState> pred, RandomSource rand, BlockPos.MutableBlockPos pos, int iterations) {
		for(int i = 0; i < iterations; ++i) {
			BlockState blockstate = config.groundState.getState(rand, pos);
			BlockState blockstate1 = level.getBlockState(pos);
			if (!blockstate.is(blockstate1.getBlock())) {
				if (!pred.test(blockstate1)) {
					return i != 0;
				}

				level.setBlock(pos, blockstate, 2);
				pos.move(config.surface.getDirection());
			}
		}

		return true;
	}
}