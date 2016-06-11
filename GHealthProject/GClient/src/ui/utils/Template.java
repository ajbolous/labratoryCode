package ui.utils;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Resources;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Template {

	private JFrame template;

	public Template() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		template = new JFrame();
		template.setTitle("<Frame name> - GHealth");
		template.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		template.setIconImage(icon);
		template.setForeground(Color.BLACK);
		template.setFont(new Font("Dialog", Font.PLAIN, 16));
		template.setBackground(Color.WHITE);
		template.getContentPane().setBackground(Color.WHITE);
		template.getContentPane().setLayout(null);

		JLabel logo = new JLabel("GHealth - <Frame Name>");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		template.getContentPane().add(logo);
		template.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		template.setBounds(100, 100, 501, 496);
		template.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
