package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.monster.EntityGoon;
import vibrantjourneys.entities.renderer.models.ModelGoon;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderGoon extends RenderBiped<EntityGoon>
{
    private static final ResourceLocation GOON_TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/entity/goon.png");

    public RenderGoon(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelGoon(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityGoon entity)
    {
        return GOON_TEXTURES;
    }
    
    @Override
    protected void preRenderCallback(EntityGoon entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(0.85F, 0.85F, 0.85F);
    }
    
    public static class Factory implements IRenderFactory<EntityGoon>
    {
        @Override
        public Render<? super EntityGoon> createRenderFor(RenderManager manager)
        {
            return new RenderGoon(manager);
        }
    }
}