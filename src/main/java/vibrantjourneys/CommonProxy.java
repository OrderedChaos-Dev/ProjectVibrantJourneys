package vibrantjourneys;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CommonProxy
{
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory) {}
	public void registerItemRenderer(Item item) {}
	public void registerItemVariantRenderer(Item item, String name, int meta){}
}
