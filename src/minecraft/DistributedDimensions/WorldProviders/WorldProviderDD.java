package DistributedDimensions.WorldProviders;

import java.util.Random;

import DistributedDimensions.Common.ConfigHandler;
import DistributedDimensions.Common.DimensionRegister;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import scala.xml.include.sax.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderDD extends WorldProvider
{
	/*public String dimName;
	public WorldProviderDD(int DimID, String name)
	{
		this.dimensionId = DimID;
		this.dimName = name;
	}*/

	public void registerWorldChunkManager()
	{
			this.dimensionId = DimensionRegister.DimID;
			this.worldChunkMgr = new WorldChunkManager(worldObj);
			this.hasNoSky = false;
	}
	
	public String getDimensionName()
	{
		return ConfigHandler.getDimName(this.dimensionId);
	}
	
    @Override
	public long getSeed()
    {
    	long x = 1234567L;
    	long y = 23456789L;
    	Random r = new Random();
    	long number = x+((long)(r.nextDouble()*(y-x)));
        return number;//worldObj.getSeed();
    }
	
}