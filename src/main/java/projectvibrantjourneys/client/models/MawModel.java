package projectvibrantjourneys.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class MawModel<T extends Entity> extends SegmentedModel<T> {
	public ModelRenderer tongue;
	public ModelRenderer mouth_right;
	public ModelRenderer mouth_left;
	public ModelRenderer root;

	public MawModel() {
		textureWidth = 64;
		textureHeight = 32;

		tongue = new ModelRenderer(this);
		tongue.setRotationPoint(0.0F, 24.0F, 0.0F);
		tongue.func_217178_a("tongue", -0.5F, -25.0F, -0.5F, 1, 25, 1, 0.0F, 60, 0);
		
		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.func_217178_a("root", -0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F, 0, 0);

		mouth_right = new ModelRenderer(this);
		mouth_right.setRotationPoint(2.0F, 23.5F, 0.0F);
		setRotationAngle(mouth_right, 0.0F, 0.0F, -0.3491F);
		mouth_right.func_217178_a("mouth", -2.0F, -0.5F, -4.0F, 4, 1, 8, 0.0F, 36, 0);
		mouth_right.func_217178_a("teeth1", 1.0F, -2.5F, 3.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_right.func_217178_a("teeth2", 1.0F, -2.5F, -2.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_right.func_217178_a("teeth3", 1.0F, -2.5F, 1.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_right.func_217178_a("teeth4", 1.0F, -2.5F, -4.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_right.func_217178_a("teeth5", -1.0F, -2.5F, -4.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_right.func_217178_a("teeth6", -1.0F, -2.5F, 3.0F, 1, 2, 1, 0.0F, 0, 0);

		mouth_left = new ModelRenderer(this);
		mouth_left.setRotationPoint(-2.0F, 23.5F, 0.0F);
		mouth_left.mirror = true;
		setRotationAngle(mouth_left, 0.0F, 0.0F, 0.3491F);
		mouth_left.func_217178_a("mouth", -2.0F, -0.5F, -4.0F, 4, 1, 8, 0.0F, 36, 0);
		mouth_left.func_217178_a("teeth1", -2.0F, -2.5F, 3.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_left.func_217178_a("teeth2", 0.0F, -2.5F, 3.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_left.func_217178_a("teeth3", -2.0F, -2.5F, 1.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_left.func_217178_a("teeth4", -2.0F, -2.5F, -2.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_left.func_217178_a("teeth5", -2.0F, -2.5F, -4.0F, 1, 2, 1, 0.0F, 0, 0);
		mouth_left.func_217178_a("teeth6", 0.0F, -2.5F, -4.0F, 1, 2, 1, 0.0F, 0, 0);
	}
	
	@Override
	public Iterable<ModelRenderer> func_225601_a_() {
		return ImmutableList.of(this.mouth_left, this.mouth_right, this.tongue, this.root);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void func_225597_a_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		setRotationAngle(tongue, (float)Math.abs(Math.sin(headPitch)), 0.0F, (float)MathHelper.sin(ageInTicks * 0.067F) * 0.05F);
		setRotationAngle(mouth_left, 0.0F, 0.0F, Math.max(limbSwingAmount, 0.3491F));
		setRotationAngle(mouth_right, 0.0F, 0.0F, Math.min(-limbSwingAmount, -0.3491F));
	}
}