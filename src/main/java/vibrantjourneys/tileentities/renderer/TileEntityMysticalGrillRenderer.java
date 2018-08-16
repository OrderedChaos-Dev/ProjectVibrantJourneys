package vibrantjourneys.tileentities.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;

public class TileEntityMysticalGrillRenderer extends TileEntitySpecialRenderer<TileEntityMysticalGrill>
{
	private EntityItem food = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D);
	private EntityItem netherwart = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D);
	private EntityItem essence = new EntityItem(Minecraft.getMinecraft().world, 0.0D, 0.0D, 0.0D);
	
	@Override
    public void render(TileEntityMysticalGrill grill, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (grill.getFood() != ItemStack.EMPTY)
        {
        	food.setItem(grill.getFood());
            GL11.glPushMatrix();
        	GL11.glTranslatef((float)x + 0.5F, (float)y + (float)(1.5 * Math.sin(Math.PI * grill.getWorld().getTotalWorldTime())), (float)z + 0.5F);
        	GL11.glRotatef((float)(grill.getWorld().getTotalWorldTime() * 1.5), 0, 1, 0);
        	
        	GL11.glScalef(1.1F, 1.1F, 1.1F);
        	Minecraft.getMinecraft().getRenderManager().renderEntity(food, 0.0D, 0.0D, 0.0D, 0.0F, 0, false);
            GL11.glPopMatrix();
        }
        int netherWart = grill.getNetherWartCount();
        for(int i = 0; i < netherWart; i++)
        {
        	netherwart.setItem(new ItemStack(Items.NETHER_WART, 1, 0));
        	
            GL11.glPushMatrix();
        	GL11.glTranslatef((float)x + 0.245F + (float)(0.125 * i), (float)y + 0.1F, (float)z + 0.5F);
        	
        	GL11.glScalef(0.3F, 0.3F, 0.3F);
        	Minecraft.getMinecraft().getRenderManager().renderEntity(netherwart, 0.0D, 0.0D, 0.0D, 0.0F, 0, false);
            GL11.glPopMatrix();
        }
        if(grill.hasEssence())
        {
        	essence.setItem(new ItemStack(PVJItems.unstable_essence, 1, 0));
        	
            GL11.glPushMatrix();
        	GL11.glTranslatef((float)x + 0.5F, (float)y + 0.1F, (float)z + 0.65F);
        	
        	GL11.glScalef(0.4F, 0.4F, 0.4F);
        	Minecraft.getMinecraft().getRenderManager().renderEntity(essence, 0.0D, 0.0D, 0.0D, 0.0F, 0, false);
            GL11.glPopMatrix();
        }
    }	
}
