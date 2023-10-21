package dev.orderedchaos.projectvibrantjourneys.common.mixin;

import dev.orderedchaos.projectvibrantjourneys.common.world.PortalType;
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
                    target="Lnet/minecraft/world/level/levelgen/structure/structures/RuinedPortalPiece;addNetherrackDripColumnsBelowPortal(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/LevelAccessor;)V",
                    shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void postProcess(WorldGenLevel level, StructureManager manager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos blockPos, CallbackInfo info, BoundingBox boundingbox) {
        if(PVJConfig.configOptions.get("enableBetterRuinedNetherPortals").get() && random.nextFloat() > 0.3F && level.getLevel().dimensionTypeId() == BuiltinDimensionTypes.OVERWORLD) {
            PortalType type = PortalType.getRandom(random);

            BlockPos.betweenClosedStream(this.getBoundingBox().inflatedBy(5)).forEach((pos) -> {
                if(level.getBlockState(pos).is(Blocks.NETHERRACK) && (level.isEmptyBlock(pos.above()) || level.getBlockState(pos.above()).is(Blocks.WATER))) {
                    if(random.nextFloat() < 0.75F) {
                        LevelUtils.setBlock(level, pos, type.topSoil.defaultBlockState(), 3);

                        if(level.isEmptyBlock(pos.above())) {
                            if(random.nextBoolean()) {
                                level.setBlock(pos.above(), type.randomFlora(random).defaultBlockState(), 3);
                            } else {
                                switch(type) {
                                    case WARPED_FOREST:
                                        if(random.nextFloat() < 0.3F) {
                                            int length = random.nextInt(3) + 1;
                                            int i = 1;
                                            while(length > 0) {
                                                if(level.isEmptyBlock(pos.above(i))) {
                                                    LevelUtils.setBlock(level, pos.above(i), Blocks.TWISTING_VINES_PLANT.defaultBlockState(), 3);
                                                } else {
                                                    break;
                                                }

                                                length--;
                                                i++;
                                            }
                                            LevelUtils.setBlock(level, pos.above(i - 1), Blocks.TWISTING_VINES.defaultBlockState(), 3);
                                        }
                                        break;
                                    case BASALT_DELTAS:
                                        if(random.nextBoolean()) {
                                            LevelUtils.setBlock(level, pos, Blocks.BLACKSTONE.defaultBlockState(), 3);
                                        }
                                        break;
                                    case SOUL_SAND_VALLEY:
                                        if(random.nextFloat() < 0.4F) {
                                            LevelUtils.setBlock(level, pos.above(), Blocks.SOUL_FIRE.defaultBlockState(), 3);
                                        } else if(random.nextFloat() < 0.05F) {
                                            int height = random.nextInt(3) + 2;
                                            for(int i = 1; i <= height; i++) {
                                                if(level.isEmptyBlock(pos.above(i)) || level.getBlockState(pos.above(i)).canBeReplaced()) {
                                                    LevelUtils.setBlock(level, pos.above(i), Blocks.BONE_BLOCK.defaultBlockState(), 3);
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                }
            });
        }
    }


}