package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClam extends ModelBase
{
    public ModelRenderer bottom;
    public ModelRenderer top;
    public ModelRenderer pearl;

    public ModelClam()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.pearl = new ModelRenderer(this, 0, 0);
        this.pearl.setRotationPoint(-0.9F, 21.0F, -0.8F);
        this.pearl.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bottom = new ModelRenderer(this, 0, 0);
        this.bottom.setRotationPoint(-0.5F, 19.6F, 1.2F);
        this.bottom.addBox(-3.3F, 0.0F, -2.5F, 7, 2, 5, 0.0F);
        this.setRotateAngle(bottom, -0.5462880558742251F, 0.0F, 0.0F);
        this.top = new ModelRenderer(this, 0, 0);
        this.top.setRotationPoint(-0.2F, 22.0F, 0.0F);
        this.top.addBox(-3.6F, 0.0F, -2.5F, 7, 2, 5, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
        this.pearl.render(f5);
        this.bottom.render(f5);
        this.top.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
