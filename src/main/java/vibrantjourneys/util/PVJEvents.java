package vibrantjourneys.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.entities.passive.EntityPlaceholder;
import vibrantjourneys.entities.passive.EntityStarfish;
import vibrantjourneys.items.ItemMysticalFood;

public class PVJEvents
{
	@SubscribeEvent
	public void onBreakGrass(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.getState().getBlock();
		if(!PVJConfig.misc.doGrassDropSeeds)
		{
			if(block instanceof BlockTallGrass || block instanceof BlockShortGrass)
			{
				boolean flag = false;
				for(ItemStack item : event.getDrops())
				{
					if(item.getItem() == Items.WHEAT_SEEDS)
					{
						flag = true;
					}
				}
				if(flag)
				{
					event.getDrops().clear();
				}
			}
		}
	}
	
	@SubscribeEvent
	public void feedWolfEvent(PlayerInteractEvent.EntityInteractSpecific event)
	{
		if(event.getTarget() instanceof EntityWolf)
		{
			EntityWolf wolf = (EntityWolf)event.getTarget();
			if(wolf.isTamed() && wolf.getOwner() == event.getEntityPlayer())
			{
				if(event.getEntityPlayer().getHeldItem(event.getHand()).getItem() instanceof ItemMysticalFood)
				{
					wolf.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("strength"), 1200));
					wolf.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"), 1200, 2));
					wolf.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("speed"), 1200));
					wolf.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("resistance"), 1200));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onWatcherSpawn(LivingSpawnEvent.CheckSpawn event)
	{
		if(event.getEntityLiving() instanceof EntityWatcher)
		{
			Random random = event.getWorld().rand;
			int x = random.nextInt(50) - random.nextInt(50);
			int y = random.nextInt(40) - random.nextInt(40);
			int z = random.nextInt(50) - random.nextInt(50);
			BlockPos pos = new BlockPos(event.getX() + x, event.getY() + y, event.getZ() + z);
			
			while(!event.getWorld().isAirBlock(pos))
			{
				x = random.nextInt(50) - random.nextInt(50);
				y = random.nextInt(40) - random.nextInt(40);
				z = random.nextInt(50) - random.nextInt(50);
				pos = new BlockPos(event.getX() + x, event.getY() + y, event.getZ() + z);
			}
			event.getEntityLiving().setPosition(event.getX() + x, event.getY() + y, event.getZ() + z);
		}
	}
	
	/*
	 * Since the starfish is a water mob, it can only spawn in water due to how Minecraft does things
	 * So I have a placeholder entity that spawns on beaches that is immediately replaced with starfish
	 * So now it can spawn on beaches and underwater in oceans
	 */
	@SubscribeEvent
	public void spawnStarfishOnBeach(LivingSpawnEvent.CheckSpawn event)
	{
		if(event.getEntityLiving() instanceof EntityPlaceholder)
		{
			if(BiomeReference.BEACH_BIOMES.contains(event.getWorld().getBiomeForCoordsBody(new BlockPos(event.getX(), 0, event.getZ()))))
			{
				EntityStarfish starfish = new EntityStarfish(event.getWorld());
				starfish.setPosition(event.getX(), event.getY(), event.getZ());
				starfish.setRandomColor();
				event.getWorld().spawnEntity(starfish);
				event.setResult(Result.DENY);
			}
		}
	}
}
