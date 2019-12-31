package projectvibrantjourneys.common.world.blockstateproviders;

import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import projectvibrantjourneys.init.PVJBlocks;

public class RocksBlockStateProvider extends BlockStateProvider {
   private static final BlockState[] rocks = new BlockState[] {
		   	PVJBlocks.rocks.getDefaultState(),
		   	PVJBlocks.mossy_rocks.getDefaultState(),
		   	PVJBlocks.andesite_rocks.getDefaultState(),
		   	PVJBlocks.diorite_rocks.getDefaultState(),
		   	PVJBlocks.granite_rocks.getDefaultState()
		   };
   public RocksBlockStateProvider() {
      super(BlockStateProviderType.field_227397_d_);
   }

   public <T> RocksBlockStateProvider(Dynamic<T> p_i225856_1_) {
      this();
   }

   public BlockState func_225574_a_(Random rand, BlockPos pos) {
	   int length = rocks.length;
	   return rocks[rand.nextInt(length)];
   }

   public <T> T serialize(DynamicOps<T> p_218175_1_) {
      Builder<T, T> builder = ImmutableMap.builder();
      builder.put(p_218175_1_.createString("type"), p_218175_1_.createString(Registry.field_229387_t_.getKey(this.field_227393_a_).toString()));
      return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(builder.build()))).getValue();
   }
}