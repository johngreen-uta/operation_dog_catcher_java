package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogAddSlime extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JTextField textFieldVolume;
	JTextField textFieldPowerlevel;
	JLabel labelRow;
	JLabel labelCol;
	JLabel labelVolume;
	JLabel labelPowerlevel;
	String row;
	String col;
	String Volume;
	String powerLevel;
	private DataAddSlime localDataAddSlime;
	
	
	
	public DialogAddSlime()
	{
		this.setTitle("Add Slime");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(5,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		labelVolume=new JLabel("Volume");
		labelPowerlevel=new JLabel("Power Level");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
		textFieldVolume=new JTextField();
		textFieldPowerlevel=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
		this.add(labelVolume);
		this.add(textFieldVolume);
		
		this.add(labelPowerlevel);
		this.add(textFieldPowerlevel);
		
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
			Volume=this.textFieldVolume.getText();
			powerLevel=this.textFieldPowerlevel.getText();
			localDataAddSlime.row=row;
			localDataAddSlime.col=col;
			localDataAddSlime.volume=Volume;
			localDataAddSlime.powerLevel=powerLevel;
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
	
	public void setDataAddSlime(DataAddSlime dataAddSlime)
	{
		localDataAddSlime=dataAddSlime;
		return;
	}
	

	
	
}
