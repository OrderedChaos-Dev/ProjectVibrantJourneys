package dev.orderedchaos.projectvibrantjourneys.data;

import dev.orderedchaos.projectvibrantjourneys.common.blocks.HollowLogBlock;
import dev.orderedchaos.projectvibrantjourneys.core.registry.PVJBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class PVJBlockLootProvider extends BlockLootSubProvider {

  private HashSet<Block> knownBlocks = new HashSet<>();

  protected PVJBlockLootProvider() {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags());
  }

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

    add(PVJBlocks.BONES.get(), (block) -> {
      return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.BONE)));
    });
    add(PVJBlocks.CHARRED_BONES.get(), (block) -> {
      return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.BONE)));
    });
    add(PVJBlocks.TWIGS.get(), (block) -> {
      return createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK)));
    });

    add(PVJBlocks.FALLEN_LEAVES.get(), (block) -> {
      return createShearsOnlyDrop(block);
    });
    add(PVJBlocks.DEAD_FALLEN_LEAVES.get(), (block) -> {
      return createShearsOnlyDrop(block);
    });

    add(PVJBlocks.NATURAL_COBWEB.get(), (block) -> {
      return createSilkTouchOrShearsDispatchTable(Blocks.COBWEB, this.applyExplosionCondition(Blocks.COBWEB, LootItem.lootTableItem(Items.STRING)));
    });
    add(PVJBlocks.PRICKLY_BUSH.get(), (block) -> {
      return createShearsDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))));
    });
    add(PVJBlocks.SHORT_GRASS.get(), this::createGrassDrops);


    add(PVJBlocks.SEASHELLS.get(), (block) -> {
      return LootTable.lootTable()
        .withPool(
          LootPool.lootPool()
            .setRolls(ConstantValue.exactly(1.0F))
            .add(applyExplosionDecay(block,
              LootItem.lootTableItem(Items.PRISMARINE_SHARD)
                .when(LootItemRandomChanceCondition.randomChance(0.125F)))));
    });
  }

  private void doublePlant(Block plant) {
    add(plant, (block) -> {
      return createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
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
