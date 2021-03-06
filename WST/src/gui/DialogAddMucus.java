package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddMucus extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldHeight;
	JTextField textFieldDiameter;
	JTextField textFieldPowerLevel;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelHeight;
	JLabel labelDiameter;
	JLabel labelPowerLevel;
	String row;
	String col;
	String Height;
	String Diameter;
	String powerLevel;
	private DataAddMucus localDataAddMucus;
	
	
	
	public DialogAddMucus()
	{
		this.setTitle("Add Mucus");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(6,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelHeight=new JLabel("Height");
		labelDiameter=new JLabel("Diameter");
		labelPowerLevel=new JLabel("Power Level");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldHeight=new JTextField();
		textFieldDiameter=new JTextField();
		textFieldPowerLevel=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
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

		setSize(500,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			
			row=this.textFieldRow.getText();
			col=this.textFieldCol.getText();
			Height=this.textFieldHeight.getText();
			Diameter=this.textFieldDiameter.getText();
			powerLevel=this.textFieldPowerLevel.getText();
			localDataAddMucus.row=row;
			localDataAddMucus.col=col;
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
	
	public void setDataAddMucus(DataAddMucus dataAddMucus)
	{
		localDataAddMucus=dataAddMucus;
		return;
	}
	

	
	
}
