package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.StarfishModel;
import projectvibrantjourneys.common.entities.passive.StarfishEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class StarfishRenderer extends MobRenderer<StarfishEntity, StarfishModel<StarfishEntity>> {

	public StarfishRenderer(EntityRendererManager manager) {
		super(manager, new StarfishModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(StarfishEntity entity) {
		int color = entity.getColor();
		return new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_" + color + ".png");
	}
}
