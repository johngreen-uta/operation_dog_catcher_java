package map;

public class StargateNode {

	   private static StargateNode instance = null;
	   private String planet;
	   
	   protected StargateNode() {
	      // Exists only to defeat instantiation.
	   }
	   public static StargateNode getInstance() {
	      if(instance == null) {
	         instance = new StargateNode();
	      }
	      return instance;
	   }
	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planet) {
		this.planet = planet;
	}
	}