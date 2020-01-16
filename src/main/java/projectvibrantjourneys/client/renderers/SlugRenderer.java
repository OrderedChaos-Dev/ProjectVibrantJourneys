package projectvibrantjourneys.client.renderers;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.SlugModel;
import projectvibrantjourneys.common.entities.passive.SlugEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class SlugRenderer extends MobRenderer<SlugEntity, SlugModel<SlugEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/snail/snail_0.png");
	
	public SlugRenderer(EntityRendererManager manager) {
		super(manager, new SlugModel<>(), 0.05F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(SlugEntity entity) {
		return TEXTURE;
	}
	
	@Override
	protected void func_225620_a_(SlugEntity entity, MatrixStack matrixstack, float p_225620_3_) {
		matrixstack.func_227862_a_(0.3F, 0.3F, 0.3F);
	}
}
