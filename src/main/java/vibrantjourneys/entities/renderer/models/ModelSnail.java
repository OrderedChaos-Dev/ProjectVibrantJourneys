package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelSnail extends ModelBase
{
    public ModelRenderer body;
    public ModelRenderer shell;
    public ModelRenderer antennaeLeft;
    public ModelRenderer antennaeRight;

    public ModelSnail()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.antennaeLeft = new ModelRenderer(this, 0, 0);
        this.antennaeLeft.setRotationPoint(0.0F, 23.4F, 0.0F);
        this.antennaeLeft.addBox(0.0F, 0.1F, -2.8F, 2, 0, 1, 0.0F);
        this.setRotateAngle(antennaeLeft, -0.1795943800302165F, 0.0F, 0.0F);
        this.shell = new ModelRenderer(this, 0, 0);
        this.shell.setRotationPoint(0.0F, 20.9F, -1.1F);
        this.shell.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 22.9F, -1.9F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.antennaeRight = new ModelRenderer(this, 0, 0);
        this.antennaeRight.setRotationPoint(0.8F, 23.4F, 0.0F);
        this.antennaeRight.addBox(0.0F, 0.1F, -2.8F, 2, 0, 1, 0.0F);
        this.setRotateAngle(antennaeRight, -0.1795943800302165F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.antennaeLeft.offsetX, this.antennaeLeft.offsetY, this.antennaeLeft.offsetZ);
        GlStateManager.translate(this.antennaeLeft.rotationPointX * f5, this.antennaeLeft.rotationPointY * f5, this.antennaeLeft.rotationPointZ * f5);
        GlStateManager.scale(0.1D, 1.0D, 1.0D);
        GlStateManager.translate(-this.antennaeLeft.offsetX, -this.antennaeLeft.offsetY, -this.antennaeLeft.offsetZ);
        GlStateManager.translate(-this.antennaeLeft.rotationPointX * f5, -this.antennaeLeft.rotationPointY * f5, -this.antennaeLeft.rotationPointZ * f5);
        this.antennaeLeft.render(f5);
        GlStateManager.popMatrix();
        this.shell.render(f5);
        this.body.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.antennaeRight.offsetX, this.antennaeRight.offsetY, this.antennaeRight.offsetZ);
        GlStateManager.translate(this.antennaeRight.rotationPointX * f5, this.antennaeRight.rotationPointY * f5, this.antennaeRight.rotationPointZ * f5);
        GlStateManager.scale(0.1D, 1.0D, 1.0D);
        GlStateManager.translate(-this.antennaeRight.offsetX, -this.antennaeRight.offsetY, -this.antennaeRight.offsetZ);
        GlStateManager.translate(-this.antennaeRight.rotationPointX * f5, -this.antennaeRight.rotationPointY * f5, -this.antennaeRight.rotationPointZ * f5);
        this.antennaeRight.render(f5);
        GlStateManager.popMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}