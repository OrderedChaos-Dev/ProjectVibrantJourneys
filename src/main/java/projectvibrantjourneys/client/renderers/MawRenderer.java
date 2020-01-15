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
	protected void func_225620_a_(MawEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.func_227862_a_(3.0F, 3.0F, 3.0F);
	}
	
	@Override
	protected void func_225621_a_(MawEntity entity, MatrixStack matrixstack, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
		super.func_225621_a_(entity, matrixstack, p_225621_3_, p_225621_4_, p_225621_5_);
		if(entity.getAttachmentFace() == Direction.UP) {
			matrixstack.func_227861_a_(0.0D, (double)(entity.getHeight() + 0.1F), 0.0D);
			matrixstack.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(180.0F));
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(MawEntity entity) {
		return TEXTURE;
	}
}
