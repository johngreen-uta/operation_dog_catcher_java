package map;

public class SlimeNode extends GhostNode {
	
	private double volume = -1;

	public SlimeNode(int powerLevel, double volume) {
		super(powerLevel);
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}


}
