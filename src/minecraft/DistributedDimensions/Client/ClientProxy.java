package DistributedDimensions.Client;

import DistributedDimensions.Common.CommonProxy;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	 @SideOnly(Side.CLIENT)
	 @ForgeSubscribe
	 public void initializeIcons(TextureStitchEvent.Post event)
	 {

	 }
	 
	 
	 @Override
	  public void registerRenderThings()
	 {

		
	 }
}
