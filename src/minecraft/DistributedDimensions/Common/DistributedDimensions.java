package DistributedDimensions.Common;

import java.io.File;
import java.util.Collection;
import java.util.List;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import universalelectricity.prefab.network.PacketManager;
import DistributedDimensions.Commands.CommandCreate;
import DistributedDimensions.Commands.CommandDD;
import DistributedDimensions.Commands.CommandDelete;
import DistributedDimensions.Commands.CommandGetDim;
import DistributedDimensions.Commands.CommandList;
import DistributedDimensions.Commands.CommandTP;
import DistributedDimensions.WorldProviders.WorldProviderDD;
import DistributedDimensions.WorldProviders.WorldProviderDesertDD;
import DistributedDimensions.WorldProviders.WorldProviderEndDD;
import DistributedDimensions.WorldProviders.WorldProviderForestDD;
import DistributedDimensions.WorldProviders.WorldProviderHellDD;
import DistributedDimensions.WorldProviders.WorldProviderJungleDD;
import DistributedDimensions.WorldProviders.WorldProviderSwampDD;
import DistributedDimensions.WorldProviders.WorldProviderTundraDD;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Mod.ServerStopping;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "DisDimensions", name = "Distributed Dimensions", version = "0.0.1")
@NetworkMod(channels = "DisDimensions", clientSideRequired = true, serverSideRequired = false, packetHandler = PacketManager.class)
public class DistributedDimensions
{
	public static final String				modid				= "DisDimensions";
	public ConfigHandler config;
	public ConfigHandler config2;
	public File conPath;
	
	@Instance("DisDimensions")
	public static DistributedDimensions				instance			= new DistributedDimensions();	
	
	public static List<Integer> registeredDims;
	public static CommonProxy	proxy;
	public static int WorldProSurfaceID=50;
	public static int WorldProHellID=51;
	public static int WorldProEndID=52;
	public static int WorldProForestID=53;
	public static int WorldProJungleID=54;
	public static int WorldProTundraID=55;
	public static int WorldProDesertID=56;
	public static int WorldProSwampID=57;
	public String path;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftServer server = MinecraftServer.getServer();
		//this.path = server.worldServerForDimension(0).getWorldInfo().getWorldName();
		this.path = event.getModConfigurationDirectory().getAbsolutePath().toString().toString() + "/DisDimensions/";
		File Temp = new File(this.path);
		Temp.mkdir();
		//registeredDims = null;
		
		//this.config = new ConfigHandler(event.getSuggestedConfigurationFile());
		
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		DimensionManager.registerProviderType(WorldProSurfaceID, WorldProviderDD.class, false);
		DimensionManager.registerProviderType(WorldProHellID, WorldProviderHellDD.class, false);	
		DimensionManager.registerProviderType(WorldProEndID, WorldProviderEndDD.class, false);	
		DimensionManager.registerProviderType(WorldProForestID, WorldProviderForestDD.class, false);
		DimensionManager.registerProviderType(WorldProJungleID, WorldProviderJungleDD.class, false);
		DimensionManager.registerProviderType(WorldProTundraID, WorldProviderTundraDD.class, false);
		DimensionManager.registerProviderType(WorldProDesertID, WorldProviderDesertDD.class, false);
		DimensionManager.registerProviderType(WorldProSwampID, WorldProviderSwampDD.class, false);
		//this.config.readConfig();
		//MinecraftServer server = MinecraftServer.getServer(); //Gets current server
	}
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
	}

    @ServerStarting
	public void serverStart(FMLServerStartingEvent event)
	{
    	
    	MinecraftServer server = MinecraftServer.getServer(); //Gets current server
    	ICommandManager command = server.getCommandManager(); //Gets the command manager to use for server
    	ServerCommandManager serverCommand = ((ServerCommandManager) command); //Turns it into another form to use
    	serverCommand.registerCommand(new CommandCreate());
    	serverCommand.registerCommand(new CommandDelete());
    	serverCommand.registerCommand(new CommandDD());
    	serverCommand.registerCommand(new CommandTP());
       	serverCommand.registerCommand(new CommandList());
       	serverCommand.registerCommand(new CommandGetDim());
       	
       //	Boolean pathexists = (path.)
       	
       	String name = server.worldServerForDimension(0).getWorldInfo().getWorldName();
       	this.conPath = new File(path + name + ".cfg");
		this.config = new ConfigHandler(this.conPath);
		this.config.readConfig();
	}
    
    @ServerStopping
    public void ServerStop(FMLServerStoppingEvent event)
    {
    	ConfigHandler.unRegisterDims();
    }
}
