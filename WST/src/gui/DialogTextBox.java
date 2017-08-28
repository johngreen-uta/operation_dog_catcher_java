package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JTextArea;

public class  DialogTextBox extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JTextArea output;
	
	public DialogTextBox()
	{
		output=new JTextArea();
		Container content = this.getContentPane();;
		content.add(output, BorderLayout.CENTER);
		setSize(300,300);
	}
	
	public void setTextBox(String title, String text)
	{
		output.setText(text);
		this.setTitle(title);
	}
	
}