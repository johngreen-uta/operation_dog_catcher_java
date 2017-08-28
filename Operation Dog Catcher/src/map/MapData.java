package map;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author John Green
 * 
 * description: handles file I/O and data storage
 * 
 * some code has been modified from professor Eric Becker's mary ellen carter examples
 * https://elearn.uta.edu/webapps/portal/frameset.jsp?tab_tab_group_id=_2_1&url=%2Fwebapps%2Fblackboard%2Fexecute%2Flauncher%3Ftype%3DCourse%26id%3D_228496_1%26url%3D
 *
 */
public class MapData 
{
	int charMap[][];
	int waterInt;
	int buildingInt;
	int vegetationInt;
	int rubbleInt;
	int slimeInt;
	int hologramInt;
	int heroInt;
	int alienInt;
	int ghostInt;
	int stargateInt;
	char waterChar;
	char buildingChar;
	char vegetationChar;
	char rubbleChar;
	char slimeChar;
	char hologramChar;
	char heroChar;
	char alienChar;
	char ghostChar;
	char stargateChar;

	ArrayList <MapNode> mapNodeList = new ArrayList<MapNode>(2793);
	private ArrayList <Neighborhood> hoodList = new ArrayList<Neighborhood>();
	
	public MapData()
	{
		charMap=new int[147][19];
		waterInt=0;
		buildingInt=1;
		vegetationInt=2;
		rubbleInt=3;
		slimeInt=4;
		hologramInt=5;
		heroInt=6;
		alienInt=7;
		ghostInt=8;
		stargateInt=9;
		waterChar='W';
		buildingChar='B';
		vegetationChar='G';
		rubbleChar='R';
		slimeChar='E';
		hologramChar='X';
		heroChar='H';
		alienChar='A';
		ghostChar='g';
		stargateChar='@';
		buildNeighborhoodList();
		Collections.sort(getHoodList());
	}
	
