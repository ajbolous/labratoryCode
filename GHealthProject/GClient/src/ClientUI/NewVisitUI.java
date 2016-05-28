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
	public NewVisitUI(Visit visit) {
				
				
				super ();
				setBorder(new TitledBorder(null, "New Visit", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLACK));
				setBackground(UIManager.getColor("Panel.background"));
				setBounds(new Rectangle(283, 143, 122, 144));
				setLayout(null);
				
				textField_1 = new JTextField(DateTime.getDateString(visit.getVisitDate()));
				textField_1.setBounds(82, 52, 155, 20);
				textField_1.setBackground(new Color(255, 255, 255));
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				add(textField_1);
				
				JLabel lblDate = new JLabel("Date :");
				lblDate.setBounds(10, 54, 46, 14);
				lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(lblDate);
				
				JLabel lblComments = new JLabel("Comments : ");
				lblComments.setBounds(10, 122, 104, 20);
				lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
				add(lblComments);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(82, 108, 328, 73);
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
							error_lbl.setText("*Please enter comments");
						
						else {
							visit.setComments(textArea.getText());
							
							removeAll();
							revalidate();
							updateUI();
						
							JLabel msg = new JLabel(" ");
							if (visit.getTreatment().isEndFlag()){
								msg.setText("you canit add visits and Examibations to Treatment"+visit.getTreatment().getTid()+
										visit.getTreatment().gettType()+"\nEnd Date :  "+DateTime.getDateString(visit.getTreatment().getEnd()));
								msg.setBackground(Color.RED);
							}
							else{
								mrctrl.saveVisit(visit);
							msg.setText(" *Treatment saved successfully");
							msg.setBackground(Color.BLUE);
							
							}
							
							 msg.setFont(new Font("Tahoma", Font.PLAIN, 13));
							 
							msg.setBounds(100, 86, 269, 27);
							add(msg);
							
							//setVisible(false);
							
					   }
					
					}
				});
				btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnSave.setBounds(117, 218, 89, 23);
				add(btnSave);
				
				JButton btnNewButton = new JButton("Cancel");
				btnNewButton.setFont(UIManager.getFont("Button.font"));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						
					}
				});
				btnNewButton.setBounds(270, 218, 89, 23);
				add(btnNewButton);
				
				error_lbl = new JLabel("");
				 error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
					error_lbl.setForeground(Color.RED);
					error_lbl.setBounds(82, 83, 269, 27);
				
				add(error_lbl);
				
				
			

			
		}

		
	}
	
	
