package Controllers;

import java.util.ArrayList;
import java.util.Date;

import Client.Application;
import Utils.Request;
import models.Statistic;



public class ReportsController {
	
	
	public ArrayList<Statistic> getReport(Date date)// return array of 7 statistics by the date of the first day of the week
	{
		Request r = new Request("statistics/byDate");
		r.addParam("date", date);
		return (ArrayList<Statistic>) Application.client.sendRequest(r);
	}
	
	

}
