package projectvibrantjourneys.client.entity.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import projectvibrantjourneys.common.entities.ClamEntity;

public class ClamModel<T extends Entity> extends HierarchicalModel<T>
{
    public ModelPart bottom;
    public ModelPart top;
    public ModelPart pearl;

    public ClamModel()
    {
        this.texWidth = 64;
        this.texHeight = 32;
        this.pearl = new ModelPart(this, 0, 0);
        this.pearl.setPos(-0.9F, 21.0F, -0.8F);
        this.pearl.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bottom = new ModelPart(this, 0, 0);
        this.bottom.setPos(-0.5F, 19.6F, 1.2F);
        this.bottom.addBox(-3.3F, 0.0F, -2.5F, 7, 2, 5, 0.0F);
        this.setRotateAngle(bottom, -0.5462880558742251F, 0.0F, 0.0F);
        this.top = new ModelPart(this, 0, 0);
        this.top.setPos(-0.2F, 22.0F, 0.0F);
        this.top.addBox(-3.6F, 0.0F, -2.5F, 7, 2, 5, 0.0F);
    }
    
    public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
        ModelPart.xRot = x;
        ModelPart.yRot = y;
        ModelPart.zRot = z;
    }
    
	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.bottom, this.top, this.pearl);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(!((ClamEntity)entity).hasPearl()) {
			this.pearl.visible = false;
		} else {
			this.pearl.visible = true;
		}
	}
}