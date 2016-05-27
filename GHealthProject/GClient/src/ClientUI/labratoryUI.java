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
import javax.swing.JTable;

public class labratoryUI {

	private JFrame labratoryUI;
	private JTable table;

	
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
		
		JLabel logo = new JLabel("Examinations");
		logo.setBounds(0, 0, 645, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		labratoryUI.getContentPane().add(logo);
		
		table = new JTable();
		table.setBounds(10, 71, 635, 139);
		table.setModel(new MyTableModel(new String[]{"id","Doctor","Patient","Comments","Status"},new Object[][]{}));
		
		
		labratoryUI.getContentPane().add(table);
		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		labratoryUI.setBounds(100, 100, 661, 623);
		labratoryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
