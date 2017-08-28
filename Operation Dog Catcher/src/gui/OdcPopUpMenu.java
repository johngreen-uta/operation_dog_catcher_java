package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class OdcPopUpMenu extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuItem menuItemPkeScan;
	private JMenuItem menuItemSpectrailTrailScan;
	private JMenuItem menuItemVisualScan;
	private JMenuItem menuItemSendInspector;
	private JMenuItem menuItemGetHood;
	
	private MapComponent myMapComponent;
	private MainFrame parent;
	
	// Scan Menu
	private static final String commandPkeScan="PKE Scan";
	private static final String commandSpectrailTrailScan="Spectral Trail Scan";
	private static final String commandVisualScan="Visual Scan";
	private static final String commandSendInspector="Send Inspector";
	private static final String commandGetHood="Nieghborhood";
	
	public OdcPopUpMenu()
	{			
		menuItemPkeScan=new JMenuItem(commandPkeScan);
		menuItemPkeScan.addActionListener(this);
		this.add(menuItemPkeScan);
	
		menuItemSpectrailTrailScan=new JMenuItem(commandSpectrailTrailScan);
		menuItemSpectrailTrailScan.addActionListener(this);
		this.add(menuItemSpectrailTrailScan);
		
		menuItemVisualScan=new JMenuItem(commandVisualScan);
		menuItemVisualScan.addActionListener(this);
		this.add(menuItemVisualScan);
		
		menuItemSendInspector=new JMenuItem(commandSendInspector);
		menuItemSendInspector.addActionListener(this);
		this.add(menuItemSendInspector);
		
		menuItemGetHood=new JMenuItem(commandGetHood);
		menuItemGetHood.addActionListener(this);
		this.add(menuItemGetHood);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		switch(arg0.getActionCommand())
		{
		case commandPkeScan:
			parent.tempDialogScanNode.setDataScanNode(parent.tempDataScanNode, myMapComponent.getPoint());
			parent.subController.PkeScan(parent.tempDataScanNode.row, parent.tempDataScanNode.col);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandSpectrailTrailScan:
			parent.tempDialogScanNode.setDataScanNode(parent.tempDataScanNode, myMapComponent.getPoint());
			parent.subController.SpectrailTrailScan(parent.tempDataScanNode.row, parent.tempDataScanNode.col);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandVisualScan:
			System.out.println(myMapComponent.getPoint());
			parent.tempDialogScanNode.setDataScanNode(parent.tempDataScanNode, myMapComponent.getPoint());
			
			parent.subController.VisualScan(parent.tempDataScanNode.row, parent.tempDataScanNode.col);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandSendInspector:
			parent.tempDialogScanNode.setDataScanNode(parent.tempDataScanNode, myMapComponent.getPoint());
			parent.subController.SendInspector(parent.tempDataScanNode.row, parent.tempDataScanNode.col);
			parent.subController.showMap(parent.mapComponent);
			break;
		case commandGetHood:
			parent.tempDialogScanNode.setDataScanNode(parent.tempDataScanNode, myMapComponent.getPoint());
			parent.tempDialogTextBox.setTextBox(commandGetHood,
					parent.subController.getHood(parent.tempDataScanNode.row, parent.tempDataScanNode.col));
			parent.tempDialogTextBox.setModal(true);
			parent.tempDialogTextBox.setVisible(true);
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