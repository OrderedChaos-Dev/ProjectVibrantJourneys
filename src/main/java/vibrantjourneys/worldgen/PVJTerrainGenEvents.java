package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vibrantjourneys.init.PVJBiomes;
import vibrantjourneys.init.PVJBlocks;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.worldgen.feature.WorldGenBaobabTree;
import vibrantjourneys.worldgen.feature.WorldGenCherryBlossomTree;
import vibrantjourneys.worldgen.feature.WorldGenJacarandaTree;
import vibrantjourneys.worldgen.feature.WorldGenPVJDungeon;
import vibrantjourneys.worldgen.feature.WorldGenPineTree;

public class PVJTerrainGenEvents
{
	@SubscribeEvent
	public void onDecorate(PopulateChunkEvent.Populate event)
	{
		//Add PVJ Dungeon decorations
		if(event.getType().equals(PopulateChunkEvent.Populate.EventType.DUNGEON) && PVJConfig.worldgen.modifyDungeons)
		{
			int chunkX = event.getChunkX();
			int chunkZ = event.getChunkZ();
			
			ChunkGeneratorSettings settings = ChunkGeneratorSettings.Factory.jsonToFactory(event.getWorld().getWorldInfo().getGeneratorOptions()).build();
			Random rand = event.getWorld().rand;
			int dungeonSpawnChance = settings.dungeonChance;
			
			for(int i = 0; i < dungeonSpawnChance; i++)
			{
				int x = chunkX * 16 + 6;
				int y = rand.nextInt(256);
				int z = chunkZ * 16 + 6;
				(new WorldGenPVJDungeon()).generate(event.getWorld(), rand, new BlockPos(x, y, z));
			}
			event.setResult(Result.DENY);
		}
	}
	
