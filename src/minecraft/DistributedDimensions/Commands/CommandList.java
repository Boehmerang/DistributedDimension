package DistributedDimensions.Commands;

import DistributedDimensions.Common.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommandList extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DDList"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName();
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

		if(icommandsender instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = ((EntityPlayerMP)icommandsender);
			int dims = DimensionManager.getNextFreeDimId();//.getIDs();


				player.sendChatToPlayer("========================================");
				player.sendChatToPlayer("         MC-Vanilla Dimensions          ");
				player.sendChatToPlayer("========================================");
				player.sendChatToPlayer("  -1:     The Nether                    ");
				player.sendChatToPlayer("   0:     OverWorld                     ");
				player.sendChatToPlayer("   1:     The End                       ");
				player.sendChatToPlayer("========================================");
				player.sendChatToPlayer("         Distributed Dimensions         ");
				player.sendChatToPlayer("========================================");
				ConfigHandler.ListDims(player);
				player.sendChatToPlayer("========================================");
				
				/*if (server.worldServers != null)
				{
					for (Integer id : DimensionManager.getIDs())
					{
						if (id.SIZE == 1)
							player.sendChatToPlayer("  " + id + ":     Name           Type        ");
						if (id.SIZE == 2)
							player.sendChatToPlayer(" " + id + ":     Name           Type        ");
						if (id.SIZE == 3)
							player.sendChatToPlayer(id + ":     Name           Type        ");
					}
				}*/
				
			
		}
	}
}