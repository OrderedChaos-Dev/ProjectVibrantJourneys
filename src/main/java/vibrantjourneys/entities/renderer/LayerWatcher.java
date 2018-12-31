package vibrantjourneys.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.neutral.EntityWatcher;
import vibrantjourneys.entities.renderer.models.ModelWatcher;

@SideOnly(Side.CLIENT)
public class LayerWatcher implements LayerRenderer<EntityWatcher>
{
    private final RenderWatcher renderer;
    private final ModelBase model = new ModelWatcher(0);

    public LayerWatcher(RenderWatcher renderer)
    {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityWatcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.isInvisible())
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.model.setModelAttributes(this.renderer.getMainModel());
            
            this.model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }
}