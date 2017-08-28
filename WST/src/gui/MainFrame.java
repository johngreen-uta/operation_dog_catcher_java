package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import map.MapData;
import phase2.SubController;

public class MainFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1156392119668344557L;

	//*******************************************************
	//
	//     The Subcontroller
	//
	//*******************************************************
	SubController subController;

	//*******************************************************
	//
	//     The Map
	//
	//*******************************************************

	private MapData map;
	
	//*******************************************************
	//
	//     The Menus
	//
	//*******************************************************
	
	// File Menu
	private static final String commandLoad="Load";
	private static final String commandSave="Save";
	private static final String commandExit="Exit";
	
	// Edit Menu
	private static final String commandAddStarship="Add Starship";
	private static final String commandAddLair="Add Hidden Lair";
	private static final String commandAddStargate="Add Stargate";
	private static final String commandAddHero="Add Hero";
	private static final String commandAddMucus="Add Mucus";
	private static final String commandAddChunky="Add Extra-Chunky";
	private static final String commandAddSlime="Add Slime";
	private static final String commandEditRow="Edit Row";
	private static final String commandClearNode="Clear Node";
	private static final String commandClear="Clear Map";
	
	// View Menu
	private static final String commandChangeSymbol="Change Map Symbol";
	private static final String commandShowMap="View Map";
	private static final String commandConvertRow="Convert row/col to lat/lon";
	private static final String commandConvertLat="Convert lat/lon to row/col";

	
	// About Menu
	private static final String commandAbout="About";
	
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuItemLoad;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	
	private JMenu menuEdit;
	private JMenuItem menuItemAddStarship;
	private JMenuItem menuItemAddLair;
	private JMenuItem menuItemAddStargate;
	private JMenuItem menuItemAddHero;
	private JMenuItem menuItemAddMucus;
	private JMenuItem menuItemAddChunky;
	private JMenuItem menuItemAddSlime;
	private JMenuItem menuItemEditRow;
	private JMenuItem menuItemClearNode;
	private JMenuItem menuItemClear;

	private JMenu menuView;
	private JMenuItem menuItemChangeSymbol;
	private JMenuItem menuItemShowMap;
	private JMenuItem menuItemConvertRow;
	private JMenuItem menuItemConvertLat;


	private JMenuItem menuItemAbout;
	

	
	//==============================================
	//
	// Dialog Boxes and Datastores
	//
	//==============================================	

	DialogTextBox tempDialogTextBox;
	DialogLoad tempDialogLoad;
	DataLoad tempDataLoad;
	DialogSave tempDialogSave;
	DataSave tempDataSave;
	DialogChangeSymbol tempDialogChangeSymbol;
	DataChangeSymbol tempDataChangeSymbol;
	DialogAddStarship tempDialogAddStarship;
	DataAddStarship tempDataAddStarship;
	DialogAddLair tempDialogAddLair;
	DataAddLair tempDataAddLair;
	DialogAddStargate tempDialogAddStargate;
	DataAddStargate tempDataAddStargate;
	DialogAddHero tempDialogAddHero;
	DataAddHero tempDataAddHero;
	DialogAddMucus tempDialogAddMucus;
	DataAddMucus tempDataAddMucus;
	DialogAddChunky tempDialogAddChunky;
	DataAddChunky tempDataAddChunky;
	DialogAddSlime tempDialogAddSlime;
	DataAddSlime tempDataAddSlime;
	DialogEditRow tempDialogEditRow;
	DataEditRow tempDataEditRow;
	DialogClearNode tempDialogClearNode;
	DataClearNode tempDataClearNode;
	DialogConvertRow tempDialogConvertRow;
	DataConvertRow tempDataConvertRow;
	

	//*******************************************************
	//
	// The Text Area
	//
	//*******************************************************

	JTextArea textArea;
	JScrollPane scrollPane;
	Container content;

	MapComponent mapComponent;

	
	private JMenuItem makeMenuItem(String sLabel)
	{
		JMenuItem miTemp=null;
		miTemp=new JMenuItem(sLabel);
		miTemp.addActionListener(this);
		return miTemp;
	}
	
	private void MakeMenus()
	{
		
		
		//===========================
		//Menu Bar
		//===========================
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//===========================
		//File Menu
		//===========================
		menuFile=new JMenu("File");

		menuItemLoad=makeMenuItem(commandLoad);
		menuItemSave=makeMenuItem(commandSave);
		menuItemExit=makeMenuItem(commandExit);
		menuFile.add(menuItemLoad);
		menuFile.add(menuItemSave);
		menuFile.add(menuItemExit);
		menuBar.add(menuFile);
		
		//===========================
		//Edit Menu
		//===========================
		menuEdit=new JMenu("Edit");

		
		menuItemAddStarship=makeMenuItem(commandAddStarship);
		menuItemAddLair=makeMenuItem(commandAddLair);
		menuItemAddStargate=makeMenuItem(commandAddStargate);
		menuItemAddHero=makeMenuItem(commandAddHero);
		menuItemAddMucus=makeMenuItem(commandAddMucus);
		menuItemAddChunky=makeMenuItem(commandAddChunky);
		menuItemAddSlime=makeMenuItem(commandAddSlime);
		menuItemEditRow=makeMenuItem(commandEditRow);
		menuItemClearNode=makeMenuItem(commandClearNode);
		menuItemClear=makeMenuItem(commandClear);

		menuEdit.add(menuItemAddStarship);
		menuEdit.add(menuItemAddLair);
		menuEdit.add(menuItemAddStargate);
		menuEdit.add(menuItemAddHero);
		menuEdit.add(menuItemAddMucus);
		menuEdit.add(menuItemAddChunky);
		menuEdit.add(menuItemAddSlime);
		menuEdit.add(menuItemEditRow);
		menuEdit.add(menuItemClearNode);
		menuEdit.add(menuItemClear);
		menuBar.add(menuEdit);

		//===========================
		//View Menu
		//===========================
		menuView=new JMenu("View");

		menuItemChangeSymbol=makeMenuItem(commandChangeSymbol);
		menuItemShowMap=makeMenuItem(commandShowMap);
		menuItemConvertRow=makeMenuItem(commandConvertRow);
		menuItemConvertLat=makeMenuItem(commandConvertLat);
		
		menuView.add(menuItemChangeSymbol);
		menuView.add(menuItemShowMap);
		menuView.add(menuItemConvertRow);
		menuView.add(menuItemConvertLat);
		
		menuBar.add(menuView);

		//===========================
		//About Menu Item
		//===========================
		menuItemAbout=makeMenuItem(commandAbout);
		menuBar.add(menuItemAbout);
		
	}
	
	private void MakeMapArea()
	{
		WstPopUpMenu tempPopup=null;
		
		mapComponent = new MapComponent();
		tempPopup=new WstPopUpMenu();
		tempPopup.setMapComponent(mapComponent);
		tempPopup.setParent(this);
		mapComponent.addMouseListener( mapComponent );
		mapComponent.setComponentPopupMenu(tempPopup);
		content = this.getContentPane();
		content.add(mapComponent, BorderLayout.CENTER); 
		repaint();
		validate();
	}
	
	
	public MainFrame()
	{
		super ("WST");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//==================================================
		map=new MapData();
		//==================================================
		subController=new SubController();
		subController.setMapData(map);
		//==================================================
		MakeMenus();
		MakeMapArea();
		MakeDialogAndData();
		//==================================================		
		this.setSize(new Dimension(1516,362));
		
	}
	
	private void MakeDialogAndData() 
	{
		// TODO Auto-generated method stub
		tempDialogTextBox=new DialogTextBox();
		tempDialogAddStarship=new DialogAddStarship();
		tempDataAddStarship=new DataAddStarship();
		tempDialogAddLair=new DialogAddLair();
		tempDataAddLair=new DataAddLair();
		tempDialogAddStargate=new DialogAddStargate();
		tempDataAddStargate=new DataAddStargate();
		tempDialogAddHero=new DialogAddHero();
		tempDataAddHero=new DataAddHero();
		tempDialogAddMucus=new DialogAddMucus();
		tempDataAddMucus=new DataAddMucus();
		tempDialogAddChunky=new DialogAddChunky();
		tempDataAddChunky=new DataAddChunky();
		tempDialogAddSlime=new DialogAddSlime();
		tempDataAddSlime=new DataAddSlime();
		tempDataLoad=new DataLoad();
		tempDialogLoad=new DialogLoad();
		tempDataSave=new DataSave();
		tempDialogSave=new DialogSave();
		tempDialogChangeSymbol=new DialogChangeSymbol();
		tempDataChangeSymbol=new DataChangeSymbol();
		tempDataEditRow=new DataEditRow();
		tempDialogEditRow=new DialogEditRow();
		tempDataClearNode=new DataClearNode();
		tempDialogClearNode=new DialogClearNode();
		tempDataConvertRow=new DataConvertRow();
		tempDialogConvertRow=new DialogConvertRow();
	}

	public void run()
	{
		this.setVisible(true);
		for (int row=0;row<10000;row+=1 )
		{				
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			repaint();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame main=new MainFrame();
		main.run();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command="";
		command=arg0.getActionCommand();
		
		switch(command)
		{
		case commandLoad:
			subController.load();
			subController.showMap(mapComponent);
			break;
		case commandSave:
			subController.Save();
			break;
		case commandExit:
			subController.exit();
			break;		
		case commandAddStarship:
			tempDialogAddStarship.setDataAddStarship(tempDataAddStarship);		
			tempDialogAddStarship.setModal(true);
			tempDialogAddStarship.setVisible(true);
			subController.addStarship(tempDialogAddStarship.row, tempDialogAddStarship.col,
					tempDialogAddStarship.clasification, tempDialogAddStarship.planet);
			subController.showMap(mapComponent);
			break;
		case commandAddLair:
			tempDialogAddLair.setDataAddLair(tempDataAddLair);		
			tempDialogAddLair.setModal(true);
			tempDialogAddLair.setVisible(true);
			subController.addLair(tempDialogAddLair.row, tempDialogAddLair.col,
					tempDialogAddLair.Street, tempDialogAddLair.Number, tempDialogAddLair.planet);
			subController.showMap(mapComponent);
			break;
		case commandAddStargate:
			tempDialogAddStargate.setDataAddStargate(tempDataAddStargate);		
			tempDialogAddStargate.setModal(true);
			tempDialogAddStargate.setVisible(true);
			subController.addStargate(tempDialogAddStargate.row, tempDialogAddStargate.col,
					tempDialogAddStargate.planet);
			subController.showMap(mapComponent);
			break;
		case commandAddHero:
			tempDialogAddHero.setDataAddHero(tempDataAddHero);		
			tempDialogAddHero.setModal(true);
			tempDialogAddHero.setVisible(true);
			subController.addHero(tempDialogAddHero.row, tempDialogAddHero.col, tempDialogAddHero.age);
			subController.showMap(mapComponent);
			break;
		case commandAddMucus:
			tempDialogAddMucus.setDataAddMucus(tempDataAddMucus);		
			tempDialogAddMucus.setModal(true);
			tempDialogAddMucus.setVisible(true);
			subController.addMucus(tempDialogAddMucus.row, tempDialogAddMucus.col,
					tempDialogAddMucus.Height, tempDialogAddMucus.Diameter, tempDialogAddMucus.powerLevel);
			subController.showMap(mapComponent);
			break;
		case commandAddChunky:
			tempDialogAddChunky.setDataAddChunky(tempDataAddChunky);		
			tempDialogAddChunky.setModal(true);
			tempDialogAddChunky.setVisible(true);
			subController.addChunky(tempDialogAddChunky.row, tempDialogAddChunky.col,
					tempDialogAddChunky.Smell, tempDialogAddChunky.PowerLevel);
			subController.showMap(mapComponent);
			break;
		case commandAddSlime:
			tempDialogAddSlime.setDataAddSlime(tempDataAddSlime);		
			tempDialogAddSlime.setModal(true);
			tempDialogAddSlime.setVisible(true);
			subController.addSlime(tempDialogAddSlime.row, tempDialogAddSlime.col,
					tempDialogAddSlime.Volume, tempDialogAddSlime.powerLevel);
			subController.showMap(mapComponent);
			break;
		case commandEditRow:
			tempDialogEditRow.setDataEditRow(tempDataEditRow);		
			tempDialogEditRow.setModal(true);
			tempDialogEditRow.setVisible(true);
			//subController.editRow(tempDialogEditRow.row);
			subController.showMap(mapComponent);
			break;
		case commandClearNode:
			tempDialogClearNode.setDataClearNode(tempDataClearNode);		
			tempDialogClearNode.setModal(true);
			tempDialogClearNode.setVisible(true);
			subController.clearNode(tempDialogClearNode.row, tempDialogClearNode.col);
			subController.showMap(mapComponent);
			break;
		case commandClear:
			subController.clear(mapComponent);
			subController.showMap(mapComponent);
			break;
		case commandChangeSymbol:
			tempDialogChangeSymbol.setDataChangeSymbol(tempDataChangeSymbol);
			tempDialogChangeSymbol.setModal(true);
			tempDialogChangeSymbol.setVisible(true);
			subController.ChangeSymbol(tempDialogChangeSymbol.water,
					tempDialogChangeSymbol.building,
					tempDialogChangeSymbol.vegetation,
					tempDialogChangeSymbol.rubble,
					tempDialogChangeSymbol.slime,
					tempDialogChangeSymbol.hologram,
					tempDialogChangeSymbol.hero,
					tempDialogChangeSymbol.ghost,
					tempDialogChangeSymbol.alien,
					tempDialogChangeSymbol.stargate);
			break;
		case commandShowMap:
			subController.showMap(mapComponent);
			break;
		case commandConvertRow:
			tempDialogConvertRow.setDataConvertRow(tempDataConvertRow);		
			tempDialogConvertRow.setModal(true);
			tempDialogConvertRow.setVisible(true);
			tempDialogTextBox.setTextBox(commandConvertRow,subController.ConvertRow(tempDialogConvertRow.row, tempDialogConvertRow.col));
			tempDialogTextBox.setModal(true);
			tempDialogTextBox.setVisible(true);
			break;
		case commandConvertLat:
			tempDialogConvertRow.setDataConvertRow(tempDataConvertRow);		
			tempDialogConvertRow.setModal(true);
			tempDialogConvertRow.setVisible(true);
			tempDialogTextBox.setTextBox(commandConvertLat,subController.ConvertLat(tempDialogConvertRow.row, tempDialogConvertRow.col));
			tempDialogTextBox.setModal(true);
			tempDialogTextBox.setVisible(true);
			break;
		case commandAbout:
			tempDialogTextBox.setTextBox(commandAbout,subController.about());
			tempDialogTextBox.setModal(true);
			tempDialogTextBox.setVisible(true);
			break;
		
		}
	}

}
