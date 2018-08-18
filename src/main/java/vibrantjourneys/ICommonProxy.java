package vibrantjourneys;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public interface ICommonProxy
{	
	public void registerItemRenderer(Item item);
	
	public void registerItemVariantRenderer(Item item, int meta, ModelResourceLocation resource);
	
	public void registerBlockColor(IBlockColor iblockcolor, Block block);
	
	public void registerItemColor(IItemColor iitemcolor, Item item);
	
	public void setIgnoredPropertiesForModel(Item item, IProperty<?>... properties);

	public <T extends TileEntity> void registerTESRs();
	
	public void registerEntityRenderers();
	
	public void registerBlockColors();
}
