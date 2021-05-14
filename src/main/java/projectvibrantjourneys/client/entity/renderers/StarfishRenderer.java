package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.entity.models.StarfishModel;
import projectvibrantjourneys.common.entities.StarfishEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class StarfishRenderer extends MobRenderer<StarfishEntity, StarfishModel<StarfishEntity>> {

	public StarfishRenderer(EntityRendererManager manager) {
		super(manager, new StarfishModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(StarfishEntity entity) {
		int color = entity.getColor();
		return new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_" + color + ".png");
	}
}