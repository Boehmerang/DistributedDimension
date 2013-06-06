package DistributedDimensions.Commands;

import DistributedDimensions.Common.DimensionRegister;
import DistributedDimensions.Common.DistributedDimensions;
import DistributedDimensions.Common.ConfigHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;


public class CommandCreate extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DDCreate"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName() + " <Name> [Type]";
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		if (astring.length == 2)
		{
			String ComType = "";
			String DimName = astring[0];
			String setting = astring[1];
			/*switch (astring.length) 
			{
			case 2:
				setting = astring[2];
			case 1:
				DimName = astring[1];
				break;
			}*/
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)icommandsender;
				boolean isPlayerOp = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().areCommandsAllowed(player.getCommandSenderName());
				if (isPlayerOp)
				{
					if (setting.equalsIgnoreCase("normal"))
					{
						player.sendChatToPlayer("Creating a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 1, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProSurfaceID, DimName);
					}
					else if (setting.equalsIgnoreCase("Nether"))
					{
						player.sendChatToPlayer("This will create a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 2, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProHellID, DimName);
					}
					else if (setting.equalsIgnoreCase("End"))
					{
						player.sendChatToPlayer("This will create a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 3, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProEndID, DimName);
					}
					else if (setting.equalsIgnoreCase("Forest"))
					{
						player.sendChatToPlayer("This will create a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 4, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProForestID, DimName);
					}
					else if (setting.equalsIgnoreCase("Jungle"))
					{
						player.sendChatToPlayer("This will create a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 5, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProJungleID, DimName);
					}
					else if (setting.equalsIgnoreCase("Tundra"))
					{
						player.sendChatToPlayer("This will create a world named " + DimName + " of type " + setting);
						DimensionRegister.Register(DimName, 6, player);
						player.sendChatToPlayer("Creation Complete");
						ConfigHandler.addID(DimensionRegister.DimID, DistributedDimensions.WorldProJungleID, DimName);
					}
					else
					{
						throw new WrongUsageException("Type must be Normal, End, Nether, Forest, Jungle.");
					}
				}
				else
				{
					player.sendChatToPlayer("Only OP's can Create new Dimensions!");
				}
			}
		}
		else //catch (Exception e)
		{
			throw new WrongUsageException("/" + getCommandName() + " [Name] [Setting]");
		}
	}

}