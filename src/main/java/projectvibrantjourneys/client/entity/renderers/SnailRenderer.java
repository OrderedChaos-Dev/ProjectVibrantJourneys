package projectvibrantjourneys.client.entity.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.SnailModel;
import projectvibrantjourneys.common.entities.SnailEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {
	
	public SnailRenderer(EntityRendererManager manager) {
		super(manager, new SnailModel<>(), 0.01F);
	}
	
	@Override
	protected void scale(SnailEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.scale(0.3F, 0.3F, 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(SnailEntity entity) {
		int color = entity.getColor();
		return new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/snail/snail_" + color + ".png");
	}
}