package ClientUI;

	import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Examination;
import models.Visit;

	import java.awt.Panel;
import java.awt.Rectangle;

	import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

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
import javax.swing.UIManager;
import javax.swing.JTextPane;

	public class ExaminationPanel  extends JPanel {
		private JTextField textField_1;
		private JTextField textField_3;
		private JTextField textField_2;
		String str = new String();
		private JTextField textField;

		/**
		 * Create the panel.
		 */
		public ExaminationPanel(Examination ex) {
			super();
			setBackground(UIManager.getColor("Button.light"));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			
			textField_1 = new JTextField(DateTime.getDateString(ex.getExaminationDate()));
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(137, 38, 281, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(30, 40, 46, 14);
			add(lblDate);
			
			JLabel lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblComments.setBounds(30, 131, 99, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(137, 128, 281, 47);
			add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane.setViewportView(textArea);
			
			JLabel lblDoctorname = new JLabel("Doctor : ");
			lblDoctorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDoctorname.setBounds(30, 69, 64, 21);
			add(lblDoctorname);
			
			textField_3 = new JTextField(ex.getTreatment().getDoctor().getFirstName()+(ex.getTreatment().getDoctor().getLastName()));
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_3.setBackground(Color.WHITE);
			textField_3.setEditable(false);
			textField_3.setBounds(137, 69, 281, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Type :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(30, 101, 56, 20);
			add(lblNewLabel);
			
			textField_2 = new JTextField(ex.getEType());
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_2.setBackground(Color.WHITE);
			textField_2.setEditable(false);
			textField_2.setBounds(137, 100, 281, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDate_1 = new JLabel("Results:");
			lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate_1.setBounds(30, 189, 79, 14);
			add(lblDate_1);
			
			JLabel lblFiles = new JLabel("Files:");
			lblFiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFiles.setBounds(30, 247, 79, 14);
			add(lblFiles);
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBounds(137, 244, 281, 20);
			add(textField);
			
			JLabel label = new JLabel("Referral Information");
			label.setForeground(new Color(30, 144, 255));
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBackground(Color.LIGHT_GRAY);
			label.setBounds(10, 11, 149, 13);
			add(label);
			
			JLabel lblResults = new JLabel("Results");
			lblResults.setForeground(new Color(30, 144, 255));
			lblResults.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblResults.setBackground(Color.LIGHT_GRAY);
			lblResults.setBounds(10, 171, 69, 13);
			add(lblResults);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setBounds(137, 186, 281, 47);
			add(scrollPane_1);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			scrollPane_1.setViewportView(textArea_1);
			
			
			
		
			
		}
	}

