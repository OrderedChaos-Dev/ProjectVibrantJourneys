package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.AngryGhostModel;
import projectvibrantjourneys.common.entities.WraithEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class WraithRenderer extends BipedRenderer<WraithEntity, AngryGhostModel<WraithEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/wraith.png");
	
	public WraithRenderer(EntityRendererManager manager) {
		super(manager, new AngryGhostModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(WraithEntity entity) {
		return TEXTURE;
	}
	
	//this handles transparency - return false for always transparent
	@Override
	protected boolean func_225622_a_(WraithEntity entity, boolean flag) {
		return false;
	}
}
