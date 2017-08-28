package map;

public class MucusNode extends GhostNode {
	
	private float diameter = -1;
	private float height = -1;

	public MucusNode(int powerLevel, float diameter, float height) {
		super(powerLevel);
		this.diameter = diameter;
		this.height = height;		
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
