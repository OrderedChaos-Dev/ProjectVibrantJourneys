package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.common.blocks.HollowLogBlock;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class PVJBlockLootProvider extends BlockLootSubProvider {

  private HashSet<Block> knownBlocks = new HashSet<>();

  protected PVJBlockLootProvider() {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  }

  private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);

  @Override
  protected void generate() {
    dropSelf(PVJBlocks.BEACH_GRASS.get());
    dropSelf(PVJBlocks.BARK_MUSHROOM.get());
    dropSelf(PVJBlocks.ORANGE_BARK_MUSHROOM.get());
    dropSelf(PVJBlocks.LIGHT_BROWN_BARK_MUSHROOM.get());
    dropSelf(PVJBlocks.GLOWING_BLUE_FUNGUS.get());
    dropSelf(PVJBlocks.SMALL_CACTUS.get());
    dropSelf(PVJBlocks.REEDS.get());
    dropSelf(PVJBlocks.ICICLE.get());
    dropSelf(PVJBlocks.CATTAIL.get());
    dropSelf(PVJBlocks.SEA_OATS.get());
    dropSelf(PVJBlocks.GLOWCAP.get());
    dropSelf(PVJBlocks.WARPED_NETTLE.get());
    dropSelf(PVJBlocks.CRIMSON_NETTLE.get());
    dropSelf(PVJBlocks.CINDERCANE.get());
    dropSelf(PVJBlocks.PINK_LOTUS.get());

    hollowLog(PVJBlocks.OAK_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.BIRCH_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.SPRUCE_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.JUNGLE_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.ACACIA_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.DARK_OAK_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.CHERRY_HOLLOW_LOG.get());
    hollowLog(PVJBlocks.MANGROVE_HOLLOW_LOG.get());

    dropPottedContents(PVJBlocks.POTTED_GLOWCAP.get());
    dropPottedContents(PVJBlocks.POTTED_CRIMSON_NETTLE.get());
    dropPottedContents(PVJBlocks.POTTED_WARPED_NETTLE.get());
    dropPottedContents(PVJBlocks.POTTED_CINDERCANE.get());
    dropPottedContents(PVJBlocks.POTTED_SMALL_CACTUS.get());
    dropPottedContents(PVJBlocks.POTTED_PRICKLY_BUSH.get());

    doublePlant(PVJBlocks.CATTAIL.get());
    doublePlant(PVJBlocks.SEA_OATS.get());
    doublePlant(PVJBlocks.REEDS.get());

    dropWhenSilkTouch(PVJBlocks.ICICLE.get());
    dropWhenSilkTouch(PVJBlocks.ROCKS.get());
    dropWhenSilkTouch(PVJBlocks.MOSSY_ROCKS.get());
    dropWhenSilkTouch(PVJBlocks.SANDSTONE_ROCKS.get());
    dropWhenSilkTouch(PVJBlocks.RED_SANDSTONE_ROCKS.get());
    dropWhenSilkTouch(PVJBlocks.ICE_CHUNKS.get());
    dropWhenSilkTouch(PVJBlocks.PINECONES.get());

    dropOther(PVJBlocks.BEACHED_KELP.get(), Items.KELP);
    dropOther(PVJBlocks.DRIED_BEACHED_KELP.get(), Items.DRIED_KELP);

    add(PVJBlocks.BONES.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.BONE))));
    add(PVJBlocks.CHARRED_BONES.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.BONE))));
    add(PVJBlocks.TWIGS.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK))));

    add(PVJBlocks.PINK_VINES.get(), BlockLootSubProvider::createShearsOnlyDrop);
    add(PVJBlocks.PINK_VINES_PLANT.get(), block -> LootTable.lootTable()
      .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_SHEARS).add(LootItem.lootTableItem(PVJBlocks.PINK_VINES.get()))));

    add(PVJBlocks.SLIME_NODULE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Items.SLIME_BALL));

    add(PVJBlocks.YELLOW_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.YELLOW_WILDFLOWERS.get()));
    add(PVJBlocks.ORANGE_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.ORANGE_WILDFLOWERS.get()));
    add(PVJBlocks.BLUE_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.BLUE_WILDFLOWERS.get()));
    add(PVJBlocks.PURPLE_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.PURPLE_WILDFLOWERS.get()));
    add(PVJBlocks.WHITE_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.WHITE_WILDFLOWERS.get()));
    add(PVJBlocks.MIXED_WILDFLOWERS.get(), this.createPetalsDrops(PVJBlocks.MIXED_WILDFLOWERS.get()));

    shearsOrSilkTouch(PVJBlocks.FALLEN_LEAVES.get());
    shearsOrSilkTouch(PVJBlocks.DEAD_FALLEN_LEAVES.get());
    shearsOrSilkTouch(PVJBlocks.SANDY_SPROUTS.get());

    add(PVJBlocks.NATURAL_COBWEB.get(), (block) -> createSilkTouchOrShearsDispatchTable(Blocks.COBWEB, this.applyExplosionCondition(Blocks.COBWEB, LootItem.lootTableItem(Items.STRING))));
    add(PVJBlocks.PRICKLY_BUSH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
    add(PVJBlocks.SHORT_GRASS.get(), this::createGrassDrops);
    add(PVJBlocks.WATERGRASS.get(), block -> watergrass(block, block));

    add(PVJBlocks.SEASHELLS.get(), (block) -> LootTable.lootTable()
      .withPool(
        LootPool.lootPool()
          .setRolls(ConstantValue.exactly(1.0F))
          .add(applyExplosionDecay(block,
            LootItem.lootTableItem(Items.PRISMARINE_SHARD)
              .when(LootItemRandomChanceCondition.randomChance(0.125F))))));

    add(
      PVJBlocks.FERROUS_GRAVEL.get(),
      block -> createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT)
          .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F))
          .otherwise(LootItem.lootTableItem(Blocks.GRAVEL)))
      ).withPool(
        LootPool.lootPool()
          .when(HAS_NO_SILK_TOUCH)
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.RAW_IRON).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
      )
    );
    add(
      PVJBlocks.GILDED_GRAVEL.get(),
      block -> createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Items.FLINT)
          .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F))
          .otherwise(LootItem.lootTableItem(Blocks.GRAVEL)))
      ).withPool(
        LootPool.lootPool()
          .when(HAS_NO_SILK_TOUCH)
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.RAW_GOLD).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
      )
    );
    add(
      PVJBlocks.GILDED_RED_SAND.get(),
      block -> createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Items.RED_SAND))
      ).withPool(
        LootPool.lootPool()
          .when(HAS_NO_SILK_TOUCH)
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.RAW_GOLD).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))
      )
    );
    add(
      PVJBlocks.MUDDY_BONES.get(),
      block -> this.createSilkTouchDispatchTable(block,
        this.applyExplosionCondition(block, LootItem.lootTableItem(Blocks.MUD))
      ).withPool(
        LootPool.lootPool()
          .when(HAS_NO_SILK_TOUCH)
          .add(
            this.applyExplosionCondition(block,
              LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
      )
    );
  }

  private void doublePlant(Block plant) {
    add(plant, (block) -> {
      return createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
    });
  }

  private void shearsOrSilkTouch(Block block) {
    add(block, (b) -> {
      return LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SHEARS_OR_SILK_TOUCH).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(b)));
    });
  }

  private void hollowLog(Block hollowLog) {
    add(hollowLog, (block) -> {
      return LootTable.lootTable()
        .withPool(
          this.applyExplosionCondition(
            block,
            LootPool.lootPool()
              .setRolls(ConstantValue.exactly(1.0F))
              .add(LootItem.lootTableItem(block))))
        .withPool(
          this.applyExplosionCondition(
            block,
            LootPool.lootPool()
              .setRolls(ConstantValue.exactly(1.0F))
              .add(LootItem.lootTableItem(Items.MOSS_CARPET))
              .when(LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                  .hasProperty(HollowLogBlock.MOSSY, true)))
          )
        );
    });
  }

  protected LootTable.Builder watergrass(Block p_248590_, Block p_248735_) {
    LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(p_248735_).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(p_248590_, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
    return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0))));
  }

  @Override
  protected void add(Block block, LootTable.Builder builder) {
    super.add(block, builder);
    knownBlocks.add(block);
  }

  @Override
  protected HashSet<Block> getKnownBlocks() {
    return knownBlocks;
  }
}
