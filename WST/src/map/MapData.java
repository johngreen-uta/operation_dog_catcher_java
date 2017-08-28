package map;

import java.io.File;
import java.util.ArrayList;
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
	
	static StargateNode stargate=new StargateNode("",-1,-1);
	
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
		File inputFile = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("..\\saves\\"));
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			inputFile=new File("..\\saves\\"+chooser.getSelectedFile().getName());
		}
		else
			return;

		try
		{
		Scanner input=new Scanner(inputFile);
		String newline;

		while (input.hasNextLine())
		{
			newline=input.nextLine();
			String line []=newline.split(",");
	
			int pos=0;

			MapNode newNode = new MapNode();
			
			pos=doSquare(line,pos,newNode);
			
			
			if(line.length > 4)
			{
				pos=doType(line,pos,newNode);
			}
			
			mapNodeList.add(newNode);
		}
		input.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
		
		MakeMap();
	}
	
	private int doType(String[] line, int pos, MapNode newNode) {
		
		String weird=line[pos];
		pos=pos+1;
		switch(weird)
		{
		case "G":
			pos=doGhosts(line,pos,newNode);
			break;
		case "A":
			pos=doAliens(line,pos,newNode);
			break;
		case "H":
			pos=doHeros(line,pos,newNode);
			break;
		}
		return 0;
	}

	private int doGhosts(String[] line, int pos, MapNode newNode) {
		String ghosts;
		int ghostMax;
		ghosts=line[pos];
		pos=pos+1;
		ghostMax=Integer.parseInt(ghosts,10);
		ArrayList<Object> ghostList=new ArrayList<Object>(ghostMax);
		int countGhost=0;
		String ghostType;
		String ghostVolume;
		String ghostDiameter;
		String ghostHeight;
		String ghostSmell;
		String ghostPower;
			
		try
		{
		while (countGhost<ghostMax)
		{
			ghostType=line[pos];
			pos=pos+1;
 			
			switch (ghostType)
			{
			case "Slime":
				
				ghostVolume=line[pos];
				pos=pos+1;
				ghostPower=line[pos];
				pos=pos+1;
				SlimeNode newSlime=new SlimeNode(Integer.valueOf(ghostPower), Double.valueOf(ghostVolume));
				ghostList.add(newSlime);
				break;
			case "Mucus":
			
				ghostDiameter=line[pos];
				pos=pos+1;
				ghostHeight=line[pos];
				pos=pos+1;
				ghostPower=line[pos];
				pos=pos+1;
				MucusNode newMucus=new MucusNode(Integer.valueOf(ghostPower), Float.valueOf(ghostDiameter), Float.valueOf(ghostHeight));
				ghostList.add(newMucus);
				break;
			case "Extra-Chunky":
			{
				ghostSmell=line[pos];
				pos=pos+1;
				ghostPower=line[pos];
				pos=pos+1;
				ChunkyNode newChunky=new ChunkyNode(Integer.valueOf(ghostPower), ghostSmell);
				ghostList.add(newChunky);
				break;
			}
			default:
				System.err.print("Error:");
				System.err.printf("%c\n",ghostType.charAt(0));
			}
			countGhost=countGhost+1;
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		newNode.ghostList = ghostList;
		return pos;
	}

	private int doAliens(String[] line, int pos, MapNode newNode) {
	
		String alien;
		int alienMax;
		alien=line[pos];
		pos=pos+1;
		alienMax=Integer.parseInt(alien,10);
		ArrayList<Object> alienList=new ArrayList<Object>(alienMax);
		int countalien=0;
		String alienType;
		String alienShipType;
		String alienNumber;
		String alienStreet;
		String alienPlanet;
		while (countalien<alienMax)
		{
			alienType=line[pos];
			pos=pos+1;
			switch (alienType)
			{
			case "Starship":
				alienShipType=line[pos];
				pos=pos+1;
				alienPlanet=line[pos];
				pos=pos+1;
				StarShipNode newStarShip=new StarShipNode(alienPlanet, Integer.valueOf(alienShipType));
				alienList.add(newStarShip);
				break;
			case "Lair":
				
				alienNumber=line[pos];
				pos=pos+1;
				alienStreet=line[pos];
				pos=pos+1;
				alienPlanet=line[pos];
				pos=pos+1;
				HiddenLairNode newLair=new HiddenLairNode(alienPlanet, Integer.valueOf(alienNumber), alienStreet);
				alienList.add(newLair);
				break;
			case "Stargate":
				alienPlanet=line[pos];
				pos=pos+1;
				if(stargate.row != -1)
				{
					mapNodeList.get((stargate.row*147)+stargate.col).alienList.remove(stargate);
				}
				stargate.row=newNode.row;
				stargate.col=newNode.col;
				stargate.setPlanet(alienPlanet);
				alienList.add(stargate);
				System.out.printf("\tTHE STARGATE \t%s",alienPlanet);
				break;
				
			default:
				System.err.printf("%s\n",alienType);
			}
			countalien=countalien+1;
		}
		newNode.alienList = alienList;
		return pos;
	}

	private int doHeros(String line [],int pos, MapNode newNode)
	{
		String heroes;
		int heroesMax;
		heroes=line[pos];
		pos=pos+1;
		heroesMax=Integer.parseInt(heroes,10);
		ArrayList<Object> heroList=new ArrayList<Object>(heroesMax);
		int countHeroes=0;
		String heroesDays;
		while (countHeroes<heroesMax)
		{
			heroesDays=line[pos];
			pos=pos+1;
			HeroNode newHero=new HeroNode(Integer.valueOf(heroesDays));
			heroList.add(newHero);
			countHeroes=countHeroes+1;
		}
		newNode.heroList = heroList;
		return pos;
	}

	private int doSquare(String[] line, int pos, MapNode newNode) {
		String Lon;
		String Lat;
		String terrain;
		String inspected;
		
		
		Lon=line[pos];
		newNode.lon=Float.valueOf(Lon);
		pos=pos+1;
		Lat=line[pos];
		newNode.lat=Float.valueOf(Lat);
		pos=pos+1;
		terrain=line[pos];
		newNode.feature=terrain.charAt(0);
		pos=pos+1;
		inspected=line[pos];
		newNode.survey=Boolean.valueOf(inspected);
		pos=pos+1;
		
		newNode.row=(int) ((Float.valueOf(Lon)+74.01719)/0.004632053+0.1);
		newNode.col=(int) ((Float.valueOf(Lat)-40.70032)/0.001188306+0.1);
		
		return pos;
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
				
				if(temp.alienList.size() > 0 && temp.survey)
				{
					if(temp.alienList.contains(stargate))
						symbol=stargateInt;
					else
						symbol=hologramInt;
				}
				else if(temp.heroList.size() > 0 && temp.survey)
				{
					symbol=rubbleInt;
				}
				else if(temp.ghostList.size() > 0 && temp.survey)
				{
					symbol=slimeInt;
				}
				else if(temp.alienList.size() > 0)
				{
					if(temp.alienList.contains(stargate))
						symbol=stargateInt;
					else
						symbol=alienInt;
				}
				else if(temp.heroList.size() > 0)
				{
					symbol=heroInt;
				}
				else if(temp.ghostList.size() > 0)
				{
					symbol=ghostInt;
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

		for(int i=0; i<mapNodeList.size(); i++)
		{
			mapNodeList.get(i).alienList.clear();
			mapNodeList.get(i).heroList.clear();
			mapNodeList.get(i).ghostList.clear();
		}
		
		//Load("EmptyManhattan.txt");

		MakeMap();
	}

	public void changeSymbol(String water2, String building2,
			String vegetation2, String rubble2, String slime2,
			String hologram2, String hero2, String ghost2, String alien2, String stargate2) {
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
		if(stargate2.length() > 0)
			stargateChar=stargate2.charAt(0);
	}

	public String getMap() {
		// TODO Auto-generated method stub
		String mapString="";
		for(int i = 0; i < 19; i++)
		{
			for(int j = 0; j < 147; j++)
			{
				if(charMap[j][i] == waterInt)
					mapString+=waterChar;
				else if(charMap[j][i] == buildingInt)
					mapString+=buildingChar;
				else if(charMap[j][i] == vegetationInt)
					mapString+=vegetationChar;
				else if(charMap[j][i] == rubbleInt)
					mapString+=rubbleChar;
				else if(charMap[j][i] == slimeInt)
					mapString+=slimeChar;
				else if(charMap[j][i] == hologramInt)
					mapString+=hologramChar;
				else if(charMap[j][i] == heroInt)
					mapString+=heroChar;
				else if(charMap[j][i] == alienInt)
					mapString+=alienChar;
				else if(charMap[j][i] == ghostInt)
					mapString+=ghostChar;
				else if(charMap[j][i] == stargateInt)
					mapString+=stargateChar;
				else
					mapString+='?';
			}
			mapString+="\n";
		}
		return mapString;
	}

	public void clearNode(String row, String col) {
		// TODO Auto-generated method stub
		int x;
		int y;
		x = Integer.valueOf(col);
		y = Integer.valueOf(row);
		if(Exists(y,x))
		{
			mapNodeList.get((y*147)+x).alienList.clear();
			mapNodeList.get((y*147)+x).heroList.clear();
			mapNodeList.get((y*147)+x).ghostList.clear();
			mapNodeList.get((y*147)+x).survey = false;
		}
		MakeMap();
	}

	public void addLair(String row, String col, String street, String number,
			String planet) {
		// TODO Auto-generated method stub
		HiddenLairNode newNode=new HiddenLairNode(planet, Integer.valueOf(number), street);
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.add(newNode);
		MakeMap();
	}

	public String addStargate(String row, String col, String planet) {
		// TODO Auto-generated method stub
		String text="";
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.clear();
		System.out.println("try");
		if(stargate.row != -1)
			text=text+("remove Stargate at row: "+stargate.row+" col: "+stargate.col+"\n");
			mapNodeList.get((stargate.row*147)+stargate.col).alienList.remove(stargate);
			//mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.remove(stargate);
		stargate.row=Integer.valueOf(row);
		stargate.col=Integer.valueOf(col);
		stargate.setPlanet(planet);
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.add(stargate);
		MakeMap();
		return text=text+("add Stargate at row: "+row+" col: "+col+"\n");
	}

	public void addStarship(String row, String col, String clasification,
			String planet) {
		// TODO Auto-generated method stub
		System.out.println(row+" "+col);
		StarShipNode newNode=new StarShipNode(planet, Integer.valueOf(clasification));
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.add(newNode);
		MakeMap();
	}

	public void addMucus(String row, String col, String height,
			String diameter, String powerLevel) {
		// TODO Auto-generated method stub
		MucusNode newNode=new MucusNode(Integer.valueOf(powerLevel), Float.valueOf(diameter),
				Float.valueOf(height));
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.add(newNode);
		MakeMap();
	}

	public void addChunky(String row, String col, String smell,
			String powerLevel) {
		// TODO Auto-generated method stub
		ChunkyNode newNode=new ChunkyNode(Integer.valueOf(powerLevel), smell);
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.add(newNode);
		MakeMap();
	}

	public void addSlime(String row, String col, String volume,
			String powerLevel) {
		// TODO Auto-generated method stub
		SlimeNode newNode=new SlimeNode(Integer.valueOf(powerLevel), Double.valueOf(volume));
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.add(newNode);
		MakeMap();
	}

	public void addHero(String row, String col, String age) {
		// TODO Auto-generated method stub
		HeroNode newNode=new HeroNode(Integer.valueOf(age));
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).ghostList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).alienList.clear();
		mapNodeList.get((Integer.valueOf(row)*147)+Integer.valueOf(col)).heroList.add(newNode);
		MakeMap();
	}
}
