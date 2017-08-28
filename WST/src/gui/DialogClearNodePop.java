package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class  DialogClearNodePop extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	private DataClearNode localDataClearNode;
	
	
	
	public DialogClearNodePop()
	{
		this.setTitle("Clear Node");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(1,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		
		this.add(buttonYes);
		this.add(buttonNo);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(100,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			this.setVisible(false);
			dispose();
		}
		else if (e.getActionCommand()=="No")
		{
			localDataClearNode.row=null;
			localDataClearNode.col=null;
			this.setVisible(false);
			this.setModal(false);
			dispose();
		}
	}
	
	public void setDataClearNode(DataClearNode dataClearNode, Point point)
	{
		localDataClearNode=dataClearNode;
		localDataClearNode.row =Integer.toString((int)point.getY());
		localDataClearNode.col =Integer.toString((int)point.getX());
		return;
	}	
}
