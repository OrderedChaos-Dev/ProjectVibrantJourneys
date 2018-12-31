package vibrantjourneys.entities.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.neutral.EntityCoyote;

@SideOnly(Side.CLIENT)
public class LayerCoyoteCollar implements LayerRenderer<EntityCoyote>
{
    private static final ResourceLocation WOLF_COLLAR = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
    private final RenderCoyote coyote;

    public LayerCoyoteCollar(RenderCoyote wolfRendererIn)
    {
        this.coyote = wolfRendererIn;
    }

    @Override
    public void doRenderLayer(EntityCoyote entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (entitylivingbaseIn.isTamed() && !entitylivingbaseIn.isInvisible())
        {
            this.coyote.bindTexture(WOLF_COLLAR);
            float[] afloat = entitylivingbaseIn.getCollarColor().getColorComponentValues();
            GlStateManager.color(afloat[0], afloat[1], afloat[2]);
            this.coyote.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }
}