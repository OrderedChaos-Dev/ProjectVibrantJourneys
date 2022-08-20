package com.projectvibrantjourneys.common.world.features;

import java.util.HashSet;
import java.util.Random;

import com.mojang.serialization.Codec;
import com.projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import com.projectvibrantjourneys.common.blocks.FallenLeavesBlock;
import com.projectvibrantjourneys.common.blocks.GroundcoverBlock;
import com.projectvibrantjourneys.common.world.features.configs.FallenTreeConfiguration;
import com.projectvibrantjourneys.core.registry.PVJBlocks;
import com.projectvibrantjourneys.util.TreeFeatureUtils;
import com.projectvibrantjourneys.util.TreeFeatureUtils.WeightedBiomeEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

public class FallenTreeFeature extends Feature<FallenTreeConfiguration> {
	
	public FallenTreeFeature(Codec<FallenTreeConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<FallenTreeConfiguration> context) {
		WorldGenLevel world = context.level();
		BlockPos pos = context.origin();
		Random rand = context.random();	
		BlockState hollowLog = context.config().hollowLog();
		BlockState baseLog = context.config().baseLog();
		ResourceLocation biome = world.getBiome(pos).value().getRegistryName();

		int weight = TreeFeatureUtils.getWeight(biome, new HashSet<WeightedBiomeEntry>(context.config().data()));
		if(rand.nextFloat() > weight / 100.0F)
			return false;
		
		BlockState below = world.getBlockState(pos.below());
		if(below.is(BlockTags.ICE) || below.getBlock() == Blocks.SNOW_BLOCK || below.getFluidState().isSource())
			return false;
		
		int length = rand.nextInt(3) + 4;
		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
		Direction dirCounterClockwise = dir.getCounterClockWise();
		Direction dirClockwise = dir.getClockWise();
		boolean branched = false;
		
		for(int i = 0; i < length; i++) {
			if(!canReplace(world, pos)) {
				return false;
			}
			pos = pos.offset(dir.getNormal());
		}
		
		pos = context.origin();
		
		for(int i = 0; i < length; i++) {
			if(canReplace(world, pos)) {
				if(!(below.getMaterial().isReplaceable() || below.getFluidState().is(Fluids.WATER)) || i > (length / 2)) {
					world.setBlock(pos, hollowLog.setValue(RotatedPillarBlock.AXIS, dir.getAxis()), 2);
					
					if(world.isEmptyBlock(pos.above()) && rand.nextFloat() < 0.4F) {
						world.setBlock(pos.above(), Blocks.MOSS_CARPET.defaultBlockState(), 2);
					}
					
					if(!branched && i <= (length / 2) + 1 && rand.nextFloat() < 0.2F) {
						BlockPos branchPos = rand.nextBoolean() ? pos.offset(dirCounterClockwise.getNormal()) : pos.offset(dirClockwise.getNormal());;
						world.setBlock(branchPos, baseLog.setValue(RotatedPillarBlock.AXIS, dirCounterClockwise.getAxis()), 2);
						if(world.isEmptyBlock(branchPos.above()) && rand.nextFloat() < 0.4F) {
							world.setBlock(branchPos.above(), Blocks.MOSS_CARPET.defaultBlockState(), 2);
						}
						branched = true;
					}
					
					BlockPos original = pos;
					
					pos = pos.offset(dirCounterClockwise.getNormal());
					if(canReplace(world, pos)) {
						if(rand.nextFloat() < 0.4F && Block.isFaceFull(world.getBlockState(pos.below()).getCollisionShape(world, pos.below()), Direction.UP)) {
							world.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState(), 2);
						} else if(rand.nextFloat() < 0.4F) {
							BarkMushroomBlock mushroom = BarkMushroomBlock.getRandom(rand);
							world.setBlock(pos, mushroom.defaultBlockState().setValue(BarkMushroomBlock.FACING, dirCounterClockwise), 2);
						}
					}
					
					pos = original;
					pos = pos.offset(dirClockwise.getNormal());
					if(canReplace(world, pos)) {
						if(rand.nextFloat() < 0.4F && Block.isFaceFull(world.getBlockState(pos.below()).getCollisionShape(world, pos.below()), Direction.UP)) {
							world.setBlock(pos, Blocks.MOSS_CARPET.defaultBlockState(), 2);
						} else if(rand.nextFloat() < 0.4F) {
							BarkMushroomBlock mushroom = BarkMushroomBlock.getRandom(rand);
							world.setBlock(pos, mushroom.defaultBlockState().setValue(BarkMushroomBlock.FACING, dirClockwise), 2);
						}
					}
					
					pos = original;
					pos = pos.offset(dir.getNormal());
				} else {
					dir = dir.getOpposite();
					pos = context.origin().offset(dir.getNormal());
				}
				below = world.getBlockState(pos.below());
			} else {
				return length - i < length;
			}
		}
		
		return true;
	}
	
	public boolean canReplace(WorldGenLevel world, BlockPos pos) {
		return world.getBlockState(pos).getMaterial().isReplaceable() || world.isEmptyBlock(pos) || world.getBlockState(pos).getBlock() instanceof FallenLeavesBlock || world.getBlockState(pos).getBlock() instanceof GroundcoverBlock;
	}
}