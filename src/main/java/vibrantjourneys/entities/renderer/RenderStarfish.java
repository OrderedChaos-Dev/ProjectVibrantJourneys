package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.passive.EntityStarfish;
import vibrantjourneys.entities.renderer.models.ModelStarfish;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderStarfish extends RenderLiving<EntityStarfish>
{
    public RenderStarfish(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelStarfish(), 0.1F);
    }

    @Override
    protected float getDeathMaxRotation(EntityStarfish entityLivingBaseIn)
    {
        return 180.0F;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityStarfish entity)
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/starfish/starfish_" + entity.getColor() + ".png");
    }
    
    public static class Factory implements IRenderFactory<EntityStarfish>
    {
        @Override
        public Render<? super EntityStarfish> createRenderFor(RenderManager manager)
        {
            return new RenderStarfish(manager);
        }
    }
}