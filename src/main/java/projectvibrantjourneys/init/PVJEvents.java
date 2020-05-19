package projectvibrantjourneys.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.SwordItem;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import projectvibrantjourneys.common.blocks.GroundcoverBlock;
import projectvibrantjourneys.common.blocks.SeaOatsBlock;
import projectvibrantjourneys.common.entities.monster.IceCubeEntity;
import projectvibrantjourneys.common.entities.monster.MawEntity;

public class PVJEvents {
	
	public static Map<Block, Block> stripping_map = new HashMap<Block, Block>();
	
	@SuppressWarnings("deprecation") //works in this case
	@SubscribeEvent
	public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		ItemStack stack = event.getItemStack();
		Item item = stack.getItem();
		World world = event.getWorld();
		Direction direction = event.getFace();
		BlockPos pos = event.getPos();
		BlockPos posWithOffset = pos.offset(direction);
		PlayerEntity player = event.getPlayer();
		
		Block groundcover;
		
		int model = world.getRandom().nextInt(5);
		
		if(item == Items.IRON_NUGGET) {
			groundcover = PVJBlocks.iron_nugget;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == Items.GOLD_NUGGET) {
			groundcover = PVJBlocks.gold_nugget;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == Items.FLINT) {
			groundcover = PVJBlocks.flint;
			if(groundcover.isValidPosition(groundcover.getDefaultState(), world, posWithOffset)) {
				world.setBlockState(posWithOffset, groundcover.getDefaultState().with(GroundcoverBlock.MODEL, model));
				if(!player.isCreative())
					stack.shrink(1);
				event.setResult(Result.ALLOW);
			}
		} else if(item == PVJBlocks.dung.asItem()) {
			if(!player.isCrouching()) {
				if(!event.getWorld().isRemote) {
					event.setCanceled(true);
					BoneMealItem.applyBonemeal(stack, world, pos, player);
					if(world.getBlockState(pos).getBlock() == Blocks.SAND) {
						this.grow((ServerWorld)world, world.rand, posWithOffset, world.getBlockState(pos));
						stack.shrink(1);
					}
				} else {
					event.setCanceled(true);
					player.swingArm(event.getHand());
					BoneMealItem.spawnBonemealParticles(world, pos, 0);
				}
			}
		} else if(item == Items.BONE_MEAL) {
			if(!player.isCrouching()) {
				if(world.getBlockState(pos).getBlock() == Blocks.SAND && world.isAirBlock(pos.up())) {
					if(!event.getWorld().isRemote) {
						event.setCanceled(true);
						this.grow((ServerWorld)world, world.rand, posWithOffset, world.getBlockState(pos));
						stack.shrink(1);
					} else {
						player.swingArm(event.getHand());
						BoneMealItem.spawnBonemealParticles(world, pos, 0);
					}
				}
			}
		} else if(item instanceof AxeItem) {
			BlockState activatedBlock = world.getBlockState(pos);
			if(stripping_map.get(activatedBlock.getBlock()) != null) {
				Block block = activatedBlock.getBlock();
				if(block instanceof RotatedPillarBlock) {
					Axis axis = activatedBlock.get(RotatedPillarBlock.AXIS);
					world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
					world.setBlockState(pos, stripping_map.get(activatedBlock.getBlock()).getDefaultState().with(LogBlock.AXIS, axis), 2);
					stack.damageItem(1, player, (entity) -> {
						 entity.sendBreakAnimation(event.getHand());
		            });
					player.swingArm(event.getHand());
					event.setResult(Result.ALLOW);
				}
			}
		}
		
