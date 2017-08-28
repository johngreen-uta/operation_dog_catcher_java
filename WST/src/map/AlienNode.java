package map;

/**
 * @author john green
 * 
 * description initialize items in the alien node
 *
 */
public class AlienNode {
	
	private String planet;
	
	public AlienNode() {
		planet = "";
	}
	
	public AlienNode(String planet) {
		this.setPlanet(planet);
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}
}
