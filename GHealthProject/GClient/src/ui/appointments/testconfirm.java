package ui.appointments;

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
import Controllers.AppointmentsController;
import Controllers.ReferralController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Confirmation;
import models.Examination;
import models.Patient;
import models.Referral;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ui.utils.MyTableModel;
import ui.utils.UITests;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;

public class testconfirm {

	private JFrame testconfirm; 
	private AppointmentsController app_ctrl = new AppointmentsController();
	private ReferralController RefCtrl = new ReferralController(); 
	private JTable tblToday; 

	
	
	public testconfirm(Patient p ) {
		initialize(p);
		testconfirm.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Patient p) {
		Resources res = new Resources();
		testconfirm = new JFrame();
		testconfirm.setTitle("New Conformation - GHealth");
		testconfirm.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		testconfirm.setIconImage(icon);
		testconfirm.setForeground(Color.BLACK);
		testconfirm.setFont(new Font("Dialog", Font.PLAIN, 16));
		testconfirm.setBackground(Color.WHITE);
		testconfirm.getContentPane().setBackground(Color.WHITE);
		testconfirm.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("New Refferal and conformation");
		logo.setBounds(-89, -12, 412, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		testconfirm.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(24, 69, 66, 14);
		testconfirm.getContentPane().add(lblPatientId);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 741, 409);
		testconfirm.getContentPane().add(scrollPane);
		
		tblToday = new JTable();
		scrollPane.setViewportView(tblToday);
		tblToday.setModel(new MyTableModel(new String[]{"id","Patient","namedoctor","cpec","Status"},new Object[][]{}));
		DefaultTableModel model = (DefaultTableModel) tblToday.getModel();
		for(Referral ref : p.getReferrals()){
			if(ref.isActive()){
			model.addRow(new Object[]{ref.getRid(),
					ref.getPatient().getSid(),
					ref.getDoctor_name(),
					ref.getSpeciality(),
					ref.isActive()
			}
			);
			}
		}
	
		JLabel label_id = new JLabel((String) p.getSid());
		label_id.setBounds(85, 64, 200, 25);
		testconfirm.getContentPane().add(label_id);
		testconfirm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		testconfirm.setBounds(100, 100, 576, 420);
		testconfirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


