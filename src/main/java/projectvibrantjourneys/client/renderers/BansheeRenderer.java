package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.AngryGhostModel;
import projectvibrantjourneys.common.entities.monster.BansheeEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class BansheeRenderer extends BipedRenderer<BansheeEntity, AngryGhostModel<BansheeEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/ghost/banshee.png");
	
	public BansheeRenderer(EntityRendererManager manager) {
		super(manager, new AngryGhostModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(BansheeEntity entity) {
		return TEXTURE;
	}
	
	//this handles transparency - return false for always transparent
	@Override
	protected boolean isVisible(BansheeEntity entity) {
		return false;
	}
}
