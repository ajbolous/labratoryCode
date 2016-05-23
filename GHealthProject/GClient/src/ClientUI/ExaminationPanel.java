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

	public class ExaminationPanel  extends JPanel {
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_3;
		private JTextField textField_2;
		String str = new String();
		JTextArea textArea_1 = new JTextArea();
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;

		/**
		 * Create the panel.
		 */
		public ExaminationPanel(Examination ex) {
			super();
			setBackground(new Color(255, 255, 255));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			textField = new JTextField(ex.getEid());
			textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
			textField.setBackground(Color.WHITE);
			textField.setEditable(false);
			textField.setBounds(134, 38, 104, 20);
			add(textField);
			textField.setColumns(10);
			
			
			textField_1 = new JTextField(DateTime.getDateString(ex.getExaminationDate()));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(357, 38, 153, 20);
			textField_1.setColumns(10);
			add(textField_1);

			
			
			
			JLabel lblVisitId = new JLabel("ExaminationID :");
			lblVisitId.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblVisitId.setBounds(9, 38, 143, 20);
			add(lblVisitId);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDate.setBounds(301, 40, 46, 14);
			add(lblDate);
			
			JLabel lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblComments.setBounds(9, 169, 110, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(182, 165, 328, 44);
			add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			textArea.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent arg0) {
				}
				public void inputMethodTextChanged(InputMethodEvent arg0) {
					str= textArea.getText();
					textArea_1.setText(str);
				}
			});
			
			scrollPane.setViewportView(textArea);
			
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
			lblDoctorname.setBounds(9, 80, 110, 21);
			add(lblDoctorname);
			
			textField_3 = new JTextField(ex.getTreatment().getDoctor().getFirstName()+(ex.getTreatment().getDoctor().getLastName()));
			textField_3.setBackground(Color.WHITE);
			textField_3.setEditable(false);
			textField_3.setBounds(182, 81, 197, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Examination Type :");
			lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblNewLabel.setBounds(9, 126, 179, 20);
			add(lblNewLabel);
			
			textField_2 = new JTextField(ex.getEType());
			textField_2.setBackground(Color.WHITE);
			textField_2.setEditable(false);
			textField_2.setBounds(182, 127, 197, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(153, 153, 153));
			panel_1.setBounds(0, 221, 520, 27);
			add(panel_1);
			
			JLabel lblNewLabel_1 = new JLabel("Examination Result");
			lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Examination Result :");
			lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblNewLabel_2.setForeground(new Color(0, 0, 0));
			lblNewLabel_2.setBounds(9, 400, 163, 20);
			add(lblNewLabel_2);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(182, 398, 328, 50);
			add(scrollPane_1);
			
			
			textArea_1.setEditable(false);
			scrollPane_1.setViewportView(textArea_1);
			
			JLabel lblPhotolink = new JLabel("PhotoLink :");
			lblPhotolink.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblPhotolink.setBounds(9, 481, 110, 20);
			add(lblPhotolink);
			
			JLabel lblLabortianName = new JLabel("Labortian Name : ");
			lblLabortianName.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblLabortianName.setBounds(9, 304, 143, 20);
			add(lblLabortianName);
			
			textField_4 = new JTextField();
			textField_4.setBounds(182, 305, 197, 20);
			add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblClincsName = new JLabel("Clincs Name : ");
			lblClincsName.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblClincsName.setBounds(10, 354, 133, 14);
			add(lblClincsName);
			
			textField_5 = new JTextField();
			textField_5.setBounds(182, 352, 197, 20);
			add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblDate_1 = new JLabel("Date : ");
			lblDate_1.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDate_1.setBounds(9, 269, 79, 14);
			add(lblDate_1);
			
			textField_6 = new JTextField();
			textField_6.setBounds(182, 267, 197, 20);
			add(textField_6);
			textField_6.setColumns(10);
			
			
			
		
			
		}
	}

