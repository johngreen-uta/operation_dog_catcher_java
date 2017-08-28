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

public class  DialogAddStargatePop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldPlanet;
	JLabel labelPlanet;
	String planet;
	private DataAddStargate localDataAddStargate;
	
	
	
	public DialogAddStargatePop()
	{
		this.setTitle("Add Stargate");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(2,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelPlanet=new JLabel("Planet");
		textFieldPlanet=new JTextField();

		this.add(labelPlanet);
		this.add(textFieldPlanet);
		
		this.add(buttonYes);
		this.add(buttonNo);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(150,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{

			planet=this.textFieldPlanet.getText();
			localDataAddStargate.planet=planet;
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
	
	public void setDataAddStargate(DataAddStargate dataAddStargate, Point point)
	{
		localDataAddStargate=dataAddStargate;
		localDataAddStargate.row =Integer.toString((int)point.getY());
		localDataAddStargate.col =Integer.toString((int)point.getX());
		return;
	}
	

	
	
}
