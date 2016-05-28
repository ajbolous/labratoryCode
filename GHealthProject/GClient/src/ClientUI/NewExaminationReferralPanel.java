package ClientUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Examination;
import models.Patient;
import models.Visit;

	import java.awt.Panel;
import java.awt.Rectangle;

	import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import Controllers.MedicalRecordController;
import Utils.DateTime;

	import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.JComboBox;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class NewExaminationReferralPanel  extends JPanel {
		private JTextField textField_1;
		JLabel error_lbl;
		
		String exType;
		MedicalRecordController mrctrl = new MedicalRecordController();
		
		/**
		 * Create the panel.
		 */
		public NewExaminationReferralPanel(Examination ex) {
			super();
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "New Referral", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			setBackground(UIManager.getColor("Panel.background"));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			
			textField_1 = new JTextField(DateTime.getDateString(ex.getExaminationDate()));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(140, 59, 197, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(9, 61, 46, 14);
			add(lblDate);
			
			JLabel lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblComments.setBounds(10, 183, 110, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(140, 178, 308, 68);
			add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			
			
			JLabel lblNewLabel = new JLabel("Examination Type :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(9, 115, 121, 20);
			add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exType=(String) comboBox.getSelectedItem();
					
				}
			});
			
			comboBox.setBounds(140, 113, 197, 27);
			add(comboBox);
			
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String comment = textArea.getText();

					error_lbl.setText("");
					if (UITests.notEmpty(comment) == false)
						error_lbl.setText("*Please enter comment");
					
					else {
						ex.setComments(comment);
						ex.setEType(exType);
						removeAll();
						revalidate();
						updateUI();
					
						JLabel msg = new JLabel("");
						if (ex.getTreatment().isEndFlag()){
							msg.setText("you canit add visits and Examibations to Treatment"+ex.getTreatment().getTid()+
									ex.getTreatment().gettType()+"\nEnd Date :  "+DateTime.getDateString(ex.getTreatment().getEnd()));
							msg.setBackground(Color.RED);
						}
						else{
							mrctrl.saveExamination(ex);
						msg.setText(" *Examnation added to Treatment "+ex.getTreatment().getTid()+
									" "+ex.getTreatment().gettType()+ "  successfully");
						msg.setBackground(Color.BLUE);
						
						}
						
						 msg.setFont(new Font("Tahoma", Font.PLAIN, 13));
						 
						msg.setBounds(100, 86, 269, 27);
						add(msg);
						//setVisible(false);
				}
				}
			});
			btnSave.setBounds(140, 277, 89, 23);
			add(btnSave);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancel.setBounds(296, 277, 89, 23);
			add(btnCancel);
			
			 error_lbl = new JLabel("");
			 error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				error_lbl.setForeground(Color.RED);
				error_lbl.setBounds(140, 153, 269, 27);
			
			add(error_lbl);
			
			
			
		}
	}

