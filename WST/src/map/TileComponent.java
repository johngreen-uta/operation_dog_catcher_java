package map;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;


public class TileComponent extends JComponent implements MouseListener
{
	
private static final long serialVersionUID = 1L;

BufferedImage image;
JLabel localStatusBar;
JPopupMenu popUpMenu;
	
	
	public TileComponent(BufferedImage img, JLabel statusBar) {
		image=img;
		localStatusBar=statusBar;
	
	}

	public void paint(Graphics g) {
 
        g.drawImage(image, 0, 0, null);
        
    }

	  public Dimension getPreferredSize() {
	        if (image == null) {
	             return new Dimension(800,600);
	        } else {
	           return new Dimension(image.getWidth(null), image.getHeight(null));
	       }
	    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MouseClicked");
		Point p=arg0.getLocationOnScreen();
		
		
		popUpMenu.setLocation(p.x,p.y);

		popUpMenu.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//localStatusBar.setText("BOO!");
		System.out.println("MousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MouseReleased");
	}

	public void setPopupMenu(JPopupMenu testMenu) {
		// TODO Auto-generated method stub
		popUpMenu=testMenu;
	}    

	

}
