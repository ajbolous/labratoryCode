package ClientUI;

import java.awt.EventQueue;

		import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

		import java.awt.Color;

		import javax.swing.JLabel;

		import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

		import javax.swing.JButton;

		import Client.Resources;
import Controllers.MedicalRecordController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import javax.swing.UIManager;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.border.TitledBorder;

public class NewVisitUI extends JPanel  {
	
	
	private JTextField textField_1;
	private JTextArea textArea = new JTextArea();
	JLabel error_lbl;
	
	MedicalRecordController mrctrl = new MedicalRecordController();
	// TODO Auto-generated constructor stub
	public NewVisitUI(Visit visit, DoctorMedicalRecordUI doctorMedicalRecordUI) {
				
				
				super ();
				setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "New Visit", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				setBackground(UIManager.getColor("Panel.background"));
				setBounds(new Rectangle(283, 143, 122, 144));
				setLayout(null);
				
				textField_1 = new JTextField(DateTime.getDateString(visit.getVisitDate())+" "+ DateTime.getTimeString(visit.getVisitDate()));
				textField_1.setBounds(107, 52, 155, 20);
				textField_1.setBackground(Color.WHITE);
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				add(textField_1);
				
				JLabel lblDate = new JLabel("Visit Date :");
				lblDate.setBounds(10, 54, 77, 14);
				lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(lblDate);
				
				JLabel lblComments = new JLabel("Visit description : ");
				lblComments.setBounds(10, 121, 97, 20);
				lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(lblComments);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(107, 122, 329, 120);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				add(scrollPane);
				
				JTextArea textArea = new JTextArea();
				textArea.addInputMethodListener(new InputMethodListener() {
					public void caretPositionChanged(InputMethodEvent arg0) {
					}
					public void inputMethodTextChanged(InputMethodEvent arg0) {
						
					}
				});
				textArea.setFont(UIManager.getFont("Button.font"));
				scrollPane.setViewportView(textArea);
				
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String comments= textArea.getText(); 
						error_lbl.setText("");
						if (UITests.notEmpty(comments) == false)
							error_lbl.setText("*Please enter visit description");
						
						else {
							visit.setComments(textArea.getText());
							
						
							
							if (visit.getTreatment().isEndFlag()){
								Messages.warningMessage("canot add Visits or Examibations to Treatment"+visit.getTreatment().getTid()+
										"-" +visit.getTreatment().gettType()+"\nThis treatment is closed", "warnning", doctorMedicalRecordUI.DoctorMedicalRecord);
							
								
							}
							else{
								mrctrl.saveVisit(visit);
								
								Visit visitDB =(Visit)mrctrl.getLastVisitByTid(visit.getTreatment().getTid());
								
								Messages.successMessage("Visit was added successfully to Treatment "+visit.getTreatment().getTid()+
										"-"+visit.getTreatment().gettType(), "Success", doctorMedicalRecordUI.DoctorMedicalRecord);
								System.out.println("visitDB"+visitDB.getVid());

								doctorMedicalRecordUI.updateTree(visitDB , true);
							
							
							
							
							}
							
							
							
							setVisible(false);
							
					   }
					
					}
				});
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnSave.setBounds(138, 322, 89, 23);
				add(btnSave);
				
				JButton btnNewButton = new JButton("Cancel");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
					}
				});
				btnNewButton.setBounds(280, 322, 89, 23);
				add(btnNewButton);
				
				error_lbl = new JLabel("");
				 error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
					error_lbl.setForeground(Color.RED);
					error_lbl.setBounds(107, 94, 269, 27);
				
				add(error_lbl);
				
				
			

			
		}

		
	}
	
	
