package projectvibrantjourneys.common.blocks;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import projectvibrantjourneys.common.entities.passive.ScarecrowEntity;
import projectvibrantjourneys.init.PVJBlocks;
import projectvibrantjourneys.init.PVJEntities;
import projectvibrantjourneys.init.PVJSoundEvents;

public class PossessedPumpkinBlock extends CarvedPumpkinBlock {

	@Nullable
	private BlockPattern scarecrowPattern;
	
	private static final Predicate<BlockState> IS_FENCE = (state) -> {
		return state.getBlock().isIn(BlockTags.FENCES);
	};
	
	public PossessedPumpkinBlock() {
		super(Block.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).tickRandomly().sound(SoundType.WOOD));
	}
	
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (oldState.getBlock() != state.getBlock()) {
			this.trySpawnGolem(worldIn, pos);
		}
	}
	
	   private void trySpawnGolem(World world, BlockPos pos) {
	      BlockPattern.PatternHelper patternHelper = this.getScarecrowPattern().match(world, pos);
	         if (patternHelper != null) {
		            for(int j = 0; j < this.getScarecrowPattern().getPalmLength(); ++j) {
		               for(int k = 0; k < this.getScarecrowPattern().getThumbLength(); ++k) {
		                  CachedBlockInfo cachedblockinfo2 = patternHelper.translateOffset(j, k, 0);
		                  world.setBlockState(cachedblockinfo2.getPos(), Blocks.AIR.getDefaultState(), 2);
		                  world.playEvent(2001, cachedblockinfo2.getPos(), Block.getStateId(cachedblockinfo2.getBlockState()));
		               }
		            }

		            BlockPos blockpos = patternHelper.translateOffset(1, 2, 0).getPos();
		            ScarecrowEntity scarecrow = PVJEntities.scarecrow.create(world);
		            scarecrow.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
		            world.addEntity(scarecrow);

		            for(ServerPlayerEntity serverplayerentity1 : world.getEntitiesWithinAABB(ServerPlayerEntity.class, scarecrow.getBoundingBox().grow(5.0D))) {
		               CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, scarecrow);
		            }

		            for(int i1 = 0; i1 < this.getScarecrowPattern().getPalmLength(); ++i1) {
		               for(int j1 = 0; j1 < this.getScarecrowPattern().getThumbLength(); ++j1) {
		                  CachedBlockInfo cachedblockinfo1 = patternHelper.translateOffset(i1, j1, 0);
		                  world.notifyNeighbors(cachedblockinfo1.getPos(), Blocks.AIR);
		               }
		            }
		         }
	   }
	   
	private BlockPattern getScarecrowPattern() {
		if (this.scarecrowPattern == null) {
			this.scarecrowPattern = BlockPatternBuilder.start().aisle("~^~", "F#F", "~F~")
					.where('^', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(PVJBlocks.possessed_pumpkin)))
					.where('F', CachedBlockInfo.hasState(IS_FENCE))
					.where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.HAY_BLOCK)))
					.where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
		}

		return this.scarecrowPattern;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(100) == 0) {
			worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F),
					(double) ((float) pos.getZ() + 0.5F), PVJSoundEvents.entity_ghost_ambient, SoundCategory.BLOCKS,
					1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}
	}
}
