package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import javax.swing.ImageIcon;

public class Pin {
	
	//Image Files
	ImageIcon tempIcon;
	Image tempImage;

	//Position on the Map
	public Position pos;
	public int icon;
	
	public Pin(int x,int y, int iconInt)
	{	
		pos=new Position(x,y);
		if(iconInt == 0)
			tempIcon=new ImageIcon("..\\saves\\0.png");
		else if(iconInt == 1)
			tempIcon=new ImageIcon("..\\saves\\1.png");
		else if(iconInt == 2)
			tempIcon=new ImageIcon("..\\saves\\2.png");
		else if(iconInt == 3)
			tempIcon=new ImageIcon("..\\saves\\3.png");
		else if(iconInt == 4)
			tempIcon=new ImageIcon("..\\saves\\4.png");
		else if(iconInt == 5)
			tempIcon=new ImageIcon("..\\saves\\5.png");
		else if(iconInt == 6)
			tempIcon=new ImageIcon("..\\saves\\6.png");
		else if(iconInt == 7)
			tempIcon=new ImageIcon("..\\saves\\7.png");
		else if(iconInt == 8)
			tempIcon=new ImageIcon("..\\saves\\8.png");
		else if(iconInt == 9)
			tempIcon=new ImageIcon("..\\saves\\9.png");
		else if(iconInt == 10)
			tempIcon=new ImageIcon("..\\saves\\true.png");
		else if(iconInt == 11)
			tempIcon=new ImageIcon("..\\saves\\false.png");
		else if(iconInt == 12)
			tempIcon=new ImageIcon("..\\saves\\alien.png");
		else if(iconInt == 13)
			tempIcon=new ImageIcon("..\\saves\\hero.png");
		else if(iconInt == 14)
			tempIcon=new ImageIcon("..\\saves\\ghost.png");
		else if(iconInt == 15)
			tempIcon=new ImageIcon("..\\saves\\stargate.png");
		//=========================
		
		//Taken From:
		//http://stackoverflow.com/questions/14097386/how-to-make-drawn-images-transparent-in-java
		
		ImageFilter filter = new RGBImageFilter() {
			int transparentColor = Color.white.getRGB() | 0xFF000000;

			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == transparentColor) {
					return 0x00FFFFFF & rgb;
				} else {
					return rgb;
				}
			}
		};

		ImageProducer filteredImgProd = new FilteredImageSource(tempIcon.getImage().getSource(), filter);
		tempImage = Toolkit.getDefaultToolkit().createImage(filteredImgProd);
	      
		//=========================
	}
	
	public Image getIcon()
	{
			return tempImage;
	}
}
