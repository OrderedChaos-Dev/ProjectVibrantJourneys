package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.neutral.EntityCoyote;
import vibrantjourneys.entities.renderer.models.ModelCoyote;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderCoyote extends RenderLiving<EntityCoyote>
{
    private static final ResourceLocation COYOTE = new ResourceLocation(Reference.MOD_ID, "textures/entity/coyote/coyote.png");
    private static final ResourceLocation TAMED_COYOTE = new ResourceLocation(Reference.MOD_ID, "textures/entity/coyote/coyote_tame.png");
    private static final ResourceLocation ANGRY_BOI = new ResourceLocation(Reference.MOD_ID, "textures/entity/coyote/coyote_angry.png");

    public RenderCoyote(RenderManager manager)
    {
        super(manager, new ModelCoyote(), 0.5F);
        this.addLayer(new LayerCoyoteCollar(this));
    }
    
    @Override
    protected float handleRotationFloat(EntityCoyote livingBase, float partialTicks)
    {
        return livingBase.getTailRotation();
    }

    @Override
    public void doRender(EntityCoyote entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.isWolfWet())
        {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    protected void preRenderCallback(EntityCoyote entitylivingbaseIn, float partialTickTime)
    {
    	GlStateManager.scale(0.9F, 0.9F, 0.9F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCoyote entity)
    {
        if (entity.isTamed())
        {
            return TAMED_COYOTE;
        }
        else
        {
            return entity.isAngry() ? ANGRY_BOI : COYOTE;
        }
    }
    
    public static class Factory implements IRenderFactory<EntityCoyote>
    {
        @Override
        public Render<? super EntityCoyote> createRenderFor(RenderManager manager)
        {
            return new RenderCoyote(manager);
        }
    }
}