package projectvibrantjourneys.init;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;

public class PVJEvents {
	
	@SuppressWarnings("deprecation") //works in this case
	@SubscribeEvent
	public void placeNuggets(PlayerInteractEvent.RightClickBlock event) {
		ItemStack stack = event.getItemStack();
		Item item = stack.getItem();
		World world = event.getWorld();
		Direction direction = event.getFace();
		BlockPos pos = event.getPos();
		BlockPos posWithOffset = pos.offset(direction);
		PlayerEntity player = event.getPlayer();
		
		Block groundcover;
		
		int model = world.getRandom().nextInt(5);
		
		if(item == Items.IRON_NUGGET) {
			groundcover = PVJBlocks.iron_nugget;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == Items.GOLD_NUGGET) {
			groundcover = PVJBlocks.gold_nugget;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == Items.FLINT) {
			groundcover = PVJBlocks.flint;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == PVJBlocks.dung.asItem()) {
			if(!player.isCrouching()) {
				if(BoneMealItem.applyBonemeal(stack, world, pos, player)) {
					BoneMealItem.spawnBonemealParticles(world, pos, 0);
					event.setCanceled(true);
				}
			}
		}
	}
}
