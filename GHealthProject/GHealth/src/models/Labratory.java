package models;

import java.util.ArrayList;

public class Labratory extends Entity {
	private ArrayList <Labratorian> Labrtorians ; 
	private ArrayList <Examination> Examinations;
	private Labratorian labratorian;
	private int lab_id;
	
	public ArrayList<Labratorian> getLabrtorians() {
		return Labrtorians;
	}
	public void setLabrtorians(ArrayList<Labratorian> labrtorians) {
		Labrtorians = labrtorians;
	}
	public ArrayList<Examination> getExaminations() {
		return Examinations;
	}
	public void setExaminations(ArrayList<Examination> examinations) {
		Examinations = examinations;
	}
	public Labratorian getLabratorian() {
		return labratorian;
	}
	public void setLabratorian(Labratorian labratorian) {
		this.labratorian = labratorian;
	}
	public int getLab_id() {
		return lab_id;
	}
	public void setLab_id(int lab_id) {
		this.lab_id = lab_id;
	}
}
