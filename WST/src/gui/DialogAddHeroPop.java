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

public class DialogAddHeroPop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldAge;
	JLabel labelAge;
	String age;
	private DataAddHero localDataAddHero;
	
	
	
	public DialogAddHeroPop()
	{
		this.setTitle("Add Hero");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(2,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelAge=new JLabel("Age");
		textFieldAge=new JTextField();

		this.add(labelAge);
		this.add(textFieldAge);
			
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
			age=this.textFieldAge.getText();
			localDataAddHero.age=age;
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
		else if (e.getActionCommand()=="No")
		{
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
		
		
	}
	
	public void setDataAddHero(DataAddHero dataAddHero, Point point)
	{
		localDataAddHero=dataAddHero;
		localDataAddHero.row =Integer.toString((int)point.getY());
		localDataAddHero.col =Integer.toString((int)point.getX());
		return;
	}
	

	
	
}
