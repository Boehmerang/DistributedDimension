package DistributedDimensions.Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.DimensionManager;
import DistributedDimensions.Common.DistributedDimensions;

public class ConfigHandler 
{
	 private static ArrayList lines = new ArrayList();
	  private static File path;
	  private static File path2;

	  public ConfigHandler(File path)
	  {
	    this.path = path;
	    path2 = this.path;
	  }

	  public void readConfig() {
	    BufferedReader reader = getReader();
	    if (reader == null) {
	      writeConfig();
	      return;
	    }
	    try
	    {
	      String line;
	      while ((line = reader.readLine()) != null)
	        if ((!line.trim().startsWith("#")) && (!line.isEmpty())) {
	          line = line.trim();
	          lines.add(line);
	          //DimensionRegister.addID(line);
	          if (line.contains(":"))
	          {
	        	  String[] split = line.split(":");
	        	  int id = Integer.parseInt(split[0]);
	        	  int pro = Integer.parseInt(split[1]);
	        	  DimensionManager.registerDimension(id, pro);
	          }
	          
	        }
	      reader.close();
	    } catch (IOException e) {
	      e.printStackTrace(System.err);
	    }
	  }

	  public static List getLines() {
	    return Collections.unmodifiableList(lines);
	  }

	  private static BufferedReader getReader() 
	  {
	    try 
	    {
	      FileInputStream fis = new FileInputStream(path2);
	      DataInputStream dis = new DataInputStream(fis);
	      return new BufferedReader(new InputStreamReader(dis)); 
	    }
	    catch (FileNotFoundException e) 
	    {
	    }
	    return null;
	  }
	  private static BufferedReader getReader2() 
	  {
	    try 
	    {
	      FileInputStream fis = new FileInputStream(path2);
	      DataInputStream dis = new DataInputStream(fis);
	      return new BufferedReader(new InputStreamReader(dis)); 
	    }
	    catch (FileNotFoundException e) 
	    {
	    }
	    return null;
	  }
	  
	  private void writeConfig()
	  {
	    try {
	      FileWriter fw = new FileWriter(this.path, true);
	      BufferedWriter writer = new BufferedWriter(fw);

	      writer.write("# The following format is used: <DimID>:<Name>\n");
	      writer.write("# Please do not edit this file it will break all\n");
	      writer.write("# the dimensions you edit.\n");

	      writer.close();
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }
	  
	  public static void addID(int id, int provider, String name)
	  {
		    try {
			      FileWriter fw = new FileWriter(path2, true);
			      BufferedWriter writer = new BufferedWriter(fw);

			      writer.write(id + ":" + provider + ":" + name + "\n");


			      writer.close();
			    } catch (Exception e) {
			      e.printStackTrace(System.err);
			    }
	  }

	  public static void ListDims(EntityPlayerMP player) 
	  {
		  BufferedReader reader = getReader();
		    try
		    {
		      String line;
		      while ((line = reader.readLine()) != null)
		        if ((!line.trim().startsWith("#")) && (!line.isEmpty())) {
		          line = line.trim();
		          if (line.contains(":"))
		          {
		        	  String type;
		        	  String[] split = line.split(":");
		        	  int ID = Integer.parseInt(split[0]);
		        	  int pro = Integer.parseInt(split[1]);
		        	  String name = String.valueOf(split[2]);
		        	  if (pro == DistributedDimensions.WorldProSurfaceID)
		        	  {
		        		  if (ID < 10)
		        		  {
		        			  player.sendChatToPlayer("   " + Integer.toString(ID) + ": Surface : " + name );
		        		  }
		        		  else if (ID > 9 && ID < 100)
		        		  {
		        			  player.sendChatToPlayer("  " + Integer.toString(ID) + ": Surface : " + name );
		        		  }
		        		  else if (ID > 100 && ID < 1000)
		        		  {
		        			  player.sendChatToPlayer(" " + Integer.toString(ID) + ": Surface : " + name );
		        		  }
		        	  }
		        	  if (pro == DistributedDimensions.WorldProHellID)
		        	  {
		        		  if (ID < 10)
		        		  {
		        			  player.sendChatToPlayer("   " + Integer.toString(ID) + ": Nether : " + name );
		        		  }
		        		  else if (ID > 9 && ID < 100)
		        		  {
		        			  player.sendChatToPlayer("  " + Integer.toString(ID) + ": Nether : " + name );
		        		  }
		        		  else if (ID > 100 && ID < 1000)
		        		  {
		        			  player.sendChatToPlayer(" " + Integer.toString(ID) + ": Nether : " + name );
		        		  }
		        	  }
		          }
		          
		        }
		      reader.close();
		    }
		    catch (IOException e) 
		    {
		    	e.printStackTrace(System.err);
		    }
	  }
	  
	public static void RemoveID(int dim)
	  {
		 File tempFile = new File(path2.getAbsolutePath()+".tmp");
		  BufferedReader reader = getReader();
		    try
		    { 
		    	FileWriter fw = new FileWriter(tempFile, true);
			      BufferedWriter writer = new BufferedWriter(fw);

		    	String line;
		    	while ((line = reader.readLine()) != null)
		    		if ((line.trim().startsWith("#")) && (!line.isEmpty()))
		    			writer.write(line + "\n");
		    		else if ((!line.trim().startsWith("#")) && (!line.isEmpty())) 
		    		{
		    			line = line.trim();
		    			String[] split = line.split(":");
		    			int ID = Integer.parseInt(split[0]);
		    			if (ID != dim)
		    			{      
		    				writer.write(line + "\n");
		    			}
		    		}  
		    	
		    	writer.close();
		    	reader.close();
		    	
		    	if (!path.delete())
		    	{
		    	    System.out.println("Could not delete file");
		    	    return;
		    	}
		    	
		    	if(!tempFile.renameTo(path))
		    	{
		    		 System.out.println("Could not rename file");
		    	}
		 
		    	
		    }
		    catch (FileNotFoundException ex) 
		    {
		    	  ex.printStackTrace();
		    }
		    catch (IOException e) 
		    {
		    	e.printStackTrace(System.err);
		    }
	  }
	  
	public static String getDimName(int dim)
	{
		 BufferedReader reader = getReader2(); 
		    try
		    {
		    	String line;
		    	while ((line = reader.readLine()) != null)
		    		if ((!line.trim().startsWith("#")) && (!line.isEmpty())) 
		    		{
		    			line = line.trim();
		    			if (line.contains(":"))
		    			{
		    				String type;
		    				String[] split = line.split(":");
		    				int ID = Integer.parseInt(split[0]);		        	  
		    				String name = String.valueOf(split[2]);
		    				if (ID == dim)
		    				{
		    					return name;
		    				}
		        		  
		    			}
		    			
		    		}
		    	reader.close();
		    }
		    catch (IOException e) 
		    {
		    	e.printStackTrace(System.err);
			}
		return "Unnamed";
	}
	  
}