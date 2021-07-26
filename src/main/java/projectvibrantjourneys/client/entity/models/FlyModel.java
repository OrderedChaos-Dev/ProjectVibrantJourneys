package projectvibrantjourneys.client.entity.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelPart;
import net.minecraft.entity.Entity;

public class FlyModel<T extends Entity> extends SegmentedModel<T>
{
    public ModelPart body;

    public FlyModel()
    {
    	super();
        this.texWidth = 1;
        this.texHeight = 1;
        this.body = new ModelPart(this, 0, 0);
        this.body.setPos(0.0F, 32.5F, 0F);
        this.body.addBox(0.0F, -10.0F, 0.0F, 1, 1, 1, 0.0F);
    }

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.body);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	
	}
}