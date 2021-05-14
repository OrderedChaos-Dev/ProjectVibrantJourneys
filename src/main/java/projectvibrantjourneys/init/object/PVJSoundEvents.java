package projectvibrantjourneys.init.object;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJSoundEvents {

	public static final ArrayList<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();
	
	public static final SoundEvent FLY_AMBIENT = registerSoundEvent("entity.fly.ambient");
	public static final SoundEvent PATRICK_STAR = registerSoundEvent("entity.starfish.patrick");
	
	@SubscribeEvent
	public static void initSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		SOUNDS.forEach((e) -> event.getRegistry().register(e));
	}
	
	public static SoundEvent registerSoundEvent(String name) {
		ResourceLocation resource = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name);
		SoundEvent event = new SoundEvent(resource).setRegistryName(resource);
		SOUNDS.add(event);
		return event;
	}
}
