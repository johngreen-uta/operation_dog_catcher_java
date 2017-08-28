
package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddLair extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldPlanet;
	JTextField textFieldStreet;
	JTextField textFieldNumber;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelPlanet;
	JLabel labelStreet;
	JLabel labelNumber;
	String row;
	String col;
	String planet;
	String Street;
	String Number;
	private DataAddLair localDataAddLair;
	
	
	
	public DialogAddLair()
	{
		this.setTitle("Add Lair");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(6,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelPlanet=new JLabel("Planet");
		labelStreet=new JLabel("Street");
		labelNumber=new JLabel("Number");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldPlanet=new JTextField();
		textFieldNumber=new JTextField();
		textFieldStreet=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
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

		setSize(500,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			
			row=this.textFieldRow.getText();
			col=this.textFieldCol.getText();
			planet=this.textFieldPlanet.getText();
			Street=this.textFieldStreet.getText();
			Number=this.textFieldNumber.getText();
			localDataAddLair.row=row;
			localDataAddLair.col=col;
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
	
	public void setDataAddLair(DataAddLair dataAddLair)
	{
		localDataAddLair=dataAddLair;
		return;
	}
	

	
	
}