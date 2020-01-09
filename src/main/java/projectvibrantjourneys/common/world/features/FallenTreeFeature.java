package projectvibrantjourneys.common.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import projectvibrantjourneys.common.blocks.BarkMushroomBlock;
import projectvibrantjourneys.init.PVJBlocks;

public class FallenTreeFeature extends Feature<BlockStateFeatureConfig> {
	
	public FallenTreeFeature(Function<Dynamic<?>, ? extends BlockStateFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
		Direction dir = Direction.Plane.HORIZONTAL.random(rand);
		int length = 4 + rand.nextInt(3);
		
		if(!world.getBlockState(pos.down()).isOpaqueCube(world, pos.down())) {
			return false;
		}
		
		boolean shouldPlace = true;
		
		while(shouldPlace) {
			//check space
			BlockPos checkPos = pos;
			boolean flag = false;
			for(int i = 0; i < length; i++) {
				checkPos = checkPos.offset(dir);
				
				while(world.isAirBlock(checkPos.down()) || world.getBlockState(checkPos.down()).getBlock() == Blocks.WATER) {
					checkPos = checkPos.down();
				}
				if(!canReplace(world.getBlockState(checkPos))) {
					if(rand.nextFloat() < 0.3F)
						return false;
					else
						flag = true;
				}
			}
			
			if(flag) {
				dir = Direction.Plane.HORIZONTAL.random(rand);
				continue;
			}
			
			shouldPlace = false;
			
			BlockState log = config.field_227270_a_;
			
			boolean isBranched = false;
			BlockPos logPos = pos;
			for(int i = 0; i < length; i++) {
				logPos = logPos.offset(dir);
				while(world.isAirBlock(logPos.down()) || world.getBlockState(logPos.down()).getBlock() == Blocks.WATER) {
					logPos = logPos.down();
				}
				placeAndDecorate(world, logPos, log.with(LogBlock.AXIS, dir.getAxis()), dir);
				if(!isBranched) {
					if(world.getRandom().nextBoolean()) {
						isBranched = true;
						Direction dir2 = world.getRandom().nextBoolean() ? dir.rotateYCCW() : dir.rotateY();
						BlockPos branchPos = logPos.offset(dir2);
						placeAndDecorate(world, branchPos, log.with(LogBlock.AXIS, dir2.getAxis()), dir2);
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	private boolean canReplace(BlockState state) {
		return state.getBlock() == Blocks.TALL_GRASS || state.getBlock() == Blocks.WATER || state.getBlock() == Blocks.AIR;
	}
	
	private void placeAndDecorate(IWorld world, BlockPos pos, BlockState state, Direction direction) {
		world.setBlockState(pos, state, 2);
		Direction dir2 = world.getRandom().nextBoolean() ? direction.rotateYCCW() : direction.rotateY();
		
		if(world.getRandom().nextFloat() < 0.4F) {
			BlockState barkShroom = PVJBlocks.bark_mushroom.getDefaultState().with(BarkMushroomBlock.FACING, dir2);
			if(world.isAirBlock(pos.offset(dir2)))
				world.setBlockState(pos.offset(dir2), barkShroom, 2);
		}
	}
}
