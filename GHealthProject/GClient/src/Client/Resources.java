package Client;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Resources {
	public static ImageIcon getIcon(String name){
			return new ImageIcon(Resources.class.getResource("/img/" + name));
		}
	
	public static Image getImage(String name){
		return new ImageIcon(Resources.class.getResource("/img/" + name)).getImage();
	}
}
