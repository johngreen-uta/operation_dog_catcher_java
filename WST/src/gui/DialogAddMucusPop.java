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

public class  DialogAddMucusPop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldHeight;
	JTextField textFieldDiameter;
	JTextField textFieldPowerLevel;;
	JLabel labelHeight;
	JLabel labelDiameter;
	JLabel labelPowerLevel;
	String Height;
	String Diameter;
	String powerLevel;
	private DataAddMucus localDataAddMucus;
	
	
	
	public DialogAddMucusPop()
	{
		this.setTitle("Add Mucus");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(4,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelHeight=new JLabel("Height");
		labelDiameter=new JLabel("Diameter");
		labelPowerLevel=new JLabel("Power Level");
		textFieldHeight=new JTextField();
		textFieldDiameter=new JTextField();
		textFieldPowerLevel=new JTextField();
		
		this.add(labelHeight);
		this.add(textFieldHeight);
		
		this.add(labelDiameter);
		this.add(textFieldDiameter);
		
		this.add(labelPowerLevel);
		this.add(textFieldPowerLevel);
		
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

			Height=this.textFieldHeight.getText();
			Diameter=this.textFieldDiameter.getText();
			powerLevel=this.textFieldPowerLevel.getText();
			localDataAddMucus.height=Height;
			localDataAddMucus.diameter=Diameter;
			localDataAddMucus.powerLevel=powerLevel;
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
	
	public void setDataAddMucus(DataAddMucus dataAddMucus, Point point)
	{
		localDataAddMucus=dataAddMucus;
		localDataAddMucus.row =Integer.toString((int)point.getY());
		localDataAddMucus.col =Integer.toString((int)point.getX());
		return;
	}
	

	
	
}
