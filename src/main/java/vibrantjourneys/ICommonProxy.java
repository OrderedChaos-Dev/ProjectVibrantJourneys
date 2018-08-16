package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.IWorldGenerator;

public interface ICommonProxy
{
	public <T extends Entity> void registerEntityRenderer(Class<T> entity, IRenderFactory<? super T> factory);
	
	public void registerItemRenderer(Item item);
	
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource);
	
	public void registerWorldGenerator(IWorldGenerator worldgen);
	
	public void registerBlockColor(IBlockColor iblockcolor, Block block);
	
	public void registerItemColor(IItemColor iitemcolor, Item item);
	
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties);

	<T extends TileEntity> void registerTESR(Class<T> te, TileEntitySpecialRenderer<? super T> tesr);
}
