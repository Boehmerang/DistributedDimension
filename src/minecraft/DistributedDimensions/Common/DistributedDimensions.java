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
	public ConfigHandler config;
	
	@Instance("DisDimensions")
	public static DistributedDimensions				instance			= new DistributedDimensions();	
	
	
	public static CommonProxy	proxy;
	public static int WorldProSurfaceID=50;
	public static int WorldProHellID=51;
	public static int WorldProEndID=52;
	public static int WorldProForestID=53;
	public static int WorldProJungleID=54;
	public static int WorldProTundraID=55;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		this.config = new ConfigHandler(event.getSuggestedConfigurationFile());
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
		this.config.readConfig();
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
	}
}
