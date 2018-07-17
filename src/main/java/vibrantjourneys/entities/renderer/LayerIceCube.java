package vibrantjourneys.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.monster.EntityIceCube;

@SideOnly(Side.CLIENT)
public class LayerIceCube implements LayerRenderer<EntityIceCube>
{
    private final RenderIceCube renderer;
    private final ModelBase slimeModel = new ModelSlime(0);

    public LayerIceCube(RenderIceCube renderer)
    {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityIceCube entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.isInvisible())
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.slimeModel.setModelAttributes(this.renderer.getMainModel());
            this.slimeModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
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