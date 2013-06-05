package DistributedDimensions.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommandGetDim  extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DDGetDim"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName();
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		if(icommandsender instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)icommandsender;
			
			boolean isPlayerOp = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().areCommandsAllowed(player.getCommandSenderName());
			if (isPlayerOp)
			{
				player.sendChatToPlayer("Your are in Dimension: " + Integer.toString(player.dimension) + ".");
			}
			else
			{
				player.sendChatToPlayer("Only OP's can Delete new Dimensions!");
			}
		}
	}

}