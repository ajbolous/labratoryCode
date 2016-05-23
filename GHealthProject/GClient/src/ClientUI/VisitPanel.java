package ClientUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Visit;

import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import Utils.DateTime;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class VisitPanel extends VPanel {
	

	/**
	 * Create the panel.
	 */
	public VisitPanel(Visit visit) {
		super(visit);
		textArea.setEditable(false);
	}
}
