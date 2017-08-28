package phase2;

import gui.MapComponent;
import gui.Pin;

import javax.swing.JTextArea;

import map.MapData;

public class SubController {

	private JTextArea output;
	MapComponent mapOutput;
	String text;
	MapData map;

	public void load() {
		// TODO Auto-generated method stub
		map.Load();
	}

	public void Save() {
		// TODO Auto-generated method stub	
		map.Save();
	}

	public void exit() {
		System.exit(0);
	}

	public void clear(MapComponent mapComponent) {
		// TODO Auto-generated method stub	
		mapComponent.getThesePins().clear();
		map.Clear();
	}	

	public String about() {
		// TODO Auto-generated method stub
		text="";
		text=text+"=================\n";
		text=text+"John Green - Solo 1\n";
		text=text+"John Green\n";
		text=text+"1001011958\n";
		text=text+"Weird Stuf Tool\n";
		text=text+"11/2/2014\n";
		text=text+"Vertion 0.2\n";
		text=text+"=================\n";
		text=text+"\n";
		return text;		
	}

	public void showMap(MapComponent mapComponent) {
		int charMap[][] = map.GetCharMap();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 3 || charMap[y][x] == 6)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8-21),13);
				}
				else if(charMap[y][x] == 5 || charMap[y][x] == 7)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8-21),12);
				}
				else if(charMap[y][x] == 4 || charMap[y][x] == 8)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8-21),14);
				}
				else if(charMap[y][x] == 9)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8-21),15);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}

		//text=map.getMap();
		//output.setText(text);
		
	}

	public void setTextArea(JTextArea textArea) {
		// TODO Auto-generated method stub
		output=textArea;
	}
	
	public void setMapData(MapData newMap)
	{
		map=newMap;
	}

	public void ChangeSymbol(String water, String building, String vegetation,
			String rubble, String slime, String hologram, String hero,
			String ghost, String alien, String stargate) {
		// TODO Auto-generated method stub
		map.changeSymbol(water, building, vegetation, rubble, slime, hologram, 
				hero, ghost, alien,stargate);
	}

	public void clearNode(String row, String col) {
		// TODO Auto-generated method stub
		map.clearNode(row,col);
	}

	public void addLair(String row, String col, String street, String number,
			String planet) {
		// TODO Auto-generated method stub
		System.out.println(number);
		map.addLair(row,col,street,number,planet);
	}

	public String addStargate(String row, String col, String planet) {
		// TODO Auto-generated method stub
		return map.addStargate(row, col, planet);
	}

	public void addStarship(String row, String col, String clasification,
			String planet) {
		// TODO Auto-generated method stub
		map.addStarship(row,col,clasification,planet);
	}

	public void addMucus(String row, String col, String height,
			String diameter, String powerLevel) {
		// TODO Auto-generated method stub
		map.addMucus(row,col,height,diameter,powerLevel);
	}

	public void addChunky(String row, String col, String smell,
			String powerLevel) {
		// TODO Auto-generated method stub
		map.addChunky(row,col,smell,powerLevel);
		
	}

	public void addSlime(String row, String col, String volume,
			String powerLevel) {
		// TODO Auto-generated method stub
		map.addSlime(row,col,volume,powerLevel);
	}

	public void addHero(String row, String col, String age) {
		// TODO Auto-generated method stub
		map.addHero(row,col,age);
	}

	public String ConvertRow(String row, String col) {
		// TODO Auto-generated method stub
		text="";
		try { 
	        int x = Integer.parseInt(row); 
	        int y = Integer.parseInt(col);
	        text=text+"lat: "+((0.001188306*y)+40.70032)+" lon: "+((0.004632053*x)-74.0171900000);
	    } catch(NumberFormatException e) { 
	        text="convertion failed"; 
	    }
		return text;
	}

	public String ConvertLat(String row, String col) {
		// TODO Auto-generated method stub
		text="";
		try { 
	        float x = Float.parseFloat(row); 
	        float y = Float.parseFloat(col);
	        text=text+"row: "+(int) ((x+74.01719)/0.004632053+0.1)+" col: "+(int) ((y-40.70032)/0.001188306+0.1);
	    } catch(NumberFormatException e) { 
	        text="convertion failed";
	    }
		return text;
	}

}
