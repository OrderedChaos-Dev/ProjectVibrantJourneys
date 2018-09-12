package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAnt extends ModelBase
{

    public ModelRenderer head;
    public ModelRenderer thorax;
    public ModelRenderer abdomen;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;

    public ModelAnt()
    {
        this.head = new ModelRenderer(this, 32, 4);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.head.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.thorax = new ModelRenderer(this, 0, 0);
        this.thorax.addBox(-3.0F, -2.7F, -3.0F, 6, 6, 6, 0.0F);
        this.thorax.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.abdomen = new ModelRenderer(this, 0, 12);
        this.abdomen.addBox(-5.0F, -4.0F, -6.0F, 10, 6, 12, 0.0F);
        this.abdomen.setRotationPoint(0.0F, 15.0F, 9.0F);
        this.leg1 = new ModelRenderer(this, 18, 0);
        this.leg1.addBox(-15.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        this.leg2 = new ModelRenderer(this, 18, 0);
        this.leg2.addBox(-1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        this.leg3 = new ModelRenderer(this, 18, 0);
        this.leg3.addBox(-15.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        this.leg4 = new ModelRenderer(this, 18, 0);
        this.leg4.addBox(-1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        this.leg5 = new ModelRenderer(this, 18, 0);
        this.leg5.addBox(-15.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        this.leg6 = new ModelRenderer(this, 18, 0);
        this.leg6.addBox(-1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F);
        this.leg6.setRotationPoint(4.0F, 15.0F, 0.0F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale * 0.8F);
        this.thorax.render(scale * 1.1F);
        this.abdomen.render(scale * 0.95F);
        this.leg1.render(scale);
        this.leg2.render(scale);
        this.leg3.render(scale);
        this.leg4.render(scale);
        this.leg5.render(scale);
        this.leg6.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.leg1.rotateAngleZ = -((float)Math.PI / 4F);
        this.leg2.rotateAngleZ = ((float)Math.PI / 4F);
        this.leg3.rotateAngleZ = -0.58119464F;
        this.leg4.rotateAngleZ = 0.58119464F;
        this.leg5.rotateAngleZ = -0.58119464F;
        this.leg6.rotateAngleZ = 0.58119464F;
        this.leg1.rotateAngleY = ((float)Math.PI / 4F);
        this.leg2.rotateAngleY = -((float)Math.PI / 4F);
        this.leg3.rotateAngleY = 0.3926991F;
        this.leg4.rotateAngleY = -0.3926991F;
        this.leg5.rotateAngleY = -0.3926991F;
        this.leg6.rotateAngleY = 0.3926991F;
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        this.leg1.rotateAngleY += f3;
        this.leg2.rotateAngleY += -f3;
        this.leg3.rotateAngleY += f4;
        this.leg4.rotateAngleY += -f4;
        this.leg5.rotateAngleY += f5;
        this.leg6.rotateAngleY += -f5;
        this.leg1.rotateAngleZ += f7;
        this.leg2.rotateAngleZ += -f7;
        this.leg3.rotateAngleZ += f8;
        this.leg4.rotateAngleZ += -f8;
        this.leg5.rotateAngleZ += f9;
        this.leg6.rotateAngleZ += -f9;
    }
}