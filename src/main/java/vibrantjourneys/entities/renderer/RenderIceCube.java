package vibrantjourneys.entities.renderer;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.monster.EntityIceCube;
import vibrantjourneys.util.Reference;

public class RenderIceCube extends RenderLiving<EntityIceCube>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/icecube.png");

    public RenderIceCube(RenderManager manager)
    {
        super(manager, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerIceCube(this));
    }

    @Override
    public void doRender(EntityIceCube entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        this.shadowSize = 0.25F * (float)entity.getSlimeSize();
    }

    @Override
    protected void preRenderCallback(EntityIceCube entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIceCube entity)
    {
        return TEXTURE;
    }
    
    public static class Factory implements IRenderFactory<EntityIceCube>
    {
        @Override
        public Render<? super EntityIceCube> createRenderFor(RenderManager manager)
        {
            return new RenderIceCube(manager);
        }
    }
}
