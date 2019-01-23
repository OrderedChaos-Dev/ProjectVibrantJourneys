package vibrantjourneys.entities.renderer;

import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.passive.EntitySmallSpider;

@SideOnly(Side.CLIENT)
public class RenderSmallSpider<T extends EntitySmallSpider> extends RenderLiving<T>
{
    private static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");

    public RenderSmallSpider(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSpider(), 0.1F);
        this.addLayer(new LayerSmallSpiderEyes<T>(this));
    }
    
    @Override
    protected void preRenderCallback(EntitySmallSpider entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.2F, 0.2F, 0.2F);
    }

    @Override
    protected float getDeathMaxRotation(T entityLivingBaseIn)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity)
    {
        return SPIDER_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntitySmallSpider>
    {
        @Override
        public Render<? super EntitySmallSpider> createRenderFor(RenderManager manager)
        {
            return new RenderSmallSpider<EntitySmallSpider>(manager);
        }
    }
}