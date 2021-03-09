package projectvibrantjourneys.common.world.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class FallenTreeFeature extends Feature<BlockStateFeatureConfig> {

	public FallenTreeFeature(Codec<BlockStateFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
		BlockState b = world.getBlockState(pos.down());
		if(b.getMaterial() == Material.ICE || b.getMaterial() == Material.ICE || b.getBlock() == Blocks.SNOW_BLOCK) return false;
		boolean branching = rand.nextBoolean();
		BlockPos temp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		List<BlockPos> positions = new ArrayList<BlockPos>();
		int length = rand.nextInt(3) + 4;
		Direction dir = Direction.Plane.HORIZONTAL.random(rand);
		BlockState state = config.state.with(RotatedPillarBlock.AXIS, dir.getAxis());
		while(length > 0) {
			if(world.getBlockState(pos).getMaterial().isReplaceable()) {
				positions.add(pos);
				length--;
				pos = pos.offset(dir);
				
				if(world.getBlockState(pos.down()).getMaterial().isReplaceable() || world.getBlockState(pos.down()).getBlock() == Blocks.WATER) {
					temp = temp.offset(dir.getOpposite());
					if(world.getBlockState(temp).getMaterial().isReplaceable()) {
						positions.add(temp);
						length--;
					} else {
						return false;
					}
				}
				
			} else {
				return false;
			}
		}
		
		for(BlockPos p : positions) {
			world.setBlockState(p, state, 2);
			if(branching && rand.nextBoolean()) {
				Direction d = rand.nextBoolean() ? dir.rotateY() : dir.rotateYCCW();
				BlockPos branchPos = p.offset(d);
				if(world.getBlockState(branchPos).getMaterial().isReplaceable() || world.isAirBlock(branchPos))
					world.setBlockState(branchPos, config.state.with(RotatedPillarBlock.AXIS, d.getAxis()), 2);
				branching = false;
			}
		}
		return true;
	}
}
