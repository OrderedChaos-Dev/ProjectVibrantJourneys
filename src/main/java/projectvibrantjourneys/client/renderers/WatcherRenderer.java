package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix3f;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.WatcherLayer;
import projectvibrantjourneys.client.models.WatcherModel;
import projectvibrantjourneys.common.entities.monster.WatcherEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class WatcherRenderer extends MobRenderer<WatcherEntity, WatcherModel<WatcherEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/watcher/watcher.png");
	private static final ResourceLocation BEAM_TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/watcher/watcher_beam.png");
	private static final RenderType BEAM_RENDER = RenderType.getEntityCutoutNoCull(BEAM_TEXTURE);
	
	public WatcherRenderer(EntityRendererManager manager) {
		super(manager, new WatcherModel<>(16), 0.25F);
		this.addLayer(new WatcherLayer<>(this));
	}
	
	@Override
	protected void preRenderCallback(WatcherEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.scale(1.2F, 1.2F, 1.2F);
	}
	
	@Override
	public boolean shouldRender(WatcherEntity livingEntityIn, ClippingHelperImpl camera, double camX, double camY, double camZ) {
		if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
			return true;
		} else {
			if (livingEntityIn.hasTargetedEntity()) {
				LivingEntity livingentity = livingEntityIn.getTargetedEntity();
				if (livingentity != null) {
					Vec3d vec3d = this.getPosition(livingentity, (double) livingentity.getHeight() * 0.5D, 1.0F);
					Vec3d vec3d1 = this.getPosition(livingEntityIn, (double) livingEntityIn.getEyeHeight(), 1.0F);
					return camera.isBoundingBoxInFrustum(
							new AxisAlignedBB(vec3d1.x, vec3d1.y, vec3d1.z, vec3d.x, vec3d.y, vec3d.z));
				}
			}

			return false;
		}
	}

	private Vec3d getPosition(LivingEntity entityLivingBaseIn, double eyeHeight, float ticks) {
		double d0 = MathHelper.lerp((double) ticks, entityLivingBaseIn.lastTickPosX, entityLivingBaseIn.getPosX());
		double d1 = MathHelper.lerp((double) ticks, entityLivingBaseIn.lastTickPosY, entityLivingBaseIn.getPosY()) + eyeHeight;
		double d2 = MathHelper.lerp((double) ticks, entityLivingBaseIn.lastTickPosZ, entityLivingBaseIn.getPosZ());
		return new Vec3d(d0, d1, d2);
	}

	@Override
	public void render(WatcherEntity watcher, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(watcher, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		LivingEntity livingentity = watcher.getTargetedEntity();
		if (livingentity != null) {
			float f = watcher.getAttackAnimationScale(partialTicks);
			float f1 = (float) watcher.world.getGameTime() + partialTicks;
			float f2 = f1 * 0.5F % 1.0F;
			float f3 = watcher.getEyeHeight();
			matrixStackIn.push();
			matrixStackIn.translate(0.0D, (double) f3, 0.0D);
			Vec3d vec3d = this.getPosition(livingentity, (double) livingentity.getHeight() * 0.5D, partialTicks);
			Vec3d vec3d1 = this.getPosition(watcher, (double) f3, partialTicks);
			Vec3d vec3d2 = vec3d.subtract(vec3d1);
			float f4 = (float) (vec3d2.length() + 1.0D);
			vec3d2 = vec3d2.normalize();
			float f5 = (float) Math.acos(vec3d2.y);
			float f6 = (float) Math.atan2(vec3d2.z, vec3d2.x);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees((((float) Math.PI / 2F) - f6) * (180F / (float) Math.PI)));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f5 * (180F / (float) Math.PI)));
			float f7 = f1 * 0.05F * -1.5F;
			float f8 = f * f;
			int r = Math.min(70 + (int) (f8 * 230.0F), 255);
			float f11 = MathHelper.cos(f7 + 2.3561945F) * 0.282F;
			float f12 = MathHelper.sin(f7 + 2.3561945F) * 0.282F;
			float f13 = MathHelper.cos(f7 + ((float) Math.PI / 4F)) * 0.282F;
			float f14 = MathHelper.sin(f7 + ((float) Math.PI / 4F)) * 0.282F;
			float f15 = MathHelper.cos(f7 + 3.926991F) * 0.282F;
			float f16 = MathHelper.sin(f7 + 3.926991F) * 0.282F;
			float f17 = MathHelper.cos(f7 + 5.4977875F) * 0.282F;
			float f18 = MathHelper.sin(f7 + 5.4977875F) * 0.282F;
			float f19 = MathHelper.cos(f7 + (float) Math.PI) * 0.2F;
			float f20 = MathHelper.sin(f7 + (float) Math.PI) * 0.2F;
			float f21 = MathHelper.cos(f7 + 0.0F) * 0.2F;
			float f22 = MathHelper.sin(f7 + 0.0F) * 0.2F;
			float f23 = MathHelper.cos(f7 + ((float) Math.PI / 2F)) * 0.2F;
			float f24 = MathHelper.sin(f7 + ((float) Math.PI / 2F)) * 0.2F;
			float f25 = MathHelper.cos(f7 + ((float) Math.PI * 1.5F)) * 0.2F;
			float f26 = MathHelper.sin(f7 + ((float) Math.PI * 1.5F)) * 0.2F;
			float f29 = -1.0F + f2;
			float f30 = f4 * 2.5F + f29;
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(BEAM_RENDER);
			MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
			Matrix4f matrix4f = matrixstack$entry.getMatrix();
			Matrix3f matrix3f = matrixstack$entry.getNormal();
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f19, f4, f20, r, 10, 10, 0.4999F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f19, 0.0F, f20, r, 10, 10, 0.4999F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f21, 0.0F, f22, r, 10, 10, 0.0F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f21, f4, f22, r, 10, 10, 0.0F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f23, f4, f24, r, 10, 10, 0.4999F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f23, 0.0F, f24, r, 10, 10, 0.4999F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f25, 0.0F, f26, r, 10, 10, 0.0F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f25, f4, f26, r, 10, 10, 0.0F, f30);
			float f31 = 0.0F;
			if (watcher.ticksExisted % 2 == 0) {
				f31 = 0.5F;
			}

			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f11, f4, f12, r, 10, 10, 0.5F, f31 + 0.5F);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f13, f4, f14, r, 10, 10, 1.0F, f31 + 0.5F);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f17, f4, f18, r, 10, 10, 1.0F, f31);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f15, f4, f16, r, 10, 10, 0.5F, f31);
			matrixStackIn.pop();
		}
	}

	private static void func_229108_a_(IVertexBuilder vertexbuilder, Matrix4f matrix4f, Matrix3f matrix3f,
			float x, float y, float z, int red, int green, int blue, float u, float v) {
		vertexbuilder.pos(matrix4f, x, y, z)
				.color(red, green, blue, 255).tex(u, v)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).normal(matrix3f, 0.0F, 1.0F, 0.0F)
				.endVertex();
	}
	
	@Override
	public ResourceLocation getEntityTexture(WatcherEntity entity) {
		return TEXTURE;
	}
}
