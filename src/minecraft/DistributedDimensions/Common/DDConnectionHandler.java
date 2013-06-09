package DistributedDimensions.Common;

import universalelectricity.prefab.network.PacketManager;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class DDConnectionHandler implements IConnectionHandler
{
	public boolean connected = false;
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) 
	{
		manager.addToSendQueue(JoinPacketHandler.getPacket());
		//manager.addToSendQueue(DimsPacketHandler.getPacket(2,DistributedDimensions.WorldProSurfaceID));
		//PacketManager.sendPacketToClients(DimsPacketHandler.getPacket(null), netHandler.getPlayer().worldObj, netHandler.getPlayer().getPlayerCoordinates(), 4D);
		//PacketDispatcher.sendPacketToPlayer(DimsPacketHandler.getPacket(),(Player) netHandler.getPlayer());
		System.out.println("sent JoinPacket");
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) 
	{
		// TODO Auto-generated method stub
		//connected = true;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login)
	{
		// TODO Auto-generated method stub

	}

}
