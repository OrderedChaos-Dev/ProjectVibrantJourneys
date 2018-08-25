package vibrantjourneys.tileentities;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vibrantjourneys.blocks.BlockMysticalGrill;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.init.PVJItems;
import vibrantjourneys.util.PVJConfig;

public class TileEntityMysticalGrill extends TileEntity implements ITickable
{
	public static final Potion[] BENEFICIAL_POTIONS = new Potion[] {
		Potion.getPotionFromResourceLocation("speed"),
		Potion.getPotionFromResourceLocation("haste"),
		Potion.getPotionFromResourceLocation("strength"),
		Potion.getPotionFromResourceLocation("instant_health"),
		Potion.getPotionFromResourceLocation("jump_boost"),
		Potion.getPotionFromResourceLocation("regeneration"),
		Potion.getPotionFromResourceLocation("resistance"),
		Potion.getPotionFromResourceLocation("fire_resistance"),
		Potion.getPotionFromResourceLocation("water_breathing"),
		Potion.getPotionFromResourceLocation("invisibility"),
		Potion.getPotionFromResourceLocation("health_boost"),
		Potion.getPotionFromResourceLocation("absorption"),
		Potion.getPotionFromResourceLocation("luck")
	};
	
	private ItemStack food;
	private int cookTime;
	private boolean isCooking;
	private int netherWartCount;
	private boolean hasEssence;
	
	public TileEntityMysticalGrill()
	{
		cookTime = 0;
		isCooking = false;
		food = ItemStack.EMPTY;
		netherWartCount = 0;
		hasEssence = false;
	}
	
	@Override
	public void update()
	{
        if (!this.world.isRemote)
        {
        	if(isCooking && !canCook())
        	{
        		isCooking = false;
        		world.setBlockState(this.getPos(), PVJBlocks.mystical_grill.getStateFromMeta(0));
        	}
        	
    		if(isCooking)
    		{
    			//6000 ticks = 5 mins
    			if(cookTime >= PVJConfig.mysticalGrillCookTime)
    			{
    				ItemStack cookedItem = getCookedFood(food);
    				setFood(cookedItem);
    				isCooking = false;
    				netherWartCount = 0;
    				hasEssence = false;
    				cookTime = 0;
    				
    				IBlockState cauldron = world.getBlockState(pos.down());
    				int level = cauldron.getBlock().getMetaFromState(cauldron) - 1;
    				world.setBlockState(pos.down(), cauldron.withProperty(BlockCauldron.LEVEL, level));
    				world.setBlockState(this.getPos(), PVJBlocks.mystical_grill.getStateFromMeta(0));
    			}
    			else
    			{
    				cookTime++;
    			}
    		}
    		else
    		{
    			if(canCook())
    			{
    				isCooking = true;
    				world.setBlockState(this.getPos(), PVJBlocks.mystical_grill.getStateFromMeta(1));
    			}
    		}
        }
	}
	
	public boolean isCooking()
	{
		return isCooking;
	}
	
	public int getNetherWartCount()
	{
		return netherWartCount;
	}
	
	public boolean addNetherWart()
	{
		if(netherWartCount < 5)
		{
			netherWartCount++;
			updateTE();
			return true;
		}
		return false;
	}
	
	public boolean hasEssence()
	{
		return hasEssence;
	}

	public boolean addUnstableEssence()
	{
		if(hasEssence)
		{
			return false;
		}
		
		hasEssence = true;
		updateTE();
		return true;
	}
	
	public boolean canCook()
	{
		if(getCookedFood(food) != ItemStack.EMPTY && getNetherWartCount() == 5 && hasEssence())
		{
			if(world.getBlockState(pos.down(2)).getBlock() instanceof BlockFire
					|| world.getBlockState(pos.down(2)).getBlock()== Blocks.MAGMA)
			{
				IBlockState state = world.getBlockState(pos.down());
				if(state.getBlock() == Blocks.CAULDRON)
				{
					if(state.getBlock().getMetaFromState(state) > 0)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public ItemStack getCookedFood(ItemStack item)
	{
		ItemStack cookedFood = ItemStack.EMPTY;
		if(item.getItem() == Items.PORKCHOP)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_porkchop), getRandomEffects());
		
		if(item.getItem() == Items.BEEF)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_beef), getRandomEffects());
		
		if(item.getItem() == Items.CHICKEN)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_chicken), getRandomEffects());
		
		if(item.getItem() == Items.MUTTON)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_mutton), getRandomEffects());
		
		if(item.getItem() == Items.FISH && item.getMetadata() == 0)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_cod), getRandomEffects());
		
		if(item.getItem() == Items.FISH && item.getMetadata() == 1)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_salmon), getRandomEffects());
		
		if(item.getItem() == Items.POTATO)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_potato), getRandomEffects());
		
		if(item.getItem() == Items.RABBIT)
			cookedFood = PotionUtils.appendEffects(new ItemStack(PVJItems.mystical_rabbit), getRandomEffects());
		
		return cookedFood;
	}
	
	public ArrayList<PotionEffect> getRandomEffects()
	{
		ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
		int size = BENEFICIAL_POTIONS.length;
		Potion effect = BENEFICIAL_POTIONS[this.world.rand.nextInt(size)];
		Potion effect2 = BENEFICIAL_POTIONS[this.world.rand.nextInt(size)];
		if(effect == effect2)
		{
			int duration = effect.isInstant() ? 0 : 1200 + this.world.rand.nextInt(1200);
			effects.add(new PotionEffect(effect, duration, 1));
		}
		else
		{
			int duration = effect.isInstant() ? 0 : 800 + this.world.rand.nextInt(800);
			int duration2 = effect2.isInstant() ? 0 : 800 + this.world.rand.nextInt(800);
			effects.add(new PotionEffect(effect, duration, 0));
			effects.add(new PotionEffect(effect2, duration2, 0));
		}
		
		return effects;
	}
	
	public ItemStack getFood()
	{
		return food;
	}
	
	public void setFood(ItemStack item)
	{
		food = item;
		updateTE();
	}
	
	public void updateTE()
	{
		IBlockState state = world.getBlockState(this.getPos());
		this.world.notifyBlockUpdate(this.getPos(), state, state, 3);
		this.world.markBlockRangeForRenderUpdate(pos, pos);
		this.world.scheduleBlockUpdate(pos, this.getBlockType(), 0, 0);
		this.markDirty();
	}

	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.cookTime = compound.getInteger("CookTime");
        if(compound.hasKey("Item"))
        	this.food = new ItemStack(Item.getByNameOrId(compound.getString("Item")), 1, compound.getInteger("Data"));
        else
        	this.food = ItemStack.EMPTY;
        this.isCooking = compound.getBoolean("IsCooking");
        this.netherWartCount = compound.getInteger("NetherWart");
        this.hasEssence = compound.getBoolean("HasEssence");
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("CookTime", this.cookTime);
        
        if(food != ItemStack.EMPTY)
        {
            ResourceLocation resource = Item.REGISTRY.getNameForObject(food.getItem());
            compound.setString("Item", resource == null ? "" : resource.toString());
            compound.setInteger("Data", food.getMetadata());
        }
        
        compound.setBoolean("IsCooking", isCooking);
        compound.setInteger("NetherWart", netherWartCount);
        compound.setBoolean("HasEssence", hasEssence);
        
        return compound;
    }
	
	@Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 7, this.writeToNBT(new NBTTagCompound()));
    }
	
	@Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
    {
		this.readFromNBT(pkt.getNbtCompound());
    }
	
	@Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }
	
	@Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return !(newState.getBlock() instanceof BlockMysticalGrill);
    }
}
