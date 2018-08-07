package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements ICommonProxy
{
	@Override
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory)
	{
		RenderingRegistry.registerEntityRenderingHandler(entity, factory);
	}
	
	@Override
	public void registerItemRenderer(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, resource);
	}
	
	@Override
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties)
	{
		IStateMapper mapper = (new StateMap.Builder()).ignore(properties).build();
		ModelLoader.setCustomStateMapper(Block.getBlockFromItem(item), mapper);
	}

	@Override
	public void registerWorldGenerator(IWorldGenerator worldgen)
	{
		GameRegistry.registerWorldGenerator(worldgen, 0);
	}
	
	@Override
	public void registerBlockColor(IBlockColor iblockcolor, Block block)
	{
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(iblockcolor, block);
	}
	
	@Override
	public void registerItemColor(IItemColor iitemcolor, Item item)
	{
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(iitemcolor, item);
	}
}