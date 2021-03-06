package projectvibrantjourneys.client.entity.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FrogModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer limbs;
	private final ModelRenderer eyes;
	private final ModelRenderer body;

	public FrogModel() {
        this.texWidth = 64;
        this.texHeight = 32;

		limbs = new ModelRenderer(this);
		limbs.setPos(0.0F, 24.0F, 0.0F);
		limbs.texOffs(0, 9).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		limbs.texOffs(0, 13).addBox(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		limbs.texOffs(16, 9).addBox(-2.0F, -2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		limbs.texOffs(16, 12).addBox(1.0F, -2.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setPos(-1.5F, -3.5F, -3.5F);
		limbs.addChild(eyes);
		setRotationAngle(eyes, -0.1309F, 0.0F, 0.0F);
		eyes.texOffs(20, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		eyes.texOffs(20, 2).addBox(2.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, -1.0F, 0.0F);
		limbs.addChild(body);
		setRotationAngle(body, -0.2182F, 0.0F, 0.0F);
		body.texOffs(0, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 2.0F, 7.0F, 0.0F, false);
	}
	
	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.limbs);
	}
	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}