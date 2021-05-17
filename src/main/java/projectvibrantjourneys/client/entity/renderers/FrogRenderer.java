package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.FrogModel;
import projectvibrantjourneys.common.entities.FrogEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class FrogRenderer extends MobRenderer<FrogEntity, FrogModel<FrogEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/frog/frog_0.png");
	
	public FrogRenderer(EntityRendererManager manager) {
		super(manager, new FrogModel<>(), 0.05F);
	}

	@Override
	public ResourceLocation getTextureLocation(FrogEntity entity) {
		int color = entity.getColor();
		return new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/frog/frog_" + color + ".png");
	}
}