
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

public class  DialogAddLairPop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldPlanet;
	JTextField textFieldStreet;
	JTextField textFieldNumber;
	JLabel labelPlanet;
	JLabel labelStreet;
	JLabel labelNumber;
	String planet;
	String Street;
	String Number;
	private DataAddLair localDataAddLair;
	
	
	
	public DialogAddLairPop()
	{
		this.setTitle("Add Lair");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(4,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelPlanet=new JLabel("Planet");
		labelStreet=new JLabel("Street");
		labelNumber=new JLabel("Number");
		textFieldPlanet=new JTextField();
		textFieldNumber=new JTextField();
		textFieldStreet=new JTextField();

		this.add(labelPlanet);
		this.add(textFieldPlanet);
		
		this.add(labelStreet);
		this.add(textFieldStreet);
		
		this.add(labelNumber);
		this.add(textFieldNumber);
		
		this.add(buttonYes);
		this.add(buttonNo);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(300,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			planet=this.textFieldPlanet.getText();
			Street=this.textFieldStreet.getText();
			Number=this.textFieldNumber.getText();
			localDataAddLair.planet=planet;
			localDataAddLair.street=Street;
			localDataAddLair.number=Number;
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
	
	public void setDataAddLair(DataAddLair dataAddLair, Point point)
	{
		localDataAddLair=dataAddLair;
		localDataAddLair.row =Integer.toString((int)point.getY());
		localDataAddLair.col =Integer.toString((int)point.getX());
		return;
	}
	

	
	
}