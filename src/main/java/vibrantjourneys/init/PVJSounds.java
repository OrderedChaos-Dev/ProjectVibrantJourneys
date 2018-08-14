package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import vibrantjourneys.util.Reference;

public class PVJSounds
{
	public static final ArrayList<SoundEvent> SOUND_EVENTS = new ArrayList<SoundEvent>();
	
	public static final SoundEvent FLY_AMBIENT = registerSoundEvent("entity.fly.ambient");

	public static final SoundEvent GHOST_AMBIENT = registerSoundEvent("entity.ghost.ambient");
	public static final SoundEvent GHOST_HURT = registerSoundEvent("entity.ghost.hurt");
	public static final SoundEvent GHOST_DEATH = registerSoundEvent("entity.ghost.death");
	
	public static final SoundEvent GOON_AMBIENT = registerSoundEvent("entity.goon.ambient");
	public static final SoundEvent GOON_HURT = registerSoundEvent("entity.goon.hurt");
	public static final SoundEvent GOON_DEATH = registerSoundEvent("entity.goon.death");
	public static final SoundEvent GOON_PUKE = registerSoundEvent("entity.goon.puke");
	
	
	public static SoundEvent registerSoundEvent(String name)
	{
		ResourceLocation resource = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent sound = new SoundEvent(resource).setRegistryName(resource);
		SOUND_EVENTS.add(sound);
		
		return sound;
	}	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
	{
		IForgeRegistry<SoundEvent> registry = event.getRegistry();
		for(SoundEvent sound : SOUND_EVENTS)
		{
			registry.register(sound);
		}
	}
}
