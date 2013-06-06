package DistributedDimensions.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLCommonHandler;
import DistributedDimensions.Common.ConfigHandler;
import DistributedDimensions.Common.DimensionRegister;
import DistributedDimensions.Common.DistributedDimensions;

public class CommandDelete extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DDDelete"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName() + " <Name>";
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		if (astring.length == 1)
		{
			int DimID = Integer.parseInt(astring[0]);
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)icommandsender;
				boolean isPlayerOp = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().areCommandsAllowed(player.getCommandSenderName());
				if (isPlayerOp)
				{
					player.sendChatToPlayer("This will delete the world named " + DimID + ".");
					DimensionRegister.unRegister(DimID, player);
					player.sendChatToPlayer("Deletion Complete");
					ConfigHandler.RemoveID(DimID);
				}
				else
				{
					player.sendChatToPlayer("Only OP's can Delete new Dimensions!");
				}
			}
		}
		else //catch (Exception e)
		{
			throw new WrongUsageException("/" + getCommandName() + " [Name]");
		}
	}

}