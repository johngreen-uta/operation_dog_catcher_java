package phase2;

import java.util.ArrayList;

import gui.MapComponent;
import gui.Pin;

import javax.swing.JTextArea;

import map.MapData;
import map.MapNode;

public class SubController {

	private JTextArea output;
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

	public void clear() {
		// TODO Auto-generated method stub
		text=output.getText();
		text=text+"Clear\n";
		output.setText(text);		
		map.Clear();
	}

	public String about() {
		// TODO Auto-generated method stub
		text="";
		text=text+"=================\n";
		text=text+"John Green - Solo 1\n";
		text=text+"John Green\n";
		text=text+"1001011958\n";
		text=text+"Operation Dog Catcher\n";
		text=text+"11/2/2014\n";
		text=text+"Vertion 0.2\n";
		text=text+"=================\n";
		text=text+"\n";
		return text;		

	}

	public void setTextArea(JTextArea textArea) {
		// TODO Auto-generated method stub
		output=textArea;
	}
	
	public void setMapData(MapData newMap)
	{
		map=newMap;
	}

	public void PkeScan(String row, String col) {
		text=map.PkeScan(row, col);
	}

	public void SpectrailTrailScan(String row, String col) {
		text=map.SpectrailScan(row, col);
	}

	public void VisualScan(String row, String col) {
		text=map.VisualScan(row, col);
	}

	public void SendInspector(String row, String col) {
		map.SendInspector(row, col);
	}

	public void ShowPkeScan(MapComponent mapComponent) {
		int charMap[][] = map.GetCharMap();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 8)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),11);
				}
				else if(charMap[y][x] == 4)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),10);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public void ShowSpectrailScan(MapComponent mapComponent) {
		int charMap[][] = map.GetCharMap();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 7)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),11);
				}
				else if(charMap[y][x] == 5)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),10);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public void ShowVisualScan(MapComponent mapComponent) {
		int charMap[][] = map.GetCharMap();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 6)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),11);
				}
				else if(charMap[y][x] == 3)
				{
					tempPin=new Pin((int)(y*10.2),(int)(x*15.8),10);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public void ShowPkeCount(MapComponent mapComponent) {
		int tempInt;
		int[][] charMap = map.GetCharMap();
		ArrayList<MapNode> nodeList = map.GetMapNodes();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 4)
				{
					tempInt = nodeList.get(x*147+y).getGhostList().size();
					if(tempInt >= 9)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),9);
					else if(tempInt > 0)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),tempInt);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public void ShowSpectrailcount(MapComponent mapComponent) {
		int tempInt;
		int[][] charMap = map.GetCharMap();
		ArrayList<MapNode> nodeList = map.GetMapNodes();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 5)
				{
					tempInt = nodeList.get(x*147+y).getAlienList().size();
					if(tempInt >= 9)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),9);
					else if(tempInt > 0)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),tempInt);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public void ShowVisualCount(MapComponent mapComponent) {
		int tempInt;
		int[][] charMap = map.GetCharMap();
		ArrayList<MapNode> nodeList = map.GetMapNodes();
		mapComponent.getThesePins().clear();
		for(int y=0; y<147; y++)
		{
			for(int x=0; x<19; x++)
			{
				Pin tempPin = null;
				if(charMap[y][x] == 3)
				{
					tempInt = nodeList.get(x*147+y).getHeroList().size();
					if(tempInt >= 9)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),9);
					else if(tempInt > 0)
						tempPin=new Pin((int)(y*10.2),(int)(x*15.8),tempInt);
				}
				if(tempPin != null)
				{
					mapComponent.addPin(tempPin);
				}
			}
		}
	}

	public String ShowReport() {
		text=map.getReport();
		return text;
	}

	public void ChangeSymbol(String water, String building, String vegetation,
			String rubble, String slime, String hologram, String hero,
			String ghost, String alien, String stargate) {
		// TODO Auto-generated method stub
		map.changeSymbol(water, building, vegetation, rubble, slime, hologram, 
				hero, ghost, alien,stargate);
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
	}

	public String getHood(String row, String col) {
		// TODO Auto-generated method stub
		for(int i=0; i<map.getHoodList().size(); i++)
		{
			if(map.getHoodList().get(i).getMap()[Integer.valueOf(col)][Integer.valueOf(row)] == 1)
				return map.getHoodList().get(i).getName();
		}
		return "No Data";
	}
}
