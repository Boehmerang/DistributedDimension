package DistributedDimensions.Common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.io.ByteArrayDataInput;

import DistributedDimensions.Network.IPacketReceiver;

import scala.Int;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class DimsPacketHandler// implements IPacketReceiver
{
	 public static Packet getPacket(int ID, int pro) 
	 {
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 DataOutputStream data = new DataOutputStream(bos);
		 try
		 {
			 data.writeInt(ID);
			 data.writeInt(pro);

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