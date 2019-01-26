package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.monster.EntityBanshee;
import vibrantjourneys.entities.renderer.models.ModelGhost;
import vibrantjourneys.util.Reference;

@SideOnly(Side.CLIENT)
public class RenderBanshee extends RenderBiped<EntityBanshee>
{
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entity/banshee.png");

    public RenderBanshee(RenderManager renderManagerIn)
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
    protected ResourceLocation getEntityTexture(EntityBanshee entity)
    {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityBanshee>
    {
        @Override
        public Render<? super EntityBanshee> createRenderFor(RenderManager manager)
        {
            return new RenderBanshee(manager);
        }
    }
}