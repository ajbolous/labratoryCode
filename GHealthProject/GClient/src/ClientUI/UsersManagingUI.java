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
import Controllers.UsersController;
import models.User;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UsersManagingUI {

	private JFrame ui;
	private JTable tblOnline;
	private JTable tblLocked;

	
	public UsersManagingUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ui = new JFrame();
		ui.setTitle("<Frame name> - GHealth");
		ui.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		ui.setIconImage(icon);
		ui.setForeground(Color.BLACK);
		ui.setFont(new Font("Dialog", Font.PLAIN, 16));
		ui.setBackground(Color.WHITE);
		ui.getContentPane().setBackground(Color.WHITE);
		ui.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("Users managment");
		logo.setBounds(0, 0, 495, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		ui.getContentPane().add(logo);
		
		tblOnline = new JTable();
		tblOnline.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblOnline.setBounds(10, 91, 475, 160);
		tblOnline.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Id", "Name", "Email", "ip"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ui.getContentPane().add(tblOnline);
		
		tblLocked = new JTable();
		tblLocked.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblLocked.setBounds(10, 275, 475, 160);
		tblLocked.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Id", "Name", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		ui.getContentPane().add(tblLocked);
		ui.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		ui.setBounds(100, 100, 501, 496);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ui.setVisible(true);
		fillUsers();
	
	}
	
	private void fillUsers(){
		DefaultTableModel odm = (DefaultTableModel) tblOnline.getModel();
		DefaultTableModel ldm = (DefaultTableModel) tblLocked.getModel();

		for(User u : UsersController.getOnlineUsers())
			odm.addRow(new Object[]{u.getSid(),u.getFirstName() + " " + u.getLastName(),u.getEmail(),"127.0.0.1"});
		
		for(User u : UsersController.getLockedUsers())
			odm.addRow(new Object[]{u.getSid(),u.getFirstName() + " " + u.getLastName(),u.getEmail()});
	}
}
