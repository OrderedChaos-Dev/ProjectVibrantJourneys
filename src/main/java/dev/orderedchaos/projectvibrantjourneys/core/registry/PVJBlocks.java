package dev.orderedchaos.projectvibrantjourneys.core.registry;

import dev.orderedchaos.projectvibrantjourneys.common.blocks.*;
import dev.orderedchaos.projectvibrantjourneys.core.ProjectVibrantJourneys;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class PVJBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectVibrantJourneys.MOD_ID);

    /* OVERWORLD FLORA */
    public static final RegistryObject<Block> BEACH_GRASS = BLOCKS.register("beach_grass",
            () -> new BeachGrassBlock(replaceablePlant(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> SEA_OATS = BLOCKS.register("sea_oats",
            () -> new SeaOatsBlock(replaceablePlant(MapColor.SAND)));
    public static final RegistryObject<Block> CATTAIL = BLOCKS.register("cattail",
            () -> new DoubleHighWaterPlantBlock(replaceablePlant(null)));
    public static final RegistryObject<Block> BARK_MUSHROOM = BLOCKS.register("bark_mushroom",
            () -> new BarkMushroomBlock(barkMushroom()));
    public static final RegistryObject<Block> LIGHT_BROWN_BARK_MUSHROOM = BLOCKS.register("light_brown_bark_mushroom",
            () -> new BarkMushroomBlock(barkMushroom()));
    public static final RegistryObject<Block> ORANGE_BARK_MUSHROOM = BLOCKS.register("orange_bark_mushroom",
            () -> new BarkMushroomBlock(barkMushroom()));
    public static final RegistryObject<Block> GLOWING_BLUE_FUNGUS = BLOCKS.register("glowing_blue_fungus",
            () -> new GlowingFungusBlock(barkMushroom().lightLevel((state) -> 6).sound(SoundType.SMALL_DRIPLEAF).emissiveRendering((state, level, pos) -> true)));
    public static final RegistryObject<Block> SHORT_GRASS = BLOCKS.register("short_grass",
            () -> new ShortGrassBlock(replaceablePlant(null)));
    public static final RegistryObject<Block> SMALL_CACTUS = BLOCKS.register("small_cactus",
            () -> new SmallCactusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().ignitedByLava().pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> PRICKLY_BUSH = BLOCKS.register("prickly_bush",
            () -> new ThornsBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> REEDS = BLOCKS.register("reeds",
            () -> new DoubleHighWaterPlantBlock(replaceablePlant(null)));
    public static final RegistryObject<Block> ICICLE = BLOCKS.register("icicle",
            () -> new IcicleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).noOcclusion().sound(SoundType.GLASS).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ)));

    /* NETHER FLORA */
    public static final RegistryObject<Block> CRIMSON_NETTLE = BLOCKS.register("crimson_nettle",
            () -> new NetherPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WARPED_NETTLE = BLOCKS.register("warped_nettle",
            () -> new NetherPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CINDERCANE = BLOCKS.register("cindercane",
            () -> new CindercaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).noCollission().randomTicks().instabreak().sound(SoundType.TWISTING_VINES).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GLOWCAP = BLOCKS.register("glowcap",
            () -> new GlowcapBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).lightLevel((state) -> 12).pushReaction(PushReaction.DESTROY)));

    /* GROUNDCOVER */
    public static final RegistryObject<Block> FALLEN_LEAVES = BLOCKS.register("fallen_leaves",
            () -> new FallenLeavesBlock(Block.Properties.of().mapColor(MapColor.GRASS).noCollission().strength(0.1F, 0.0F).ignitedByLava().sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DEAD_FALLEN_LEAVES = BLOCKS.register("dead_fallen_leaves",
            () -> new FallenLeavesBlock(Block.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.1F, 0.0F).ignitedByLava().sound(SoundType.GRASS).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TWIGS = BLOCKS.register("twigs",
            () -> new GroundcoverBlock(groundcover(SoundType.CROP, true)));
    public static final RegistryObject<Block> ROCKS = BLOCKS.register("rocks",
            () -> new GroundcoverBlock(groundcover(SoundType.STONE, false)));
    public static final RegistryObject<Block> MOSSY_ROCKS = BLOCKS.register("mossy_rocks",
            () -> new GroundcoverBlock(groundcover(SoundType.STONE, false)));
    public static final RegistryObject<Block> SANDSTONE_ROCKS = BLOCKS.register("sandstone_rocks",
            () -> new GroundcoverBlock(groundcover(SoundType.STONE, false)));
    public static final RegistryObject<Block> RED_SANDSTONE_ROCKS = BLOCKS.register("red_sandstone_rocks",
            () -> new GroundcoverBlock(groundcover(SoundType.STONE, false)));
    public static final RegistryObject<Block> ICE_CHUNKS = BLOCKS.register("ice_chunks",
            () -> new GroundcoverBlock(groundcover(SoundType.GLASS, false)));
    public static final RegistryObject<Block> BONES = BLOCKS.register("bones",
            () -> new GroundcoverBlock(groundcover(SoundType.BONE_BLOCK, false)));
    public static final RegistryObject<Block> CHARRED_BONES = BLOCKS.register("charred_bones",
            () -> new GroundcoverBlock(groundcover(SoundType.BONE_BLOCK, false)));
    public static final RegistryObject<Block> PINECONES = BLOCKS.register("pinecones",
            () -> new GroundcoverBlock(groundcover(SoundType.CROP, true)));
    public static final RegistryObject<Block> SEASHELLS = BLOCKS.register("seashells",
            () -> new GroundcoverBlock(groundcover(SoundType.STONE, false)));

    /* MISC */
    public static final RegistryObject<Block> NATURAL_COBWEB = BLOCKS.register("natural_cobweb",
            NaturalCobwebBlock::new);

    public static final RegistryObject<Block> OAK_HOLLOW_LOG = BLOCKS.register("oak_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BIRCH_HOLLOW_LOG = BLOCKS.register("birch_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));
    public static final RegistryObject<Block> SPRUCE_HOLLOW_LOG = BLOCKS.register("spruce_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> JUNGLE_HOLLOW_LOG = BLOCKS.register("jungle_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> ACACIA_HOLLOW_LOG = BLOCKS.register("acacia_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG)));
    public static final RegistryObject<Block> DARK_OAK_HOLLOW_LOG = BLOCKS.register("dark_oak_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG)));

    public static final RegistryObject<Block> POTTED_GLOWCAP = BLOCKS.register("potted_glowcap",
            () -> createFlowerPot(GLOWCAP.get()));
    public static final RegistryObject<Block> POTTED_CRIMSON_NETTLE = BLOCKS.register("potted_crimson_nettle",
            () -> createFlowerPot(CRIMSON_NETTLE.get()));
    public static final RegistryObject<Block> POTTED_WARPED_NETTLE = BLOCKS.register("potted_warped_nettle",
            () -> createFlowerPot(WARPED_NETTLE.get()));
    public static final RegistryObject<Block> POTTED_CINDERCANE = BLOCKS.register("potted_cindercane",
            () -> createFlowerPot(CINDERCANE.get()));
    public static final RegistryObject<Block> POTTED_SMALL_CACTUS = BLOCKS.register("potted_small_cactus",
            () -> createFlowerPot(SMALL_CACTUS.get()));
    public static final RegistryObject<Block> POTTED_PRICKLY_BUSH = BLOCKS.register("potted_prickly_bush",
            () -> createFlowerPot(PRICKLY_BUSH.get()));

    private static BlockBehaviour.Properties replaceablePlant(@Nullable MapColor mapColorOverride) {
        return Block.Properties.of()
                .replaceable()
                .mapColor(mapColorOverride != null ? mapColorOverride : MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XYZ)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties barkMushroom() {
        return Block.Properties.of()
                .noCollission()
                .instabreak()
                .sound(SoundType.WOOD)
                .destroyTime(0.2F);
    }

    private static BlockBehaviour.Properties groundcover(SoundType soundType, boolean isFlammable) {
        BlockBehaviour.Properties groundcover = Block.Properties.of()
                .strength(0.05F, 0.0F)
                .noOcclusion()
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY)
                .sound(soundType);

        if(isFlammable) {
            groundcover = groundcover.ignitedByLava();
        }

        return groundcover;
    }

    public static Block createFlowerPot(Block plant) {
        Block block = new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).lightLevel((state) -> plant == GLOWCAP.get() ? 12 : 0));
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(plant), () -> block);
        return block;
    }
}