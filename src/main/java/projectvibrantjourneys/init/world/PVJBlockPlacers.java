package projectvibrantjourneys.init.world;

import java.lang.reflect.Constructor;

import com.mojang.serialization.Codec;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import projectvibrantjourneys.common.world.features.blockplacers.GroundcoverPlacer;
import projectvibrantjourneys.common.world.features.blockplacers.RocksBlockPlacer;
import projectvibrantjourneys.common.world.features.blockstateproviders.ShortGrassBlockStateProvider;
import projectvibrantjourneys.common.world.features.foliageplacers.BaobabFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.PalmFoliagePlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.BaobabTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.MangroveTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.PalmTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.RedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.SmallRedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.WillowTrunkPlacer;
import projectvibrantjourneys.core.ProjectVibrantJourneys;

@Mod.EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID)
public class PVJBlockPlacers {

	public static final TrunkPlacerType<SmallRedwoodTrunkPlacer> SMALL_REDWOOD_TRUNK_PLACER = registerTrunkPlacer("small_redwood_trunk_placer", SmallRedwoodTrunkPlacer.CODEC);
	public static final TrunkPlacerType<RedwoodTrunkPlacer> REDWOOD_TRUNK_PLACER = registerTrunkPlacer("small_redwood_trunk_placer", RedwoodTrunkPlacer.CODEC);
	public static final TrunkPlacerType<MangroveTrunkPlacer> MANGROVE_TRUNK_PLACER = registerTrunkPlacer("mangrove_trunk_placer", MangroveTrunkPlacer.CODEC);
	public static final TrunkPlacerType<WillowTrunkPlacer> WILLOW_TRUNK_PLACER = registerTrunkPlacer("willow_trunk_placer", WillowTrunkPlacer.CODEC);
	public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = registerTrunkPlacer("palm_trunk_placer", PalmTrunkPlacer.CODEC);
	public static final TrunkPlacerType<BaobabTrunkPlacer> BAOBAB_TRUNK_PLACER = registerTrunkPlacer("baobab_trunk_placer", BaobabTrunkPlacer.CODEC);
	
	public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = registerFoliagePlacer("palm_foliage_placer", new FoliagePlacerType<PalmFoliagePlacer>(PalmFoliagePlacer.CODEC));
	public static final FoliagePlacerType<BaobabFoliagePlacer> BAOBAB_FOLIAGE_PLACER = registerFoliagePlacer("baobab_foliage_placer", new FoliagePlacerType<BaobabFoliagePlacer>(BaobabFoliagePlacer.CODEC));
	
	public static final BlockStateProviderType<ShortGrassBlockStateProvider> SHORT_GRASS_BLOCK_STATE_PROVIDER = registerBlockStateProvider("short_grass_block_state_provider", new BlockStateProviderType<ShortGrassBlockStateProvider>(ShortGrassBlockStateProvider.CODEC));
	
	public static final BlockPlacerType<RocksBlockPlacer> ROCKS_BLOCK_PLACER = registerBlockPlacer("rocks_block_placer", new BlockPlacerType<RocksBlockPlacer>(RocksBlockPlacer.CODEC));
	public static final BlockPlacerType<GroundcoverPlacer> GROUNDCOVER_PLACER = registerBlockPlacer("groundcover_placer", new BlockPlacerType<GroundcoverPlacer>(GroundcoverPlacer.CODEC));
	
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
	
	private static <P extends BlockStateProvider> BlockStateProviderType<P> registerBlockStateProvider(String key, BlockStateProviderType<P> type) {
		type.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key));
		ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES.register(type);
		return type;
	}
	
	private static <P extends BlockPlacer> BlockPlacerType<P> registerBlockPlacer(String key, BlockPlacerType<P> type) {
		type.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key));
		ForgeRegistries.BLOCK_PLACER_TYPES.register(type);
		return type;
	}
}
