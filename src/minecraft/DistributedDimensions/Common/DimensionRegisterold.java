package DistributedDimensions.Common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegisterold 
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
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProSurfaceID);
			break;
		case 2:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProHellID);
			break;
		case 3:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProEndID);
			break;
		case 4:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProForestID);
			break;
		case 5:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProJungleID);
			break;
		case 6:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			DimensionManager.registerDimension(DimID, DistributedDimensions.WorldProTundraID);
			break;
		default:
			break;
		}
		
		
	}
	public static void unRegister(int dim, EntityPlayer player)
	{
			player.sendChatToPlayer("Unregistering Dimension " + dim + ".");
			DimensionManager.unregisterDimension(dim);
			player.sendChatToPlayer("Unregistered Dimension " + dim + ".");
	}
	public static void addID(String line)
	{
		
	}

}
