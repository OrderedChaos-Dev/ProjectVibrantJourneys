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
import projectvibrantjourneys.init.object.PVJBlocks;
import projectvibrantjourneys.init.object.PVJItems;

public class JuniperLeavesBlock extends LeavesBlock {

	public JuniperLeavesBlock(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		if(player.mayBuild()) {
			InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(PVJItems.juniper_berries, 1 + world.getRandom().nextInt(2)));
			world.setBlock(pos, PVJBlocks.juniper_leaves.defaultBlockState().setValue(PERSISTENT, state.getValue(PERSISTENT)), 2);
		}
		return ActionResultType.SUCCESS;
	}
}
