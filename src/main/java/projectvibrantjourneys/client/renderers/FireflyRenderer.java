package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.FlyModel;
import projectvibrantjourneys.common.entities.FireflyEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class FireflyRenderer extends MobRenderer<FireflyEntity, FlyModel<FireflyEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/firefly.png");
	
	public FireflyRenderer(EntityRendererManager manager) {
		super(manager, new FlyModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(FireflyEntity entity) {
		return TEXTURE;
	}
	
	@Override
	protected int func_225624_a_(FireflyEntity entity, float f) {
		return 15;
	}
}
