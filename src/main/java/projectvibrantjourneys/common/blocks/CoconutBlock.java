package projectvibrantjourneys.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoconutBlock extends Block {
	
	protected static final VoxelShape SHAPE = Block.box(4.0D, 10.0D, 4.0D, 11.0D, 16.0D, 11.0D);
	
	public CoconutBlock() {
		super(Block.Properties.of(Material.WOOD).strength(0.4F, 0.7F).sound(SoundType.WOOD));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState up = world.getBlockState(pos.above());
		return up.getMaterial().isSolid() || up.getBlock() instanceof LeavesBlock;
	}
	
	@Override
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		if(!canSurvive(state, world, pos)) {
			world.destroyBlock(pos, true);
			Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
		if (!player.mayBuild()) {
			return InteractionResult.PASS;
		} else {
			world.destroyBlock(pos, true);
			Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
			return InteractionResult.SUCCESS;
		}
	}
}
