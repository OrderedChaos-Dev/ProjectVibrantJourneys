package vibrantjourneys.entities.renderer;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.passive.EntityFirefly;
import vibrantjourneys.entities.renderer.models.ModelFly;
import vibrantjourneys.util.Reference;

public class RenderFirefly extends RenderLiving<EntityFirefly>
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/firefly.png");

    public RenderFirefly(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelFly(), 0.1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityFirefly entity)
    {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityFirefly>
    {
        @Override
        public Render<? super EntityFirefly> createRenderFor(RenderManager manager)
        {
            return new RenderFirefly(manager);
        }
    }
}