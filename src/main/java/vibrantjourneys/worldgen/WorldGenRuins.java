package vibrantjourneys.worldgen;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJWorldGen;
import vibrantjourneys.util.PVJLootTableList;
import vibrantjourneys.util.Reference;

public class WorldGenRuins implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;

	public WorldGenRuins(int frequency, Biome... biomes)
	{
		this.biomes = biomes;
		this.frequency = frequency;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		for(int id : PVJWorldGen.dimensionBlacklist)
			if(world.provider == DimensionManager.getProvider(id))
				return;
		
		boolean isValidBiome = false;
		for(int i = 0; i < biomes.length; i++)
		{
			if(biome == biomes[i])
			{
				isValidBiome = true;
				break;
			}
		}
		
		if(isValidBiome)
		{
			if(world.getBlockState(new BlockPos(x, world.getHeight(x, z) - 1, z)).getBlock() == Blocks.GRASS)
			{
				for(int i = 0; i < frequency; i++)
				{
					if(random.nextInt(5300) == 0)
					{
						WorldServer server = DimensionManager.getWorld(0);
						TemplateManager manager = server.getStructureTemplateManager();
						
						int id = 1;
						if(random.nextBoolean())
						{
							if(biome == Biomes.BIRCH_FOREST || biome == Biomes.BIRCH_FOREST_HILLS || biome == Biomes.MUTATED_BIRCH_FOREST || biome == Biomes.MUTATED_BIRCH_FOREST_HILLS)
							{
								id = 3;
							}
							else
							{
								id = 2;
							}
						}
						
						
						Template structure = manager.get(server.getMinecraftServer(), new ResourceLocation(Reference.MOD_ID, "ruins/ruins" + id));
						
						if(structure != null)
						{
							int yOffset = id == 3 ? 1 : 0;
							BlockPos pos = new BlockPos(x, world.getHeight(x, z) - yOffset, z);
							Rotation rot = Rotation.values()[random.nextInt(Rotation.values().length)];
							PlacementSettings settings = new PlacementSettings().setMirror(Mirror.NONE)
									.setRotation(rot)
									.setIgnoreStructureBlock(false);
							structure.addBlocksToWorld(world, pos, settings);
							System.out.println(pos);
							
							Map<BlockPos, String> blocks = structure.getDataBlocks(pos, settings);
							for(Entry<BlockPos, String> entry : blocks.entrySet())
							{
								if(entry.getValue().equals("chest"))
								{
									BlockPos chestPos = entry.getKey().down();
									TileEntity chest = world.getTileEntity(chestPos);
									if(chest instanceof TileEntityChest)
									{
										((TileEntityChest)chest).setLootTable(PVJLootTableList.RUINS, random.nextLong());
									}
									world.setBlockToAir(entry.getKey());
								}
								if(entry.getValue().equals("support"))
								{
									BlockPos supportPos = entry.getKey();
									world.setBlockToAir(supportPos);
									IBlockState state = getSupportBlock(id);
									while(canReplace(world, supportPos))
									{
										world.setBlockState(supportPos, state, 2);
										supportPos = supportPos.down();
									}
								}
							}
							break;
						}
					}
				}
			}
		}
	}
	
	public IBlockState getSupportBlock(int id)
	{
		switch(id)
		{
			case 1:
			default:
				return Blocks.COBBLESTONE.getDefaultState();
			case 2:
				return Blocks.PLANKS.getDefaultState();
			case 3:
				return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
		}
	}
	
	public boolean canReplace(World world, BlockPos pos)
	{
		if(world.isAirBlock(pos))
			return true;
		
		IBlockState state = world.getBlockState(pos);
		
		if(state.getBlock().isReplaceable(world, pos))
			return true;
		
		if(state.getBlock().isLeaves(state, world, pos))
			return true;
		
		if(state.getMaterial() == Material.WATER)
			return true;
		
		return false;
	}
}
