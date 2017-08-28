package map;

public class HiddenLairNode extends AlienNode{

	private int number = -1;
	private String street = null;

	public HiddenLairNode(String planet, int number, String street) {
		super(planet);
		this.setNumber(number);
		this.setStreet(street);
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
