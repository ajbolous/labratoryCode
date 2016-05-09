package Client;

import javax.swing.ImageIcon;

public class Resources {
	public ImageIcon getIcon(String name){
		return new ImageIcon(this.getClass().getResource("/img/" + name));
		}
}
