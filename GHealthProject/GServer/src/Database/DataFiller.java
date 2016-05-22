package Database;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Random;
import models.*;

public class DataFiller {

	DbHandler db;
	public static String[] firstNames ={"John", "Tyrion","Arya","Sandor","Euron","Dyneris","Ned","Cersi","Sam","Sansa","Ramsey","Roose","Robert","Walder","Jora"};
	public static String[] lastNames ={"Lanister","Bolton","Stark","Clegane","Targeryan","Greyjoy","Weiss","Drogo","Karstak","Turlly","Mormont","Frey","Slavador","Snow"};
	public static String[] cities = {"King's Landing","Winterfell","Iron Islands","Valyeria", "The Wall", "Castle Black","Deadfall","Mereen","Highgarden","Dorn"};
	public static Random rand = new Random();

	public DataFiller(DbHandler d){
		db = d;
	}
	public void fillDoctors() throws SQLException{
		for(int i =0;i<120;i++){
			Doctor d = new Doctor();
			d.setFirstName(firstNames[rand.nextInt(firstNames.length)]);
			d.setLastName(lastNames[rand.nextInt(lastNames.length)]);
			
			d.setEmail(d.getFirstName()+"."+d.getLastName() + "@crows.com");
			try {
				d.setBirthDate(Utils.DateTime.getDate(1990+rand.nextInt(10), rand.nextInt(12),rand.nextInt(29) ));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			d.setAddress(cities[rand.nextInt(cities.length)]+ ", St. " + i);
			d.setPhone("0" + (548143001 + i));
			d.setPass("123123");
			d.setSid(""+(200000000 + i));
			db.doctors.createIfNotExists(d);
		}
	}
	
	public void fillPatients() throws SQLException{
		for(int i =0;i<120;i++){
			Patient p = new Patient();
			p.setFirstName(firstNames[rand.nextInt(firstNames.length)]);
			p.setLastName(lastNames[rand.nextInt(lastNames.length)]);
			
			p.setEmail(p.getFirstName()+"."+p.getLastName() + "@crows.com");
			try {
				p.setBirthDate(Utils.DateTime.getDate(1990+rand.nextInt()%10, rand.nextInt()%12,rand.nextInt()%29 ));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			p.setAddress(cities[rand.nextInt(cities.length)] + ", St. " + i);
			p.setPhone("0" + (548143001 + i));
			p.setSid(""+(300000000 + i));
			db.patients.createIfNotExists(p);
		}
	}
	
	public void fillClinics() throws SQLException{
		for(int i =0;i<20;i++){
			Clinic c = new Clinic();
			c.setAddress(cities[rand.nextInt(cities.length)]);
			c.setPhone("04-" + (5143001 + i));
			c.setName("GHealth " + c.getAddress());
			c.setEmail(c.getName().replace(" ","_").toLowerCase() + i +"@crows.com");
			
			db.clinics.create(c);
		}
	}
	
	public void fillAppointments() throws SQLException, ParseException{
		
		for(int i =0;i<8;i++){
		Doctor d = db.doctors.queryForId("20000000" + i);
		Patient p = db.patients.queryForId("30000000" + i);
	
		Appointment a = new Appointment(d,p,Utils.DateTime.getDate(2016, 10, 5+i,11,10));

		db.appointments.createIfNotExists(a);
		}
	
	}
}
