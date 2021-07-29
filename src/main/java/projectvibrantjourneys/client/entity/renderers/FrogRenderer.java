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

	private static final ResourceLocation TEXTURE_0 = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/frog_0.png");
	private static final ResourceLocation TEXTURE_1 = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/frog_1.png");
	private static final ResourceLocation TEXTURE_2 = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/frog_2.png");
	private static final ResourceLocation TEXTURE_3 = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/frog_3.png");
	private static final ResourceLocation TEXTURE_4 = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/frog_4.png");
	
	public FrogRenderer(EntityRendererManager manager) {
		super(manager, new FrogModel<>(), 0.05F);
	}

	@Override
	public ResourceLocation getTextureLocation(FrogEntity entity) {
		int color = entity.getColor();
		switch(color) {
		case 0:
		default:
			return TEXTURE_0;
		case 1:
			return TEXTURE_1;
		case 2:
			return TEXTURE_2;
		case 3:
			return TEXTURE_3;
		case 4:
			return TEXTURE_4;
	}
	}
}