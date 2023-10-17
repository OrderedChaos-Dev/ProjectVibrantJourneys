package dev.orderedchaos.projectvibrantjourneys.common.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {

    private int burnTime;

    public FuelBlockItem(Block block, Properties props, int burnTime) {
        super(block, props);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, RecipeType type) {
        return this.burnTime;
    }
}
