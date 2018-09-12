package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.passive.EntityAnt;
import vibrantjourneys.entities.renderer.models.ModelAnt;

@SideOnly(Side.CLIENT)
public class RenderAnt<T extends EntityAnt> extends RenderLiving<T>
{
    private static final ResourceLocation ANT_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");

    public RenderAnt(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelAnt(), 0.005F);
    }
    
    @Override
    protected void preRenderCallback(EntityAnt entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.08F, 0.08F, 0.08F);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity)
    {
        return ANT_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntityAnt>
    {
        @Override
        public Render<? super EntityAnt> createRenderFor(RenderManager manager)
        {
            return new RenderAnt(manager);
        }
    }
}