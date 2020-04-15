package projectvibrantjourneys.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ScarecrowModel<T extends Entity> extends SegmentedModel<T> {
	
	private final ModelRenderer scarecrow;
	
	public ScarecrowModel() {
		textureWidth = 64;
		textureHeight = 64;

		scarecrow = new ModelRenderer(this);
		scarecrow.setRotationPoint(0.0F, 24.0F, 0.0F);
		scarecrow.addBox("body", -5.0F, -29.0F, -3.0F, 10, 13, 6, 0.0F, 0, 36);
		scarecrow.addBox("stick", -1.0F, -29.0F, -1.0F, 2, 29, 2, 0.0F, 0, 0);
		scarecrow.addBox("arms", -12.0F, -28.0F, -1.0F, 24, 2, 2, 0.0F, 9, 0);
		scarecrow.addBox("head", -5.0F, -39.0F, -5.0F, 10, 10, 10, 0.0F, 13, 5);
		scarecrow.addBox("body_arms", -11.0F, -29.0F, -2.0F, 22, 4, 4, 0.0F, 12, 25);
	}
	
	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.scarecrow);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}