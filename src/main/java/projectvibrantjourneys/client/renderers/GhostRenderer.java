package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.GhostModel;
import projectvibrantjourneys.common.entities.monster.GhostEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class GhostRenderer extends BipedRenderer<GhostEntity, GhostModel<GhostEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/ghost/ghost.png");
	
	public GhostRenderer(EntityRendererManager manager) {
		super(manager, new GhostModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(GhostEntity entity) {
		return TEXTURE;
	}
	
	//this handles transparency - return false for always transparent
	@Override
	protected boolean isVisible(GhostEntity entity) {
		return false;
	}
}
