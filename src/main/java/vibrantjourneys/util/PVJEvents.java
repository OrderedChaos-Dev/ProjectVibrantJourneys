package vibrantjourneys.util;

import java.util.Iterator;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import vibrantjourneys.blocks.plant.BlockShortGrass;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.init.PVJBlocks;
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
	}
	
	@SubscribeEvent
	public void placePuddles(TickEvent.ServerTickEvent event)
	{
		if(event.phase == TickEvent.Phase.END && PVJConfig.master.enablePuddles)
		{
			WorldServer world = DimensionManager.getWorld(0);
			try
			{
				if(world.getTotalWorldTime() % 10 == 0)
				{
					Iterator<Chunk> iterator = world.getPlayerChunkMap().getChunkIterator();
					
					while(iterator.hasNext())
					{
						Random random = world.rand;
						ChunkPos chunkPos = iterator.next().getPos();
						
						int x = random.nextInt(8) - random.nextInt(8);
						int z = random.nextInt(8) - random.nextInt(8);
						BlockPos pos = chunkPos.getBlock(8 + x, 0, 8 + z);
						
						int y = world.getHeight(pos).getY() + random.nextInt(4) - random.nextInt(4);
						BlockPos puddlePos = pos.add(0, y, 0);
						
						if(this.canSpawnPuddle(world, puddlePos))
						{
							if(random.nextInt(9) == 0)
							{
								world.setBlockState(puddlePos.up(), PVJBlocks.puddle.getDefaultState(), 2);
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public boolean canSpawnPuddle(World world, BlockPos pos)
	{
		if(!world.isSideSolid(pos, EnumFacing.UP))
			return false;
		if(!world.isAirBlock(pos.up()))
			return false;
		if(!world.isRaining())
			return false;
		
		Biome biome = world.getBiomeForCoordsBody(pos);
		if(biome.canRain() && !biome.getEnableSnow())
		{
			for(int y = pos.getY() + 1; y < world.getHeight(); y++)
			{
				BlockPos up = new BlockPos(pos.getX(), y, pos.getZ());
				if(!world.isAirBlock(up))
					return false;
			}
			return true;
		}
		
		return false;
	}
	
	@SubscribeEvent
	public void dropSquid(LivingDropsEvent event)
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
