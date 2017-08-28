package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddStargate extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldPlanet;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelPlanet;
	String row;
	String col;
	String planet;
	private DataAddStargate localDataAddStargate;
	
	
	
	public DialogAddStargate()
	{
		this.setTitle("Add Stargate");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(4,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelPlanet=new JLabel("Planet");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldPlanet=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
		this.add(labelPlanet);
		this.add(textFieldPlanet);
		
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
			localDataAddStargate.row=row;
			localDataAddStargate.col=col;
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
	
	public void setDataAddStargate(DataAddStargate dataAddStargate)
	{
		localDataAddStargate=dataAddStargate;
		return;
	}
	

	
	
}
