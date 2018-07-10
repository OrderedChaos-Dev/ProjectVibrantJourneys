package vibrantjourneys.entities.renderer;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.passive.EntitySnail;
import vibrantjourneys.entities.renderer.models.ModelSnail;
import vibrantjourneys.util.Reference;

public class RenderSnail extends RenderLiving<EntitySnail>
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "snail");

    public RenderSnail(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelSnail(), 0.1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntitySnail entity)
    {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySnail>
    {
        @Override
        public Render<? super EntitySnail> createRenderFor(RenderManager manager)
        {
            return new RenderSnail(manager);
        }
    }
}