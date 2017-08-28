package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogAddHero extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldAge;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelAge;
	String row;
	String col;
	String age;
	private DataAddHero localDataAddHero;
	
	
	
	public DialogAddHero()
	{
		this.setTitle("Add Hero");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(4,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelAge=new JLabel("Age");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldAge=new JTextField();
				
		
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
		this.add(labelAge);
		this.add(textFieldAge);
		
		
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
			
			row=this.textFieldRow.getText();
			col=this.textFieldCol.getText();
			age=this.textFieldAge.getText();
			localDataAddHero.row=row;
			localDataAddHero.col=col;
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
	
	public void setDataAddHero(DataAddHero dataAddHero)
	{
		localDataAddHero=dataAddHero;
		return;
	}
	

	
	
}
