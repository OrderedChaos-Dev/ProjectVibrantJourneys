package projectvibrantjourneys.common.world.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FallenTreeFeature extends Feature<NoFeatureConfig> {

	public FallenTreeFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}
	
	public static final Set<Pair<String, Block>> LOGS = new HashSet<Pair<String, Block>>();

	@Override
	public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		BlockState state = getLog(world, pos);
		if(state == null) {
			return false;
		}
		BlockState b = world.getBlockState(pos.below());
		if(b.getMaterial() == Material.ICE || b.getMaterial() == Material.ICE || b.getBlock() == Blocks.SNOW_BLOCK) return false;
		boolean branching = rand.nextBoolean();
		BlockPos temp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		List<BlockPos> positions = new ArrayList<BlockPos>();
		int length = rand.nextInt(3) + 4;

		Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);

		while(length > 0) {
			if(world.getBlockState(pos).getMaterial().isReplaceable()) {
				positions.add(pos);
				length--;
				pos = pos.offset(dir.getNormal());
				
				if(world.getBlockState(pos.below()).getMaterial().isReplaceable() || world.getBlockState(pos.below()).getBlock() == Blocks.WATER) {
					temp = temp.offset(dir.getOpposite().getNormal());
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
			world.setBlock(p, state.setValue(RotatedPillarBlock.AXIS, dir.getAxis()), 2);
			if(branching && rand.nextBoolean()) {
				Direction d = rand.nextBoolean() ? dir.getClockWise(): dir.getCounterClockWise();
				BlockPos branchPos = p.offset(d.getNormal());
				if(world.getBlockState(branchPos).getMaterial().isReplaceable() || world.isEmptyBlock(branchPos))
					world.setBlock(branchPos, state.setValue(RotatedPillarBlock.AXIS, d.getAxis()), 2);
				branching = false;
			}
		}
		return true;
	}
	
	private BlockState getLog(ISeedReader world, BlockPos pos) {
		Biome biome = world.getBiome(pos);
		List<Block> logs = LOGS.stream().filter((pair) -> pair.getFirst().equals(biome.getRegistryName().toString())).map((pair) -> pair.getSecond()).collect(Collectors.toList());
		if(logs.size() > 0)
			return logs.get(world.getRandom().nextInt(logs.size())).defaultBlockState();
		return null;
	}
}