	private void buildNeighborhoodList()
	{
		File folder = new File("..\\Neighborhoods");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				getHoodList().add(buildNeighborhood(listOfFiles[i].getName()));
			} 
		}
	}
	
	private Neighborhood buildNeighborhood(String hood)
	{
		Neighborhood temphood=new Neighborhood();
		String[] token = hood.split("\\.");
		temphood.setName(token[0]);
		temphood.setMap(getNeighborhoodMap(hood));
		return temphood;
	}
	
	private int[][] getNeighborhoodMap(String filename) {
		// TODO Auto-generated method stub
		int neighborhood[][]=new int[147][19];
		int pos=0;
		int row=0;
		int col=0;
		
		try
		{
			File inputFile=new File("..\\Neighborhoods\\"+filename);
			
			Scanner input=new Scanner(inputFile);
			String newline;

			newline=input.nextLine();
			while(pos < 2793)
			{
				neighborhood[col][row] = newline.charAt(pos)-48;
				pos+=1;
				col+=1;
				if(pos%147 == 0)
				{
					row+=1;
					col=0;
				}
			}
			input.close();
		
		}
		catch(Exception e)
		{
			System.out.println(filename+" did not load");
			e.printStackTrace(System.err);
		}
		return neighborhood;
	}

	public int[][] GetCharMap()
	{
		return charMap;
	}
	
	/**
	 * @param
	 * @return mapNodeList
	 * @exception
	 */
	public ArrayList<MapNode> GetMapNodes() 
	{
		return mapNodeList;
	}
	/**
	 * @param 
	 * @return void
	 * @exception
	 * description: pulls data from file and stores the data in an arraylist
	 */
	public void Load() 
	{
		// initialize variables
		String fileName;
		LoadFile load = new LoadFile();
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("..\\saves\\"));
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			fileName = ("..\\saves\\"+chooser.getSelectedFile().getName());
		}
		else
			return;
		
		mapNodeList = load.BuildFile(fileName);
		
		MakeMap();
	}

	/**
	 * @param 
	 * @return void
	 * @exception no file loaded
	 * description; builds a character map from data set
	 */
	public void MakeMap()
	{
		try
		{
			// initialize values
			ArrayList<MapNode> map_Nodes=GetMapNodes();
			int maxLoop=0;
			maxLoop=map_Nodes.size();
			int mapLoop=0;
			int row;
			int col;
			int symbol=-1;
			MapNode temp=null;

			// loop through data set and sets chars on the character map
			for (mapLoop=0;mapLoop<maxLoop;mapLoop++)
			{
				temp=map_Nodes.get(mapLoop);
				row=temp.row;
				col=temp.col;
				
				if(temp.getAlienList().size() > 0 && temp.survey)
				{
					symbol=hologramInt;
				}
				else if(temp.getHeroList().size() > 0 && temp.survey)
				{
					symbol=rubbleInt;
				}
				else if(temp.getGhostList().size() > 0 && temp.survey)
				{
					symbol=slimeInt;
				}
				else if(temp.feature == 'W')
				{
					symbol=waterInt;
				}
				else if(temp.feature == 'B')
				{
					symbol=buildingInt;
				}
				else if(temp.feature == 'G')
				{
					symbol=vegetationInt;
				}
				else
					symbol=-1;
				charMap[col][row]=symbol; // add to char map

			}
		}
		catch (Exception e) // file not loaded
		{
			System.out.println("invalid file");
		}	
	}
	
	/**
	 * @param char i, char ch
	 * @return void
	 * @exception none
	 * description swaps previous char i with the new char ch
	 */
	public void UpdateCharMap(char oldChar, char newChar) {
		for(int row=0; row < 19; row++)
		{
			for(int col=0; col < 147; col++)
			{
				if(charMap[col][row] == oldChar)
				{
					charMap[col][row] = newChar;
				}
			}
		}
	}
	
	/**
	 * @param int row, int col
	 * @return boolean
	 * @exception index out of range
	 * description; check if a node exist in the data set
	 */
	public boolean Exists(int row, int col) 
	{
		try // loop through data set looking for a match
		{
			if(mapNodeList.get((row*147)+col) != null)
			{
				return true;
			}
			return false;
		}
		catch (Exception e) // out of range
		{
			return false;
		}
	}
	
	/**
	 * @param 
	 * @return void
	 * @exception file not found
	 * description; save data to specified file
	 */
	public void Save() 
	{
		SaveFile Save = new SaveFile();
		
		Save.Save(mapNodeList);
	}
	/**
	 * @param Map_Draw map_Draw
	 * @return void
	 * @exception file not found
	 */

	public void Clear() {
		
		LoadFile load = new LoadFile();

		mapNodeList = load.BuildFile("..\\saves\\EmptyManhattan.txt");

		MakeMap();
	}

	public String PkeScan(String row, String col) {
		// TODO Auto-generated method stub
		if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getGhostList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = ghostInt;
			return getGhostReport(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getGhostList());
		}
		return "Scan failed to find anything\n";
	}

	private String getGhostReport(ArrayList<Object> ghostList) {
		// TODO Auto-generated method stub
		String text="";
		text=text+"Ghosts: "+ghostList.size()+"\n";
		for(int i = 0; i < ghostList.size(); i++)
		{
			if(ghostList.get(i) instanceof SlimeNode)
			{
				SlimeNode slime = (SlimeNode) ghostList.get(i);
				text=text+i+":\tSlime\t"+slime.getVolume()+"\t"+slime.getPowerLevel()+"\n";
			}
			else if(ghostList.get(i) instanceof MucusNode)
			{
				MucusNode mucus = (MucusNode) ghostList.get(i);
				text=text+i+":\tMucus\t"+mucus.getDiameter()+"\t"+mucus.getHeight()+"\t"+mucus.getPowerLevel()+"\n";
			}
			else if(ghostList.get(i) instanceof ChunkyNode)
			{
				ChunkyNode chunky = (ChunkyNode) ghostList.get(i);
				text=text+i+":\tExtra-Chunky\t"+chunky.getSmell()+"\t"+chunky.getPowerLevel()+"\n";
			}
		}
		return text;
	}

	public String SpectrailScan(String row, String col) {
		// TODO Auto-generated method stub
		if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getAlienList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = alienInt;
			return getAlienReport(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getAlienList());
		}
		return "Scan failed to find anything\n";
	}

	private String getAlienReport(ArrayList<Object> alienList) {
		// TODO Auto-generated method stub
		String text="";
		text=text+"Aliens: "+alienList.size()+"\n";
		for(int j =0; j < alienList.size(); j++)
		{
			if(alienList.get(j) instanceof StarShipNode)
			{
				StarShipNode starship = (StarShipNode) alienList.get(j);
				text=text+j+":\tStarship\t"+starship.getClassification()+"\t"+starship.getPlanet()+"\n";
			}
			else if(alienList.get(j) instanceof StargateNode)
			{
				StargateNode stargate = (StargateNode) alienList.get(j);
				text=text+j+":\tTHE STARGATE\t"+stargate.getPlanet()+"\n";
			}
			else if(alienList.get(j) instanceof HiddenLairNode)
			{
				HiddenLairNode lair = (HiddenLairNode) alienList.get(j);
				text=text+j+":\tLair\t"+lair.getNumber()+"\t"+lair.getStreet()+"\t"+lair.getPlanet()+"\n";
			}
		}
		return text;
	}

	public String VisualScan(String row, String col) {
		// TODO Auto-generated method stub
		if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getHeroList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = heroInt;
			return getHeroReport(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getHeroList());
		}
		return "Scan failed to find anything\n";
	}

	private String getHeroReport(ArrayList<Object> heroList) {
		// TODO Auto-generated method stub
		String text="";
		text=text+"Heros: "+heroList.size()+"\n";
		for(int j =0; j < heroList.size(); j++)
		{
			HeroNode hero = (HeroNode) heroList.get(j);
			text=text+j+":\t"+hero.getAge()+"\n";
		}
		return text;
	}

	public void SendInspector(String row, String col) {
		// TODO Auto-generated method stub
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).survey = true;
		if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getGhostList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = slimeInt;
		}
		else if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getAlienList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = hologramInt;
		}
		else if(mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).getHeroList().size() > 0)
		{
			charMap[Integer.valueOf(col)][Integer.valueOf(row)] = rubbleInt;
		}
	}

	public String getPkeScan() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == ghostInt)
				{
					mapString+="F";
				}
				else if(charMap[j][i] == slimeInt)
				{
					mapString+="T";
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getSpectrailScan() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == alienInt)
				{
					mapString+="F";
				}
				else if(charMap[j][i] == hologramInt)
				{
					mapString+="T";
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getVisualScan() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == heroInt)
				{
					mapString+="F";
				}
				else if(charMap[j][i] == rubbleInt)
				{
					mapString+="T";
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getPkeCount() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == slimeInt)
				{
					mapString+=mapNodeList.get( (i*147)+j ).getGhostList().size();
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getSpectrailCount() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == hologramInt)
				{
					mapString+=mapNodeList.get( (i*147)+j ).getAlienList().size();
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getVisualCount() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == rubbleInt)
				{
					mapString+=mapNodeList.get( (i*147)+j ).getHeroList().size();
				}
				else
				{
					mapString+=" ";
				}
			}
			mapString+="\n";
		}
		return mapString;
	}

	public String getReport() {
		// TODO Auto-generated method stub		
		
		int i, j;
		String text="";
		MapNode tempNode;
		StarShipNode starship;
		StargateNode stargate;
		HiddenLairNode lair;
		HeroNode hero;
		SlimeNode slime;
		MucusNode mucus;
		ChunkyNode chunky;
		
		for(i =0; i < mapNodeList.size(); i++)
		{
			tempNode = mapNodeList.get(i);
			text=text+"============\n";
			text=text+tempNode.lon+", "+tempNode.lat+"\n";
			text=text+tempNode.feature+", "+tempNode.survey+"\n";
			if(tempNode.getAlienList().size() > 0)
			{
				updateAlien(tempNode.getAlienList().size(),tempNode.row,tempNode.col);
				text=text+"Aliens: "+tempNode.getAlienList().size()+"\n";
				for(j =0; j < tempNode.getAlienList().size(); j++)
				{
					if(tempNode.getAlienList().get(j) instanceof StarShipNode)
					{
						starship = (StarShipNode) tempNode.getAlienList().get(j);
						text=text+j+":\tStarship\t"+starship.getClassification()+"\t"+starship.getPlanet()+"\n";
					}
					else if(tempNode.getAlienList().get(j) instanceof StargateNode)
					{
						stargate = (StargateNode) tempNode.getAlienList().get(j);
						text=text+j+":\tTHE STARGATE\t"+stargate.getPlanet()+"\n";
					}
					else if(tempNode.getAlienList().get(j) instanceof HiddenLairNode)
					{
						lair = (HiddenLairNode) tempNode.getAlienList().get(j);
						text=text+j+":\tLair\t"+lair.getNumber()+"\t"+lair.getStreet()+"\t"+lair.getPlanet()+"\n";
					}
				}
			}
			else if(tempNode.getHeroList().size() > 0)
			{
				updateHero(tempNode.getHeroList().size(),tempNode.row,tempNode.col);
				text=text+"Heros: "+tempNode.getHeroList().size()+"\n";
				for(j =0; j < tempNode.getHeroList().size(); j++)
				{
					hero = (HeroNode) tempNode.getHeroList().get(j);
					text=text+j+":\t"+hero.getAge()+"\n";
				}
			}
			else if(tempNode.getGhostList().size() > 0)
			{
				updateGhost(tempNode.getGhostList().size(),tempNode.row,tempNode.col);
				text=text+"Ghosts: "+tempNode.getGhostList().size()+"\n";
				for(j =0; j < tempNode.getGhostList().size(); j++)
				{
					if(tempNode.getGhostList().get(j) instanceof SlimeNode)
					{
						slime = (SlimeNode) tempNode.getGhostList().get(j);
						text=text+j+":\tSlime\t"+slime.getVolume()+"\t"+slime.getPowerLevel()+"\n";
					}
					else if(tempNode.getGhostList().get(j) instanceof MucusNode)
					{
						mucus = (MucusNode) tempNode.getGhostList().get(j);
						text=text+j+":\tMucus\t"+mucus.getDiameter()+"\t"+mucus.getHeight()+"\t"+mucus.getPowerLevel()+"\n";
					}
					else if(tempNode.getGhostList().get(j) instanceof ChunkyNode)
					{
						chunky = (ChunkyNode) tempNode.getGhostList().get(j);
						text=text+j+":\tExtra-Chunky\t"+chunky.getSmell()+"\t"+chunky.getPowerLevel()+"\n";
					}
				}
			}
		}
		
		text=text+String.format("%-20s %-10s %-10s %-10s\n","Neighborhood","Aliens","Heros","Ghosts");
		Neighborhood temphood;
		for(i=0; i<getHoodList().size(); i++)
		{
			temphood = getHoodList().get(i);
			text=text+String.format("%-20s %-10d %-10d %-10d\n",temphood.getName(),temphood.getAlienCount(),temphood.getHeroCount(),temphood.getGhostCount());
		}
		return text;
	}

		
	private void updateAlien(int size, int row, int col) {
		// TODO Auto-generated method stub
		Neighborhood temphood;
		for(int i=0; i<getHoodList().size(); i++)
		{
			temphood = getHoodList().get(i);
			if(temphood.getMap()[col][row] == 1)
				temphood.setAlienCount(temphood.getAlienCount() + 1);
		}
	}
	
	private void updateHero(int size, int row, int col) {
		// TODO Auto-generated method stub
		Neighborhood temphood;
		for(int i=0; i<getHoodList().size(); i++)
		{
			temphood = getHoodList().get(i);
			if(temphood.getMap()[col][row] == 1)
				temphood.setHeroCount(temphood.getHeroCount() + 1);
		}
	}
	
	private void updateGhost(int size, int row, int col) {
		// TODO Auto-generated method stub
		Neighborhood temphood;
		for(int i=0; i<getHoodList().size(); i++)
		{
			temphood = getHoodList().get(i);
			if(temphood.getMap()[col][row] == 1)
				temphood.setGhostCount(temphood.getGhostCount() + 1);
		}
	}

	public void changeSymbol(String water2, String building2,
			String vegetation2, String rubble2, String slime2,
			String hologram2, String hero2, String ghost2, String alien2, String stargate) {
		// TODO Auto-generated method stub
		if(water2.length() > 0)
			waterChar=water2.charAt(0);
		if(building2.length() > 0)
			buildingChar=building2.charAt(0);
		if(vegetation2.length() > 0)
			vegetationChar=vegetation2.charAt(0);
		if(rubble2.length() > 0)
			rubbleChar=rubble2.charAt(0);
		if(slime2.length() > 0)
			slimeChar=slime2.charAt(0);
		if(hologram2.length() > 0)
			hologramChar=hologram2.charAt(0);
		if(hero2.length() > 0)
			heroChar=hero2.charAt(0);
		if(alien2.length() > 0)
			alienChar=alien2.charAt(0);
		if(ghost2.length() > 0)
			ghostChar=ghost2.charAt(0);
		if(stargate.length() > 0)
			stargateChar=stargate.charAt(0);
	}

	public ArrayList <Neighborhood> getHoodList() {
		return hoodList;
	}

	public void setHoodList(ArrayList <Neighborhood> hoodList) {
		this.hoodList = hoodList;
	}

}
