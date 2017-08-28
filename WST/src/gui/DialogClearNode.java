package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  DialogClearNode extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldRow;
	JTextField textFieldCol;
	JLabel labelRow;
	JLabel labelCol;
	String row;
	String col;
	private DataClearNode localDataClearNode;
	
	
	
	public DialogClearNode()
	{
		this.setTitle("Clear Node");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelRow=new JLabel("Row");
		labelCol=new JLabel("Column");
		textFieldRow=new JTextField();
		textFieldCol=new JTextField();
				
		this.add(labelCol);
		this.add(textFieldCol);
		
		this.add(labelRow);
		this.add(textFieldRow);
		
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
			localDataClearNode.row=row;
			localDataClearNode.col=col;
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
	
	public void setDataClearNode(DataClearNode dataClearNode)
	{
		localDataClearNode=dataClearNode;
		return;
	}	
}
