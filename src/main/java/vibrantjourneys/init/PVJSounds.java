package vibrantjourneys.init;

import java.util.ArrayList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import vibrantjourneys.util.Reference;

public class PVJSounds
{
	public static final ArrayList<SoundEvent> SOUND_EVENTS = new ArrayList<SoundEvent>();
	
	public static final SoundEvent FLY_AMBIENT = registerSoundEvent("entity.pvj_fly.ambient");

	public static final SoundEvent GHOST_AMBIENT = registerSoundEvent("entity.pvj_ghost.ambient");
	public static final SoundEvent GHOST_HURT = registerSoundEvent("entity.pvj_ghost.hurt");
	public static final SoundEvent GHOST_DEATH = registerSoundEvent("entity.pvj_ghost.death");
	
	public static final SoundEvent GOON_AMBIENT = registerSoundEvent("entity.pvj_goon.ambient");
	public static final SoundEvent GOON_HURT = registerSoundEvent("entity.pvj_goon.hurt");
	public static final SoundEvent GOON_DEATH = registerSoundEvent("entity.pvj_goon.death");
	public static final SoundEvent GOON_PUKE = registerSoundEvent("entity.pvj_goon.puke");
	
	public static final SoundEvent DUCK_QUACK = registerSoundEvent("entity.pvj_duck.quack");
	
	public static SoundEvent registerSoundEvent(String name)
	{
		ResourceLocation resource = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent sound = new SoundEvent(resource).setRegistryName(resource);
		SOUND_EVENTS.add(sound);
		
		return sound;
	}
}
