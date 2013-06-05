package DistributedDimensions.Common;

import DistributedDimensions.Commands.CommandCreate;
import DistributedDimensions.Commands.CommandDD;
import DistributedDimensions.Commands.CommandDelete;
import DistributedDimensions.Commands.CommandGetDim;
import DistributedDimensions.Commands.CommandList;
import DistributedDimensions.Commands.CommandTP;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import universalelectricity.prefab.network.PacketManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "DisDimensions", name = "Distributed Dimensions", version = "0.0.1")
@NetworkMod(channels = "DisDimensions", clientSideRequired = true, serverSideRequired = false, packetHandler = PacketManager.class)
public class DistributedDimensions
{
	public static final String				modid				= "DisDimensions";
	
	@Instance("DisDimensions")
	public static DistributedDimensions				instance			= new DistributedDimensions();	
	
	//@SidedProxy(clientSide = "murdercoins.client.ClientProxy", serverSide = "murdercoins.common.CommonProxy")
	
	public static CommonProxy	proxy;
	public static int WorldProSurfaceID=50;
	public static int WorldProHellID=51;
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		DimensionManager.registerProviderType(WorldProSurfaceID, WorldProviderDD.class, false);
		DimensionManager.registerProviderType(WorldProHellID, WorldProviderHellDD.class, false);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
	}

    @ServerStarting
	public void serverStart(FMLServerStartingEvent event)
	{
    	/*
    	 * add for loop for list array of registered dimensions.
    	 */
    	if(DimensionRegister.OwDims != null)
    	{
    		for(int i = 0; i > DimensionRegister.OwDims.size(); i++)
    		{
    			DimensionManager.registerDimension(i, WorldProSurfaceID);
    		}
    	}
    	
    	MinecraftServer server = MinecraftServer.getServer(); //Gets current server
    	ICommandManager command = server.getCommandManager(); //Gets the command manager to use for server
    	ServerCommandManager serverCommand = ((ServerCommandManager) command); //Turns it into another form to use
    	serverCommand.registerCommand(new CommandCreate());
    	serverCommand.registerCommand(new CommandDelete());
    	serverCommand.registerCommand(new CommandDD());
    	serverCommand.registerCommand(new CommandTP());
       	serverCommand.registerCommand(new CommandList());
       	serverCommand.registerCommand(new CommandGetDim());
	}
}
