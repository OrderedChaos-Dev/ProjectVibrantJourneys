package projectvibrantjourneys.init;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.entities.IceCubeEntity;

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
	
	@SubscribeEvent
	public void thisIsWar(LivingSpawnEvent event) {
		if(event.getEntityLiving() instanceof MagmaCubeEntity) {
			MagmaCubeEntity magmaCube = (MagmaCubeEntity)event.getEntityLiving();
			magmaCube.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(magmaCube, IceCubeEntity.class, 10, true, false, (entity) -> {
				return Math.abs(entity.func_226278_cu_() - magmaCube.func_226278_cu_()) <= 4.0D;
			}));
			magmaCube.getCollisionBox(magmaCube);
		}
	}
	
	@SubscribeEvent
	public void attack(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof MagmaCubeEntity) {
			MagmaCubeEntity magmaCube = (MagmaCubeEntity)event.getEntityLiving();
			World world = event.getEntityLiving().getEntityWorld();
			List<Entity> neighbors = world.getEntitiesWithinAABBExcludingEntity(magmaCube, magmaCube.getBoundingBox());
			for(Entity entity : neighbors) {
				if(entity instanceof IceCubeEntity) {
					magmaCube.attackEntityAsMob(entity);
				}
			}
		}
	}
}
