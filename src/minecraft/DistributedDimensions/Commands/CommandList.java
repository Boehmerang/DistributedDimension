package DistributedDimensions.Commands;

import scala.Int;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.DimensionManager;

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
		if(icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = ((EntityPlayer)icommandsender);
			Integer[] temparray = DimensionManager.getIDs();
			for ( int i=0; i > DimensionManager.getIDs().length; i++)
			{
				player.sendChatToPlayer(temparray[i].toString());
			}
		}
	}
}