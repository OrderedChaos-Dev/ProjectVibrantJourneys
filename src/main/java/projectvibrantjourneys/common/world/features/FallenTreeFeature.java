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
	public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		BlockState state = getLog(world, pos);
		if(state == null) {
			return false;
		}
		BlockState b = world.getBlockState(pos.down());
		if(b.getMaterial() == Material.ICE || b.getMaterial() == Material.ICE || b.getBlock() == Blocks.SNOW_BLOCK) return false;
		boolean branching = rand.nextBoolean();
		BlockPos temp = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		List<BlockPos> positions = new ArrayList<BlockPos>();
		int length = rand.nextInt(3) + 4;

		Direction dir = Direction.Plane.HORIZONTAL.random(rand);

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
			world.setBlockState(p, state.with(RotatedPillarBlock.AXIS, dir.getAxis()), 2);
			if(branching && rand.nextBoolean()) {
				Direction d = rand.nextBoolean() ? dir.rotateY() : dir.rotateYCCW();
				BlockPos branchPos = p.offset(d);
				if(world.getBlockState(branchPos).getMaterial().isReplaceable() || world.isAirBlock(branchPos))
					world.setBlockState(branchPos, state.with(RotatedPillarBlock.AXIS, d.getAxis()), 2);
				branching = false;
			}
		}
		return true;
	}
	
	private BlockState getLog(ISeedReader world, BlockPos pos) {
		Biome biome = world.getBiome(pos);
		List<Block> logs = LOGS.stream().filter((pair) -> pair.getFirst().equals(biome.getRegistryName().toString())).map((pair) -> pair.getSecond()).collect(Collectors.toList());
		if(logs.size() > 0)
			return logs.get(world.getRandom().nextInt(logs.size())).getDefaultState();
		return null;
	}
}
