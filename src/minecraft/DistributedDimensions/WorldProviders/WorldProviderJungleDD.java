package DistributedDimensions.WorldProviders;

import DistributedDimensions.ChunkProviders.ChunkProviderJungleDD;
import DistributedDimensions.Common.ConfigHandler;
import DistributedDimensions.Common.DimensionRegister;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderJungleDD extends WorldProvider
{
	 public void registerWorldChunkManager()
	 {
	  this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.jungle, 0.8F, 0.1F);
	  this.dimensionId = DimensionRegister.DimID;
	 }
	 
	 public String getDimensionName() 
	 {
	  return ConfigHandler.getDimName(this.dimensionId);
	 }
	 
	 public boolean canRespawnHere()
	 {
	  return true;
	 }
	 
	 @Override
	 public IChunkProvider createChunkGenerator()
	 {
	  return new ChunkProviderJungleDD(worldObj, worldObj.getSeed(), true);
	 }
	}
