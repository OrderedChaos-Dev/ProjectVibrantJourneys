package vibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.tileentities.TileEntityCampfire;
import vibrantjourneys.tileentities.TileEntityChimneyTop;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;

public class PVJTileEntities
{
	public static void initTileEntities()
	{
		if(!PVJConfig.master.disableMysticalGrill)
			GameRegistry.registerTileEntity(TileEntityMysticalGrill.class, new ResourceLocation(Reference.MOD_ID, "mystical_grill"));
		
		if(!PVJConfig.master.disableChimneys)
			GameRegistry.registerTileEntity(TileEntityChimneyTop.class, new ResourceLocation(Reference.MOD_ID, "chimney_top"));
		
		if(!PVJConfig.master.disableLighting)
			GameRegistry.registerTileEntity(TileEntityCampfire.class, new ResourceLocation(Reference.MOD_ID, "campfire"));
	}
}
