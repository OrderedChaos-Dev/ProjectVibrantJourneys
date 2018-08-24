package vibrantjourneys.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import vibrantjourneys.tileentities.TileEntityCampfire;

public class SlotCampfireFuel extends Slot
{
    public SlotCampfireFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityCampfire.isItemFuel(stack);
    }
}