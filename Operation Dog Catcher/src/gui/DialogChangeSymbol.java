package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogChangeSymbol extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6542587319791401131L;
	JButton buttonYes;
	JButton buttonNo;
	JTextField textFieldWater;
	JTextField textFieldBuilding;
	JTextField textFieldVegetation;
	JTextField textFieldRubble;
	JTextField textFieldSlime;
	JTextField textFieldHologram;
	JTextField textFieldHero;
	JTextField textFieldAlien;
	JTextField textFieldGhost;
	JTextField textFieldstargate;
	JLabel labelWater;
	JLabel labelBuilding;
	JLabel labelVegetation;
	JLabel labelRubble;
	JLabel labelSlime;
	JLabel labelHologram;
	JLabel labelHero;
	JLabel labelAlien;
	JLabel labelGhost;
	JLabel labelstargate;
	String[] symbols;
	String water;
	String building;
	String vegetation;
	String rubble;
	String slime;
	String hologram;
	String hero;
	String alien;
	String ghost;
	String stargate;
	private DataChangeSymbol localDataChangeSymbol;
	
	
	
	public DialogChangeSymbol()
	{
		this.setTitle("Change Symbol");
		Container content = this.getContentPane();
		GridLayout layout = new GridLayout(11,2);
		content.setLayout(layout);
		buttonYes=new JButton("Yes");
		buttonNo=new JButton("No");
		labelWater=new JLabel("Water");
		labelBuilding=new JLabel("Building");
		labelVegetation=new JLabel("Vegetatio");
		labelRubble=new JLabel("Rubble");
		labelSlime=new JLabel("Slime");
		labelHologram=new JLabel("Hologram");
		labelHero=new JLabel("Hero");
		labelAlien=new JLabel("Alien");
		labelGhost=new JLabel("Ghost");
		labelstargate=new JLabel("Stagate");
		textFieldWater=new JTextField();
		textFieldBuilding=new JTextField();
		textFieldVegetation=new JTextField();
		textFieldRubble=new JTextField();
		textFieldSlime=new JTextField();
		textFieldHologram=new JTextField();
		textFieldHero=new JTextField();
		textFieldAlien=new JTextField();
		textFieldGhost=new JTextField();
		textFieldstargate=new JTextField();
		
		this.add(labelWater);
		this.add(textFieldWater);
		this.add(labelBuilding);
		this.add(textFieldBuilding);
		this.add(labelVegetation);
		this.add(textFieldVegetation);
		this.add(labelRubble);
		this.add(textFieldRubble);
		this.add(labelSlime);
		this.add(textFieldSlime);
		this.add(labelHologram);
		this.add(textFieldHologram);
		this.add(labelHero);
		this.add(textFieldHero);
		this.add(labelAlien);
		this.add(textFieldAlien);
		this.add(labelGhost);
		this.add(textFieldGhost);
		this.add(labelstargate);
		this.add(textFieldstargate);
		this.add(buttonYes);
		this.add(buttonNo);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);

		setSize(700,200);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if  (e.getActionCommand()=="Yes")
		{
			
			water=this.textFieldWater.getText();
			building=this.textFieldBuilding.getText();
			vegetation=this.textFieldVegetation.getText();
			rubble=this.textFieldRubble.getText();
			slime=this.textFieldSlime.getText();
			hologram=this.textFieldHologram.getText();
			hero=this.textFieldHero.getText();
			alien=this.textFieldAlien.getText();
			ghost=this.textFieldGhost.getText();
			stargate=this.textFieldstargate.getText();
			localDataChangeSymbol.water=water;
			localDataChangeSymbol.building=building;
			localDataChangeSymbol.vegetation=vegetation;
			localDataChangeSymbol.rubble=rubble;
			localDataChangeSymbol.slime=slime;
			localDataChangeSymbol.hologram=hologram;
			localDataChangeSymbol.hero=hero;
			localDataChangeSymbol.alien=alien;
			localDataChangeSymbol.ghost=ghost;
			localDataChangeSymbol.stargate=stargate;
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
	
	public void setDataChangeSymbol(DataChangeSymbol tempDataChangeSymbol) {
		// TODO Auto-generated method stub
		localDataChangeSymbol=tempDataChangeSymbol;
		return;
	}
	

	
	
}