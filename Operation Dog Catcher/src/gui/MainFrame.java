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
	
	// Scan Menu
	private static final String commandPkeScan="PKE Scan";
	private static final String commandSpectrailTrailScan="Spectral Trail Scan";
	private static final String commandVisualScan="Visual Scan";
	private static final String commandSendInspector="Send Inspector";
	
	// View Menu
	private static final String commandChangeSymbol="Change Map Symbol";
	private static final String commandShowMap="View Map";
	private static final String commandShowPkeScan="PKE Map";
	private static final String commandShowSpectrailScan="Spectrail Trail Map";
	private static final String commandShowVisualScan="Visual Map";
	private static final String commandShowPkeCount="Pke count Map";
	private static final String commandShowSpectrailcount="Spectrail Trail count Map";
	private static final String commandShowVisualCount="Visual Count Map";
	private static final String commandShowReport="View Report";
	
	// About Menu
	private static final String commandAbout="About";
	
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuItemLoad;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	
	private JMenu menuScan;
	private JMenuItem menuItemPkeScan;
	private JMenuItem menuItemSpectrailTrailScan;
	private JMenuItem menuItemVisualScan;
	private JMenuItem menuItemSendInspector;

	
	private JMenu menuView;
	private JMenuItem menuItemChangeSymbol;
	private JMenuItem menuItemShowMap;
	private JMenuItem menuItemShowPkeScan;
	private JMenuItem menuItemShowSpectrailScan;
	private JMenuItem menuItemShowVisualScan;
	private JMenuItem menuItemShowPkeCount;
	private JMenuItem menuItemShowSpectrailcount;
	private JMenuItem menuItemShowVisualCount;
	private JMenuItem menuItemShowReport;

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
	DialogScanNode tempDialogScanNode;
	DataScanNode tempDataScanNode;
	

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
		//Scan Menu
		//===========================
		menuScan=new JMenu("Scan");

		
		menuItemPkeScan=makeMenuItem(commandPkeScan);
		menuItemSpectrailTrailScan=makeMenuItem(commandSpectrailTrailScan);
		menuItemVisualScan=makeMenuItem(commandVisualScan);
		menuItemSendInspector=makeMenuItem(commandSendInspector);

		menuScan.add(menuItemPkeScan);
		menuScan.add(menuItemSpectrailTrailScan);
		menuScan.add(menuItemVisualScan);
		menuScan.add(menuItemSendInspector);
		menuBar.add(menuScan);

		//===========================
		//View Menu
		//===========================
		menuView=new JMenu("View");

		menuItemChangeSymbol=makeMenuItem(commandChangeSymbol);
		menuItemShowMap=makeMenuItem(commandShowMap);
		menuItemShowPkeScan=makeMenuItem(commandShowPkeScan);
		menuItemShowSpectrailScan=makeMenuItem(commandShowSpectrailScan);
		menuItemShowVisualScan=makeMenuItem(commandShowVisualScan);
		menuItemShowPkeCount=makeMenuItem(commandShowPkeCount);
		menuItemShowSpectrailcount=makeMenuItem(commandShowSpectrailcount);
		menuItemShowVisualCount=makeMenuItem(commandShowVisualCount);
		menuItemShowReport=makeMenuItem(commandShowReport);
		menuView.add(menuItemChangeSymbol);
		menuView.add(menuItemShowMap);
		menuView.add(menuItemShowPkeScan);
		menuView.add(menuItemShowSpectrailScan);
		menuView.add(menuItemShowVisualScan);
		menuView.add(menuItemShowPkeCount);
		menuView.add(menuItemShowSpectrailcount);
		menuView.add(menuItemShowVisualCount);
		menuView.add(menuItemShowReport);
		menuBar.add(menuView);

		//===========================
		//About Menu Item
		//===========================
		menuItemAbout=makeMenuItem(commandAbout);
		menuBar.add(menuItemAbout);
		
	}
	
	private void MakeTextArea()
	{
		/*
		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", 0, 10));
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		content = this.getContentPane();
		content.add(scrollPane, BorderLayout.CENTER);
		subController.setTextArea(textArea);
		*/
		
		OdcPopUpMenu tempPopup=null;
		
		mapComponent = new MapComponent();
		tempPopup=new OdcPopUpMenu();
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
		super ("ODC");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//==================================================
		map=new MapData();
		//==================================================
		subController=new SubController();
		subController.setMapData(map);
		//==================================================
		MakeMenus();
		MakeTextArea();
		MakeDialogAndData();
		//==================================================		
		this.setSize(new Dimension(1516,362));
		
	}
	
	private void MakeDialogAndData() 
	{
		// TODO Auto-generated method stub
		tempDialogTextBox=new DialogTextBox();
		tempDialogScanNode=new DialogScanNode();
		tempDataScanNode=new DataScanNode();
		tempDataLoad=new DataLoad();
		tempDialogLoad=new DialogLoad();
		tempDataSave=new DataSave();
		tempDialogSave=new DialogSave();
		tempDialogChangeSymbol=new DialogChangeSymbol();
		tempDataChangeSymbol=new DataChangeSymbol();
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
		case commandPkeScan:
			tempDialogScanNode.setDataScanNode(tempDataScanNode);		
			tempDialogScanNode.setModal(true);
			tempDialogScanNode.setVisible(true);
			subController.PkeScan(tempDialogScanNode.row, tempDialogScanNode.col);
			subController.showMap(mapComponent);
			break;
		case commandSpectrailTrailScan:
			tempDialogScanNode.setDataScanNode(tempDataScanNode);		
			tempDialogScanNode.setModal(true);
			tempDialogScanNode.setVisible(true);
			subController.SpectrailTrailScan(tempDialogScanNode.row, tempDialogScanNode.col);
			subController.showMap(mapComponent);
			break;
		case commandVisualScan:
			tempDialogScanNode.setDataScanNode(tempDataScanNode);		
			tempDialogScanNode.setModal(true);
			tempDialogScanNode.setVisible(true);
			subController.VisualScan(tempDialogScanNode.row, tempDialogScanNode.col);
			subController.showMap(mapComponent);
			break;
		case commandSendInspector:
			tempDialogScanNode.setDataScanNode(tempDataScanNode);		
			tempDialogScanNode.setModal(true);
			tempDialogScanNode.setVisible(true);
			subController.SendInspector(tempDialogScanNode.row, tempDialogScanNode.col);
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
		case commandShowPkeScan:
			subController.ShowPkeScan(mapComponent);
			repaint();
			break;
		case commandShowSpectrailScan:
			subController.ShowSpectrailScan(mapComponent);
			break;
		case commandShowVisualScan:
			subController.ShowVisualScan(mapComponent);
			break;
		case commandShowPkeCount:
			subController.ShowPkeCount(mapComponent);
			break;
		case commandShowSpectrailcount:
			subController.ShowSpectrailcount(mapComponent);
			break;
		case commandShowVisualCount:
			subController.ShowVisualCount(mapComponent);
			break;
		case commandShowReport:
			tempDialogTextBox.setTextBox(commandShowReport,subController.ShowReport());
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
