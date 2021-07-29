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
	
	private static final ResourceLocation TEXTURE_RED = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_0.png");
	private static final ResourceLocation TEXTURE_DARK_RED = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_1.png");
	private static final ResourceLocation TEXTURE_BROWN = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_2.png");
	private static final ResourceLocation TEXTURE_BLUE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_3.png");
	private static final ResourceLocation TEXTURE_PURPLE = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/starfish/starfish_4.png");

	public StarfishRenderer(EntityRendererManager manager) {
		super(manager, new StarfishModel<>(), 0.0F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(StarfishEntity entity) {
		int color = entity.getColor();
		switch(color) {
			case 0:
			default:
				return TEXTURE_RED;
			case 1:
				return TEXTURE_DARK_RED;
			case 2:
				return TEXTURE_BROWN;
			case 3:
				return TEXTURE_BLUE;
			case 4:
				return TEXTURE_PURPLE;
		}
	}
}