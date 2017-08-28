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
	
	ArrayList<Object> heroList;
	ArrayList<Object> alienList;
	ArrayList<Object> ghostList;

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
		heroList=new ArrayList<Object>();
		alienList=new ArrayList<Object>();
		ghostList=new ArrayList<Object>();
	}
}
