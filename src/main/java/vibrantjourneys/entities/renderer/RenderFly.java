package vibrantjourneys.entities.renderer;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import vibrantjourneys.entities.passive.EntityFly;
import vibrantjourneys.entities.renderer.models.ModelFly;
import vibrantjourneys.util.Reference;

public class RenderFly extends RenderLiving<EntityFly>
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "fly");

    public RenderFly(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn, new ModelFly(), 0.1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityFly entity)
    {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityFly>
    {
        @Override
        public Render<? super EntityFly> createRenderFor(RenderManager manager)
        {
            return new RenderFly(manager);
        }
    }
}