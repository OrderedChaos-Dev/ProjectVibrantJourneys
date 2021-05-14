package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.FlyModel;
import projectvibrantjourneys.common.entities.FireflyEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class FireflyRenderer extends MobRenderer<FireflyEntity, FlyModel<FireflyEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/firefly.png");
	
	public FireflyRenderer(EntityRendererManager manager) {
		super(manager, new FlyModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(FireflyEntity entity) {
		return TEXTURE;
	}
	
	@Override
	protected int getBlockLightLevel(FireflyEntity entity, BlockPos pos) {
		return 15;
	}
}