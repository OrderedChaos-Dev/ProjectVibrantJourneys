package projectvibrantjourneys.common.items;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import projectvibrantjourneys.common.entities.IBucketCollectable;

public class PVJFishBucketItem extends BucketItem {
	
	private final EntityType<?> fishType;

	public PVJFishBucketItem(EntityType<?> fishTypeIn, Item.Properties builder) {
		super(Fluids.WATER, builder);
		this.fishType = fishTypeIn;
	}

	@Override
	public void checkExtraContent(World world, ItemStack itemstack, BlockPos pos) {
		if (world instanceof ServerWorld) {
			this.placeFish((ServerWorld) world, itemstack, pos);
		}
	}

	@Override
	protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
		worldIn.playSound(player, pos, SoundEvents.BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
	}

	private void placeFish(ServerWorld worldIn, ItemStack stack, BlockPos pos) {
		Entity entity = this.fishType.spawn(worldIn, stack, (PlayerEntity) null, pos, SpawnReason.BUCKET, true, false);
		if (entity != null) {
			((IBucketCollectable) entity).setFromBucket(true);
		}

	}
}