package vibrantjourneys.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vibrantjourneys.items.ItemMysticalFood;

public class PVJEvents
{
	@SubscribeEvent
	public void onBreakGrass(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.getState().getBlock();
		if(!PVJConfig.doGrassDropSeeds)
		{
			if(block instanceof BlockTallGrass)
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
}
