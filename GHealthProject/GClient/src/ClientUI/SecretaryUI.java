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
import Controllers.MedicalRecordController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Appointment;
import models.Secretary;
import models.Treatment;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

	public class SecretaryUI { 

		private JFrame secretary;
		private JTable table;
		private MedicalRecordController mrctrl = new MedicalRecordController();
		private ArrayList <Treatment> trList;

		
		public SecretaryUI() {
			initialize();
			secretary.setSize(666, 512);
			secretary.setLocationRelativeTo(null);
			secretary.setVisible(true);
			
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Resources res = new Resources();
			secretary = new JFrame();
			secretary.setTitle("<Frame name> - GHealth");
			secretary.setResizable(false);
			Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
			secretary.setIconImage(icon);
			secretary.setForeground(Color.BLACK);
			secretary.setFont(new Font("Dialog", Font.PLAIN, 16));
			secretary.setBackground(Color.WHITE);
			secretary.getContentPane().setBackground(Color.WHITE);
			secretary.getContentPane().setLayout(null);
			
			JLabel logo = new JLabel("GHealth - <Frame Name>");
			logo.setBounds(0, 0, 495, 80);
			logo.setForeground(SystemColor.textHighlight);
			logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
			logo.setBackground(Color.WHITE);
			logo.setIcon(res.getIcon("logo.png"));
			secretary.getContentPane().add(logo);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 182, 640, 212);
			secretary.getContentPane().add(scrollPane);
			
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"treatmentId", "PatientId", "PatientName", "DocotrName", "startDate", "EndDate", 
				}
			));
			 trList  = (ArrayList)mrctrl.getAllopenTreatments((Secretary)Application.user);
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				dm.setRowCount(0);
				for (Treatment t : trList) {
					dm.addRow(new Object[] { t.getTid(),t.getMedicalRecord().getPatient().getSid(),
							t.getMedicalRecord().getPatient().getFirstName()+" "+t.getMedicalRecord().getPatient().getLastName(),
							t.getDoctor().getFirstName() + " "+  t.getDoctor().getLastName(),
							DateTime.getDateString(t.getStart()),
							DateTime.getTimeString(t.getEnd())});
				}
					
					
				
			
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			table.getColumnModel().getColumn(1).setPreferredWidth(109);
			table.getColumnModel().getColumn(2).setPreferredWidth(95);
			scrollPane.setViewportView(table);
			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent event){
							int row=table.getSelectedRow();
							Treatment treatment =trList.get(row);
							
							
							

						}
						
					});
			secretary.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
			secretary.setBounds(100, 100, 501, 496);
			secretary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}


