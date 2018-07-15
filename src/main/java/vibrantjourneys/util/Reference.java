package vibrantjourneys.util;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Reference
{
    public static final String MOD_ID = "pvj";
    public static final String NAME = "Project: Vibrant Journeys";
    public static final String VERSION = "1.0.0";
    public static final String CLIENT = "vibrantjourneys.ClientProxy";
    public static final String SERVER = "vibrantjourneys.CommonProxy";
    
    public static final Biome[] ALL_BIOMES = ForgeRegistries.BIOMES.getValuesCollection().toArray(new Biome[0]);
}
