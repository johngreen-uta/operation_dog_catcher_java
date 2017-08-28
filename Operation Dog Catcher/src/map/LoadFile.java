package map;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFile {
	
	ArrayList <MapNode> mapNodeList = new ArrayList<MapNode>(2793);
	
	public ArrayList <MapNode> BuildFile(String filename)
	{
		File inputFile=new File(filename);
		
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
		return mapNodeList;
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
		newNode.setGhostList(ghostList);
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
				StargateNode newStargate=StargateNode.getInstance();
				newStargate.setPlanet(alienPlanet);
				alienList.add(newStargate);
				break;
				
			default:
				System.err.printf("%s\n",alienType);
			}
			countalien=countalien+1;
		}
		newNode.setAlienList(alienList);
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
		newNode.setHeroList(heroList);
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
}