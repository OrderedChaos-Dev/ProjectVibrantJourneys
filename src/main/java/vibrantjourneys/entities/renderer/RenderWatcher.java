package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.monster.EntityWatcher;
import vibrantjourneys.entities.renderer.models.ModelWatcher;
import vibrantjourneys.util.Reference;

public class RenderWatcher extends RenderLiving<EntityWatcher>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/entity/watcher.png");

    public RenderWatcher(RenderManager manager)
    {
        super(manager, new ModelWatcher(16), 0.25F);
        this.addLayer(new LayerWatcher(this));
    }

    @Override
    public void doRender(EntityWatcher entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    protected void preRenderCallback(EntityWatcher entitylivingbaseIn, float partialTickTime)
    {
    	GlStateManager.scale(1.6F, 1.6F, 1.6F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWatcher entity)
    {
        return TEXTURE;
    }
    
    public static class Factory implements IRenderFactory<EntityWatcher>
    {
        @Override
        public Render<? super EntityWatcher> createRenderFor(RenderManager manager)
        {
            return new RenderWatcher(manager);
        }
    }
}
