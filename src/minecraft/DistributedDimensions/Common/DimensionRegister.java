package DistributedDimensions.Common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegister extends DimensionManager
{
	public static DimensionRegister instance = new DimensionRegister();
	public static List<Integer> OwDims = new ArrayList<Integer>();
	public static List<Integer> NetDims = new ArrayList<Integer>();
	public static List<Integer> EndDims = new ArrayList<Integer>();
	public static int DimID;
	
	public static void Register(String name, int type, EntityPlayer player)
	{
		switch (type)
		{
		case 1:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProSurfaceID);
			break;
		case 2:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProHellID);
			break;
		case 3:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProEndID);
			break;
		case 4:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProForestID);
			break;
		case 5:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProJungleID);
			break;
		case 6:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProTundraID);
			break;
		case 7:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProDesertID);
			break;
		case 8:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			registerDimension(DimID, DistributedDimensions.WorldProSwampID);
			break;
		default:
			break;
		}
		
		
	}
	public static void unRegister(int dim, EntityPlayer player)
	{
			player.sendChatToPlayer("Unregistering Dimension " + dim + ".");
			unregisterDimension(dim);
			player.sendChatToPlayer("Unregistered Dimension " + dim + ".");
	}
	public static void addID(String line)
	{
		
	}

}
