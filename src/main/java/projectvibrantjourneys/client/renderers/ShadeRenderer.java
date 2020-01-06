package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.GhostModel;
import projectvibrantjourneys.common.entities.ShadeEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class ShadeRenderer extends BipedRenderer<ShadeEntity, GhostModel<ShadeEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/shade.png");
	
	public ShadeRenderer(EntityRendererManager manager) {
		super(manager, new GhostModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ShadeEntity entity) {
		return TEXTURE;
	}
	
	//this handles transparency - return false for always transparent
	@Override
	protected boolean func_225622_a_(ShadeEntity entity, boolean flag) {
		return false;
	}
}
