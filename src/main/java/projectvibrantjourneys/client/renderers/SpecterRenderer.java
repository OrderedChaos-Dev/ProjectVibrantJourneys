package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.AngryGhostModel;
import projectvibrantjourneys.common.entities.SpecterEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class SpecterRenderer extends BipedRenderer<SpecterEntity, AngryGhostModel<SpecterEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/specter.png");
	
	public SpecterRenderer(EntityRendererManager manager) {
		super(manager, new AngryGhostModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(SpecterEntity entity) {
		return TEXTURE;
	}
	
	//this handles transparency - return false for always transparent
	@Override
	protected boolean func_225622_a_(SpecterEntity entity, boolean flag) {
		return false;
	}
}
