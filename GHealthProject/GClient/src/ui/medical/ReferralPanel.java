package ui.medical;

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

	public class ReferralPanel  extends JPanel {
		private JTextField textField_1;
		private JTextField textField_3;
		private JTextField textField_2;
		private String str = new String();
		private JLabel lblDate;
		private JLabel lblComments;
		private JLabel lblDoctorname;
		private JTextArea textArea;
		private JLabel lblNewLabel;
		public JButton btnCancel;

		/**
		 * Create the JScrollPane.
		 */
		public ReferralPanel(Examination ex) {
			super();
			setBorder(new TitledBorder(null, "Referral Information", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
			setBackground(UIManager.getColor("Panel.background"));
			setBounds(283, 143, 471, 322);
			setLayout(null);
		
				
			
			 lblDate = new JLabel("Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(9, 40, 46, 14);
			add(lblDate);
			
			 lblComments = new JLabel("Comments : ");
			lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblComments.setBounds(9, 169, 110, 14);
			add(lblComments);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(130, 164, 328, 108);
			add(scrollPane);
			
		    textArea = new JTextArea();
		    textArea.setEditable(false);
			
			
			scrollPane.setViewportView(textArea);
			
			lblDoctorname = new JLabel("DoctorName : ");
			lblDoctorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDoctorname.setBounds(9, 80, 110, 21);
			add(lblDoctorname);
			
			textField_3 = new JTextField();
			textField_3.setBackground(Color.WHITE);
			textField_3.setEditable(false);
			textField_3.setBounds(130, 81, 197, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			lblNewLabel = new JLabel("Examination Type :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(9, 126, 110, 20);
			add(lblNewLabel);
			
			textField_2 = new JTextField();
			textField_2.setBackground(Color.WHITE);
			
			textField_2.setEditable(false);
			textField_2.setBounds(130, 127, 197, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			
			textField_1 = new JTextField();
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setEditable(false);
			textField_1.setBounds(130, 38, 197, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			textField_1.setText(DateTime.getDateString(ex.getReferralDate()));
			
			textField_2.setText(ex.geteType());
			textField_3.setText(""+ex.getTreatment().getDoctor().getFirstName() +" "+(ex.getTreatment().getDoctor().getLastName()));
			textArea.setText(ex.getComments());
			
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancel.setBounds(356, 288, 89, 23);
			add(btnCancel);
			
			
			
			
		}
			
			
			
		
	}

