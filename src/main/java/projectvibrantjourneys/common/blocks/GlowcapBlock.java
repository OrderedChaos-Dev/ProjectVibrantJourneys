package projectvibrantjourneys.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GlowcapBlock extends MushroomBlock {

	public GlowcapBlock() {
		super(Block.Properties.create(Material.PLANTS, MaterialColor.YELLOW)
				.doesNotBlockMovement()
				.tickRandomly()
				.zeroHardnessAndResistance()
				.sound(SoundType.PLANT).setLightLevel((state) -> {
		      return 12;
		   }));
	}

	@Override
	public boolean grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		return false;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
		}
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
}
