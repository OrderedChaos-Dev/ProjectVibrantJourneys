package dev.orderedchaos.projectvibrantjourneys.common.mixin;

import dev.orderedchaos.projectvibrantjourneys.common.world.features.ruinednetherportals.RuinedNetherPortalDecorator;
import dev.orderedchaos.projectvibrantjourneys.core.config.PVJConfig;
import dev.orderedchaos.projectvibrantjourneys.util.LevelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.RuinedPortalPiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Function;

@Mixin(RuinedPortalPiece.class)
public abstract class RuinedPortalPieceMixin extends TemplateStructurePiece {

  public RuinedPortalPieceMixin(StructurePieceType type, CompoundTag tag, StructureTemplateManager manager, Function<ResourceLocation, StructurePlaceSettings> settings) {
    super(type, tag, manager, settings);
  }

  @Inject(method = "postProcess",
    at = @At(
      value = "INVOKE",
      target = "Lnet/minecraft/world/level/levelgen/structure/structures/RuinedPortalPiece;addNetherrackDripColumnsBelowPortal(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/LevelAccessor;)V",
      shift = At.Shift.AFTER),
    locals = LocalCapture.CAPTURE_FAILEXCEPTION)
  public void postProcess(WorldGenLevel level, StructureManager manager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos blockPos, CallbackInfo info, BoundingBox boundingbox) {
    if (PVJConfig.configOptions.get("enableBetterRuinedNetherPortals").get() && random.nextFloat() > 0.3F && level.getLevel().dimensionTypeId() == BuiltinDimensionTypes.OVERWORLD) {
      RuinedNetherPortalDecorator decorator = RuinedNetherPortalDecorator.getRandomDecorator(random);
      BlockPos.betweenClosedStream(this.getBoundingBox().inflatedBy(5)).forEach((pos) -> {
        if (level.getBlockState(pos).is(Blocks.NETHERRACK) && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).is(Blocks.WATER))) {
          BlockState topSoil = decorator.getTopSoil(level, random);
          if(topSoil != null) {
            if(LevelUtils.setBlock(level, pos, topSoil, 3)) {
              if(level.isEmptyBlock(pos.above())) {
                decorator.decorate(level, random, pos);
              }
            }
          }

        }
      });
    }
  }


}