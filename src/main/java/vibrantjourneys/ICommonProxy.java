package vibrantjourneys;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.IWorldGenerator;

public interface ICommonProxy
{
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory);
	
	public void registerItemRenderer(Item item, String name);
	
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource);
	
	public void registerWorldGenerator(IWorldGenerator worldgen);
}