	@SubscribeEvent 
	public void removeLakes(DecorateBiomeEvent.Decorate event)
	{
		Biome biome = event.getWorld().getBiomeForCoordsBody(event.getChunkPos().getBlock(8, 0, 8));
		
		//remove most desert lakes
		if(BiomeReference.DESERT_BIOMES.contains(biome))
		{
			if(PVJConfig.worldgen.decreaseDesertLakes && event.getType() == Decorate.EventType.LAKE_WATER)
			{
				if(event.getRand().nextInt(6) < 5)
				{
					event.setResult(Result.DENY);
				}
			}
		}
		//remove most plains ponds
		if(biome == Biomes.PLAINS)
		{
			if(PVJConfig.worldgen.decreasePlainsPonds && event.getType() == Decorate.EventType.LAKE_WATER)
			{
				if(event.getRand().nextInt(6) < 5)
				{
					event.setResult(Result.DENY);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void genTrees(DecorateBiomeEvent.Decorate event)
	{
		Biome biome = event.getWorld().getBiomeForCoordsBody(event.getChunkPos().getBlock(8, 0, 8));
		
		if(event.getType() == Decorate.EventType.TREE)
		{
			if(BiomeReference.BAOBAB_TREES.contains(biome))
			{
				if(event.getRand().nextInt(200) < PVJConfig.worldgen.baobabDensity)
				{
					BlockPos pos = event.getWorld().getHeight(event.getChunkPos().getBlock(13, 0, 13));
					(new WorldGenBaobabTree(false, 15, 6)).generate(event.getWorld(), event.getRand(), pos);
				}
			}
			if(BiomeReference.MOUNTAIN_BIOMES.contains(biome) || BiomeReference.SPRUCE_TREES.contains(biome))
			{
				if(event.getRand().nextInt(7) == 0 && PVJConfig.worldgen.pineDensity > 0)
				{
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8, 0, 8));
					(new WorldGenPineTree(false)).generate(event.getWorld(), event.getRand(), pos);
				}
			}
			//flower forest
			if(biome == Biomes.MUTATED_FOREST)
			{
				if(event.getRand().nextInt(7) == 0 && PVJConfig.worldgen.pinkCherryBlossomDensity > 0)
				{
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8, 0, 8));
					(new WorldGenCherryBlossomTree(true, true)).generate(event.getWorld(), event.getRand(), pos);
				}
				if(event.getRand().nextInt(7) == 0 && PVJConfig.worldgen.whiteCherryBlossomDensity > 0)
				{
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8, 0, 8));
					(new WorldGenCherryBlossomTree(true, false)).generate(event.getWorld(), event.getRand(), pos);
				}
			}
			if(BiomeReference.JACARANDA_TREES.contains(biome))
			{
				if(event.getRand().nextInt(7) == 0 && PVJConfig.worldgen.jacarandaDensity > 0)
				{
					int xRand = event.getRand().nextInt(8) - event.getRand().nextInt(8);
					int zRand = event.getRand().nextInt(8) - event.getRand().nextInt(8);
					BlockPos pos = event.getWorld().getTopSolidOrLiquidBlock(event.getChunkPos().getBlock(8 + xRand, 0, 8 + zRand));
					(new WorldGenJacarandaTree(false)).generate(event.getWorld(), event.getRand(), pos);
					event.setResult(Result.DENY);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void generateBeachVillage(BiomeEvent.GetVillageBlockID event)
	{
		if(event.getBiome() == Biomes.BEACH)
		{
			Block block = event.getOriginal().getBlock();
			if(block == Blocks.PLANKS)
			{
				event.setReplacement(PVJBlocks.PLANKS.get(EnumWoodType.PALM.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.LOG || block == Blocks.LOG2)
			{
				EnumAxis axis = event.getOriginal().getValue(BlockLog.LOG_AXIS);
				event.setReplacement(PVJBlocks.LOGS.get(EnumWoodType.PALM.getID()).getDefaultState().withProperty(BlockLog.LOG_AXIS, axis));
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_FENCE)
			{
				event.setReplacement(PVJBlocks.FENCES.get(EnumWoodType.PALM.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_STAIRS)
			{
				EnumFacing facing = event.getOriginal().getValue(BlockStairs.FACING);
				event.setReplacement(PVJBlocks.STAIRS.get(EnumWoodType.PALM.getID()).getDefaultState().withProperty(BlockStairs.FACING, facing));
				event.setResult(Result.DENY);
			}
		}
		if(event.getBiome() == PVJBiomes.prairie)
		{
			Block block = event.getOriginal().getBlock();
			if(block == Blocks.PLANKS)
			{
				event.setReplacement(PVJBlocks.PLANKS.get(EnumWoodType.COTTONWOOD.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.LOG || block == Blocks.LOG2)
			{
				EnumAxis axis = event.getOriginal().getValue(BlockLog.LOG_AXIS);
				event.setReplacement(PVJBlocks.LOGS.get(EnumWoodType.COTTONWOOD.getID()).getDefaultState().withProperty(BlockLog.LOG_AXIS, axis));
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_FENCE)
			{
				event.setReplacement(PVJBlocks.FENCES.get(EnumWoodType.COTTONWOOD.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_STAIRS)
			{
				EnumFacing facing = event.getOriginal().getValue(BlockStairs.FACING);
				event.setReplacement(PVJBlocks.STAIRS.get(EnumWoodType.COTTONWOOD.getID()).getDefaultState().withProperty(BlockStairs.FACING, facing));
				event.setResult(Result.DENY);
			}
		}
		if(event.getBiome() == PVJBiomes.blossoming_fields)
		{
			Block block = event.getOriginal().getBlock();
			if(block == Blocks.PLANKS)
			{
				event.setReplacement(PVJBlocks.PLANKS.get(EnumWoodType.CHERRY_BLOSSOM.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.LOG || block == Blocks.LOG2)
			{
				EnumAxis axis = event.getOriginal().getValue(BlockLog.LOG_AXIS);
				event.setReplacement(PVJBlocks.LOGS.get(EnumWoodType.CHERRY_BLOSSOM.getID()).getDefaultState().withProperty(BlockLog.LOG_AXIS, axis));
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_FENCE)
			{
				event.setReplacement(PVJBlocks.FENCES.get(EnumWoodType.CHERRY_BLOSSOM.getID()).getDefaultState());
				event.setResult(Result.DENY);
			}
			if(block == Blocks.OAK_STAIRS)
			{
				EnumFacing facing = event.getOriginal().getValue(BlockStairs.FACING);
				event.setReplacement(PVJBlocks.STAIRS.get(EnumWoodType.CHERRY_BLOSSOM.getID()).getDefaultState().withProperty(BlockStairs.FACING, facing));
				event.setResult(Result.DENY);
			}
		}
	}
}
