package vibrantjourneys.crafting;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FurnaceFuelHandler
{
	private HashMap<Item, Integer> fuelValues = new HashMap<Item, Integer>();
	
	@SubscribeEvent
	public void getBurnTime(FurnaceFuelBurnTimeEvent event)
	{
		Item item = event.getItemStack().getItem();
		if(fuelValues.containsKey(item))
		{
			event.setBurnTime(fuelValues.get(item));
		}
	}

	public void addFuel(Item item, int burnTime)
	{
		this.fuelValues.put(item, burnTime);
	}
	
	public void addFuel(Block block, int burnTime)
	{
		this.fuelValues.put(Item.getItemFromBlock(block), burnTime);
	}
}
