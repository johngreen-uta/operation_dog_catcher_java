package map;

public class Neighborhood implements Comparable<Object>{

	private String name;
	private int alienCount;
	private int heroCount;
	private int ghostCount;
	private int[][] map;
	
	public Neighborhood()
	{
		setName("");
		alienCount=0;
		heroCount=0;
		ghostCount=0;
		setMap(new int[147][19]);
	}
	
	public int getAlienCount() {
		return alienCount;
	}
	public void setAlienCount(int alienCount) {
		this.alienCount = alienCount;
	}
	public int getHeroCount() {
		return heroCount;
	}
	public void setHeroCount(int heroCount) {
		this.heroCount = heroCount;
	}
	public int getGhostCount() {
		return ghostCount;
	}
	public void setGhostCount(int ghostCount) {
		this.ghostCount = ghostCount;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(((Neighborhood) arg0).getName());
	}
	
}
