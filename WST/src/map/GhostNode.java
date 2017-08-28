package map;

/**
 * @author john green
 * 
 * description initialize items in the ghost node
 *
 */
public class GhostNode {
	
	private int powerLevel = -1;

	public GhostNode(int powerLevel) {
		this.setPowerLevel(powerLevel);
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
}
