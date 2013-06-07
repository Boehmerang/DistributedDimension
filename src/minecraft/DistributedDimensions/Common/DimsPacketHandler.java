package DistributedDimensions.Common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import scala.Int;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class DimsPacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
		EntityPlayer sender = (EntityPlayer) player;
		
	}
	
	 public static Packet getPacket(List<Integer> set) 
	 {
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    DataOutputStream data = new DataOutputStream(bos);
		    String[] set2 = (String[]) set.toArray();
		    try
		    {
		    	//data.writeByte(packetId);
		    	//data.writeInt(set.size());
		    	for (int i = 0 ; i < set.size(); i++)
		    	{	
		    		int id = Integer.valueOf(set2[i]);
		        	data.writeInt(id);
		        	//data.
		    	}
		    }
		    catch (IOException e) 
		    {
		    	e.printStackTrace();
		    }


		    Packet250CustomPayload pkt = new Packet250CustomPayload();
		    pkt.channel = "DisDimensions";
		    pkt.data = bos.toByteArray();
		    pkt.length = bos.size();
		    pkt.isChunkDataPacket = false;
		    return pkt;
		  }
}