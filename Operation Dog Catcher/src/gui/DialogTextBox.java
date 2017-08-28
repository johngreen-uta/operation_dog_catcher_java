package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class  DialogTextBox extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JTextArea textArea;
	
	public DialogTextBox()
	{	
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", 0, 14));
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		Container content = this.getContentPane();
		content.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void setTextBox(String title, String text)
	{
		textArea.setText(text);
		this.setTitle(title);
		if(title.equals("View Report"))
			setSize(800,600);
		else
			setSize(300,300);
	}
	
}