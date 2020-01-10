package projectvibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJSoundEvents {
	
	public static SoundEvent entity_fly_ambient;
	
	public static SoundEvent patrick_star;
	
	public static SoundEvent entity_ghost_ambient;
	public static SoundEvent entity_ghost_hurt;
	public static SoundEvent entity_ghost_death;

	@SubscribeEvent
	public static void initSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		entity_fly_ambient = registerSoundEvent("entity.fly.ambient");
		
		patrick_star = registerSoundEvent("entity.starfish.patrick");
		
		entity_ghost_ambient = registerSoundEvent("entity.ghost.ambient");
		entity_ghost_hurt = registerSoundEvent("entity.ghost.hurt");
		entity_ghost_death = registerSoundEvent("entity.ghost.death");
		
	}
	
	public static SoundEvent registerSoundEvent(String name) {
		ResourceLocation resource = new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name);
		SoundEvent event = new SoundEvent(resource).setRegistryName(resource);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
