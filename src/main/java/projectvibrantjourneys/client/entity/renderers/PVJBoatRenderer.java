package projectvibrantjourneys.client.entity.renderers;

import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.items.PVJBoatEntity;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@OnlyIn(Dist.CLIENT)
public class PVJBoatRenderer extends BoatRenderer {
	private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/fir.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/pine.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/redwood.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/willow.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/mangrove.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/palm.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/aspen.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/juniper.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/cottonwood.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/baobab.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/maple.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/sakura.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/tamarack.png"),
			new ResourceLocation(ProjectVibrantJourneys.MOD_ID, "textures/entity/boat/joshua.png")};

	public PVJBoatRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(BoatEntity entity) {
		return BOAT_TEXTURES[((PVJBoatEntity)entity).getCCBoatType().ordinal()];
	}
}
