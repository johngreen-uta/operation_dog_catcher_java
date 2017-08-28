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

public class  DialogAddChunkyPop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldSmell;
	JTextField textFieldPowerLevel;
	JLabel labelSmell;
	JLabel labelPowerLevel;
	String Smell;
	String PowerLevel;
	private DataAddChunky localDataAddChunky;
	
	
	
	public DialogAddChunkyPop()
	{
		this.setTitle("Add Chunky");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelSmell=new JLabel("Smell");
		labelPowerLevel=new JLabel("PowerLevel");
		textFieldSmell=new JTextField();
		textFieldPowerLevel=new JTextField();
		
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
			Smell=this.textFieldSmell.getText();
			PowerLevel=this.textFieldPowerLevel.getText();
			localDataAddChunky.smell=Smell;
			localDataAddChunky.powerLevel=PowerLevel;
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
	
	public void setDataAddChunky(DataAddChunky dataAddChunky, Point point)
	{
		localDataAddChunky=dataAddChunky;
		localDataAddChunky.row =Integer.toString((int)point.getY());
		localDataAddChunky.col =Integer.toString((int)point.getX());
		return;
	}
	

	
	
}
