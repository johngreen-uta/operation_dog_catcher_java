package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class MapComponent extends JComponent implements MouseListener{

	private static final long serialVersionUID = 1L;
	
	BufferedImage image;
	private ArrayList <Pin> thesePins;
	Point clickPosition = null;
	int corX;
	int corY;
	
	public MapComponent()
	{
		File mapFile=null;
		BufferedImage mapImage=null;
		try
		{
			mapFile=new File("..\\saves\\Manhattan.png");
			mapImage=ImageIO.read(mapFile);
		}
		catch(Exception e)
		{
			
		}
		image=mapImage;
		setThesePins(new ArrayList<Pin>());
	}
	
	public void paint(Graphics g) {
 
        g.drawImage(image, 0, 0, 1500, 300, null);
        
        int pinLoop=0;
        int pinMax=0;
        
        Pin thisPin;     
        
        pinMax=getThesePins().size();
        for (pinLoop=0;pinLoop<pinMax;pinLoop++)
        {
        	thisPin=getThesePins().get(pinLoop);      	
        	g.drawImage(thisPin.getIcon(),thisPin.pos.x,thisPin.pos.y,null);	
        }        
    }

	public Dimension getPreferredSize() {
		if (image == null) {
			return new Dimension(1500,300);
		} else {
			return new Dimension(image.getWidth(null), image.getHeight(null));
		}
	}

	public void addPin(Pin myPin) {
		// TODO Auto-generated method stub
		getThesePins().add(myPin);
	}

	public ArrayList <Pin> getThesePins() {
		return thesePins;
	}

	public void setThesePins(ArrayList <Pin> thesePins) {
		this.thesePins = thesePins;
	}
	
	public Point getPoint()
	{
		int x = (int) Math.floor(clickPosition.getX()/(1500/147.0));
		int y = (int) Math.floor(clickPosition.getY()/(300/19.0));
		Point newPoint=new Point(x,y);
		return newPoint;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clickPosition = this.getMousePosition();
		System.out.println("MousePressed at: "+clickPosition);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}     
}
	
	
	
	

