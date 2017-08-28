package map;

public class ChunkyNode extends GhostNode {

	private String smell = null;
	
	public ChunkyNode(int powerLevel, String smell) {
		super(powerLevel);
		this.setSmell(smell);
	}

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}
}
