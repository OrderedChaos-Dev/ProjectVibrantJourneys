package vibrantjourneys.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.init.PVJItems;
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
		if(event.getEntityLiving() instanceof EntityFirefly)
		{
			if(!PVJConfig.entities.firefliesSpawnInSnowBiomes)
			{
				Biome biome = event.getWorld().getBiomeForCoordsBody(event.getEntityLiving().getPosition());
				if(BiomeReference.SNOWY_BIOMES.contains(biome))
				{
					event.setResult(Result.DENY);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void dropSquid(LivingDropsEvent event)
	{
		if(PVJConfig.entities.squidsDropFood)
		{
			if(event.getEntityLiving() instanceof EntitySquid)
			{
				ItemStack squid = new ItemStack(PVJItems.raw_squid);
				if(event.getSource() == DamageSource.ON_FIRE)
					squid = new ItemStack(PVJItems.cooked_squid);
				
				EntityItem drop = new EntityItem(event.getEntityLiving().getEntityWorld());
				BlockPos pos = event.getEntityLiving().getPosition();
				drop.setItem(squid);
				drop.setPosition(pos.getX(), pos.getY(), pos.getZ());
				
				event.getEntityLiving().getEntityWorld().spawnEntity(drop);
			}	
		}
	}
	
	/*@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void setSwampColor(GetGrassColor event)
	{
		if(event.getBiome() == Biomes.SWAMPLAND || event.getBiome() == Biomes.MUTATED_SWAMPLAND)
		{
			event.setNewColor(0x70D325);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void setSwampColor(GetFoliageColor event)
	{
		if(event.getBiome() == Biomes.SWAMPLAND || event.getBiome() == Biomes.MUTATED_SWAMPLAND)
		{
			event.setNewColor(0x70D325);
		}
	}*/
}
