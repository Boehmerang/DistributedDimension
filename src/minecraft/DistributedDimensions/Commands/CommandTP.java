package DistributedDimensions.Commands;

import java.util.ArrayList;
import java.util.List;

import DistributedDimensions.Common.DDTeleporter;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommandTP extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "DDTP"; //Name of the command
	}
    
	@Override
	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
    	return "/" + getCommandName() + " <DimID> [Player]";
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{	
		MinecraftServer mcServer = null;
		if (astring.length == 1)
		{
			Integer DimID = Integer.valueOf(astring[0]);
			if(icommandsender instanceof EntityPlayerMP)
			{
				EntityPlayerMP player = (EntityPlayerMP)icommandsender;
				Entity entity = player;
				boolean isPlayerOp = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().areCommandsAllowed(player.getCommandSenderName());
				mcServer = FMLCommonHandler.instance().getMinecraftServerInstance();
				WorldServer newworld = mcServer.worldServerForDimension(DimID);
				player.worldObj.updateEntityWithOptionalForce(player, false);
				if (isPlayerOp)
				{
					player.sendChatToPlayer("This will teleport you to Dim: " + DimID + ".");
					//player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DimName);
					player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DimID, new DDTeleporter(player.mcServer.worldServerForDimension(DimID)));
					//player.travelToDimension(DimID);
					/*boolean changingworlds = player.worldObj != newworld;
					 player.closeScreen();
					 if (changingworlds)
					 {
						 int spawnY = newworld.getSpawnPoint().posY;
						 player.dimension = DimID;
					     player.playerNetServerHandler.sendPacketToPlayer(new Packet9Respawn(player.dimension, (byte)player.worldObj.difficultySetting, newworld.getWorldInfo().getTerrainType(), newworld.getHeight(), player.theItemInWorldManager.getGameType()));
					     ((WorldServer)player.worldObj).getPlayerManager().removePlayer(player);
					     player.setLocationAndAngles(newworld.getSpawnPoint().posX + 0.5D, newworld.getSpawnPoint().posY + 2, newworld.getSpawnPoint().posZ + 0.5D, player.rotationYaw, player.rotationPitch);
					     ((WorldServer)newworld).theChunkProviderServer.loadChunk(newworld.getSpawnPoint().posX >> 4, newworld.getSpawnPoint().posZ >> 4);
					     while (getCollidingWorldGeometry(newworld, entity.boundingBox, entity).size() != 0) 
					     {
					    	spawnY += 1;
						     player.setLocationAndAngles(newworld.getSpawnPoint().posX + 0.5D, spawnY + 2, newworld.getSpawnPoint().posZ + 0.5D, player.rotationYaw, player.rotationPitch);
					     }
					     newworld.updateEntityWithOptionalForce(entity, false);
					     player.theItemInWorldManager.setWorld((WorldServer)newworld);
					     player.mcServer.getConfigurationManager().updateTimeAndWeatherForPlayer(player, (WorldServer)newworld);
					     player.mcServer.getConfigurationManager().syncPlayerInventory(player);
					 }*/
					 
				}
				else
				{
					player.sendChatToPlayer("Only OP's can Delete new Dimensions!");
				}
			}
		}
		else if (astring.length == 2)
		{
			String DimName = astring[0];
			String player2 = astring[1];
			if(icommandsender instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)icommandsender;
				boolean isPlayerOp = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().areCommandsAllowed(player.getCommandSenderName());
				if (isPlayerOp)
				{
					player.sendChatToPlayer("This will teleport " + player2 + " to " + DimName + ".");
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
	  private static List getCollidingWorldGeometry(World world, AxisAlignedBB axisalignedbb, Entity entity)
	  {
	    ArrayList collidingBoundingBoxes = new ArrayList();
	    int i = MathHelper.floor_double(axisalignedbb.minX);
	    int j = MathHelper.floor_double(axisalignedbb.maxX + 1.0D);
	    int k = MathHelper.floor_double(axisalignedbb.minY);
	    int l = MathHelper.floor_double(axisalignedbb.maxY + 1.0D);
	    int i1 = MathHelper.floor_double(axisalignedbb.minZ);
	    int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0D);
	    for (int k1 = i; k1 < j; k1++) {
	      for (int l1 = i1; l1 < j1; l1++) {
	        if (world.blockExists(k1, 64, l1))
	        {
	          for (int i2 = k - 1; i2 < l; i2++) {
	            Block block = Block.blocksList[world.getBlockId(k1, i2, l1)];
	            if (block != null)
	              block.addCollisionBoxesToList(world, k1, i2, l1, axisalignedbb, collidingBoundingBoxes, entity);
	          }
	        }
	      }
	    }
	    return collidingBoundingBoxes;
	  }
}
