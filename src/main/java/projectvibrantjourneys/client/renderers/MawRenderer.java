package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.MawModel;
import projectvibrantjourneys.common.entities.monster.MawEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class MawRenderer extends MobRenderer<MawEntity, MawModel<MawEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/maw.png");
	
	public MawRenderer(EntityRendererManager manager) {
		super(manager, new MawModel<>(), 0.05F);
	}
	
	@Override
	protected void preRenderCallback(MawEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.scale(3.0F, 3.0F, 3.0F);
	}
	
	@Override
	protected void applyRotations(MawEntity entity, MatrixStack matrixstack, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entity, matrixstack, ageInTicks, rotationYaw, partialTicks);
		if(entity.getAttachmentFace() == Direction.UP) {
			matrixstack.translate(0.0D, (double)(entity.getHeight() + 0.1F), 0.0D);
			matrixstack.rotate(Vector3f.ZP.rotationDegrees(180.0F));
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(MawEntity entity) {
		return TEXTURE;
	}
}
