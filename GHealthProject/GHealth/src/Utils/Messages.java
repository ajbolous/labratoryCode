package Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Messages {
	
	public static void errorMessage(String message, String title, Component c){
		JOptionPane.showMessageDialog(c, message,title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void warningMessage(String message, String title, Component c){
		JOptionPane.showMessageDialog(c, message,title, JOptionPane.WARNING_MESSAGE);
	}
	
	public static void informationMessage(String message, String title, Component c){
		JOptionPane.showMessageDialog(c, message,title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int confirmMessage(String message,String title, Component c){
		return JOptionPane.showConfirmDialog(c,message,title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	}
	

	
}
