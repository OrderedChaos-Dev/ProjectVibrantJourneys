package vibrantjourneys.entities.renderer;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.passive.EntityDuck;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving<EntityDuck>
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/entity/duck.png");

    public RenderDuck(RenderManager manager)
    {
        super(manager, new ModelChicken(), 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDuck entity)
    {
        return TEXTURES;
    }

    @Override
    protected float handleRotationFloat(EntityDuck duck, float partialTicks)
    {
        float f = duck.oFlap + (duck.wingRotation - duck.oFlap) * partialTicks;
        float f1 = duck.oFlapSpeed + (duck.destPos - duck.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
    
    public static class Factory implements IRenderFactory<EntityDuck>
    {
        @Override
        public Render<? super EntityDuck> createRenderFor(RenderManager manager)
        {
            return new RenderDuck(manager);
        }
    }
}