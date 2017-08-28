package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogSave extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldFile;
	JLabel labelFile;
	String filename;
	private DataSave localDataSave;
	
	public DialogSave()
	{
		this.setTitle("Save");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(2,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelFile=new JLabel("File");
		
		textFieldFile=new JTextField();
				
		this.add(labelFile);
		this.add(textFieldFile);
		
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
			
			filename=this.textFieldFile.getText();
			localDataSave.filename=filename;
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
	

	public void setDataSave(DataSave dataSave) {
		// TODO Auto-generated method stub
		localDataSave=dataSave;
	}
	

	
	
}
