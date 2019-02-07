package vibrantjourneys.worldgen;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

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

public class WorldGenAbandonedFarm implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;

	public WorldGenAbandonedFarm(int frequency, Biome... biomes)
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
					if(random.nextInt(5000) == 0)
					{
						WorldServer server = DimensionManager.getWorld(0);
						TemplateManager manager = server.getStructureTemplateManager();
						int id = random.nextInt(4) + 1;
						Template structure = manager.get(server.getMinecraftServer(), new ResourceLocation(Reference.MOD_ID, "farm/farm" + id));
						
						if(structure != null)
						{
							BlockPos pos = new BlockPos(x, world.getHeight(x, z) - 1, z);
							Rotation rot = Rotation.values()[random.nextInt(Rotation.values().length)];
							PlacementSettings settings = new PlacementSettings().setMirror(Mirror.NONE)
									.setRotation(rot)
									.setIgnoreStructureBlock(false);
							structure.addBlocksToWorld(world, pos, settings);
							
							Map<BlockPos, String> blocks = structure.getDataBlocks(pos, settings);
							for(Entry<BlockPos, String> entry : blocks.entrySet())
							{
								if(entry.getValue().equals("chest"))
								{
									BlockPos chestPos = entry.getKey().down();
									TileEntity chest = world.getTileEntity(chestPos);
									if(chest instanceof TileEntityChest)
									{
										((TileEntityChest)chest).setLootTable(PVJLootTableList.ABANDONED_FARM, random.nextLong());
									}
									world.setBlockToAir(entry.getKey());
								}
							}
							
							break;
						}
					}
				}
			}
		}
	}
}
