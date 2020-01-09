package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.FlyModel;
import projectvibrantjourneys.common.entities.passive.FlyEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class FlyRenderer extends MobRenderer<FlyEntity, FlyModel<FlyEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/fly.png");
	
	public FlyRenderer(EntityRendererManager manager) {
		super(manager, new FlyModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(FlyEntity entity) {
		return TEXTURE;
	}
}
