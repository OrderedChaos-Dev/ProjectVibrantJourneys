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
		super(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_YELLOW)
				.noCollission()
				.randomTicks()
				.instabreak()
				.sound(SoundType.GRASS).lightLevel((state) -> {
		      return 12;
		   }));
	}

	@Override
	public boolean growMushroom(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		return false;
	}
	
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
		}
	}
	
	@Override
	public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
	
	@Override
	public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
}
