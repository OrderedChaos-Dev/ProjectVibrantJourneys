package projectvibrantjourneys.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class StarfishModel<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer body1;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer body5;

    public StarfishModel()
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

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body1, this.body2, this.body3, this.body4, this.body5);
	}
    
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
}