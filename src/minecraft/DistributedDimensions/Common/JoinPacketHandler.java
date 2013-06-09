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
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class JoinPacketHandler// implements IPacketReceiver
{

	
	 public static Packet getPacket() 
	 {
		 
		 //int runtimes=0;
		 int id;
		 int pro;
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 DataOutputStream data = new DataOutputStream(bos);
		 /*
		 String[] set2 = (String[]) set.toArray();
		 List<Integer> ow = DimensionRegister.instance.OwDims;
		 if (ow != null)
			 runtimes++;
		 List<Integer> net = DimensionRegister.instance.NetDims;
		 if (net != null)
			 runtimes++;
		 List<Integer> end = DimensionRegister.instance.EndDims;
		 if (end != null)
			 runtimes++;
		 List<Integer> fore = DimensionRegister.instance.ForDims;
		 if (fore != null)
			 runtimes++;
		 List<Integer> jun = DimensionRegister.instance.JunDims;
		 if (jun != null)
			 runtimes++;
		 List<Integer> tun = DimensionRegister.instance.TunDims;
		 if (tun != null)
			 runtimes++;
		 List<Integer> des = DimensionRegister.instance.DesDims;
		 if (des != null)
			 runtimes++;
		 List<Integer> Swa = DimensionRegister.instance.SwaDims;
		 if (Swa != null)
			 runtimes++;
		 */
		 
		 List<Integer> regDims = DimensionRegister.instance.registeredDims;
		 try
		 {
			 if(regDims != null)
			 {
				 for(int i = 0; i < regDims.size(); i ++ )
				 {
					 id = regDims.get(i);
					 pro = DimensionManager.getProviderType(id);
					 System.out.println(id + " " + pro);
					 data.writeInt(id);
					 data.writeInt(pro);
				 }
			 }
			 else
				 data.writeInt(0);
		 }
		 catch (IOException e) 
		 {
			 e.printStackTrace();
		 }


		 Packet250CustomPayload pkt = new Packet250CustomPayload();
		 pkt.channel = "DDJoinPacket";
		 pkt.data = bos.toByteArray();
		 pkt.length = bos.size();
		 pkt.isChunkDataPacket = false;
		 return pkt;
	}
}