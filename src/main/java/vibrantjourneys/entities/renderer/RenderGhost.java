package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.neutral.EntityGhost;
import vibrantjourneys.entities.renderer.models.ModelGhost;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderGhost extends RenderBiped<EntityGhost>
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/ghost.png");

    public RenderGhost(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelGhost(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelGhost(0.5F, true);
                this.modelArmor = new ModelGhost(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGhost entity)
    {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityGhost>
    {
        @Override
        public Render<? super EntityGhost> createRenderFor(RenderManager manager)
        {
            return new RenderGhost(manager);
        }
    }
}