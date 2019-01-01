package vibrantjourneys.entities.renderer.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStarfish extends ModelBase {
    public ModelRenderer body1;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer body5;

    public ModelStarfish()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body2 = new ModelRenderer(this, 0, 0);
        this.body2.setRotationPoint(0.0F, 22.899999618530273F, -0.30000001192092896F);
        this.body2.addBox(-0.5F, 0.0F, -3.9000000953674316F, 1, 1, 4, 0.0F);
        this.setRotateAngle(body2, 0.0F, -2.2764329910278316F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 0);
        this.body3.setRotationPoint(0.0F, 22.899999618530273F, -0.20000000298023224F);
        this.body3.addBox(-0.6000000238418579F, 0.0F, -2.700000047683716F, 1, 1, 3, 0.0F);
        this.setRotateAngle(body3, 0.0F, 1.5707963705062866F, 0.0F);
        this.body1 = new ModelRenderer(this, 0, 0);
        this.body1.setRotationPoint(0.0F, 22.899999618530273F, -0.20000000298023224F);
        this.body1.addBox(0.0F, 0.0F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(body1, 0.0F, 0.13665927946567535F, 0.0F);
        this.body5 = new ModelRenderer(this, 0, 0);
        this.body5.setRotationPoint(0.9F, 22.9F, -0.1F);
        this.body5.addBox(0.0F, 0.0F, -3.2F, 1, 1, 3, 0.0F);
        this.setRotateAngle(body5, 0.0F, 2.9140017191297325F, 0.0F);
        this.body4 = new ModelRenderer(this, 0, 0);
        this.body4.setRotationPoint(0.0F, 22.899999618530273F, -0.20000000298023224F);
        this.body4.addBox(-0.4000000059604645F, 0.0F, -3.9000000953674316F, 1, 1, 4, 0.0F);
        this.setRotateAngle(body4, 0.0F, -0.9560913443565369F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body5.render(f5);
        this.body3.render(f5);
        this.body4.render(f5);
        this.body1.render(f5);
        this.body2.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
