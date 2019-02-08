package vibrantjourneys.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.tileentities.TileEntityMysticalGrill;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;

public class PVJTileEntities
{
	public static void initTileEntities()
	{
		if(PVJConfig.master.enableMysticalGrill)
			GameRegistry.registerTileEntity(TileEntityMysticalGrill.class, new ResourceLocation(Reference.MOD_ID, "mystical_grill"));
	}
}