		Block block = world.getBlockState(pos).getBlock();
		if(block == Blocks.BONE_BLOCK) {
			if(item == PVJItems.maw_tongue) {
				EntityType<MawEntity> mawType = PVJEntities.maw;
				
				if(direction == Direction.UP) {
					MawEntity maw = (MawEntity) mawType.spawn(world, stack, player, pos, SpawnReason.BREEDING, true, !Objects.equals(pos, posWithOffset) && direction == Direction.UP);
					if (maw != null) {
						stack.shrink(1);
						maw.getDataManager().set(MawEntity.FRIENDLY, true);
						maw.getDataManager().set(MawEntity.ATTACHED_FACE, direction.getOpposite());
						maw.targetSelector.removeGoal(new NearestAttackableTargetGoal<>(maw, PlayerEntity.class, true));
						if(stack.hasDisplayName()) {
							maw.setCustomName(stack.getDisplayName());
						}
						world.removeBlock(pos, false);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void thisIsWar(LivingSpawnEvent event) {
		if(event.getEntityLiving() instanceof MagmaCubeEntity) {
			MagmaCubeEntity magmaCube = (MagmaCubeEntity)event.getEntityLiving();
			magmaCube.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(magmaCube, IceCubeEntity.class, 10, true, false, (entity) -> {
				return Math.abs(entity.getPosY() - magmaCube.getPosY()) <= 4.0D;
			}));
			magmaCube.getCollisionBox(magmaCube);
		}
	}
	
	@SubscribeEvent
	public void attack(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof MagmaCubeEntity) {
			MagmaCubeEntity magmaCube = (MagmaCubeEntity)event.getEntityLiving();
			World world = event.getEntityLiving().getEntityWorld();
			List<Entity> neighbors = world.getEntitiesWithinAABBExcludingEntity(magmaCube, magmaCube.getBoundingBox());
			for(Entity entity : neighbors) {
				if(entity instanceof IceCubeEntity) {
					magmaCube.attackEntityAsMob(entity);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void trade(VillagerTradesEvent event) {
		if(event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(1).add(new VillagerTrades.ITrade() {
				
				@Override
				public MerchantOffer getOffer(Entity entity, Random rand) {
					return new MerchantOffer(new ItemStack(PVJItems.pearl, 1), new ItemStack(Items.EMERALD, 1), 10, 4, 1);
				}
			});
		}
	}

	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
	      BlockPos blockpos = pos.up();
	      BlockState blockstate = PVJBlocks.beach_grass.getDefaultState();

	      for(int i = 0; i < 128; ++i) {
	         BlockPos blockpos1 = blockpos;
	         int j = 0;

	         while(true) {
	            if (j >= i / 16) {
	               BlockState blockstate2 = world.getBlockState(blockpos1);

	               if (!blockstate2.isAir()) {
	                  break;
	               }

	               BlockState blockstate1;
	               if (rand.nextInt(5) == 0) {
	            	   blockstate1 = PVJBlocks.sea_oats.getDefaultState();
	               } else {
	                  blockstate1 = blockstate;
	               }

	               if (blockstate1.isValidPosition(world, blockpos1)) {
	                  if(blockstate1.getBlock() == PVJBlocks.sea_oats) {
	                	  if(world.isAirBlock(blockpos1.up())) {
	                		  world.setBlockState(blockpos1, PVJBlocks.sea_oats.getDefaultState(), 3);
	                		  world.setBlockState(blockpos1.up(), PVJBlocks.sea_oats.getDefaultState().with(SeaOatsBlock.HALF, DoubleBlockHalf.UPPER), 3);
	                	  } else {
	                		  world.setBlockState(blockpos1, PVJBlocks.beach_grass.getDefaultState(), 3);
	                	  }
	                  } else {
		                  world.setBlockState(blockpos1, blockstate1, 3);
	                  }
	               }
	               break;
	            }

	            blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
	            if (world.getBlockState(blockpos1.down()).getBlock() != Blocks.SAND || world.getBlockState(blockpos1).isCollisionShapeOpaque(world, blockpos1)) {
	               break;
	            }

	            ++j;
	         }
	      }
	}
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.BreakSpeed event) {
		Item item = event.getPlayer().getHeldItemMainhand().getItem();
		if(item instanceof SwordItem || item instanceof ShearsItem) {
			if(event.getState().getBlock() == PVJBlocks.natural_cobweb) {
				event.setNewSpeed(15.0F);
			}
		}
	}
	
	@SubscribeEvent
	public void harvestCobweb(PlayerEvent.HarvestCheck event) {
		if(event.getTargetBlock().getBlock() == PVJBlocks.natural_cobweb) {
			Item item = event.getPlayer().getHeldItemMainhand().getItem();
			if(item instanceof SwordItem || item instanceof ShearsItem) {
				event.setCanHarvest(true);
			}
		}
	}
}
