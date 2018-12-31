package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vibrantjourneys.entities.neutral.EntityCoyote;

@SideOnly(Side.CLIENT)
public class ModelCoyote extends ModelBase
{
    public ModelRenderer coyoteHeadMain;
    public ModelRenderer coyoteBody;
    public ModelRenderer coyoteLeg1;
    public ModelRenderer coyoteLeg2;
    public ModelRenderer coyoteLeg3;
    public ModelRenderer coyoteLeg4;
    ModelRenderer coyoteTail;
    ModelRenderer coyoteMane;

    public ModelCoyote()
    {
        this.coyoteHeadMain = new ModelRenderer(this, 0, 0);
        this.coyoteHeadMain.addBox(-2.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
        this.coyoteHeadMain.setRotationPoint(-1.0F, 13.5F, -7.0F);
        this.coyoteBody = new ModelRenderer(this, 18, 14);
        this.coyoteBody.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        this.coyoteBody.setRotationPoint(0.0F, 14.0F, 2.0F);
        this.coyoteMane = new ModelRenderer(this, 21, 0);
        this.coyoteMane.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        this.coyoteMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
        this.coyoteLeg1 = new ModelRenderer(this, 0, 18);
        this.coyoteLeg1.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.coyoteLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.coyoteLeg2 = new ModelRenderer(this, 0, 18);
        this.coyoteLeg2.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.coyoteLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.coyoteLeg3 = new ModelRenderer(this, 0, 18);
        this.coyoteLeg3.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.coyoteLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.coyoteLeg4 = new ModelRenderer(this, 0, 18);
        this.coyoteLeg4.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.coyoteLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.coyoteTail = new ModelRenderer(this, 9, 18);
        this.coyoteTail.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.coyoteTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.coyoteHeadMain.setTextureOffset(16, 14).addBox(-2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        this.coyoteHeadMain.setTextureOffset(16, 14).addBox(2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        this.coyoteHeadMain.setTextureOffset(0, 10).addBox(-0.5F, 0.0F, -5.0F, 3, 3, 4, 0.0F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 5.0F * scale, 2.0F * scale);
            this.coyoteHeadMain.renderWithRotation(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.coyoteBody.render(scale);
            this.coyoteLeg1.render(scale);
            this.coyoteLeg2.render(scale);
            this.coyoteLeg3.render(scale);
            this.coyoteLeg4.render(scale);
            this.coyoteTail.renderWithRotation(scale);
            this.coyoteMane.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
            this.coyoteHeadMain.renderWithRotation(scale);
            this.coyoteBody.render(scale);
            this.coyoteLeg1.render(scale);
            this.coyoteLeg2.render(scale);
            this.coyoteLeg3.render(scale);
            this.coyoteLeg4.render(scale);
            this.coyoteTail.renderWithRotation(scale);
            this.coyoteMane.render(scale);
        }
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        EntityCoyote EntityCoyote = (EntityCoyote)entitylivingbaseIn;

        if (EntityCoyote.isAngry())
        {
            this.coyoteTail.rotateAngleY = 0.0F;
        }
        else
        {
            this.coyoteTail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }

        if (EntityCoyote.isSitting())
        {
            this.coyoteMane.setRotationPoint(-1.0F, 16.0F, -3.0F);
            this.coyoteMane.rotateAngleX = ((float)Math.PI * 2F / 5F);
            this.coyoteMane.rotateAngleY = 0.0F;
            this.coyoteBody.setRotationPoint(0.0F, 18.0F, 0.0F);
            this.coyoteBody.rotateAngleX = ((float)Math.PI / 4F);
            this.coyoteTail.setRotationPoint(-1.0F, 21.0F, 6.0F);
            this.coyoteLeg1.setRotationPoint(-2.5F, 22.0F, 2.0F);
            this.coyoteLeg1.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.coyoteLeg2.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.coyoteLeg2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.coyoteLeg3.rotateAngleX = 5.811947F;
            this.coyoteLeg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.coyoteLeg4.rotateAngleX = 5.811947F;
            this.coyoteLeg4.setRotationPoint(0.51F, 17.0F, -4.0F);
        }
        else
        {
            this.coyoteBody.setRotationPoint(0.0F, 14.0F, 2.0F);
            this.coyoteBody.rotateAngleX = ((float)Math.PI / 2F);
            this.coyoteMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.coyoteMane.rotateAngleX = this.coyoteBody.rotateAngleX;
            this.coyoteTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.coyoteLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.coyoteLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.coyoteLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.coyoteLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.coyoteLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.coyoteLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.coyoteLeg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.coyoteLeg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }

        this.coyoteHeadMain.rotateAngleZ = EntityCoyote.getInterestedAngle(partialTickTime) + EntityCoyote.getShakeAngle(partialTickTime, 0.0F);
        this.coyoteMane.rotateAngleZ = EntityCoyote.getShakeAngle(partialTickTime, -0.08F);
        this.coyoteBody.rotateAngleZ = EntityCoyote.getShakeAngle(partialTickTime, -0.16F);
        this.coyoteTail.rotateAngleZ = EntityCoyote.getShakeAngle(partialTickTime, -0.2F);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.coyoteHeadMain.rotateAngleX = headPitch * 0.017453292F;
        this.coyoteHeadMain.rotateAngleY = netHeadYaw * 0.017453292F;
        this.coyoteTail.rotateAngleX = ageInTicks;
    }
}