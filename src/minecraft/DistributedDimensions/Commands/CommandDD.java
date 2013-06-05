package DistributedDimensions.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommandDD extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DD"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName();
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		if(icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)icommandsender;
			player.sendChatToPlayer("         Welcome to Distributed Dimensions!                  ");
			//player.sendChatToPlayer("-------------------------------------------------------------");
			player.sendChatToPlayer("              Available commands are:                        ");
			//player.sendChatToPlayer("-------------------------------------------------------------");
			player.sendChatToPlayer("/DDCreate [NAME] [TYPE]  -- Used to create a new Dimension.");
			player.sendChatToPlayer("/DDDelete [NAME]            -- Used to delete a Dimension.");
			player.sendChatToPlayer("/DDTP [NAME] [PLAYER]    -- Teleports Player to Dimension.");
			/*player.sendChatToPlayer("");
			player.sendChatToPlayer("");
			player.sendChatToPlayer("");
			player.sendChatToPlayer("");*/
			//player.sendChatToPlayer("-------------------------------------------------------------");
		}
	}

}