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

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewVisitUI  {
	
	private JFrame NewVisit;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea = new JTextArea();
	
	MedicalRecordController mrctrl = new MedicalRecordController();
	// TODO Auto-generated constructor stub
	public NewVisitUI(Visit visit) {
				initialize(visit);
				NewVisit.setSize(450, 301);
				NewVisit.setLocationRelativeTo(null);
				NewVisit.setVisible(true);
			}

			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize(Visit visit) {
				Resources res = new Resources();
				NewVisit = new JFrame();
				NewVisit.setTitle("<New Visit> - GHealth");
				NewVisit.setResizable(false);
				Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
				NewVisit.setIconImage(icon);
				NewVisit.setForeground(Color.BLACK);
				NewVisit.setFont(new Font("Dialog", Font.PLAIN, 16));
				NewVisit.setBackground(Color.WHITE);
				NewVisit.getContentPane().setBackground(Color.WHITE);
				NewVisit.getContentPane().setLayout(null);
				NewVisit.setLocationRelativeTo(null);
				
				textField = new JTextField();
				textField.setBounds(100, 52, 91, 20);
				textField.setBackground(new Color(255, 255, 255));
				textField.setEditable(false);
				NewVisit.getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(273, 52, 155, 20);
				textField_1.setBackground(new Color(255, 255, 255));
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				NewVisit.getContentPane().add(textField_1);
				
				JLabel lblVisitId = new JLabel("VisitID :");
				lblVisitId.setBounds(10, 54, 80, 14);
				lblVisitId.setFont(new Font("Arial Black", Font.BOLD, 12));
				NewVisit.getContentPane().add(lblVisitId);
				
				JLabel lblDate = new JLabel("Date :");
				lblDate.setBounds(217, 54, 46, 14);
				lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
				NewVisit.getContentPane().add(lblDate);
				
				JLabel lblComments = new JLabel("Comments : ");
				lblComments.setBounds(10, 122, 104, 20);
				lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
				NewVisit.getContentPane().add(lblComments);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(100, 109, 328, 73);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				NewVisit.getContentPane().add(scrollPane);
				
				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 444, 27);
				panel.setBackground(new Color(153, 153, 153));
				NewVisit.getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblVisitDetails = new JLabel("New Visit ");
				lblVisitDetails.setBackground(Color.CYAN);
				lblVisitDetails.setBounds(0, 0, 444, 27);
				lblVisitDetails.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblVisitDetails);
				lblVisitDetails.setFont(new Font("Arial Black", Font.BOLD, 12));
				
				JButton btnSave = new JButton("save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mrctrl.saveVisit(visit,textArea.getText());
					}
				});
				btnSave.setFont(new Font("Arial", Font.BOLD, 12));
				btnSave.setBounds(230, 237, 89, 23);
				NewVisit.getContentPane().add(btnSave);
				
				JButton btnNewButton = new JButton("cancel");
				btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NewVisit.setVisible(false);
						
					}
				});
				btnNewButton.setBounds(345, 237, 89, 23);
				NewVisit.getContentPane().add(btnNewButton);
				
				
			

			
		}

		
	}
	
	
