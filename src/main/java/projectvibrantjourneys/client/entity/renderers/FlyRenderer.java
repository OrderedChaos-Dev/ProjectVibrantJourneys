package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.FlyModel;
import projectvibrantjourneys.common.entities.FlyEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class FlyRenderer extends MobRenderer<FlyEntity, FlyModel<FlyEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/fly.png");
	
	public FlyRenderer(EntityRendererManager manager) {
		super(manager, new FlyModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(FlyEntity entity) {
		return TEXTURE;
	}
}