package com.projectvibrantjourneys.blocks;

import com.projectvibrantjourneys.init.object.PVJBlocks;
import com.projectvibrantjourneys.init.object.PVJItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BerriedJuniperLeavesBlock extends LeavesBlock {

	public BerriedJuniperLeavesBlock(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
		if(player.mayBuild()) {
			Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(PVJItems.JUNIPER_BERRIES.get(), 1 + world.getRandom().nextInt(2)));
			world.setBlock(pos, PVJBlocks.juniper_leaves.get().defaultBlockState().setValue(PERSISTENT, state.getValue(PERSISTENT)), 2);
		}
		return InteractionResult.SUCCESS;
	}
}