package ui.medical;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Application;
import Client.Resources;
import Controllers.AppointmentsController;
import Controllers.MedicalRecordController;
import Controllers.PatientsController;
import models.Doctor;
import models.Examination;
import models.Patient;
import models.Treatment;
import models.Visit;
import ui.appointments.RequestInformationUI;
import ui.main.ClientUI;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class DoctorMedicalRecordUI {

	public JFrame DoctorMedicalRecord;

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTree tree;
	private Doctor d;
	private Treatment t;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private DoctorMedicalRecordUI doctorMedicalRecordUI;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode rootNode;

	public DoctorMedicalRecordUI(Patient p) throws ParseException {
		initialize(p);
		doctorMedicalRecordUI = this;
		DoctorMedicalRecord.setSize(1056, 816);
		DoctorMedicalRecord.setLocationRelativeTo(null);
		DoctorMedicalRecord.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize(Patient p) throws ParseException {
		DoctorMedicalRecord = new JFrame();
		DoctorMedicalRecord.setTitle("<Doctor Medical Record> - GHealth");
		DoctorMedicalRecord.setResizable(false);
		Image icon = Resources.getImage("icon.png");
		DoctorMedicalRecord.setIconImage(icon);
		DoctorMedicalRecord.setForeground(Color.BLACK);
		DoctorMedicalRecord.setFont(new Font("Dialog", Font.PLAIN, 16));
		DoctorMedicalRecord.setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setLayout(null);

		JLabel logo = new JLabel("Medical Record");
		logo.setBounds(0, 0, 847, 53);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		DoctorMedicalRecord.getContentPane().add(logo);
		DoctorMedicalRecord.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { logo }));
		DoctorMedicalRecord.setBounds(100, 100, 863, 595);
		DoctorMedicalRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 1024, 78);
		DoctorMedicalRecord.getContentPane().add(panel);
		panel.setLayout(null);

		btnNewButton_1 = new JButton("Add Referral");
		btnNewButton = new JButton("Add Visit");
		scrollPane_1 = new JScrollPane();
		panel_1 = new JPanel();

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 21);
		panel.add(lblNewLabel);

		JTextField cName = new JTextField(p.getFirstName() + "  "
				+ p.getLastName());
		cName.setBackground(Color.WHITE);
		cName.setEditable(false);
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 195, 21);
		panel.add(cName);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(520, 11, 52, 21);
		panel.add(lblPhone);

		JTextField label_1 = new JTextField(p.getPhone());
		label_1.setBackground(Color.WHITE);
		label_1.setEditable(false);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(577, 11, 119, 21);
		panel.add(label_1);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(308, 45, 40, 21);
		panel.add(lblAge);

		int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

		String age = (String.format("%3.2f",
				(float) calculateAge2(p.getBirthDate())));
		JTextField lblAge_2 = new JTextField(age);
		lblAge_2.setBackground(Color.WHITE);
		lblAge_2.setEditable(false);
		lblAge_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge_2.setBounds(345, 45, 67, 21);
		panel.add(lblAge_2);

		JLabel lblWeight = new JLabel("Gender:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(714, 11, 62, 21);
		panel.add(lblWeight);

		JTextField label = new JTextField(p.getGender());
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(786, 10, 72, 23);
		panel.add(label);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeight.setBounds(10, 45, 67, 21);
		panel.add(lblHeight);

		JTextField label_2 = new JTextField(Float.toString(p.getHeight()));
		label_2.setBackground(Color.WHITE);
		label_2.setEditable(false);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(71, 44, 52, 22);
		panel.add(label_2);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(278, 14, 33, 14);
		panel.add(lblId);

		JTextField label_3 = new JTextField(p.getSid());
		label_3.setBackground(Color.WHITE);
		label_3.setEditable(false);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(308, 11, 195, 21);
		panel.add(label_3);

		JLabel lblWeight_1 = new JLabel("Weight:");
		lblWeight_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight_1.setBounds(146, 43, 67, 21);
		panel.add(lblWeight_1);

		JTextField label_5 = new JTextField(Float.toString(p.getWeight()));
		label_5.setBackground(Color.WHITE);
		label_5.setEditable(false);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(206, 45, 83, 21);
		panel.add(label_5);

		JButton btnUpdateInformation = new JButton(" Patient Information");
		btnUpdateInformation.setBounds(467, 45, 151, 23);
		panel.add(btnUpdateInformation);
		btnUpdateInformation.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnReguestInformationFrom = new JButton(
				"Reguest Information From HMO");
		btnReguestInformationFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableAddVisitOrReferral(false);
				new RequestInformationUI(p);

			}
		});
		btnReguestInformationFrom.setBounds(628, 45, 230, 23);
		panel.add(btnReguestInformationFrom);
		btnReguestInformationFrom.setFont(new Font("Arial", Font.BOLD, 12));

		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		DoctorMedicalRecord.getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(232, 156, 571, 32);
		panel_1.setLayout(null);
		btnNewButton.setToolTipText("You must choose Treatment to add Visit ");

		btnNewButton.setEnabled(false);

		panel_1.add(btnNewButton);
		btnNewButton_1
				.setToolTipText("You must choose Treatment to add Referral");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// enableAddVisitOrReferral(false);
				NewExaminationReferralPanel exPanel = new NewExaminationReferralPanel(
						MedicalRecordController.getNewReferral(t),
						doctorMedicalRecordUI);
				scrollPane_1.setViewportView(exPanel);

			}
		});

		btnNewButton_1.setEnabled(false);
		panel_1.add(btnNewButton_1);

		btnNewButton.setBounds(175, 6, 114, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// enableAddVisitOrReferral(false);
					NewVisitUI vPanel = new NewVisitUI(MedicalRecordController
							.getNewVisit(t), doctorMedicalRecordUI);
					scrollPane_1.setViewportView(vPanel);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnNewButton_1.setBounds(323, 6, 104, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnNewTreatment = new JButton("New Treatment");
		btnNewTreatment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewTreatment.setBounds(8, 7, 134, 22);
		panel_1.add(btnNewTreatment);

		JButton btnCancel = new JButton("cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(461, 7, 89, 22);
		panel_1.add(btnCancel);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setBounds(24, 199, 1000, 565);
		DoctorMedicalRecord.getContentPane().add(splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));

		tree = new JTree();
		scrollPane.setViewportView(tree);

		tree.setShowsRootHandles(false);
		tree.putClientProperty("JTree.lineStyle", "Horizontal");

		rootNode = new DefaultMutableTreeNode("");

		DefaultMutableTreeNode otherNodes = new DefaultMutableTreeNode(
				"Other treatments");
		DefaultMutableTreeNode doctorNodes = new DefaultMutableTreeNode(
				"Doctor treatments");

		d = (Doctor) Application.user;
		String speciality[] = AppointmentsController.getSpecialties();

		for (String spec : speciality) {
			if (!spec.equals("")) {
				DefaultMutableTreeNode node_S = new DefaultMutableTreeNode(spec);
				DefaultMutableTreeNode node_t;
				Iterator<Treatment> treatment = p.getMedicalRecord()
						.getTreatments().iterator();

				while (treatment.hasNext()) {
					DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode(
							" *Visits");
					DefaultMutableTreeNode node_3 = new DefaultMutableTreeNode(
							" *Examinations");

					Treatment t = treatment.next();

					if (t.getDoctor().getSpeciality().equals(spec)) {

						node_t = new DefaultMutableTreeNode(t);

						Iterator<Visit> visit = t.getVisits().iterator();
						while (visit.hasNext()) {
							Visit v = visit.next();
							node_2.add(new DefaultMutableTreeNode(v));

						}

						Iterator<Examination> examination = t.getExamination()
								.iterator();
						while (examination.hasNext()) {
							Examination ex = examination.next();
							node_3.add(new DefaultMutableTreeNode(ex));
						}

						node_t.add(node_2);
						node_t.add(node_3);
						if (t.getDoctor().getSid().equals(d.getSid()))
							doctorNodes.add(node_t);
						else
							node_S.add(node_t);

					}

				}

				otherNodes.add(node_S);
			}
		}
		rootNode.add(doctorNodes);
		rootNode.add(otherNodes);
		treeModel = new DefaultTreeModel(rootNode);
		tree.setModel(treeModel);
		tree.setRootVisible(false);

		splitPane.setRightComponent(scrollPane_1);
		scrollPane_1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBackground(Color.WHITE);

		tree.setShowsRootHandles(true);
		tree.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
								.getLastSelectedPathComponent();
						if (node != null) {
							Object obj = node.getUserObject();

							if (obj.getClass() == Visit.class) {
								Visit v = (Visit) obj;
								t = v.getTreatment();
								VisitPanel vi = new VisitPanel(v);
								scrollPane_1.setViewportView(vi);
								if (t.getDoctor().getSid()
										.equals(Application.user.getSid()))
									enableAddVisitOrReferral(true);
								else
									enableAddVisitOrReferral(false);

							}
							if (obj.getClass() == Treatment.class) {
								t = (Treatment) obj;
								TreatmentPanel tPanel = new TreatmentPanel(
										(Treatment) obj, doctorMedicalRecordUI);
								scrollPane_1.setViewportView(tPanel);
								if (t.getDoctor().getSid()
										.equals(Application.user.getSid()))
									enableAddVisitOrReferral(true);
								else
									enableAddVisitOrReferral(false);
							}

							if (obj.getClass() == Examination.class) {
								Examination ex = (Examination) obj;
								t = ex.getTreatment();
								ExaminationPanel ep;
								ep = new ExaminationPanel(ex);

								scrollPane_1.setViewportView(ep.mainPanel);
								if (t.getDoctor().getSid()
										.equals(Application.user.getSid()))
									enableAddVisitOrReferral(true);
								else
									enableAddVisitOrReferral(false);
							}

						} else
							enableAddVisitOrReferral(false);
					}

				});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorMedicalRecord.setVisible(false);
				DoctorMedicalRecord.dispose();
				new ClientUI();
			}
		});
		btnNewTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Treatment treatment = MedicalRecordController
							.getNewTreatment((Doctor) Application.user,
									p.getMedicalRecord());
					NewTreatmentUI tPanel = new NewTreatmentUI(treatment,
							doctorMedicalRecordUI);
					scrollPane_1.setViewportView(tPanel);
					t = treatment;
					enableAddVisitOrReferral(true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private static double calculateAge2(Date d) {
		return (new Date().getTime() - d.getTime())
				/ (1000 * 60 * 60 * 24 * 365.0);
	}

	public void updateTree(Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (child.getClass() == Visit.class) {

			DefaultMutableTreeNode root = ((DefaultMutableTreeNode) tree
					.getModel().getRoot());
			if ((t.getDoctor().getSid().equals(d.getSid()))) {
				DefaultMutableTreeNode doctorTreatment = (DefaultMutableTreeNode) tree
						.getModel().getChild(root, 0);
				int count1 = tree.getModel().getChildCount(doctorTreatment);

				for (int i1 = 0; i1 < count1; i1++) {

					if (((tree.getModel().getChild(doctorTreatment, i1))
							.toString()).equals((t.toString()))) {
						DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) tree
								.getModel().getChild(doctorTreatment, i1);
						DefaultMutableTreeNode parent = (DefaultMutableTreeNode) tree
								.getModel().getChild(node1, 0);
						treeModel.insertNodeInto(childNode, parent,
								parent.getChildCount());
						// Make sure the user can see the lovely new node.
						if (shouldBeVisible)
							tree.scrollPathToVisible(new TreePath(childNode
									.getPath()));
					}
				}
			}

			else {
				DefaultMutableTreeNode otherTreatment = (DefaultMutableTreeNode) tree
						.getModel().getChild(root, 1);
				int count = tree.getModel().getChildCount(otherTreatment);
				for (int i = 0; i < count; i++) {
					if (((tree.getModel().getChild(otherTreatment, i))
							.toString()).equals(t.getDoctor().getSpeciality())) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
								.getModel().getChild(otherTreatment, i);
						int count1 = tree.getModel().getChildCount(node);

						for (int i1 = 0; i1 < count1; i1++) {

							if (((tree.getModel().getChild(node, i1))
									.toString()).equals(((Visit) child)
									.getTreatment().toString())) {
								DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) tree
										.getModel().getChild(node, i1);
								DefaultMutableTreeNode parent = (DefaultMutableTreeNode) tree
										.getModel().getChild(node1, 0);
								treeModel.insertNodeInto(childNode, parent,
										parent.getChildCount());
								// Make sure the user can see the lovely new
								// node.
								if (shouldBeVisible)
									tree.scrollPathToVisible(new TreePath(
											childNode.getPath()));

							}
						}

					}
				}
			}
		}
		if (child.getClass() == Treatment.class) {

			DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree
					.getModel().getRoot();
			if (((Treatment) child).getDoctor().getSid().equals(d.getSid())) {

				rootNode = (DefaultMutableTreeNode) tree.getModel().getChild(
						root, 0);

				DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode(
						" *Visits");
				DefaultMutableTreeNode node_3 = new DefaultMutableTreeNode(
						" *Examinations");
				childNode.add(node_2);
				childNode.add(node_3);

				// tree.revalidate();
				treeModel.insertNodeInto(childNode, rootNode,
						rootNode.getChildCount());
				// Make sure the user can see the lovely new node.
				if (shouldBeVisible) {
					tree.scrollPathToVisible(new TreePath(childNode.getPath()));
				}
			}

			else {
				rootNode = (DefaultMutableTreeNode) tree.getModel().getChild(
						root, 1);
				int count = tree.getModel().getChildCount(rootNode);
				for (int i = 0; i < count; i++) {

					if (((tree.getModel().getChild(rootNode, i)).toString())
							.equals(t.getDoctor().getSpeciality())) {

						DefaultMutableTreeNode parent = (DefaultMutableTreeNode) tree
								.getModel().getChild(rootNode, i);
						DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode(
								" *Visits");
						DefaultMutableTreeNode node_3 = new DefaultMutableTreeNode(
								" *Examinations");
						childNode.add(node_2);
						childNode.add(node_3);

						// tree.revalidate();
						treeModel.insertNodeInto(childNode, parent,
								parent.getChildCount());
						// Make sure the user can see the lovely new node.
						if (shouldBeVisible) {
							tree.scrollPathToVisible(new TreePath(childNode
									.getPath()));
						}
						// return childNode;
					}
				}
			}
		}

		/*
		 * if (child.getClass() == Examination.class) { Examination ex =
		 * (Examination) child;
		 * 
		 * DefaultMutableTreeNode rootNode = ((DefaultMutableTreeNode) tree
		 * .getModel().getRoot()); int count =
		 * tree.getModel().getChildCount(rootNode); for (int i = 0; i < count;
		 * i++) { if (((tree.getModel().getChild(rootNode, i)).toString())
		 * .equals(t.getDoctor().getSpeciality())) { DefaultMutableTreeNode node
		 * = (DefaultMutableTreeNode) tree .getModel().getChild(rootNode, i);
		 * int count1 = tree.getModel().getChildCount(node);
		 * 
		 * for (int i1 = 0; i1 < count1; i1++) {
		 * 
		 * if (((tree.getModel().getChild(node, i1)).toString())
		 * .equals(t.toString())) { DefaultMutableTreeNode node1 =
		 * (DefaultMutableTreeNode) tree .getModel().getChild(node, i1);
		 * DefaultMutableTreeNode parent = (DefaultMutableTreeNode) tree
		 * .getModel().getChild(node1, 1); parent.add(childNode);
		 * treeModel.insertNodeInto(childNode, parent, parent.getChildCount());
		 * // Make sure the user can see the lovely new node. if
		 * (shouldBeVisible) tree.scrollPathToVisible(new TreePath(childNode
		 * .getPath()));
		 * 
		 * } }
		 * 
		 * } } }
		 */
	}

	public void enableAddVisitOrReferral(boolean b) {
		btnNewButton.setEnabled(b);
		btnNewButton_1.setEnabled(b);

	}

	/*
	 * public void createtree(String id) { Patient p =
	 * patientController.getById(id); tree.removeAll();
	 * 
	 * tree.setModel(new DefaultTreeModel( new
	 * DefaultMutableTreeNode("Specialisties") { {
	 * 
	 * String specialty [] = apctrl.getSpecialties(); for (int
	 * i=1;i<specialty.length;i++) { DefaultMutableTreeNode node_S= new
	 * DefaultMutableTreeNode(specialty[i]); DefaultMutableTreeNode node_1;
	 * Iterator <Treatment> treatment
	 * =p.getMedicalRecord().getTreatments().iterator(); DefaultMutableTreeNode
	 * node_2 = new DefaultMutableTreeNode("Visits"); DefaultMutableTreeNode
	 * node_3 = new DefaultMutableTreeNode("Examinations");
	 * 
	 * while ( treatment.hasNext() ) {
	 * 
	 * Treatment t =treatment.next();
	 * 
	 * if (t.getDoctor().getSpeciality().equals(specialty[i])) {
	 * 
	 * node_1 = new DefaultMutableTreeNode(t); //DefaultMutableTreeNode node_2 =
	 * new DefaultMutableTreeNode("Visits"); Iterator <Visit> visit
	 * =t.getVisits().iterator(); while(visit.hasNext()) { Visit v =
	 * visit.next(); node_2.add(new DefaultMutableTreeNode(v));
	 * 
	 * }
	 * 
	 * //DefaultMutableTreeNode node_3 = new
	 * DefaultMutableTreeNode("Examinations"); Iterator <Examination>
	 * examination =t.getExamination().iterator(); while (examination.hasNext())
	 * { Examination ex =examination.next(); node_3.add(new
	 * DefaultMutableTreeNode(ex)); }
	 * 
	 * node_1.add(node_2); node_1.add(node_3); node_S.add(node_1);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * } add(node_S); }
	 * 
	 * 
	 * } } ));
	 * 
	 * 
	 * }
	 */
}