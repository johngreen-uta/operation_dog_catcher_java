package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddStarshipPop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldPlanet;
	JTextField textFieldClasification;
	JLabel labelPlanet;
	JLabel labelClasification;
	String planet;
	String clasification;
	private DataAddStarship localDataAddStarship;
	
	
	
	public DialogAddStarshipPop()
	{
		this.setTitle("Add Starship");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelPlanet=new JLabel("Planet");
		labelClasification=new JLabel("Clasification");
		textFieldPlanet=new JTextField();
		textFieldClasification=new JTextField();
		
		this.add(labelPlanet);
		this.add(textFieldPlanet);
		
		this.add(labelClasification);
		this.add(textFieldClasification);
		
		this.add(buttonYes);
		this.add(buttonNo);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(200,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			planet=this.textFieldPlanet.getText();
			clasification=this.textFieldClasification.getText();
			localDataAddStarship.planet=planet;
			localDataAddStarship.clasification=clasification;
			this.setVisible(false);
			dispose();
		}
		else if (e.getActionCommand()=="No")
		{
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
		
		
	}
	
	public void setDataAddStarship(DataAddStarship dataAddStarship, Point point)
	{
		localDataAddStarship=dataAddStarship;
		localDataAddStarship.row =Integer.toString((int)point.getY());
		localDataAddStarship.col =Integer.toString((int)point.getX());
		return;
	}
}
