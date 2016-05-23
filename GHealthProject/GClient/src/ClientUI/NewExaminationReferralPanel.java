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
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class NewExaminationReferralPanel  extends JPanel {
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_3;
		String str = new String();

		/**
		 * Create the panel.
		 */
		public NewExaminationReferralPanel(Examination ex) {
			super();
			setBackground(new Color(255, 255, 255));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			textField = new JTextField(ex.getEid());
			textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			textField.setBackground(Color.WHITE);
			textField.setEditable(false);
			textField.setBounds(155, 77, 104, 20);
			add(textField);
			textField.setColumns(10);
			
			
			textField_1 = new JTextField(DateTime.getDateString(ex.getExaminationDate()));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(357, 77, 153, 20);
			textField_1.setColumns(10);
			add(textField_1);

			
			
			
			JLabel lblVisitId = new JLabel("ExaminationID :");
			lblVisitId.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblVisitId.setBounds(9, 76, 143, 20);
			add(lblVisitId);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDate.setBounds(304, 79, 46, 14);
			add(lblDate);
			
			JLabel lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblComments.setBounds(9, 261, 110, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(167, 257, 328, 44);
			add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			textArea.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent arg0) {
				}
				public void inputMethodTextChanged(InputMethodEvent arg0) {
					str= textArea.getText();
				}
			});
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 153, 153));
			panel.setBounds(0, 0, 520, 27);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblVisitDetails = new JLabel("Referral Information");
			lblVisitDetails.setBackground(Color.LIGHT_GRAY);
			lblVisitDetails.setBounds(0, 0, 500, 27);
			lblVisitDetails.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lblVisitDetails);
			lblVisitDetails.setFont(new Font("Arial Black", Font.BOLD, 12));
			
			JLabel lblDoctorname = new JLabel("DoctorName : ");
			lblDoctorname.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDoctorname.setBounds(9, 120, 110, 21);
			add(lblDoctorname);
			
			textField_3 = new JTextField(ex.getTreatment().getDoctor().getFirstName()+(ex.getTreatment().getDoctor().getLastName()));
			textField_3.setBackground(Color.WHITE);
			textField_3.setEditable(false);
			textField_3.setBounds(155, 121, 197, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Examination Type :");
			lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblNewLabel.setBounds(9, 188, 179, 20);
			add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBackground(SystemColor.window);
			comboBox.setBounds(167, 186, 181, 27);
			add(comboBox);
			
			
			
		
			
		}
	}

