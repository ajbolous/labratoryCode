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
import Controllers.InvoiceController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Examination;
import models.Invoice;
import models.Treatment;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import com.j256.ormlite.stmt.query.SetValue;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

	public class InvoiceUI {
		

		private JFrame Invoice;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JLabel error_lbl ;
		private String[] exList ;
		private InvoiceController invoicectrl = new InvoiceController();
		
		

		
		public InvoiceUI(Treatment treatment  ,SecretaryUI secUI) {
			initialize(treatment ,secUI);
			
			Invoice.setLocationRelativeTo(null);
			Invoice.setVisible(true);
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize(Treatment treatment ,SecretaryUI secUI) {
			Resources res = new Resources();
			Invoice = new JFrame();
			Invoice.setTitle("<Invoice> - GHealth");
			Invoice.setResizable(false);
			Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
			Invoice.setIconImage(icon);
			Invoice.setForeground(Color.BLACK);
			Invoice.setFont(new Font("Dialog", Font.PLAIN, 16));
			Invoice.setBackground(Color.WHITE);
			Invoice.getContentPane().setBackground(Color.WHITE);
			Invoice.getContentPane().setLayout(null);
			Invoice.setLocale(null);
			Invoice.setSize(388, 491);
			JLabel logo = new JLabel("GHealth - <Invoice>");
			logo.setBounds(0, 0, 365, 71);
			logo.setForeground(SystemColor.textHighlight);
			logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
			logo.setBackground(Color.WHITE);
			logo.setIcon(res.getIcon("logo.png"));
			Invoice.getContentPane().add(logo);
			
			JLabel lblNewLabel = new JLabel("TreatmentID : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(21, 82, 90, 22);
			Invoice.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("NumOfVisits : ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(21, 182, 90, 22);
			Invoice.getContentPane().add(lblNewLabel_1);
			
			JLabel lblExaminations = new JLabel("Examinations : ");
			lblExaminations.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblExaminations.setBounds(21, 231, 90, 22);
			Invoice.getContentPane().add(lblExaminations);
			
			JLabel lblTreatmenttype = new JLabel("TreatmentType");
			lblTreatmenttype.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTreatmenttype.setBounds(21, 136, 90, 14);
			Invoice.getContentPane().add(lblTreatmenttype);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(121, 234, 146, 81);
			Invoice.getContentPane().add(scrollPane);
			
			JList list = new JList();
			list.setEnabled(false);
			list.setVisibleRowCount(3);
			ArrayList<String> examinationList = new ArrayList<String>(); 
			Iterator<Examination> examination = treatment
					.getExamination().iterator();
			while (examination.hasNext()) {
				Examination ex = examination.next();
				examinationList.add(ex.geteType());
				
				
			}
			 exList = new String[examinationList.size()] ;
			exList=examinationList.toArray(exList);
			
			list.setModel(new AbstractListModel() {
				
				String[] values =exList;
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			scrollPane.setViewportView(list);
			
			JLabel lblPayment = new JLabel("Payment :");
			lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPayment.setBounds(21, 347, 90, 22);
			Invoice.getContentPane().add(lblPayment);
			
			textField = new JTextField(""+treatment.getTid());
			textField.setEditable(false);
			textField.setBounds(121, 84, 146, 20);
			Invoice.getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField(treatment.gettType());
			textField_1.setEditable(false);
			textField_1.setBounds(121, 134, 146, 20);
			Invoice.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField(""+treatment.getVisits().size());
			textField_2.setEditable(false);
			textField_2.setBounds(121, 187, 146, 20);
			Invoice.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(121, 349, 146, 20);
			Invoice.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel label = new JLabel("$");
			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label.setBounds(269, 352, 27, 14);
			Invoice.getContentPane().add(label);
			
			JButton btnSend = new JButton("Send ");
			btnSend.setToolTipText("Send the invoice to HMO  .");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Invoice invoice = new Invoice();
					invoice.setTreatment(treatment);
					try {
						invoice.setDate(DateTime.currentDate());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String payment = textField_3.getText();
					
					error_lbl.setText("");
					if (UITests.notEmpty(payment) == false)
						error_lbl.setText("* Please enter Payment");
					else
					{
						invoice.setPayment(Double.parseDouble(payment));
						//send Invoice to HMO
						invoicectrl.sendInvoice(invoice);
						
						Messages.successMessage("Invoice was sended successfully ", "Success",Invoice);
						secUI.removeTreatment(treatment);
					}
					
				}
			});
			error_lbl = new JLabel("");
			error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			error_lbl.setForeground(Color.RED);
		    error_lbl.setBounds(121, 319, 269, 30);
		    Invoice.getContentPane().add(error_lbl);
			
			btnSend.setBounds(121, 426, 89, 23);
			Invoice.getContentPane().add(btnSend);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = Messages.confirmMessage("Are you sure you want to cancel?","GHealth" , null);
								if(result == JOptionPane.YES_OPTION){
									Invoice.dispose();
								}
								
										
					
				}
			});
			btnCancel.setBounds(220, 426, 89, 23);
			Invoice.getContentPane().add(btnCancel);
			Invoice.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
			Invoice.setBounds(100, 100, 388, 489);
			Invoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}


