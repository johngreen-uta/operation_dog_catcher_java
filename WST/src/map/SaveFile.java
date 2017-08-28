package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JFileChooser;

public class SaveFile {
	
	File mapFile=null;

	public void Save(ArrayList <MapNode> mapNodeList) 
	{
		// initialize variables
		int fileLoop=0;
		float lat=0;
		float lon=0;
		char symbol=' ';
		String text="";

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("..\\saves\\"));
	    int returnVal = chooser.showSaveDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       mapFile=new File("..\\saves\\"+chooser.getSelectedFile().getName());
	    }
	    else
	    	return;
		
		//System.out.printf("saving to %s\n",filename);
		//mapFile=new File("..\\saves\\"+filename);
		
		try // try save to specified file
		{
			Formatter myFormatter;
			myFormatter = new Formatter(mapFile);
			
			for (fileLoop=0;fileLoop<mapNodeList.size();fileLoop++)
			{
				text="";
				//System.out.format("%s\n",mapNodeList.get(fileLoop).feature);
				switch (mapNodeList.get(fileLoop).feature)
				{
				case 'W':
					symbol='W';
					break;
				case 'B':
					symbol='B';
					break;
				case 'G':
					symbol='G';
					break;
				default:
					symbol='?';
					break;
				}
				//System.out.format("test enter 85****\n");
				lat = (float) ((0.001188306*(mapNodeList.get(fileLoop).col))+40.70032);
				lon = (float) ((0.004632053*(mapNodeList.get(fileLoop).row))-74.0171900000);
				text=text+lon+','+lat+','+symbol+','+mapNodeList.get(fileLoop).survey;
				if (mapNodeList.get(fileLoop).alienList.size() > 0)
				{
					text=text+",A,"+mapNodeList.get(fileLoop).alienList.size();
					text+=getAlienNodeSave(mapNodeList.get(fileLoop).alienList);
				}
				if (mapNodeList.get(fileLoop).heroList.size() > 0)
				{
					//System.out.format("test hero\n");
					text=text+",H,"+mapNodeList.get(fileLoop).heroList.size();
					text+=getHeroNodeSave(mapNodeList.get(fileLoop).heroList);
				}
				if (mapNodeList.get(fileLoop).ghostList.size() > 0)
				{
					text=text+",G,"+mapNodeList.get(fileLoop).ghostList.size();
					text+=getGhostNodeSave(mapNodeList.get(fileLoop).ghostList);
				}
				myFormatter.format("%s\n",text);
			}
			
			myFormatter.close();
		} catch (FileNotFoundException e) // file does not exist
		{
			System.out.println("file not found");
			return;
		}
	}

	private String getGhostNodeSave(ArrayList<Object> ghostList) {
		// TODO Auto-generated method stub
		String text="";
		ChunkyNode tempChunky;
		MucusNode tempMucus;
		SlimeNode tempSlime;

		for(int i = 0; i < ghostList.size(); i++)
		{
			if(ghostList.get(i) instanceof ChunkyNode)
			{
				tempChunky = (ChunkyNode) ghostList.get(i);
				text=text+",Extra-Chunky,"+tempChunky.getSmell()+','+tempChunky.getPowerLevel();
				//System.out.println(text+" 888 *-");
			}
			else if(ghostList.get(i) instanceof MucusNode)
			{
				tempMucus = (MucusNode) ghostList.get(i);
				text=text+",Mucus,"+tempMucus.getDiameter()+','+tempMucus.getHeight()+','+tempMucus.getPowerLevel();
			}
			else if(ghostList.get(i) instanceof SlimeNode)
			{
				tempSlime = (SlimeNode) ghostList.get(i);
				text=text+",Slime,"+tempSlime.getVolume()+','+tempSlime.getPowerLevel();
			}
		}
		return text;
	}

	private String getHeroNodeSave(ArrayList<Object> heroList) {
		// TODO Auto-generated method stub
		String text="";
		//System.out.format("test 47*****\n");
		for(int i = 0; i < heroList.size(); i++)
		{
			//System.out.format("test\n");
			text=text+','+Integer.toString( (((HeroNode) heroList.get(i)).getAge()));
		}
		return text;
	}

	private String getAlienNodeSave(ArrayList<Object> alienList) {
		// TODO Auto-generated method stub
		String text="";
		StarShipNode tempShip;
		HiddenLairNode tempLair;
		StargateNode tempStargate;

		for(int i = 0; i < alienList.size(); i++)
		{
			if(alienList.get(i) instanceof StarShipNode)
			{
				tempShip = (StarShipNode) alienList.get(i);
				text=text+",Starship,"+tempShip.getClassification()+','+tempShip.getPlanet();
			}
			else if(alienList.get(i) instanceof HiddenLairNode)
			{
				tempLair = (HiddenLairNode) alienList.get(i);
				text=text+",Lair,"+tempLair.getNumber()+','+tempLair.getStreet()+','+tempLair.getPlanet();
			}
			else if(alienList.get(i) instanceof StargateNode)
			{
				tempStargate = (StargateNode) alienList.get(i);
				text=text+",Stargate,"+tempStargate.getPlanet();
			}
		}
		return text;
	}
}
