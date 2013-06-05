package DistributedDimensions.Common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegister 
{
	public static List<Integer> OwDims = new ArrayList<Integer>();
	public static List<Integer> NetDims = new ArrayList<Integer>();
	public static List<Integer> EndDims = new ArrayList<Integer>();
	public static int DimID;
	public static void Register(String name, int type, EntityPlayer player)
	{
		switch (type)
		{
		case 1:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			OwDims.add(DimID);  //add dimension id to list of dims to load on server start.
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProSurfaceID);
			break;
		case 2:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			NetDims.add(DimID);  //add dimension id to list of dims to load on server start.
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProHellID);
			break;
		case 3:
			break;
		default:
			break;
		}
		
		
	}

}
