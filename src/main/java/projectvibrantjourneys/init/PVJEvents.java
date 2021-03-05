package projectvibrantjourneys.init;

import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.SwordItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.common.world.FeatureManager;

public class PVJEvents {
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.BreakSpeed event) {
		if(event.getState().getBlock() == PVJBlocks.natural_cobweb) {
			Item item = event.getPlayer().getHeldItemMainhand().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setNewSpeed(15.0F);
			}
		}
	}
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.HarvestCheck event) {
		if(event.getTargetBlock().getBlock() == PVJBlocks.natural_cobweb) {
			Item item = event.getPlayer().getHeldItemMainhand().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setCanHarvest(true);
			}
		}
	}
	
	@SubscribeEvent
	public void onBiomeLoad(BiomeLoadingEvent biome) {
		if(biome.getCategory() == Biome.Category.NETHER || biome.getCategory() == Biome.Category.THEEND)
			return;
		
		if(biome.getCategory() == Biome.Category.BEACH)
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> FeatureManager.seaOatsFeature);
	}
}
