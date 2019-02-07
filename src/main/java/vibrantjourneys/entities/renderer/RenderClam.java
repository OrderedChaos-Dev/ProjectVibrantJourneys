package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.passive.EntityClam;
import vibrantjourneys.entities.renderer.models.ModelClam;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderClam extends RenderLiving<EntityClam>
{
    public RenderClam(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelClam(), 0.1F);
    }

    @Override
    protected float getDeathMaxRotation(EntityClam entityLivingBaseIn)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityClam entity)
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/clam.png");
    }
    
    public static class Factory implements IRenderFactory<EntityClam>
    {
        @Override
        public Render<? super EntityClam> createRenderFor(RenderManager manager)
        {
            return new RenderClam(manager);
        }
    }
}