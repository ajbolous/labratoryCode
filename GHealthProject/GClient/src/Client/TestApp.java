package Client;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ClientUI.*;

public class TestApp {

	public static void main(String[] args) {
		Application.connect();
		//UsersManagingUI iden= new UsersManagingUI();
		AddPatientUI u = new AddPatientUI();
	
		
		
		
		JTextField textField = new JTextField(15);
		JDateChooser chooser = new JDateChooser();
		chooser.setBackground(Color.GRAY);
		chooser.setLocale(Locale.US);
		chooser.setBounds(90,394,252,25);
		chooser.setVisible(true);
		chooser.addPropertyChangeListener("date", new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        JDateChooser chooser = (JDateChooser)evt.getSource();
		        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		        textField.setText(formatter.format(chooser.getDate()));
		    }
		});
		
		addPatient.getContentPane().add(chooser);
		
		
	}
}
