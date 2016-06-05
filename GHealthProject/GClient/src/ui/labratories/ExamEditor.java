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
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;
import java.text.ParseException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamEditor {

	private JFrame labratoryUI;

	private Examination exam;
	public ExamEditor(Examination ex) {
		initialize();
		exam = ex;
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

		JLabel logo = new JLabel("Examinations");
		logo.setBounds(0, 0, 645, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		labratoryUI.getContentPane().add(logo);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 66, 584, 157);
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

		JLabel label_2 = new JLabel("<dynamic> <dynamic>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(338, 11, 239, 21);
		panel.add(label_2);
		try {
			label_2.setText(new String("Tody:" + Utils.DateTime.currentDate().toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}


		
		JLabel lblExaminationType = new JLabel("Examination Type:");
		lblExaminationType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExaminationType.setBounds(10, 43, 452, 21);
		panel.add(lblExaminationType);

		JLabel lblComments = new JLabel("Doctor comments:");
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComments.setBounds(10, 75, 168, 21);
		panel.add(lblComments);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(161, 79, 416, 54);
		panel.add(scrollPane_1);

		JLabel lblResults = new JLabel("Result comments:");
		lblResults.setBounds(10, 226, 128, 14);
		labratoryUI.getContentPane().add(lblResults);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(34, 251, 297, 156);
		labratoryUI.getContentPane().add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JLabel lblAttachedImage = new JLabel("Attached Image");
		lblAttachedImage.setBounds(339, 229, 128, 14);
		labratoryUI.getContentPane().add(lblAttachedImage);
		
		JButton btnAddImage = new JButton("Add Image");
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

				    ExaminationController.saveExamination(exam, ic);
				}
			}
		});
		btnAddImage.setBounds(341, 251, 237, 149);
		labratoryUI.getContentPane().add(btnAddImage);

		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		labratoryUI.setBounds(100, 100, 594, 440);
		labratoryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
