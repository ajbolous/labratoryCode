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
import Controllers.InvoiceController;
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
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

	public class SecretaryUI { 

		private JFrame secretary;
		private JTable table;
		private InvoiceController invoicectrl = new InvoiceController();
		private ArrayList <Treatment> trList;
		private JPanel panel;

		
		public SecretaryUI() {
			initialize(this);
			secretary.setSize(756, 512);
			secretary.setLocationRelativeTo(null);
			secretary.setVisible(true);
			
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize(SecretaryUI  secUI) {
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
			logo.setBounds(0, 0, 495, 68);
			logo.setForeground(SystemColor.textHighlight);
			logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
			logo.setBackground(Color.WHITE);
			logo.setIcon(res.getIcon("logo.png"));
			secretary.getContentPane().add(logo);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 143, 751, 318);
			secretary.getContentPane().add(scrollPane);
			
			
			table = new JTable();
		
			table.setModel(new MyTableModel(
				new String[] {
					"TreatmentId", "PatientId", "PatientName", "DocotrName", "startDate", "EndDate", 
				},
				new Object[][] {
				}
			));
			 trList  = (ArrayList)invoicectrl.getAllopenTreatments((Secretary)Application.user);
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				dm.setRowCount(0);
				for (Treatment t : trList) {
					dm.addRow(new Object[] { t.getTid(),t.getMedicalRecord().getPatient().getSid(),
							t.getMedicalRecord().getPatient().getFirstName()+" "+t.getMedicalRecord().getPatient().getLastName(),
							t.getDoctor().getFirstName() + " "+  t.getDoctor().getLastName(),
							DateTime.getDateString(t.getStart()),
							DateTime.getDateString(t.getEnd())});
				}
					
					
				table.setFillsViewportHeight(true);
				table.setSurrendersFocusOnKeystroke(true);
				table.setShowVerticalLines(false);
				table.setRowHeight(30);
				table.setFont(new Font("Tahoma", Font.PLAIN, 16));
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setBackground(Color.WHITE);
			
			
			scrollPane.setViewportView(table);
			
			panel = new JPanel();
			panel.setBounds(20, 91, 630, 54);
			panel.setLayout(null);
			panel.setBounds(0, 66, 751, 36);
			secretary.getContentPane().add(panel);
			
			JLabel label = new JLabel("Name:");
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBounds(10, 11, 46, 21);
			panel.add(label);
			
			JLabel label_1 = new JLabel("<dynamic> <dynamic>");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(61, 11, 207, 21);
			panel.add(label_1);
			
			label_1.setText(new String (((Secretary)Application.user).getFirstName()+" "+((Secretary)Application.user).getLastName()));
			
			JLabel label_3 = new JLabel((String) null);
			label_3.setHorizontalAlignment(SwingConstants.TRAILING);
			label_3.setVerticalAlignment(SwingConstants.TOP);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_3.setBounds(223, 11, 90, 21);
			panel.add(label_3);
			
			JLabel label_2 = new JLabel("<dynamic> <dynamic>");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_2.setBounds(502, 11, 239, 21);
			panel.add(label_2);
			try {
				label_2.setText(new String ("Today:"+Utils.DateTime.currentDate().toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secretary.getContentPane().add(panel);
			
			JLabel lblTreatments = new JLabel("Treatments : ");
			lblTreatments.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTreatments.setBounds(10, 113, 104, 24);
			secretary.getContentPane().add(lblTreatments);
			
			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent event){
							int row=table.getSelectedRow();
							
							Treatment treatment =trList.get(row);
							
							InvoiceUI in = new InvoiceUI(treatment ,secUI);
							
							
							

						}
						
					});
			secretary.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
			secretary.setBounds(100, 100, 501, 496);
			secretary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public void removeTreatment(Treatment t )
		{
	
			DefaultTableModel dm = (DefaultTableModel) table.getModel();
			dm.removeRow(trList.indexOf(t ));
			
			
		}
	}


