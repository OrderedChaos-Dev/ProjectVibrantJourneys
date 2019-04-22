package vibrantjourneys.entities.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import vibrantjourneys.integration.sereneseasons.PVJSereneSeasons;
import vibrantjourneys.util.PVJLootTableList;
import vibrantjourneys.util.Reference;

public class EntitySnail extends EntityCritter
{
    public EntitySnail(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.2F);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }
    
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
    }
	
    @Override
    protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateClimber(this, worldIn);
    }

	@Override
	protected ResourceLocation getLootTable()
	{
		return PVJLootTableList.SNAIL;
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