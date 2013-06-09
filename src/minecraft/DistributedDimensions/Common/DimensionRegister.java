package DistributedDimensions.Common;

import java.util.ArrayList;
import java.util.List;

import universalelectricity.prefab.network.PacketManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegister extends DimensionManager
{
	public static DimensionRegister instance = new DimensionRegister();
	
	public static List<Integer> OwDims = new ArrayList<Integer>();
	public static List<Integer> NetDims = new ArrayList<Integer>();
	public static List<Integer> EndDims = new ArrayList<Integer>();
	public static List<Integer> DesDims = new ArrayList<Integer>();
	public static List<Integer> JunDims = new ArrayList<Integer>();
	public static List<Integer> TunDims = new ArrayList<Integer>();
	public static List<Integer> SwaDims = new ArrayList<Integer>();
	public static List<Integer> ForDims = new ArrayList<Integer>();
	public List<Integer> registeredDims = new ArrayList<Integer>();
	
	public static int DimID;
	
	public void Register(String name, int type, EntityPlayer player)
	{
		if (registeredDims == null) registeredDims = new ArrayList<Integer>();
		switch (type)
		{
		case 1:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//OwDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProSurfaceID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProSurfaceID));
			break;
		case 2:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//NetDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProHellID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProHellID));
			break;
		case 3:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//EndDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProEndID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProEndID));
			break;
		case 4:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//ForDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProForestID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProForestID));
			break;
		case 5:
			DimID = getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//JunDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProJungleID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProJungleID));
			break;
		case 6:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//TunDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProTundraID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProTundraID));
			break;
		case 7:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//DesDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProDesertID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProDesertID));
			break;
		case 8:
			DimID = DimensionManager.getNextFreeDimId();
			player.sendChatToPlayer("Using Dimension ID: " + DimID);
			//SwaDims.add(DimID);
			registeredDims.add(DimID);
			registerDimension(DimID, DistributedDimensions.WorldProSwampID);
			PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(DimID, DistributedDimensions.WorldProSwampID));
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
