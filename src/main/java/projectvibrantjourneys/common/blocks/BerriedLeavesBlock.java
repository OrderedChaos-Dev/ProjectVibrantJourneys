package projectvibrantjourneys.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJItems;

public class BerriedLeavesBlock extends LeavesBlock {

	public BerriedLeavesBlock(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		if (!player.abilities.allowEdit) {
			return ActionResultType.PASS;
		} else {
			int count = 1 + world.getRandom().nextInt(2);
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(PVJItems.juniper_berries, count));
			world.setBlockState(pos, PVJBlocks.juniper_leaves.getDefaultState());
			return ActionResultType.SUCCESS;
		}
	}
}
