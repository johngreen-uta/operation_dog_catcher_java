package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddChunky extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldSmell;
	JTextField textFieldPowerLevel;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelSmell;
	JLabel labelPowerLevel;
	String row;
	String col;
	String Smell;
	String PowerLevel;
	private DataAddChunky localDataAddChunky;
	
	
	
	public DialogAddChunky()
	{
		this.setTitle("Add Chunky");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(5,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelSmell=new JLabel("Smell");
		labelPowerLevel=new JLabel("PowerLevel");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldSmell=new JTextField();
		textFieldPowerLevel=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
		this.add(labelSmell);
		this.add(textFieldSmell);
		
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
			Smell=this.textFieldSmell.getText();
			PowerLevel=this.textFieldPowerLevel.getText();
			localDataAddChunky.row=row;
			localDataAddChunky.col=col;
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
	
	public void setDataAddChunky(DataAddChunky dataAddChunky)
	{
		localDataAddChunky=dataAddChunky;
		return;
	}
	

	
	
}
