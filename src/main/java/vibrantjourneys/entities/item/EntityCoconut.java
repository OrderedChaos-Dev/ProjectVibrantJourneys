package vibrantjourneys.entities.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.init.PVJItems;

public class EntityCoconut extends EntityThrowable
{
	public EntityCoconut(World worldIn)
	{
		super(worldIn);
	}
	
	public EntityCoconut(World worldIn, double x, double y, double z)
	{
		super(worldIn, x, y, z);
	}
	
    public EntityCoconut(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        this.setPosition(throwerIn.posX, throwerIn.posY + (double)throwerIn.getEyeHeight() - 0.30000000149011612D, throwerIn.posZ);
    }

	@Override
	protected void onImpact(RayTraceResult result)
	{
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
        }

        if (!this.world.isRemote)
        {
        	ItemStack coconut = new ItemStack(PVJItems.cracked_coconut, 2);
        	InventoryHelper.spawnItemStack(world, this.posX, this.posY, this.posZ, coconut);
        	
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(PVJItems.cracked_coconut));
            }
        }
    }
}
