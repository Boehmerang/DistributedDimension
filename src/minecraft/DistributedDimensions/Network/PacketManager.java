package DistributedDimensions.Network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import universalelectricity.core.vector.Vector3;

import DistributedDimensions.Common.DimensionRegister;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;


public class PacketManager implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) 
	{
		// TODO Auto-generated method stub
		if (packet.channel.equals("DisDimensions"))
		{
			handleRandom(packet, player);
		}
		else if (packet.channel.equals("DDJoinPacket"))
		{
			if (packet.getPacketSize() == 1)
				return;
			else
				handleJoin(packet, player);
		}
	}
	
	private void handleRandom(Packet250CustomPayload packet, Player player)
	{
		System.out.println("packettest");
		int id;
		int pro;
		DataInputStream dataStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		//EntityPlayer play = (EntityPlayer) player;
		try
		{
		//int runtimes = dataStream.readInt();
		
		//for(int i = 0; i < runtimes; i++)
		//{
			id = dataStream.readInt();
			pro = dataStream.readInt();
			//int qty = dataStream.readInt();
			//for (int d = 0; d < qty; d++)
			//{
				//int id = dataStream.readInt();
				DimensionRegister.registerDimension(id, pro);
				//play.sendChatToPlayer("Registered Dimension " + id);
				System.out.println("Registed Dimension" + id + "with provider " + pro);
			//}
		//}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	private void handleJoin(Packet250CustomPayload packet, Player player)
	{
		System.out.println("joinpackettest-at handle");
		int run = packet.getPacketSize()/2;
		int id;
		int pro;
		DataInputStream dataStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		try
		{
			for (int i = 0; i < run; i++)
			{
				id = dataStream.readInt();
				pro = dataStream.readInt();
				System.out.println("Registering dimension " + id);
				DimensionManager.registerDimension(id, pro);
			}
		}
		catch(Exception e)
		{
			
		}
	}

}