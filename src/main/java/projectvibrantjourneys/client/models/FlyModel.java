package projectvibrantjourneys.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlyModel<T extends Entity> extends SegmentedModel<T>
{
    public ModelRenderer body;

    public FlyModel()
    {
    	super();
        this.textureWidth = 1;
        this.textureHeight = 1;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 32.5F, 0F);
        this.body.func_228301_a_(0.0F, -10.0F, 0.0F, 1, 1, 1, 0.0F);
    }

	@Override
	public Iterable<ModelRenderer> func_225601_a_() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void func_225597_a_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
}