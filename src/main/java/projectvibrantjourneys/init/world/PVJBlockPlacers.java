package projectvibrantjourneys.init.world;

import java.lang.reflect.Constructor;

import com.mojang.serialization.Codec;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.features.foliageplacers.PalmFoliagePlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.SmallRedwoodTrunkPlacer;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJBlockPlacers {

	public static final TrunkPlacerType<SmallRedwoodTrunkPlacer> SMALL_REDWOOD_TRUNK_PLACER = registerTrunkPlacer("small_redwood_trunk_placer", SmallRedwoodTrunkPlacer.CODEC);
//	public static final TrunkPlacerType<RedwoodTrunkPlacer> REDWOOD_TRUNK_PLACER;
	public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = registerFoliagePlacer("palm_foliage_placer", new FoliagePlacerType<PalmFoliagePlacer>(PalmFoliagePlacer.CODEC));
	
	private static <P extends AbstractTrunkPlacer> TrunkPlacerType<P> registerTrunkPlacer(String key, Codec<P> codec) {
		try {
			Constructor<TrunkPlacerType> c = TrunkPlacerType.class.getDeclaredConstructor(Codec.class);
			c.setAccessible(true);
			return Registry.register(Registry.TRUNK_PLACER_TYPES, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key), c.newInstance(codec));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliagePlacer(String key, FoliagePlacerType<P> type) {
		type.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key));
		ForgeRegistries.FOLIAGE_PLACER_TYPES.register(type);
		return type;
	}
}
