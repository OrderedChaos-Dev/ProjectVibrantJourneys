package dev.orderedchaos.projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GlowcapBlock extends MushroomBlock {

	public GlowcapBlock(BlockBehaviour.Properties props) {
		super(props, null);
		//Block.Properties.of(Material.PLANT, MaterialColor.COLOR_YELLOW)
		//				.noCollission()
		//				.randomTicks()
		//				.instabreak()
		//				.sound(SoundType.GRASS).lightLevel((state) -> {
		//		      return 12;
		//		   }), () -> null
	}

	@Override
	public boolean growMushroom(ServerLevel world, BlockPos pos, BlockState state, RandomSource rand) {
		return false;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return blockstate.canSustainPlant(worldIn, blockpos, Direction.UP, this);
		}
	}
	
	@Override
	public boolean isBonemealSuccess(Level worldIn, RandomSource rand, BlockPos pos, BlockState state) {
		return false;
	}
	
	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
}