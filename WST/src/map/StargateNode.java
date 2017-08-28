package map;

public class StargateNode extends AlienNode {

	int row;
	int col;
	
	public StargateNode(String planet, int row, int col) {
		super(planet);
		this.row=row;
		this.col=col;
	}
}
