package vibrantjourneys.entities.passive;

import net.minecraft.world.World;

/**
 * Placeholder entity used for special spawn conditions
 *
 */
public class EntityPlaceholder extends EntityPVJAnimal
{
	public EntityPlaceholder(World world)
	{
		super(world);
		this.setSize(0.1F,  0.1F);
	}
}
