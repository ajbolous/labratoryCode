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
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

	public class ExaminationPanel  extends JPanel {
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
			setBorder(new TitledBorder(null, "Referral Information", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
			setBackground(UIManager.getColor("Panel.background"));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			
			textField_1 = new JTextField(DateTime.getDateString(ex.getExaminationDate()));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(130, 38, 197, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(9, 40, 46, 14);
			add(lblDate);
			
			JLabel lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblComments.setBounds(30, 131, 99, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(130, 164, 328, 44);
			add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent arg0) {
				}
				public void inputMethodTextChanged(InputMethodEvent arg0) {
					str= textArea.getText();
					textArea_1.setText(str);
				}
			});
			
			scrollPane.setViewportView(textArea);
			
			JLabel lblDoctorname = new JLabel("DoctorName : ");
			lblDoctorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDoctorname.setBounds(9, 80, 110, 21);
			add(lblDoctorname);
			
			textField_3 = new JTextField(ex.getTreatment().getDoctor().getFirstName()+(ex.getTreatment().getDoctor().getLastName()));
			textField_3.setEditable(false);
			textField_3.setBounds(130, 81, 197, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Examination Type :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(9, 126, 110, 20);
			add(lblNewLabel);
			
			textField_2 = new JTextField(ex.getEType());
			
			textField_2.setEditable(false);
			textField_2.setBounds(130, 127, 197, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Examination Result", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(0, 235, 521, 329);
			add(panel);
			panel.setLayout(null);
			
			textField_5 = new JTextField();
			textField_5.setBounds(131, 119, 197, 20);
			panel.add(textField_5);
			
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(130, 169, 328, 50);
			panel.add(scrollPane_1);
			
			
			textArea_1.setEditable(false);
			scrollPane_1.setViewportView(textArea_1);
			
			JLabel lblPhotolink = new JLabel("PhotoLink :");
			lblPhotolink.setBounds(10, 255, 63, 16);
			panel.add(lblPhotolink);
			lblPhotolink.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblNewLabel_2 = new JLabel("Examination Result :");
			lblNewLabel_2.setBounds(10, 189, 110, 15);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setForeground(new Color(0, 0, 0));
			
			JLabel lblClincsName = new JLabel("Clincs Name : ");
			lblClincsName.setBounds(10, 119, 133, 14);
			panel.add(lblClincsName);
			lblClincsName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblLabortianName = new JLabel("Labortian Name : ");
			lblLabortianName.setBounds(10, 69, 143, 20);
			panel.add(lblLabortianName);
			lblLabortianName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			textField_4 = new JTextField();
			textField_4.setBounds(130, 70, 197, 20);
			panel.add(textField_4);
			
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			
			JLabel lblDate_1 = new JLabel("Date : ");
			lblDate_1.setBounds(10, 28, 79, 14);
			panel.add(lblDate_1);
			lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			textField_6 = new JTextField();
			textField_6.setBounds(129, 27, 197, 20);
			panel.add(textField_6);
			
			textField_6.setEditable(false);
			textField_6.setColumns(10);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setBounds(350, 295, 89, 23);
			panel.add(btnCancel);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeAll();
	                revalidate();
	                repaint();
				}
			});
			
			
			
		
			
		}
	}

