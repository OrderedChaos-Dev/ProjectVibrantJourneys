package vibrantjourneys.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMysticalFood extends ItemFood
{	
	public ItemMysticalFood(ItemFood baseFood)
	{
		super(baseFood.getHealAmount(ItemStack.EMPTY), baseFood.getSaturationModifier(ItemStack.EMPTY), false);
		this.setAlwaysEdible();
        this.setMaxStackSize(1);
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
    }
	
	@Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            for (PotionEffect effect : PotionUtils.getEffectsFromStack(stack))
            {
                if (effect.getPotion().isInstant())
                {
                    effect.getPotion().affectEntity(player, player, player, effect.getAmplifier(), 1.0D);
                }
                else
                {
                    player.addPotionEffect(new PotionEffect(effect));
                }
            }
        }
    }
}
