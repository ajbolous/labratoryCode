package models;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import com.j256.ormlite.field.DatabaseField;

public class Report implements Serializable {
	private int pMax=0;
	private int pMin=Integer.MAX_VALUE;
	private double pAvg=0;
	private double pStd=0;
	private int wMax=0;
	private int wMin=Integer.MAX_VALUE;
	private double wAvg=0;
	private double wStd=0;
	
	public int getpMax() {
		return pMax;
	}

	public void setpMax(int pMax) {
		this.pMax = pMax;
	}

	public int getpMin() {
		return pMin;
	}

	public void setpMin(int pMin) {
		this.pMin = pMin;
	}

	public double getpAvg() {
		return pAvg;
	}

	public void setpAvg(double pAvg) {
		this.pAvg = pAvg;
	}

	public double getpStd() {
		return pStd;
	}

	public void setpStd(double pStd) {
		this.pStd = pStd;
	}

	public int getwMax() {
		return wMax;
	}

	public void setwMax(int wMax) {
		this.wMax = wMax;
	}

	public int getwMin() {
		return wMin;
	}

	public void setwMin(int wMin) {
		this.wMin = wMin;
	}

	public double getwAvg() {
		return wAvg;
	}

	public void setwAvg(double wAvg) {
		this.wAvg = wAvg;
	}

	public double getwStd() {
		return wStd;
	}

	public void setwStd(double wStd) {
		this.wStd = wStd;
	}

	public ArrayList<Statistic> getStatistic() {
		return statistic;
	}

	public void setStatistic(ArrayList<Statistic> statistic) {
		this.statistic = statistic;
	}

	private ArrayList<Statistic> statistic;
    

}
