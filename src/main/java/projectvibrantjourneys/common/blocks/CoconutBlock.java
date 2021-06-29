package projectvibrantjourneys.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CoconutBlock extends Block {
	
	protected static final VoxelShape SHAPE = Block.box(4.0D, 10.0D, 4.0D, 11.0D, 16.0D, 11.0D);
	
	public CoconutBlock() {
		super(Block.Properties.of(Material.WOOD).strength(0.4F, 0.7F).sound(SoundType.WOOD));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState up = world.getBlockState(pos.above());
		return up.getMaterial().isSolid() || up.getBlock() instanceof LeavesBlock;
	}
	
	@Override
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos)) {
			world.destroyBlock(pos, true);
			InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult brt) {
		if (!player.mayBuild()) {
			return ActionResultType.PASS;
		} else {
			world.destroyBlock(pos, true);
			InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
			return ActionResultType.SUCCESS;
		}
	}
}
