package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelWatcher extends ModelBase
{
    ModelRenderer body;

    public ModelWatcher(int i)
    {
        if (i > 0)
        {
            this.body = new ModelRenderer(this, 0, i);
            this.body.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
        }
        else
        {
            this.body = new ModelRenderer(this, 0, i);
            this.body.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);
        }
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.translate(0.0F, 0.001F, 0.0F);
        this.body.render(scale);
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.body.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = headPitch * 0.017453292F;
    }
        
}