package projectvibrantjourneys.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.client.models.ScarecrowModel;
import projectvibrantjourneys.common.entities.passive.ScarecrowEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class ScarecrowRenderer extends MobRenderer<ScarecrowEntity, ScarecrowModel<ScarecrowEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/scarecrow.png");
	
	public ScarecrowRenderer(EntityRendererManager manager) {
		super(manager, new ScarecrowModel<>(), 0.5F);
	}
	
	@Override
	public ResourceLocation getEntityTexture(ScarecrowEntity entity) {
		return TEXTURE;
	}
}
