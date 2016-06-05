package ui.medical;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Clinic;
import models.Examination;
import ui.utils.Messages;
import ui.utils.UITests;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Controllers.MedicalRecordController;
import Utils.DateTime;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class NewExaminationReferralPanel extends JPanel {
	private JTextField textField_1;
	private JLabel error_lbl;

	private String exType;

	/**
	 * Create the panel.
	 * 
	 * @param doctorMedicalRecordUI
	 */
	public NewExaminationReferralPanel(Examination ex,
			DoctorMedicalRecordUI doctorMedicalRecordUI) {
		super();
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"New Referral", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		setBackground(UIManager.getColor("Panel.background"));
		setBounds(new Rectangle(283, 143, 122, 144));
		setLayout(null);

		textField_1 = new JTextField(DateTime.getDateString(ex
				.getReferralDate())
				+ " "
				+ DateTime.getTimeString(ex.getReferralDate()));
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
		lblComments.setBounds(9, 252, 121, 14);
		add(lblComments);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(140, 247, 308, 68);
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblNewLabel = new JLabel("Examination Type :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(9, 115, 121, 20);
		add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Blood",
				"Urine", "CT", "ECG", "X-Ray", "Eye", "CAT" }));
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exType = (String) comboBox.getSelectedItem();

			}
		});

		comboBox.setBounds(140, 113, 197, 27);
		add(comboBox);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comment = textArea.getText();

				error_lbl.setText("");
				if (UITests.notEmpty(comment) == false)
					error_lbl.setText("*Please enter comment");

				else {
					ex.setComments(comment);
					ex.seteType(exType);

					if (ex.getTreatment().isEndFlag()) {

						Messages.warningMessage(
								"cannot add visits or Examibations to Treatment"
										+ ex.getTreatment().getTid() + "-"
										+ ex.getTreatment().gettType(),
								"warning",
								doctorMedicalRecordUI.DoctorMedicalRecord);

					} else {

						MedicalRecordController.saveReferral(ex);
						Messages.successMessage(
								"Referral was added successfully  ", "Success",
								doctorMedicalRecordUI.DoctorMedicalRecord);

					}

					setVisible(false);
				}
			}
		});
		btnSave.setBounds(248, 365, 89, 23);
		add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(359, 365, 89, 23);
		add(btnCancel);

		error_lbl = new JLabel("");
		error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		error_lbl.setForeground(Color.RED);
		error_lbl.setBounds(140, 219, 269, 27);

		add(error_lbl);

		JLabel lblLabortary = new JLabel("Labratory :");
		lblLabortary.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLabortary.setBounds(9, 180, 121, 20);
		add(lblLabortary);

		JComboBox<Clinic> comboBox_1 = new JComboBox();

		ArrayList<Clinic> labList = (ArrayList<Clinic>) MedicalRecordController
				.getAllLabratories();
		for (Clinic clinic : labList)
			comboBox_1.addItem(clinic);

		// String[] lab=new String[labList.size()];

		// lab=labList.toArray(lab);
		// comboBox_1.setModel(new DefaultComboBoxModel(labList));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinic clinic = (Clinic) comboBox_1.getSelectedItem();
				ex.setClinic(clinic);
			}
		});
		comboBox_1.setBounds(140, 180, 197, 31);
		add(comboBox_1);

	}
}
