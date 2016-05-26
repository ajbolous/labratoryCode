package ClientUI;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Resources;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class labratoryUI {

	private JFrame labratoryUI;

	
	public labratoryUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		labratoryUI = new JFrame();
		labratoryUI.setTitle("<Frame name> - GHealth");
		labratoryUI.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		labratoryUI.setIconImage(icon);
		labratoryUI.setForeground(Color.BLACK);
		labratoryUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		labratoryUI.setBackground(Color.WHITE);
		labratoryUI.getContentPane().setBackground(Color.WHITE);
		labratoryUI.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - <Frame Name>");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		labratoryUI.getContentPane().add(logo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 86, 495, 370);
		labratoryUI.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("tests", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("MedicalRecordforpatient", null, panel_1, null);
		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		labratoryUI.setBounds(100, 100, 501, 496);
		labratoryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
