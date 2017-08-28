package map;

public class StarShipNode extends AlienNode {

	private int classification = -1;
	
	public StarShipNode(String planet, int classificationIn) {
		super(planet);
		classification = classificationIn;
	}
	
	public int getClassification() {
		return classification;
	}
	public void setClassification(int classification) {
		this.classification = classification;
	}
}
