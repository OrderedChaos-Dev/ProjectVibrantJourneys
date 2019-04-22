package vibrantjourneys.entities.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import vibrantjourneys.integration.sereneseasons.PVJSereneSeasons;
import vibrantjourneys.util.Reference;

public class EntitySmallSpider extends EntityCritter
{
    public EntitySmallSpider(World world)
    {
        super(world);
        this.setSize(0.28F, 0.18F);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.06D);
    }
    
    @Override
    public void setInWeb()
    {
    }

    //is this really necessary? not really
    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
	@Override
    public boolean getCanSpawnHere()
    {
		if(this.world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return false;
		
        Biome biome = world.getBiomeForCoordsBody(this.getPosition());
        if(BiomeDictionary.hasType(biome, Type.SNOWY))
        	return false;
        
        if(Reference.isSereneSeasonsLoaded)
        	if(PVJSereneSeasons.canSnowHere(getEntityWorld(), getPosition()))
        		return false;
        
		Block block = this.getEntityWorld().getBlockState(this.getPosition().down()).getBlock();
		if(block != Blocks.GRASS)
			return false;
        
		return super.getCanSpawnHere();
    }
}