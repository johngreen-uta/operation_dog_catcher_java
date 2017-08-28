package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class WstPopUpMenu extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem menuItemAddStarship;
	private JMenuItem menuItemAddLair;
	private JMenuItem menuItemAddStargate;
	private JMenuItem menuItemAddHero;
	private JMenuItem menuItemAddMucus;
	private JMenuItem menuItemAddChunky;
	private JMenuItem menuItemAddSlime;
	private JMenuItem menuItemClearNode;
	
	private MapComponent myMapComponent;
	private MainFrame parent;
	
	// Edit Menu
	private static final String commandAddStarship="Add Starship";
	private static final String commandAddLair="Add Hidden Lair";
	private static final String commandAddStargate="Add Stargate";
	private static final String commandAddHero="Add Hero";
	private static final String commandAddMucus="Add Mucus";
	private static final String commandAddChunky="Add Extra-Chunky";
	private static final String commandAddSlime="Add Slime";
	private static final String commandClearNode="Clear Node";	
	
	
	DialogAddStarshipPop tempDialogAddStarship;
	DataAddStarship tempDataAddStarship;
	DialogAddLairPop tempDialogAddLair;
	DataAddLair tempDataAddLair;
	DialogAddStargatePop tempDialogAddStargate;
	DataAddStargate tempDataAddStargate;
	DialogAddHeroPop tempDialogAddHero;
	DataAddHero tempDataAddHero;
	DialogAddMucusPop tempDialogAddMucus;
	DataAddMucus tempDataAddMucus;
	DialogAddChunkyPop tempDialogAddChunky;
	DataAddChunky tempDataAddChunky;
	DialogAddSlimePop tempDialogAddSlime;
	DataAddSlime tempDataAddSlime;
	DialogClearNodePop tempDialogClearNode;
	DataClearNode tempDataClearNode;
	
	private void MakeDialogAndData() 
	{
		// TODO Auto-generated method stub
		tempDialogAddStarship=new DialogAddStarshipPop();
		tempDataAddStarship=new DataAddStarship();
		tempDialogAddLair=new DialogAddLairPop();
		tempDataAddLair=new DataAddLair();
		tempDialogAddStargate=new DialogAddStargatePop();
		tempDataAddStargate=new DataAddStargate();
		tempDialogAddHero=new DialogAddHeroPop();
		tempDataAddHero=new DataAddHero();
		tempDialogAddMucus=new DialogAddMucusPop();
		tempDataAddMucus=new DataAddMucus();
		tempDialogAddChunky=new DialogAddChunkyPop();
		tempDataAddChunky=new DataAddChunky();
		tempDialogAddSlime=new DialogAddSlimePop();
		tempDataAddSlime=new DataAddSlime();
		tempDataClearNode=new DataClearNode();
		tempDialogClearNode=new DialogClearNodePop();
	}
	
	public WstPopUpMenu()
	{	
		MakeDialogAndData();
		
		menuItemAddStarship=new JMenuItem(commandAddStarship);
		menuItemAddStarship.addActionListener(this);
		this.add(menuItemAddStarship);
	
		menuItemAddLair=new JMenuItem(commandAddLair);
		menuItemAddLair.addActionListener(this);
		this.add(menuItemAddLair);
		
		menuItemAddStargate=new JMenuItem(commandAddStargate);
		menuItemAddStargate.addActionListener(this);
		this.add(menuItemAddStargate);
		
		menuItemAddHero=new JMenuItem(commandAddHero);
		menuItemAddHero.addActionListener(this);
		this.add(menuItemAddHero);
	
		menuItemAddMucus=new JMenuItem(commandAddMucus);
		menuItemAddMucus.addActionListener(this);
		this.add(menuItemAddMucus);
		
		menuItemAddChunky=new JMenuItem(commandAddChunky);
		menuItemAddChunky.addActionListener(this);
		this.add(menuItemAddChunky);
		
		menuItemAddSlime=new JMenuItem(commandAddSlime);
		menuItemAddSlime.addActionListener(this);
		this.add(menuItemAddSlime);	
		
		menuItemClearNode=new JMenuItem(commandClearNode);
		menuItemClearNode.addActionListener(this);
		this.add(menuItemClearNode);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		switch(arg0.getActionCommand())
		{
		case commandAddStarship:
			System.out.println(commandAddStarship);
			tempDialogAddStarship.setDataAddStarship(tempDataAddStarship, myMapComponent.getPoint());		
			tempDialogAddStarship.setModal(true);
			tempDialogAddStarship.setVisible(true);
			parent.subController.addStarship(tempDataAddStarship.row, tempDataAddStarship.col,
					tempDataAddStarship.clasification, tempDataAddStarship.planet);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddLair:
			tempDialogAddLair.setDataAddLair(tempDataAddLair, myMapComponent.getPoint());		
			tempDialogAddLair.setModal(true);
			tempDialogAddLair.setVisible(true);
			parent.subController.addLair(tempDataAddLair.row, tempDataAddLair.col,
					tempDataAddLair.street, tempDataAddLair.number, tempDataAddLair.planet);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddStargate:
			tempDialogAddStargate.setDataAddStargate(tempDataAddStargate, myMapComponent.getPoint());		
			tempDialogAddStargate.setModal(true);
			tempDialogAddStargate.setVisible(true);
			String text=parent.subController.addStargate(tempDataAddStargate.row, tempDataAddStargate.col,
					tempDataAddStargate.planet);
			parent.tempDialogTextBox.setTextBox(commandAddStargate,text);
			parent.tempDialogTextBox.setModal(true);
			parent.tempDialogTextBox.setVisible(true);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddHero:
			tempDialogAddHero.setDataAddHero(tempDataAddHero, myMapComponent.getPoint());		
			tempDialogAddHero.setModal(true);
			tempDialogAddHero.setVisible(true);
			parent.subController.addHero(tempDataAddHero.row, tempDataAddHero.col, tempDataAddHero.age);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddMucus:
			tempDialogAddMucus.setDataAddMucus(tempDataAddMucus, myMapComponent.getPoint());		
			tempDialogAddMucus.setModal(true);
			tempDialogAddMucus.setVisible(true);
			parent.subController.addMucus(tempDataAddMucus.row, tempDataAddMucus.col,
					tempDataAddMucus.height, tempDataAddMucus.diameter, tempDataAddMucus.powerLevel);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddChunky:
			tempDialogAddChunky.setDataAddChunky(tempDataAddChunky, myMapComponent.getPoint());		
			tempDialogAddChunky.setModal(true);
			tempDialogAddChunky.setVisible(true);
			parent.subController.addChunky(tempDataAddChunky.row, tempDataAddChunky.col,
					tempDataAddChunky.smell, tempDataAddChunky.powerLevel);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandAddSlime:
			tempDialogAddSlime.setDataAddSlime(tempDataAddSlime, myMapComponent.getPoint());		
			tempDialogAddSlime.setModal(true);
			tempDialogAddSlime.setVisible(true);
			parent.subController.addSlime(tempDataAddSlime.row, tempDataAddSlime.col,
					tempDataAddSlime.volume, tempDataAddSlime.powerLevel);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandClearNode:
			tempDialogClearNode.setDataClearNode(tempDataClearNode, myMapComponent.getPoint());		
			tempDialogClearNode.setModal(true);
			tempDialogClearNode.setVisible(true);
			parent.subController.clearNode(tempDataClearNode.row, tempDataClearNode.col);
			parent.subController.showMap(parent.mapComponent);
			break;
		}
		
		//parent.MakeMapArea();
	}

	public MapComponent getMapComponent() {
		return myMapComponent;
	}

	public void setMapComponent(MapComponent myMapComponent) {
		this.myMapComponent = myMapComponent;
	}
	
	public void setParent(MainFrame parentPtr)
	{
		parent=parentPtr;
	}


}
