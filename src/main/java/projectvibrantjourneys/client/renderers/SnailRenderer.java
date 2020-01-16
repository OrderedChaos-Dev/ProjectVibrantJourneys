package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.SnailModel;
import projectvibrantjourneys.common.entities.passive.SnailEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {
	
	public SnailRenderer(EntityRendererManager manager) {
		super(manager, new SnailModel<>(), 0.01F);
	}
	
	@Override
	protected void func_225620_a_(SnailEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.func_227862_a_(0.3F, 0.3F, 0.3F);
	}

	@Override
	public ResourceLocation getEntityTexture(SnailEntity entity) {
		int color = entity.getColor();
		return new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/snail/snail_" + color + ".png");
	}
}
