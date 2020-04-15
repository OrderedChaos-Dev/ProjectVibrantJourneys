package projectvibrantjourneys.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;

public class GhostModel<T extends MobEntity> extends BipedModel<T> {
	public GhostModel() {
		this(0.0F, false);
	}

	public GhostModel(float modelSize, boolean bool) {
		super(modelSize, 0.0F, 64, bool ? 32 : 64);
		this.bipedLeftLeg.showModel = false;
		this.bipedRightLeg.showModel = false;
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
		float f2 = -(float) Math.PI / 2.00F;
		this.bipedRightArm.rotateAngleX = f2;
		this.bipedLeftArm.rotateAngleX = f2;
		this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
	//set transparency
	@Override
	public void render(MatrixStack stack, IVertexBuilder vertexbuilder, int light, int overlay, float r, float g, float b, float a) {
		float transparency = 0.5F;
		this.getBodyParts().forEach((renderer) -> {
			renderer.render(stack, vertexbuilder, light, overlay, r, g, b, transparency);
		});
		this.getBodyParts().forEach((renderer) -> {
			renderer.render(stack, vertexbuilder, light, overlay, r, g, b, transparency);
		});
	}
}