package map;

import java.util.ArrayList;

/*
 * 
 * @author john green
 * 
 * description initialize items in the node object
 *
 */
public class MapNode 
{
	
	private ArrayList<Object> heroList;
	private ArrayList<Object> alienList;
	private ArrayList<Object> ghostList;

	public int row;
	public int col;
	public float lon;
	public float lat;
	public char feature;
	public boolean survey;

	/**
	 * @param 
	 * @return void
	 * @exception
	 */
	public MapNode() 
	{
		row=-1;
		col=-1;
		lon=-1;
		lat=-1;
		feature='?';
		survey=false;
		setHeroList(new ArrayList<Object>());
		setAlienList(new ArrayList<Object>());
		setGhostList(new ArrayList<Object>());
	}

	public ArrayList<Object> getGhostList() {
		return ghostList;
	}

	public void setGhostList(ArrayList<Object> ghostList) {
		this.ghostList = ghostList;
	}

	public ArrayList<Object> getAlienList() {
		return alienList;
	}

	public void setAlienList(ArrayList<Object> alienList) {
		this.alienList = alienList;
	}

	public ArrayList<Object> getHeroList() {
		return heroList;
	}

	public void setHeroList(ArrayList<Object> heroList) {
		this.heroList = heroList;
	}
}
