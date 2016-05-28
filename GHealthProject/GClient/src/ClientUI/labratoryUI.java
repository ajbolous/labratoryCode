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

import Client.Application;
import Client.Resources;
import models.Examination;
import models.Labratorian;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class labratoryUI {

	private JFrame labratoryUI;
	private JTable tblToday;

	
	public labratoryUI() {
		initialize();
		labratoryUI.setVisible(true);
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 66, 751, 36);
		labratoryUI.getContentPane().add(panel);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 11, 46, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("<dynamic> <dynamic>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(61, 11, 207, 21);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(223, 11, 90, 21);
		panel.add(label_3);
		
		JLabel label_2 = new JLabel("<dynamic> <dynamic>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(585, 11, 156, 21);
		panel.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 741, 131);
		labratoryUI.getContentPane().add(scrollPane);
		
		tblToday = new JTable();
		scrollPane.setViewportView(tblToday);
		tblToday.setModel(new MyTableModel(new String[]{"id","Doctor","Patient","Type","Status"},new Object[][]{}));
		
		JLabel lblTodaysExaminations = new JLabel("Today's Examinations");
		lblTodaysExaminations.setBounds(0, 108, 170, 14);
		labratoryUI.getContentPane().add(lblTodaysExaminations);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(11, 267, 740, 248);
		labratoryUI.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(25, 11, 46, 14);
		panel_1.add(lblNewLabel);

		fillExaminations(tblToday);
		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		labratoryUI.setBounds(100, 100, 763, 555);
		labratoryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void fillExaminations(JTable tbl){
		DefaultTableModel model = (DefaultTableModel) tbl.getModel();
		Labratorian lab = (Labratorian) Application.user;
		for(Examination e : lab.getExaminations())
			model.addRow(new Object[]{e.getEid(),
					e.getTreatment().getDoctor().getFirstName(),
					e.getTreatment().getMedicalRecord().getPatient().getSid(),
					e.getEType(),
					"Opened"
			});
	}
}
