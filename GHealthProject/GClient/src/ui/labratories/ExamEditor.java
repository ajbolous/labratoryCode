package ui.labratories;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFileChooser;

import Client.Application;
import Client.Resources;
import Controllers.ExaminationController;
import models.Examination;
import models.Labratorian;
import ui.utils.Messages;

import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;
import java.text.ParseException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.io.File;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamEditor {

	private JFrame labratoryUI;
	private Date creationDate = null;
	private Examination exam;

	public ExamEditor(Examination ex) {
		exam = ex;
		initialize();
		labratoryUI.setVisible(true);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Labratorian labratorian = (Labratorian) Application.user;
		labratoryUI = new JFrame();
		labratoryUI.setTitle("<Frame name> - GHealth");
		labratoryUI.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		labratoryUI.setIconImage(icon);
		labratoryUI.setForeground(Color.BLACK);
		labratoryUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		labratoryUI.setBackground(Color.WHITE);
		labratoryUI.getContentPane().setBackground(Color.WHITE);
		labratoryUI.getContentPane().setLayout(null);

		JLabel label_2 = new JLabel("<dynamic> <dynamic>");
		label_2.setBounds(278, 44, 240, 21);
		labratoryUI.getContentPane().add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			creationDate = Utils.DateTime.currentDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_2.setText(creationDate.toString());

		JLabel logo = new JLabel("Examinations");
		logo.setBounds(0, 0, 378, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		labratoryUI.getContentPane().add(logo);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 66, 518, 157);
		labratoryUI.getContentPane().add(panel);

		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatient.setBounds(10, 11, 80, 21);
		panel.add(lblPatient);

		JLabel label_1 = new JLabel("<dynamic> <dynamic>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(106, 11, 207, 21);
		panel.add(label_1);

		label_1.setText(new String(labratorian.getFirstName() + " " + labratorian.getLastName()));

		JLabel label_3 = new JLabel((String) null);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(223, 11, 90, 21);
		panel.add(label_3);

		JLabel lblExaminationType = new JLabel("Examination Type:" + exam.geteType());
		lblExaminationType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExaminationType.setBounds(10, 43, 498, 21);
		panel.add(lblExaminationType);

		JLabel lblComments = new JLabel("Doctor comments: ");
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComments.setBounds(10, 75, 168, 21);
		panel.add(lblComments);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(143, 75, 319, 67);
		panel.add(scrollPane_1);
		
		JTextPane txtDoctor = new JTextPane();
		txtDoctor.setEditable(false);
		scrollPane_1.setViewportView(txtDoctor);
		txtDoctor.setText(exam.getComments());
		
		JLabel lblResults = new JLabel("Result comments:");
		lblResults.setBounds(54, 226, 128, 14);
		labratoryUI.getContentPane().add(lblResults);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(78, 251, 385, 75);
		labratoryUI.getContentPane().add(scrollPane);

		JTextPane txtResult = new JTextPane();
		scrollPane.setViewportView(txtResult);
		txtResult.setText(exam.getResults());
		
		JLabel lblAttachedImage = new JLabel("Attached Image");
		lblAttachedImage.setBounds(54, 337, 128, 14);
		labratoryUI.getContentPane().add(lblAttachedImage);

		JButton btnAddImage = new JButton("Add Image");

		ImageIcon image = (ImageIcon) ExaminationController.getImage(exam);
		if (image != null)
			btnAddImage.setIcon(image);

		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(labratoryUI);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					exam.setFile(selectedFile.getName());
					ImageIcon ic = Resources.getImageFromPath(selectedFile.getPath());
					btnAddImage.setIcon(ic);
				}
			}
		});
		btnAddImage.setBounds(78, 352, 385, 170);
		labratoryUI.getContentPane().add(btnAddImage);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				exam.setResults(txtResult.getText());
				exam.setExaminationDate(creationDate);
				ExaminationController.saveExamination(exam, (ImageIcon)btnAddImage.getIcon());
				Messages.successMessage("Examination results added", "Examinations", null);
				
				labratoryUI.dispose();
			}
		});
		btnSave.setBounds(78, 533, 169, 23);
		labratoryUI.getContentPane().add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(294, 533, 169, 23);
		labratoryUI.getContentPane().add(btnCancel);

		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		labratoryUI.setBounds(100, 100, 523, 596);
		labratoryUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
